package net.slimpopo.personamod.item.constants;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.level.block.Blocks;
import net.slimpopo.personamod.constant.damage.Affinity;
import net.slimpopo.personamod.constant.damage.DamageType;
import net.slimpopo.personamod.constant.spell.Spell;
import net.slimpopo.personamod.constant.spell.SpellLevel;
import net.slimpopo.personamod.effects.ModEffects;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SpellList {
    private static List<Spell> spellList = new ArrayList<>();

    public SpellList() {
        spellList.add(new Spell("Agi", "Light Fire damage to 1 foe.",
                Affinity.FIRE, DamageType.LIGHT, SpellLevel.ONE_STAR, Blocks.MAGMA_BLOCK,
                new MobEffectInstance(ModEffects.BURN.get(), 60 * SpellLevel.ONE_STAR.getLevel(), 1),
                4,null));
        spellList.add(new Spell("Agilao","Medium Fire damage to 1 foe.",
                Affinity.FIRE, DamageType.MEDIUM, SpellLevel.TWO_STAR, Blocks.MAGMA_BLOCK,
                new MobEffectInstance(ModEffects.BURN.get(),60 * SpellLevel.TWO_STAR.getLevel(), 1)
                ,8,null));
        spellList.add(new Spell("Agidyne","Heavy Fire damage to 1 foe.",
                Affinity.FIRE, DamageType.HEAVY, SpellLevel.THREE_STAR, Blocks.MAGMA_BLOCK,
                new MobEffectInstance(ModEffects.BURN.get(),60 * SpellLevel.THREE_STAR.getLevel(), 1)
                ,12,null));
        spellList.add(new Spell("Maragi","Light Fire damage to all foes.",
                Affinity.FIRE, DamageType.LIGHT, SpellLevel.MA_ONE_STAR, Blocks.MAGMA_BLOCK,
                new MobEffectInstance(ModEffects.BURN.get(),60 * SpellLevel.ONE_STAR.getLevel(), 1)
                ,10,null));
        spellList.add(new Spell("Maragion","Medium Fire damage to all foe.",
                Affinity.FIRE, DamageType.MEDIUM, SpellLevel.MA_TWO_STAR, Blocks.MAGMA_BLOCK,
                new MobEffectInstance(ModEffects.BURN.get(),60 * SpellLevel.TWO_STAR.getLevel(), 1)
                ,16,null));
        spellList.add(new Spell("Maragidyne","Heavy Fire damage to 1 foe.",
                Affinity.FIRE, DamageType.HEAVY, SpellLevel.MA_THREE_STAR, Blocks.MAGMA_BLOCK,
                new MobEffectInstance(ModEffects.BURN.get(),60 * SpellLevel.THREE_STAR.getLevel(), 1)
                ,22,null));
        spellList.add(new Spell("Bufu","Light Ice damage to 1 foe.",
                Affinity.ICE, DamageType.LIGHT, SpellLevel.ONE_STAR, Blocks.ICE,
                new MobEffectInstance(ModEffects.FREEZE.get(),60 * SpellLevel.ONE_STAR.getLevel(), 1)
                ,4,null));
        spellList.add(new Spell("Bufula","Medium Ice damage to 1 foe.",
                Affinity.ICE, DamageType.MEDIUM, SpellLevel.TWO_STAR, Blocks.ICE,
                new MobEffectInstance(ModEffects.FREEZE.get(),60 * SpellLevel.TWO_STAR.getLevel(), 1)
                ,8,null));
        spellList.add(new Spell("Bufudyne","Heavy Ice damage to 1 foe.",
                Affinity.ICE, DamageType.HEAVY, SpellLevel.THREE_STAR, Blocks.ICE,
                new MobEffectInstance(ModEffects.FREEZE.get(),60 * SpellLevel.THREE_STAR.getLevel(), 1)
                ,12,null));
        spellList.add(new Spell("Mabufu","Light Ice damage to all foes.",
                Affinity.ICE, DamageType.LIGHT, SpellLevel.MA_ONE_STAR, Blocks.ICE,
                new MobEffectInstance(ModEffects.FREEZE.get(),60 * SpellLevel.ONE_STAR.getLevel(), 1)
                ,10,null));
        spellList.add(new Spell("Mabufula","Medium Ice damage to all foes.",
                Affinity.ICE, DamageType.MEDIUM, SpellLevel.MA_TWO_STAR, Blocks.ICE,
                new MobEffectInstance(ModEffects.FREEZE.get(),60 * SpellLevel.TWO_STAR.getLevel(), 1)
                ,16,null));
        spellList.add(new Spell("Mabufudyne","Heavy Ice damage to all foes.",
                Affinity.ICE, DamageType.HEAVY, SpellLevel.MA_THREE_STAR, Blocks.ICE,
                new MobEffectInstance(ModEffects.FREEZE.get(),60 * SpellLevel.THREE_STAR.getLevel(), 1)
                ,22,null));
        spellList.add(new Spell("Zio","Light Electricity damage to 1 foe.",
                Affinity.ELECTRIC, DamageType.LIGHT, SpellLevel.ONE_STAR, null,
                new MobEffectInstance(ModEffects.SHOCK.get(),60 * SpellLevel.ONE_STAR.getLevel(), 1)
                ,4,null));
        spellList.add(new Spell("Zionga","Medium Electricity damage to 1 foe.",
                Affinity.ELECTRIC, DamageType.MEDIUM, SpellLevel.TWO_STAR, null,
                new MobEffectInstance(ModEffects.SHOCK.get(),60 * SpellLevel.TWO_STAR.getLevel(), 1)
                ,8,null));
        spellList.add(new Spell("Ziodyne","Heavy Electricity damage to 1 foe.",
                Affinity.ELECTRIC, DamageType.HEAVY, SpellLevel.THREE_STAR, null,
                new MobEffectInstance(ModEffects.SHOCK.get(),60 * SpellLevel.THREE_STAR.getLevel(), 1)
                ,12,null));
        spellList.add(new Spell("Mazio","Light Electricity damage to all foes.",
                Affinity.ELECTRIC, DamageType.LIGHT, SpellLevel.MA_ONE_STAR, null,
                new MobEffectInstance(ModEffects.SHOCK.get(),60 * SpellLevel.ONE_STAR.getLevel(), 1)
                ,10,null));
        spellList.add(new Spell("Mazionga","Medium Electricity damage to all foe.",
                Affinity.ELECTRIC, DamageType.MEDIUM, SpellLevel.MA_TWO_STAR, null,
                new MobEffectInstance(ModEffects.SHOCK.get(),60 * SpellLevel.TWO_STAR.getLevel(), 1)
                ,16,null));
        spellList.add(new Spell("Maziodyne","Heavy Electricity damage to all foe.",
                Affinity.ELECTRIC, DamageType.HEAVY, SpellLevel.MA_THREE_STAR, null,
                new MobEffectInstance(ModEffects.SHOCK.get(),60 * SpellLevel.THREE_STAR.getLevel(), 1)
                ,22,null));
        spellList.add(new Spell("Frei","Light Nuke damage to 1 foe.",
                Affinity.NUCLEAR, DamageType.LIGHT, SpellLevel.ONE_STAR, null, null,
                4,null));
        spellList.add(new Spell("Freila","Medium Nuke damage to 1 foe.",
                Affinity.NUCLEAR, DamageType.MEDIUM, SpellLevel.TWO_STAR, null, null,
                8,null));
        spellList.add(new Spell("Freidyne","Heavy Nuke damage to 1 foe.",
                Affinity.NUCLEAR, DamageType.HEAVY, SpellLevel.THREE_STAR, null, null,
                12,null));
        spellList.add(new Spell("Mafrei","Light Nuke damage to all foe.",
                Affinity.NUCLEAR, DamageType.LIGHT, SpellLevel.MA_ONE_STAR, null, null,
                10,null));
        spellList.add(new Spell("Mafreila","Medium Nuke damage to all foe.",
                Affinity.NUCLEAR, DamageType.MEDIUM, SpellLevel.MA_TWO_STAR, null, null,
                16,null));
        spellList.add(new Spell("Mafreidyne","Heavy Nuke damage to all foe.",
                Affinity.NUCLEAR, DamageType.HEAVY, SpellLevel.MA_THREE_STAR, null, null,
                22,null));
        spellList.add(new Spell("Psi","Light Psy damage to 1 foe.",
                Affinity.PSYCHOKINESIS, DamageType.LIGHT, SpellLevel.ONE_STAR, null, null,
                4,null));
        spellList.add(new Spell("Psio","Medium Psy damage to 1 foe.",
                Affinity.PSYCHOKINESIS, DamageType.MEDIUM, SpellLevel.TWO_STAR, null, null,
                8,null));
        spellList.add(new Spell("Psiodyne","Heavy Psy damage to 1 foe.",
                Affinity.PSYCHOKINESIS, DamageType.HEAVY, SpellLevel.THREE_STAR, null, null,
                12,null));
        spellList.add(new Spell("Mapsi","Light Psy damage to all foe.",
                Affinity.PSYCHOKINESIS, DamageType.LIGHT, SpellLevel.MA_ONE_STAR, null, null,
                10,null));
        spellList.add(new Spell("Mapsio","Medium Psy damage to all foe.",
                Affinity.PSYCHOKINESIS, DamageType.MEDIUM, SpellLevel.MA_TWO_STAR, null, null,
                16,null));
        spellList.add(new Spell("Mapsiodyne","Heavy Psy damage to all foe.",
                Affinity.PSYCHOKINESIS, DamageType.HEAVY, SpellLevel.MA_THREE_STAR, null, null,
                22,null));
        spellList.add(new Spell("Garu","Light Wind damage to 1 foe.",
                Affinity.WIND, DamageType.LIGHT, SpellLevel.ONE_STAR, null,
                new MobEffectInstance(MobEffects.LEVITATION,60 * SpellLevel.ONE_STAR.getLevel(), 1),
                4,null));
        spellList.add(new Spell("Garula","Medium Wind damage to 1 foe.",
                Affinity.WIND, DamageType.MEDIUM, SpellLevel.TWO_STAR, null,
                new MobEffectInstance(MobEffects.LEVITATION,60 * SpellLevel.TWO_STAR.getLevel(), 1),
                8,null));
        spellList.add(new Spell("Garudyne","Heavy Wind damage to 1 foe.",
                Affinity.WIND, DamageType.HEAVY, SpellLevel.THREE_STAR, null,
                new MobEffectInstance(MobEffects.LEVITATION,60 * SpellLevel.THREE_STAR.getLevel(), 1),
                12,null));
        spellList.add(new Spell("Magaru","Light Wind damage to all foe.",
                Affinity.WIND, DamageType.LIGHT, SpellLevel.MA_ONE_STAR, null,
                new MobEffectInstance(MobEffects.LEVITATION,60 * SpellLevel.ONE_STAR.getLevel(), 1),
                10,null));
        spellList.add(new Spell("Garula","Medium Wind damage to all foe.",
                Affinity.WIND, DamageType.MEDIUM, SpellLevel.MA_TWO_STAR, null,
                new MobEffectInstance(MobEffects.LEVITATION,60 * SpellLevel.ONE_STAR.getLevel(), 1),
                16,null));
        spellList.add(new Spell("Magarudyne","Heavy Wind damage to all foe.",
                Affinity.WIND, DamageType.HEAVY, SpellLevel.MA_THREE_STAR, null,
                new MobEffectInstance(MobEffects.LEVITATION,60 * SpellLevel.THREE_STAR.getLevel(), 1),
                22,null));
        spellList.add(new Spell("Eiha","Light Curse damage to enemy.",
                Affinity.CURSE, DamageType.LIGHT, SpellLevel.ONE_STAR, null,null,
                4,null));
        spellList.add(new Spell("Eiga","Medium Curse damage to enemy.",
                Affinity.CURSE, DamageType.MEDIUM, SpellLevel.TWO_STAR, null,null,
                8,null));
        spellList.add(new Spell("Eigaon","Medium Curse damage to enemy.",
                Affinity.CURSE, DamageType.HEAVY, SpellLevel.THREE_STAR, null,null,
                12,null));
        spellList.add(new Spell("Maeiha","Light Curse damage to enemies.",
                Affinity.CURSE, DamageType.LIGHT, SpellLevel.MA_ONE_STAR, null,null,
                10,null));
        spellList.add(new Spell("Maeiga","Light Curse damage to enemies.",
                Affinity.CURSE, DamageType.MEDIUM, SpellLevel.MA_TWO_STAR, null,null,
                16,null));
        spellList.add(new Spell("Maeigaon","Heavy Curse damage to enemies.",
                Affinity.CURSE, DamageType.HEAVY, SpellLevel.MA_THREE_STAR, null,null,
                22,null));
        spellList.add(new Spell("Mudo","Light Chance of death to enemy.",
                Affinity.CURSE, DamageType.INSTAKILL, SpellLevel.ONE_STAR, null,null,
                8,null));
        spellList.add(new Spell("Mudoon","High Chance of death to enemy.",
                Affinity.CURSE, DamageType.INSTAKILL, SpellLevel.ONE_STAR, null,null,
                15,null));
        spellList.add(new Spell("Mamudo","Light Chance of death to enemies.",
                Affinity.CURSE, DamageType.INSTAKILL, SpellLevel.ONE_STAR, null,null,
                18,null));
        spellList.add(new Spell("Mamudoon","High Chance of death to enemies.",
                Affinity.CURSE, DamageType.INSTAKILL, SpellLevel.TWO_STAR, null,null,
                34,null));
        spellList.add(new Spell("Kouha","Light bless damage to enemy.",
                Affinity.BLESS, DamageType.LIGHT, SpellLevel.ONE_STAR, null,null,
                4,null));
        spellList.add(new Spell("Kouga","Medium bless damage to enemy.",
                Affinity.BLESS, DamageType.MEDIUM, SpellLevel.TWO_STAR, null,null,
                8,null));
        spellList.add(new Spell("Kougaon","Heavy bless damage to enemy.",
                Affinity.BLESS, DamageType.HEAVY, SpellLevel.THREE_STAR, null,null,
                12,null));
        spellList.add(new Spell("Makouga","Medium bless damage to enemies.",
                Affinity.BLESS, DamageType.MEDIUM, SpellLevel.MA_TWO_STAR, null,null,
                10,null));
        spellList.add(new Spell("Makouha","Light bless damage to enemies.",
                Affinity.BLESS, DamageType.LIGHT, SpellLevel.MA_ONE_STAR, null,null,
                16,null));
        spellList.add(new Spell("Makougaon","Heavy bless damage to enemies.",
                Affinity.BLESS, DamageType.HEAVY, SpellLevel.MA_THREE_STAR, null,null,
                22,null));
        spellList.add(new Spell("Hama","Light Chance of death to enemy.",
                Affinity.BLESS, DamageType.INSTAKILL, SpellLevel.ONE_STAR, null,null,
                8,null));
        spellList.add(new Spell("Hamaon","High Chance of death to enemy.",
                Affinity.BLESS, DamageType.INSTAKILL, SpellLevel.TWO_STAR, null,null,
                15,null));
        spellList.add(new Spell("Mahama","Light Chance of death to enemies.",
                Affinity.BLESS, DamageType.INSTAKILL, SpellLevel.ONE_STAR, null,null,
                18,null));
        spellList.add(new Spell("Mahamaon","High Chance of death to enemies.",
                Affinity.BLESS, DamageType.INSTAKILL, SpellLevel.ONE_STAR, null,null,
                34,null));
    }

    public static Spell getSpellDataWithName(String name){
       return spellList.stream().filter(spell -> spell.getSPELL_NAME().equalsIgnoreCase(name)).findFirst()
               .orElse(new Spell());
    }

    public static Spell getSpellFromRandom(){
        Random random = new Random();
        return spellList.get(random.nextInt(spellList.size()));
    }

}
