package net.slimpopo.personamod.constant.entity.level;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.Tag;
import net.slimpopo.personamod.item.constants.SpellItem;
import net.slimpopo.personamod.item.constants.SpellItemList;

public class SkillLearnedLevel{
    private int levelRequired;
    private SpellItem spellItemRelated;

    public SkillLearnedLevel(){

    }

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

    public CompoundTag createCompoundNBTData() {
        CompoundTag compoundTag = new CompoundTag();
        compoundTag.putInt("level_req", levelRequired);
        compoundTag.putString("spell_itm_related", spellItemRelated.getSpellData().getSPELL_NAME());
        return compoundTag;
    }

    public SkillLearnedLevel loadCompoundNBTData(Tag tag) {
        CompoundTag compoundTag = (CompoundTag) tag;
        this.levelRequired = compoundTag.getInt("level_req");
        this.spellItemRelated = SpellItemList.getSpellItem(compoundTag.getString("spell_itm_related"));
        return this;
    }
}