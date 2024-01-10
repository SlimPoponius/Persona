package net.slimpopo.personamod.item.custom.spells.physical;

import com.mojang.logging.LogUtils;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.slimpopo.personamod.constant.spell.PhysicalSpell;
import net.slimpopo.personamod.entity.custom.single.FlameThrowable;
import net.slimpopo.personamod.item.constants.PhysicalSpellItem;
import net.slimpopo.personamod.item.constants.SpellItem;
import org.slf4j.Logger;

public class LungeItem extends PhysicalSpellItem {
    private static final Logger LOGGER = LogUtils.getLogger();

    public LungeItem(Properties pProperties) {
        super(pProperties,"LUNGE");
    }

}
