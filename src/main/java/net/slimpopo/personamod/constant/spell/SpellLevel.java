package net.slimpopo.personamod.constant.spell;

public enum SpellLevel {

    ONE_STAR(1,1),
    TWO_STAR(2,1),
    THREE_STAR(3,1),
    MA_ONE_STAR(1,4),
    MA_TWO_STAR(2,8),
    MA_THREE_STAR(2,12);

    private int level;
    private int range;

    SpellLevel(int level, int range) {
        this.level = level;
        this.range = range;
    }

    public int getLevel() {
        return level;
    }

    public int getRange() {
        return range;
    }
}
