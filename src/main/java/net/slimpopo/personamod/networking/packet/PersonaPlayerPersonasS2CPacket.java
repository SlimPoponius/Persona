package net.slimpopo.personamod.networking.packet;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.network.NetworkEvent;
import net.slimpopo.personamod.client.ClientPersonaPlayerPersonaData;

import java.util.function.Supplier;

public class PersonaPlayerPersonasS2CPacket {
    private final int personaIdx;
    private final int personaLvl;
    private final int currentXp;
    private final int neededXp;

    public PersonaPlayerPersonasS2CPacket(int personaIdx, int personaLvl, int currentXp, int neededXp){
        this.personaIdx = personaIdx;
        this.personaLvl = personaLvl;
        this.currentXp  = currentXp;
        this.neededXp   = neededXp;

    }

    public PersonaPlayerPersonasS2CPacket(FriendlyByteBuf buf){
        this.personaIdx = buf.readInt();
        this.personaLvl = buf.readInt();
        this.currentXp = buf.readInt();
        this.neededXp = buf.readInt();
    }

    public void toBytes(FriendlyByteBuf buf){
        buf.writeInt(personaIdx);
        buf.writeInt(personaLvl);
        buf.writeInt(currentXp);
        buf.writeInt(neededXp);
    }

    public boolean handle(Supplier<NetworkEvent.Context> supplier){
        NetworkEvent.Context context = supplier.get();
        context.enqueueWork(() -> {
            ClientPersonaPlayerPersonaData.set(personaIdx,personaLvl,currentXp,neededXp);
        });
        return true;
    }

}
