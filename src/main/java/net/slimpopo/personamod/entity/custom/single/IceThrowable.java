package net.slimpopo.personamod.entity.custom.single;

import net.minecraft.client.Minecraft;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.slimpopo.personamod.effects.ModEffects;
import net.slimpopo.personamod.entity.ModEntities;
import net.slimpopo.personamod.entity.custom.SkillThrowable;
import net.slimpopo.personamod.entity.custom.projectile.PersonaThrowableItemProjectile;
import net.slimpopo.personamod.item.ModItems;
import net.slimpopo.personamod.constant.spell.Spell;

import java.util.Random;

public class IceThrowable extends PersonaThrowableItemProjectile {

    private Spell spellInformation;

    public IceThrowable(EntityType<? extends ThrowableItemProjectile> entityType, Level pLevel){
        super(entityType,pLevel,null);
    }

    public IceThrowable(Level pLevel){
        super(ModEntities.ICE_THROWABLE.get(),pLevel,null);
    }

    public IceThrowable(Level pLevel, LivingEntity livingEntity){
        super(ModEntities.ICE_THROWABLE.get(), livingEntity, pLevel,null);
    }

    public IceThrowable(Level pLevel, Spell spellData) {
        super(ModEntities.ICE_THROWABLE.get(), pLevel,spellData);
    }

    public IceThrowable(Level pLevel, LivingEntity livingEntity, Spell spellInformation) {
        super(ModEntities.ICE_THROWABLE.get(), livingEntity,pLevel,spellInformation);
        this.spellInformation = spellInformation;
    }

    @Override
    protected void onHitEntity(EntityHitResult pResult) {
        super.onHitEntity(pResult);

        if (!this.level().isClientSide) {
            this.level().broadcastEntityEvent(this, (byte)3);

            Entity entity = pResult.getEntity();
            Entity entity1 = this.getOwner();
            int i = entity.getRemainingFireTicks();

            int level = null != spellInformation ? spellInformation.getSPELL_LEVEL().getLevel(): 0;

            if (entity1 instanceof LivingEntity) {
                Random random = new Random();
                if(random.nextFloat() > 0.85f){
                    if(entity instanceof LivingEntity) {
                        ((LivingEntity) entity).addEffect(
                                new MobEffectInstance(ModEffects.FREEZE.get(),
                                        60 * level, 1));
                        ((LivingEntity) entity).addEffect(
                                new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN,
                                        60 * level, 2000));
                    }
                }

                this.doEnchantDamageEffects((LivingEntity)entity1, entity);
            }

        }

        this.discard();
    }



    @Override
    protected Item getDefaultItem() {
        return ModItems.ICETHROWABLE.get();
    }
}
