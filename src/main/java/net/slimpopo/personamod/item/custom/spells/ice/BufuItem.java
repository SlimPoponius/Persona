package net.slimpopo.personamod.item.custom.spells.ice;

import com.mojang.logging.LogUtils;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.slimpopo.personamod.effects.ModEffects;
import net.slimpopo.personamod.entity.custom.single.IceThrowable;
import net.slimpopo.personamod.item.constants.*;
import org.slf4j.Logger;

public class BufuItem extends SpellItem {
    private static final Logger LOGGER = LogUtils.getLogger();


    private static final Spell BUFU = new Spell("Bufu","Light Ice damage to 1 foe.",
            Affinity.ICE, DamageType.LIGHT, SpellLevel.ONE_STAR, Blocks.ICE,
            new MobEffectInstance(ModEffects.FREEZE.get(),60 * SpellLevel.ONE_STAR.getLevel(), 1));

    public BufuItem(Properties pProperties) {
        super(pProperties,BUFU);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {

        ItemStack itemStack = pPlayer.getItemInHand(pUsedHand);

        if(!pLevel.isClientSide) {
            IceThrowable projectile = new IceThrowable(pLevel, pPlayer, BUFU);
            projectile.setItem(itemStack);
            projectile.shootFromRotation(pPlayer, pPlayer.getXRot(), pPlayer.getYRot(), 0.0F, 1.5F, 1.0F);
            pLevel.addFreshEntity(projectile);
        }

        return InteractionResultHolder.sidedSuccess(itemStack,pLevel.isClientSide);
    }
}
