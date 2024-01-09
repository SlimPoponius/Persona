package net.slimpopo.personamod.entity.custom.constants;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.level.Level;
import net.slimpopo.personamod.constant.entity.ControlledPersona;
import net.slimpopo.personamod.constant.entity.MobPersona;
import net.slimpopo.personamod.constant.entity.Persona;
import net.slimpopo.personamod.constant.entity.level.DamageLevelIdentifier;
import net.slimpopo.personamod.constant.spell.Spell;
import net.slimpopo.personamod.item.constants.SpellList;

import javax.naming.ldap.Control;

public class PersonaEntity extends PathfinderMob{
    private SpellList spellList = new SpellList();
    private final MobPersona personaData;

    public PersonaEntity(EntityType<? extends PathfinderMob> pEntityType, Level pLevel, MobPersona mobPersona) {
        super(pEntityType, pLevel);
        this.personaData = mobPersona;
        this.xpReward = 3 * personaData.getLEVEL();
    }

    public boolean hurt(DamageSource pSource, Spell spellInformation, float pAmount) {
        float multiplier = 1.0f;
        if(personaData.getWeakAgainst().contains(spellInformation.getAFFINITY())){
            multiplier = 1.5f;
        }
        else if(personaData.getStrongAgainst().contains(spellInformation.getAFFINITY())){
            multiplier = 0.5f;
        }
        else if(personaData.getAbsorbAgainst().contains(spellInformation.getAFFINITY())){
            this.heal(pAmount);
            return false;
        }
        else if(personaData.getNullAgainst().contains(spellInformation.getAFFINITY())){
            multiplier = 0.0f;
        }
        return super.hurt(pSource, pAmount * multiplier);
    }

    public SpellList getSpellList() {
        return spellList;
    }

    public MobPersona getPersonaData() {
        return personaData;
    }


    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(3, new FloatGoal(this));
        this.goalSelector.addGoal(5, new RandomLookAroundGoal(this));
        this.goalSelector.addGoal(7, new RandomStrollGoal(this, 1.0D));
        this.goalSelector.addGoal(2, new MoveTowardsTargetGoal(this, 0.9D, 32.0F));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, Zombie.class,true));
    }


}
