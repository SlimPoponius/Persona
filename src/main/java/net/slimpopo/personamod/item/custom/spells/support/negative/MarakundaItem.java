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
import net.slimpopo.personamod.entity.custom.constants.ControlledPersonaEntity;
import net.slimpopo.personamod.item.constants.SpellItem;
import org.slf4j.Logger;

public class MarakundaItem extends SpellItem {
    private static final Logger LOGGER = LogUtils.getLogger();

    public MarakundaItem(Properties pProperties) {
        super(pProperties,"MARAKUNDA");
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {

        ItemStack itemStack = pPlayer.getItemInHand(pUsedHand);

        if(!pLevel.isClientSide) {
            getMobsWithinRange((ServerPlayer) pPlayer,(ServerLevel) pLevel,15).forEach(livingEntity -> {
                if(!(livingEntity instanceof Player) || !(livingEntity instanceof ControlledPersonaEntity)){
                    livingEntity.addEffect(new MobEffectInstance(ModEffects.DEFENSE_DOWN.get(),900));
                    livingEntity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS,900));
                }
            });
        }

        return super.use(pLevel,pPlayer,pUsedHand);
    }
}
