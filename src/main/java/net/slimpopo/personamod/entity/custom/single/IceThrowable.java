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
import net.slimpopo.personamod.item.ModItems;
import net.slimpopo.personamod.constant.spell.Spell;

import java.util.Random;

public class IceThrowable extends ThrowableItemProjectile {

    private Spell spellInformation;

    public IceThrowable(EntityType<? extends ThrowableItemProjectile> entityType, Level pLevel){
        super(entityType,pLevel);
    }

    public IceThrowable(Level pLevel){
        super(ModEntities.ICE_THROWABLE.get(),pLevel);
    }

    public IceThrowable(Level pLevel, LivingEntity livingEntity){
        super(ModEntities.ICE_THROWABLE.get(), livingEntity, pLevel);
    }

    public IceThrowable(Level pLevel, Spell spellData) {
        super(ModEntities.ICE_THROWABLE.get(), pLevel);
    }

    public IceThrowable(Level pLevel, LivingEntity livingEntity, Spell spellInformation) {
        super(ModEntities.ICE_THROWABLE.get(), livingEntity,pLevel);
        this.spellInformation = spellInformation;
    }

    @Override
    protected void onHitBlock(BlockHitResult pResult) {
        Level pLevel = this.level();

        if(!pLevel.isClientSide){
            this.level().broadcastEntityEvent(this, (byte)3);
            SkillThrowable projectile = new SkillThrowable();
            projectile.getBlockArea(pResult.getBlockPos(),pLevel,spellInformation);
        }

        this.discard();
        super.onHitBlock(pResult);
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
                Random random = new Random();
                if(random.nextFloat() > 0.85f){
                    if(entity instanceof LivingEntity) {
                        ((LivingEntity) entity).addEffect(
                                new MobEffectInstance(ModEffects.FREEZE.get(),
                                        60 * spellInformation.getSPELL_LEVEL().getLevel(), 1));
                        ((LivingEntity) entity).addEffect(
                                new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN,
                                        60 * spellInformation.getSPELL_LEVEL().getLevel(), 2000));
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
        return ModItems.ICETHROWABLE.get();
    }
}
