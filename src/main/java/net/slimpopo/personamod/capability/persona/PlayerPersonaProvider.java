package net.slimpopo.personamod.capability.persona;

import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.CapabilityToken;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.INBTSerializable;
import net.minecraftforge.common.util.LazyOptional;
import net.slimpopo.personamod.capability.persona.impl.PlayerPersona;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class PlayerPersonaProvider implements ICapabilityProvider, INBTSerializable<CompoundTag> {
    public static Capability<PlayerPersona> PLAYER_PERSONA
            = CapabilityManager.get(new CapabilityToken<PlayerPersona>() { });

    private PlayerPersona playerPersona = null;
    private final LazyOptional<PlayerPersona> optional = LazyOptional.of(this::createPlayerPersona);

    private PlayerPersona createPlayerPersona() {
        if(null == this.playerPersona){
            this.playerPersona = new PlayerPersona();
        }
        return  this.playerPersona;
    }

    @Override
    public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
        if(cap == PLAYER_PERSONA) {
            return optional.cast();
        }

        return LazyOptional.empty();
    }

    @Override
    public CompoundTag serializeNBT() {
        CompoundTag nbt = new CompoundTag();
        createPlayerPersona().saveNBTData(nbt);
        return nbt;
    }

    @Override
    public void deserializeNBT(CompoundTag nbt) {
        createPlayerPersona().loadNBTData(nbt);
    }
}
