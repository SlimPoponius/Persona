package net.slimpopo.personamod.entity;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.slimpopo.personamod.PersonaMod;
import net.slimpopo.personamod.entity.custom.group.*;
import net.slimpopo.personamod.entity.custom.personas.blackfrost.BlackFrostEntity;
import net.slimpopo.personamod.entity.custom.personas.blackfrost.BlackFrostSummonEntity;
import net.slimpopo.personamod.entity.custom.personas.jackfrost.JackFrostEntity;
import net.slimpopo.personamod.entity.custom.personas.jackfrost.JackFrostSummonEntity;
import net.slimpopo.personamod.entity.custom.personas.pyrojack.PyroJackEntity;
import net.slimpopo.personamod.entity.custom.personas.pyrojack.PyroJackSummonEntity;
import net.slimpopo.personamod.entity.custom.single.*;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, PersonaMod.MOD_ID);


    public static final RegistryObject<EntityType<CurseThrowable>> CURSE_THROWABLE =
            ENTITY_TYPES.register("crs_throwable",() -> EntityType
                    .Builder.<CurseThrowable>of(CurseThrowable::new, MobCategory.MISC)
                    .sized(0.5f,0.5f).build("crs_throwable"));
    public static final RegistryObject<EntityType<CurseMudoThrowable>> CURSE_MUDO_THROWABLE =
            ENTITY_TYPES.register("crs_mudo_throwable",() -> EntityType
                    .Builder.<CurseMudoThrowable>of(CurseMudoThrowable::new, MobCategory.MISC)
                    .sized(0.5f,0.5f).build("crs_mudo_throwable"));

    public static final RegistryObject<EntityType<MaCurseMudoThrowable>> GRP_CURSE_MUDO_THROWABLE =
            ENTITY_TYPES.register("grp_crs_mudo_throwable",() -> EntityType
                    .Builder.<MaCurseMudoThrowable>of(MaCurseMudoThrowable::new, MobCategory.MISC)
                    .sized(0.5f,0.5f).build("grp_crs_mudo_throwable"));
    public static final RegistryObject<EntityType<MaCurseThrowable>> GRP_CURSE_THROWABLE =
            ENTITY_TYPES.register("grp_crs_throwable",() -> EntityType
                    .Builder.<MaCurseThrowable>of(MaCurseThrowable::new, MobCategory.MISC)
                    .sized(0.5f,0.5f).build("grp_crs_throwable"));

    public static final RegistryObject<EntityType<BlessThrowable>> BLESS_THROWABLE =
            ENTITY_TYPES.register("bls_throwable",() -> EntityType
                    .Builder.<BlessThrowable>of(BlessThrowable::new, MobCategory.MISC)
                    .sized(0.5f,0.5f).build("bls_throwable"));

    public static final RegistryObject<EntityType<BlessHamaThrowable>> BLESS_HAMA_THROWABLE =
            ENTITY_TYPES.register("bls_hama_throwable",() -> EntityType
                    .Builder.<BlessHamaThrowable>of(BlessHamaThrowable::new, MobCategory.MISC)
                    .sized(0.5f,0.5f).build("bls_hama_throwable"));

    public static final RegistryObject<EntityType<MaBlessHamaThrowable>> GRP_BLESS_HAMA_THROWABLE =
            ENTITY_TYPES.register("grp_bls_throwable",() -> EntityType
                    .Builder.<MaBlessHamaThrowable>of(MaBlessHamaThrowable::new, MobCategory.MISC)
                    .sized(0.5f,0.5f).build("grp_bls_throwable"));
    public static final RegistryObject<EntityType<MaBlessThrowable>> GRP_BLESS_THROWABLE =
            ENTITY_TYPES.register("grp_bls_hama_throwable",() -> EntityType
                    .Builder.<MaBlessThrowable>of(MaBlessThrowable::new, MobCategory.MISC)
                    .sized(0.5f,0.5f).build("grp_bls_hama_throwable"));

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

    public static final RegistryObject<EntityType<AlmightyThrowable>> ALMIGHTY_THROWABLE =
            ENTITY_TYPES.register("almighty_throwable",() -> EntityType
                    .Builder.<AlmightyThrowable>of(AlmightyThrowable::new, MobCategory.MISC)
                    .sized(0.5f,0.5f).build("almighty_throwable"));

    public static final RegistryObject<EntityType<MaAlmightyThrowable>> GRP_ALMIGHTY_THROWABLE =
            ENTITY_TYPES.register("grp_almighty_throwable",() -> EntityType
                    .Builder.<MaAlmightyThrowable>of(MaAlmightyThrowable::new, MobCategory.MISC)
                    .sized(0.5f,0.5f).build("grp_almighty_throwable"));

    //Mobs
    public static final RegistryObject<EntityType<PyroJackEntity>> PYRO_JACK =
            ENTITY_TYPES.register("pyro_jack", () -> EntityType.Builder.of(PyroJackEntity::new, MobCategory.MONSTER)
                    .sized(1.0f,1.0f).build("pyro_jack"));
    public static final RegistryObject<EntityType<JackFrostEntity>> JACK_FROST =
            ENTITY_TYPES.register("jack_frost", () -> EntityType.Builder.of(JackFrostEntity::new, MobCategory.MONSTER)
                    .sized(1.0f,1.0f).build("jack_frost"));
    public static final RegistryObject<EntityType<BlackFrostEntity>> BLACK_FROST =
            ENTITY_TYPES.register("black_frost", () -> EntityType.Builder.of(BlackFrostEntity::new, MobCategory.MONSTER)
                    .sized(1.0f,1.0f).build("black_frost"));

    //Tameable
    public static final RegistryObject<EntityType<JackFrostSummonEntity>> JACK_FROST_SUMMON =
            ENTITY_TYPES.register("jack_frost_summon", () -> EntityType.Builder.of(JackFrostSummonEntity::new, MobCategory.MISC)
                    .sized(1.0f,1.0f).build("jack_frost_summon"));
    public static final RegistryObject<EntityType<PyroJackSummonEntity>> PYRO_JACK_SUMMON =
            ENTITY_TYPES.register("pyro_jack_summon", () -> EntityType.Builder.of(PyroJackSummonEntity::new, MobCategory.MISC)
                    .sized(1.0f,1.0f).build("pyro_jack_summon"));
    public static final RegistryObject<EntityType<BlackFrostSummonEntity>> BLACK_FROST_SUMMON =
            ENTITY_TYPES.register("black_frost_summon", () -> EntityType.Builder.of(BlackFrostSummonEntity::new, MobCategory.MISC)
                    .sized(1.0f,1.0f).build("black_frost_summon"));

    public static void register(IEventBus eventBus){
        ENTITY_TYPES.register(eventBus);
    }

}
