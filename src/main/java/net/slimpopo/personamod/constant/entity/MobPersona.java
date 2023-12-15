package net.slimpopo.personamod.constant.entity;

import net.slimpopo.personamod.constant.damage.Affinity;
import net.slimpopo.personamod.item.constants.SpellItem;

import java.util.List;

public class MobPersona extends Persona{

    private int LEVEL;
    private List<SpellItem> currentSkills;
    public List<SpellItem> getCurrentSkills() {
        return currentSkills;
    }

    public MobPersona(int STRENGTH, int MAGIC, int ENDURANCE, int AGILITY, int LUCK, List<Affinity> strongAgainst,
                      List<Affinity> weakAgainst, List<Affinity> nullAgainst, List<Affinity> absorbAgainst,
                      List<SpellItem> currentSkills, int level) {

        super(STRENGTH, MAGIC, ENDURANCE, AGILITY, LUCK, strongAgainst, weakAgainst, nullAgainst, absorbAgainst);
        this.currentSkills = currentSkills;
        this.LEVEL = level;
    }

    public int getLEVEL() {
        return LEVEL;
    }

    public void setLEVEL(int LEVEL) {
        this.LEVEL = LEVEL;
    }
}
