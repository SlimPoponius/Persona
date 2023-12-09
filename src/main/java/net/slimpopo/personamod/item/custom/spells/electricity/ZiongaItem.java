package net.slimpopo.personamod.item.custom.spells.electricity;

import com.mojang.logging.LogUtils;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.slimpopo.personamod.effects.ModEffects;
import net.slimpopo.personamod.entity.custom.single.ElectricThrowable;
import net.slimpopo.personamod.item.constants.*;
import org.slf4j.Logger;

public class ZiongaItem extends SpellItem {
    private static final Logger LOGGER = LogUtils.getLogger();


    private static final Spell ZIONGA = new Spell("Zionga","Medium Electricity damage to 1 foe.",
            Affinity.ELECTRIC, DamageType.MEDIUM, SpellLevel.TWO_STAR, null,
            new MobEffectInstance(ModEffects.SHOCK.get(),60 * SpellLevel.TWO_STAR.getLevel(), 1));

    public ZiongaItem(Properties pProperties) {
        super(pProperties, ZIONGA);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {

        ItemStack itemStack = pPlayer.getItemInHand(pUsedHand);

        if(!pLevel.isClientSide) {
            ElectricThrowable projectile = new ElectricThrowable(pLevel, pPlayer, ZIONGA);
            projectile.setItem(itemStack);
            projectile.shootFromRotation(pPlayer, pPlayer.getXRot(), pPlayer.getYRot(), 0.0F, 1.5F, 1.0F);
            pLevel.addFreshEntity(projectile);
        }

        return InteractionResultHolder.sidedSuccess(itemStack,pLevel.isClientSide);
    }
}
