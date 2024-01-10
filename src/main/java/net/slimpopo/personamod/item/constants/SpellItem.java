package net.slimpopo.personamod.item.constants;

import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.LivingEntity;
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

import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class SpellItem extends Item {
    private final SpellList spellList = new SpellList();
    public final Spell spellData;

    public SpellItem(Properties pProperties, String spellName) {
        super(pProperties);
        this.spellData = spellList.getSpellDataWithName(spellName);
    }

    public SpellItem(Properties pProperties, Spell spellData) {
        super(pProperties);
        this.spellData = spellData;
    }


    public boolean isAbleToPerformSkill(Level pLevel, Player pPlayer) {
        AtomicBoolean metReq = new AtomicBoolean(false);
        pPlayer.getCapability(PlayerPersonaProvider.PLAYER_PERSONA).ifPresent(playerPersona -> {
            if(doesSpellHaveSpCost()){
                if(hasEnoughSpToCast(playerPersona.getSP())) {

                    playerPersona.subSP(this.spellData.getSpCost());
                    ModMessages.sendToPlayer(new PersonaPlayerSpS2CPacket(playerPersona.getSP(),
                            playerPersona.getMaxSP()),(ServerPlayer) pPlayer);
                    metReq.set(true);
                }
                else{
                    pPlayer.sendSystemMessage(Component.literal("You do not have enough sp to cast!"));
                }
            }
            else{
                if(hasEnoughHealthToCast(pPlayer.getHealth(), pPlayer.getMaxHealth())){
                    float healthCost = pPlayer.getHealth() * this.spellData.getHealthCost();
                    pPlayer.hurt(pLevel.damageSources().magic(),healthCost);
                    metReq.set(true);
                }
                else{
                    pPlayer.sendSystemMessage(Component.literal("You do not have enough health to cast!"));

                }
            }

        });
        return metReq.get();
    }

    protected boolean hasEnoughHealthToCast(float health, float maxHealth) {
        return health >= maxHealth * this.spellData.getHealthCost();
    }

    protected boolean hasEnoughSpToCast(int sp) {
        return sp >= this.spellData.getSpCost();
    }



    protected boolean doesSpellHaveSpCost() {
        return null != this.spellData.getSpCost();
    }

    @Override
    public boolean overrideOtherStackedOnMe(ItemStack pStack, ItemStack pOther, Slot pSlot, ClickAction pAction,
                                            Player pPlayer, SlotAccess pAccess) {
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
        return this.spellData;
    }

    protected List<ServerPlayer> getPlayersWithinRange(ServerPlayer player, ServerLevel level, int range) {
        return level.getEntitiesOfClass(ServerPlayer.class,player.getBoundingBox().inflate(range));
    }

    protected List<LivingEntity> getMobsWithinRange(ServerPlayer player, ServerLevel level, int range) {
        return level.getEntitiesOfClass(LivingEntity.class,player.getBoundingBox().inflate(range));
    }



}
