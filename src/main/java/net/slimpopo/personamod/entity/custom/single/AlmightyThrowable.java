package net.slimpopo.personamod.entity.custom.single;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.slimpopo.personamod.constant.spell.Spell;
import net.slimpopo.personamod.effects.ModEffects;
import net.slimpopo.personamod.entity.ModEntities;
import net.slimpopo.personamod.entity.custom.projectile.PersonaThrowableItemProjectile;
import net.slimpopo.personamod.item.ModItems;

import java.util.Random;

public class AlmightyThrowable extends PersonaThrowableItemProjectile {

    private Spell spellInformation;

    public AlmightyThrowable(EntityType<? extends ThrowableItemProjectile> entityType, Level pLevel){
        super(entityType,pLevel,null);
    }

    public AlmightyThrowable(Level pLevel){
        super(ModEntities.ALMIGHTY_THROWABLE.get(),pLevel,null);
    }

    public AlmightyThrowable(Level pLevel, LivingEntity livingEntity){
        super(ModEntities.ALMIGHTY_THROWABLE.get(), livingEntity, pLevel,null);
    }

    public AlmightyThrowable(Level pLevel, Spell spellData) {
        super(ModEntities.ALMIGHTY_THROWABLE.get(), pLevel,spellData);
    }

    public AlmightyThrowable(Level pLevel, LivingEntity livingEntity, Spell spellInformation) {
        super(ModEntities.ALMIGHTY_THROWABLE.get(), livingEntity,pLevel, spellInformation);
        this.spellInformation = spellInformation;
    }


    @Override
    protected void onHitEntity(EntityHitResult pResult) {
        super.onHitEntity(pResult);
        this.discard();
    }

    @Override
    protected Item getDefaultItem() {
        return ModItems.ALMIGHTYTHROWABLE.get();
    }
}
