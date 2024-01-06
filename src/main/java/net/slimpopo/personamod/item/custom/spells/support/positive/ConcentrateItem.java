package net.slimpopo.personamod.item.custom.spells.support.positive;

import com.mojang.logging.LogUtils;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.slimpopo.personamod.capability.persona.PlayerPersonaProvider;
import net.slimpopo.personamod.item.constants.SpellItem;
import org.slf4j.Logger;

public class ConcentrateItem extends SpellItem {
    private static final Logger LOGGER = LogUtils.getLogger();

    public ConcentrateItem(Properties pProperties) {
        super(pProperties,"CHARGE");
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {

        ItemStack itemStack = pPlayer.getItemInHand(pUsedHand);

        if(!pLevel.isClientSide) {
           pPlayer.getCapability(PlayerPersonaProvider.PLAYER_PERSONA).ifPresent(playerPersona -> {
               playerPersona.setUsedConcentrateSkill(true);
           });
        }

        return super.use(pLevel,pPlayer,pUsedHand);
    }
}
