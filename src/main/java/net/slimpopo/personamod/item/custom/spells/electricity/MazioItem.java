package net.slimpopo.personamod.item.custom.spells.electricity;

import com.mojang.logging.LogUtils;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.slimpopo.personamod.effects.ModEffects;
import net.slimpopo.personamod.entity.custom.group.MaElectricThrowable;
import net.slimpopo.personamod.item.constants.*;
import org.slf4j.Logger;

public class MazioItem extends SpellItem {
    private static final Logger LOGGER = LogUtils.getLogger();


    private static final Spell MAZIO = new Spell("Mazio","Light Electricity damage to all foes.",
            Affinity.ELECTRIC, DamageType.LIGHT, SpellLevel.MA_ONE_STAR, null,
            new MobEffectInstance(ModEffects.SHOCK.get(),60 * SpellLevel.ONE_STAR.getLevel(), 1));

    public MazioItem(Properties pProperties) {
        super(pProperties, MAZIO);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {

        ItemStack itemStack = pPlayer.getItemInHand(pUsedHand);

        if(!pLevel.isClientSide) {
            MaElectricThrowable projectile = new MaElectricThrowable(pLevel, pPlayer, MAZIO);
            projectile.setItem(itemStack);
            projectile.shootFromRotation(pPlayer, pPlayer.getXRot(), pPlayer.getYRot(), 0.0F, 1.5F, 1.0F);
            pLevel.addFreshEntity(projectile);
        }

        return InteractionResultHolder.sidedSuccess(itemStack,pLevel.isClientSide);
    }
}
