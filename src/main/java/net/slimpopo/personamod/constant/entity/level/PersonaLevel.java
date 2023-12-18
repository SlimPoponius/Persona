package net.slimpopo.personamod.constant.entity.level;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.Tag;
import net.slimpopo.personamod.constant.spell.Spell;
import net.slimpopo.personamod.item.constants.SpellItem;

import java.util.List;

public class PersonaLevel {
    private int currentXp;
    private int neededXP;

    private int currentLevel;
    private int maxLevel = 99;

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
        currentXp += calculateExperienceFromLevelDifference(experience, enemyLevel);
        if(canLevelUp()){
            levelUp();
        }
    }

    public int getExperienceTotal(int experience,int enemyLevel){
        return calculateExperienceFromLevelDifference(experience, enemyLevel);
    }

    private int calculateExperienceFromLevelDifference(int experience, int enemyLevel) {
        int levelDiff = enemyLevel - this.currentLevel;

        if(levelDiff > 10)
            levelDiff = 10;
        else if(levelDiff < -10)
            levelDiff = -10;

        float multiplier = switch (levelDiff){
            case -10 ->   .247f;
            case -9  ->   .284f;
            case -8  ->   .327f;
            case -7  ->   .376f;
            case -6  ->   .432f;
            case -5  ->   .497f;
            case -4  ->   .572f;
            case -3  ->   .658f;
            case -2  ->   .756f;
            case -1  ->   .87f;
            case 1   ->   1.15f;
            case 2   ->   1.323f;
            case 3   ->   1.521f;
            case 4   ->   1.749f;
            case 5   ->   2.011f;
            case 6   ->   2.313f;
            case 7   ->   2.66f;
            case 8   ->   3.059f;
            case 9   ->   3.518f;
            case 10  ->   4.046f;
            default  ->   1f;

        };
        return (int)(Math.round(experience * multiplier));
    }

    public void levelUp(){
        if(currentLevel != maxLevel)
            this.currentLevel++;
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
}
