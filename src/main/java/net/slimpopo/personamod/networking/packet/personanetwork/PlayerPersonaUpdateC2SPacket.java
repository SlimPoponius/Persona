package net.slimpopo.personamod.networking.packet.personanetwork;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.NetworkEvent;
import net.slimpopo.personamod.capability.persona.PlayerPersonaProvider;
import net.slimpopo.personamod.constant.entity.ControlledPersona;
import net.slimpopo.personamod.networking.ModMessages;

import java.util.function.Supplier;

public class PlayerPersonaUpdateC2SPacket {
    public PlayerPersonaUpdateC2SPacket(){


    }
    public PlayerPersonaUpdateC2SPacket(FriendlyByteBuf buf){

    }
    public void toBytes(FriendlyByteBuf buf){


    }

    public boolean handle(Supplier<NetworkEvent.Context> supplier){
        NetworkEvent.Context context = supplier.get();
        context.enqueueWork(() -> {
            ServerPlayer player = context.getSender();
            player.getCapability(PlayerPersonaProvider.PLAYER_PERSONA).ifPresent(playerPersona -> {

                ControlledPersona cp =playerPersona.getControlledPersonaFromIndex(playerPersona.getCurrentPersonaIndex());

                ModMessages.sendToPlayer(new PlayerPersonaUpdateS2CPacket(playerPersona.getPersonaParty(),
                        playerPersona.getPersonaCount()), player);

            });
        });
        return true;
    }

}
