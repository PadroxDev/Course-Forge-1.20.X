package net.padrox.mccourse.datagen;

import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.ShapedRecipe;
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

        sword(pWriter, ModItems.ALEXANDRITE_SWORD.get(), ModItems.ALEXANDRITE_GEM.get());
        pickaxe(pWriter, ModItems.ALEXANDRITE_PICKAXE.get(), ModItems.ALEXANDRITE_GEM.get());
        axe(pWriter, ModItems.ALEXANDRITE_AXE.get(), ModItems.ALEXANDRITE_GEM.get());
        shovel(pWriter, ModItems.ALEXANDRITE_SHOVEL.get(), ModItems.ALEXANDRITE_GEM.get());
        hoe(pWriter, ModItems.ALEXANDRITE_HOE.get(), ModItems.ALEXANDRITE_GEM.get());
        paxel(pWriter, ModItems.ALEXANDRITE_PAXEL.get(), ModItems.ALEXANDRITE_AXE.get(), ModItems.ALEXANDRITE_SHOVEL.get(),
                ModItems.ALEXANDRITE_PICKAXE.get(), Items.STICK, ModItems.ALEXANDRITE_GEM.get());
        hammer(pWriter, ModItems.ALEXANDRITE_HAMMER.get(), ModItems.ALEXANDRITE_GEM.get());

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

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.HEAVENS_BLADE.get())
                .define('I', Items.BLAZE_ROD)
                .define('F', Items.FEATHER)
                .define('G', ModItems.PURIFIED_ALEXANDRITE_GEM.get())
                .define('A', ModItems.ALEXANDRITE_GEM.get())
                .pattern(" A ")
                .pattern("FGF")
                .pattern(" I ")
                .unlockedBy(getHasName(ModItems.PURIFIED_ALEXANDRITE_GEM.get()), has(ModItems.PURIFIED_ALEXANDRITE_GEM.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModBlocks.ALEXANDRITE_LAMP.get())
                .define('R', Items.REDSTONE)
                .define('A', ModItems.ALEXANDRITE_GEM.get())
                .define('G', Items.GLASS)
                .pattern("GRG")
                .pattern("RAR")
                .pattern("GRG")
                .unlockedBy(getHasName(ModItems.ALEXANDRITE_GEM.get()), has(ModItems.ALEXANDRITE_GEM.get()))
                .save(pWriter);
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

    protected static void sword(Consumer<FinishedRecipe> pFinishedRecipeConsumer, ItemLike pSword, ItemLike pMaterial) {
        swordBuilder(pSword, Ingredient.of(pMaterial)).unlockedBy(getHasName(pMaterial), has(pMaterial)).save(pFinishedRecipeConsumer);
    }

    protected static RecipeBuilder swordBuilder(ItemLike pSword, Ingredient pMaterial) {
        return ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, pSword).define('#', pMaterial).define('I', Items.STICK)
                .pattern(" # ")
                .pattern(" # ")
                .pattern(" I ");
    }

    protected static void pickaxe(Consumer<FinishedRecipe> pFinishedRecipeConsumer, ItemLike pPickaxe, ItemLike pMaterial) {
        pickaxeBuilder(pPickaxe, Ingredient.of(pMaterial)).unlockedBy(getHasName(pMaterial), has(pMaterial)).save(pFinishedRecipeConsumer);
    }

    protected static RecipeBuilder pickaxeBuilder(ItemLike pPickaxe, Ingredient pMaterial) {
        return ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, pPickaxe).define('#', pMaterial).define('I', Items.STICK)
                .pattern("###")
                .pattern(" I ")
                .pattern(" I ");
    }

    protected static void axe(Consumer<FinishedRecipe> pFinishedRecipeConsumer, ItemLike pAxe, ItemLike pMaterial) {
        axeBuilder(pAxe, Ingredient.of(pMaterial)).unlockedBy(getHasName(pMaterial), has(pMaterial)).save(pFinishedRecipeConsumer);
    }

    protected static RecipeBuilder axeBuilder(ItemLike pAxe, Ingredient pMaterial) {
        return ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, pAxe).define('#', pMaterial).define('I', Items.STICK)
                .pattern(" ##")
                .pattern(" I#")
                .pattern(" I ");
    }

    protected static void shovel(Consumer<FinishedRecipe> pFinishedRecipeConsumer, ItemLike pShovel, ItemLike pMaterial) {
        shovelBuilder(pShovel, Ingredient.of(pMaterial)).unlockedBy(getHasName(pMaterial), has(pMaterial)).save(pFinishedRecipeConsumer);
    }
    protected static RecipeBuilder shovelBuilder(ItemLike pShovel, Ingredient pMaterial) {
        return ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, pShovel).define('#', pMaterial).define('I', Items.STICK)
                .pattern(" # ")
                .pattern(" I ")
                .pattern(" I ");
    }

    protected static void hoe(Consumer<FinishedRecipe> pFinishedRecipeConsumer, ItemLike pHoe, ItemLike pMaterial) {
        hoeBuilder(pHoe, Ingredient.of(pMaterial)).unlockedBy(getHasName(pMaterial), has(pMaterial)).save(pFinishedRecipeConsumer);
    }

    protected static RecipeBuilder hoeBuilder(ItemLike pHoe, Ingredient pMaterial) {
        return ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, pHoe).define('#', pMaterial).define('I', Items.STICK)
                .pattern(" ##")
                .pattern(" I ")
                .pattern(" I ");
    }

    protected static void paxel(Consumer<FinishedRecipe> pFinishedRecipeConsumer, ItemLike pPaxel, ItemLike pAxeComponent, ItemLike pShovelComponent, ItemLike pPickaxeComponent, ItemLike pBase, ItemLike pMaterial) {
        paxelBuilder(pPaxel, pAxeComponent, pShovelComponent, pPickaxeComponent, pBase).unlockedBy(getHasName(pMaterial), has(pMaterial)).save(pFinishedRecipeConsumer);
    }

    protected static RecipeBuilder paxelBuilder(ItemLike pPaxel, ItemLike pAxeComponent, ItemLike pShovelComponent, ItemLike pPickaxeComponent, ItemLike pBase) {
        return ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, pPaxel)
                .define('I', pBase)
                .define('A', pAxeComponent)
                .define('S', pShovelComponent)
                .define('P', pPickaxeComponent)
                .pattern("ASP")
                .pattern(" I ")
                .pattern(" I ");
    }

    protected static void hammer(Consumer<FinishedRecipe> pFinishedRecipeConsumer, ItemLike pHammer, ItemLike pMaterial) {
        hammerBuilder(pHammer, Ingredient.of(pMaterial)).unlockedBy(getHasName(pMaterial), has(pMaterial)).save(pFinishedRecipeConsumer);
    }

    protected static RecipeBuilder hammerBuilder(ItemLike pHammer, Ingredient pMaterial) {
        return ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, pHammer).define('#', pMaterial).define('I', Items.STICK)
                .pattern("###")
                .pattern("###")
                .pattern(" I ");
    }
}
