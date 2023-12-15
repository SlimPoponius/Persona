package net.slimpopo.personamod.entity.custom.group;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.slimpopo.personamod.constant.spell.Spell;
import net.slimpopo.personamod.entity.ModEntities;
import net.slimpopo.personamod.entity.custom.SkillThrowable;
import net.slimpopo.personamod.item.ModItems;

public class MaCurseMudoThrowable extends ThrowableItemProjectile {

    private Spell spellInformation;
    private float chanceIncrease;
    public MaCurseMudoThrowable(EntityType<? extends ThrowableItemProjectile> entityType, Level pLevel){
        super(entityType,pLevel);
    }

    public MaCurseMudoThrowable(Level pLevel){
        super(ModEntities.GRP_CURSE_MUDO_THROWABLE.get(),pLevel);
    }

    public MaCurseMudoThrowable(Level pLevel, LivingEntity livingEntity){
        super(ModEntities.GRP_CURSE_MUDO_THROWABLE.get(), livingEntity, pLevel);
    }

    public MaCurseMudoThrowable(Level pLevel, Spell spellData) {
        super(ModEntities.GRP_CURSE_MUDO_THROWABLE.get(), pLevel);
    }

    public MaCurseMudoThrowable(Level pLevel, LivingEntity livingEntity, Spell spellInformation, float chanceIncrease) {
        super(ModEntities.GRP_CURSE_MUDO_THROWABLE.get(), livingEntity,pLevel);
        this.spellInformation = spellInformation;
        this.chanceIncrease = chanceIncrease;
    }

    @Override
    protected void onHitBlock(BlockHitResult pResult) {
        Level pLevel = this.level();

        if(!pLevel.isClientSide){
            this.level().broadcastEntityEvent(this, (byte)3);
            SkillThrowable projectile = new SkillThrowable();
            projectile.getBlockAreaForMudoSpells(pResult.getBlockPos(),pLevel,spellInformation,
                    true,chanceIncrease);
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
            projectile.getBlockAreaForMudoSpells(pResult.getEntity().blockPosition(),pLevel,spellInformation,
                    false,chanceIncrease);
        }

        this.discard();
        super.onHitEntity(pResult);
    }

    @Override
    protected Item getDefaultItem() {
        return ModItems.MACURSETHROWABLE.get();
    }
}
