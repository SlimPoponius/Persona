package net.slimpopo.personamod.event;

import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.EntityJoinLevelEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.LogicalSide;
import net.minecraftforge.fml.common.Mod;
import net.slimpopo.personamod.PersonaMod;
import net.slimpopo.personamod.capability.persona.PlayerPersonaProvider;
import net.slimpopo.personamod.capability.persona.impl.PlayerPersona;
import net.slimpopo.personamod.client.ClientPersonaPlayerData;
import net.slimpopo.personamod.client.ClientPersonaPlayerPersonaData;
import net.slimpopo.personamod.constant.entity.ControlledPersona;
import net.slimpopo.personamod.damagesource.ModDamageTypes;
import net.slimpopo.personamod.entity.custom.constants.PersonaEntity;
import net.slimpopo.personamod.networking.ModMessages;
import net.slimpopo.personamod.networking.packet.PersonaPlayerPersonasS2CPacket;
import net.slimpopo.personamod.networking.packet.PersonaPlayerSpS2CPacket;
import net.slimpopo.personamod.networking.packet.PersonaPlayerUnlockS2CPacket;
import net.slimpopo.personamod.networking.packet.personanetwork.PlayerPersonaUpdateS2CPacket;


@Mod.EventBusSubscriber(modid = PersonaMod.MOD_ID)
public class ModEvents {

    @SubscribeEvent
    public static void onAttachCapabilitiesPlayer(AttachCapabilitiesEvent<Entity> event){
        if(event.getObject() instanceof Player){
            if(!event.getObject().getCapability(PlayerPersonaProvider.PLAYER_PERSONA).isPresent()){
                event.addCapability(new ResourceLocation(PersonaMod.MOD_ID,"personadata"),
                        new PlayerPersonaProvider());
            }
        }
    }

    @SubscribeEvent
    public static void onPlayerCloned(PlayerEvent.Clone event){
        if(event.isWasDeath()){
            event.getOriginal().getCapability(PlayerPersonaProvider.PLAYER_PERSONA).ifPresent(old -> {
                event.getOriginal().getCapability(PlayerPersonaProvider.PLAYER_PERSONA).ifPresent(newStore -> {
                    newStore.copyFrom(old);
                });
            });
        }
    }

    @SubscribeEvent
    public static void onRegisterCapabilities(RegisterCapabilitiesEvent event){
        event.register(PlayerPersona.class);
    }

    @SubscribeEvent
    public static void onPlayerTick(TickEvent.PlayerTickEvent event){
        if(event.side == LogicalSide.SERVER){
            event.player.getCapability(PlayerPersonaProvider.PLAYER_PERSONA).ifPresent(playerPersona -> {
                if(playerPersona.getSP() < playerPersona.getMaxSP() && event.player.getRandom().nextFloat() < 0.005f){
                    playerPersona.addSP(3);
                    System.out.println("On Player Tick Player Id: " + event.player.getUUID());
                    System.out.println("Mod Event Current Sp: " + playerPersona.getSP());

                }
                ModMessages.sendToPlayer(
                        new PersonaPlayerSpS2CPacket(playerPersona.getSP(),playerPersona.getMaxSP()),
                        ((ServerPlayer)event.player));
//                ModMessages.sendToPlayer(
//                        new PlayerPersonaUpdateS2CPacket(playerPersona.getPersonaParty(),
//                                playerPersona.getPersonaCount())
//                        ,((ServerPlayer)event.player));
//                if(ClientPersonaPlayerPersonaData.getUpdatedStatus()){
//                    playerPersona.getControlledPersonaFromIndex(ClientPersonaPlayerPersonaData.getPlayerPersonaIdx())
//                            .getPersonaLevel()
//                            .update(ClientPersonaPlayerPersonaData.getPlayerPersonaLvl(),
//                                    ClientPersonaPlayerPersonaData.getPlayerPersonaCurrentXp(),
//                                    ClientPersonaPlayerPersonaData.getPlayerPersonaNeededXp());
//                    playerPersona.getControlledPersonaFromIndex(ClientPersonaPlayerPersonaData.getPlayerPersonaIdx())
//                            .generateItemStacks();
//                }
            });
        }
    }

    @SubscribeEvent
    public static void onPlayerJoinedWorld(EntityJoinLevelEvent event){
        if(!event.getLevel().isClientSide){
            if(event.getEntity() instanceof ServerPlayer player){
                player.getCapability(PlayerPersonaProvider.PLAYER_PERSONA).ifPresent(playerPersona -> {
                    ModMessages.sendToPlayer(
                            new PersonaPlayerSpS2CPacket(playerPersona.getSP(), playerPersona.getMaxSP()),player);
                    ModMessages.sendToPlayer(
                            new PlayerPersonaUpdateS2CPacket(playerPersona.getPersonaParty(),
                                    playerPersona.getPersonaCount())
                            ,player);

                    if(playerPersona.getCurrentPersonaIndex() != -1) {
                        ControlledPersona pPersona = playerPersona
                                .getControlledPersonaFromIndex(playerPersona.getCurrentPersonaIndex());
                        ModMessages.sendToPlayer(new PersonaPlayerUnlockS2CPacket(playerPersona.unlockedPersonaUse(),
                                        pPersona.getPersonaName(),
                                        pPersona.getLearnedSkills().get(pPersona.getCurrentSelectedLearnedSkill())
                                                .getSpellData().getSPELL_NAME())
                                , player);
                    }
                });
            }
        }
    }

    @SubscribeEvent
    public static void onEntityDiedEvent(LivingDeathEvent event){
        if (event.getEntity() instanceof PersonaEntity persona) {
            if(event.getSource().getEntity() instanceof Player player){
                player.getCapability(PlayerPersonaProvider.PLAYER_PERSONA).ifPresent(playerPersona -> {
                    playerPersona.addSpExperience(playerPersona
                            .calculateExperienceGained(persona.getPersonaData().getEXPERIENCE(),
                                    persona.getPersonaData().getLEVEL()));
                    playerPersona.getCurrentPersona().getPersonaLevel().addExperience(4,
                            persona.getPersonaData().getLEVEL());
                    player.sendSystemMessage(Component
                            .literal("Current Max Health is: " + player.getMaxHealth()));

                    ModMessages.sendToPlayer(
                            new PersonaPlayerSpS2CPacket(playerPersona.getSP(),playerPersona.getMaxSP()),
                            (ServerPlayer) player);

                    ModMessages.sendToPlayer(
                            new PlayerPersonaUpdateS2CPacket(playerPersona.getPersonaParty(),
                                    playerPersona.getPersonaCount())
                            ,(ServerPlayer) player);

                });
            }
        }
    }
}
