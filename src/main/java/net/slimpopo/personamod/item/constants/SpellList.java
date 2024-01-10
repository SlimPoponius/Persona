package net.slimpopo.personamod.item.constants;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.level.block.Blocks;
import net.slimpopo.personamod.constant.damage.Affinity;
import net.slimpopo.personamod.constant.damage.DamageType;
import net.slimpopo.personamod.constant.damage.RangeType;
import net.slimpopo.personamod.constant.spell.PhysicalSpell;
import net.slimpopo.personamod.constant.spell.Spell;
import net.slimpopo.personamod.constant.spell.SpellLevel;
import net.slimpopo.personamod.effects.ModEffects;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SpellList {
    private static List<Spell> spellList = new ArrayList<>();

    public SpellList() {
        //region FIRE
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
        //endregion
        //region ICE
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
        //endregion
        //region ELECTRIC
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
        //endregion
        //region NUCLEAR
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
        //endregion
        //region PSYCHOKINESIS
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
        //endregion
        //region WIND
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
        //endregion
        //region CURSE
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
        //endregion
        //region BLESS
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
        //endregion
        //region ALMIGHTY
        spellList.add(new Spell("Megido","Medium Almighty damage to a wide area of foes. ",
                Affinity.ALMIGHTY, DamageType.MEDIUM, SpellLevel.MA_ONE_STAR, null,null,
                14,null));
        spellList.add(new Spell("Megidola","Medium Almighty damage to a wide area of foes. ",
                Affinity.ALMIGHTY, DamageType.HEAVY, SpellLevel.MA_TWO_STAR, null,null,
                24,null));
        spellList.add(new Spell("Megidolaon","Medium Almighty damage to a wide area of foes. ",
                Affinity.ALMIGHTY, DamageType.SEVERE, SpellLevel.MA_THREE_STAR, null,null,
                36,null));
        //endregion
        //region STAT-CHANGING
        spellList.add(new Spell("Tarukaja","Temporarily increase attack power for one ally. ",
                Affinity.NONE, DamageType.NONE, SpellLevel.ONE_STAR, null,null,
                12,null));
        spellList.add(new Spell("Matarukaja","Temporarily increase attack rate for all allies. ",
                Affinity.NONE, DamageType.NONE, SpellLevel.MA_ONE_STAR, null,null,
                24,null));
        spellList.add(new Spell("Rakukaja","Temporarily increase defense for one ally.  ",
                Affinity.NONE, DamageType.NONE, SpellLevel.ONE_STAR, null,null,
                12,null));
        spellList.add(new Spell("Marakukaja","Temporarily increase defense rate for all allies.",
                Affinity.NONE, DamageType.NONE, SpellLevel.MA_ONE_STAR, null,null,
                24,null));
        spellList.add(new Spell("Sukukaja","Temporarily increase speed for one ally. ",
                Affinity.NONE, DamageType.NONE, SpellLevel.ONE_STAR, null,null,
                12,null));
        spellList.add(new Spell("Masukukaja","Temporarily increase speed for all allies.  ",
                Affinity.NONE, DamageType.NONE, SpellLevel.MA_ONE_STAR, null,null,
                24,null));
        spellList.add(new Spell("Heat Riser",
                "Increase attack, defense and speed rate of 1 ally for a certain period of time.",
                Affinity.NONE, DamageType.NONE, SpellLevel.ONE_STAR, null,null,
                36,null));
        spellList.add(new Spell("Dekaja","Removes all stat buffs for all foes.",
                Affinity.NONE, DamageType.NONE, SpellLevel.ONE_STAR, null,null,
                6,null));
        spellList.add(new Spell("Debilitate",
                "Temporarily decrease ATK/DEF and Speed rate for an area of foes.",
                Affinity.NONE, DamageType.NONE, SpellLevel.ONE_STAR, null,null,
                35,null));
        spellList.add(new Spell("Concentrate","Next magical attack deals double the damage.",
                Affinity.NONE, DamageType.NONE, SpellLevel.ONE_STAR, null,null,
                26,null));
        spellList.add(new Spell("Charge","Next physical attack deals double the damage.",
                Affinity.NONE, DamageType.NONE, SpellLevel.ONE_STAR, null,null,
                26,null));
        spellList.add(new Spell("Tarunda","Temporarily decrease attack for an area of foes ",
                Affinity.NONE, DamageType.NONE, SpellLevel.ONE_STAR, null,null,
                12,null));
        spellList.add(new Spell("Matarunda",
                "Decrease attack power of foes in a wide range for a certain period of time.",
                Affinity.NONE, DamageType.NONE, SpellLevel.ONE_STAR, null,null,
                24,null));
        spellList.add(new Spell("Rakunda","Temporarily decrease defense for an area of foes. ",
                Affinity.NONE, DamageType.NONE, SpellLevel.ONE_STAR, null,null,
                12,null));
        spellList.add(new Spell("Marakunda",
                "Decrease defense of foes in a wide range for a certain period of time.",
                Affinity.NONE, DamageType.NONE, SpellLevel.ONE_STAR, null,null,
                24,null));
        spellList.add(new Spell("Sukunda","Temporarily decrease speed rate for an area of foes.",
                Affinity.NONE, DamageType.NONE, SpellLevel.ONE_STAR, null,null,
                12,null));
        spellList.add(new Spell("Masukunda",
                "Decrease agility of foes in a wide range for a certain period of time.",
                Affinity.NONE, DamageType.NONE, SpellLevel.ONE_STAR, null,null,
                24,null));
        spellList.add(new Spell("Tetraja","A barrier that nullifies an insta-kill once for one ally.",
                Affinity.NONE, DamageType.NONE, SpellLevel.ONE_STAR, null,null,
                6,null));
        spellList.add(new Spell("Dekunda","Removes all stat debuffs for all allies.",
                Affinity.NONE, DamageType.NONE, SpellLevel.ONE_STAR, null,null,
                6,null));
        //endregion
        //region PHYSICAL
        spellList.add(new PhysicalSpell("Lunge","Light Physical damage to a narrow range of foes.",Affinity.PHYSICAL,DamageType.LIGHT,SpellLevel.MA_ONE_STAR,null,null,null,0.1f,RangeType.NARROW));
        spellList.add(new PhysicalSpell("Cleave","Light Physical damage to a narrow range of foes with Medium chance of Critical.",Affinity.PHYSICAL,DamageType.LIGHT,SpellLevel.MA_ONE_STAR,null,null,null,0.1f,RangeType.NARROW));
        spellList.add(new PhysicalSpell("Giant Slice","Medium Physical damage to a narrow range of foes.",Affinity.PHYSICAL,DamageType.MEDIUM,SpellLevel.MA_ONE_STAR,null,null,null,0.15f,RangeType.NARROW));
        spellList.add(new PhysicalSpell("Assault Dive","Heavy Physical damage to a narrow range of foes.",Affinity.PHYSICAL,DamageType.HEAVY,SpellLevel.MA_ONE_STAR,null,null,null,0.15f,RangeType.NARROW));
        spellList.add(new PhysicalSpell("Megaton Raid","Severe Physical damage to a narrow range of foes.",Affinity.PHYSICAL,DamageType.SEVERE,SpellLevel.MA_ONE_STAR,null,null,null,0.24f,RangeType.NARROW));
        spellList.add(new PhysicalSpell("God's Hand","Colossal Physical damage to a narrow range of foes.",Affinity.PHYSICAL,DamageType.COLOSSAL,SpellLevel.MA_ONE_STAR,null,null,null,0.25f,RangeType.NARROW));
        spellList.add(new PhysicalSpell("Brave Blade","Heavy Physical damage to a narrow range of foes with High chance of Critical.",Affinity.PHYSICAL,DamageType.HEAVY,SpellLevel.MA_ONE_STAR,null,null,null,0.2f,RangeType.NARROW));
        spellList.add(new PhysicalSpell("Sword Dance","Severe Physical damage to a narrow range of foes with High chance of Critical.",Affinity.PHYSICAL,DamageType.SEVERE,SpellLevel.MA_ONE_STAR,null,null,null,0.25f,RangeType.NARROW));
        spellList.add(new PhysicalSpell("Double Fangs","Medium Physical damage to a narrow range of foes with Medium chance of Critical.",Affinity.PHYSICAL,DamageType.MEDIUM,SpellLevel.MA_ONE_STAR,null,null,null,0.12f,RangeType.NARROW));
        spellList.add(new PhysicalSpell("Dream Needle","Light Physical damage to a narrow range of foes with Medium chance of Sleep.",Affinity.PHYSICAL,DamageType.LIGHT,SpellLevel.MA_ONE_STAR,null,null,null,0.1f,RangeType.NARROW));
        spellList.add(new PhysicalSpell("Terror Claw","Light Physical damage to a narrow range of foes with Medium chance of Fear.",Affinity.PHYSICAL,DamageType.LIGHT,SpellLevel.MA_ONE_STAR,null,null,null,0.1f,RangeType.NARROW));
        spellList.add(new PhysicalSpell("Headbutt","Light Physical damage to a narrow range of foes with Medium chance of Forget.",Affinity.PHYSICAL,DamageType.LIGHT,SpellLevel.MA_ONE_STAR,null,null,null,0.1f,RangeType.NARROW));
        spellList.add(new PhysicalSpell("Vorpal Blade","Severe Physical damage to a narrow range of foes with Medium chance of Critical.",Affinity.PHYSICAL,DamageType.SEVERE,SpellLevel.MA_ONE_STAR,null,null,null,0.18f,RangeType.NARROW));
        spellList.add(new PhysicalSpell("Hysterical Slap","Medium Physical damage to a narrow range of foes with Medium chance of Rage.",Affinity.PHYSICAL,DamageType.MEDIUM,SpellLevel.MA_ONE_STAR,null,null,null,0.1f,RangeType.NARROW));
        spellList.add(new PhysicalSpell("Brain Shake","Medium Physical damage to a narrow range of foes with Medium chance of Brainwash.",Affinity.PHYSICAL,DamageType.MEDIUM,SpellLevel.MA_ONE_STAR,null,null,null,0.1f,RangeType.NARROW));
        spellList.add(new PhysicalSpell("Sledgehammer","Medium Physical damage to a narrow range of foes with Medium chance of Dizzy.",Affinity.PHYSICAL,DamageType.MEDIUM,SpellLevel.MA_ONE_STAR,null,null,null,0.1f,RangeType.NARROW));
        spellList.add(new PhysicalSpell("Miracle Punch","Heavy Physical damage to a narrow range of foes. High chance of Critical.",Affinity.PHYSICAL,DamageType.HEAVY,SpellLevel.MA_ONE_STAR,null,null,null,0.2f,RangeType.NARROW));
        spellList.add(new PhysicalSpell("Vajra Blast","Medium Physical damage to wide range of foes.",Affinity.PHYSICAL,DamageType.MEDIUM,SpellLevel.MA_ONE_STAR,null,null,null,0.12f,RangeType.WIDE));
        spellList.add(new PhysicalSpell("Vicious Strike","Light Physical damage to wide range of foes with Medium chance of Critical hit.",Affinity.PHYSICAL,DamageType.LIGHT,SpellLevel.MA_ONE_STAR,null,null,null,0.12f,RangeType.WIDE));
        spellList.add(new PhysicalSpell("Heat Wave","Heavy Physical damage to wide range of foes with High chance of Critical hit.",Affinity.PHYSICAL,DamageType.HEAVY,SpellLevel.MA_ONE_STAR,null,null,null,0.18f,RangeType.WIDE));
        spellList.add(new PhysicalSpell("Tempest Slash","Heavy Physical damage to wide range Foes with high chance of Critical hit.",Affinity.PHYSICAL,DamageType.HEAVY,SpellLevel.MA_ONE_STAR,null,null,null,0.17f,RangeType.WIDE));
        spellList.add(new PhysicalSpell("Gigantomachia","Severe Physical damage to wide range Foes with high chance of Critical hit.",Affinity.PHYSICAL,DamageType.SEVERE,SpellLevel.MA_ONE_STAR,null,null,null,0.24f,RangeType.WIDE));
        spellList.add(new PhysicalSpell("Deathbound","Severe Physical damage to wide range Foes with medium chance of Critical hit.",Affinity.PHYSICAL,DamageType.SEVERE,SpellLevel.MA_ONE_STAR,null,null,null,0.24f,RangeType.WIDE));
        spellList.add(new PhysicalSpell("Rampage","Medium Physical damage to a wide range Foes",Affinity.PHYSICAL,DamageType.MEDIUM,SpellLevel.MA_ONE_STAR,null,null,null,0.12f,RangeType.WIDE));
        spellList.add(new PhysicalSpell("Agneyastra","Colossal Physical damage to wide range Foes with high chance of Critical",Affinity.PHYSICAL,DamageType.COLOSSAL,SpellLevel.MA_ONE_STAR,null,null,null,0.24f,RangeType.WIDE));
        spellList.add(new PhysicalSpell("Swift Strike","Heavy Physical damage to wide range of Foes",Affinity.PHYSICAL,DamageType.HEAVY,SpellLevel.MA_ONE_STAR,null,null,null,0.18f,RangeType.WIDE));
        spellList.add(new PhysicalSpell("Myriad Slashes","Severe Physical damage to a wide area of foes with high chance of Critical",Affinity.PHYSICAL,DamageType.SEVERE,SpellLevel.MA_ONE_STAR,null,null,null,0.24f,RangeType.WIDE));
        spellList.add(new PhysicalSpell("Hassou Tobi","Colossal Physical damage to a wide area of foes with high chance of Critical. ",Affinity.PHYSICAL,DamageType.COLOSSAL,SpellLevel.MA_ONE_STAR,null,null,null,0.3f,RangeType.WIDE));
        spellList.add(new PhysicalSpell("Memory Blow","Light Physical damage to a wide range of foes with Medium chance of Forget.",Affinity.PHYSICAL,DamageType.LIGHT,SpellLevel.MA_ONE_STAR,null,null,null,0.12f,RangeType.WIDE));
        spellList.add(new PhysicalSpell("Dormin Rush","Medium Physical damage to a wide range of foes with Medium chance of Sleep.",Affinity.PHYSICAL,DamageType.MEDIUM,SpellLevel.MA_ONE_STAR,null,null,null,0.12f,RangeType.WIDE));
        spellList.add(new PhysicalSpell("Oni-Kagura","Medium Physical damage to a wide range of foes with Medium chance of Rage.",Affinity.PHYSICAL,DamageType.MEDIUM,SpellLevel.MA_ONE_STAR,null,null,null,0.16f,RangeType.WIDE));
        spellList.add(new PhysicalSpell("Flash Bomb","Medium Physical damage to a wide range of foes with Medium chance of Dizzy.",Affinity.PHYSICAL,DamageType.MEDIUM,SpellLevel.MA_ONE_STAR,null,null,null,0.12f,RangeType.WIDE));
        spellList.add(new PhysicalSpell("Bloodbath","Medium Physical damage to a wide range of foes with Medium chance of Fear.",Affinity.PHYSICAL,DamageType.MEDIUM,SpellLevel.MA_ONE_STAR,null,null,null,0.12f,RangeType.WIDE));
        spellList.add(new PhysicalSpell("Brain Buster","Heavy Physical damage to a wide range of foes with Medium chance of Brainwash.",Affinity.PHYSICAL,DamageType.HEAVY,SpellLevel.MA_ONE_STAR,null,null,null,0.12f,RangeType.WIDE));        //endregion
        //region GUN
        spellList.add(new PhysicalSpell("Snap","Light Gun damage to a narrow range.",Affinity.GUN,DamageType.LIGHT,SpellLevel.MA_ONE_STAR,null,null,null,0.16f,RangeType.NARROW));
        spellList.add(new PhysicalSpell("One-shot Kill","Heavy Gun damage to a narrow range with very high chance of Critical.",Affinity.GUN,DamageType.HEAVY,SpellLevel.MA_ONE_STAR,null,null,null,0.3f,RangeType.NARROW));
        spellList.add(new PhysicalSpell("Triple Down","Heavy Gun damage to wide range of foes with high change of Critical.",Affinity.GUN,DamageType.HEAVY,SpellLevel.MA_ONE_STAR,null,null,null,0.24f,RangeType.WIDE));
        spellList.add(new PhysicalSpell("Riot Gun","Severe Gun damage to a wide area of foes with high change of Critical.",Affinity.GUN,DamageType.SEVERE,SpellLevel.MA_ONE_STAR,null,null,null,0.4f,RangeType.WIDE));        //endregion

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
