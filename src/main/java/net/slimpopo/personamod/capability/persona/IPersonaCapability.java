package net.slimpopo.personamod.capability.persona;

public interface IPersonaCapability {



    int getSP();
    int getMaxSP();
    int getSPLevel();
    int getCurrentSpExperience();

    boolean unlockedPersonaUse();

    void setup();
    void setSP(int sp);
    void addSP(int sp);
    void addSP();
    void setMaxSP(int maxSP);
    void setSPLevel(int level);
    void addSPLevel();
    void setCurrentSpExperience(int exp);
    void addToCurrentSpExperience(int exp);
    void setPersonaFlag(boolean hasPersona);
}
