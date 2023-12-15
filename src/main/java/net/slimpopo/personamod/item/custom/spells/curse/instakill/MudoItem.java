package net.slimpopo.personamod.item.custom.spells.curse.instakill;

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
import net.slimpopo.personamod.entity.custom.single.CurseMudoThrowable;
import net.slimpopo.personamod.entity.custom.single.FlameThrowable;
import net.slimpopo.personamod.item.constants.SpellItem;
import org.slf4j.Logger;

public class MudoItem extends SpellItem {
    private static final Logger LOGGER = LogUtils.getLogger();


    private static final Spell MUDO = new Spell("Mudo","Light Chance of death to enemy.",
            Affinity.CURSE, DamageType.INSTAKILL, SpellLevel.ONE_STAR, null,null);

    public MudoItem(Properties pProperties) {
        super(pProperties,MUDO);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {

        ItemStack itemStack = pPlayer.getItemInHand(pUsedHand);

        if(!pLevel.isClientSide) {
            CurseMudoThrowable projectile = new CurseMudoThrowable(pLevel, pPlayer, MUDO,0.0f);
            projectile.setItem(itemStack);
            projectile.shootFromRotation(pPlayer, pPlayer.getXRot(), pPlayer.getYRot(), 0.0F, 1.5F, 1.0F);
            pLevel.addFreshEntity(projectile);
        }

        return InteractionResultHolder.sidedSuccess(itemStack,pLevel.isClientSide);
    }
}
