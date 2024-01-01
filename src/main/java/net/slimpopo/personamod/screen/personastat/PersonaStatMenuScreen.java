package net.slimpopo.personamod.screen.personastat;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.AbstractButton;
import net.minecraft.client.gui.narration.NarrationElementOutput;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.slimpopo.personamod.PersonaMod;
import net.slimpopo.personamod.constant.entity.ControlledPersona;
import net.slimpopo.personamod.constant.entity.Persona;
import net.slimpopo.personamod.item.constants.SpellItem;

public class PersonaStatMenuScreen extends AbstractContainerScreen<PersonaStatMenu> {
    private static final ResourceLocation TEXTURE =
            new ResourceLocation(PersonaMod.MOD_ID,"textures/gui/persona_stat_page.png");
    private static final ResourceLocation TEXTURE_BAR =
            new ResourceLocation(PersonaMod.MOD_ID,"textures/gui/persona_stat_bar.png");
    private ControlledPersona personaViewed;
    private SpellItem spellItem;

    public PersonaStatMenuScreen(PersonaStatMenu pMenu, Inventory pPlayerInventory,
                                 Component pTitle) {
        super(pMenu, pPlayerInventory, pTitle);
        this.personaViewed = (ControlledPersona) pMenu.getPersonaData();
        this.spellItem = pMenu.getSpellItem();
    }

    @Override
    protected void init() {
        super.init();
        this.inventoryLabelY = 10000;
        this.titleLabelY = 10000;

        //Buttons: x = 25, y = 91
        for(int i = 0; i < 4;i++) {
            for(int j = 0; j < 2;j++) {
                int idx = i + (4*j);
                this.addRenderableWidget(new AbstractButton(28 + (66 * j), 91 + (15 * i), 52, 12,
                        Component.literal(personaViewed.getLearnedSkills().get(idx).getSpellData().getSPELL_NAME())) {
                    @Override
                    protected void updateWidgetNarration(NarrationElementOutput pNarrationElementOutput) {

                    }

                    @Override
                    public void onPress() {
                        personaViewed.getLearnedSkills().set(idx,spellItem);
                        Minecraft.getInstance().player.closeContainer();
                    }
                });
            }
        }
    }

    @Override
    protected void renderBg(GuiGraphics pGuiGraphics, float pPartialTick, int pMouseX, int pMouseY) {
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0f,1.0f,1.0f,1.0f);
        RenderSystem.setShaderTexture(0,TEXTURE);

        int x = (width - imageWidth) / 2;
        int y = (height-imageHeight) / 2;

        pGuiGraphics.blit(TEXTURE,x,y,0,0,imageWidth,imageHeight);
        renderPersonaStatsPage(pGuiGraphics,x,y);
    }

    private void renderPersonaStatsPage(GuiGraphics pGuiGraphics, int x, int y) {
        //x: 21, y: 28, difference for each bar: 9
        int strStat = (int)(personaViewed.getStrengthPercentage() * 133.0f);
        int magStat = (int)(personaViewed.getMagicPercentage() * 133.0f);
        int agiStat = (int)(personaViewed.getAgilityPercentage() * 133.0f);
        int endStat = (int)(personaViewed.getEndurancePercentage() * 133.0f);
        int lckStat = (int)(personaViewed.getLuckPercentage() * 133.0f);

        pGuiGraphics.blit(TEXTURE_BAR,x +21, y + 28,0,0
                ,strStat,5,strStat,5);
        pGuiGraphics.drawString(Minecraft.getInstance().font, "STR",x+4,
                y + 28,0x000000);
        pGuiGraphics.drawString(Minecraft.getInstance().font,String.valueOf(personaViewed.getSTRENGTH()),x+154,
                y+28,0x000000);


        pGuiGraphics.blit(TEXTURE_BAR,x +21, y + 37,0,0
                ,magStat,5,magStat,5);
        pGuiGraphics.drawString(Minecraft.getInstance().font, "MAG",x+4,
                y + 37,0x000000);
        pGuiGraphics.drawString(Minecraft.getInstance().font,String.valueOf(personaViewed.getMAGIC()),x+154,
                y+37,0x000000);


        pGuiGraphics.blit(TEXTURE_BAR,x +21, y + 46,0,0
                ,agiStat,5,agiStat,5);
        pGuiGraphics.drawString(Minecraft.getInstance().font, "AGI",x+4,
                y + 46,0x000000);
        pGuiGraphics.drawString(Minecraft.getInstance().font,String.valueOf(personaViewed.getAGILITY()),x+154,
                y+46,0x000000);


        pGuiGraphics.blit(TEXTURE_BAR,x +21, y + 55,0,0
                ,endStat,5,endStat,5);
        pGuiGraphics.drawString(Minecraft.getInstance().font, "END",x+4,
                y + 55,0x000000);
        pGuiGraphics.drawString(Minecraft.getInstance().font,String.valueOf(personaViewed.getENDURANCE()),x+154,
                y+55,0x000000);

        pGuiGraphics.blit(TEXTURE_BAR,x +21, y + 64,0,0
                ,lckStat,5,lckStat,5);
        pGuiGraphics.drawString(Minecraft.getInstance().font, "LUC",x+4,
                y + 64,0x000000);
        pGuiGraphics.drawString(Minecraft.getInstance().font,String.valueOf(personaViewed.getLUCK()),x+154,
                y+64,0x000000);



    }

    @Override
    public void render(GuiGraphics pGuiGraphics, int pMouseX, int pMouseY, float pPartialTick) {
        renderBackground(pGuiGraphics);
        super.render(pGuiGraphics, pMouseX, pMouseY, pPartialTick);
    }
}
