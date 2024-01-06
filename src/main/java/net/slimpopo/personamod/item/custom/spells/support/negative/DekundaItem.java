package net.slimpopo.personamod.item.custom.spells.support.negative;

import com.mojang.logging.LogUtils;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.slimpopo.personamod.effects.ModEffects;
import net.slimpopo.personamod.item.constants.SpellItem;
import org.slf4j.Logger;

import java.util.List;

public class DekundaItem extends SpellItem {
    private static final Logger LOGGER = LogUtils.getLogger();

    public DekundaItem(Properties pProperties) {
        super(pProperties,"DEKUNDA");
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {

        ItemStack itemStack = pPlayer.getItemInHand(pUsedHand);

        if(!pLevel.isClientSide) {
            List<MobEffectInstance> harmful_effects = pPlayer.getActiveEffects().stream().filter(mobEffectInstance ->
                    !mobEffectInstance.getEffect().isBeneficial()
            ).toList();

            pPlayer.getActiveEffects().removeAll(harmful_effects);

            getPlayersWithinRange((ServerPlayer) pPlayer,(ServerLevel) pLevel,10).forEach(serverPlayer -> {
                List<MobEffectInstance> hEffects = serverPlayer.getActiveEffects().stream().filter(mobEffectInstance ->
                        !mobEffectInstance.getEffect().isBeneficial()
                ).toList();

                serverPlayer.getActiveEffects().removeAll(hEffects);
            });

        }

        return super.use(pLevel,pPlayer,pUsedHand);
    }
}
