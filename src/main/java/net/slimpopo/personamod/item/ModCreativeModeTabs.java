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

                    })
                    .build());

    public static final RegistryObject<CreativeModeTab> PERSONA_SPAWN_TAB = CREATIVE_MODE_TABS.register("persona_spawn_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.ZIO.get()))
                    .title(Component.translatable("creativetab.persona_spawn_tab"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModItems.PYRO_JACK_SPAWN_EGG.get());


                    })
                    .build());

    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
