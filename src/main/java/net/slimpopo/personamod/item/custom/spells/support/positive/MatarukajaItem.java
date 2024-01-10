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
import net.slimpopo.personamod.entity.custom.constants.ControlledPersonaEntity;
import net.slimpopo.personamod.item.constants.SpellItem;
import net.slimpopo.personamod.item.constants.SupportSpellItem;
import org.slf4j.Logger;

import java.util.List;

public class MatarukajaItem extends SupportSpellItem {
    private static final Logger LOGGER = LogUtils.getLogger();

    public MatarukajaItem(Properties pProperties) {
        super(pProperties,"MATARUKAJA",
                List.of(new MobEffectInstance(ModEffects.ATTACK_UP.get(),900),
                        new MobEffectInstance(MobEffects.DAMAGE_BOOST,900)), true);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {

        ItemStack itemStack = pPlayer.getItemInHand(pUsedHand);

        if(!pLevel.isClientSide) {
            if(isAbleToPerformSkill(pLevel,pPlayer)) {
                addEffectsToUser(pPlayer);
                getPlayersWithinRange((ServerPlayer) pPlayer,(ServerLevel) pLevel,10).forEach(this::addEffectsToUser);
                return super.use(pLevel,pPlayer,pUsedHand);

            }

        }
        return InteractionResultHolder.fail(pPlayer.getItemInHand(pUsedHand));
    }

}
