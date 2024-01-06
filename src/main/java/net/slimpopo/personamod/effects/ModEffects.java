package net.slimpopo.personamod.effects;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.slimpopo.personamod.PersonaMod;
import net.slimpopo.personamod.effects.custom.*;
import net.slimpopo.personamod.effects.custom.support.defense.*;
import net.slimpopo.personamod.effects.custom.support.defense.NullBless;
import net.slimpopo.personamod.effects.custom.support.defense.NullCurse;
import net.slimpopo.personamod.effects.custom.support.defense.NullElec;
import net.slimpopo.personamod.effects.custom.support.defense.NullFire;
import net.slimpopo.personamod.effects.custom.support.defense.NullIce;
import net.slimpopo.personamod.effects.custom.support.defense.NullNuke;
import net.slimpopo.personamod.effects.custom.support.defense.NullPsy;
import net.slimpopo.personamod.effects.custom.support.defense.NullWind;
import net.slimpopo.personamod.effects.custom.support.defense.drain.*;
import net.slimpopo.personamod.effects.custom.support.defense.repel.*;
import net.slimpopo.personamod.effects.custom.support.defense.resist.*;
import net.slimpopo.personamod.effects.custom.support.offense.AttackDownEffect;
import net.slimpopo.personamod.effects.custom.support.offense.AttackUpEffect;
import net.slimpopo.personamod.effects.custom.support.offense.DefenseDownEffect;
import net.slimpopo.personamod.effects.custom.support.offense.DefenseUpEffect;


public class ModEffects {
    public static final DeferredRegister<MobEffect> MOB_EFFECTS =
            DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, PersonaMod.MOD_ID);

    public static final RegistryObject<FreezeEffect> FREEZE = MOB_EFFECTS.register("freeze",
            () -> new FreezeEffect(MobEffectCategory.HARMFUL,0x99FFFF));

    public static final RegistryObject<ShockEffect> SHOCK = MOB_EFFECTS.register("shock",
            () -> new ShockEffect(MobEffectCategory.HARMFUL,0xFFFF00));

    public static final RegistryObject<BurnEffect> BURN = MOB_EFFECTS.register("burn",
            () -> new BurnEffect(MobEffectCategory.HARMFUL,0xFF0000));

    public static final RegistryObject<ConfuseEffect> CONFUSE = MOB_EFFECTS.register("confuse",
            () -> new ConfuseEffect(MobEffectCategory.HARMFUL,0xFFB6C1));

    public static final RegistryObject<DespairEffect> DESPAIR = MOB_EFFECTS.register("despair",
            () -> new DespairEffect(MobEffectCategory.HARMFUL,0x301934));

    public static final RegistryObject<FearEffect> FEAR = MOB_EFFECTS.register("fear",
            () -> new FearEffect(MobEffectCategory.HARMFUL,0xAA336A));

    public static final RegistryObject<DizzyEffect> DIZZY = MOB_EFFECTS.register("dizzy",
            () -> new DizzyEffect(MobEffectCategory.HARMFUL,0xFFFFED));

    public static final RegistryObject<RageEffect> RAGE = MOB_EFFECTS.register("rage",
            () -> new RageEffect(MobEffectCategory.HARMFUL,0xFFFFED));

    //ICE
    public static final RegistryObject<ResistIce> RESIST_ICE = MOB_EFFECTS.register("resist_ice",
            () -> new ResistIce(MobEffectCategory.BENEFICIAL,0x99FFFF));

    public static final RegistryObject<RepelIce> REPEL_ICE = MOB_EFFECTS.register("repel_ice",
            () -> new RepelIce(MobEffectCategory.BENEFICIAL,0x99FFFF));

    public static final RegistryObject<NullIce> NULL_ICE = MOB_EFFECTS.register("null_ice",
            () -> new NullIce(MobEffectCategory.BENEFICIAL,0x99FFFF));

    public static final RegistryObject<DrainIce> DRAIN_ICE = MOB_EFFECTS.register("drain_ice",
            () -> new DrainIce(MobEffectCategory.BENEFICIAL,0x99FFFF));

    //WIND
    public static final RegistryObject<ResistWind> RESIST_WIND = MOB_EFFECTS.register("resist_wind",
            () -> new ResistWind(MobEffectCategory.BENEFICIAL,0x32CD32));

    public static final RegistryObject<RepelWind> REPEL_WIND = MOB_EFFECTS.register("repel_wind",
            () -> new RepelWind(MobEffectCategory.BENEFICIAL,0x32CD32));

    public static final RegistryObject<NullWind> NULL_WIND = MOB_EFFECTS.register("null_wind",
            () -> new NullWind(MobEffectCategory.BENEFICIAL,0x32CD32));

    public static final RegistryObject<DrainWind> DRAIN_WIND = MOB_EFFECTS.register("drain_wind",
            () -> new DrainWind(MobEffectCategory.BENEFICIAL,0x32CD32));

    //Wind
    public static final RegistryObject<ResistFire> RESIST_FIRE = MOB_EFFECTS.register("resist_fire",
            () -> new ResistFire(MobEffectCategory.BENEFICIAL,0xFF0000));

    public static final RegistryObject<RepelFire> REPEL_FIRE = MOB_EFFECTS.register("repel_fire",
            () -> new RepelFire(MobEffectCategory.BENEFICIAL,0xFF0000));

    public static final RegistryObject<NullFire> NULL_FIRE = MOB_EFFECTS.register("null_fire",
            () -> new NullFire(MobEffectCategory.BENEFICIAL,0xFF0000));

    public static final RegistryObject<DrainFire> DRAIN_FIRE = MOB_EFFECTS.register("drain_fire",
            () -> new DrainFire(MobEffectCategory.BENEFICIAL,0xFF0000));

    //Elec
    public static final RegistryObject<ResistElec> RESIST_ELEC = MOB_EFFECTS.register("resist_elec",
            () -> new ResistElec(MobEffectCategory.BENEFICIAL,0xFFFF00));

    public static final RegistryObject<RepelElec> REPEL_ELEC = MOB_EFFECTS.register("repel_elec",
            () -> new RepelElec(MobEffectCategory.BENEFICIAL,0xFFFF00));

    public static final RegistryObject<NullElec> NULL_ELEC = MOB_EFFECTS.register("null_elec",
            () -> new NullElec(MobEffectCategory.BENEFICIAL,0xFFFF00));

    public static final RegistryObject<DrainElec> DRAIN_ELEC = MOB_EFFECTS.register("drain_elec",
            () -> new DrainElec(MobEffectCategory.BENEFICIAL,0xFFFF00));

    //Psy
    public static final RegistryObject<ResistPsy> RESIST_PSY = MOB_EFFECTS.register("resist_psy",
            () -> new ResistPsy(MobEffectCategory.BENEFICIAL,0xFF10F0));

    public static final RegistryObject<RepelPsy> REPEL_PSY = MOB_EFFECTS.register("repel_psy",
            () -> new RepelPsy(MobEffectCategory.BENEFICIAL,0xFF10F0));

    public static final RegistryObject<NullPsy> NULL_PSY = MOB_EFFECTS.register("null_psy",
            () -> new NullPsy(MobEffectCategory.BENEFICIAL,0xFF10F0));

    public static final RegistryObject<DrainPsy> DRAIN_PSY = MOB_EFFECTS.register("drain_psy",
            () -> new DrainPsy(MobEffectCategory.BENEFICIAL,0xFF10F0));

    //Nuke
    public static final RegistryObject<ResistNuke> RESIST_NUKE = MOB_EFFECTS.register("resist_nuke",
            () -> new ResistNuke(MobEffectCategory.BENEFICIAL,0x0CFFF4));

    public static final RegistryObject<RepelNuke> REPEL_NUKE = MOB_EFFECTS.register("repel_nuke",
            () -> new RepelNuke(MobEffectCategory.BENEFICIAL,0x0CFFF4));

    public static final RegistryObject<NullNuke> NULL_NUKE = MOB_EFFECTS.register("null_nuke",
            () -> new NullNuke(MobEffectCategory.BENEFICIAL,0x0CFFF4));

    public static final RegistryObject<DrainNuke> DRAIN_NUKE = MOB_EFFECTS.register("drain_nuke",
            () -> new DrainNuke(MobEffectCategory.BENEFICIAL,0x0CFFF4));

    //Curse
    public static final RegistryObject<ResistCurse> RESIST_CURSE = MOB_EFFECTS.register("resist_curse",
            () -> new ResistCurse(MobEffectCategory.BENEFICIAL,0x8B0000));

    public static final RegistryObject<RepelCurse> REPEL_CURSE = MOB_EFFECTS.register("repel_curse",
            () -> new RepelCurse(MobEffectCategory.BENEFICIAL,0x8B0000));

    public static final RegistryObject<NullCurse> NULL_CURSE = MOB_EFFECTS.register("null_curse",
            () -> new NullCurse(MobEffectCategory.BENEFICIAL,0x8B0000));

    public static final RegistryObject<DrainCurse> DRAIN_CURSE = MOB_EFFECTS.register("drain_curse",
            () -> new DrainCurse(MobEffectCategory.BENEFICIAL,0x8B0000));

    //Bless
    public static final RegistryObject<ResistBless> RESIST_BLESS = MOB_EFFECTS.register("resist_bless",
            () -> new ResistBless(MobEffectCategory.BENEFICIAL,0xFFFDD0));

    public static final RegistryObject<RepelBless> REPEL_BLESS = MOB_EFFECTS.register("repel_bless",
            () -> new RepelBless(MobEffectCategory.BENEFICIAL,0xFFFDD0));

    public static final RegistryObject<NullBless> NULL_BLESS = MOB_EFFECTS.register("null_bless",
            () -> new NullBless(MobEffectCategory.BENEFICIAL,0xFFFDD0));

    public static final RegistryObject<DrainBless> DRAIN_BLESS = MOB_EFFECTS.register("drain_bless",
            () -> new DrainBless(MobEffectCategory.BENEFICIAL,0xFFFDD0));


    public static final RegistryObject<AttackUpEffect> ATTACK_UP = MOB_EFFECTS.register("attack_up",
            () -> new AttackUpEffect(MobEffectCategory.BENEFICIAL,0xFFFDD0));
    public static final RegistryObject<DefenseUpEffect> DEFENSE_UP = MOB_EFFECTS.register("defense_up",
            () -> new DefenseUpEffect(MobEffectCategory.BENEFICIAL,0xFFFDD0));
    public static final RegistryObject<AttackDownEffect> ATTACK_DOWN = MOB_EFFECTS.register("attack_down",
            () -> new AttackDownEffect(MobEffectCategory.HARMFUL,0xFFFDD0));
    public static final RegistryObject<DefenseDownEffect> DEFENSE_DOWN = MOB_EFFECTS.register("defense_down",
            () -> new DefenseDownEffect(MobEffectCategory.HARMFUL,0xFFFDD0));

    public static void register(IEventBus eventBus){
        MOB_EFFECTS.register(eventBus);
    }

}
