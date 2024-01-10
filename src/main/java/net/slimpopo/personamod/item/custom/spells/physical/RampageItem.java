package net.slimpopo.personamod.item.custom.spells.physical;

import com.mojang.logging.LogUtils;
import net.slimpopo.personamod.item.constants.PhysicalSpellItem;
import org.slf4j.Logger;

public class RampageItem extends PhysicalSpellItem {
    private static final Logger LOGGER = LogUtils.getLogger();

    public RampageItem(Properties pProperties) {
        super(pProperties,"RAMPAGE");
    }

}
