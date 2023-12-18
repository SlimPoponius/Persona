package net.slimpopo.personamod.item.constants;

import net.minecraft.world.item.ItemStack;
import net.slimpopo.personamod.item.ModItems;
import net.slimpopo.personamod.item.constants.SpellItem;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class SpellItemList {
    private static Map<String, SpellItem> spellItemsForPersonas = new LinkedHashMap<String, SpellItem>(){
        {
            put("agi", ModItems.AGI.get());
            put("agilao", ModItems.AGILAO.get());
            put("agidyne", ModItems.AGIDYNE.get());
            put("maragi", ModItems.MARAGI.get());
            put("maragilao", ModItems.MARAGION.get());
            put("maragidyne", ModItems.MARAGIDYNE.get());

            put("bufu",ModItems.BUFU.get());
            put("bufula",ModItems.BUFULA.get());
            put("bufudyne",ModItems.BUFUDYNE.get());
            put("mabufu",ModItems.MABUFU.get());
            put("mabufula",ModItems.MABUFULA.get());
            put("mabufudyne",ModItems.MABUFUDYNE.get());

            put("garu",ModItems.GARU.get());
            put("garula",ModItems.GARULA.get());
            put("garudyne",ModItems.GARUDYNE.get());
            put("magaru",ModItems.MAGARU.get());
            put("magarula",ModItems.MAGARULA.get());
            put("magarudyne",ModItems.MAGARUDYNE.get());

            put("zio",ModItems.ZIO.get());
            put("zionga",ModItems.ZIONGA.get());
            put("ziodyne",ModItems.ZIODYNE.get());
            put("mazio",ModItems.MAZIO.get());
            put("mazionga",ModItems.MAZIONGA.get());
            put("maziodyne",ModItems.MAZIODYNE.get());

            put("psi",ModItems.PSI.get());
            put("psio",ModItems.PSIO.get());
            put("psiodyne",ModItems.PSIODYNE.get());
            put("mapsi",ModItems.MAPSI.get());
            put("mapsio",ModItems.MAPSIO.get());
            put("mapsiodyne",ModItems.MAPSIODYNE.get());

            put("frei",ModItems.FREI.get());
            put("freila",ModItems.FREILA.get());
            put("freidyne",ModItems.FREIDYNE.get());
            put("mafrei",ModItems.MAFREI.get());
            put("mafreila",ModItems.MAFREILA.get());
            put("mafreidyne",ModItems.MAFREIDYNE.get());

            put("mudo",ModItems.MUDO.get());
            put("mudoon",ModItems.MUDOON.get());
            put("mamudo",ModItems.MAMUDO.get());
            put("mamudoon",ModItems.MAMUDOON.get());

            put("eiha",ModItems.EIHA.get());
            put("eiga",ModItems.EIGA.get());
            put("eigaon",ModItems.EIGAON.get());
            put("maeiha",ModItems.MAEIHA.get());
            put("maeiga",ModItems.MAEIGA.get());
            put("maeigaon",ModItems.MAEIGAON.get());

            put("hama",ModItems.HAMA.get());
            put("hamaon",ModItems.HAMAON.get());
            put("mahama",ModItems.MAHAMA.get());
            put("mahamaon",ModItems.MAHAMAON.get());

            put("kouha",ModItems.KOUHA.get());
            put("kouga",ModItems.KOUGA.get());
            put("kougaon",ModItems.KOUGAON.get());
            put("makouha",ModItems.MAKOUHA.get());
            put("makouga",ModItems.MAKOUGA.get());
            put("makougaon",ModItems.MAKOUGAON.get());

        }
    };

    public static SpellItem getSpellItem(String spellName){
        for(Map.Entry<String, SpellItem> item: spellItemsForPersonas.entrySet()){
            if(item.getKey().equalsIgnoreCase(spellName)){
                return item.getValue();
            }
        }
        return null;
    }

    public static ItemStack getItemStack(String spellName){
        for(Map.Entry<String, SpellItem> item: spellItemsForPersonas.entrySet()){
            if(item.getKey().equalsIgnoreCase(spellName)){
                return new ItemStack(item.getValue());
            }
        }
        return ItemStack.EMPTY;
    }


}
