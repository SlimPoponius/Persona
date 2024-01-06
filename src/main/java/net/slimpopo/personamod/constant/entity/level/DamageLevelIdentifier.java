package net.slimpopo.personamod.constant.entity.level;

import net.slimpopo.personamod.constant.entity.Persona;

public class DamageLevelIdentifier {

    public static float getDamageMultiplierBasedOnLevel(int userLevel, int targetLevel){
        int levelDiff = targetLevel - userLevel;

        if(levelDiff > 10)
            levelDiff = 10;
        else if(levelDiff < -10)
            levelDiff = -10;

        float multiplier = switch (levelDiff){
            case -10 ->   .5f;
            case -9  ->   .55f;
            case -8  ->   .6f;
            case -7  ->   .65f;
            case -6  ->   .7f;
            case -5  ->   .75f;
            case 2   ->   1.1f;
            case 3   ->   1.15f;
            case 4   ->   1.2f;
            case 5   ->   1.25f;
            case 6   ->   1.3f;
            case 7   ->   1.35f;
            case 8   ->   1.4f;
            case 9   ->   1.45f;
            case 10  ->   1.5f;
            default  ->   1f;

        };
        return multiplier;
    }

}
