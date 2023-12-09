package net.slimpopo.personamod.effects.custom;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

import java.util.Random;

public class ConfuseEffect extends MobEffect {
    public ConfuseEffect(MobEffectCategory pCategory, int pColor) {
        super(pCategory, pColor);
    }

    @Override
    public void applyEffectTick(LivingEntity pLivingEntity, int pAmplifier) {
        Random random = new Random();

        if(!pLivingEntity.level().isClientSide){
            if(random.nextFloat() > 0.8f){
                if(pLivingEntity instanceof Mob mob){
                    mob.spawnAtLocation(spawnRandomMinerals());
                }
                else if(pLivingEntity instanceof Player player){
                    pickRandomItemFromInventoryAndDeleteIt(player);
                }
            }
        }


        super.applyEffectTick(pLivingEntity, pAmplifier);
    }

    private void pickRandomItemFromInventoryAndDeleteIt(Player player) {
        Random random = new Random();
        int pos = player.getInventory().items.size();
        int invIdx = random.nextInt() % pos;
        Item chosenitm = player.getInventory().items.get(invIdx).getItem();

        ItemStack chosenItem = player.getInventory().items.stream().filter(x -> x.is(chosenitm)).findFirst().get();
        int itemLocationInInventory = player.getInventory().findSlotMatchingItem(chosenItem);
        player.getInventory().removeItem(itemLocationInInventory,1);
    }

    private ItemStack spawnRandomMinerals() {
        Random random = new Random();
        //iron, gold, copper, lapiz, redstone, diamond, emerald, coal
        int ore = random.nextInt() % 8;
        Item dropped = getItemFromValue(ore);
        return (null!= dropped) ? new ItemStack(dropped) : ItemStack.EMPTY;
    }

    private Item getItemFromValue(int ore) {
        switch(ore){
            case 0:
                return Items.COAL;
            case 1:
                return Items.COPPER_INGOT;
            case 2:
                return Items.GOLD_INGOT;
            case 3:
                return Items.LAPIS_LAZULI;
            case 4:
                return Items.IRON_INGOT;
            case 5:
                return Items.DIAMOND;
            case 6:
                return Items.REDSTONE;
            case 7:
                return Items.EMERALD;
        }
        return null;
    }

    @Override
    public boolean isDurationEffectTick(int pDuration, int pAmplifier) {
        return true;
    }
}
