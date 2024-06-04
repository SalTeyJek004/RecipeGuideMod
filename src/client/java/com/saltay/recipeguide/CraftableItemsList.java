package com.saltay.recipeguide;

import net.minecraft.src.game.recipe.CraftingManager;
import net.minecraft.src.game.recipe.IRecipe;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CraftableItemsList {
    List<IRecipe> unsortedRecipes;
    List<Object> sortedRecipes = new ArrayList<Object>();

    public CraftableItemsList() {
        unsortedRecipes = CraftingManager.getInstance().getRecipeList();
        Iterator<IRecipe> iterator = unsortedRecipes.listIterator();
    }


}
