package net.slimpopo.personamod.entity.custom.single;

import net.minecraft.client.Minecraft;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.slimpopo.personamod.effects.ModEffects;
import net.slimpopo.personamod.entity.ModEntities;
import net.slimpopo.personamod.item.ModItems;
import net.slimpopo.personamod.constant.spell.Spell;

import java.util.Random;

public class ElectricThrowable extends ThrowableItemProjectile {

    private Spell spellInformation;

    public ElectricThrowable(EntityType<? extends ThrowableItemProjectile> entityType, Level pLevel){
        super(entityType,pLevel);
    }

    public ElectricThrowable(Level pLevel){
        super(ModEntities.ELECTRIC_THROWABLE.get(),pLevel);
    }

    public ElectricThrowable(Level pLevel, LivingEntity livingEntity){
        super(ModEntities.ELECTRIC_THROWABLE.get(), livingEntity, pLevel);
    }

    public ElectricThrowable(Level pLevel, Spell spellData) {
        super(ModEntities.ELECTRIC_THROWABLE.get(), pLevel);
    }

    public ElectricThrowable(Level pLevel, LivingEntity livingEntity, Spell spellInformation) {
        super(ModEntities.ELECTRIC_THROWABLE.get(), livingEntity,pLevel);
        this.spellInformation = spellInformation;
    }

    @Override
    protected void onHitEntity(EntityHitResult pResult) {
        if (!this.level().isClientSide) {
            this.level().broadcastEntityEvent(this, (byte)3);

            Entity entity = pResult.getEntity();
            Entity entity1 = this.getOwner();
            int i = entity.getRemainingFireTicks();

            boolean flag = entity.hurt(this.damageSources().playerAttack(Minecraft.getInstance().player), 5.0F);
            if (entity1 instanceof LivingEntity) {
                ServerLevel serverLevel = (ServerLevel) entity1.level();
                Random random = new Random();

                if(random.nextFloat() > 0.75f) {
                    EntityType.LIGHTNING_BOLT.spawn(serverLevel, entity.blockPosition(),
                            MobSpawnType.TRIGGERED);
                }

                if(random.nextFloat() > 0.85f){
                    if(entity instanceof LivingEntity) {
                        ((LivingEntity) entity).addEffect(
                                new MobEffectInstance(ModEffects.SHOCK.get(),
                                        60 * spellInformation.getSPELL_LEVEL().getLevel(), 1));
                    }
                }

                this.doEnchantDamageEffects((LivingEntity)entity1, entity);
            }

        }

        this.discard();
        super.onHitEntity(pResult);
    }



    @Override
    protected Item getDefaultItem() {
        return ModItems.ELECTRICTHROWABLE.get();
    }
}
