package net.slimpopo.personamod.networking.packet;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.entity.LevelEntityGetter;
import net.minecraftforge.network.NetworkEvent;
import net.slimpopo.personamod.entity.custom.constants.ControlledPersonaEntity;

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

            //Check if Persona is already summoned
            if(personaHasBeenSummoned(player,level)){
                //getPersona Entity
                ControlledPersonaEntity ownedEntity = getPersonaOwnedByPlayer(player,level);
                //create and Add Persona Attack Goal
//                ownedEntity.setCurrentSpellUsed("");
                //add Attack Nearest Target Goal

                //remove the previous 2 goals from entity

            }
            else{
                //Notify persona is not released
            }
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
