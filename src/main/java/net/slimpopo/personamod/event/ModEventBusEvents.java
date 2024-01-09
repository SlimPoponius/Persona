package net.slimpopo.personamod.event;

import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.slimpopo.personamod.PersonaMod;
import net.slimpopo.personamod.entity.ModEntities;
import net.slimpopo.personamod.entity.custom.personas.jackfrost.JackFrostEntity;
import net.slimpopo.personamod.entity.custom.personas.jackfrost.JackFrostSummonEntity;
import net.slimpopo.personamod.entity.custom.personas.pyrojack.PyroJackEntity;
import net.slimpopo.personamod.entity.custom.personas.pyrojack.PyroJackSummonEntity;

@Mod.EventBusSubscriber(modid = PersonaMod.MOD_ID,bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {

    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event){
        event.put(ModEntities.PYRO_JACK.get(), PyroJackEntity.createAttributes().build());
        event.put(ModEntities.JACK_FROST.get(), JackFrostEntity.createAttributes().build());
        event.put(ModEntities.BLACK_FROST.get(), JackFrostEntity.createAttributes().build());

        event.put(ModEntities.PYRO_JACK_SUMMON.get(), PyroJackSummonEntity.createAttributes().build());
        event.put(ModEntities.JACK_FROST_SUMMON.get(), JackFrostSummonEntity.createAttributes().build());
        event.put(ModEntities.BLACK_FROST_SUMMON.get(), JackFrostSummonEntity.createAttributes().build());

    }
}
