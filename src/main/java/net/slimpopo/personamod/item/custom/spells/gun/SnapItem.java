package net.slimpopo.personamod.item.custom.spells.gun;

import com.mojang.logging.LogUtils;
import net.slimpopo.personamod.item.constants.PhysicalSpellItem;
import org.slf4j.Logger;

public class SnapItem extends PhysicalSpellItem {
    private static final Logger LOGGER = LogUtils.getLogger();

    public SnapItem(Properties pProperties) {
        super(pProperties,"SNAP");
    }

}
