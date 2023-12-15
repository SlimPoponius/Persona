package net.slimpopo.personamod.item.custom.spells.ice;

import com.mojang.logging.LogUtils;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.slimpopo.personamod.constant.damage.Affinity;
import net.slimpopo.personamod.constant.damage.DamageType;
import net.slimpopo.personamod.constant.spell.Spell;
import net.slimpopo.personamod.constant.spell.SpellLevel;
import net.slimpopo.personamod.effects.ModEffects;
import net.slimpopo.personamod.entity.custom.group.MaIceThrowable;
import net.slimpopo.personamod.item.constants.*;
import org.slf4j.Logger;

public class MabufuItem extends SpellItem {
    private static final Logger LOGGER = LogUtils.getLogger();


    private static final Spell MABUFU = new Spell("Mabufu","Light Ice damage to all foes.",
            Affinity.ICE, DamageType.LIGHT, SpellLevel.MA_ONE_STAR, Blocks.ICE,
            new MobEffectInstance(ModEffects.FREEZE.get(),60 * SpellLevel.ONE_STAR.getLevel(), 1));

    public MabufuItem(Properties pProperties) {
        super(pProperties,MABUFU);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {

        ItemStack itemStack = pPlayer.getItemInHand(pUsedHand);

        if(!pLevel.isClientSide) {
            MaIceThrowable projectile = new MaIceThrowable(pLevel, pPlayer, MABUFU);
            projectile.setItem(itemStack);
            projectile.shootFromRotation(pPlayer, pPlayer.getXRot(), pPlayer.getYRot(), 0.0F, 1.5F, 1.0F);
            pLevel.addFreshEntity(projectile);
        }

        return InteractionResultHolder.sidedSuccess(itemStack,pLevel.isClientSide);
    }
}
