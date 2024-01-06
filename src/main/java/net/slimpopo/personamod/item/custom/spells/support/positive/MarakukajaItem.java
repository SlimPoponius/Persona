package net.slimpopo.personamod.item.custom.spells.support.positive;

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

public class MarakukajaItem extends SpellItem {
    private static final Logger LOGGER = LogUtils.getLogger();

    public MarakukajaItem(Properties pProperties) {
        super(pProperties,"MARAKUKAJA");
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {

        ItemStack itemStack = pPlayer.getItemInHand(pUsedHand);

        if(!pLevel.isClientSide) {
            pPlayer.addEffect(new MobEffectInstance(ModEffects.DEFENSE_UP.get(),900));
            pPlayer.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE,900));
            getPlayersWithinRange((ServerPlayer) pPlayer,(ServerLevel) pLevel,10).forEach(serverPlayer -> {
                serverPlayer.addEffect(new MobEffectInstance(ModEffects.DEFENSE_UP.get(),900));
                serverPlayer.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE,900));
            });

        }

        return super.use(pLevel,pPlayer,pUsedHand);
    }
}
