package net.slimpopo.personamod.entity.custom.personas;

import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializer;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.MoveTowardsTargetGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.RangedAttackMob;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.level.Level;
import net.slimpopo.personamod.constant.damage.Affinity;
import net.slimpopo.personamod.constant.entity.MobPersona;
import net.slimpopo.personamod.entity.ai.PyroJackRangedAttackGoal;
import net.slimpopo.personamod.entity.custom.constants.PersonaEntity;
import net.slimpopo.personamod.item.ModItems;
import org.checkerframework.checker.units.qual.A;

import java.util.ArrayList;
import java.util.List;

public class PyroJackEntity extends PersonaEntity {

    private static final MobPersona PERSONA_DATA =
            new MobPersona("pyro_jack",2,5,3,1,2,
                    new ArrayList<>(),List.of(Affinity.ICE,Affinity.WIND),new ArrayList<>(),
                    List.of(Affinity.FIRE), List.of(ModItems.AGI.get()), 2, new ArrayList<>(),4);

    private static final EntityDataAccessor<Boolean> ATTACKING =
            SynchedEntityData.defineId(PyroJackEntity.class, EntityDataSerializers.BOOLEAN);

    public PyroJackEntity(EntityType<? extends PersonaEntity> pEntityType, Level pLevel) {
        super(pEntityType, pLevel,PERSONA_DATA);
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
        this.goalSelector.addGoal(2,new PyroJackRangedAttackGoal( this,1.0D,
                false));
        super.registerGoals();
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
