package net.slimpopo.personamod.networking.packet;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.network.NetworkEvent;
import net.slimpopo.personamod.client.ClientPersonaPlayerPersonaData;
import net.slimpopo.personamod.client.ClientPersonaSelectionData;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class PersonaPlayerUnlockS2CPacket {
    private final boolean unlockPersona;
    private final String currentSelectedPersona;
    private final String currentSelectedPersonaSkill;

    public PersonaPlayerUnlockS2CPacket(boolean unlockPersona, String currentSelectedPersona,
                                        String currentSelectedPersonaSkill){
        this.unlockPersona = unlockPersona;
        this.currentSelectedPersona = currentSelectedPersona;
        this.currentSelectedPersonaSkill = currentSelectedPersonaSkill;
    }

    public PersonaPlayerUnlockS2CPacket(FriendlyByteBuf buf){
        this.unlockPersona = buf.readBoolean();
        this.currentSelectedPersona = buf.readUtf();
        this.currentSelectedPersonaSkill = buf.readUtf();
    }

    public void toBytes(FriendlyByteBuf buf){
        buf.writeBoolean(unlockPersona);
        buf.writeUtf(currentSelectedPersona);
        buf.writeUtf(currentSelectedPersonaSkill);
    }

    public boolean handle(Supplier<NetworkEvent.Context> supplier){
        NetworkEvent.Context context = supplier.get();
        context.enqueueWork(() -> {
            ClientPersonaSelectionData.set(currentSelectedPersona, currentSelectedPersonaSkill, unlockPersona);
        });
        return true;
    }

}
