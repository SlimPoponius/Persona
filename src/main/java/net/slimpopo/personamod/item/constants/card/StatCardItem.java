package net.slimpopo.personamod.item.constants.card;

import net.minecraft.client.Minecraft;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.slimpopo.personamod.capability.persona.PlayerPersonaProvider;
import net.slimpopo.personamod.constant.entity.ControlledPersona;
import net.slimpopo.personamod.entity.custom.constants.ControlledPersonaList;
import net.slimpopo.personamod.item.constants.SpellItemList;
import net.slimpopo.personamod.networking.ModMessages;
import net.slimpopo.personamod.networking.packet.PersonaPlayerUnlockS2CPacket;
import net.slimpopo.personamod.networking.packet.personanetwork.PlayerPersonaUpdateS2CPacket;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;

public class StatCardItem extends CardItem{
    private String statToUpdate;

    public StatCardItem(Properties pProperties) {
        super(pProperties);
        generatePersonaStatCard();
    }

    private void generatePersonaStatCard() {
        Random random = new Random();
        this.statToUpdate = getStatForChange(random.nextInt() % 5);
    }

    private String getStatForChange(int i) {
        return switch (i){
            case 0 -> "STRENGTH";
            case 1 -> "MAGIC";
            case 2 -> "AGILITY";
            case 3 -> "ENDURANCE";
            case 4 -> "LUCK";
            default -> "NONE";
        };
    }

    public String getStatToUpdate() {
        return statToUpdate;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        if(pPlayer.getItemInHand(pUsedHand).hasTag() &&
        !pPlayer.getItemInHand(pUsedHand).getTag().getString("personamod.statcarddata").isEmpty()){
            statToUpdate = pPlayer.getItemInHand(pUsedHand).getTag().getString("personamod.statcarddata");
        }
        else{
            randomizeItemOnRightClick();
            addNbtDataToItem(pPlayer.getItemInHand(pUsedHand));
            return InteractionResultHolder.success(pPlayer.getItemInHand(pUsedHand));
        }

        AtomicBoolean hasFailed = new AtomicBoolean(false);

        if(!pLevel.isClientSide){

            pPlayer.getCapability(PlayerPersonaProvider.PLAYER_PERSONA)
                    .ifPresent(playerPersona -> {
                        if(playerPersona.unlockedPersonaUse() && playerPersona.getPersonaParty().size() >= 1) {
                            int personaIdx = playerPersona.getCurrentPersonaIndex();

                            if (!isStatMaxedOut(playerPersona.getControlledPersonaFromIndex(personaIdx),
                                    statToUpdate)) {
                                updateStat(playerPersona.getControlledPersonaFromIndex(personaIdx),statToUpdate);
                                ModMessages.sendToPlayer(
                                        new PlayerPersonaUpdateS2CPacket(playerPersona.getPersonaParty(),
                                                playerPersona.getPersonaCount())
                                        , (ServerPlayer) pPlayer);
                            } else {
                                if (null != Minecraft.getInstance().player) {
                                    Minecraft.getInstance().player.sendSystemMessage(
                                            Component.literal("Persona stat is maxed out!"));
                                }
                                hasFailed.set(true);
                            }
                        }
                        else {
                            if (null != Minecraft.getInstance().player) {
                                Minecraft.getInstance().player.sendSystemMessage(
                                        Component.literal("You cannot currently use this card"));
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

    private boolean isStatMaxedOut(ControlledPersona controlledPersonaFromIndex, String statToUpdate) {
        return switch (statToUpdate.toLowerCase(Locale.ROOT)){
            case "strength" -> controlledPersonaFromIndex.checkStrength();
            case "magic" -> controlledPersonaFromIndex.checkMagic();
            case "agility" ->  controlledPersonaFromIndex.checkAgility();
            case "endurance" -> controlledPersonaFromIndex.checkEndurance();
            case "luck" -> controlledPersonaFromIndex.checkLuck();
            default ->  false;
        };
    }

    private void updateStat(ControlledPersona controlledPersonaFromIndex, String statToUpdate) {
        switch (statToUpdate.toLowerCase(Locale.ROOT)){
            case "strength" -> controlledPersonaFromIndex.addSTRENGTH(1);
            case "magic" -> controlledPersonaFromIndex.addMAGIC(1);
            case "agility" -> controlledPersonaFromIndex.addAGILITY(1);
            case "endurance" -> controlledPersonaFromIndex.addENDURANCE(1);
            case "luck" -> controlledPersonaFromIndex.addLUCK(1);
            default -> controlledPersonaFromIndex.addSTRENGTH(1);
        }
    }

    @Override
    protected void randomizeItemOnRightClick() {
        generatePersonaStatCard();
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents,
                                TooltipFlag pIsAdvanced) {
        if(pStack.hasTag()){
            statToUpdate = pStack.getTag().getString("personamod.statcarddata");
        }

        if(!statToUpdate.isEmpty()) {
            pTooltipComponents.add(Component.literal("Status: " + statToUpdate + "+1"));
        }
        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
    }

    @Override
    public Component getName(ItemStack pStack) {
        if(pStack.hasTag()){
            statToUpdate = pStack.getTag().getString("personamod.statcarddata");
        }

        if(!statToUpdate.isEmpty()) {
            return Component.literal(statToUpdate + "+1");
        }
        return super.getName(pStack);
    }

    public void addNbtDataToItem(ItemStack pStack){
        CompoundTag compoundTag = new CompoundTag();
        compoundTag.putString("personamod.statcarddata", statToUpdate);
        pStack.setTag(compoundTag);
    }
}
