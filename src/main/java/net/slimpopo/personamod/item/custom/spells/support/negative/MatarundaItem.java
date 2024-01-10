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
import net.slimpopo.personamod.item.constants.SupportSpellItem;
import org.slf4j.Logger;

import java.util.List;

public class MatarundaItem extends SupportSpellItem {
    private static final Logger LOGGER = LogUtils.getLogger();

    public MatarundaItem(Properties pProperties) {
        super(pProperties,"TARUNDA",
                List.of(new MobEffectInstance(ModEffects.ATTACK_DOWN.get(),900),
                        new MobEffectInstance(MobEffects.DAMAGE_BOOST,900,-2)),false);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {

        ItemStack itemStack = pPlayer.getItemInHand(pUsedHand);

        if(!pLevel.isClientSide) {
            if(isAbleToPerformSkill(pLevel,pPlayer)) {
                getMobsWithinRange((ServerPlayer) pPlayer,(ServerLevel) pLevel,15).forEach(livingEntity -> {
                    if(!(livingEntity instanceof Player) && !(livingEntity instanceof ControlledPersonaEntity)){
                        addEffectsToEntity(livingEntity);
                    }
                });
                return super.use(pLevel,pPlayer,pUsedHand);
            }
        }
        return InteractionResultHolder.fail(pPlayer.getItemInHand(pUsedHand));

    }
}
