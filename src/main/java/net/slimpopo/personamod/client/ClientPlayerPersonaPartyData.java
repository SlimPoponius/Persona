package net.slimpopo.personamod.client;

import net.slimpopo.personamod.constant.entity.ControlledPersona;

import java.util.List;

public class ClientPlayerPersonaPartyData {
    private static List<ControlledPersona> personas;

    public static void set(List<ControlledPersona> personas){
        ClientPlayerPersonaPartyData.personas = personas;
    }

    public static List<ControlledPersona> getPersonas() {
        return personas;
    }
}
