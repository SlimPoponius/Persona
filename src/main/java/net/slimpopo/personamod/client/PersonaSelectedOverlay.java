package net.slimpopo.personamod.client;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.gui.overlay.IGuiOverlay;
import net.slimpopo.personamod.PersonaMod;


public class PersonaSelectedOverlay {
    private static final String personaNameKey = "key.personamod.personaname";

    public static final ResourceLocation PERSONA_SEL_OVERLAY =
            new ResourceLocation(PersonaMod.MOD_ID,"textures/persona_sel/selectionbarpersona.png");
    public static final ResourceLocation PERSONA_SEL_SKILL_OVERLAY =
            new ResourceLocation(PersonaMod.MOD_ID,"textures/persona_sel/selectionbarmagic.png");

    public static final IGuiOverlay PERSONA_SEL = (((gui, guiGraphics, partialTick, screenWidth, screenHeight) -> {
        int x = screenWidth/2;
        int y = screenHeight;
        boolean hasPersonasUnlocked = ClientPersonaSelectionData.isUnlockedPersonas();
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0f,1.0f,1.0f,1.0f);

        if(hasPersonasUnlocked) {
            String currentSelectedPersona = Component.translatable(personaNameKey+"."
                    + ClientPersonaSelectionData.getCurrentSelectedPersona()).getString();

            String currentSelectedPersonaSkill = ClientPersonaSelectionData.getCurrentSelectedPersonaSkill();

            guiGraphics.blit(PERSONA_SEL_SKILL_OVERLAY, -10, 10, 0,
                    0, 182, 33, 182, 33);

            guiGraphics.drawString(Minecraft.getInstance().font,currentSelectedPersona,65,
                    25,0xFFFFFF);

            guiGraphics.blit(PERSONA_SEL_OVERLAY, -10, 33, 0,
                    0, 182, 33, 182, 33);

            guiGraphics.drawString(Minecraft.getInstance().font,currentSelectedPersonaSkill,55,
                    48,0xFFFFFF);

        }

    }));
}
