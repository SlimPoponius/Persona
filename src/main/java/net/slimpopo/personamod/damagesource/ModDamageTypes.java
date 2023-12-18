package net.slimpopo.personamod.damagesource;

import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.damagesource.DamageScaling;
import net.minecraft.world.damagesource.DamageType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.slimpopo.personamod.PersonaMod;

public interface ModDamageTypes {
    ResourceKey<DamageType> PERSONA_DAMAGE = ResourceKey.create(Registries.DAMAGE_TYPE,
            new ResourceLocation(PersonaMod.MOD_ID, "persona_damage")
    );

    private static ResourceKey<DamageType> register(String name) {
        return ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation(PersonaMod.MOD_ID, name));
    }

    // bootstrap method
    static void bootstrap(BootstapContext<DamageType> bootstapContext) {
        bootstapContext.register(PERSONA_DAMAGE, new DamageType("persona_damage", 0.1f));
    }

}
