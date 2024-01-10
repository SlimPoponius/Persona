package net.slimpopo.personamod.item;

import com.sun.jna.Memory;
import net.minecraft.world.entity.ai.Brain;
import net.minecraft.world.entity.monster.Giant;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.slimpopo.personamod.PersonaMod;
import net.slimpopo.personamod.entity.ModEntities;
import net.slimpopo.personamod.item.constants.card.ArcanaCardItem;
import net.slimpopo.personamod.item.constants.card.PersonaCardItem;
import net.slimpopo.personamod.item.constants.card.SkillCardItem;
import net.slimpopo.personamod.item.constants.card.StatCardItem;
import net.slimpopo.personamod.item.custom.spells.almighty.MegidoItem;
import net.slimpopo.personamod.item.custom.spells.almighty.MegidolaItem;
import net.slimpopo.personamod.item.custom.spells.almighty.MegidolaonItem;
import net.slimpopo.personamod.item.custom.spells.bless.*;
import net.slimpopo.personamod.item.custom.spells.bless.instakill.HamaItem;
import net.slimpopo.personamod.item.custom.spells.bless.instakill.HamaonItem;
import net.slimpopo.personamod.item.custom.spells.bless.instakill.MahamaItem;
import net.slimpopo.personamod.item.custom.spells.bless.instakill.MahamaonItem;
import net.slimpopo.personamod.item.custom.spells.curse.*;
import net.slimpopo.personamod.item.custom.spells.curse.instakill.MamudoItem;
import net.slimpopo.personamod.item.custom.spells.curse.instakill.MamudoonItem;
import net.slimpopo.personamod.item.custom.spells.curse.instakill.MudoItem;
import net.slimpopo.personamod.item.custom.spells.curse.instakill.MudoonItem;
import net.slimpopo.personamod.item.custom.spells.electricity.*;
import net.slimpopo.personamod.item.custom.spells.fire.*;
import net.slimpopo.personamod.item.custom.spells.gun.OneShotKillItem;
import net.slimpopo.personamod.item.custom.spells.gun.RiotGunItem;
import net.slimpopo.personamod.item.custom.spells.gun.SnapItem;
import net.slimpopo.personamod.item.custom.spells.gun.TripleDownItem;
import net.slimpopo.personamod.item.custom.spells.ice.*;
import net.slimpopo.personamod.item.custom.spells.nuke.*;
import net.slimpopo.personamod.item.custom.spells.physical.*;
import net.slimpopo.personamod.item.custom.spells.psy.*;
import net.slimpopo.personamod.item.custom.spells.support.negative.*;
import net.slimpopo.personamod.item.custom.spells.support.positive.*;
import net.slimpopo.personamod.item.custom.spells.wind.*;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, PersonaMod.MOD_ID);

    //PERSONA SKILLS
    //region AGI SPELLS
    public static final RegistryObject<AgiItem> AGI = ITEMS.register("agi",
            () -> new AgiItem(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<AgilaoItem> AGILAO = ITEMS.register("agilao",
            () -> new AgilaoItem(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<AgidyneItem> AGIDYNE = ITEMS.register("agidyne",
            () -> new AgidyneItem(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<MaragiItem> MARAGI = ITEMS.register("maragi",
            () -> new MaragiItem(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<MaragionItem> MARAGION = ITEMS.register("maragion",
            () -> new MaragionItem(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<MaragidyneItem> MARAGIDYNE = ITEMS.register("maragidyne",
            () -> new MaragidyneItem(new Item.Properties().stacksTo(1)));
    //endregion
    //region BUFU SPELLS
    public static final RegistryObject<BufuItem> BUFU = ITEMS.register("bufu",
            () -> new BufuItem(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<BufulaItem> BUFULA = ITEMS.register("bufula",
            () -> new BufulaItem(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<BufudyneItem> BUFUDYNE = ITEMS.register("bufudyne",
            () -> new BufudyneItem(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<MabufuItem> MABUFU = ITEMS.register("mabufu",
            () -> new MabufuItem(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<MabufulaItem> MABUFULA = ITEMS.register("mabufula",
            () -> new MabufulaItem(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<MabufudyneItem> MABUFUDYNE = ITEMS.register("mabufudyne",
            () -> new MabufudyneItem(new Item.Properties().stacksTo(1)));
    //endregion
    //region GARU
    public static final RegistryObject<GaruItem> GARU = ITEMS.register("garu",
            () -> new GaruItem(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<GarulaItem> GARULA = ITEMS.register("garula",
            () -> new GarulaItem(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<GarudyneItem> GARUDYNE = ITEMS.register("garudyne",
            () -> new GarudyneItem(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<MagaruItem> MAGARU = ITEMS.register("magaru",
            () -> new MagaruItem(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<MagarulaItem> MAGARULA = ITEMS.register("magarula",
            () -> new MagarulaItem(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<MagarudyneItem> MAGARUDYNE = ITEMS.register("magarudyne",
            () -> new MagarudyneItem(new Item.Properties().stacksTo(1)));
    //endregion
    //region ZIO
    public static final RegistryObject<ZioItem> ZIO = ITEMS.register("zio",
            () -> new ZioItem(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<ZiongaItem> ZIONGA = ITEMS.register("zionga",
            () -> new ZiongaItem(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<ZiodyneItem> ZIODYNE = ITEMS.register("ziodyne",
            () -> new ZiodyneItem(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<MazioItem> MAZIO = ITEMS.register("mazio",
            () -> new MazioItem(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<MaziongaItem> MAZIONGA= ITEMS.register("mazionga",
            () -> new MaziongaItem(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<MaziodyneItem> MAZIODYNE = ITEMS.register("maziodyne",
            () -> new MaziodyneItem(new Item.Properties().stacksTo(1)));
    //endregion
    //region FREI
    public static final RegistryObject<FreiItem> FREI = ITEMS.register("frei",
            () -> new FreiItem(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<FreilaItem> FREILA = ITEMS.register("freila",
            () -> new FreilaItem(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<FreidyneItem> FREIDYNE = ITEMS.register("freidyne",
            () -> new FreidyneItem(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<MafreiItem> MAFREI = ITEMS.register("mafrei",
            () -> new MafreiItem(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<MafreilaItem> MAFREILA = ITEMS.register("mafreila",
            () -> new MafreilaItem(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<MafreidyneItem> MAFREIDYNE = ITEMS.register("mafreidyne",
            () -> new MafreidyneItem(new Item.Properties().stacksTo(1)));
    //endregion
    //region PSI
    public static final RegistryObject<PsiItem> PSI = ITEMS.register("psi",
            () -> new PsiItem(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<PsioItem> PSIO = ITEMS.register("psio",
            () -> new PsioItem(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<PsiodyneItem> PSIODYNE = ITEMS.register("psiodyne",
            () -> new PsiodyneItem(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<MapsiItem> MAPSI = ITEMS.register("mapsi",
            () -> new MapsiItem(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<MapsioItem> MAPSIO = ITEMS.register("mapsio",
            () -> new MapsioItem(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<MapsiodyneItem> MAPSIODYNE = ITEMS.register("mapsiodyne",
            () -> new MapsiodyneItem(new Item.Properties().stacksTo(1)));
    //endregion
    //region CURSE
    public static final RegistryObject<MudoItem> MUDO = ITEMS.register("mudo",
            () -> new MudoItem(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<MamudoItem> MAMUDO = ITEMS.register("mamudo",
            () -> new MamudoItem(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<MudoonItem> MUDOON = ITEMS.register("mudoon",
            () -> new MudoonItem(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<MamudoonItem> MAMUDOON = ITEMS.register("mamudoon",
            () -> new MamudoonItem(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<EihaItem> EIHA = ITEMS.register("eiha",
            () -> new EihaItem(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<EigaItem> EIGA = ITEMS.register("eiga",
            () -> new EigaItem(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<EigaonItem> EIGAON = ITEMS.register("eigaon",
            () -> new EigaonItem(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<MaeihaItem> MAEIHA = ITEMS.register("maeiha",
            () -> new MaeihaItem(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<MaeigaItem> MAEIGA = ITEMS.register("maeiga",
            () -> new MaeigaItem(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<MaeigaonItem> MAEIGAON = ITEMS.register("maeigaon",
            () -> new MaeigaonItem(new Item.Properties().stacksTo(1)));
    //endregion
    //region BLESS
    public static final RegistryObject<HamaItem> HAMA = ITEMS.register("hama",
            () -> new HamaItem(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<HamaonItem> HAMAON = ITEMS.register("hamaon",
            () -> new HamaonItem(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<MahamaItem> MAHAMA = ITEMS.register("mahama",
            () -> new MahamaItem(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<MahamaonItem> MAHAMAON = ITEMS.register("mahamaon",
            () -> new MahamaonItem(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<KouhaItem> KOUHA = ITEMS.register("kouha",
            () -> new KouhaItem(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<KougaItem> KOUGA = ITEMS.register("kouga",
            () -> new KougaItem(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<KougaonItem> KOUGAON = ITEMS.register("kougaon",
            () -> new KougaonItem(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<MakouhaItem> MAKOUHA = ITEMS.register("makouha",
            () -> new MakouhaItem(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<MakougaItem> MAKOUGA = ITEMS.register("makouga",
            () -> new MakougaItem(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<MakougaonItem> MAKOUGAON = ITEMS.register("makougaon",
            () -> new MakougaonItem(new Item.Properties().stacksTo(1)));
    //endregion
    //region ALMIGHTY
    public static final RegistryObject<MegidoItem> MEGIDO = ITEMS.register("megido",
            () -> new MegidoItem(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<MegidolaItem> MEGIDOLA = ITEMS.register("megidola",
            () -> new MegidolaItem(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<MegidolaonItem> MEGIDOLAON = ITEMS.register("megidolaon",
            () -> new MegidolaonItem(new Item.Properties().stacksTo(1)));
    //endregion
    //region PHYSICAL
    public static final RegistryObject<LungeItem>LUNGE = ITEMS.register("lunge",
            () -> new LungeItem(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<CleaveItem>CLEAVE = ITEMS.register("cleave",
            () -> new CleaveItem(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<GiantSliceItem>GIANTSLICE = ITEMS.register("giantslice",
            () -> new GiantSliceItem(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<AssaultDiveItem>ASSAULTDIVE = ITEMS.register("assaultdive",
            () -> new AssaultDiveItem(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<MegatonRaidItem>MEGATONRAID = ITEMS.register("megatonraid",
            () -> new MegatonRaidItem(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<GodsHandItem>GODSHAND = ITEMS.register("godshand",
            () -> new GodsHandItem(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<BraveBladeItem>BRAVEBLADE = ITEMS.register("braveblade",
            () -> new BraveBladeItem(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<SwordDanceItem>SWORDDANCE = ITEMS.register("sworddance",
            () -> new SwordDanceItem(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<DoubleFangItem>DOUBLEFANGS = ITEMS.register("doublefangs",
            () -> new DoubleFangItem(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<DreamNeedleItem>DREAMNEEDLE = ITEMS.register("dreamneedle",
            () -> new DreamNeedleItem(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<TerrorClawItem>TERRORCLAW = ITEMS.register("terrorclaw",
            () -> new TerrorClawItem(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<HeadbuttItem>HEADBUTT = ITEMS.register("headbutt",
            () -> new HeadbuttItem(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<VorpalBladeItem>VORPALBLADE = ITEMS.register("vorpalblade",
            () -> new VorpalBladeItem(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<HystericalSlapItem>HYSTERICALSLAP = ITEMS.register("hystericalslap",
            () -> new HystericalSlapItem(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<BrainShakeItem>BRAINSHAKE = ITEMS.register("brainshake",
            () -> new BrainShakeItem(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<SledgehammerItem>SLEDGEHAMMER = ITEMS.register("sledgehammer",
            () -> new SledgehammerItem(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<MiraclePunchItem>MIRACLEPUNCH = ITEMS.register("miraclepunch",
            () -> new MiraclePunchItem(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<VajraBlastItem>VAJRABLAST = ITEMS.register("vajrablast",
            () -> new VajraBlastItem(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<ViciousStrikeItem>VICIOUSSTRIKE = ITEMS.register("viciousstrike",
            () -> new ViciousStrikeItem(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<HeatWaveItem>HEATWAVE = ITEMS.register("heatwave",
            () -> new HeatWaveItem(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<TempestSlashItem>TEMPESTSLASH = ITEMS.register("tempestslash",
            () -> new TempestSlashItem(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<GigantomachiaItem>GIGANTOMACHIA = ITEMS.register("gigantomachia",
            () -> new GigantomachiaItem(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<DeathboundItem>DEATHBOUND = ITEMS.register("deathbound",
            () -> new DeathboundItem(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<RampageItem>RAMPAGE = ITEMS.register("rampage",
            () -> new RampageItem(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<AgneyastraItem>AGNEYASTRA = ITEMS.register("agneyastra",
            () -> new AgneyastraItem(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<SwiftStrikeItem>SWIFTSTRIKE = ITEMS.register("swiftstrike",
            () -> new SwiftStrikeItem(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<MyriadSlashesItem>MYRIADSLASHES = ITEMS.register("myriadslashes",
            () -> new MyriadSlashesItem(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<HassouTobiItem>HASSOUTOBI = ITEMS.register("hassoutobi",
            () -> new HassouTobiItem(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<MemoryBlowItem>MEMORYBLOW = ITEMS.register("memoryblow",
            () -> new MemoryBlowItem(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<DorminRushItem>DORMINRUSH = ITEMS.register("dorminrush",
            () -> new DorminRushItem(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<OniKaguraItem> ONIKAGURA = ITEMS.register("oni-kagura",
            () -> new OniKaguraItem(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<FlashBombItem>FLASHBOMB = ITEMS.register("flashbomb",
            () -> new FlashBombItem(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<BloodbathItem>BLOODBATH = ITEMS.register("bloodbath",
            () -> new BloodbathItem(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<BrainBusterItem>BRAINBUSTER = ITEMS.register("brainbuster",
            () -> new BrainBusterItem(new Item.Properties().stacksTo(1)));
    //endregion
    //region GUN
    public static final RegistryObject<SnapItem>SNAP = ITEMS.register("snap",
            () -> new SnapItem(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<OneShotKillItem> ONESHOTKILL = ITEMS.register("oneshotkill",
            () -> new OneShotKillItem(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<TripleDownItem>TRIPLEDOWN = ITEMS.register("tripledown",
            () -> new TripleDownItem(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<RiotGunItem>RIOTGUN = ITEMS.register("riotgun",
            () -> new RiotGunItem(new Item.Properties().stacksTo(1)));
    //endregion
    //region SUPPORT - POSITIVE
    public static final RegistryObject<TarukajaItem> TARUKAJA = ITEMS.register("tarukaja",
            () -> new TarukajaItem(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<MatarukajaItem> MATARUKAJA = ITEMS.register("matarukaja",
            () -> new MatarukajaItem(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<RakukajaItem> RAKUKAJA = ITEMS.register("rakukaja",
            () -> new RakukajaItem(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<MarakukajaItem> MARAKUKAJA = ITEMS.register("marakukaja",
            () -> new MarakukajaItem(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<SukukajaItem> SUKUKAJA = ITEMS.register("sukukaja",
            () -> new SukukajaItem(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<MasukukajaItem> MASUKUKAJA = ITEMS.register("masukukaja",
            () -> new MasukukajaItem(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<HeatRiserItem> HEATRISER = ITEMS.register("heatriser",
            () -> new HeatRiserItem(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<ChargeItem> CHARGE = ITEMS.register("charge",
            () -> new ChargeItem(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<ConcentrateItem> CONCENTRATE = ITEMS.register("concentrate",
            () -> new ConcentrateItem(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<TetrajaItem> TETRAJA = ITEMS.register("tetraja",
            () -> new TetrajaItem(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<DekajaItem> DEKAJA = ITEMS.register("dekaja",
            () -> new DekajaItem(new Item.Properties().stacksTo(1)));
    //endregion
    //region SUPPORT - NEGATIVE
    public static final RegistryObject<TarundaItem> TARUNDA = ITEMS.register("tarunda",
            () -> new TarundaItem(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<MatarundaItem> MATARUNDA = ITEMS.register("matarunda",
            () -> new MatarundaItem(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<RakundaItem> RAKUNDA = ITEMS.register("rakunda",
            () -> new RakundaItem(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<MarakundaItem> MARAKUNDA = ITEMS.register("marakunda",
            () -> new MarakundaItem(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<SukundaItem> SUKUNDA = ITEMS.register("sukunda",
            () -> new SukundaItem(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<MasukundaItem> MASUKUNDA = ITEMS.register("masukunda",
            () -> new MasukundaItem(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<DebilitateItem> DEBILITATE = ITEMS.register("debilitate",
            () -> new DebilitateItem(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<DekundaItem> DEKUNDA = ITEMS.register("dekunda",
            () -> new DekundaItem(new Item.Properties().stacksTo(1)));
    //endregion
    //region THROWABLE ITEMS
    public static final RegistryObject<Item> FLAMETHROWABLE = ITEMS.register("flamethrowable",
            () -> new Item(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> MAFLAMETHROWABLE = ITEMS.register("maflamethrowable",
            () -> new Item(new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> WINDTHROWABLE = ITEMS.register("windthrowable",
            () -> new Item(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> MAWINDTHROWABLE = ITEMS.register("mawindthrowable",
            () -> new Item(new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> ICETHROWABLE = ITEMS.register("icethrowable",
            () -> new Item(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> MAICETHROWABLE = ITEMS.register("maicethrowable",
            () -> new Item(new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> ELECTRICTHROWABLE = ITEMS.register("electricthrowable",
            () -> new Item(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> MAELECTRICTHROWABLE = ITEMS.register("maelectricthrowable",
            () -> new Item(new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> NUKETHROWABLE = ITEMS.register("nukethrowable",
            () -> new Item(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> MANUKETHROWABLE = ITEMS.register("manukethrowable",
            () -> new Item(new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> PSITHROWABLE = ITEMS.register("psithrowable",
            () -> new Item(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> MAPSITHROWABLE = ITEMS.register("mpsithrowable",
            () -> new Item(new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> CURSETHROWABLE = ITEMS.register("cursethrowable",
            () -> new Item(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> MACURSETHROWABLE = ITEMS.register("macursethrowable",
            () -> new Item(new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> BLESSTHROWABLE = ITEMS.register("blessthrowable",
            () -> new Item(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> MABLESSTHROWABLE = ITEMS.register("mablessthrowable",
            () -> new Item(new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> ALMIGHTYTHROWABLE = ITEMS.register("almightythrowable",
            () -> new Item(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> MAALMIGHTYTHROWABLE = ITEMS.register("maalmightythrowable",
            () -> new Item(new Item.Properties().stacksTo(1)));
    //endregion
    //region ARCANA CARDS
    public static final RegistryObject<SkillCardItem> SKILLCARD = ITEMS.register("skillcard",
            () -> new SkillCardItem(new Item.Properties().stacksTo(1).durability(1)));
    public static final RegistryObject<StatCardItem> STATCARD = ITEMS.register("statcard",
            () -> new StatCardItem(new Item.Properties().stacksTo(1).durability(1)));
    public static final RegistryObject<PersonaCardItem> PERSONACARD = ITEMS.register("personacard",
            () -> new PersonaCardItem(new Item.Properties().stacksTo(1).durability(1)));
    public static final RegistryObject<ArcanaCardItem> ARCANACARD = ITEMS.register("arcanacard",
            () -> new ArcanaCardItem(new Item.Properties().stacksTo(1).durability(1)));
    //endregion
    //region SPAWN
    public static final RegistryObject<Item> PYRO_JACK_SPAWN_EGG = ITEMS.register("pyro_jack_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntities.PYRO_JACK,0xda9113,0x0d426b,
                    new Item.Properties()));
    public static final RegistryObject<Item> JACK_FROST_SPAWN_EGG = ITEMS.register("jack_frost_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntities.JACK_FROST,0xFFFFFF,0x00008b,
                    new Item.Properties()));
    public static final RegistryObject<Item> BLACK_FROST_SPAWN_EGG = ITEMS.register("black_frost_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntities.BLACK_FROST,0x222021,0x330066,
                    new Item.Properties()));
    //endregion
    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
