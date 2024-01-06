package net.slimpopo.personamod.item;

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
import net.slimpopo.personamod.item.custom.spells.ice.*;
import net.slimpopo.personamod.item.custom.spells.nuke.*;
import net.slimpopo.personamod.item.custom.spells.psy.*;
import net.slimpopo.personamod.item.custom.spells.support.negative.*;
import net.slimpopo.personamod.item.custom.spells.support.positive.*;
import net.slimpopo.personamod.item.custom.spells.wind.*;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, PersonaMod.MOD_ID);

    //PERSONA SKILLS
    //AGI SPELLS
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

    //BUFU SPELLS
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

    //GARU
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

    //ZIO
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

    //FREI
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

    //PSI
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

    //CURSE
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

    //BLESS
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

    //ALMIGHTY
    public static final RegistryObject<MegidoItem> MEGIDO = ITEMS.register("megido",
            () -> new MegidoItem(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<MegidolaItem> MEGIDOLA = ITEMS.register("megidola",
            () -> new MegidolaItem(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<MegidolaonItem> MEGIDOLAON = ITEMS.register("megidolaon",
            () -> new MegidolaonItem(new Item.Properties().stacksTo(1)));


    //SUPPORT - POSITIVE
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

    //SUPPORT - NEGATIVE
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


    //THROWABLE ITEMS
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

    //ARCANA CARDS
    public static final RegistryObject<SkillCardItem> SKILLCARD = ITEMS.register("skillcard",
            () -> new SkillCardItem(new Item.Properties().stacksTo(1).durability(1)));
    public static final RegistryObject<StatCardItem> STATCARD = ITEMS.register("statcard",
            () -> new StatCardItem(new Item.Properties().stacksTo(1).durability(1)));
    public static final RegistryObject<PersonaCardItem> PERSONACARD = ITEMS.register("personacard",
            () -> new PersonaCardItem(new Item.Properties().stacksTo(1).durability(1)));
    public static final RegistryObject<ArcanaCardItem> ARCANACARD = ITEMS.register("arcanacard",
            () -> new ArcanaCardItem(new Item.Properties().stacksTo(1).durability(1)));

    //SPAWN
    public static final RegistryObject<Item> PYRO_JACK_SPAWN_EGG = ITEMS.register("pyro_jack_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntities.PYRO_JACK,0xda9113,0x0d426b,
                    new Item.Properties()));
    public static final RegistryObject<Item> PYRO_JACK_SUMMON_SPAWN_EGG = ITEMS.register("pyro_jack_summon_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntities.PYRO_JACK_SUMMON,0xda9113,0x0d426b,
                    new Item.Properties()));


    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
