package net.slimpopo.personamod.networking.packet;

import net.minecraft.client.Minecraft;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.entity.LevelEntityGetter;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraftforge.network.NetworkEvent;
import net.slimpopo.personamod.capability.persona.PlayerPersonaProvider;
import net.slimpopo.personamod.constant.entity.ControlledPersona;
import net.slimpopo.personamod.entity.custom.constants.ControlledPersonaEntity;
import net.slimpopo.personamod.item.constants.SpellItem;
import net.slimpopo.personamod.item.constants.SupportSpellItem;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public class PersonaAttackC2SPacket {
    public PersonaAttackC2SPacket(){

    }

    public PersonaAttackC2SPacket(FriendlyByteBuf buf){

    }

    public void toBytes(FriendlyByteBuf buf){

    }

    public boolean handle(Supplier<NetworkEvent.Context> supplier){
        NetworkEvent.Context context = supplier.get();
        context.enqueueWork(() -> {
           //HERE ON SERVER
            ServerPlayer player = context.getSender();
            ServerLevel level = player.serverLevel();
            player.getCapability(PlayerPersonaProvider.PLAYER_PERSONA)
                    .ifPresent(playerPersona -> {


                        //Check if Persona is already summoned
                        if(personaHasBeenSummoned(player,level)){

                            //getPersona Entity
                            ControlledPersona controlledPersona = playerPersona
                                    .getControlledPersonaFromIndex(playerPersona.getCurrentPersonaIndex());

                            ItemStack spellChosen = controlledPersona.getLearnedItems()
                                    .get(controlledPersona.getCurrentSelectedLearnedSkill());

                            ItemStack heldItem = player.getMainHandItem();

                            player.setItemInHand(InteractionHand.MAIN_HAND, spellChosen);
                            if(spellChosen.getItem() instanceof SupportSpellItem supportSpellItem) {
                                supportSpellItem.setCaster(player);
                                if (player.getMainHandItem().useOn(
                                        new UseOnContext(player, InteractionHand.MAIN_HAND,
                                                new BlockHitResult(player.blockPosition().getCenter(),
                                                        player.getDirection(), player.blockPosition(), true)))
                                        != InteractionResult.SUCCESS) {
                                    player.getMainHandItem().use(level, player, InteractionHand.MAIN_HAND);
                                }
                            }
                            else {
                                player.getMainHandItem().use(level, player, InteractionHand.MAIN_HAND);
                            }
                            player.setItemInHand(InteractionHand.MAIN_HAND, heldItem);
                        }
                        else{
                            //Notify persona is not released
                            Minecraft.getInstance().player
                                    .sendSystemMessage(
                                            Component.literal("You have not released you persona to use a skill."));
                        }

                    });

        });
        return true;
    }

    private ControlledPersonaEntity getPersonaOwnedByPlayer(ServerPlayer player, ServerLevel level) {
        for(ControlledPersonaEntity entity: level.getEntitiesOfClass(ControlledPersonaEntity.class,player.getBoundingBox().inflate(5))){
            if(entity.getOwnerUUID().equals(player.getUUID()))
                return entity;
        }
        return null;
    }

    private boolean personaHasBeenSummoned(ServerPlayer player, ServerLevel level) {
        for(ControlledPersonaEntity entity: level.getEntitiesOfClass(ControlledPersonaEntity.class,player.getBoundingBox().inflate(5))){
            if(entity.getOwnerUUID().equals(player.getUUID()))
                return true;
        }
        return false;
    }


}
