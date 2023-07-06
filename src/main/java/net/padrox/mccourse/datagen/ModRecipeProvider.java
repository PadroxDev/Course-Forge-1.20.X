package net.padrox.mccourse.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import net.padrox.mccourse.MCCourseMod;
import net.padrox.mccourse.block.ModBlocks;
import net.padrox.mccourse.item.ModItems;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public static final List<ItemLike> ALEXANDRITE_SMELTABLES = List.of(ModItems.RAW_ALEXANDRITE.get(),
            ModBlocks.ALEXANDRITE_ORE.get(), ModBlocks.DEEPSLATE_ALEXANDRITE_ORE.get(),
            ModBlocks.NETHER_ALEXANDRITE_ORE.get(), ModBlocks.END_ALEXANDRITE_ORE.get());

    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> pWriter) {
        nineBlockStorageRecipes(pWriter, RecipeCategory.MISC, ModItems.RAW_ALEXANDRITE.get(), RecipeCategory.MISC, ModBlocks.RAW_ALEXANDRITE_BLOCK.get(),
                "mccourse:raw_alexandrite", "alexandrite", "mccourse:raw_alexandrite_block", "alexandrite");
        nineBlockStorageRecipes(pWriter, RecipeCategory.MISC, ModItems.ALEXANDRITE_GEM.get(), RecipeCategory.MISC, ModBlocks.ALEXANDRITE_BLOCK.get(),
                "mccourse:alexandrite_gem", "alexandrite", "mccourse:alexandrite_block", "alexandrite");
        oreSmelting(pWriter, ALEXANDRITE_SMELTABLES, RecipeCategory.MISC, ModItems.ALEXANDRITE_GEM.get(), 0.25f, 200, "alexandrite");
        oreBlasting(pWriter, ALEXANDRITE_SMELTABLES, RecipeCategory.MISC, ModItems.ALEXANDRITE_GEM.get(), 0.25f, 100, "alexandrite");

        stairs(pWriter, ModBlocks.RAW_ALEXANDRITE_STAIRS.get(), ModItems.RAW_ALEXANDRITE.get());
        slab(pWriter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.RAW_ALEXANDRITE_SLAB.get(), ModItems.RAW_ALEXANDRITE.get());
        stairs(pWriter, ModBlocks.ALEXANDRITE_STAIRS.get(), ModItems.ALEXANDRITE_GEM.get());
        slab(pWriter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.ALEXANDRITE_SLAB.get(), ModItems.ALEXANDRITE_GEM.get());

        pressurePlate(pWriter, ModBlocks.RAW_ALEXANDRITE_PRESSURE_PLATE.get(), ModItems.RAW_ALEXANDRITE.get());
        button(pWriter, ModBlocks.RAW_ALEXANDRITE_BUTTON.get(), ModItems.RAW_ALEXANDRITE.get());
        pressurePlate(pWriter, ModBlocks.ALEXANDRITE_PRESSURE_PLATE.get(), ModItems.ALEXANDRITE_GEM.get());
        button(pWriter, ModBlocks.ALEXANDRITE_BUTTON.get(), ModItems.ALEXANDRITE_GEM.get());

        fence(pWriter, ModBlocks.RAW_ALEXANDRITE_FENCE.get(), ModItems.RAW_ALEXANDRITE.get());
        fenceGate(pWriter, ModBlocks.RAW_ALEXANDRITE_FENCE_GATE.get(), ModItems.RAW_ALEXANDRITE.get());
        wall(pWriter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.RAW_ALEXANDRITE_WALL.get(), ModItems.RAW_ALEXANDRITE.get());
        fence(pWriter, ModBlocks.ALEXANDRITE_FENCE.get(), ModItems.ALEXANDRITE_GEM.get());
        fenceGate(pWriter, ModBlocks.ALEXANDRITE_FENCE_GATE.get(), ModItems.ALEXANDRITE_GEM.get());
        wall(pWriter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.ALEXANDRITE_WALL.get(), ModItems.ALEXANDRITE_GEM.get());

        door(pWriter, ModBlocks.RAW_ALEXANDRITE_DOOR.get(), ModItems.RAW_ALEXANDRITE.get());
        trapdoor(pWriter, ModBlocks.RAW_ALEXANDRITE_TRAPDOOR.get(), ModItems.RAW_ALEXANDRITE.get());
        door(pWriter, ModBlocks.ALEXANDRITE_DOOR.get(), ModItems.ALEXANDRITE_GEM.get());
        trapdoor(pWriter, ModBlocks.ALEXANDRITE_TRAPDOOR.get(), ModItems.ALEXANDRITE_GEM.get());
    }

    protected static void oreSmelting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.SMELTING_RECIPE, pIngredients, pCategory, pResult,
                pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTime, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.BLASTING_RECIPE, pIngredients, pCategory, pResult,
                pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static void oreCooking(Consumer<FinishedRecipe> pFinishedRecipeConsumer, RecipeSerializer<? extends AbstractCookingRecipe> pCookingSerializer,
                                     List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        for(ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult, pExperience, pCookingTime,
                    pCookingSerializer).group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(pFinishedRecipeConsumer, MCCourseMod.MOD_ID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }
    }

    protected static void stairs(Consumer<FinishedRecipe> pFinishedRecipeConsumer, ItemLike pStairs, ItemLike pMaterial) {
        stairBuilder(pStairs, Ingredient.of(pMaterial)).unlockedBy(getHasName(pMaterial), has(pMaterial)).save(pFinishedRecipeConsumer);
    }

    protected static void slab(Consumer<FinishedRecipe> pFinishedRecipeConsumer, RecipeCategory pCategory, ItemLike pSlab, ItemLike pMaterial) {
        slabBuilder(pCategory, pSlab, Ingredient.of(pMaterial)).unlockedBy(getHasName(pMaterial), has(pMaterial)).save(pFinishedRecipeConsumer);
    }

    protected static void button(Consumer<FinishedRecipe> pFinishedRecipeConsumer, ItemLike pButton, ItemLike pMaterial) {
        buttonBuilder(pButton, Ingredient.of(pMaterial)).unlockedBy(getHasName(pMaterial), has(pMaterial)).save(pFinishedRecipeConsumer);
    }

    protected static void fence(Consumer<FinishedRecipe> pFinishedRecipeConsumer, ItemLike pFence, ItemLike pMaterial) {
        fenceBuilder(pFence, Ingredient.of(pMaterial)).unlockedBy(getHasName(pMaterial), has(pMaterial)).save(pFinishedRecipeConsumer);
    }

    protected static void fenceGate(Consumer<FinishedRecipe> pFinishedRecipeConsumer, ItemLike pFenceGate, ItemLike pMaterial) {
        fenceGateBuilder(pFenceGate, Ingredient.of(pMaterial)).unlockedBy(getHasName(pMaterial), has(pMaterial)).save(pFinishedRecipeConsumer);
    }

    protected static void door(Consumer<FinishedRecipe> pFinishedRecipeConsumer, ItemLike pDoor, ItemLike pMaterial) {
        doorBuilder(pDoor, Ingredient.of(pMaterial)).unlockedBy(getHasName(pMaterial), has(pMaterial)).save(pFinishedRecipeConsumer);
    }

    protected static void trapdoor(Consumer<FinishedRecipe> pFinishedRecipeConsumer, ItemLike pTrapdoor, ItemLike pMaterial) {
        ironTrapdoorBuilder(pTrapdoor, Ingredient.of(pMaterial)).unlockedBy(getHasName(pMaterial), has(pMaterial)).save(pFinishedRecipeConsumer);
    }

    protected static RecipeBuilder ironTrapdoorBuilder(ItemLike pTrapdoor, Ingredient pMaterial) {
        return ShapedRecipeBuilder.shaped(RecipeCategory.REDSTONE, pTrapdoor).define('#', pMaterial).pattern("##").pattern("##");
    }
}
