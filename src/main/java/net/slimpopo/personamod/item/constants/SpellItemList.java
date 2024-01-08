package net.slimpopo.personamod.item.constants;

import net.minecraft.world.item.ItemStack;
import net.slimpopo.personamod.item.ModItems;
import net.slimpopo.personamod.item.constants.SpellItem;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;

public class SpellItemList {
    private static Map<String, SpellItem> spellItemsForPersonas = new LinkedHashMap<String, SpellItem>(){
        {
            //FIRE
            put("agi", ModItems.AGI.get());
            put("agilao", ModItems.AGILAO.get());
            put("agidyne", ModItems.AGIDYNE.get());
            put("maragi", ModItems.MARAGI.get());
            put("maragilao", ModItems.MARAGION.get());
            put("maragidyne", ModItems.MARAGIDYNE.get());

            //ICE
            put("bufu",ModItems.BUFU.get());
            put("bufula",ModItems.BUFULA.get());
            put("bufudyne",ModItems.BUFUDYNE.get());
            put("mabufu",ModItems.MABUFU.get());
            put("mabufula",ModItems.MABUFULA.get());
            put("mabufudyne",ModItems.MABUFUDYNE.get());

            //WIND
            put("garu",ModItems.GARU.get());
            put("garula",ModItems.GARULA.get());
            put("garudyne",ModItems.GARUDYNE.get());
            put("magaru",ModItems.MAGARU.get());
            put("magarula",ModItems.MAGARULA.get());
            put("magarudyne",ModItems.MAGARUDYNE.get());

            //ELECTRIC
            put("zio",ModItems.ZIO.get());
            put("zionga",ModItems.ZIONGA.get());
            put("ziodyne",ModItems.ZIODYNE.get());
            put("mazio",ModItems.MAZIO.get());
            put("mazionga",ModItems.MAZIONGA.get());
            put("maziodyne",ModItems.MAZIODYNE.get());

            //PSYCHOKINESIS
            put("psi",ModItems.PSI.get());
            put("psio",ModItems.PSIO.get());
            put("psiodyne",ModItems.PSIODYNE.get());
            put("mapsi",ModItems.MAPSI.get());
            put("mapsio",ModItems.MAPSIO.get());
            put("mapsiodyne",ModItems.MAPSIODYNE.get());

            //NUCLEAR
            put("frei",ModItems.FREI.get());
            put("freila",ModItems.FREILA.get());
            put("freidyne",ModItems.FREIDYNE.get());
            put("mafrei",ModItems.MAFREI.get());
            put("mafreila",ModItems.MAFREILA.get());
            put("mafreidyne",ModItems.MAFREIDYNE.get());

            //CURSE
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

            //BLESS
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

            //ALIMIGHTY
            put("megido",ModItems.MEGIDO.get());
            put("megidola",ModItems.MEGIDOLA.get());
            put("megidolaon",ModItems.MEGIDOLAON.get());

            //SUPPORT
            put("tarukaja",ModItems.TARUKAJA.get());
            put("matarukaja",ModItems.MATARUKAJA.get());
            put("rakukaja",ModItems.RAKUKAJA.get());
            put("marakukaja",ModItems.MARAKUKAJA.get());
            put("sukukaja",ModItems.SUKUKAJA.get());
            put("masukukaja",ModItems.MASUKUKAJA.get());
            put("heatriser",ModItems.HEATRISER.get());
            put("dekaja",ModItems.DEKAJA.get());
            put("concentrate",ModItems.CONCENTRATE.get());
            put("charge",ModItems.CHARGE.get());
            put("tarunda",ModItems.TARUNDA.get());
            put("matarunda",ModItems.MATARUNDA.get());
            put("rakunda",ModItems.RAKUNDA.get());
            put("marakunda",ModItems.MARAKUNDA.get());
            put("sukunda",ModItems.SUKUNDA.get());
            put("masukunda",ModItems.MASUKUNDA.get());
            put("dekunda",ModItems.DEKUNDA.get());
            put("debilitate",ModItems.DEBILITATE.get());
            put("tetraja",ModItems.TETRAJA.get());
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

    public static SpellItem getSpellItemFromRandom(){
        Random random = new Random();
        Object[] values = spellItemsForPersonas.values().toArray();
        int idx = Math.abs(random.nextInt() % spellItemsForPersonas.size());
        SpellItem item = (SpellItem) values[idx];
        return item;
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
