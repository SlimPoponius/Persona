package net.slimpopo.personamod.entity.custom.group;

import net.minecraft.client.Minecraft;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.slimpopo.personamod.entity.ModEntities;
import net.slimpopo.personamod.entity.custom.SkillThrowable;
import net.slimpopo.personamod.item.ModItems;
import net.slimpopo.personamod.item.constants.Spell;

public class MaFlameThrowable extends ThrowableItemProjectile {

    private Spell spellInformation;

    public MaFlameThrowable(EntityType<? extends ThrowableItemProjectile> entityType, Level pLevel){
        super(entityType,pLevel);
    }

    public MaFlameThrowable(Level pLevel){
        super(ModEntities.GRP_FLAME_THROWABLE.get(),pLevel);
    }

    public MaFlameThrowable(Level pLevel, LivingEntity livingEntity){
        super(ModEntities.GRP_FLAME_THROWABLE.get(), livingEntity, pLevel);
    }

    public MaFlameThrowable(Level pLevel, Spell spellData) {
        super(ModEntities.GRP_FLAME_THROWABLE.get(), pLevel);
    }

    public MaFlameThrowable(Level pLevel, LivingEntity livingEntity, Spell spellInformation) {
        super(ModEntities.GRP_FLAME_THROWABLE.get(), livingEntity,pLevel);
        this.spellInformation = spellInformation;
    }

    @Override
    protected void onHitBlock(BlockHitResult pResult) {
        Level pLevel = this.level();

        if(!pLevel.isClientSide){
            this.level().broadcastEntityEvent(this, (byte)3);
            SkillThrowable projectile = new SkillThrowable();
            projectile.getBlockAreaForMaSpells(pResult.getBlockPos(),pLevel,spellInformation,
                    true,true);
        }

        this.discard();
        super.onHitBlock(pResult);
    }

    @Override
    protected void onHitEntity(EntityHitResult pResult) {
        Level pLevel = this.level();

        if(!pLevel.isClientSide){
            this.level().broadcastEntityEvent(this, (byte)3);
            SkillThrowable projectile = new SkillThrowable();
            projectile.getBlockAreaForMaSpells(pResult.getEntity().blockPosition(),pLevel,spellInformation,
                    false,true);
        }

        this.discard();
        super.onHitEntity(pResult);
    }

    @Override
    protected Item getDefaultItem() {
        return ModItems.FLAMETHROWABLE.get();
    }
}
