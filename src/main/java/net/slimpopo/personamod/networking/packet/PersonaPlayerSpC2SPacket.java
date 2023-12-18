package net.slimpopo.personamod.networking.packet;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.NetworkEvent;
import net.slimpopo.personamod.capability.persona.PlayerPersonaProvider;
import net.slimpopo.personamod.constant.entity.Persona;
import net.slimpopo.personamod.entity.custom.constants.ControlledPersonaEntity;
import net.slimpopo.personamod.networking.ModMessages;

import java.util.function.Supplier;

public class PersonaPlayerSpC2SPacket {


    public PersonaPlayerSpC2SPacket(){

    }

    public PersonaPlayerSpC2SPacket(FriendlyByteBuf buf){

    }

    public void toBytes(FriendlyByteBuf buf){

    }

    public boolean handle(Supplier<NetworkEvent.Context> supplier){
        NetworkEvent.Context context = supplier.get();
        context.enqueueWork(() -> {
           //HERE ON SERVER
            ServerPlayer player = context.getSender();
            ServerLevel level = player.serverLevel();

            player.getCapability(PlayerPersonaProvider.PLAYER_PERSONA).ifPresent( playerPersona -> {
                System.out.println("current sp: " + playerPersona.getSP());
                ModMessages.sendToPlayer(
                        new PersonaPlayerSpS2CPacket(playerPersona.getSP(), playerPersona.getMaxSP()),player);
            });
        });
        return true;
    }

    private boolean personaHasBeenSummoned(ServerPlayer player, ServerLevel level) {
        for(ControlledPersonaEntity entity: level.getEntitiesOfClass(ControlledPersonaEntity.class,player.getBoundingBox().inflate(5))){
            if(entity.getOwnerUUID().equals(player.getUUID()))
                return true;
        }
        return false;
    }


}
