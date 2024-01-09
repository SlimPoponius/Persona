package net.slimpopo.personamod.entity.client.renderer.jackfrost;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.slimpopo.personamod.PersonaMod;
import net.slimpopo.personamod.entity.client.ModModelLayers;
import net.slimpopo.personamod.entity.client.models.JackFrostModel;
import net.slimpopo.personamod.entity.client.models.PyroJackModel;
import net.slimpopo.personamod.entity.custom.personas.jackfrost.JackFrostEntity;
import net.slimpopo.personamod.entity.custom.personas.pyrojack.PyroJackEntity;

public class JackFrostRenderer extends MobRenderer<JackFrostEntity, JackFrostModel<JackFrostEntity>> {
    public JackFrostRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new JackFrostModel<>(pContext.bakeLayer(ModModelLayers.JACK_FROST_LAYER)), 1f);
    }

    @Override
    public ResourceLocation getTextureLocation(JackFrostEntity pEntity) {
        return new ResourceLocation(PersonaMod.MOD_ID,"textures/entity/jack_frost.png");
    }
}
