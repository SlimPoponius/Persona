package net.slimpopo.personamod.constant.entity.level;

import net.slimpopo.personamod.item.constants.SpellItem;

public class SkillLearnedLevel{
    private int levelRequired;
    private SpellItem spellItemRelated;

    public SkillLearnedLevel(int levelRequired, SpellItem spellItemRelated){
        this.levelRequired = levelRequired;
        this.spellItemRelated = spellItemRelated;
    }

    public int getLevelRequired() {
        return levelRequired;
    }

    public SpellItem getSpellItemRelated() {
        return spellItemRelated;
    }
}