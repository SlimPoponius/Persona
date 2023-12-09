package net.slimpopo.personamod;

import com.mojang.logging.LogUtils;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.client.renderer.entity.ThrownItemRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.slimpopo.personamod.effects.ModEffects;
import net.slimpopo.personamod.entity.ModEntities;
import net.slimpopo.personamod.item.ModCreativeModeTabs;
import net.slimpopo.personamod.item.ModItems;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(PersonaMod.MOD_ID)
public class PersonaMod
{
    // Define mod id in a common place for everything to reference
    public static final String MOD_ID = "personamod";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();

    public PersonaMod()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModCreativeModeTabs.register(modEventBus);
        ModItems.register(modEventBus);
        ModEntities.register(modEventBus);
        ModEffects.register(modEventBus);

        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);

        // Register the item to a creative tab
        modEventBus.addListener(this::addCreative);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {

    }

    // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event)
    {

    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {

    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
            EntityRenderers.register(ModEntities.FLAME_THROWABLE.get(), ThrownItemRenderer::new);
            EntityRenderers.register(ModEntities.GRP_FLAME_THROWABLE.get(), ThrownItemRenderer::new);
            EntityRenderers.register(ModEntities.ICE_THROWABLE.get(), ThrownItemRenderer::new);
            EntityRenderers.register(ModEntities.GRP_ICE_THROWABLE.get(), ThrownItemRenderer::new);
            EntityRenderers.register(ModEntities.WIND_THROWABLE.get(), ThrownItemRenderer::new);
            EntityRenderers.register(ModEntities.GRP_WIND_THROWABLE.get(), ThrownItemRenderer::new);
            EntityRenderers.register(ModEntities.ELECTRIC_THROWABLE.get(), ThrownItemRenderer::new);
            EntityRenderers.register(ModEntities.GRP_ELECTRIC_THROWABLE.get(), ThrownItemRenderer::new);
            EntityRenderers.register(ModEntities.NUKE_THROWABLE.get(), ThrownItemRenderer::new);
            EntityRenderers.register(ModEntities.GRP_NUKE_THROWABLE.get(), ThrownItemRenderer::new);
            EntityRenderers.register(ModEntities.PSI_THROWABLE.get(), ThrownItemRenderer::new);
            EntityRenderers.register(ModEntities.GRP_PSI_THROWABLE.get(), ThrownItemRenderer::new);

        }
    }
}
