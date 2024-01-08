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
import net.slimpopo.personamod.effects.ModEffects;
import net.slimpopo.personamod.item.constants.SpellItem;
import net.slimpopo.personamod.item.constants.SupportSpellItem;
import org.slf4j.Logger;

import java.util.List;

public class HeatRiserItem extends SupportSpellItem {
    private static final Logger LOGGER = LogUtils.getLogger();

    public HeatRiserItem(Properties pProperties) {
        super(pProperties,"HEATRISER",
                List.of(new MobEffectInstance(ModEffects.ATTACK_UP.get(),900),
                        new MobEffectInstance(MobEffects.DAMAGE_BOOST,900),
                        new MobEffectInstance(MobEffects.MOVEMENT_SPEED,900,2),
                        new MobEffectInstance(ModEffects.DEFENSE_UP.get(),900),
                        new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE,900)));
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {

        if(!pLevel.isClientSide) {
            this.addEffectsToUser(pPlayer);
//            pPlayer.addEffect(new MobEffectInstance(ModEffects.ATTACK_UP.get(),900));
//            pPlayer.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST,900));
//            pPlayer.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED,900,2));
//            pPlayer.addEffect(new MobEffectInstance(ModEffects.DEFENSE_UP.get(),900));
//            pPlayer.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE,900));
        }

        return super.use(pLevel,pPlayer,pUsedHand);
    }

}
