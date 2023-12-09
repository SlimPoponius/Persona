package net.slimpopo.personamod.item.custom.spells.psy;

import com.mojang.logging.LogUtils;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.slimpopo.personamod.entity.custom.single.PsiThrowable;
import net.slimpopo.personamod.item.constants.*;
import org.slf4j.Logger;

public class PsioItem extends SpellItem {
    private static final Logger LOGGER = LogUtils.getLogger();


    private static final Spell PSIO = new Spell("Psio","Medium Psy damage to 1 foe.",
            Affinity.PSYCHOKINESIS, DamageType.MEDIUM, SpellLevel.TWO_STAR, null, null);

    public PsioItem(Properties pProperties) {
        super(pProperties, PSIO);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {

        ItemStack itemStack = pPlayer.getItemInHand(pUsedHand);

        if(!pLevel.isClientSide) {
            PsiThrowable projectile = new PsiThrowable(pLevel, pPlayer, PSIO);
            projectile.setItem(itemStack);
            projectile.shootFromRotation(pPlayer, pPlayer.getXRot(), pPlayer.getYRot(), 0.0F, 1.5F, 1.0F);
            pLevel.addFreshEntity(projectile);
        }

        return InteractionResultHolder.sidedSuccess(itemStack,pLevel.isClientSide);
    }
}
