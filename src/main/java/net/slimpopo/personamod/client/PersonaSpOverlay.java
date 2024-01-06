package net.slimpopo.personamod.client;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.gui.overlay.ForgeGui;
import net.minecraftforge.client.gui.overlay.GuiOverlayManager;
import net.minecraftforge.client.gui.overlay.IGuiOverlay;
import net.slimpopo.personamod.PersonaMod;

import java.awt.*;

public class PersonaSpOverlay {
    public static final ResourceLocation PERSONASP_OVERLAY =
            new ResourceLocation(PersonaMod.MOD_ID,"textures/personasp/personaspbaroverlay.png");
    public static final ResourceLocation PERSONASP_UNDERLAY =
            new ResourceLocation(PersonaMod.MOD_ID,"textures/personasp/personaspbarunderlay.png");

    public static final IGuiOverlay PERSONA_SP = (((gui, guiGraphics, partialTick, screenWidth, screenHeight) -> {
        int x = screenWidth/2;
        int y = screenHeight;
        int sp = (int)(ClientPersonaPlayerData.getPlayerSpAmount() * 182.0f);

        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0f,1.0f,1.0f,1.0f);
        RenderSystem.setShaderTexture(0,PERSONASP_UNDERLAY);

        guiGraphics.drawString(Minecraft.getInstance().font,String.valueOf(ClientPersonaPlayerData.getCurSp())
                ,(x * 2) - 24,y/2,0xFFFFFF);

        guiGraphics.blit(PERSONASP_UNDERLAY,(x * 2) - 20,(y/2) - 91,0,
                0,5,182,5,5);


        if(sp > 0f){
            RenderSystem.setShaderTexture(0,PERSONASP_OVERLAY);
            guiGraphics.blit(PERSONASP_OVERLAY,(x * 2) - 20,(y/2) - 91,0,0,5,sp,
                    5,sp);
        }
    }));
}
