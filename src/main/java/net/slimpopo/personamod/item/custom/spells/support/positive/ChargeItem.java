package net.slimpopo.personamod.item.custom.spells.support.positive;

import com.mojang.logging.LogUtils;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.slimpopo.personamod.capability.persona.PlayerPersonaProvider;
import net.slimpopo.personamod.effects.ModEffects;
import net.slimpopo.personamod.item.constants.SpellItem;
import net.slimpopo.personamod.item.constants.SupportSpellItem;
import org.slf4j.Logger;

import java.util.ArrayList;

public class ChargeItem extends SupportSpellItem {
    private static final Logger LOGGER = LogUtils.getLogger();

    public ChargeItem(Properties pProperties) {
        super(pProperties,"CHARGE", new ArrayList<>(),true);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {

        ItemStack itemStack = pPlayer.getItemInHand(pUsedHand);

        if(!pLevel.isClientSide) {
            if(isAbleToPerformSkill(pLevel,pPlayer)) {
                pPlayer.getCapability(PlayerPersonaProvider.PLAYER_PERSONA).ifPresent(playerPersona -> {
                    playerPersona.setUsedChargeSkill(true);
                });
                return super.use(pLevel,pPlayer,pUsedHand);
            }
        }
        return InteractionResultHolder.fail(pPlayer.getItemInHand(pUsedHand));
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        return InteractionResult.SUCCESS;
    }
}
