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

public class MaragiItem extends SpellItem {
    private static final Logger LOGGER = LogUtils.getLogger();


    private static final Spell MARAGI = new Spell("Maragi","Light Fire damage to all foes.",
            Affinity.FIRE, DamageType.LIGHT, SpellLevel.MA_ONE_STAR, Blocks.MAGMA_BLOCK,
            new MobEffectInstance(ModEffects.BURN.get(),60 * SpellLevel.ONE_STAR.getLevel(), 1));

    public MaragiItem(Properties pProperties) {
        super(pProperties, MARAGI);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {

        ItemStack itemStack = pPlayer.getItemInHand(pUsedHand);

        if(!pLevel.isClientSide) {
            MaFlameThrowable projectile = new MaFlameThrowable(pLevel, pPlayer, MARAGI);
            projectile.setItem(itemStack);
            projectile.shootFromRotation(pPlayer, pPlayer.getXRot(), pPlayer.getYRot(), 0.0F, 1.5F, 1.0F);
            pLevel.addFreshEntity(projectile);
        }

        return InteractionResultHolder.sidedSuccess(itemStack,pLevel.isClientSide);
    }
}
