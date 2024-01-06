package net.slimpopo.personamod.constant.entity;

import net.slimpopo.personamod.constant.damage.Affinity;
import net.slimpopo.personamod.constant.entity.level.DamageLevelIdentifier;
import net.slimpopo.personamod.constant.spell.Spell;
import net.slimpopo.personamod.item.constants.SpellItem;

import java.util.List;

public class MobPersona extends Persona{

    private int LEVEL;
    private int EXPERIENCE;
    private List<SpellItem> currentSkills;
    public List<SpellItem> getCurrentSkills() {
        return currentSkills;
    }

    public MobPersona(String name,int STRENGTH, int MAGIC, int ENDURANCE, int AGILITY, int LUCK, List<Affinity> strongAgainst,
                      List<Affinity> weakAgainst, List<Affinity> nullAgainst, List<Affinity> absorbAgainst,
                      List<SpellItem> currentSkills, int level, List<Affinity> repelAgainst, int experience) {

        super(name,STRENGTH, MAGIC, ENDURANCE, AGILITY, LUCK, strongAgainst, weakAgainst, nullAgainst,
                absorbAgainst, repelAgainst);
        this.currentSkills = currentSkills;
        this.LEVEL = level;
        this.EXPERIENCE = experience;
    }

    public int getLEVEL() {
        return LEVEL;
    }

    public void setLEVEL(int LEVEL) {
        this.LEVEL = LEVEL;
    }

    @Override
    public float getDamageNumberBasedOnSpell(Spell spell, Persona source) {
        int level = 1;

        if(spell.isHasBeenRepelled() && this.getReflectAgainst().contains(spell.getAFFINITY())){
            return 0f;
        }

        float base_power = (float)(Math.max(Math.sqrt(spell.getDAMAGE_TYPE().getDamageMultiplier()) *
                Math.sqrt(source.getCorrespondingStatToSpell(spell)),1));

        float total_power = (float) (base_power/(Math.sqrt((source.getENDURANCE() * 8))));

        if(source instanceof ControlledPersona cp) {
            level = cp.getPersonaLevel().getCurrentLevel();
        }

        if(source instanceof MobPersona cp) {
            level = cp.getLEVEL();
        }

        float damageScaleBasedOnLevel = DamageLevelIdentifier
                .getDamageMultiplierBasedOnLevel(level, this.getLEVEL());

        float damageScaleBasedOnElement = this.checkAffinityResistance(spell);

        return total_power * damageScaleBasedOnElement * damageScaleBasedOnLevel;
    }

    public int getEXPERIENCE() {
        return EXPERIENCE;
    }
}
