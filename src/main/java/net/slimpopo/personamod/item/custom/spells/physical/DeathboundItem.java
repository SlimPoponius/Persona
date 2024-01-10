package net.slimpopo.personamod.item.custom.spells.physical;

import com.mojang.logging.LogUtils;
import net.slimpopo.personamod.item.constants.PhysicalSpellItem;
import org.slf4j.Logger;

public class DeathboundItem extends PhysicalSpellItem {
    private static final Logger LOGGER = LogUtils.getLogger();

    public DeathboundItem(Properties pProperties) {
        super(pProperties,"DEATHBOUND");
    }

}
