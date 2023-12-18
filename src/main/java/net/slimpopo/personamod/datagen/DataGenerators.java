package net.slimpopo.personamod.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.RegistryDataLoader;
import net.minecraftforge.common.data.DatapackBuiltinEntriesProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.slimpopo.personamod.PersonaMod;
import net.slimpopo.personamod.damagesource.ModDamageTypes;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

@Mod.EventBusSubscriber(modid = PersonaMod.MOD_ID,bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenerators {

    private static final RegistrySetBuilder BUILDER =
            new RegistrySetBuilder().add(Registries.DAMAGE_TYPE, ModDamageTypes::bootstrap);


    @SubscribeEvent
    public static void gatherData(GatherDataEvent event){
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

        generator.addProvider(event.includeServer(), new ModItemModelProvider(packOutput,existingFileHelper));

        ModBlockTagGenerator blockTagGenerator = generator.addProvider(event.includeServer(),
                new ModBlockTagGenerator(packOutput,lookupProvider,existingFileHelper));

        generator.addProvider(event.includeServer(), new ModItemTagGenerator(packOutput,lookupProvider,
                blockTagGenerator.contentsGetter(),existingFileHelper));

        generator.addProvider(event.includeServer(), new ModRecipeProvider(packOutput));
        generator.addProvider(event.includeServer(), ModLootTableProvider.create(packOutput));
        generator.addProvider(event.includeServer(), new ModBlockStateProvider(packOutput,existingFileHelper));
        generator.addProvider(event.includeServer(), new DatapackBuiltinEntriesProvider(
                packOutput, event.getLookupProvider(), BUILDER, Set.of(PersonaMod.MOD_ID)));

    }


}
