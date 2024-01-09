package net.slimpopo.personamod.entity.client.renderer.blackfrost;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.slimpopo.personamod.PersonaMod;
import net.slimpopo.personamod.entity.client.ModModelLayers;
import net.slimpopo.personamod.entity.client.models.JackFrostModel;
import net.slimpopo.personamod.entity.custom.personas.blackfrost.BlackFrostEntity;
import net.slimpopo.personamod.entity.custom.personas.jackfrost.JackFrostEntity;

public class BlackFrostRenderer extends MobRenderer<BlackFrostEntity, JackFrostModel<BlackFrostEntity>> {
    public BlackFrostRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new JackFrostModel<>(pContext.bakeLayer(ModModelLayers.BLACK_FROST_LAYER)), 1f);
    }

    @Override
    public ResourceLocation getTextureLocation(BlackFrostEntity pEntity) {
        return new ResourceLocation(PersonaMod.MOD_ID,"textures/entity/black_frost.png");
    }
}
