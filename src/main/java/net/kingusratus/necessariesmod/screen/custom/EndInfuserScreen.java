package net.kingusratus.necessariesmod.screen.custom;

import net.kingusratus.necessariesmod.NecessariesMod;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

public class EndInfuserScreen extends AbstractContainerScreen<EndInfuserMenu> {

    private static final ResourceLocation GUI_TEXTURE =
            ResourceLocation.fromNamespaceAndPath(NecessariesMod.MOD_ID,"textures/gui/end_infuser/end_infuser_gui.png");
    private static final ResourceLocation ARROW_TEXTURE =
            ResourceLocation.fromNamespaceAndPath(NecessariesMod.MOD_ID,"textures/gui/end_infuser/infuser_progress.png");
    private static final ResourceLocation FUEL_TEXTURE =
            ResourceLocation.fromNamespaceAndPath(NecessariesMod.MOD_ID,"textures/gui/end_infuser/fuel_length.png");
    private static final ResourceLocation BUBBLES_TEXTURE =
            ResourceLocation.fromNamespaceAndPath(NecessariesMod.MOD_ID,"textures/gui/end_infuser/bubbles.png");

    public EndInfuserScreen(EndInfuserMenu menu, Inventory playerInventory, Component title) {
        super(menu, playerInventory, title);
    }

    @Override
    protected void renderBg(GuiGraphics guiGraphics, float v, int i, int i1) {
        int x = (width - imageWidth) / 2;
        int y = (height - imageHeight) / 2;

        guiGraphics.blit(RenderType.GUI_TEXTURED, GUI_TEXTURE, x, y, 0, 0, imageWidth, imageHeight, 256, 256);

        renderProgressArrow(guiGraphics, x, y);
        renderFuelBar(guiGraphics, x, y);
        renderBubbles(guiGraphics, x, y);
    }

    private void renderProgressArrow(GuiGraphics guiGraphics, int x, int y) {
        if(menu.isCrafting()) {
            guiGraphics.blit(RenderType.GUI_TEXTURED, ARROW_TEXTURE,x + 76, y + 26, 0, 0, menu.getScaledArrowProgress(), 9, 28, 9);
        }
    }

    private void renderFuelBar(GuiGraphics guiGraphics, int x, int y) {
        guiGraphics.blit(RenderType.GUI_TEXTURED, FUEL_TEXTURE, x + 134, y + 59, 0, 0, menu.getScaledFuelBar(), 4, 18, 4);
    }

    private void renderBubbles(GuiGraphics guiGraphics, int x, int y) {
        if(menu.isCrafting()) {
            int scaledHeight = menu.getScaledBubbleProgress();
            guiGraphics.blit(RenderType.GUI_TEXTURED, BUBBLES_TEXTURE, x + 137, y + 29 + (29 - scaledHeight), 0, 29 - scaledHeight, 12, scaledHeight, 12, 29);
        }
    }

    @Override
    public void render(GuiGraphics pGuiGraphics, int pMouseX, int pMouseY, float pPartialTick) {
        super.render(pGuiGraphics, pMouseX, pMouseY, pPartialTick);
        this.renderTooltip(pGuiGraphics, pMouseX, pMouseY);
    }
}
