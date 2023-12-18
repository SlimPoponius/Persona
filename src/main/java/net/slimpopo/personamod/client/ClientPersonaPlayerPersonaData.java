package net.slimpopo.personamod.client;

public class ClientPersonaPlayerPersonaData {
    private static boolean unlockedPersonas;
    private static int playerPersonaIdx;
    private static int playerPersonaLvl;
    private static int playerPersonaCurrentXp;
    private static int playerPersonaNeededXp;

    private static boolean updatedData = false;

    public static void set(int playerPersonaIdx,int playerPersonaLvl,
                           int playerPersonaCurrentXp,int playerPersonaNeededXp){

        ClientPersonaPlayerPersonaData.playerPersonaIdx = playerPersonaIdx;
        ClientPersonaPlayerPersonaData.playerPersonaLvl = playerPersonaLvl;
        ClientPersonaPlayerPersonaData.playerPersonaCurrentXp = playerPersonaCurrentXp;
        ClientPersonaPlayerPersonaData.playerPersonaNeededXp = playerPersonaNeededXp;
        ClientPersonaPlayerPersonaData.updatedData = true;
    }

    public static void reset(){
        ClientPersonaPlayerPersonaData.updatedData = false;
    }

    public static int getPlayerPersonaIdx(){
        return playerPersonaIdx;
    }
    public static int getPlayerPersonaLvl(){
        return playerPersonaLvl;
    }
    public static int getPlayerPersonaCurrentXp(){
        return playerPersonaCurrentXp;
    }
    public static int getPlayerPersonaNeededXp(){
        return playerPersonaNeededXp;
    }
    public static boolean isUnlockedPersonas(){return unlockedPersonas;}
    public static boolean getUpdatedStatus(){return updatedData;}

}
