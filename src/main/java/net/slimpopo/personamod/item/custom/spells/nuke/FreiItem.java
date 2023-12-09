package net.slimpopo.personamod.item.custom.spells.nuke;

import com.mojang.logging.LogUtils;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.slimpopo.personamod.entity.custom.single.WindThrowable;
import net.slimpopo.personamod.item.constants.*;
import org.slf4j.Logger;

public class FreiItem extends SpellItem {
    private static final Logger LOGGER = LogUtils.getLogger();


    private static final Spell FREI = new Spell("Frei","Light Nuke damage to 1 foe.",
            Affinity.NUCLEAR, DamageType.LIGHT, SpellLevel.ONE_STAR, null, null);

    public FreiItem(Properties pProperties) {
        super(pProperties, FREI);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {

        ItemStack itemStack = pPlayer.getItemInHand(pUsedHand);

        if(!pLevel.isClientSide) {
            WindThrowable projectile = new WindThrowable(pLevel, pPlayer, FREI);
            projectile.setItem(itemStack);
            projectile.shootFromRotation(pPlayer, pPlayer.getXRot(), pPlayer.getYRot(), 0.0F, 1.5F, 1.0F);
            pLevel.addFreshEntity(projectile);
        }

        return InteractionResultHolder.sidedSuccess(itemStack,pLevel.isClientSide);
    }
}
