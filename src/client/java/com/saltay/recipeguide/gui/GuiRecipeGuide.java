package com.saltay.recipeguide.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.src.client.gui.FontRenderer;
import net.minecraft.src.client.gui.GuiButton;
import net.minecraft.src.client.gui.GuiScreen;
import net.minecraft.src.client.gui.StringTranslate;
import net.minecraft.src.client.renderer.entity.RenderItem;

public class GuiRecipeGuide extends GuiScreen {

    private final RenderItem itemRenderer = new RenderItem();
    private GuiRecipeGuideSlot guiRecipeGuideSlot;

    @Override
    public void initGui() {
        this.controlList.clear();
        StringTranslate st = StringTranslate.getInstance();
        this.controlList.add(new GuiButton(0, 48, this.height - 24, 88, 20, st.translateKey("gui.cancel")));
        this.guiRecipeGuideSlot = new GuiRecipeGuideSlot(this);
        this.guiRecipeGuideSlot.registerScrollButtons(this.controlList, 7, 8);
    }

    @Override
    protected void actionPerformed(GuiButton button) {
        if (button.id == 0) {

        } else {
            this.guiRecipeGuideSlot.actionPerformed(button);
        }
    }

    @Override
    public void drawScreen(int arg1, int arg2, float deltaTicks) {
        this.guiRecipeGuideSlot.drawScreen(arg1, arg2, deltaTicks);
        super.drawScreen(arg1, arg2, deltaTicks);
    }

    static Minecraft getMC(GuiRecipeGuide guiRecipeGuide) {
        return guiRecipeGuide.mc;
    }
    static FontRenderer getFR(GuiRecipeGuide guiRecipeGuide) {
        return guiRecipeGuide.fontRenderer;
    }
    static RenderItem getIR(GuiRecipeGuide guiRecipeGuide) {
        return guiRecipeGuide.itemRenderer;
    }

}
