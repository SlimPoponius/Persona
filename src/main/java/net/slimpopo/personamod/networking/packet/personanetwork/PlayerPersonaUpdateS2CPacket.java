package net.slimpopo.personamod.networking.packet.personanetwork;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.NetworkEvent;
import net.slimpopo.personamod.capability.persona.PlayerPersonaProvider;
import net.slimpopo.personamod.client.ClientPersonaSelectionData;
import net.slimpopo.personamod.client.ClientPlayerPersonaPartyData;
import net.slimpopo.personamod.constant.entity.ControlledPersona;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class PlayerPersonaUpdateS2CPacket {
    private final int partySize;
    private final List<ControlledPersona> personas;

    public PlayerPersonaUpdateS2CPacket(List<ControlledPersona> personas,int partySize){
        this.personas = personas;
        this.partySize = partySize;

    }

    public PlayerPersonaUpdateS2CPacket(FriendlyByteBuf buf){
        partySize = buf.readInt();
        personas = new ArrayList<>();
        for(int i = 0 ; i < partySize; i++) {
            personas.add(new ControlledPersona().readFromCompoundNbtData(buf.readNbt()));
        }

    }

    public void toBytes(FriendlyByteBuf buf){
        buf.writeInt(partySize);
        for(ControlledPersona controlledPersona: personas){
            buf.writeNbt(controlledPersona.createCompoundNBTData());
        }
    }

    public boolean handle(Supplier<NetworkEvent.Context> supplier){
        NetworkEvent.Context context = supplier.get();
        context.enqueueWork(() -> {
            ServerPlayer player = context.getSender();

            player.getCapability(PlayerPersonaProvider.PLAYER_PERSONA).ifPresent(playerPersona -> {
                ControlledPersona cp = playerPersona.getCurrentPersona();
                String currentPersona = cp.getPersonaName();
                String currentPersonaSkill = cp.getLearnedSkills().get(cp.getCurrentSelectedLearnedSkill())
                        .getSpellData().getSPELL_NAME();

                ClientPersonaSelectionData
                        .set(currentPersona,currentPersonaSkill,playerPersona.unlockedPersonaUse(),player);
            });
            ClientPlayerPersonaPartyData.set(personas);
        });
        return true;
    }

}
