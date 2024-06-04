package com.saltay.recipeguide.mixins;

import com.saltay.recipeguide.gui.GuiRecipeGuide;
import net.minecraft.src.client.gui.*;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(GuiIngameMenu.class)
public class MixinGuiIngameMenu extends GuiScreen {

    @Inject(method = "initGui", at = @At("TAIL"))
    public void initGuiMIXIN(CallbackInfo ci) {
        this.controlList
                .add(
                        new GuiButton(
                                8, this.width / 2 - 44, this.height / 4 + 72 - 16, 88, 20,
                                StringTranslate.getInstance().translateKey("inGameMenu.recipeGuide")
                        )
                );
    }

    @Inject(method = "actionPerformed", at = @At("TAIL"))
    protected void actionPreformedMIXIN(GuiButton button, CallbackInfo ci) {
        if (button.id == 8) {
            this.mc.displayGuiScreen(new GuiRecipeGuide());
        }
    }
}
