package net.slimpopo.personamod.event;

import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.slimpopo.personamod.PersonaMod;
import net.slimpopo.personamod.entity.ModEntities;
import net.slimpopo.personamod.entity.custom.personas.PyroJackEntity;

@Mod.EventBusSubscriber(modid = PersonaMod.MOD_ID,bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {

    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event){
        event.put(ModEntities.PYRO_JACK.get(), PyroJackEntity.createAttributes().build());
    }
}
