package net.slimpopo.personamod.entity.custom.single;

import net.minecraft.client.Minecraft;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.slimpopo.personamod.effects.ModEffects;
import net.slimpopo.personamod.entity.ModEntities;
import net.slimpopo.personamod.entity.custom.SkillThrowable;
import net.slimpopo.personamod.item.ModItems;
import net.slimpopo.personamod.item.constants.Spell;

import java.util.Random;

public class FlameThrowable extends ThrowableItemProjectile {

    private Spell spellInformation;

    public FlameThrowable(EntityType<? extends ThrowableItemProjectile> entityType,Level pLevel){
        super(entityType,pLevel);
    }

    public FlameThrowable(Level pLevel){
        super(ModEntities.FLAME_THROWABLE.get(),pLevel);
    }

    public FlameThrowable( Level pLevel, LivingEntity livingEntity){
        super(ModEntities.FLAME_THROWABLE.get(), livingEntity, pLevel);
    }

    public FlameThrowable(Level pLevel, Spell spellData) {
        super(ModEntities.FLAME_THROWABLE.get(), pLevel);
    }

    public FlameThrowable(Level pLevel, LivingEntity livingEntity, Spell spellInformation) {
        super(ModEntities.FLAME_THROWABLE.get(), livingEntity,pLevel);
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
            if (!entity.fireImmune()) {
                Entity entity1 = this.getOwner();
                boolean flag = entity.hurt(this.damageSources().playerAttack(Minecraft.getInstance().player), 5.0F);
                if (entity1 instanceof LivingEntity) {
                    Random random = new Random();
                    if(random.nextFloat() > 0.85f) {
                        ((LivingEntity) entity).addEffect(
                                new MobEffectInstance(ModEffects.BURN.get(),
                                        60 * spellInformation.getSPELL_LEVEL().getLevel(), 1));
                    }
                    this.doEnchantDamageEffects((LivingEntity)entity1, entity);
                }
            }

        }

        this.discard();
        super.onHitEntity(pResult);
    }



    @Override
    protected Item getDefaultItem() {
        return ModItems.FLAMETHROWABLE.get();
    }
}
