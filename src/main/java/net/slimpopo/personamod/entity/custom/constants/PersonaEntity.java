package net.slimpopo.personamod.entity.custom.constants;

import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.level.Level;
import net.slimpopo.personamod.constant.entity.MobPersona;
import net.slimpopo.personamod.constant.spell.Spell;
import net.slimpopo.personamod.item.constants.SpellList;

public class PersonaEntity extends PathfinderMob{
    private SpellList spellList = new SpellList();
    private final MobPersona personaData;

    protected PersonaEntity(EntityType<? extends PathfinderMob> pEntityType, Level pLevel, MobPersona mobPersona) {
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
}
