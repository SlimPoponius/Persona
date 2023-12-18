package net.slimpopo.personamod.entity.custom.constants;

import net.minecraft.world.level.Level;
import net.slimpopo.personamod.entity.ModEntities;
import net.slimpopo.personamod.entity.custom.personas.PyroJackSummonEntity;
import net.slimpopo.personamod.item.constants.SpellItem;

import java.util.LinkedHashMap;
import java.util.Map;

public class ControlledPersonaEntityList {
    private static Level level;

    public ControlledPersonaEntityList(Level level){
        this.level = level;
    }

    private static Map<String, ControlledPersonaEntity> personaEntityMap = new LinkedHashMap<>(){{
        put("pyro_jack", new PyroJackSummonEntity(ModEntities.PYRO_JACK_SUMMON.get(),level));

    }};

    public ControlledPersonaEntity getEntityFromId(String id){
        for (Map.Entry<String, ControlledPersonaEntity> persona : personaEntityMap.entrySet()) {
            if(persona.getKey().equalsIgnoreCase(id)){
                return persona.getValue();
            }
        }
        return null;
    }
}
