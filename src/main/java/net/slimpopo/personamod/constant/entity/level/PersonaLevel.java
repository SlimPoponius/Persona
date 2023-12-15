package net.slimpopo.personamod.constant.entity.level;

import net.slimpopo.personamod.constant.spell.Spell;
import net.slimpopo.personamod.item.constants.SpellItem;

import java.util.List;

public class PersonaLevel {
    private int currentXp;
    private int neededXP;

    private int currentLevel;
    private int maxLevel = 99;
    private List<SkillLearnedLevel> learnedSkills;

    public PersonaLevel(int currentLevel, List<SkillLearnedLevel> learnedSkills){
        this.currentLevel = currentLevel;
        this.learnedSkills = learnedSkills;
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

    public List<SkillLearnedLevel> getLearnedSkills() {
        return learnedSkills;
    }

    public void addSkillToSkillList(SkillLearnedLevel skill){
        this.learnedSkills.add(skill);
    }

    public boolean canLevelUp(){
        return currentXp >= neededXP;
    }

    public void levelUp(){
        if(currentLevel != maxLevel)
            this.currentLevel++;
    }

    private int calculateExperienceNeededForNextLevel() {
        return (int) Math.round(neededXP + Math.pow(currentLevel,2.0D));
    }

}
