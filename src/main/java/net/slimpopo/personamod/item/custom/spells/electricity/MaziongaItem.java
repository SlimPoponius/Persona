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

public class MaziongaItem extends SpellItem {
    private static final Logger LOGGER = LogUtils.getLogger();


    private static final Spell MAZIONGA = new Spell("Mazionga","Medium Electricity damage to all foe.",
            Affinity.ELECTRIC, DamageType.MEDIUM, SpellLevel.MA_TWO_STAR, null,
            new MobEffectInstance(ModEffects.SHOCK.get(),60 * SpellLevel.TWO_STAR.getLevel(), 1));

    public MaziongaItem(Properties pProperties) {
        super(pProperties, MAZIONGA);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {

        ItemStack itemStack = pPlayer.getItemInHand(pUsedHand);

        if(!pLevel.isClientSide) {
            MaElectricThrowable projectile = new MaElectricThrowable(pLevel, pPlayer, MAZIONGA);
            projectile.setItem(itemStack);
            projectile.shootFromRotation(pPlayer, pPlayer.getXRot(), pPlayer.getYRot(), 0.0F, 1.5F, 1.0F);
            pLevel.addFreshEntity(projectile);
        }

        return InteractionResultHolder.sidedSuccess(itemStack,pLevel.isClientSide);
    }
}
