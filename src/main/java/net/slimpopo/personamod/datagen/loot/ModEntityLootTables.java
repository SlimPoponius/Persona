package net.slimpopo.personamod.datagen.loot;

import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.data.loot.EntityLootSubProvider;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.entries.LootTableReference;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.registries.RegistryObject;
import net.slimpopo.personamod.entity.ModEntities;
import net.slimpopo.personamod.entity.custom.constants.PersonaEntity;
import net.slimpopo.personamod.item.ModItems;
import net.slimpopo.personamod.item.block.ModBlocks;

import java.util.Set;
import java.util.stream.Stream;

public class ModEntityLootTables extends EntityLootSubProvider {
    public ModEntityLootTables() {
        super( FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    public void generate() {

        this.add(ModEntities.PYRO_JACK.get(),createPersonaTable());
        this.add(ModEntities.JACK_FROST.get(),createPersonaTable());
        this.add(ModEntities.BLACK_FROST.get(),createPersonaTable());

    }

    @Override
    protected Stream<EntityType<?>> getKnownEntityTypes() {
        return ModEntities.ENTITY_TYPES.getEntries().stream().map(RegistryObject::get);
    }

    protected static LootTable.Builder createPersonaTable() {
        return LootTable.lootTable().withPool(LootPool.lootPool()
                .setRolls(ConstantValue.exactly(1.0F))
                .add(LootItem.lootTableItem(ModItems.ARCANACARD.get())))
                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0f,3.0f)));
    }
}
