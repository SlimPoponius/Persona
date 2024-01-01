package net.slimpopo.personamod.screen.personastat;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.inventory.SimpleContainerData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.slimpopo.personamod.constant.entity.Persona;
import net.slimpopo.personamod.item.constants.SpellItem;
import net.slimpopo.personamod.screen.ModMenuTypes;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class PersonaStatMenu extends AbstractContainerMenu {
    private final Level level;
    private Persona personaData;
    private SpellItem spellItem;
//    private final ContainerData data;


    public PersonaStatMenu(int containerId, Inventory inv, FriendlyByteBuf extraData){
        this(containerId,inv);
    }

    public PersonaStatMenu(int containerId, Inventory inv){
        super(ModMenuTypes.PERSONA_STAT_MENU.get(),containerId);
        this.level = inv.player.level();
//        this.data = data;
    }

    public void setPersonaData(Persona personaData) {
        this.personaData = personaData;
    }

    public Persona getPersonaData() {
        return personaData;
    }

    public void setSpellItem(SpellItem spellItem) {
        this.spellItem = spellItem;
    }

    public SpellItem getSpellItem() {
        return spellItem;
    }



    @Override
    public ItemStack quickMoveStack(Player pPlayer, int pIndex) {
        return null;
    }

    @Override
    public boolean stillValid(Player pPlayer) {
        return false;
    }
}
