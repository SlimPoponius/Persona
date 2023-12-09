package net.slimpopo.personamod.entity.custom.group;

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
import net.slimpopo.personamod.entity.custom.single.NukeThrowable;
import net.slimpopo.personamod.item.ModItems;
import net.slimpopo.personamod.item.constants.Spell;

public class MaPsiThrowable extends ThrowableItemProjectile {

    private Spell spellInformation;

    public MaPsiThrowable(EntityType<? extends ThrowableItemProjectile> entityType, Level pLevel){
        super(entityType,pLevel);
    }

    public MaPsiThrowable(Level pLevel){
        super(ModEntities.GRP_PSI_THROWABLE.get(),pLevel);
    }

    public MaPsiThrowable(Level pLevel, LivingEntity livingEntity){
        super(ModEntities.GRP_PSI_THROWABLE.get(), livingEntity, pLevel);
    }

    public MaPsiThrowable(Level pLevel, Spell spellData) {
        super(ModEntities.GRP_PSI_THROWABLE.get(), pLevel);
    }

    public MaPsiThrowable(Level pLevel, LivingEntity livingEntity, Spell spellInformation) {
        super(ModEntities.GRP_PSI_THROWABLE.get(), livingEntity,pLevel);
        this.spellInformation = spellInformation;
    }

    @Override
    protected void onHitBlock(BlockHitResult pResult) {
        Level pLevel = this.level();

        if(!pLevel.isClientSide){
            this.level().broadcastEntityEvent(this, (byte)3);
            SkillThrowable projectile = new SkillThrowable();
            projectile.getBlockAreaForMaSpells(pResult.getBlockPos(),pLevel,spellInformation,
                    true,false);
        }

        this.discard();
        super.onHitBlock(pResult);
    }

    @Override
    protected void onHitEntity(EntityHitResult pResult) {
        if (!this.level().isClientSide) {
            this.level().broadcastEntityEvent(this, (byte)3);

            SkillThrowable projectile = new SkillThrowable();
            projectile.getBlockAreaForMaSpells(pResult.getEntity().blockPosition(),this.level(),spellInformation,
                    false,false);

        }

        this.discard();
        super.onHitEntity(pResult);
    }

    private boolean hasStatusesToNuke(LivingEntity entity) {
        return entity.hasEffect(ModEffects.BURN.get()) ||
                entity.hasEffect(ModEffects.FREEZE.get()) ||
                entity.hasEffect(ModEffects.SHOCK.get());
    }


    public void throwInArea(NukeThrowable throwable, Level pLevel, Spell spell,
                            LivingEntity entity, float angle){
        this.shootFromRotation(entity, entity.getXRot(), angle,
                0.0F, 1.5F, 1.0F);
        level().addFreshEntity(throwable);
    }


    @Override
    protected Item getDefaultItem() {
        return ModItems.PSITHROWABLE.get();
    }
}
