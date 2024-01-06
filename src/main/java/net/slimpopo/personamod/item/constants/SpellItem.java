package net.slimpopo.personamod.item.constants;

import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.SlotAccess;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.ClickAction;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.slimpopo.personamod.capability.persona.PlayerPersonaProvider;
import net.slimpopo.personamod.constant.spell.Spell;
import net.slimpopo.personamod.networking.ModMessages;
import net.slimpopo.personamod.networking.packet.PersonaPlayerSpS2CPacket;

public class SpellItem extends Item {
    private final SpellList spellList = new SpellList();
    private Spell spellData;

    public SpellItem(Properties pProperties, String spellName) {
        super(pProperties);
        this.spellData = spellList.getSpellDataWithName(spellName);
    }

    public SpellItem(Properties pProperties, Spell spellData) {
        super(pProperties);
        this.spellData = spellData;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        if(!pLevel.isClientSide){
            pPlayer.getCapability(PlayerPersonaProvider.PLAYER_PERSONA).ifPresent(playerPersona -> {
                if(doesSpellHaveSpCost()){
                    if(hasEnoughSpToCast(playerPersona.getSP())) {

                        playerPersona.subSP(spellData.getSpCost());
                        ModMessages.sendToPlayer(new PersonaPlayerSpS2CPacket(playerPersona.getSP(),
                                playerPersona.getMaxSP()),(ServerPlayer) pPlayer);
                    }
                    else{
                        pPlayer.sendSystemMessage(Component.literal("You do not have enough sp to cast!"));
                    }
                }
                else{
                    if(hasEnoughHealthToCast(pPlayer.getHealth(),pPlayer.getMaxHealth())){
                        float healthCost = pPlayer.getHealth() * spellData.getHealthCost();
                        pPlayer.hurt(pLevel.damageSources().magic(),healthCost);
                    }
                    else{
                        pPlayer.sendSystemMessage(Component.literal("You do not have enough health to cast!"));
                    }
                }

            });
        }

        return super.use(pLevel, pPlayer, pUsedHand);
    }

    private boolean hasEnoughHealthToCast(float health, float maxHealth) {
        return health >= maxHealth * this.spellData.getHealthCost();
    }

    private boolean hasEnoughSpToCast(int sp) {
        return sp >= this.spellData.getSpCost();
    }



    private boolean doesSpellHaveSpCost() {
        return null != this.spellData.getSpCost();
    }

    @Override
    public boolean overrideOtherStackedOnMe(ItemStack pStack, ItemStack pOther, Slot pSlot, ClickAction pAction, Player pPlayer, SlotAccess pAccess) {
        return false;
    }

    @Override
    public boolean overrideStackedOnOther(ItemStack pStack, Slot pSlot, ClickAction pAction, Player pPlayer) {
        return false;
    }

    @Override
    public boolean isDamageable(ItemStack stack) {
        return false;
    }

    public Spell getSpellData() {
        return spellData;
    }

}
