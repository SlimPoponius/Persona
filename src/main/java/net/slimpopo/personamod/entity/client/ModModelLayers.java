package net.slimpopo.personamod.entity.client;

import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;
import net.slimpopo.personamod.PersonaMod;

public class ModModelLayers {
    public static final ModelLayerLocation PYRO_JACK_LAYER = new ModelLayerLocation(
            new ResourceLocation(PersonaMod.MOD_ID,"pyro_jack_layer"),"main");
    public static final ModelLayerLocation JACK_FROST_LAYER = new ModelLayerLocation(
            new ResourceLocation(PersonaMod.MOD_ID,"jack_frost_layer"),"main");
    public static final ModelLayerLocation BLACK_FROST_LAYER = new ModelLayerLocation(
            new ResourceLocation(PersonaMod.MOD_ID,"black_frost_layer"),"main");
}
