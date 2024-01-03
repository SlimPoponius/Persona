package net.slimpopo.personamod.constant.entity;

import net.slimpopo.personamod.constant.damage.Affinity;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Persona {

    private String personaName;

    private int STRENGTH;
    private int MAGIC;
    private int ENDURANCE;
    private int AGILITY;
    private int LUCK;

    private List<Affinity> StrongAgainst = new ArrayList<>();
    private List<Affinity> WeakAgainst = new ArrayList<>();
    private List<Affinity> NullAgainst = new ArrayList<>();
    private List<Affinity> AbsorbAgainst = new ArrayList<>();
    private List<Affinity> ReflectAgainst = new ArrayList<>();

    private final int MAX_STAT = 99;

    public Persona(){

    }

    public Persona(String personaName,int STRENGTH, int MAGIC, int ENDURANCE, int AGILITY, int LUCK) {
        this.personaName = personaName;
        this.STRENGTH = STRENGTH;
        this.MAGIC = MAGIC;
        this.ENDURANCE = ENDURANCE;
        this.AGILITY = AGILITY;
        this.LUCK = LUCK;
    }

    public Persona(String personaName,int STRENGTH, int MAGIC, int ENDURANCE, int AGILITY, int LUCK,
                   List<Affinity> strongAgainst, List<Affinity> weakAgainst, List<Affinity> nullAgainst,
                   List<Affinity> absorbAgainst, List<Affinity> reflectAgainst) {
        this.personaName = personaName;
        this.STRENGTH = STRENGTH;
        this.MAGIC = MAGIC;
        this.ENDURANCE = ENDURANCE;
        this.AGILITY = AGILITY;
        this.LUCK = LUCK;
        StrongAgainst = strongAgainst;
        WeakAgainst = weakAgainst;
        NullAgainst = nullAgainst;
        AbsorbAgainst = absorbAgainst;
        ReflectAgainst = reflectAgainst;
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

    public List<Affinity> getReflectAgainst() {
        return ReflectAgainst;
    }

    public void setMAGIC(int MAGIC) {
        if(MAGIC >= MAX_STAT)
            MAGIC = MAX_STAT;
        this.MAGIC = MAGIC;
    }

    public void setSTRENGTH(int STRENGTH) {
        if(STRENGTH >= MAX_STAT)
            STRENGTH = MAX_STAT;
        this.STRENGTH = STRENGTH;
    }

    public void setENDURANCE(int ENDURANCE) {
        if(ENDURANCE >= MAX_STAT)
            ENDURANCE = MAX_STAT;
        this.ENDURANCE = ENDURANCE;
    }

    public void setAGILITY(int AGILITY) {
        if(AGILITY >= MAX_STAT)
            AGILITY = MAX_STAT;
        this.AGILITY = AGILITY;
    }

    public void setLUCK(int LUCK) {
        if(LUCK >= MAX_STAT)
            LUCK = MAX_STAT;
        this.LUCK = LUCK;
    }

    public void addMAGIC(int MAGIC) {
        if(MAGIC >= MAX_STAT)
            MAGIC = MAX_STAT;
        this.MAGIC += MAGIC;
    }

    public void addSTRENGTH(int STRENGTH) {
        if(this.STRENGTH + STRENGTH >= MAX_STAT)
            STRENGTH = MAX_STAT - this.STRENGTH;
        this.STRENGTH += STRENGTH;
    }

    public void addENDURANCE(int ENDURANCE) {
        if(this.ENDURANCE + ENDURANCE >= MAX_STAT)
            ENDURANCE = MAX_STAT - this.ENDURANCE;
        this.ENDURANCE += ENDURANCE;
    }

    public void addAGILITY(int AGILITY) {
        if(this.AGILITY + AGILITY >= MAX_STAT)
            AGILITY = MAX_STAT - this.AGILITY;
        this.AGILITY += AGILITY;
    }

    public void addLUCK(int LUCK) {
        if(this.LUCK + LUCK >= MAX_STAT)
            LUCK = MAX_STAT - this.LUCK;
        this.LUCK += LUCK;
    }

    public float getMagicPercentage(){
        return (float)(this.MAGIC/MAX_STAT);
    }

    public float getStrengthPercentage(){
        return (float)(this.STRENGTH/MAX_STAT);
    }

    public float getEndurancePercentage(){
        return (float)(this.ENDURANCE/MAX_STAT);
    }

    public float getAgilityPercentage(){
        return (float)(this.AGILITY/MAX_STAT);
    }

    public float getLuckPercentage(){
        return (float)(this.LUCK/MAX_STAT);
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

    public void setReflectAgainst(List<Affinity> reflectAgainst) {
        ReflectAgainst = reflectAgainst;
    }

    public String getAffinityListAsString(List<Affinity> listing) {
        if(null == listing)
            return "";
        return listing.stream()
                .map(n -> n.toString())
                .collect(Collectors.joining(",","",""));
    }

    public String getPersonaName() {
        return personaName;
    }

    public void setPersonaName(String personaName) {
        this.personaName = personaName;
    }

    public boolean checkStrength(){
        return STRENGTH >= MAX_STAT;
    }

    public boolean checkMagic(){
        return STRENGTH >= MAX_STAT;
    }

    public boolean checkEndurance(){
        return STRENGTH >= MAX_STAT;
    }

    public boolean checkAgility(){
        return STRENGTH >= MAX_STAT;
    }

    public boolean checkLuck(){
        return STRENGTH >= MAX_STAT;
    }

}
