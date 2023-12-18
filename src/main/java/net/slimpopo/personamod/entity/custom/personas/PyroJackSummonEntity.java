package net.slimpopo.personamod.entity.custom.personas;

import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.level.Level;
import net.slimpopo.personamod.constant.damage.Affinity;
import net.slimpopo.personamod.constant.entity.ControlledPersona;
import net.slimpopo.personamod.constant.entity.MobPersona;
import net.slimpopo.personamod.entity.ai.PyroJackRangedAttackGoal;
import net.slimpopo.personamod.entity.custom.constants.ControlledPersonaEntity;
import net.slimpopo.personamod.entity.custom.constants.ControlledPersonaList;
import net.slimpopo.personamod.entity.custom.constants.PersonaEntity;
import net.slimpopo.personamod.item.ModItems;

import java.util.ArrayList;
import java.util.List;

public class PyroJackSummonEntity extends ControlledPersonaEntity {

    private static final EntityDataAccessor<Boolean> ATTACKING =
            SynchedEntityData.defineId(PyroJackSummonEntity.class, EntityDataSerializers.BOOLEAN);

    public PyroJackSummonEntity(EntityType<? extends ControlledPersonaEntity> pEntityType, Level pLevel) {
        super(pEntityType, pLevel, ControlledPersonaList.getDataFromList("pyro_jack"));
    }

    public final AnimationState idleAnimationState = new AnimationState();
    private int idleAnimationTimeOut = 0;

    public final AnimationState attackAnimationState = new AnimationState();
    public int attackAnimationTimeOut = 0;

    @Override
    public void tick() {
        super.tick();

        if(this.level().isClientSide){


        }
    }

    private void setupAnimationStates(){
        if(this.idleAnimationTimeOut <= 0){
            this.idleAnimationTimeOut = this.random.nextInt(40)+80;
            this.idleAnimationState.start(this.tickCount);
        }
        else{
            --this.idleAnimationTimeOut;
        }

        if(this.isAttacking() && attackAnimationTimeOut <=0){
            attackAnimationTimeOut = 30;
            attackAnimationState.start(this.tickCount);
        }
        else{
            --this.attackAnimationTimeOut;
        }

        if(!this.isAttacking()){
            attackAnimationState.stop();
        }
    }

    @Override
    protected void updateWalkAnimation(float pPartialTick) {
        float f;
        if(this.getPose() == Pose.STANDING){
            f = Math.min(pPartialTick * 6f, 1f);
        } else {
            f = 0f;
        }

        this.walkAnimation.update(f,0.2f);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(1,new PyroJackRangedAttackGoal( this,1.0D,
                false));
        this.goalSelector.addGoal(5, new RandomLookAroundGoal(this));

        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this,Zombie.class,true));

    }

    public static AttributeSupplier.Builder createAttributes(){
        return Monster.createMonsterAttributes()
                .add(Attributes.MAX_HEALTH, 20D)
                .add(Attributes.MOVEMENT_SPEED,0.25D);
    }

    public void setAttacking(boolean attacking){
        this.entityData.set(ATTACKING,attacking);
    }

    public boolean isAttacking(){
        return this.entityData.get(ATTACKING);
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(ATTACKING,false);
    }
}
