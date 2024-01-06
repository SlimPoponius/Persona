package net.slimpopo.personamod.constant.spell;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.level.block.Block;
import net.slimpopo.personamod.constant.damage.Affinity;
import net.slimpopo.personamod.constant.damage.DamageType;

public class Spell {
    private final String SPELL_NAME;
    private final String SPELL_DESC;
    private final Affinity AFFINITY;
    private final DamageType DAMAGE_TYPE;
    private final SpellLevel SPELL_LEVEL;
    private final Integer spCost;
    private final Float healthCost;

    private boolean hasBeenRepelled;
    private MobEffectInstance SPELL_EFFECT;

    private Block block;

    public Spell(){
        SPELL_NAME = "Lunge";
        SPELL_DESC = "Light Physical damage to 1 foe.";
        AFFINITY = Affinity.PHYSICAL;
        DAMAGE_TYPE = DamageType.LIGHT;
        SPELL_LEVEL = SpellLevel.ONE_STAR;
        healthCost = 0f;
        spCost = 0;
    }

    public Spell(String spellName,String spellDesc,Affinity affinity,
                 DamageType damageType, SpellLevel spellLevel, Block affectBlock, MobEffectInstance spellEffect,
                 Integer spCost, Float healthCost){
        SPELL_NAME = spellName;
        SPELL_DESC = spellDesc;
        AFFINITY = affinity;
        DAMAGE_TYPE = damageType;
        SPELL_LEVEL = spellLevel;
        SPELL_EFFECT = spellEffect;
        this.block = affectBlock;
        this.healthCost = healthCost;
        this.spCost = spCost;

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

    public Float getHealthCost() {
        return healthCost;
    }

    public Integer getSpCost() {
        return spCost;
    }

    public void setHasBeenRepelled(boolean hasBeenRepelled) {
        this.hasBeenRepelled = hasBeenRepelled;
    }

    public boolean isHasBeenRepelled() {
        return hasBeenRepelled;
    }
}
