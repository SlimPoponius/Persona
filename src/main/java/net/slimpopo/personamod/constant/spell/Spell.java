package net.slimpopo.personamod.constant.spell;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.level.block.Block;
import net.slimpopo.personamod.constant.damage.Affinity;
import net.slimpopo.personamod.constant.damage.DamageType;

public class Spell {
    private String SPELL_NAME;
    private String SPELL_DESC;
    private Affinity AFFINITY;
    private DamageType DAMAGE_TYPE;
    private SpellLevel SPELL_LEVEL;
    private MobEffectInstance SPELL_EFFECT;

    private Block block;

    public Spell(){
        SPELL_NAME = "Lunge";
        SPELL_DESC = "Light Physical damage to 1 foe.";
        AFFINITY = Affinity.PHYSICAL;
        DAMAGE_TYPE = DamageType.LIGHT;
        SPELL_LEVEL = SpellLevel.ONE_STAR;
    }

    public Spell(String spellName,String spellDesc,Affinity affinity,
                 DamageType damageType, SpellLevel spellLevel, Block affectBlock, MobEffectInstance spellEffect){
        SPELL_NAME = spellName;
        SPELL_DESC = spellDesc;
        AFFINITY = affinity;
        DAMAGE_TYPE = damageType;
        SPELL_LEVEL = spellLevel;
        SPELL_EFFECT = spellEffect;
        this.block = affectBlock;

    }

    public Affinity getAFFINITY() {
        return AFFINITY;
    }

    public DamageType getDAMAGE_TYPE() {
        return DAMAGE_TYPE;
    }

    public SpellLevel getSPELL_LEVEL() {
        return SPELL_LEVEL;
    }

    public String getSPELL_NAME() {
        return SPELL_NAME;
    }

    public String getSPELL_DESC() {
        return SPELL_DESC;
    }

    public MobEffectInstance getSPELL_EFFECT() {
        return SPELL_EFFECT;
    }

    public Block getBlock() {
        return block;
    }
}
