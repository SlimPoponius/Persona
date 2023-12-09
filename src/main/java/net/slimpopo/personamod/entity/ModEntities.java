package net.slimpopo.personamod.entity;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.slimpopo.personamod.PersonaMod;
import net.slimpopo.personamod.entity.custom.group.*;
import net.slimpopo.personamod.entity.custom.single.*;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, PersonaMod.MOD_ID);

    public static final RegistryObject<EntityType<FlameThrowable>> FLAME_THROWABLE =
            ENTITY_TYPES.register("flame_throwable",() -> EntityType
                    .Builder.<FlameThrowable>of(FlameThrowable::new, MobCategory.MISC)
                    .sized(0.5f,0.5f).build("flame_throwable"));

    public static final RegistryObject<EntityType<MaFlameThrowable>> GRP_FLAME_THROWABLE =
            ENTITY_TYPES.register("grp_flame_throwable",() -> EntityType
                    .Builder.<MaFlameThrowable>of(MaFlameThrowable::new, MobCategory.MISC)
                    .sized(0.5f,0.5f).build("grp_flame_throwable"));

    public static final RegistryObject<EntityType<IceThrowable>> ICE_THROWABLE =
            ENTITY_TYPES.register("ice_throwable",() -> EntityType
                    .Builder.<IceThrowable>of(IceThrowable::new, MobCategory.MISC)
                    .sized(0.5f,0.5f).build("ice_throwable"));

    public static final RegistryObject<EntityType<MaIceThrowable>> GRP_ICE_THROWABLE =
            ENTITY_TYPES.register("grp_ice_throwable",() -> EntityType
                    .Builder.<MaIceThrowable>of(MaIceThrowable::new, MobCategory.MISC)
                    .sized(0.5f,0.5f).build("grp_ice_throwable"));

    public static final RegistryObject<EntityType<WindThrowable>> WIND_THROWABLE =
            ENTITY_TYPES.register("wind_throwable",() -> EntityType
                    .Builder.<WindThrowable>of(WindThrowable::new, MobCategory.MISC)
                    .sized(0.5f,0.5f).build("wind_throwable"));

    public static final RegistryObject<EntityType<MaWindThrowable>> GRP_WIND_THROWABLE =
            ENTITY_TYPES.register("grp_wind_throwable",() -> EntityType
                    .Builder.<MaWindThrowable>of(MaWindThrowable::new, MobCategory.MISC)
                    .sized(0.5f,0.5f).build("grp_wind_throwable"));

    public static final RegistryObject<EntityType<ElectricThrowable>> ELECTRIC_THROWABLE =
            ENTITY_TYPES.register("electric_throwable",() -> EntityType
                    .Builder.<ElectricThrowable>of(ElectricThrowable::new, MobCategory.MISC)
                    .sized(0.5f,0.5f).build("electric_throwable"));

    public static final RegistryObject<EntityType<MaElectricThrowable>> GRP_ELECTRIC_THROWABLE =
            ENTITY_TYPES.register("grp_electric_throwable",() -> EntityType
                    .Builder.<MaElectricThrowable>of(MaElectricThrowable::new, MobCategory.MISC)
                    .sized(0.5f,0.5f).build("grp_electric_throwable"));

    public static final RegistryObject<EntityType<NukeThrowable>> NUKE_THROWABLE =
            ENTITY_TYPES.register("nuke_throwable",() -> EntityType
                    .Builder.<NukeThrowable>of(NukeThrowable::new, MobCategory.MISC)
                    .sized(0.5f,0.5f).build("nuke_throwable"));

    public static final RegistryObject<EntityType<MaNukeThrowable>> GRP_NUKE_THROWABLE =
            ENTITY_TYPES.register("grp_nuke_throwable",() -> EntityType
                    .Builder.<MaNukeThrowable>of(MaNukeThrowable::new, MobCategory.MISC)
                    .sized(0.5f,0.5f).build("grp_nuke_throwable"));

    public static final RegistryObject<EntityType<PsiThrowable>> PSI_THROWABLE =
            ENTITY_TYPES.register("psi_throwable",() -> EntityType
                    .Builder.<PsiThrowable>of(PsiThrowable::new, MobCategory.MISC)
                    .sized(0.5f,0.5f).build("psi_throwable"));

    public static final RegistryObject<EntityType<MaPsiThrowable>> GRP_PSI_THROWABLE =
            ENTITY_TYPES.register("grp_psi_throwable",() -> EntityType
                    .Builder.<MaPsiThrowable>of(MaPsiThrowable::new, MobCategory.MISC)
                    .sized(0.5f,0.5f).build("grp_psi_throwable"));

    public static void register(IEventBus eventBus){
        ENTITY_TYPES.register(eventBus);
    }

}
