package net.slimpopo.personamod.constant.entity;

import net.slimpopo.personamod.constant.damage.Affinity;
import net.slimpopo.personamod.constant.entity.level.PersonaLevel;
import net.slimpopo.personamod.item.constants.SpellItem;

import java.util.List;

public class ControlledPersona extends Persona{

    private List<SpellItem> learnedSkills;
    private PersonaLevel personaLevel;

    public ControlledPersona(PersonaLevel level, int STRENGTH, int MAGIC, int ENDURANCE, int AGILITY, int LUCK,
                             List<Affinity> strongAgainst, List<Affinity> weakAgainst, List<Affinity> nullAgainst,
                             List<Affinity> absorbAgainst, List<SpellItem> learnedSkills) {
        super(STRENGTH, MAGIC, ENDURANCE, AGILITY, LUCK, strongAgainst, weakAgainst,
                nullAgainst, absorbAgainst);
        this.learnedSkills = learnedSkills;
        this.personaLevel = level;
    }

    public List<SpellItem> getLearnedSkills() {
        return learnedSkills;
    }

    public void setLearnedSkills(List<SpellItem> learnedSkills) {
        this.learnedSkills = learnedSkills;
    }

    public PersonaLevel getPersonaLevel() {
        return personaLevel;
    }

    public void setPersonaLevel(PersonaLevel personaLevel) {
        this.personaLevel = personaLevel;
    }
}
