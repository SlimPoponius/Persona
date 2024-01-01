package net.slimpopo.personamod.capability.persona.impl;

import net.minecraft.nbt.CompoundTag;
import net.slimpopo.personamod.capability.persona.IPlayerPersona;
import net.slimpopo.personamod.constant.entity.ControlledPersona;
import net.slimpopo.personamod.entity.custom.constants.ControlledPersonaEntity;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

public class PlayerPersona implements IPlayerPersona {
    private final int MAX_LEVEL = 99;
    private int sp = 32;
    private int maxSp = 32;

    private int spLevel;

    private int spExperienceNeeded = 15;
    private int currentSpExperience;

    private boolean hasUnlockedPersonas;
    private boolean hasPersonaReleased;
    private int currentPersonaIndex = -1;
    private List<ControlledPersona> personas = new ArrayList<>();


    private final int MIN_SP = 0;
    private final int MAX_SP = 999;

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
        if(sp < MIN_SP) this.sp = MIN_SP;
        else if (sp > maxSp) this.sp = maxSp;
        else this.sp = sp;
    }

    @Override
    public void addSP(int sp) {
        if (sp >= maxSp) this.sp = maxSp;
        else this.sp += sp;
    }

    @Override
    public void addSP() {
        if (sp >= maxSp) this.sp = maxSp;
        else this.sp++;
    }

    public void subSP(){
        if(sp <= MIN_SP) this.sp = MIN_SP;
        else this.sp--;
    }

    public void subSP(int sp){
        if(sp <= MIN_SP) this.sp = MIN_SP;
        else this.sp -= sp;
    }

    @Override
    public void setMaxSP(int maxSP) {
        if(sp < MIN_SP) this.sp = MIN_SP;
        else if (sp > MAX_SP) this.sp = MAX_SP;
        else this.maxSp = maxSP;
    }

    @Override
    public void setSPLevel(int level) {
        spLevel = level;
    }

    @Override
    public void addSPLevel() {
        if(canLevelUp()) {
            spLevel++;
            calculateExperienceForNextLevel();
        }
    }

    public void addSpExperience(int experience){
        this.currentSpExperience += experience;
        addSPLevel();
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
        if(!canLevelUp())
            return 0;
        setMaxSP(Math.max(maxSp+6,(int) Math.floor(.101f * Math.pow(spLevel - 1,2.0)+30)));
        return (int) Math.round(spExperienceNeeded + Math.pow(spLevel,2.0D));
    }

    private boolean canLevelUp(){
        return this.spLevel < MAX_LEVEL;
    }


    public void copyFrom(PlayerPersona src){
        this.sp = src.sp;
        this.maxSp = src.maxSp;
        this.spLevel = src.spLevel;
        this.spExperienceNeeded = src.spExperienceNeeded;
        this.currentSpExperience = src.currentSpExperience;
        this.hasUnlockedPersonas = src.hasUnlockedPersonas;

        this.hasPersonaReleased = src.hasPersonaReleased;
        this.currentPersonaIndex = src.currentPersonaIndex;
        this.personas = src.personas;
    }

    public boolean isHasPersonaReleased() {
        return hasPersonaReleased;
    }

    public void setHasPersonaReleased(boolean hasPersonaReleased) {
        this.hasPersonaReleased = hasPersonaReleased;
    }

    public int getCurrentPersonaIndex() {
        if(currentPersonaIndex == -1)
            return 0;
        return currentPersonaIndex;
    }

    public void setCurrentPersonaIndex(int currentPersonaIndex) {
        this.currentPersonaIndex = currentPersonaIndex;
    }

    public void setPersonas(List<ControlledPersona> personas) {
        this.personas = personas;
    }
    public void addToCurrentPersonaListing(ControlledPersona cp){this.personas.add(cp);}

    public int getPersonaCount(){ return personas.size();}
    public ControlledPersona getControlledPersonaFromIndex(int idx){
        return personas.get(idx);
    }
    public int getIndexForPersona(ControlledPersona pData){
        return personas.indexOf(pData);
    }



    public void saveNBTData(CompoundTag nbt){
        nbt.putInt("sp",this.sp);
        nbt.putInt("maxsp",this.maxSp);
        nbt.putInt("splevel",this.spLevel);
        nbt.putInt("needed_experience",this.spExperienceNeeded);
        nbt.putInt("current_experience",this.currentSpExperience);
        nbt.putBoolean("unlocked_personas",this.hasUnlockedPersonas);
        nbt.putBoolean("persona_released",this.hasPersonaReleased);
        nbt.putInt("current_persona",this.currentPersonaIndex);

        for(int i = 0; i < 6;i++) {
            if(i < personas.size() - 1) {
                nbt.put("persona" + i, personas.get(i).createCompoundNBTData());
            }
            else{
                nbt.remove("persona" + i);
            }
        }

    }

    public void loadNBTData(CompoundTag nbt){
        sp = nbt.getInt("sp");
        maxSp = nbt.getInt("maxsp");
        spLevel = nbt.getInt("splevel");
        spExperienceNeeded = nbt.getInt("needed_experience");
        currentSpExperience = nbt.getInt("current_experience");
        hasUnlockedPersonas = nbt.getBoolean("unlocked_personas");
        hasPersonaReleased = nbt.getBoolean("persona_released");
        currentPersonaIndex = nbt.getInt("current_persona");

        for(int i = 0; i < 6;i++) {
            ControlledPersona persona = new ControlledPersona();
            try{
                personas.add(persona.readFromCompoundNbtData(nbt.get("persona" + i)));
            }
            catch (Throwable throwable){
                break;
            }
        }

    }


    public boolean findControlledPersonaWithName(String personaName) {
        return personas.stream().filter(persona -> persona.getPersonaName().equalsIgnoreCase(personaName))
                .findFirst().isPresent();
    }

}
