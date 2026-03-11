package com.rolfandco.weaponry_expansion.screen;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;

import static com.rolfandco.weaponry_expansion.WeaponryExpansion.MODID;

public class T1ModuleTableScreen extends AbstractContainerScreen<T1ModuleTableMenu> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(MODID, "textures/gui/t1_module_table_gui.png");

    public T1ModuleTableScreen(AbstractContainerMenu menu, Inventory inventory, Component title) {
        super((T1ModuleTableMenu) menu, inventory, title);
        this.titleLabelX = 8;      // defaultish
        this.titleLabelY = 6;
        this.inventoryLabelX = 8;
        this.inventoryLabelY = this.imageHeight - 94; // typical offset
    }

    @Override
    protected void renderBg(GuiGraphics guiGraphics, float partialTick, int mouseX, int mouseY) {
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1f, 1f, 1f, 1f);
        RenderSystem.setShaderTexture(0, TEXTURE);

        // Use leftPos/topPos supplied by AbstractContainerScreen
        guiGraphics.blit(TEXTURE, leftPos, topPos, 0, 0, imageWidth, imageHeight); // assumes gui is 176 * 166
    }
        /* draw texture (Blit)
        Draw(Texture, starting position x, starting position y, x offset to start drawing, y offset to start drawing, width to draw, height to draw)
        Lets you draw partial textures for things by starting at different offsets or heights/widths
        */

    @Override
    protected void init() {
        super.init();
        /* how to change label positions
        this.inventoryLabelX = int;
        this.titleLabelY = int;
         */
    }

    @Override
    public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float delta) {
        this.renderBackground(guiGraphics);
        super.render(guiGraphics, mouseX, mouseY, delta);
    }
}
