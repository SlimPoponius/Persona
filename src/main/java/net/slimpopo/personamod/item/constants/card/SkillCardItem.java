package net.slimpopo.personamod.item.constants.card;

import net.minecraft.client.Minecraft;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.*;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.network.NetworkHooks;
import net.slimpopo.personamod.capability.persona.PlayerPersonaProvider;
import net.slimpopo.personamod.capability.persona.impl.PlayerPersona;
import net.slimpopo.personamod.constant.entity.ControlledPersona;
import net.slimpopo.personamod.constant.entity.level.SkillLearnedLevel;
import net.slimpopo.personamod.item.constants.SpellItem;
import net.slimpopo.personamod.item.constants.SpellItemList;
import net.slimpopo.personamod.networking.ModMessages;
import net.slimpopo.personamod.networking.packet.PersonaPlayerPersonasS2CPacket;
import net.slimpopo.personamod.screen.personastat.PersonaStatMenu;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class SkillCardItem extends CardItem {
    private final ItemStackHandler itemStackHandler = new ItemStackHandler(0);
    private LazyOptional<IItemHandler> lazYItemhandler = LazyOptional.empty();

    private SpellItem spellItem;

    public SkillCardItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer,
                                                  InteractionHand pUsedHand) {
        AtomicBoolean hasFailed = new AtomicBoolean(false);
        if(pPlayer.getItemInHand(pUsedHand).hasTag()){
            spellItem = SpellItemList.getSpellItem(pPlayer.getItemInHand(pUsedHand)
                    .getTag().getString("personamod.skillcarddata"));
        }
        if(!pLevel.isClientSide){
            pPlayer.getCapability(PlayerPersonaProvider.PLAYER_PERSONA)
                    .ifPresent(data -> {
                        if(data.unlockedPersonaUse() && data.getPersonaCount() > 0) {
                            ControlledPersona controlledPersona =
                                    data.getControlledPersonaFromIndex(data.getCurrentPersonaIndex());
                            if (checkIfNumberIsBelow(controlledPersona, 8)) {
                                addSkillToControlledPersona((ServerPlayer) pPlayer, data, controlledPersona);
                            } else if(controlledPersona.hasLearnedSkill(spellItem.getSpellData().getSPELL_NAME())){
                                if(null != Minecraft.getInstance().player) {
                                    Minecraft.getInstance().player.sendSystemMessage(
                                            Component.literal("Current persona already has current skill."));
                                }
                                hasFailed.set(true);
                            }
                            else {
                                //create replace skill UI
                                NetworkHooks.openScreen((ServerPlayer) pPlayer,
                                        new SimpleMenuProvider((id,inv,player) -> {
                                                PersonaStatMenu menu = new PersonaStatMenu(id,inv);
                                                menu.setPersonaData(controlledPersona);
                                                menu.setSpellItem(spellItem);
                                                return menu;
                                            },
                                                Component.translatable("menu.title.personamod.skillreplace")));
                            }
                        }
                        else{
                            if(null != Minecraft.getInstance().player) {
                                Minecraft.getInstance().player.sendSystemMessage(
                                        Component.literal("You have no personas to use this on."));
                            }
                            hasFailed.set(true);
                        }
            });
            if(hasFailed.get()){
                return InteractionResultHolder.fail(pPlayer.getItemInHand(pUsedHand));
            }
            if(null != Minecraft.getInstance().player) {
                Minecraft.getInstance().player.sendSystemMessage(
                        Component.literal("Persona has learned skill: " + spellItem.getSpellData().getSPELL_NAME()));
            }
        }
        pPlayer.setItemInHand(pUsedHand,ItemStack.EMPTY);
        return super.use(pLevel, pPlayer, pUsedHand);
    }

    private void addSkillToControlledPersona(ServerPlayer pPlayer, PlayerPersona data, ControlledPersona controlledPersona) {
        controlledPersona
                .addSkillToSkillList(new SkillLearnedLevel(0
                        , spellItem));
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

    private boolean checkIfNumberIsBelow(ControlledPersona controlledPersona, int val) {
        return controlledPersona.getLearnedSkills().size() < val;
    }

//    @Override
//    public Component getDisplayName() {
//        return null;
//    }
//
//    @Nullable
//    @Override
//    public AbstractContainerMenu createMenu(int pContainerId, Inventory pPlayerInventory, Player pPlayer) {
//        return null;
//    }


    @Override
    protected void randomizeItemOnRightClick() {
        this.spellItem = SpellItemList.getSpellItemFromRandom();
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents,
                                TooltipFlag pIsAdvanced) {
        if(pStack.hasTag()){
            spellItem = SpellItemList.getSpellItem(pStack.getTag().getString("personamod.skillcarddata"));
        }

        if(null != spellItem) {
            pTooltipComponents.add(Component.literal("Skill: " + spellItem.getSpellData().getSPELL_NAME()));
        }
        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
    }

    public SpellItem getSpellItem() {
        return spellItem;
    }
}
