package net.slimpopo.personamod.entity.custom.constants;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.Tag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.goal.FollowOwnerGoal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.slimpopo.personamod.capability.persona.PlayerPersonaProvider;
import net.slimpopo.personamod.constant.entity.ControlledPersona;
import net.slimpopo.personamod.constant.spell.Spell;
import net.slimpopo.personamod.item.constants.SpellList;
import net.slimpopo.personamod.networking.ModMessages;
import org.jetbrains.annotations.Nullable;

import java.util.UUID;

public class ControlledPersonaEntity extends TamableAnimal implements OwnableEntity {
    private SpellList spellList = new SpellList();
    private ControlledPersona personaData;

    protected ControlledPersonaEntity(EntityType<? extends TamableAnimal> pEntityType, Level pLevel,
                                      ControlledPersona persona) {
        super(pEntityType, pLevel);
        this.personaData = persona;
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(6, new FollowOwnerGoal(this, 1.0D, 10.0F, 2.0F, false));
    }

    public boolean hurt(DamageSource pSource, Spell spellInformation, float pAmount) {
        float multiplier = 1.0f;
        if(personaData.getWeakAgainst().contains(spellInformation.getAFFINITY())){
            multiplier = 1.5f;
        }
        else if(personaData.getStrongAgainst().contains(spellInformation.getAFFINITY())){
            multiplier = 0.5f;
        }
        else if(personaData.getAbsorbAgainst().contains(spellInformation.getAFFINITY())){
            this.heal(pAmount);
            return false;
        }
        else if(personaData.getNullAgainst().contains(spellInformation.getAFFINITY())){
            multiplier = 0.0f;
        }
        return super.hurt(pSource, pAmount * multiplier);
    }

    public SpellList getSpellList() {
        return spellList;
    }

    @Nullable
    @Override
    public AgeableMob getBreedOffspring(ServerLevel pLevel, AgeableMob pOtherParent) {
        return null;
    }

    @Override
    public void addAdditionalSaveData(CompoundTag pCompound) {
        super.addAdditionalSaveData(pCompound);
        pCompound.put("persona_data",personaData.createCompoundNBTData());
    }

    @Override
    public void readAdditionalSaveData(CompoundTag pCompound) {

        super.readAdditionalSaveData(pCompound);
        try{
            ControlledPersona cPersona = personaData.readFromCompoundNbtData(pCompound.get("persona_data"));
        }catch(Throwable throwable){
            this.die(damageSources().fellOutOfWorld());
        }
    }

    @Nullable
    @Override
    public UUID getOwnerUUID() {
        return this.uuid;
    }

//    @Override
//    public boolean killedEntity(ServerLevel pLevel, LivingEntity pEntity) {
//        if(pEntity instanceof PersonaEntity personaEntity){
//            int experienceGained = this.personaData.getPersonaLevel()
//                    .getExperienceTotal(personaEntity.getExperienceReward(),
//                    personaEntity.getPersonaData().getLEVEL());
//            this.personaData.getPersonaLevel().addExperience(personaEntity.getExperienceReward(),
//                    personaEntity.getPersonaData().getLEVEL());
//            if(this.getOwner() instanceof Player player){
//                player.getCapability(PlayerPersonaProvider.PLAYER_PERSONA).ifPresent(playerPersona -> {
//                    playerPersona.getControlledPersonaFromIndex(playerPersona.getIndexForPersona(this.personaData))
//                            .setPersonaLevel(personaData.getPersonaLevel());
//                    playerPersona.addSpExperience(experienceGained);
//                });
//
////                ModMessages.sendToPlayer(new );
//            }
//
//        }
//        return super.killedEntity(pLevel, pEntity);
//    }
}
