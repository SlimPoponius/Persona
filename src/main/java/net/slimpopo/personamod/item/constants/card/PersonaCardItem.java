package net.slimpopo.personamod.item.constants.card;

import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.slimpopo.personamod.capability.persona.PlayerPersonaProvider;
import net.slimpopo.personamod.capability.persona.impl.PlayerPersona;
import net.slimpopo.personamod.constant.entity.ControlledPersona;
import net.slimpopo.personamod.entity.custom.constants.ControlledPersonaList;
import net.slimpopo.personamod.item.constants.SpellItemList;
import net.slimpopo.personamod.networking.ModMessages;
import net.slimpopo.personamod.networking.packet.PersonaPlayerPersonasS2CPacket;
import net.slimpopo.personamod.networking.packet.PersonaPlayerSpS2CPacket;
import net.slimpopo.personamod.networking.packet.PersonaPlayerUnlockS2CPacket;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class PersonaCardItem extends CardItem {
    private ControlledPersona persona;

    public PersonaCardItem(Properties pProperties) {
        super(pProperties);
        this.persona = ControlledPersonaList.getRandomPersona();
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        AtomicBoolean hasFailed = new AtomicBoolean(false);

        if(pPlayer.getItemInHand(pUsedHand).hasTag()){
            persona = ControlledPersonaList.getDataFromList(pPlayer.getItemInHand(pUsedHand)
                    .getTag().getString("personamod.personacarddata"));
        }

        if(!pLevel.isClientSide){
            pPlayer.getCapability(PlayerPersonaProvider.PLAYER_PERSONA)
                    .ifPresent(playerPersona -> {
                        if(playerPersona.unlockedPersonaUse() && playerPersona.getPersonaCount() < 6 &&
                           !playerPersona.findControlledPersonaWithName(persona.getPersonaName())){
                            playerPersona.addToCurrentPersonaListing(persona);
                        }
                        else if(playerPersona.getPersonaCount() > 6){
                            if(null != Minecraft.getInstance().player) {
                                Minecraft.getInstance().player.sendSystemMessage(
                                        Component.literal("Party size is too big"));
                            }
                            hasFailed.set(true);
                        }
                        else if(!playerPersona.unlockedPersonaUse()){
                            playerPersona.setPersonaFlag(true);
                            playerPersona.addToCurrentPersonaListing(persona);

                        }
                        else{
                            if(null != Minecraft.getInstance().player) {
                                Minecraft.getInstance().player.sendSystemMessage(
                                        Component.literal("Persona already exists in party"));
                            }
                            hasFailed.set(true);
                        }
                        ModMessages.sendToPlayer(new PersonaPlayerUnlockS2CPacket(playerPersona.unlockedPersonaUse(),
                                playerPersona.getControlledPersonaFromIndex(playerPersona.getCurrentPersonaIndex())
                                        .getPersonaName(),
                                playerPersona.getControlledPersonaFromIndex(playerPersona.getCurrentPersonaIndex())
                                        .getLearnedSkills().get(0).getSpellData().getSPELL_NAME()),
                                (ServerPlayer) pPlayer);
                        sendPersonaDataToClient((ServerPlayer) pPlayer,playerPersona,
                                playerPersona.getControlledPersonaFromIndex(playerPersona.getPersonaCount()-1));

                    });
        }
        if(hasFailed.get()){
            return InteractionResultHolder.fail(pPlayer.getItemInHand(pUsedHand));
        }
        if(null != Minecraft.getInstance().player) {
            Minecraft.getInstance().player.sendSystemMessage(
                    Component.literal("You have obtained: " + persona.getPersonaName()));
        }
        return super.use(pLevel, pPlayer, pUsedHand);
    }

    public void sendPersonaDataToClient(ServerPlayer pPlayer, PlayerPersona data, ControlledPersona controlledPersona){
        ModMessages.sendToPlayer(
                new PersonaPlayerPersonasS2CPacket(data.getCurrentPersonaIndex(),
                        controlledPersona.getPersonaLevel().getCurrentLevel(),
                        controlledPersona.getPersonaLevel().getCurrentXp(),
                        controlledPersona.getPersonaLevel().getNeededXP(),
                        controlledPersona.getSTRENGTH(),
                        controlledPersona.getMAGIC(),
                        controlledPersona.getAGILITY(),
                        controlledPersona.getENDURANCE(),
                        controlledPersona.getLUCK(), controlledPersona.getSkillNameList(),
                        controlledPersona.getLearnedSkills().size())
                , pPlayer);
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        if(pStack.hasTag()){
            persona = ControlledPersonaList.getDataFromList(pStack
                    .getTag().getString("personamod.personacarddata"));
        }
        pTooltipComponents.add(Component.literal("Persona: " + persona.getPersonaName()));
        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
    }

    public ControlledPersona getPersona() {
        return persona;
    }
}
