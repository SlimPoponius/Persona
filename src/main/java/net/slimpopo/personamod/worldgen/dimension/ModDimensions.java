//package net.slimpopo.personamod.worldgen.dimension;
//
//import net.minecraft.core.HolderGetter;
//import net.minecraft.core.Registry;
//import net.minecraft.core.registries.Registries;
//import net.minecraft.data.worldgen.BootstapContext;
//import net.minecraft.resources.ResourceKey;
//import net.minecraft.resources.ResourceLocation;
//import net.minecraft.tags.BlockTags;
//import net.minecraft.util.valueproviders.ConstantInt;
//import net.minecraft.world.level.Level;
//import net.minecraft.world.level.biome.Biome;
//import net.minecraft.world.level.biome.FixedBiomeSource;
//import net.minecraft.world.level.dimension.BuiltinDimensionTypes;
//import net.minecraft.world.level.dimension.DimensionType;
//import net.minecraft.world.level.dimension.LevelStem;
//import net.minecraft.world.level.levelgen.NoiseBasedChunkGenerator;
//import net.minecraft.world.level.levelgen.NoiseGeneratorSettings;
//import net.slimpopo.personamod.PersonaMod;
//
//import java.util.OptionalLong;
//
//
//public class ModDimensions {
//    public static final ResourceKey<LevelStem> PRSNAM_KEY = ResourceKey.create(Registries.LEVEL_STEM,
//            new ResourceLocation(PersonaMod.MOD_ID,"prsnadim"));
//    public static final ResourceKey<Level> PRSNAM_LEVEL_KEY = ResourceKey.create(Registries.DIMENSION,
//            new ResourceLocation(PersonaMod.MOD_ID,"prsnadim"));
//    public static final ResourceKey<DimensionType> PRSNAM_DIM_TYPE= ResourceKey.create(Registries.DIMENSION_TYPE,
//            new ResourceLocation(PersonaMod.MOD_ID,"prsnadim_type"));
//
//    public static void bootstrapType(BootstapContext<DimensionType> context){
//        context.register(PRSNAM_DIM_TYPE, new DimensionType(
//                OptionalLong.of(12000),
//                false,
//                false,
//                false,
//                false,
//                1.0,
//                true,
//                false,
//                0,
//                256,
//                256,
//                BlockTags.INFINIBURN_OVERWORLD,
//                BuiltinDimensionTypes.OVERWORLD_EFFECTS,
//                1.0f,
//                new DimensionType.MonsterSettings(false,false, ConstantInt.of(0),0)
//
//        ));
//    }
//
//    public static void bootstrapStem(BootstapContext<LevelStem> context){
//        HolderGetter<Biome> biomeRegistry = context.lookup(Registries.BIOME);
//        HolderGetter<DimensionType> dimTypes = context.lookup(Registries.DIMENSION_TYPE);
//        HolderGetter<NoiseGeneratorSettings> noisGenSettings = context.lookup(Registries.NOISE_SETTINGS);
//
//        NoiseBasedChunkGenerator wrappedChunkGenerator = new NoiseBasedChunkGenerator(
//                new FixedBiomeSource(biomeRegistry.getOrThrow())
//        )
//
//    }
//}
