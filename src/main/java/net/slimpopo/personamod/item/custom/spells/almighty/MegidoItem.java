package net.slimpopo.personamod.item.custom.spells.almighty;

import com.mojang.logging.LogUtils;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.slimpopo.personamod.entity.custom.group.MaAlmightyThrowable;
import net.slimpopo.personamod.entity.custom.single.FlameThrowable;
import net.slimpopo.personamod.item.constants.SpellItem;
import org.slf4j.Logger;

public class MegidoItem extends SpellItem {
    private static final Logger LOGGER = LogUtils.getLogger();

    public MegidoItem(Properties pProperties) {
        super(pProperties,"MEGIDO");
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {

        ItemStack itemStack = pPlayer.getItemInHand(pUsedHand);

        if(!pLevel.isClientSide) {
            if(isAbleToPerformSkill(pLevel,pPlayer)) {
                MaAlmightyThrowable projectile = new MaAlmightyThrowable(pLevel, pPlayer, getSpellData());
                projectile.setItem(itemStack);
                projectile.shootFromRotation(pPlayer, pPlayer.getXRot(), pPlayer.getYRot(), 0.0F, 1.5F, 1.0F);
                pLevel.addFreshEntity(projectile);
            }

            return super.use(pLevel,pPlayer,pUsedHand);

        }
        return InteractionResultHolder.fail(pPlayer.getItemInHand(pUsedHand));
    }
}
