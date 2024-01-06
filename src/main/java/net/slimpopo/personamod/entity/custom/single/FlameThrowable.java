package net.slimpopo.personamod.entity.custom.single;

import net.minecraft.client.Minecraft;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.slimpopo.personamod.damagesource.ModDamageSources;
import net.slimpopo.personamod.damagesource.ModDamageTypes;
import net.slimpopo.personamod.effects.ModEffects;
import net.slimpopo.personamod.entity.ModEntities;
import net.slimpopo.personamod.entity.custom.SkillThrowable;
import net.slimpopo.personamod.entity.custom.projectile.PersonaThrowableItemProjectile;
import net.slimpopo.personamod.item.ModItems;
import net.slimpopo.personamod.constant.spell.Spell;
import net.slimpopo.personamod.item.constants.card.PersonaCardItem;
import net.slimpopo.personamod.item.constants.card.SkillCardItem;
import net.slimpopo.personamod.item.constants.card.StatCardItem;

import java.util.Random;

public class FlameThrowable extends PersonaThrowableItemProjectile {

    private Spell spellInformation;

    public FlameThrowable(EntityType<? extends ThrowableItemProjectile> entityType,Level pLevel){
        super(entityType,pLevel,null);
    }

    public FlameThrowable(Level pLevel){
        super(ModEntities.FLAME_THROWABLE.get(),pLevel,null);
    }

    public FlameThrowable( Level pLevel, LivingEntity livingEntity){
        super(ModEntities.FLAME_THROWABLE.get(), livingEntity, pLevel,null);
    }

    public FlameThrowable(Level pLevel, Spell spellData) {
        super(ModEntities.FLAME_THROWABLE.get(), pLevel,spellData);
    }

    public FlameThrowable(Level pLevel, LivingEntity livingEntity, Spell spellInformation) {
        super(ModEntities.FLAME_THROWABLE.get(), livingEntity,pLevel, spellInformation);
        this.spellInformation = spellInformation;
    }


    @Override
    protected void onHitEntity(EntityHitResult pResult) {
        super.onHitEntity(pResult);

        if (!this.level().isClientSide) {
            this.level().broadcastEntityEvent(this, (byte)3);


            int level = null != spellInformation ? spellInformation.getSPELL_LEVEL().getLevel(): 0;

            Entity entity = pResult.getEntity();
            if (!entity.fireImmune()) {
                Entity entity1 = this.getOwner();

                if (entity1 instanceof LivingEntity) {
                    Random random = new Random();
                    if(random.nextFloat() > 0.85f) {
                        ((LivingEntity) entity).addEffect(
                                new MobEffectInstance(ModEffects.BURN.get(),
                                        60 * level, 1));
                    }
                    this.doEnchantDamageEffects((LivingEntity)entity1, entity);
                }
            }

        }

        this.discard();
    }

    @Override
    protected Item getDefaultItem() {
        return ModItems.FLAMETHROWABLE.get();
    }
}
