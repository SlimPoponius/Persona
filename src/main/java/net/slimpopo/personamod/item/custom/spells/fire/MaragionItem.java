package net.slimpopo.personamod.item.custom.spells.fire;

import com.mojang.logging.LogUtils;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.slimpopo.personamod.effects.ModEffects;
import net.slimpopo.personamod.entity.custom.group.MaFlameThrowable;
import net.slimpopo.personamod.item.constants.*;
import org.slf4j.Logger;

public class MaragionItem extends SpellItem {
    private static final Logger LOGGER = LogUtils.getLogger();


    private static final Spell MARAGION = new Spell("Maragion","Medium Fire damage to all foe.",
            Affinity.FIRE, DamageType.MEDIUM, SpellLevel.MA_TWO_STAR, Blocks.MAGMA_BLOCK,
            new MobEffectInstance(ModEffects.BURN.get(),60 * SpellLevel.TWO_STAR.getLevel(), 1));

    public MaragionItem(Properties pProperties) {
        super(pProperties, MARAGION);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {

        ItemStack itemStack = pPlayer.getItemInHand(pUsedHand);

        if(!pLevel.isClientSide) {
            MaFlameThrowable projectile = new MaFlameThrowable(pLevel, pPlayer, MARAGION);
            projectile.setItem(itemStack);
            projectile.shootFromRotation(pPlayer, pPlayer.getXRot(), pPlayer.getYRot(), 0.0F, 1.5F, 1.0F);
            pLevel.addFreshEntity(projectile);
        }

        return InteractionResultHolder.sidedSuccess(itemStack,pLevel.isClientSide);
    }
}
