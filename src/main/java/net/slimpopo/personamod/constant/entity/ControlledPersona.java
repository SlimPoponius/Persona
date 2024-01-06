package net.slimpopo.personamod.constant.entity;

import net.minecraft.client.Minecraft;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.Tag;
import net.minecraft.world.item.ItemStack;
import net.slimpopo.personamod.constant.damage.Affinity;
import net.slimpopo.personamod.constant.entity.level.DamageLevelIdentifier;
import net.slimpopo.personamod.constant.entity.level.PersonaLevel;
import net.slimpopo.personamod.constant.entity.level.SkillLearnedLevel;
import net.slimpopo.personamod.constant.spell.Spell;
import net.slimpopo.personamod.item.constants.SpellItem;
import net.slimpopo.personamod.item.constants.SpellItemList;

import java.util.*;
import java.util.stream.Collectors;

public class ControlledPersona extends Persona{


    private List<SpellItem> learnedSkills = new ArrayList<>();
    private List<SkillLearnedLevel> learnedSkillsFromLevel = new ArrayList<>();
    private List<ItemStack> learnedItems = new ArrayList<>();
    private List<String> learnedSkillList = new ArrayList<>();

    private PersonaLevel personaLevel;

    private UUID playerOwnerId;

    private int currentSelectedLearnedSkill;

    public ControlledPersona(){
        super();
        personaLevel = new PersonaLevel(1);
    }

    public ControlledPersona(String personaName,PersonaLevel level, int STRENGTH, int MAGIC, int ENDURANCE, int AGILITY, int LUCK,
                             List<Affinity> strongAgainst, List<Affinity> weakAgainst, List<Affinity> nullAgainst,
                             List<Affinity> absorbAgainst, List<SpellItem> learnedSkills,
                             List<SkillLearnedLevel> learnedSkillsFromLevel, List<Affinity> reflectAgainst) {
        super(personaName,STRENGTH, MAGIC, ENDURANCE, AGILITY, LUCK, strongAgainst, weakAgainst,
                nullAgainst, absorbAgainst,reflectAgainst);
        this.learnedSkills = learnedSkills;
        this.personaLevel = level;
        this.learnedSkillsFromLevel = learnedSkillsFromLevel;
        generateLearnedSpellList();
        generateItemStacks();
    }

    public void setPlayerOwnerId(UUID playerOwnerId) {
        this.playerOwnerId = playerOwnerId;
    }

    public UUID getPlayerOwnerId() {
        return playerOwnerId;
    }

    public void generateItemStacks() {
       learnedItems = new ArrayList<>();
        var skills = learnedSkillsFromLevel.stream()
                .filter(skill -> personaLevel.getCurrentLevel() >= skill.getLevelRequired())
                .map(SkillLearnedLevel::getSpellItemRelated).toList();

        for (SpellItem i: skills) {
            if(!learnedItems.contains(i))
                learnedItems.add(new ItemStack(i,1));
        }
    }

    private void generateLearnedSpellList() {
        learnedSkillList = learnedSkills.stream()
                .map(n -> n.getSpellData().getSPELL_NAME())
                .collect(Collectors.toList());

        if(currentSelectedLearnedSkill == -1) currentSelectedLearnedSkill = 0;
    }

    private String returnSpellListing(){
        return learnedSkillList.stream()
                .collect(Collectors.joining(",","",""));
    }

    public List<SpellItem> getLearnedSkills() {
        return learnedSkills;
    }

    public void setLearnedSkills(List<SpellItem> learnedSkills) {
        this.learnedSkills = learnedSkills;
        generateLearnedSpellList();
    }

    public PersonaLevel getPersonaLevel() {
        return personaLevel;
    }

    public void setPersonaLevel(PersonaLevel personaLevel) {
        this.personaLevel = personaLevel;
    }

    public List<SkillLearnedLevel> getLearnedSkillsFromLevel() {
        return learnedSkillsFromLevel;
    }

    public void addSkillToSkillList(SkillLearnedLevel skill){
        this.learnedSkillsFromLevel.add(skill);
    }

    public CompoundTag createCompoundNBTData(){
        CompoundTag personaNbt = new CompoundTag();

        personaNbt.putUUID("owned_by",playerOwnerId);
        personaNbt.putString("persona_name",getPersonaName());
        personaNbt.putInt("persona_strength",getSTRENGTH());
        personaNbt.putInt("persona_magic",getMAGIC());
        personaNbt.putInt("persona_endurance",getENDURANCE());
        personaNbt.putInt("persona_agility",getAGILITY());
        personaNbt.putInt("persona_luck",getLUCK());
        personaNbt.putInt("cur_persona_sel_skill",getCurrentSelectedLearnedSkill());
        personaNbt.putInt("learned_skills_size", learnedSkillsFromLevel.size());
        personaNbt.putString("persona_str_against", getAffinityListAsString(getStrongAgainst()));
        personaNbt.putString("persona_wk_against", getAffinityListAsString(getWeakAgainst()));
        personaNbt.putString("persona_nil_against", getAffinityListAsString(getNullAgainst()));
        personaNbt.putString("persona_abs_against", getAffinityListAsString(getAbsorbAgainst()));
        personaNbt.putString("persona_abs_against", getAffinityListAsString(getReflectAgainst()));
        personaNbt.putString("persona_cur_skills",returnSpellListing());
        personaNbt.put("persona_level_data",personaLevel.createCompoundNBTData());
        for(int i = 0; i < learnedSkillsFromLevel.size();i++){
            personaNbt.put("learned_skill_"+i,
                    learnedSkillsFromLevel.get(i).createCompoundNBTData());
        }
        return personaNbt;
    }

    public ControlledPersona readFromCompoundNbtData(Tag persona_data) {
        CompoundTag actualData = (CompoundTag)persona_data;
        this.setPlayerOwnerId(actualData.getUUID("owned_by"));
        this.setPersonaName(actualData.getString("persona_name"));
        this.setSTRENGTH(actualData.getInt("persona_strength"));
        this.setMAGIC(actualData.getInt("persona_magic"));
        this.setENDURANCE(actualData.getInt("persona_endurance"));
        this.setAGILITY(actualData.getInt("persona_agility"));
        this.setLUCK(actualData.getInt("persona_luck"));
        this.setCurrentSelectedLearnedSkill(actualData.getInt("cur_persona_sel_skill"));
        this.setStrongAgainst(convertToList(actualData.getString("persona_str_against")));
        this.setWeakAgainst(convertToList(actualData.getString("persona_wk_against")));
        this.setNullAgainst(convertToList(actualData.getString("persona_nil_against")));
        this.setAbsorbAgainst(convertToList(actualData.getString("persona_abs_against")));
        this.setAbsorbAgainst(convertToList(actualData.getString("persona_ref_against")));
        this.setLearnedSkills(getListFromData(actualData.getString("persona_cur_skills")));
        this.personaLevel.readCompoundNBTData(actualData.get("persona_level_data"));

        int sll = actualData.getInt("learned_skills_size");
        for(int i = 0; i < sll;i++){
            SkillLearnedLevel skillLearnedLevel = new SkillLearnedLevel();
            learnedSkillsFromLevel.add(skillLearnedLevel.loadCompoundNBTData(actualData.get("learned_skill_"+i)));
        }

        updateAllSkillLists();
        return this;

    }

    public void updateAllSkillLists() {
        generateLearnedSpellList();
        generateLearnedSpellItemsList();
        generateLearnedSkillList();
        generateItemStacks();
    }

    private void generateLearnedSkillList() {
        this.learnedSkillList = learnedSkillsFromLevel.stream()
                .map(spellName -> spellName.getSpellItemRelated().getSpellData().getSPELL_NAME())
                .collect(Collectors.toList());
    }

    private void generateLearnedSpellItemsList() {
        this.learnedSkills = learnedSkillsFromLevel.stream()
                .map(SkillLearnedLevel::getSpellItemRelated)
                .collect(Collectors.toList());
    }


    private List<SpellItem> getListFromData(String stringData) {
        if(stringData.isEmpty())
            return new ArrayList<>();

        List<String> listFromString = new ArrayList<>(Arrays.stream(stringData.split(",")).toList());
        listFromString.removeAll(Arrays.asList("",null));
        List<SpellItem> spellItems = new ArrayList<>();

        if(!listFromString.isEmpty()) {
            for (String str : listFromString) {
                spellItems.add(SpellItemList.getSpellItem(str));
            }
        }

        return spellItems;

    }

    private List<Affinity> convertToList(String stringData) {
        if(stringData.isEmpty())
            return new ArrayList<>();

        List<String> listFromString = new ArrayList<>(Arrays.stream(stringData.split(",")).toList());
        listFromString.removeAll(Arrays.asList("",null));
        List<Affinity> affinities = new ArrayList<>();

        if(!listFromString.isEmpty()) {
            for (String str : listFromString) {
                affinities.add(Affinity.valueOf(str));
            }
        }

        return affinities;
    }

    public boolean hasLearnedSkill(String spell_name) {
        return learnedSkills.stream().anyMatch(x -> x.getSpellData().getSPELL_NAME().equalsIgnoreCase(spell_name));
    }

    public int getCurrentSelectedLearnedSkill() {
        return currentSelectedLearnedSkill;
    }

    public void setCurrentSelectedLearnedSkill(int currentSelectedLearnedSkill) {
        this.currentSelectedLearnedSkill = currentSelectedLearnedSkill;
    }

    public String[] getSkillNameList() {
        return (String[]) learnedSkills.stream()
                .map(spell -> spell.getSpellData().getSPELL_NAME()).toList()
                .toArray(new String[learnedSkills.size()]);
    }

    public List<ItemStack> getLearnedItems() {
        return learnedItems;
    }

    @Override
    public float getDamageNumberBasedOnSpell(Spell spell, Persona source) {
        int level = 1;


        if(spell.isHasBeenRepelled() && this.getReflectAgainst().contains(spell.getAFFINITY())){
            return 0f;
        }

        float base_power = (float)(Math.max(Math.sqrt(spell.getDAMAGE_TYPE().getDamageMultiplier()) *
                Math.sqrt(source.getCorrespondingStatToSpell(spell)),1));

        float total_power = (float) (base_power/(Math.sqrt((source.getENDURANCE() * 8))));

        if(source instanceof ControlledPersona cp) {
            level = cp.getPersonaLevel().getCurrentLevel();
        }

        if(source instanceof MobPersona cp) {
            level = cp.getLEVEL();
        }

        float damageScaleBasedOnLevel = DamageLevelIdentifier
                .getDamageMultiplierBasedOnLevel(level, this.getPersonaLevel().getCurrentLevel());

        float damageScaleBasedOnElement = this.checkAffinityResistance(spell);

        return total_power * damageScaleBasedOnElement * damageScaleBasedOnLevel;
    }

    public void CheckForUpdate(){
        if(personaLevel.isHasLeveledUp()){
            updateStats();
            updateAllSkillLists();
            personaLevel.setHasLeveledUp(false);
        }
    }

    private void updateStats() {
        for(int i =0; i< 3; i++){
            addStatPointToRandomStat();
        }
    }

    private void addStatPointToRandomStat() {
        Random random = new Random();
        int chosenStat = Math.abs(random.nextInt()%5);

        switch (chosenStat){
            default -> addSTRENGTH(1);
            case 0 -> addSTRENGTH(1);
            case 1 -> addMAGIC(1);
            case 2 -> addAGILITY(1);
            case 3 -> addENDURANCE(1);
            case 4 -> addLUCK(1);
        }

    }
}
