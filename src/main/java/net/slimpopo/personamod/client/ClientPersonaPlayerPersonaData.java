package net.slimpopo.personamod.client;

public class ClientPersonaPlayerPersonaData {
    private static boolean unlockedPersonas;
    private static int playerPersonaIdx;
    private static int playerPersonaLvl;

    private static int playerPersonaStr;
    private static int playerPersonaMag;
    private static int playerPersonaAgi;
    private static int playerPersonaEnd;
    private static int playerPersonaLuc;

    private static String[] playerPersonaSkills;

    private static int playerPersonaCurrentXp;
    private static int playerPersonaNeededXp;

    private static boolean updatedData = false;

    public static void set(int playerPersonaIdx,int playerPersonaLvl,
                           int playerPersonaCurrentXp,int playerPersonaNeededXp,
                           int str, int mag, int end, int agi, int luc,
                           String[] skills){

        ClientPersonaPlayerPersonaData.playerPersonaIdx = playerPersonaIdx;
        ClientPersonaPlayerPersonaData.playerPersonaLvl = playerPersonaLvl;
        ClientPersonaPlayerPersonaData.playerPersonaCurrentXp = playerPersonaCurrentXp;
        ClientPersonaPlayerPersonaData.playerPersonaNeededXp = playerPersonaNeededXp;

        ClientPersonaPlayerPersonaData.playerPersonaStr = str;
        ClientPersonaPlayerPersonaData.playerPersonaMag = mag;
        ClientPersonaPlayerPersonaData.playerPersonaAgi = agi;
        ClientPersonaPlayerPersonaData.playerPersonaEnd = end;
        ClientPersonaPlayerPersonaData.playerPersonaLuc = luc;

        ClientPersonaPlayerPersonaData.playerPersonaSkills = skills;
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

    public static int getPlayerPersonaAgi() {
        return playerPersonaAgi;
    }
    public static int getPlayerPersonaEnd() {
        return playerPersonaEnd;
    }
    public static int getPlayerPersonaStr() {
        return playerPersonaStr;
    }
    public static int getPlayerPersonaMag() {
        return playerPersonaMag;
    }
    public static int getPlayerPersonaLuc() {
        return playerPersonaLuc;
    }

    public static String[] getPlayerPersonaSkills() {
        return playerPersonaSkills;
    }

}
