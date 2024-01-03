package net.slimpopo.personamod.item.constants.card;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.slimpopo.personamod.item.ModItems;
import net.slimpopo.personamod.item.constants.SpellItem;
import org.jetbrains.annotations.Nullable;
import org.stringtemplate.v4.ST;
import software.bernie.shadowed.eliotlash.mclib.math.functions.classic.Mod;

import java.util.List;
import java.util.Random;

public class ArcanaCardItem extends Item {

    public ArcanaCardItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer,
                                                  InteractionHand pUsedHand) {

        if(!pLevel.isClientSide){
            //determine if it will be a spell, status, or persona card.
            CardItem cardItem = generateCardItemType();
            ItemStack generatedItem = new ItemStack(cardItem);
            addNbtDataToItem(generatedItem);
            //replace this item with new item;
            pPlayer.setItemInHand(pUsedHand,generatedItem);
        }

        return super.use(pLevel, pPlayer, pUsedHand);
    }

    private CardItem generateCardItemType() {
        Random random = new Random();
        int cardType = Math.abs(random.nextInt() % 3);

        switch (cardType){
            case 0:
                PersonaCardItem pCard = ModItems.PERSONACARD.get();
                pCard.randomizeItemOnRightClick();
                return pCard;
            case 1:
                SkillCardItem sCard = ModItems.SKILLCARD.get();
                sCard.randomizeItemOnRightClick();
                return sCard;
            case 3:
                StatCardItem stCard = ModItems.STATCARD.get();
                stCard.randomizeItemOnRightClick();
                return stCard;
        }
        return ModItems.SKILLCARD.get();
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.literal("Right Click this item to see your reward."));
        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
    }

    public void addNbtDataToItem(ItemStack pStack){
        CompoundTag compoundTag = new CompoundTag();
        if(pStack.getItem() instanceof  PersonaCardItem personaCardItem){
            compoundTag.putString("personamod.personacarddata",
                    personaCardItem.getPersona().getPersonaName());
        }
        else if(pStack.getItem() instanceof SkillCardItem skillCardItem){
            compoundTag.putString("personamod.skillcarddata", skillCardItem.getSpellItem()
                    .getSpellData().getSPELL_NAME());
        }
        else if(pStack.getItem() instanceof StatCardItem statCardItem){
            compoundTag.putString("personamod.statcarddata", statCardItem.getStatToUpdate());
        }
        System.out.println("compoundTag created");
        pStack.setTag(compoundTag);
        System.out.println("compoundTag saved to item stack");
    }
}
