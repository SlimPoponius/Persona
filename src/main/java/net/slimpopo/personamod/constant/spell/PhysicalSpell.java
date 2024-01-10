package net.slimpopo.personamod.constant.spell;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.level.block.Block;
import net.slimpopo.personamod.constant.damage.Affinity;
import net.slimpopo.personamod.constant.damage.DamageType;
import net.slimpopo.personamod.constant.damage.RangeType;

public class PhysicalSpell extends Spell{

    private final RangeType SPELL_RANGE_TYPE;

    public PhysicalSpell(){
        super();
        SPELL_RANGE_TYPE = RangeType.NARROW;

    }

    public PhysicalSpell(String spellName, String spellDesc, Affinity affinity,
                         DamageType damageType, SpellLevel spellLevel,Block affectBlock,
                         MobEffectInstance spellEffect,Integer spCost, Float healthCost, RangeType rangeType){
        super(spellName,spellDesc,affinity,damageType,spellLevel,affectBlock,spellEffect,spCost,healthCost);
        SPELL_RANGE_TYPE = rangeType;
    }

    public RangeType getSPELL_RANGE_TYPE() {
        return SPELL_RANGE_TYPE;
    }
}
