package net.slimpopo.personamod.entity.custom.constants;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;
import net.slimpopo.personamod.entity.ModEntities;
import net.slimpopo.personamod.entity.custom.personas.PyroJackSummonEntity;
import net.slimpopo.personamod.item.constants.SpellItem;

import java.util.LinkedHashMap;
import java.util.Map;

public class ControlledPersonaEntityList {

    private static Map<String, EntityType<? extends ControlledPersonaEntity>> personaEntityMap = new LinkedHashMap<>(){{
        put("pyro_jack", ModEntities.PYRO_JACK_SUMMON.get());

    }};

    public static EntityType<? extends ControlledPersonaEntity> getEntityFromId(String id){
        for (Map.Entry<String, EntityType<? extends ControlledPersonaEntity>> persona : personaEntityMap.entrySet()) {
            if(persona.getKey().equalsIgnoreCase(id)){
                return persona.getValue();
            }
        }
        return null;
    }
}
