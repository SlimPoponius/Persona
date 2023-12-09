package net.slimpopo.personamod.item.custom.spells.psy;

import com.mojang.logging.LogUtils;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.slimpopo.personamod.entity.custom.group.MaPsiThrowable;
import net.slimpopo.personamod.entity.custom.single.WindThrowable;
import net.slimpopo.personamod.item.constants.*;
import org.slf4j.Logger;

public class MapsiItem extends SpellItem {
    private static final Logger LOGGER = LogUtils.getLogger();


    private static final Spell MAPSI = new Spell("Psi","Light Psy damage to all foe.",
            Affinity.PSYCHOKINESIS, DamageType.LIGHT, SpellLevel.MA_ONE_STAR, null, null);

    public MapsiItem(Properties pProperties) {
        super(pProperties, MAPSI);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {

        ItemStack itemStack = pPlayer.getItemInHand(pUsedHand);

        if(!pLevel.isClientSide) {
            MaPsiThrowable projectile = new MaPsiThrowable(pLevel, pPlayer, MAPSI);
            projectile.setItem(itemStack);
            projectile.shootFromRotation(pPlayer, pPlayer.getXRot(), pPlayer.getYRot(), 0.0F, 1.5F, 1.0F);
            pLevel.addFreshEntity(projectile);
        }

        return InteractionResultHolder.sidedSuccess(itemStack,pLevel.isClientSide);
    }
}
