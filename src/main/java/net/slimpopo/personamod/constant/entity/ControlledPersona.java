package net.slimpopo.personamod.constant.entity;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.Tag;
import net.minecraft.world.item.ItemStack;
import net.slimpopo.personamod.constant.damage.Affinity;
import net.slimpopo.personamod.constant.entity.level.PersonaLevel;
import net.slimpopo.personamod.constant.entity.level.SkillLearnedLevel;
import net.slimpopo.personamod.constant.spell.Spell;
import net.slimpopo.personamod.item.constants.SpellItem;
import net.slimpopo.personamod.item.constants.SpellItemList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class ControlledPersona extends Persona{


    private List<SpellItem> learnedSkills;
    private List<SkillLearnedLevel> learnedSkillsFromLevel;
    private List<ItemStack> learnedItems;
    private List<String> learnedSkillList;
    private PersonaLevel personaLevel;
    private UUID playerOwnerId;

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
                .map(skill -> skill.getSpellItemRelated())
                .collect(Collectors.toList());

        for (SpellItem i: skills) {
            if(!learnedItems.contains(i))
                learnedItems.add(new ItemStack(i));
        }
    }

    private void generateLearnedSpellList() {
        learnedSkillList = learnedSkills.stream()
                .map(n -> n.getSpellData().getSPELL_NAME())
                .collect(Collectors.toList());
    }

    private String returnSpellListing(){
        return learnedSkillList.stream()
                .map(n -> n.toString())
                .collect(Collectors.joining(",","",""));
    }

    public List<SpellItem> getLearnedSkills() {
        return learnedSkills;
    }

    public void setLearnedSkills(List<SpellItem> learnedSkills) {
        this.learnedSkills = learnedSkills;
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

        //personaNbt.putUUID("owned_by",playerOwnerId);
        personaNbt.putInt("persona_strength",getSTRENGTH());
        personaNbt.putInt("persona_magic",getMAGIC());
        personaNbt.putInt("persona_endurance",getENDURANCE());
        personaNbt.putInt("persona_agility",getAGILITY());
        personaNbt.putInt("persona_luck",getLUCK());
        personaNbt.putString("persona_str_against",getListString(getStrongAgainst()));
        personaNbt.putString("persona_wk_against",getListString(getWeakAgainst()));
        personaNbt.putString("persona_nil_against",getListString(getNullAgainst()));
        personaNbt.putString("persona_abs_against",getListString(getAbsorbAgainst()));
        personaNbt.putString("persona_abs_against",getListString(getReflectAgainst()));
        personaNbt.putString("persona_cur_skills",returnSpellListing());
        personaNbt.put("persona_level_data",personaLevel.createCompoundNBTData());

        return null;
    }

    public ControlledPersona readFromCompoundNbtData(Tag persona_data) {
        CompoundTag actualData = (CompoundTag)persona_data;
        this.setSTRENGTH(actualData.getInt("persona_strength"));
        this.setMAGIC(actualData.getInt("persona_magic"));
        this.setENDURANCE(actualData.getInt("persona_endurance"));
        this.setAGILITY(actualData.getInt("persona_agility"));
        this.setLUCK(actualData.getInt("persona_luck"));
        this.setStrongAgainst(convertToList(actualData.getString("persona_str_against")));
        this.setWeakAgainst(convertToList(actualData.getString("persona_wk_against")));
        this.setNullAgainst(convertToList(actualData.getString("persona_nil_against")));
        this.setAbsorbAgainst(convertToList(actualData.getString("persona_abs_against")));
        this.setAbsorbAgainst(convertToList(actualData.getString("persona_ref_against")));
        this.setLearnedSkills(getListFromData(actualData.getString("persona_cur_skills")));
        PersonaLevel levelData = personaLevel.readCompoundNBTData(actualData.get("persona_level_data"));
        return this;
    }


    private List<SpellItem> getListFromData(String stringData) {
        var listFromString = Arrays.stream(stringData.split(",")).toList();
        List<SpellItem> spellItems = new ArrayList<>();

        for(String str: listFromString){
            spellItems.add(SpellItemList.getSpellItem(str));
        }

        return spellItems;

    }

    private List<Affinity> convertToList(String stringData) {
        var listFromString = Arrays.stream(stringData.split(",")).toList();
        List<Affinity> affinities = new ArrayList<>();

        for(String str: listFromString){
            affinities.add(Affinity.valueOf(str));
        }

        return affinities;
    }

    public boolean hasLearnedSkill(String spell_name) {
        return learnedSkills.stream().anyMatch(x -> x.getSpellData().getSPELL_NAME().equalsIgnoreCase(spell_name));
    }

    public String[] getSkillNameList() {
        return (String[]) learnedSkills.stream()
                .map(spell -> spell.getSpellData().getSPELL_NAME())
                .collect(Collectors.toList())
                .toArray();
    }
}
