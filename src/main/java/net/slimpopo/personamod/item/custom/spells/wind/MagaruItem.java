package net.slimpopo.personamod.item.custom.spells.wind;

import com.mojang.logging.LogUtils;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.slimpopo.personamod.entity.custom.group.MaWindThrowable;
import net.slimpopo.personamod.item.constants.*;
import org.slf4j.Logger;

public class MagaruItem extends SpellItem {
    private static final Logger LOGGER = LogUtils.getLogger();


    private static final Spell MAGARU = new Spell("Magaru","Light Wind damage to all foe.",
            Affinity.WIND, DamageType.LIGHT, SpellLevel.MA_ONE_STAR, null,
            new MobEffectInstance(MobEffects.LEVITATION,60 * SpellLevel.ONE_STAR.getLevel(), 1));

    public MagaruItem(Properties pProperties) {
        super(pProperties, MAGARU);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {

        ItemStack itemStack = pPlayer.getItemInHand(pUsedHand);

        if(!pLevel.isClientSide) {
            MaWindThrowable projectile = new MaWindThrowable(pLevel, pPlayer, MAGARU);
            projectile.setItem(itemStack);
            projectile.shootFromRotation(pPlayer, pPlayer.getXRot(), pPlayer.getYRot(), 0.0F, 1.5F, 1.0F);
            pLevel.addFreshEntity(projectile);
        }

        return InteractionResultHolder.sidedSuccess(itemStack,pLevel.isClientSide);
    }
}
