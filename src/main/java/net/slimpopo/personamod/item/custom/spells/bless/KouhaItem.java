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
import net.slimpopo.personamod.entity.custom.single.BlessThrowable;
import net.slimpopo.personamod.item.constants.SpellItem;
import org.slf4j.Logger;

public class KouhaItem extends SpellItem {
    private static final Logger LOGGER = LogUtils.getLogger();

    public KouhaItem(Properties pProperties) {
        super(pProperties, "KOUHA");
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {

        ItemStack itemStack = pPlayer.getItemInHand(pUsedHand);

        if(!pLevel.isClientSide) {
            BlessThrowable projectile = new BlessThrowable(pLevel, pPlayer, getSpellData());
            projectile.setItem(itemStack);
            projectile.shootFromRotation(pPlayer, pPlayer.getXRot(), pPlayer.getYRot(), 0.0F, 1.5F, 1.0F);
            pLevel.addFreshEntity(projectile);
        }

        return InteractionResultHolder.sidedSuccess(itemStack,pLevel.isClientSide);
    }
}
