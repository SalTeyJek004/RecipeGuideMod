package com.saltay.recipeguide.gui;

import net.minecraft.src.client.gui.GuiSlot;
import net.minecraft.src.client.renderer.Tessellator;
import net.minecraft.src.game.item.ItemStack;
import net.minecraft.src.game.recipe.CraftingManager;
import net.minecraft.src.game.recipe.IRecipe;
import org.lwjgl.opengl.GL11;

public class GuiRecipeGuideSlot extends GuiSlot {
    final GuiRecipeGuide parentGuiRecipeGuide;
    public GuiRecipeGuideSlot(GuiRecipeGuide guiRecipeGuide) {
        super(
            GuiRecipeGuide.getMC(guiRecipeGuide),
            guiRecipeGuide.width,
            guiRecipeGuide.height,
            32,
            guiRecipeGuide.height - 55 + 4,
            36
        );
        this.parentGuiRecipeGuide = guiRecipeGuide;
    }

    @Override
    protected int getSize() {
        return CraftingManager.getInstance().getRecipeList().size();
    }

    @Override
    protected int getContentHeight() {
        return this.getSize() * 36;
    }

    @Override
    protected void elementClicked(int var1, boolean var2) {

    }

    @Override
    protected boolean isSelected(int var1) {
        return false;
    }

    @Override
    protected void drawBackground() {
    }

    @Override
    protected void drawSlot(int index, int var2, int var3, int var4, Tessellator var5) {
        IRecipe recipe = CraftingManager.getInstance().getRecipeList().get(index);
        ItemStack output = recipe.getRecipeOutput();
        GuiRecipeGuide.getIR(parentGuiRecipeGuide).renderItemIntoGUI(
                GuiRecipeGuide.getFR(parentGuiRecipeGuide),GuiRecipeGuide.getMC(parentGuiRecipeGuide).renderEngine,output,var2,var3);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        String itemname = output == null ? "null".concat(String.valueOf(index)) : output.getDisplayName();
        parentGuiRecipeGuide
                .drawString(GuiRecipeGuide.getFR(parentGuiRecipeGuide),
                        itemname, var2 + 32 + 2, var3 + 1, 16777215);
    }

    protected void drawRecipe() {

    }
}
