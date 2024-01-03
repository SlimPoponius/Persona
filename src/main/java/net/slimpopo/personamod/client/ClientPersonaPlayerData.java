package net.slimpopo.personamod.client;

public class ClientPersonaPlayerData {
    private static int curSp;
    private static int maxSp;
    private static float playerSpAmount;

    public static void set(int curSp, int maxSp){
        ClientPersonaPlayerData.curSp = curSp;
        ClientPersonaPlayerData.maxSp = maxSp;
        ClientPersonaPlayerData.playerSpAmount = ((float)curSp)/maxSp;
    }

    public static float getPlayerSpAmount(){
        return playerSpAmount;
    }
    public static int getCurSp() {
        return curSp;
    }
    public static int getMaxSp() {
        return maxSp;
    }
}
