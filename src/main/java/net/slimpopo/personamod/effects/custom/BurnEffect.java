package net.slimpopo.personamod.effects.custom;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;

import java.util.Random;

public class BurnEffect extends MobEffect {

    public BurnEffect(MobEffectCategory pCategory, int pColor) {
        super(pCategory, pColor);
    }

    @Override
    public void applyEffectTick(LivingEntity pLivingEntity, int pAmplifier) {
        Random random = new Random();

        if(!pLivingEntity.level().isClientSide() ) {
            pLivingEntity.hurt(pLivingEntity.damageSources().magic(),
                    (float)Math.floor(pLivingEntity.getHealth() * 0.1f));
        }

        super.applyEffectTick(pLivingEntity, pAmplifier);
    }

    @Override
    public boolean isDurationEffectTick(int pDuration, int pAmplifier) {
        return true;
    }
}
