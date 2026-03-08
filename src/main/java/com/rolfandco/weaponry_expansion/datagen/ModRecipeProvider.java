package com.rolfandco.weaponry_expansion.datagen;

import com.rolfandco.weaponry_expansion.item.ModItems;
import com.rolfandco.weaponry_expansion.item.jade.JadeTools;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.List;
import java.util.function.Consumer;

import static com.rolfandco.weaponry_expansion.WeaponryExpansion.MODID;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput output) {
        super(output);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> finishedRecipeConsumer) {
        toolBuilder("Sword", RecipeCategory.COMBAT, JadeTools.JADE_SWORD.get(), ModItems.CUT_JADE.get(), finishedRecipeConsumer);
        toolBuilder("Pickaxe", RecipeCategory.TOOLS, JadeTools.JADE_PICKAXE.get(), ModItems.CUT_JADE.get(), finishedRecipeConsumer);
        toolBuilder("Axe", RecipeCategory.TOOLS, JadeTools.JADE_AXE.get(), ModItems.CUT_JADE.get(), finishedRecipeConsumer);
        toolBuilder("Shovel", RecipeCategory.TOOLS, JadeTools.JADE_SHOVEL.get(), ModItems.CUT_JADE.get(), finishedRecipeConsumer);
        toolBuilder("Hoe", RecipeCategory.TOOLS, JadeTools.JADE_HOE.get(), ModItems.CUT_JADE.get(), finishedRecipeConsumer);
    }


    protected static void oreSmelting(Consumer<FinishedRecipe> p_250654_, List<ItemLike> p_250172_, RecipeCategory p_250588_, ItemLike p_251868_, float p_250789_, int p_252144_, String p_251687_) {
        oreCooking(p_250654_, RecipeSerializer.SMELTING_RECIPE, p_250172_, p_250588_, p_251868_, p_250789_, p_252144_, p_251687_, "_from_smelting");
    }

    protected static void oreBlasting(Consumer<FinishedRecipe> p_248775_, List<ItemLike> p_251504_, RecipeCategory p_248846_, ItemLike p_249735_, float p_248783_, int p_250303_, String p_251984_) {
        oreCooking(p_248775_, RecipeSerializer.BLASTING_RECIPE, p_251504_, p_248846_, p_249735_, p_248783_, p_250303_, p_251984_, "_from_blasting");
    }

    protected static void oreCooking(Consumer<FinishedRecipe> p_250791_, RecipeSerializer<? extends AbstractCookingRecipe> p_251817_, List<ItemLike> p_249619_, RecipeCategory p_251154_, ItemLike p_250066_, float p_251871_, int p_251316_, String p_251450_, String p_249236_) {
        for(ItemLike itemlike : p_249619_) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), p_251154_, p_250066_, p_251871_, p_251316_, p_251817_).group(p_251450_).unlockedBy(getHasName(itemlike), has(itemlike)).save(p_250791_, MODID + ":" + getItemName(p_250066_) + p_249236_ + "_" + getItemName(itemlike));
        }} // Must be added so .save() can have MODID + ":", since namespace is hardcoded fsr

    protected static void toolBuilder(String type, RecipeCategory category,
                                      ItemLike output, ItemLike material,
                                      Consumer<FinishedRecipe> finishedRecipeConsumer) {
        String baseName = getItemName(output);

        if (type.equals("Sword")) {
            ShapedRecipeBuilder.shaped(category, output)
                    .pattern("J")
                    .pattern("J")
                    .pattern("S")
                    .define('J', material)
                    .define('S', Items.STICK)
                    .unlockedBy(getHasName(material), has(material))
                    .save(finishedRecipeConsumer, MODID + ":" + baseName + "_from_" + getItemName(material));
        }

        if (type.equals("Pickaxe")) {
            ShapedRecipeBuilder.shaped(category, output)
                    .pattern("JJJ")
                    .pattern(" S ")
                    .pattern(" S ")
                    .define('J', material)
                    .define('S', Items.STICK)
                    .unlockedBy(getHasName(material), has(material))
                    .save(finishedRecipeConsumer, MODID + ":" + baseName + "_from_" + getItemName(material));
        }

        if (type.equals("Axe")) {
            ShapedRecipeBuilder.shaped(category, output)
                    .pattern("JJ")
                    .pattern("JS")
                    .pattern(" S")
                    .define('J', material)
                    .define('S', Items.STICK)
                    .unlockedBy(getHasName(material), has(material))
                    .save(finishedRecipeConsumer, MODID + ":" + baseName + "_from_" + getItemName(material) + "_right");

            ShapedRecipeBuilder.shaped(category, output)
                    .pattern("JJ")
                    .pattern("SJ")
                    .pattern("S ")
                    .define('J', material)
                    .define('S', Items.STICK)
                    .unlockedBy(getHasName(material), has(material))
                    .save(finishedRecipeConsumer, MODID + ":" + baseName + "_from_" + getItemName(material) + "_left");
        }

        if (type.equals("Hoe")) {
            ShapedRecipeBuilder.shaped(category, output)
                    .pattern("JJ")
                    .pattern(" S")
                    .pattern(" S")
                    .define('J', material)
                    .define('S', Items.STICK)
                    .unlockedBy(getHasName(material), has(material))
                    .save(finishedRecipeConsumer, MODID + ":" + baseName + "_from_" + getItemName(material) + "_right");

            ShapedRecipeBuilder.shaped(category, output)
                    .pattern("JJ")
                    .pattern("S ")
                    .pattern("S ")
                    .define('J', material)
                    .define('S', Items.STICK)
                    .unlockedBy(getHasName(material), has(material))
                    .save(finishedRecipeConsumer, MODID + ":" + baseName + "_from_" + getItemName(material) + "_left");
        }

        if (type.equals("Shovel")) {
            ShapedRecipeBuilder.shaped(category, output)
                    .pattern("J")
                    .pattern("S")
                    .pattern("S")
                    .define('J', material)
                    .define('S', Items.STICK)
                    .unlockedBy(getHasName(material), has(material))
                    .save(finishedRecipeConsumer, MODID + ":" + baseName + "_from_" + getItemName(material));
        }
    }

}

