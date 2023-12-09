package net.slimpopo.personamod.effects.custom;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.entity.ai.goal.AvoidEntityGoal;
import net.minecraft.world.entity.player.Player;

import java.util.Random;

public class FearEffect extends MobEffect {
    public FearEffect(MobEffectCategory pCategory, int pColor) {
        super(pCategory, pColor);
    }

    @Override
    public void applyEffectTick(LivingEntity pLivingEntity, int pAmplifier) {
        Random random = new Random();
        if(!pLivingEntity.level().isClientSide){
            if(pLivingEntity instanceof Mob mob){
                mob.goalSelector.addGoal(1, new AvoidEntityGoal<>((PathfinderMob) mob, Player.class,
                        6.0F,1.0D, 1.2D));
            }

            //
            if(random.nextFloat() > 0.75f) {
                if (pLivingEntity instanceof Mob mob) {
                    mob.setNoAi(true);
                }

                Double x = pLivingEntity.getX();
                Double y = pLivingEntity.getY();
                Double z = pLivingEntity.getZ();

                pLivingEntity.teleportTo(x, y, z);
                pLivingEntity.setDeltaMovement(0, 0, 0);
            }
        }

        super.applyEffectTick(pLivingEntity, pAmplifier);
    }



    @Override
    public boolean isDurationEffectTick(int pDuration, int pAmplifier) {
        return true;
    }
}
