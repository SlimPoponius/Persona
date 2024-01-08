package net.slimpopo.personamod.item.constants.card;

import net.minecraft.client.Minecraft;
import net.minecraft.nbt.CompoundTag;
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
import net.slimpopo.personamod.networking.packet.personanetwork.PlayerPersonaUpdateS2CPacket;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class PersonaCardItem extends CardItem {
    private final String personaNameKey = "key.personamod.personaname";

    private ControlledPersona persona;

    public PersonaCardItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        AtomicBoolean hasFailed = new AtomicBoolean(false);

        if(pPlayer.getItemInHand(pUsedHand).hasTag() &&
                !pPlayer.getItemInHand(pUsedHand)
                        .getTag().getString("personamod.personacarddata").isEmpty()){
            persona = ControlledPersonaList.getDataFromList(pPlayer.getItemInHand(pUsedHand)
                    .getTag().getString("personamod.personacarddata"));
        }
        else{
            randomizeItemOnRightClick();
            addNbtDataToItem(pPlayer.getItemInHand(pUsedHand));
            return InteractionResultHolder.success(pPlayer.getItemInHand(pUsedHand));
        }

        if(!pLevel.isClientSide){
            pPlayer.getCapability(PlayerPersonaProvider.PLAYER_PERSONA)
                    .ifPresent(playerPersona -> {
                        if(playerPersona.unlockedPersonaUse() && playerPersona.getPersonaCount() < 6 &&
                           !playerPersona.findControlledPersonaWithName(persona.getPersonaName())){
                            persona.setPlayerOwnerId(pPlayer.getUUID());
                            playerPersona.addToCurrentPersonaListing(persona);
                            postCompletionMessage(playerPersona);
                            ModMessages.sendToPlayer(
                                    new PlayerPersonaUpdateS2CPacket(playerPersona.getPersonaParty(),
                                            playerPersona.getPersonaCount())
                                    ,(ServerPlayer) pPlayer);
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
                            persona.setPlayerOwnerId(pPlayer.getUUID());
                            playerPersona.addToCurrentPersonaListing(persona);
                            postCompletionMessage(playerPersona);
                            ModMessages.sendToPlayer(new PersonaPlayerUnlockS2CPacket(playerPersona.unlockedPersonaUse(),
                                            playerPersona.getControlledPersonaFromIndex(0)
                                                    .getPersonaName(),
                                            playerPersona.getControlledPersonaFromIndex(playerPersona.getCurrentPersonaIndex())
                                                    .getLearnedSkills().get(0).getSpellData().getSPELL_NAME())
                                    ,(ServerPlayer) pPlayer);
                        }
                        else{
                            if(null != Minecraft.getInstance().player) {
                                Minecraft.getInstance().player.sendSystemMessage(
                                        Component.literal("Persona already exists in party"));
                            }
                            hasFailed.set(true);
                        }
                    });
        }
        if(hasFailed.get()){
            return InteractionResultHolder.fail(pPlayer.getItemInHand(pUsedHand));
        }

        pPlayer.setItemInHand(pUsedHand,ItemStack.EMPTY);
        return super.use(pLevel, pPlayer, pUsedHand);
    }

    private void postCompletionMessage(PlayerPersona playerPersona) {
        if(null != Minecraft.getInstance().player) {
            Minecraft.getInstance().player.sendSystemMessage(
                    Component.literal("You have obtained: " + persona.getPersonaName() + "!"));
            Minecraft.getInstance().player.sendSystemMessage(
                    Component.literal("Your current party size is: " +
                            playerPersona.getPersonaCount() + "!"));
        }
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        if(pStack.hasTag()){
            persona = ControlledPersonaList.getDataFromList(pStack
                    .getTag().getString("personamod.personacarddata"));
        }

        if(null != persona) {
            pTooltipComponents.add(Component.translatable(personaNameKey +"."+ persona.getPersonaName()));
        }

        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
    }

    public ControlledPersona getPersona() {
        return persona;
    }

    @Override
    public Component getName(ItemStack pStack) {
        if(pStack.hasTag()){
            persona = ControlledPersonaList.getDataFromList(pStack
                    .getTag().getString("personamod.personacarddata"));
        }

        if(null != persona) {
            String personaName = Component.translatable(personaNameKey +"."+ persona.getPersonaName()).getString();
            return Component.literal(personaName + " Card");

        }
        return super.getName(pStack);

    }

    @Override
    protected void randomizeItemOnRightClick() {
        this.persona = ControlledPersonaList.getRandomPersona();
    }

    public void addNbtDataToItem(ItemStack pStack){
        CompoundTag compoundTag = new CompoundTag();
        compoundTag.putString("personamod.personacarddata",
                persona.getPersonaName());
        pStack.setTag(compoundTag);

    }

}
