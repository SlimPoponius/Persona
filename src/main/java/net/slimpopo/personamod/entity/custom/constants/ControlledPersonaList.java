package net.slimpopo.personamod.entity.custom.constants;

import net.slimpopo.personamod.constant.damage.Affinity;
import net.slimpopo.personamod.constant.entity.ControlledPersona;
import net.slimpopo.personamod.constant.entity.level.PersonaLevel;
import net.slimpopo.personamod.constant.entity.level.SkillLearnedLevel;
import net.slimpopo.personamod.item.constants.SpellItem;
import net.slimpopo.personamod.item.constants.SpellItemList;
import net.slimpopo.personamod.item.constants.SpellList;

import java.util.*;

public class ControlledPersonaList {

    private SpellItemList spellList = new SpellItemList();

    private static Map<String, ControlledPersona> personaCompendium = new LinkedHashMap<>(){{
       put("pyro_jack",
               new ControlledPersona("pyro_jack",new PersonaLevel(2),2,3,3,3,2,
                       new ArrayList<>(),List.of(Affinity.ICE,Affinity.WIND),new ArrayList<>(),List.of(Affinity.FIRE),
                       List.of(SpellItemList.getSpellItem("agi"),SpellItemList.getSpellItem("rakunda")),
                       List.of(new SkillLearnedLevel(0,SpellItemList.getSpellItem("agi")),
                               new SkillLearnedLevel(0,SpellItemList.getSpellItem("rakunda"))),
                       new ArrayList<>()));
       put("jack_frost",
               new ControlledPersona("jack_frost",new PersonaLevel(11),8,9,7,9,7,
                       new ArrayList<>(),List.of(Affinity.FIRE),List.of(Affinity.ICE),new ArrayList<>(),
                       List.of(SpellItemList.getSpellItem("agi"),SpellItemList.getSpellItem("rakunda")),
                       List.of(new SkillLearnedLevel(0,SpellItemList.getSpellItem("bufu")),
                               new SkillLearnedLevel(13,SpellItemList.getSpellItem("rakunda"))),
                       new ArrayList<>()));
       put("black_frost",
               new ControlledPersona("black_frost",new PersonaLevel(67),44,46,41,42,35,
                       new ArrayList<>(),new ArrayList<>(),List.of(Affinity.NUCLEAR),List.of(Affinity.ICE),
                       List.of(SpellItemList.getSpellItem("agi"),SpellItemList.getSpellItem("rakunda")),
                       List.of(new SkillLearnedLevel(0,SpellItemList.getSpellItem("mabufudyne"))),
                       List.of(Affinity.FIRE,Affinity.CURSE)));
    }};

    public static ControlledPersona getDataFromList(String id){
        for(Map.Entry<String, ControlledPersona> data: personaCompendium.entrySet()){
            if(data.getKey().equalsIgnoreCase(id)){
                return data.getValue();
            }
        }
        return null;
    }

    public static ControlledPersona getRandomPersona(){
        Random random = new Random();
        Object[] values = personaCompendium.values().toArray();
        //if(personaCompendium.size() == 1) return (ControlledPersona) values[0];
        int idx = Math.abs(random.nextInt() % personaCompendium.size());
        return (ControlledPersona) values[idx];
    }
}
