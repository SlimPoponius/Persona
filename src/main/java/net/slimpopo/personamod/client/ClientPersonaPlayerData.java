package net.slimpopo.personamod.client;

public class ClientPersonaPlayerData {
    private static float playerSpAmount;

    public static void set(float playerSpAmount){
        ClientPersonaPlayerData.playerSpAmount = playerSpAmount;
    }

    public static float getPlayerSpAmount(){
        return playerSpAmount;
    }
}
