package net.slimpopo.personamod.item.custom.spells.wind;

import com.mojang.logging.LogUtils;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.slimpopo.personamod.entity.custom.single.WindThrowable;
import net.slimpopo.personamod.item.constants.*;
import org.slf4j.Logger;

public class GarudyneItem extends SpellItem {
    private static final Logger LOGGER = LogUtils.getLogger();


    private static final Spell GARUDYNE = new Spell("Garudyne","Heavy Wind damage to 1 foe.",
            Affinity.WIND, DamageType.HEAVY, SpellLevel.THREE_STAR, null,
            new MobEffectInstance(MobEffects.LEVITATION,60 * SpellLevel.THREE_STAR.getLevel(), 1));

    public GarudyneItem(Properties pProperties) {
        super(pProperties, GARUDYNE);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {

        ItemStack itemStack = pPlayer.getItemInHand(pUsedHand);

        if(!pLevel.isClientSide) {
            WindThrowable projectile = new WindThrowable(pLevel, pPlayer, GARUDYNE);
            projectile.setItem(itemStack);
            projectile.shootFromRotation(pPlayer, pPlayer.getXRot(), pPlayer.getYRot(), 0.0F, 1.5F, 1.0F);
            pLevel.addFreshEntity(projectile);
        }

        return InteractionResultHolder.sidedSuccess(itemStack,pLevel.isClientSide);
    }
}
