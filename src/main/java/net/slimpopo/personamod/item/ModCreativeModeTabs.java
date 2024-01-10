package net.slimpopo.personamod.item;

import net.minecraft.client.resources.DefaultPlayerSkin;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.slimpopo.personamod.PersonaMod;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, PersonaMod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> PERSONA_TAB = CREATIVE_MODE_TABS.register("persona_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.AGI.get()))
                    .title(Component.translatable("creativetab.persona_tab"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModItems.AGI.get());
                        pOutput.accept(ModItems.AGILAO.get());
                        pOutput.accept(ModItems.AGIDYNE.get());
                        pOutput.accept(ModItems.MARAGI.get());
                        pOutput.accept(ModItems.MARAGION.get());
                        pOutput.accept(ModItems.MARAGIDYNE.get());
                        pOutput.accept(ModItems.BUFU.get());
                        pOutput.accept(ModItems.BUFULA.get());
                        pOutput.accept(ModItems.BUFUDYNE.get());
                        pOutput.accept(ModItems.MABUFU.get());
                        pOutput.accept(ModItems.MABUFULA.get());
                        pOutput.accept(ModItems.MABUFUDYNE.get());
                        pOutput.accept(ModItems.GARU.get());
                        pOutput.accept(ModItems.GARULA.get());
                        pOutput.accept(ModItems.GARUDYNE.get());
                        pOutput.accept(ModItems.MAGARU.get());
                        pOutput.accept(ModItems.MAGARULA.get());
                        pOutput.accept(ModItems.MAGARUDYNE.get());
                        pOutput.accept(ModItems.ZIO.get());
                        pOutput.accept(ModItems.ZIONGA.get());
                        pOutput.accept(ModItems.ZIODYNE.get());
                        pOutput.accept(ModItems.MAZIO.get());
                        pOutput.accept(ModItems.MAZIONGA.get());
                        pOutput.accept(ModItems.MAZIODYNE.get());
                        pOutput.accept(ModItems.FREI.get());
                        pOutput.accept(ModItems.FREILA.get());
                        pOutput.accept(ModItems.FREIDYNE.get());
                        pOutput.accept(ModItems.MAFREI.get());
                        pOutput.accept(ModItems.MAFREILA.get());
                        pOutput.accept(ModItems.MAFREIDYNE.get());
                        pOutput.accept(ModItems.PSI.get());
                        pOutput.accept(ModItems.PSIO.get());
                        pOutput.accept(ModItems.PSIODYNE.get());
                        pOutput.accept(ModItems.MAPSI.get());
                        pOutput.accept(ModItems.MAPSIO.get());
                        pOutput.accept(ModItems.MAPSIODYNE.get());
                        pOutput.accept(ModItems.EIHA.get());
                        pOutput.accept(ModItems.EIGA.get());
                        pOutput.accept(ModItems.EIGAON.get());
                        pOutput.accept(ModItems.MAEIHA.get());
                        pOutput.accept(ModItems.MAEIGA.get());
                        pOutput.accept(ModItems.MAEIGAON.get());
                        pOutput.accept(ModItems.MUDO.get());
                        pOutput.accept(ModItems.MUDOON.get());
                        pOutput.accept(ModItems.MAMUDO.get());
                        pOutput.accept(ModItems.MAMUDOON.get());
                        pOutput.accept(ModItems.KOUHA.get());
                        pOutput.accept(ModItems.KOUGA.get());
                        pOutput.accept(ModItems.KOUGAON.get());
                        pOutput.accept(ModItems.MAKOUHA.get());
                        pOutput.accept(ModItems.MAKOUGA.get());
                        pOutput.accept(ModItems.MAKOUGAON.get());
                        pOutput.accept(ModItems.HAMA.get());
                        pOutput.accept(ModItems.HAMAON.get());
                        pOutput.accept(ModItems.MAHAMA.get());
                        pOutput.accept(ModItems.MAHAMAON.get());
                        pOutput.accept(ModItems.MEGIDO.get());
                        pOutput.accept(ModItems.MEGIDOLA.get());
                        pOutput.accept(ModItems.MEGIDOLAON.get());
                        pOutput.accept(ModItems.TARUKAJA.get());
                        pOutput.accept(ModItems.MATARUKAJA.get());
                        pOutput.accept(ModItems.RAKUKAJA.get());
                        pOutput.accept(ModItems.MARAKUKAJA.get());
                        pOutput.accept(ModItems.SUKUKAJA.get());
                        pOutput.accept(ModItems.MASUKUKAJA.get());
                        pOutput.accept(ModItems.HEATRISER.get());
                        pOutput.accept(ModItems.DEKAJA.get());
                        pOutput.accept(ModItems.CONCENTRATE.get());
                        pOutput.accept(ModItems.CHARGE.get());
                        pOutput.accept(ModItems.TARUNDA.get());
                        pOutput.accept(ModItems.MATARUNDA.get());
                        pOutput.accept(ModItems.RAKUNDA.get());
                        pOutput.accept(ModItems.MARAKUNDA.get());
                        pOutput.accept(ModItems.SUKUNDA.get());
                        pOutput.accept(ModItems.MASUKUNDA.get());
                        pOutput.accept(ModItems.DEKUNDA.get());
                        pOutput.accept(ModItems.DEBILITATE.get());
                        pOutput.accept(ModItems.TETRAJA.get());
                        pOutput.accept(ModItems.LUNGE.get());
                        pOutput.accept(ModItems.CLEAVE.get());
                        pOutput.accept(ModItems.GIANTSLICE.get());
                        pOutput.accept(ModItems.ASSAULTDIVE.get());
                        pOutput.accept(ModItems.MEGATONRAID.get());
                        pOutput.accept(ModItems.GODSHAND.get());
                        pOutput.accept(ModItems.BRAVEBLADE.get());
                        pOutput.accept(ModItems.SWORDDANCE.get());
                        pOutput.accept(ModItems.DOUBLEFANGS.get());
                        pOutput.accept(ModItems.DREAMNEEDLE.get());
                        pOutput.accept(ModItems.TERRORCLAW.get());
                        pOutput.accept(ModItems.HEADBUTT.get());
                        pOutput.accept(ModItems.VORPALBLADE.get());
                        pOutput.accept(ModItems.HYSTERICALSLAP.get());
                        pOutput.accept(ModItems.BRAINSHAKE.get());
                        pOutput.accept(ModItems.SLEDGEHAMMER.get());
                        pOutput.accept(ModItems.MIRACLEPUNCH.get());
                        pOutput.accept(ModItems.VAJRABLAST.get());
                        pOutput.accept(ModItems.VICIOUSSTRIKE.get());
                        pOutput.accept(ModItems.HEATWAVE.get());
                        pOutput.accept(ModItems.TEMPESTSLASH.get());
                        pOutput.accept(ModItems.GIGANTOMACHIA.get());
                        pOutput.accept(ModItems.DEATHBOUND.get());
                        pOutput.accept(ModItems.RAMPAGE.get());
                        pOutput.accept(ModItems.AGNEYASTRA.get());
                        pOutput.accept(ModItems.SWIFTSTRIKE.get());
                        pOutput.accept(ModItems.MYRIADSLASHES.get());
                        pOutput.accept(ModItems.HASSOUTOBI.get());
                        pOutput.accept(ModItems.MEMORYBLOW.get());
                        pOutput.accept(ModItems.DORMINRUSH.get());
                        pOutput.accept(ModItems.ONIKAGURA.get());
                        pOutput.accept(ModItems.FLASHBOMB.get());
                        pOutput.accept(ModItems.BLOODBATH.get());
                        pOutput.accept(ModItems.BRAINBUSTER.get());
                        pOutput.accept(ModItems.SNAP.get());
                        pOutput.accept(ModItems.ONESHOTKILL.get());
                        pOutput.accept(ModItems.TRIPLEDOWN.get());
                        pOutput.accept(ModItems.RIOTGUN.get());
                    })
                    .build());

    public static final RegistryObject<CreativeModeTab> PERSONA_SPAWN_TAB = CREATIVE_MODE_TABS.register("persona_spawn_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.ZIO.get()))
                    .title(Component.translatable("creativetab.persona_spawn_tab"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModItems.PYRO_JACK_SPAWN_EGG.get());
                        pOutput.accept(ModItems.JACK_FROST_SPAWN_EGG.get());
                        pOutput.accept(ModItems.BLACK_FROST_SPAWN_EGG.get());
                    })
                    .build());

    public static final RegistryObject<CreativeModeTab> PERSONA_ITEMS_TAB = CREATIVE_MODE_TABS.register("persona_item_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.SKILLCARD.get()))
                    .title(Component.translatable("creativetab.persona_item_tab"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModItems.SKILLCARD.get());
                        pOutput.accept(ModItems.PERSONACARD.get());
                        pOutput.accept(ModItems.STATCARD.get());
                        pOutput.accept(ModItems.ARCANACARD.get());
                    })
                    .build());

    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
