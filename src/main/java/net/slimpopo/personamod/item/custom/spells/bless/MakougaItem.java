package net.slimpopo.personamod.item.custom.spells.bless;

import com.mojang.logging.LogUtils;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.slimpopo.personamod.constant.damage.Affinity;
import net.slimpopo.personamod.constant.damage.DamageType;
import net.slimpopo.personamod.constant.spell.Spell;
import net.slimpopo.personamod.constant.spell.SpellLevel;
import net.slimpopo.personamod.entity.custom.group.MaBlessThrowable;
import net.slimpopo.personamod.item.constants.SpellItem;
import org.slf4j.Logger;

public class MakougaItem extends SpellItem {
    private static final Logger LOGGER = LogUtils.getLogger();


    private static final Spell MAKOUHA = new Spell("Makouha","Light bless damage to enemies.",
            Affinity.BLESS, DamageType.LIGHT, SpellLevel.MA_ONE_STAR, null,null);

    public MakougaItem(Properties pProperties) {
        super(pProperties,MAKOUHA);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {

        ItemStack itemStack = pPlayer.getItemInHand(pUsedHand);

        if(!pLevel.isClientSide) {
            MaBlessThrowable projectile = new MaBlessThrowable(pLevel, pPlayer, MAKOUHA);
            projectile.setItem(itemStack);
            projectile.shootFromRotation(pPlayer, pPlayer.getXRot(), pPlayer.getYRot(), 0.0F, 1.5F, 1.0F);
            pLevel.addFreshEntity(projectile);
        }

        return InteractionResultHolder.sidedSuccess(itemStack,pLevel.isClientSide);
    }
}
