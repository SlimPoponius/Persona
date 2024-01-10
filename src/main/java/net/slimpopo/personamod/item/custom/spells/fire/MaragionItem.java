package net.slimpopo.personamod.item.custom.spells.fire;

import com.mojang.logging.LogUtils;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.slimpopo.personamod.constant.damage.Affinity;
import net.slimpopo.personamod.constant.damage.DamageType;
import net.slimpopo.personamod.constant.spell.Spell;
import net.slimpopo.personamod.constant.spell.SpellLevel;
import net.slimpopo.personamod.effects.ModEffects;
import net.slimpopo.personamod.entity.custom.group.MaFlameThrowable;
import net.slimpopo.personamod.item.constants.*;
import org.slf4j.Logger;

public class MaragionItem extends SpellItem {
    private static final Logger LOGGER = LogUtils.getLogger();

    public MaragionItem(Properties pProperties) {
        super(pProperties, "MARAGION");
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {

        ItemStack itemStack = pPlayer.getItemInHand(pUsedHand);

        if(!pLevel.isClientSide) {
            if(isAbleToPerformSkill(pLevel,pPlayer)) {
                MaFlameThrowable projectile = new MaFlameThrowable(pLevel, pPlayer, getSpellData());
                projectile.setItem(itemStack);
                projectile.shootFromRotation(pPlayer, pPlayer.getXRot(), pPlayer.getYRot(), 0.0F, 1.5F, 1.0F);
                pLevel.addFreshEntity(projectile);
            }
            return super.use(pLevel,pPlayer,pUsedHand);

        }
        return InteractionResultHolder.fail(pPlayer.getItemInHand(pUsedHand));
    }
}
