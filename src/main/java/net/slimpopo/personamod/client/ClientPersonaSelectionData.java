package net.slimpopo.personamod.client;

import net.minecraft.world.entity.player.Player;

public class ClientPersonaSelectionData {
    private static boolean unlockedPersonas;
    public static String currentSelectedPersona;
    public static String currentSelectedPersonaSkill;
    public static Player playerData;

    private static boolean updatedData = false;

    public static void set(String currentSelectedPersona, String currentSelectedPersonaSkill, boolean unlockedPersonas,
                           Player playerData){

        ClientPersonaSelectionData.currentSelectedPersonaSkill = currentSelectedPersonaSkill;
        ClientPersonaSelectionData.currentSelectedPersona = currentSelectedPersona;
        ClientPersonaSelectionData.unlockedPersonas = unlockedPersonas;
        ClientPersonaSelectionData.updatedData = true;
        ClientPersonaSelectionData.playerData = playerData;
    }

    public static void reset(){
        ClientPersonaSelectionData.updatedData = false;
    }

    public static String getCurrentSelectedPersona() {
        return currentSelectedPersona;
    }
    public static Player getPlayerData() {
        return playerData;
    }
    public static String getCurrentSelectedPersonaSkill() {
        return currentSelectedPersonaSkill;
    }
    public static boolean isUnlockedPersonas(){return unlockedPersonas;}
    public static boolean getUpdatedStatus(){return updatedData;}

}
