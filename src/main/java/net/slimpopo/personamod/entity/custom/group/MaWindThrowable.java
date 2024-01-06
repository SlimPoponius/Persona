package net.slimpopo.personamod.entity.custom.group;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.slimpopo.personamod.entity.ModEntities;
import net.slimpopo.personamod.entity.custom.SkillThrowable;
import net.slimpopo.personamod.entity.custom.projectile.PersonaThrowableItemProjectile;
import net.slimpopo.personamod.item.ModItems;
import net.slimpopo.personamod.constant.spell.Spell;

public class MaWindThrowable extends PersonaThrowableItemProjectile {

    private Spell spellInformation;

    public MaWindThrowable(EntityType<? extends ThrowableItemProjectile> entityType, Level pLevel){
        super(entityType,pLevel,null);
    }

    public MaWindThrowable(Level pLevel){
        super(ModEntities.GRP_WIND_THROWABLE.get(),pLevel,null);
    }

    public MaWindThrowable(Level pLevel, LivingEntity livingEntity){
        super(ModEntities.GRP_WIND_THROWABLE.get(), livingEntity, pLevel,null);
    }

    public MaWindThrowable(Level pLevel, Spell spellData) {
        super(ModEntities.GRP_WIND_THROWABLE.get(), pLevel,spellData);
    }

    public MaWindThrowable(Level pLevel, LivingEntity livingEntity, Spell spellInformation) {
        super(ModEntities.GRP_WIND_THROWABLE.get(), livingEntity,pLevel,spellInformation);
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
                    true,false);
        }

        this.discard();
        super.onHitEntity(pResult);
    }

    @Override
    protected Item getDefaultItem() {
        return ModItems.ICETHROWABLE.get();
    }
}
