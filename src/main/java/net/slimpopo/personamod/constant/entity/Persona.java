package net.slimpopo.personamod.constant.entity;

import net.slimpopo.personamod.constant.damage.Affinity;
import net.slimpopo.personamod.constant.entity.level.PersonaLevel;
import net.slimpopo.personamod.item.constants.SpellItem;

import java.util.List;

public class Persona {


    private int STRENGTH;
    private int MAGIC;
    private int ENDURANCE;
    private int AGILITY;
    private int LUCK;

    private List<Affinity> StrongAgainst;
    private List<Affinity> WeakAgainst;
    private List<Affinity> NullAgainst;
    private List<Affinity> AbsorbAgainst;

    public Persona(int STRENGTH, int MAGIC, int ENDURANCE, int AGILITY, int LUCK) {
        this.STRENGTH = STRENGTH;
        this.MAGIC = MAGIC;
        this.ENDURANCE = ENDURANCE;
        this.AGILITY = AGILITY;
        this.LUCK = LUCK;
    }

    public Persona(int STRENGTH, int MAGIC, int ENDURANCE, int AGILITY, int LUCK,
                   List<Affinity> strongAgainst, List<Affinity> weakAgainst, List<Affinity> nullAgainst,
                   List<Affinity> absorbAgainst) {
        this.STRENGTH = STRENGTH;
        this.MAGIC = MAGIC;
        this.ENDURANCE = ENDURANCE;
        this.AGILITY = AGILITY;
        this.LUCK = LUCK;
        StrongAgainst = strongAgainst;
        WeakAgainst = weakAgainst;
        NullAgainst = nullAgainst;
        AbsorbAgainst = absorbAgainst;
    }

    public int getSTRENGTH() {
        return STRENGTH;
    }

    public int getMAGIC() {
        return MAGIC;
    }

    public int getENDURANCE() {
        return ENDURANCE;
    }

    public int getAGILITY() {
        return AGILITY;
    }

    public int getLUCK() {
        return LUCK;
    }

    public List<Affinity> getStrongAgainst() {
        return StrongAgainst;
    }

    public List<Affinity> getWeakAgainst() {
        return WeakAgainst;
    }

    public List<Affinity> getNullAgainst() {
        return NullAgainst;
    }

    public List<Affinity> getAbsorbAgainst() {
        return AbsorbAgainst;
    }

    public void setMAGIC(int MAGIC) {
        this.MAGIC = MAGIC;
    }

    public void setSTRENGTH(int STRENGTH) {
        this.STRENGTH = STRENGTH;
    }

    public void setENDURANCE(int ENDURANCE) {
        this.ENDURANCE = ENDURANCE;
    }

    public void setAGILITY(int AGILITY) {
        this.AGILITY = AGILITY;
    }

    public void setLUCK(int LUCK) {
        this.LUCK = LUCK;
    }

    public void setStrongAgainst(List<Affinity> strongAgainst) {
        StrongAgainst = strongAgainst;
    }

    public void setWeakAgainst(List<Affinity> weakAgainst) {
        WeakAgainst = weakAgainst;
    }

    public void setNullAgainst(List<Affinity> nullAgainst) {
        NullAgainst = nullAgainst;
    }

    public void setAbsorbAgainst(List<Affinity> absorbAgainst) {
        AbsorbAgainst = absorbAgainst;
    }

}
