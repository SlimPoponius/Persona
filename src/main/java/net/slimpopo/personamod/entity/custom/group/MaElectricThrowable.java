package net.slimpopo.personamod.entity.custom.group;

import net.minecraft.client.Minecraft;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.slimpopo.personamod.entity.ModEntities;
import net.slimpopo.personamod.entity.custom.SkillThrowable;
import net.slimpopo.personamod.item.ModItems;
import net.slimpopo.personamod.item.constants.Spell;

public class MaElectricThrowable extends ThrowableItemProjectile {

    private Spell spellInformation;

    public MaElectricThrowable(EntityType<? extends ThrowableItemProjectile> entityType, Level pLevel){
        super(entityType,pLevel);
    }

    public MaElectricThrowable(Level pLevel){
        super(ModEntities.GRP_ELECTRIC_THROWABLE.get(),pLevel);
    }

    public MaElectricThrowable(Level pLevel, LivingEntity livingEntity){
        super(ModEntities.GRP_ELECTRIC_THROWABLE.get(), livingEntity, pLevel);
    }

    public MaElectricThrowable(Level pLevel, Spell spellData) {
        super(ModEntities.GRP_ELECTRIC_THROWABLE.get(), pLevel);
    }

    public MaElectricThrowable(Level pLevel, LivingEntity livingEntity, Spell spellInformation) {
        super(ModEntities.GRP_ELECTRIC_THROWABLE.get(), livingEntity,pLevel);
        this.spellInformation = spellInformation;
    }

    @Override
    protected void onHitBlock(BlockHitResult pResult) {
        Level pLevel = this.level();

        if(!pLevel.isClientSide){
            this.level().broadcastEntityEvent(this, (byte)3);
            SkillThrowable projectile = new SkillThrowable();
            projectile.getBlockAreaForMaSpells(pResult.getBlockPos(),this.level(),spellInformation,
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

    @Override
    protected Item getDefaultItem() {
        return ModItems.ELECTRICTHROWABLE.get();
    }
}
