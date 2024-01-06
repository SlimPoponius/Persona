package net.slimpopo.personamod.entity.custom.single;

import net.minecraft.client.Minecraft;
import net.minecraft.world.entity.Entity;
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
import net.slimpopo.personamod.entity.custom.projectile.PersonaThrowableItemProjectile;
import net.slimpopo.personamod.item.ModItems;

import java.util.Random;

public class BlessHamaThrowable extends PersonaThrowableItemProjectile {

    private Spell spellInformation;

    public BlessHamaThrowable(EntityType<? extends ThrowableItemProjectile> entityType, Level pLevel){
        super(entityType,pLevel,null);
    }

    public BlessHamaThrowable(Level pLevel){
        super(ModEntities.BLESS_HAMA_THROWABLE.get(),pLevel,null);
    }

    public BlessHamaThrowable(Level pLevel, LivingEntity livingEntity){
        super(ModEntities.BLESS_HAMA_THROWABLE.get(), livingEntity, pLevel, null);
    }

    public BlessHamaThrowable(Level pLevel, Spell spellData) {
        super(ModEntities.BLESS_HAMA_THROWABLE.get(), pLevel, spellData);
    }

    public BlessHamaThrowable(Level pLevel, LivingEntity livingEntity, Spell spellInformation) {
        super(ModEntities.BLESS_HAMA_THROWABLE.get(), livingEntity,pLevel, spellInformation);
        this.spellInformation = spellInformation;
    }

    @Override
    protected void onHitEntity(EntityHitResult pResult) {
        super.onHitEntity(pResult);

        if (!this.level().isClientSide) {
            this.level().broadcastEntityEvent(this, (byte)3);
            Entity entity = pResult.getEntity();
            if (!entity.fireImmune()) {
                Entity entity1 = this.getOwner();
                if (entity1 instanceof LivingEntity) {
                    Random random = new Random();
                    if(random.nextFloat() > 0.90f) {
                        ((LivingEntity) entity).die(this.damageSources().magic());
                    }
                    this.doEnchantDamageEffects((LivingEntity)entity1, entity);
                }
            }

        }

        this.discard();
    }



    @Override
    protected Item getDefaultItem() {
        return ModItems.BLESSTHROWABLE.get();
    }
}
