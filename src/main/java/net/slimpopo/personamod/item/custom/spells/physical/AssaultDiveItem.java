package net.slimpopo.personamod.item.custom.spells.physical;

import com.mojang.logging.LogUtils;
import net.slimpopo.personamod.item.constants.PhysicalSpellItem;
import org.slf4j.Logger;

public class AssaultDiveItem extends PhysicalSpellItem {
    private static final Logger LOGGER = LogUtils.getLogger();

    public AssaultDiveItem(Properties pProperties) {
        super(pProperties,"ASSAULT DIVE");
    }

}
