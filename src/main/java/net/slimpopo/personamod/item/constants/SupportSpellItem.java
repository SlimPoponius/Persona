package net.slimpopo.personamod.item.constants;

import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.SlotAccess;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.ClickAction;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.slimpopo.personamod.capability.persona.PlayerPersonaProvider;
import net.slimpopo.personamod.constant.spell.Spell;
import net.slimpopo.personamod.networking.ModMessages;
import net.slimpopo.personamod.networking.packet.PersonaPlayerSpS2CPacket;

import java.util.List;

public class SupportSpellItem extends SpellItem {

    private List<MobEffectInstance> mobEffectInstances;
    private Player caster;


    public SupportSpellItem(Properties pProperties, String spellName, List<MobEffectInstance> mobEffectInstances) {
        super(pProperties, spellName);
        this.mobEffectInstances = mobEffectInstances;
    }

    public void setCaster(Player caster) {
        this.caster = caster;
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        if(!pContext.getLevel().isClientSide){
            Player targetplayer = pContext.getPlayer();
            Player myPlayer = caster;

            if(null == targetplayer || null == caster){
                return InteractionResult.FAIL;
            }


            myPlayer.sendSystemMessage(Component.literal("You tagged Player: "
                    + targetplayer.getDisplayName()));

            myPlayer.getCapability(PlayerPersonaProvider.PLAYER_PERSONA).ifPresent(playerPersona -> {
                if(this.doesSpellHaveSpCost()){
                    if(hasEnoughSpToCast(playerPersona.getSP())) {

                        playerPersona.subSP(this.getSpellData().getSpCost());
                        addEffectsToUser(targetplayer);

                        ModMessages.sendToPlayer(new PersonaPlayerSpS2CPacket(playerPersona.getSP(),
                                playerPersona.getMaxSP()),(ServerPlayer) myPlayer);
                    }
                    else{
                        myPlayer.sendSystemMessage(Component.literal("You do not have enough sp to cast!"));
                    }
                }
            });
        }

        return InteractionResult.SUCCESS;
    }

    protected void addEffectsToUser(Player targetplayer) {
        mobEffectInstances.forEach(mobEffectInstance -> {
            targetplayer.addEffect(mobEffectInstance);
        });
    }
}
