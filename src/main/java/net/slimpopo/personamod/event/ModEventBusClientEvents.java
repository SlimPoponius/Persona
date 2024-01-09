package net.slimpopo.personamod.event;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.slimpopo.personamod.PersonaMod;
import net.slimpopo.personamod.entity.client.ModModelLayers;
import net.slimpopo.personamod.entity.client.models.JackFrostModel;
import net.slimpopo.personamod.entity.client.models.PyroJackModel;

@Mod.EventBusSubscriber(modid = PersonaMod.MOD_ID,bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModEventBusClientEvents {

    @SubscribeEvent
    public static void registerLayer(EntityRenderersEvent.RegisterLayerDefinitions event){
        event.registerLayerDefinition(ModModelLayers.PYRO_JACK_LAYER, PyroJackModel::createBodyLayer);
        event.registerLayerDefinition(ModModelLayers.JACK_FROST_LAYER, JackFrostModel::createBodyLayer);
        event.registerLayerDefinition(ModModelLayers.BLACK_FROST_LAYER, JackFrostModel::createBodyLayer);

    }
}
