package net.slimpopo.personamod.client;

public class ClientPersonaSelectionData {
    private static boolean unlockedPersonas;
    public static String currentSelectedPersona;
    public static String currentSelectedPersonaSkill;


    private static boolean updatedData = false;

    public static void set(String currentSelectedPersona, String currentSelectedPersonaSkill, boolean unlockedPersonas){

        ClientPersonaSelectionData.currentSelectedPersonaSkill = currentSelectedPersonaSkill;
        ClientPersonaSelectionData.currentSelectedPersona = currentSelectedPersona;
        ClientPersonaSelectionData.unlockedPersonas = unlockedPersonas;
        ClientPersonaSelectionData.updatedData = true;
    }

    public static void reset(){
        ClientPersonaSelectionData.updatedData = false;
    }


    public static String getCurrentSelectedPersona() {
        return currentSelectedPersona;
    }
    public static String getCurrentSelectedPersonaSkill() {
        return currentSelectedPersonaSkill;
    }
    public static boolean isUnlockedPersonas(){return unlockedPersonas;}
    public static boolean getUpdatedStatus(){return updatedData;}

}
