package net.slimpopo.personamod.constant.entity.level;

public class ExperienceLevelIdentifier {
    public static int calculateExperienceFromLevelDifference(int experience, int enemyLevel, int currentLevel) {
        int levelDiff = enemyLevel - currentLevel;

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
}
