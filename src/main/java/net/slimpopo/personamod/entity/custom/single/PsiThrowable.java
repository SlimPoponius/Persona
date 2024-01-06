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
import net.slimpopo.personamod.entity.custom.projectile.PersonaThrowableItemProjectile;
import net.slimpopo.personamod.item.ModItems;
import net.slimpopo.personamod.constant.spell.Spell;

public class PsiThrowable extends PersonaThrowableItemProjectile {

    private Spell spellInformation;

    public PsiThrowable(EntityType<? extends ThrowableItemProjectile> entityType, Level pLevel){
        super(entityType,pLevel,null);
    }

    public PsiThrowable(Level pLevel){
        super(ModEntities.PSI_THROWABLE.get(),pLevel,null);
    }

    public PsiThrowable(Level pLevel, LivingEntity livingEntity){
        super(ModEntities.PSI_THROWABLE.get(), livingEntity, pLevel,null);
    }

    public PsiThrowable(Level pLevel, Spell spellData) {
        super(ModEntities.PSI_THROWABLE.get(), pLevel,spellData);
    }

    public PsiThrowable(Level pLevel, LivingEntity livingEntity, Spell spellInformation) {
        super(ModEntities.PSI_THROWABLE.get(), livingEntity,pLevel,spellInformation);
        this.spellInformation = spellInformation;
    }

    @Override
    protected void onHitEntity(EntityHitResult pResult) {
        super.onHitEntity(pResult);

        if (!this.level().isClientSide) {
            this.level().broadcastEntityEvent(this, (byte)3);

            Entity entity = pResult.getEntity();
            Entity entity1 = this.getOwner();

            if (entity1 instanceof LivingEntity) {
                this.doEnchantDamageEffects((LivingEntity)entity1, entity);
            }

        }

        this.discard();
    }


    @Override
    protected Item getDefaultItem() {
        return ModItems.PSITHROWABLE.get();
    }
}
