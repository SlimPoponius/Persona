package net.slimpopo.personamod.item.custom.spells.nuke;

import com.mojang.logging.LogUtils;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.slimpopo.personamod.entity.custom.group.MaNukeThrowable;
import net.slimpopo.personamod.item.constants.*;
import org.slf4j.Logger;

public class MafreilaItem extends SpellItem {
    private static final Logger LOGGER = LogUtils.getLogger();


    private static final Spell MAFREILA = new Spell("Mafreila","Medium Nuke damage to all foe.",
            Affinity.NUCLEAR, DamageType.MEDIUM, SpellLevel.MA_TWO_STAR, null, null);

    public MafreilaItem(Properties pProperties) {
        super(pProperties, MAFREILA);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {

        ItemStack itemStack = pPlayer.getItemInHand(pUsedHand);

        if(!pLevel.isClientSide) {
            MaNukeThrowable projectile = new MaNukeThrowable(pLevel, pPlayer, MAFREILA);
            projectile.setItem(itemStack);
            projectile.shootFromRotation(pPlayer, pPlayer.getXRot(),
                    pPlayer.getYRot(), 0.0F, 1.5F, 1.0F);
            pLevel.addFreshEntity(projectile);
        }

        return InteractionResultHolder.sidedSuccess(itemStack,pLevel.isClientSide);
    }
}
