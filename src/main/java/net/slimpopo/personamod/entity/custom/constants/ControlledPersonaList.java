package net.slimpopo.personamod.entity.custom.constants;

import net.slimpopo.personamod.constant.damage.Affinity;
import net.slimpopo.personamod.constant.entity.ControlledPersona;
import net.slimpopo.personamod.constant.entity.level.PersonaLevel;
import net.slimpopo.personamod.constant.entity.level.SkillLearnedLevel;
import net.slimpopo.personamod.item.constants.SpellItem;
import net.slimpopo.personamod.item.constants.SpellItemList;
import net.slimpopo.personamod.item.constants.SpellList;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ControlledPersonaList {

    private SpellItemList spellList = new SpellItemList();

    private static Map<String, ControlledPersona> personaCompendium = new LinkedHashMap<>(){{
       put("pyro_jack",
               new ControlledPersona("pyro_jack",new PersonaLevel(2),2,3,3,3,2,
                       new ArrayList<>(),List.of(Affinity.ICE,Affinity.WIND),new ArrayList<>(),List.of(Affinity.FIRE),
                       List.of(SpellItemList.getSpellItem("agi")),
                       List.of(new SkillLearnedLevel(0,SpellItemList.getSpellItem("agi"))),
                       new ArrayList<>()));
    }};

    public static ControlledPersona getDataFromList(String id){
        for(Map.Entry<String, ControlledPersona> data: personaCompendium.entrySet()){
            if(data.getKey().equalsIgnoreCase(id)){
                return data.getValue();
            }
        }
        return null;
    }
}
