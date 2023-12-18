package net.slimpopo.personamod.networking.packet;

import net.minecraft.client.Minecraft;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.network.NetworkEvent;
import net.slimpopo.personamod.capability.persona.PlayerPersonaProvider;
import net.slimpopo.personamod.client.ClientPersonaPlayerData;
import net.slimpopo.personamod.entity.custom.constants.ControlledPersonaEntity;

import java.util.function.Supplier;

public class PersonaPlayerSpS2CPacket {
    private final int currentSp;
    private final int maxSp;

    public PersonaPlayerSpS2CPacket(int currentSp, int maxSp){
        this.currentSp = currentSp;
        this.maxSp = maxSp;

    }

    public PersonaPlayerSpS2CPacket(FriendlyByteBuf buf){
        this.currentSp = buf.readInt();
        this.maxSp = buf.readInt();
    }

    public void toBytes(FriendlyByteBuf buf){

        buf.writeInt(currentSp);
        buf.writeInt(maxSp);
    }

    public boolean handle(Supplier<NetworkEvent.Context> supplier){
        NetworkEvent.Context context = supplier.get();
        context.enqueueWork(() -> {

            ClientPersonaPlayerData.set((float)currentSp/maxSp);


        });
        return true;
    }

}
