package net.slimpopo.personamod.item.constants;

import net.minecraft.world.entity.SlotAccess;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.ClickAction;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.slimpopo.personamod.constant.spell.Spell;

public class SpellItem extends Item {
    private final SpellList spellList = new SpellList();
    private Spell spellData;

    public SpellItem(Properties pProperties, String spellName) {
        super(pProperties);
        this.spellData = spellList.getSpellDataWithName(spellName);
    }

    public SpellItem(Properties pProperties, Spell spellData) {
        super(pProperties);
        this.spellData = spellData;
    }

    @Override
    public boolean overrideOtherStackedOnMe(ItemStack pStack, ItemStack pOther, Slot pSlot, ClickAction pAction, Player pPlayer, SlotAccess pAccess) {
        return false;
    }

    @Override
    public boolean overrideStackedOnOther(ItemStack pStack, Slot pSlot, ClickAction pAction, Player pPlayer) {
        return false;
    }

    @Override
    public boolean isDamageable(ItemStack stack) {
        return false;
    }

    public Spell getSpellData() {
        return spellData;
    }
}
