package net.slimpopo.personamod.effects.custom;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;

public class RageEffect extends MobEffect {
    public RageEffect(MobEffectCategory pCategory, int pColor) {
        super(pCategory, pColor);
    }

    @Override
    public void applyEffectTick(LivingEntity pLivingEntity, int pAmplifier) {
        if(!pLivingEntity.level().isClientSide){
            //Doubles attack and halves defense
            pLivingEntity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST,60,1));
            pLivingEntity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE,60,-1));
        }

        super.applyEffectTick(pLivingEntity, pAmplifier);
    }

    @Override
    public boolean isDurationEffectTick(int pDuration, int pAmplifier) {
        return true;
    }
}
