package net.slimpopo.personamod.networking.packet.personanetwork;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.NetworkEvent;
import net.slimpopo.personamod.capability.persona.PlayerPersonaProvider;
import net.slimpopo.personamod.client.ClientPersonaSelectionData;
import net.slimpopo.personamod.constant.entity.ControlledPersona;
import net.slimpopo.personamod.networking.ModMessages;
import net.slimpopo.personamod.networking.packet.PersonaPlayerUnlockS2CPacket;

import java.util.function.Supplier;

public class PlayerPersonaUpdateCurrentPersonaC2SPacket {
    public PlayerPersonaUpdateCurrentPersonaC2SPacket(){


    }
    public PlayerPersonaUpdateCurrentPersonaC2SPacket(FriendlyByteBuf buf){

    }
    public void toBytes(FriendlyByteBuf buf){


    }

    public boolean handle(Supplier<NetworkEvent.Context> supplier){
        NetworkEvent.Context context = supplier.get();
        context.enqueueWork(() -> {
            ServerPlayer player = context.getSender();
            player.getCapability(PlayerPersonaProvider.PLAYER_PERSONA).ifPresent(playerPersona -> {
                int personaIdx = (playerPersona.getCurrentPersonaIndex() + 1 < playerPersona.getPersonaCount() - 1) ?
                        playerPersona.getCurrentPersonaIndex() + 1 : 0;
                playerPersona.setCurrentPersonaIndex(personaIdx);
                ControlledPersona cp = playerPersona.getControlledPersonaFromIndex(playerPersona.getCurrentPersonaIndex());
                int skillIdx = cp.getCurrentSelectedLearnedSkill();
                playerPersona.getControlledPersonaFromIndex(playerPersona.getCurrentPersonaIndex())
                        .setCurrentSelectedLearnedSkill(skillIdx);

                String currentPersona = cp.getPersonaName();
                String currentPersonaSkill = cp.getLearnedSkills().get(cp.getCurrentSelectedLearnedSkill())
                        .getSpellData().getSPELL_NAME();

                ClientPersonaSelectionData.set(currentPersona,currentPersonaSkill,playerPersona.unlockedPersonaUse());
                ModMessages.sendToPlayer(new PersonaPlayerUnlockS2CPacket(playerPersona.unlockedPersonaUse(),currentPersona,
                        currentPersonaSkill), player);

            });
        });
        return true;
    }

}
