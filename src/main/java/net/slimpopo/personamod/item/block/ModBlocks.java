package net.slimpopo.personamod.item.block;

import net.minecraft.world.level.block.Block;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.slimpopo.personamod.PersonaMod;

public class ModBlocks {
    public static DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, PersonaMod.MOD_ID);

    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }
}
