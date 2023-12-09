package net.slimpopo.personamod.capability.persona.impl;

import net.slimpopo.personamod.capability.persona.IPersonaCapability;

public class PersonaCapability implements IPersonaCapability {
    private final int MAX_LEVEL = 99;
    private int sp;
    private int maxSp;
    private int spLevel;

    private int spExperienceNeeded = 15;
    private int currentSpExperience;

    private boolean hasUnlockedPersonas;


    @Override
    public int getSP() {
        return sp;
    }

    @Override
    public int getMaxSP() {
        return maxSp;
    }

    @Override
    public int getSPLevel() {
        return spLevel;
    }

    @Override
    public int getCurrentSpExperience() {
        return currentSpExperience;
    }

    @Override
    public boolean unlockedPersonaUse() {
        return hasUnlockedPersonas;
    }

    @Override
    public void setup() {
        this.spLevel = 1;
        this.setMaxSP(100);
        this.setSP(100);
        this.currentSpExperience = 0;
        this.spExperienceNeeded = this.calculateExperienceForNextLevel();
    }

    @Override
    public void setSP(int sp) {
        this.sp = sp;
    }

    @Override
    public void addSP(int sp) {
        this.sp += sp;
    }

    @Override
    public void addSP() {
        this.sp++;
    }

    @Override
    public void setMaxSP(int maxSP) {
        this.maxSp = maxSP;
    }

    @Override
    public void setSPLevel(int level) {
        spLevel = level;
    }

    @Override
    public void addSPLevel() {
        spLevel++;
        calculateExperienceForNextLevel();

    }

    @Override
    public void setCurrentSpExperience(int exp) {
        this.currentSpExperience = exp;
    }

    @Override
    public void addToCurrentSpExperience(int exp) {
        this.currentSpExperience += exp;
    }

    @Override
    public void setPersonaFlag(boolean hasPersona) {
        hasUnlockedPersonas = hasPersona;
    }

    private int calculateExperienceForNextLevel(){
        return (int) Math.round(spExperienceNeeded + Math.pow(spLevel,2.0D));
    }
}
