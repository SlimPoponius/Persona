package net.slimpopo.personamod.effects;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.slimpopo.personamod.PersonaMod;
import net.slimpopo.personamod.effects.custom.*;

public class ModEffects {
    public static final DeferredRegister<MobEffect> MOB_EFFECTS =
            DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, PersonaMod.MOD_ID);

    public static final RegistryObject<FreezeEffect> FREEZE = MOB_EFFECTS.register("freeze",
            () -> new FreezeEffect(MobEffectCategory.HARMFUL,0x99FFFF));

    public static final RegistryObject<ShockEffect> SHOCK = MOB_EFFECTS.register("shock",
            () -> new ShockEffect(MobEffectCategory.HARMFUL,0xFFFF00));

    public static final RegistryObject<BurnEffect> BURN = MOB_EFFECTS.register("burn",
            () -> new BurnEffect(MobEffectCategory.HARMFUL,0xFF0000));

    public static final RegistryObject<ConfuseEffect> CONFUSE = MOB_EFFECTS.register("confuse",
            () -> new ConfuseEffect(MobEffectCategory.HARMFUL,0xFFB6C1));

    public static final RegistryObject<DespairEffect> DESPAIR = MOB_EFFECTS.register("despair",
            () -> new DespairEffect(MobEffectCategory.HARMFUL,0x301934));

    public static final RegistryObject<FearEffect> FEAR = MOB_EFFECTS.register("fear",
            () -> new FearEffect(MobEffectCategory.HARMFUL,0xAA336A));

    public static final RegistryObject<DizzyEffect> DIZZY = MOB_EFFECTS.register("dizzy",
            () -> new DizzyEffect(MobEffectCategory.HARMFUL,0xFFFFED));

    public static final RegistryObject<RageEffect> RAGE = MOB_EFFECTS.register("rage",
            () -> new RageEffect(MobEffectCategory.HARMFUL,0xFFFFED));

    public static void register(IEventBus eventBus){
        MOB_EFFECTS.register(eventBus);
    }

}
