package net.slimpopo.personamod.entity.client.renderer;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.slimpopo.personamod.PersonaMod;
import net.slimpopo.personamod.entity.client.ModModelLayers;
import net.slimpopo.personamod.entity.client.models.PyroJackModel;
import net.slimpopo.personamod.entity.custom.personas.PyroJackEntity;

public class PyroJackRenderer extends MobRenderer<PyroJackEntity, PyroJackModel<PyroJackEntity>> {
    public PyroJackRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new PyroJackModel<>(pContext.bakeLayer(ModModelLayers.PYRO_JACK_LAYER)), 1f);
    }

    @Override
    public ResourceLocation getTextureLocation(PyroJackEntity pEntity) {
        return new ResourceLocation(PersonaMod.MOD_ID,"textures/entity/pyro_jack.png");
    }
}
