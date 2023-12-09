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

public class MafreidyneItem extends SpellItem {
    private static final Logger LOGGER = LogUtils.getLogger();


    private static final Spell MAFREIDYNE = new Spell("Mafreidyne","Heavy Nuke damage to all foe.",
            Affinity.NUCLEAR, DamageType.HEAVY, SpellLevel.MA_THREE_STAR, null, null);

    public MafreidyneItem(Properties pProperties) {
        super(pProperties, MAFREIDYNE);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {

        ItemStack itemStack = pPlayer.getItemInHand(pUsedHand);

        if(!pLevel.isClientSide) {
            MaNukeThrowable projectile = new MaNukeThrowable(pLevel, pPlayer, MAFREIDYNE);
            projectile.setItem(itemStack);
            projectile.shootFromRotation(pPlayer, pPlayer.getXRot(),
                    pPlayer.getYRot(), 0.0F, 1.5F, 1.0F);
            pLevel.addFreshEntity(projectile);
        }

        return InteractionResultHolder.sidedSuccess(itemStack,pLevel.isClientSide);
    }
}
