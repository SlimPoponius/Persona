package net.slimpopo.personamod.entity.ai;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.level.block.Blocks;
import net.slimpopo.personamod.effects.ModEffects;
//import net.slimpopo.personamod.entity.custom.constants.PersonaEntity;
import net.slimpopo.personamod.entity.custom.personas.PyroJackEntity;
import net.slimpopo.personamod.entity.custom.single.FlameThrowable;
import net.slimpopo.personamod.constant.damage.Affinity;
import net.slimpopo.personamod.constant.damage.DamageType;
import net.slimpopo.personamod.constant.spell.Spell;
import net.slimpopo.personamod.constant.spell.SpellLevel;
import net.slimpopo.personamod.item.constants.SpellList;

public class PyroJackRangedAttackGoal extends MeleeAttackGoal {
    private final PyroJackEntity entity;
    private int attackDelay = 10;
    private int ticksUntilNextAttack = 20;
    private boolean shouldCountTillNextAttack = false;

    private static final Spell AGI = SpellList.getSpellDataWithName("agi");

    public PyroJackRangedAttackGoal(PathfinderMob pMob, double pSpeedModifier, boolean pFollowingTargetEvenIfNotSeen) {
        super(pMob, pSpeedModifier, pFollowingTargetEvenIfNotSeen);
        entity = ((PyroJackEntity) pMob);
    }


    @Override
    public void tick() {
        super.tick();
        if(shouldCountTillNextAttack){
            this.ticksUntilNextAttack = Math.max(this.ticksUntilNextAttack - 1, 0);
        }
    }

    @Override
    public void start() {
        super.start();
        this.attackDelay = 40;
        this.ticksUntilNextAttack = 80;
    }

    @Override
    public void stop() {
        entity.setAttacking(false);
        super.stop();
    }

    @Override
    protected void checkAndPerformAttack(LivingEntity pEnemy, double pDistToEnemySqr) {
        if(isWithinMeleeAttackDistance(pEnemy,pDistToEnemySqr)){
            shouldCountTillNextAttack = true;
            if(isTimeToStartAttackAnimation()){
                entity.setAttacking(true);
            }

            if(isTimeToAttack()){
                this.mob.getLookControl().setLookAt(pEnemy.getX(),pEnemy.getEyeY(),pEnemy.getZ());
                performAttack(pEnemy);
            }
        }
        else if(isWithinRangedAttackDistance(pEnemy,pDistToEnemySqr)){
            shouldCountTillNextAttack = true;
            if(isTimeToStartAttackAnimation()){
                entity.setAttacking(true);
            }

            if(isTimeToAttack()){
                this.mob.getLookControl().setLookAt(pEnemy.getX(),pEnemy.getEyeY(),pEnemy.getZ());
                performAttack(pEnemy);
            }
        }
        else{
            resetAttackCooldown();
            shouldCountTillNextAttack = false;
            entity.setAttacking(false);
            entity.attackAnimationTimeOut = 0;
        }
    }

    private boolean isWithinRangedAttackDistance(LivingEntity pEnemy, double pDistToEnemySqr) {
        return pDistToEnemySqr > this.getAttackReachSqr(pEnemy)   &&
                pDistToEnemySqr <= (this.getAttackReachSqr(pEnemy)*2d);
    }

    private void performAttack(LivingEntity pEnemy) {
        FlameThrowable basicProjectile = new FlameThrowable(entity.level(),entity,AGI);
        double d0 = pEnemy.getEyeY() - (double)1.1F;
        double d1 = pEnemy.getX() - entity.getX();
        double d2 = d0 - basicProjectile.getY();
        double d3 = pEnemy.getZ() - entity.getZ();
        double d4 = Math.sqrt(d1 * d1 + d3 * d3) * (double)0.2F;
        basicProjectile.shoot(d1, d2 + d4, d3, 1.6F, 12.0F);
        entity.playSound(SoundEvents.SNOW_GOLEM_SHOOT, 1.0F, 0.4F / (entity.getRandom().nextFloat() * 0.4F + 0.8F));
        entity.level().addFreshEntity(basicProjectile);
    }

    private boolean isTimeToStartAttackAnimation() {
        return this.ticksUntilNextAttack <= attackDelay;
    }

    private boolean isWithinMeleeAttackDistance(LivingEntity pEnemy, double pDistToEnemySqr) {
        return pDistToEnemySqr <= this.getAttackReachSqr(pEnemy);
    }

    public void performRangedAttack(LivingEntity pTarget, float pDistanceFactor) {
        FlameThrowable basicProjectile = new FlameThrowable(entity.level(),entity,AGI);
        double d0 = pTarget.getEyeY() - (double)1.1F;
        double d1 = pTarget.getX() - entity.getX();
        double d2 = d0 - basicProjectile.getY();
        double d3 = pTarget.getZ() - entity.getZ();
        double d4 = Math.sqrt(d1 * d1 + d3 * d3) * (double)0.2F;
        basicProjectile.shoot(d1, d2 + d4, d3, 1.6F, 12.0F);
        entity.playSound(SoundEvents.SNOW_GOLEM_SHOOT, 1.0F, 0.4F / (entity.getRandom().nextFloat() * 0.4F + 0.8F));
        entity.level().addFreshEntity(basicProjectile);
    }
}
