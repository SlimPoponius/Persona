package net.slimpopo.personamod.constant.entity.level;

import net.minecraft.client.Minecraft;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.Tag;
import net.minecraft.network.chat.Component;
import net.slimpopo.personamod.constant.spell.Spell;
import net.slimpopo.personamod.item.constants.SpellItem;

import java.util.List;

public class PersonaLevel {
    private int currentXp;
    private int neededXP = 15;

    private int currentLevel;
    private int maxLevel = 99;

    private boolean hasLeveledUp;

    public PersonaLevel(int currentLevel){
        this.currentLevel = currentLevel;
        this.currentXp = 0;
        this.neededXP = calculateExperienceNeededForNextLevel();
    }


    public int getCurrentLevel() {
        return currentLevel;
    }

    public int getCurrentXp() {
        return currentXp;
    }

    public int getNeededXP() {
        return neededXP;
    }

    public boolean canLevelUp(){
        return currentXp >= neededXP;
    }

    public void addExperience(int experience,int enemyLevel){
        currentXp += ExperienceLevelIdentifier.calculateExperienceFromLevelDifference(experience, enemyLevel,currentLevel);
        if(canLevelUp()){
            levelUp();
        }
    }

    public int getExperienceGainTotal(int experience,int enemyLevel){
        return ExperienceLevelIdentifier.calculateExperienceFromLevelDifference(experience, enemyLevel,currentLevel);
    }

    public void levelUp(){
        if(currentLevel != maxLevel) {
            this.currentLevel++;
            Minecraft.getInstance().player.sendSystemMessage(
                    Component.literal("Persona has reached Level " + this.currentLevel));
            hasLeveledUp = true;
        }
        calculateExperienceNeededForNextLevel();
    }

    private int calculateExperienceNeededForNextLevel() {
        return (int) Math.round(neededXP + Math.pow(currentLevel,2.0D));
    }

    public CompoundTag createCompoundNBTData(){
        CompoundTag personaNbt = new CompoundTag();
        personaNbt.putInt("curent_persona_exp",currentXp);
        personaNbt.putInt("needed_persona_exp",neededXP);
        personaNbt.putInt("curent_persona_level",currentLevel);
        return personaNbt;
    }

    public PersonaLevel readCompoundNBTData(Tag persona_level_data) {
        CompoundTag actualData = (CompoundTag) persona_level_data;
        this.currentXp = actualData.getInt("curent_persona_exp");
        this.neededXP = actualData.getInt("needed_persona_exp");
        this.currentLevel = actualData.getInt("curent_persona_level");

        return this;
    }

    public void update(int playerPersonaLvl, int playerPersonaCurrentXp, int playerPersonaNeededXp) {
        this.currentLevel = playerPersonaLvl;
        this.currentXp    = playerPersonaCurrentXp;
        this.neededXP     = playerPersonaNeededXp;
    }

    public boolean isHasLeveledUp() {
        return hasLeveledUp;
    }

    public void setHasLeveledUp(boolean hasLeveledUp) {
        this.hasLeveledUp = hasLeveledUp;
    }
}
