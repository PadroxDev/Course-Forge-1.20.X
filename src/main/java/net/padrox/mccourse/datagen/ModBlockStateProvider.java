package net.padrox.mccourse.datagen;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.registries.ForgeRegistries;
import net.padrox.mccourse.MCCourseMod;
import net.padrox.mccourse.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import net.padrox.mccourse.block.custom.AlexandriteLampBlock;
import net.padrox.mccourse.block.custom.KohlrabiCropBlock;

import java.util.function.Function;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, MCCourseMod.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.ALEXANDRITE_BLOCK);
        blockWithItem(ModBlocks.RAW_ALEXANDRITE_BLOCK);

        blockWithItem(ModBlocks.ALEXANDRITE_ORE);
        blockWithItem(ModBlocks.DEEPSLATE_ALEXANDRITE_ORE);
        blockWithItem(ModBlocks.END_ALEXANDRITE_ORE);
        blockWithItem(ModBlocks.NETHER_ALEXANDRITE_ORE);

        blockWithItem(ModBlocks.SOUND_BLOCK);

        stairsBlock((StairBlock) ModBlocks.RAW_ALEXANDRITE_STAIRS.get(), blockTexture(ModBlocks.RAW_ALEXANDRITE_BLOCK.get()));
        slabBlock(((SlabBlock) ModBlocks.RAW_ALEXANDRITE_SLAB.get()), blockTexture(ModBlocks.RAW_ALEXANDRITE_BLOCK.get()), blockTexture(ModBlocks.RAW_ALEXANDRITE_BLOCK.get()));
        stairsBlock((StairBlock) ModBlocks.ALEXANDRITE_STAIRS.get(), blockTexture(ModBlocks.ALEXANDRITE_BLOCK.get()));
        slabBlock(((SlabBlock) ModBlocks.ALEXANDRITE_SLAB.get()), blockTexture(ModBlocks.ALEXANDRITE_BLOCK.get()), blockTexture(ModBlocks.ALEXANDRITE_BLOCK.get()));

        pressurePlateBlock((PressurePlateBlock) ModBlocks.RAW_ALEXANDRITE_PRESSURE_PLATE.get(), blockTexture(ModBlocks.RAW_ALEXANDRITE_BLOCK.get()));
        buttonBlock((ButtonBlock) ModBlocks.RAW_ALEXANDRITE_BUTTON.get(), blockTexture(ModBlocks.RAW_ALEXANDRITE_BLOCK.get()));
        pressurePlateBlock((PressurePlateBlock) ModBlocks.ALEXANDRITE_PRESSURE_PLATE.get(), blockTexture(ModBlocks.ALEXANDRITE_BLOCK.get()));
        buttonBlock((ButtonBlock) ModBlocks.ALEXANDRITE_BUTTON.get(), blockTexture(ModBlocks.ALEXANDRITE_BLOCK.get()));

        fenceBlock((FenceBlock) ModBlocks.RAW_ALEXANDRITE_FENCE.get(), blockTexture(ModBlocks.RAW_ALEXANDRITE_BLOCK.get()));
        fenceGateBlock((FenceGateBlock) ModBlocks.RAW_ALEXANDRITE_FENCE_GATE.get(), blockTexture(ModBlocks.RAW_ALEXANDRITE_BLOCK.get()));
        wallBlock((WallBlock) ModBlocks.RAW_ALEXANDRITE_WALL.get(), blockTexture(ModBlocks.RAW_ALEXANDRITE_BLOCK.get()));
        fenceBlock((FenceBlock) ModBlocks.ALEXANDRITE_FENCE.get(), blockTexture(ModBlocks.ALEXANDRITE_BLOCK.get()));
        fenceGateBlock((FenceGateBlock) ModBlocks.ALEXANDRITE_FENCE_GATE.get(), blockTexture(ModBlocks.ALEXANDRITE_BLOCK.get()));
        wallBlock((WallBlock) ModBlocks.ALEXANDRITE_WALL.get(), blockTexture(ModBlocks.ALEXANDRITE_BLOCK.get()));

        doorBlockWithRenderType((DoorBlock) ModBlocks.RAW_ALEXANDRITE_DOOR.get(), modLoc("block/raw_alexandrite_door_bottom"), modLoc("block/raw_alexandrite_door_top"), "cutout");
        doorBlockWithRenderType((DoorBlock) ModBlocks.ALEXANDRITE_DOOR.get(), modLoc("block/alexandrite_door_bottom"), modLoc("block/alexandrite_door_top"), "cutout");
        trapdoorBlockWithRenderType((TrapDoorBlock) ModBlocks.RAW_ALEXANDRITE_TRAPDOOR.get(), modLoc("block/raw_alexandrite_trapdoor"), true, "cutout");
        trapdoorBlockWithRenderType((TrapDoorBlock) ModBlocks.ALEXANDRITE_TRAPDOOR.get(), modLoc("block/alexandrite_trapdoor"), true, "cutout");

        blockItem(ModBlocks.RAW_ALEXANDRITE_STAIRS);
        blockItem(ModBlocks.RAW_ALEXANDRITE_SLAB);
        blockItem(ModBlocks.ALEXANDRITE_STAIRS);
        blockItem(ModBlocks.ALEXANDRITE_SLAB);

        blockItem(ModBlocks.RAW_ALEXANDRITE_PRESSURE_PLATE);
        blockItem(ModBlocks.ALEXANDRITE_PRESSURE_PLATE);

        blockItem(ModBlocks.RAW_ALEXANDRITE_FENCE_GATE);
        blockItem(ModBlocks.ALEXANDRITE_FENCE_GATE);

        blockItem(ModBlocks.RAW_ALEXANDRITE_TRAPDOOR, "_bottom");
        blockItem(ModBlocks.ALEXANDRITE_TRAPDOOR, "_bottom");

        customLamp(ModBlocks.ALEXANDRITE_LAMP.get(), AlexandriteLampBlock.CLICKED, "alexandrite_lamp");

        makeCrop(((KohlrabiCropBlock) ModBlocks.KOHLRABI_CROP.get()), "kohlrabi_stage", "kohlrabi_stage");
    }

    public void makeCrop(CropBlock block, String modelName, String textureName) {
        Function<BlockState, ConfiguredModel[]> function = state -> states(state, block, modelName, textureName);

        getVariantBuilder(block).forAllStates(function);
    }

    private ConfiguredModel[] states(BlockState state, CropBlock block, String modelName, String textureName) {
        ConfiguredModel[] models = new ConfiguredModel[1];
        models[0] = new ConfiguredModel(models().crop(modelName + state.getValue(((KohlrabiCropBlock) block).getAgeProperty()),
                new ResourceLocation(MCCourseMod.MOD_ID, "block/" + textureName + state.getValue(((KohlrabiCropBlock) block).getAgeProperty()))).renderType("cutout"));

        return models;
    }

    private void blockItem(RegistryObject<Block> blockRegistryObject, String appendix) {
        simpleBlockItem(blockRegistryObject.get(), new ModelFile.UncheckedModelFile("mccourse:block/" + ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath() + appendix));
    }

    private void blockItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockItem(blockRegistryObject.get(), new ModelFile.UncheckedModelFile("mccourse:block/" + ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath()));
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }

    private void customLamp(Block lamp, BooleanProperty property, String lampName) {
        getVariantBuilder(lamp).forAllStates(state -> {
            if(state.getValue(property)) {

                return new ConfiguredModel[]{new ConfiguredModel(models().cubeAll(lampName + "_on",
                        new ResourceLocation(MCCourseMod.MOD_ID, "block/" + lampName + "_on")))};
            } else {
                return new ConfiguredModel[]{new ConfiguredModel(models().cubeAll(lampName + "_off",
                        new ResourceLocation(MCCourseMod.MOD_ID, "block/" + lampName + "_off")))};
            }
        });
        simpleBlockItem(lamp, models().cubeAll(lampName + "_on",
                new ResourceLocation(MCCourseMod.MOD_ID, "block/" + lampName + "_off")));
    }
}