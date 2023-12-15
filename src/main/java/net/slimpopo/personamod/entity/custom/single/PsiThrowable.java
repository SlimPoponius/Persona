package net.slimpopo.personamod.entity.custom.single;

import net.minecraft.client.Minecraft;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.slimpopo.personamod.effects.ModEffects;
import net.slimpopo.personamod.entity.ModEntities;
import net.slimpopo.personamod.item.ModItems;
import net.slimpopo.personamod.constant.spell.Spell;

public class PsiThrowable extends ThrowableItemProjectile {

    private Spell spellInformation;

    public PsiThrowable(EntityType<? extends ThrowableItemProjectile> entityType, Level pLevel){
        super(entityType,pLevel);
    }

    public PsiThrowable(Level pLevel){
        super(ModEntities.PSI_THROWABLE.get(),pLevel);
    }

    public PsiThrowable(Level pLevel, LivingEntity livingEntity){
        super(ModEntities.PSI_THROWABLE.get(), livingEntity, pLevel);
    }

    public PsiThrowable(Level pLevel, Spell spellData) {
        super(ModEntities.PSI_THROWABLE.get(), pLevel);
    }

    public PsiThrowable(Level pLevel, LivingEntity livingEntity, Spell spellInformation) {
        super(ModEntities.PSI_THROWABLE.get(), livingEntity,pLevel);
        this.spellInformation = spellInformation;
    }

    @Override
    protected void onHitEntity(EntityHitResult pResult) {
        if (!this.level().isClientSide) {
            this.level().broadcastEntityEvent(this, (byte)3);

            Entity entity = pResult.getEntity();
            Entity entity1 = this.getOwner();
            int i = entity.getRemainingFireTicks();
            int multiplier = 1;
            if(entity instanceof LivingEntity){
                if(hasStatusesToNuke((LivingEntity) entity)){
                    multiplier = 2;
                }
            }

            entity.hurt(this.damageSources().playerAttack(Minecraft.getInstance().player),
                    5.0F * multiplier);
            if (entity1 instanceof LivingEntity) {
                this.doEnchantDamageEffects((LivingEntity)entity1, entity);
            }

        }

        this.discard();
        super.onHitEntity(pResult);
    }

    private boolean hasStatusesToNuke(LivingEntity entity) {
        return entity.hasEffect(ModEffects.BURN.get()) ||
                entity.hasEffect(ModEffects.FREEZE.get()) ||
                entity.hasEffect(ModEffects.SHOCK.get());
    }


    @Override
    protected Item getDefaultItem() {
        return ModItems.PSITHROWABLE.get();
    }
}
