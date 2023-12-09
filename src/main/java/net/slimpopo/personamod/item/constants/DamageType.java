package net.slimpopo.personamod.item.constants;

public enum DamageType {

    LIGHT(1.0f),
    MEDIUM(1.5f),
    HEAVY(2.0f),
    SEVERE(3.0f),
    COLOSSAL(4.0f);


    private float damageMultiplier;

    private DamageType(float v) {
        this.damageMultiplier = v;
    }

    public float getDamageMultiplier() {
        return damageMultiplier;
    }
}
