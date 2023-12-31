package net.padrox.mccourse.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.padrox.mccourse.MCCourseMod;
import net.padrox.mccourse.block.ModBlocks;
import net.padrox.mccourse.item.ModToolTiers;
import net.padrox.mccourse.util.ModTags;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider {
    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider,
                                @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, MCCourseMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        this.tag(ModTags.Blocks.METAL_DETECTOR_VALUABLES)
                .add(
                        ModBlocks.ALEXANDRITE_ORE.get(),
                        ModBlocks.DEEPSLATE_ALEXANDRITE_ORE.get(),
                        ModBlocks.NETHER_ALEXANDRITE_ORE.get(),
                        ModBlocks.END_ALEXANDRITE_ORE.get(),
                        Blocks.ANCIENT_DEBRIS,
                        Blocks.DIAMOND_ORE,
                        Blocks.DEEPSLATE_DIAMOND_ORE,
                        Blocks.EMERALD_ORE,
                        Blocks.DEEPSLATE_EMERALD_ORE,
                        Blocks.IRON_ORE,
                        Blocks.DEEPSLATE_IRON_ORE,
                        Blocks.REDSTONE_ORE,
                        Blocks.DEEPSLATE_REDSTONE_ORE,
                        Blocks.GOLD_ORE,
                        Blocks.DEEPSLATE_GOLD_ORE,
                        Blocks.LAPIS_ORE,
                        Blocks.DEEPSLATE_LAPIS_ORE,
                        Blocks.COAL_ORE,
                        Blocks.DEEPSLATE_COAL_ORE,
                        Blocks.COPPER_ORE,
                        Blocks.DEEPSLATE_COPPER_ORE,
                        Blocks.NETHER_QUARTZ_ORE,
                        Blocks.NETHER_GOLD_ORE
                ).addTag(Tags.Blocks.ORES);

        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(
                        ModBlocks.RAW_ALEXANDRITE_BLOCK.get(),
                        ModBlocks.ALEXANDRITE_BLOCK.get(),
                        ModBlocks.ALEXANDRITE_ORE.get(),
                        ModBlocks.DEEPSLATE_ALEXANDRITE_ORE.get(),
                        ModBlocks.NETHER_ALEXANDRITE_ORE.get(),
                        ModBlocks.END_ALEXANDRITE_ORE.get(),
                        ModBlocks.SOUND_BLOCK.get(),
                        ModBlocks.RAW_ALEXANDRITE_STAIRS.get(),
                        ModBlocks.RAW_ALEXANDRITE_SLAB.get(),
                        ModBlocks.ALEXANDRITE_STAIRS.get(),
                        ModBlocks.ALEXANDRITE_SLAB.get(),
                        ModBlocks.RAW_ALEXANDRITE_PRESSURE_PLATE.get(),
                        ModBlocks.RAW_ALEXANDRITE_BUTTON.get(),
                        ModBlocks.ALEXANDRITE_PRESSURE_PLATE.get(),
                        ModBlocks.ALEXANDRITE_BUTTON.get(),
                        ModBlocks.RAW_ALEXANDRITE_FENCE.get(),
                        ModBlocks.RAW_ALEXANDRITE_FENCE_GATE.get(),
                        ModBlocks.RAW_ALEXANDRITE_WALL.get(),
                        ModBlocks.ALEXANDRITE_FENCE.get(),
                        ModBlocks.ALEXANDRITE_FENCE_GATE.get(),
                        ModBlocks.ALEXANDRITE_WALL.get()
                );

        this.tag(BlockTags.NEEDS_IRON_TOOL)
                .add(
                        ModBlocks.RAW_ALEXANDRITE_BLOCK.get(),
                        ModBlocks.ALEXANDRITE_BLOCK.get(),
                        ModBlocks.ALEXANDRITE_ORE.get(),
                        ModBlocks.DEEPSLATE_ALEXANDRITE_ORE.get(),
                        ModBlocks.SOUND_BLOCK.get(),
                        ModBlocks.RAW_ALEXANDRITE_STAIRS.get(),
                        ModBlocks.RAW_ALEXANDRITE_SLAB.get(),
                        ModBlocks.ALEXANDRITE_STAIRS.get(),
                        ModBlocks.ALEXANDRITE_SLAB.get(),
                        ModBlocks.RAW_ALEXANDRITE_PRESSURE_PLATE.get(),
                        ModBlocks.RAW_ALEXANDRITE_BUTTON.get(),
                        ModBlocks.ALEXANDRITE_PRESSURE_PLATE.get(),
                        ModBlocks.ALEXANDRITE_BUTTON.get(),
                        ModBlocks.RAW_ALEXANDRITE_FENCE.get(),
                        ModBlocks.RAW_ALEXANDRITE_FENCE_GATE.get(),
                        ModBlocks.RAW_ALEXANDRITE_WALL.get(),
                        ModBlocks.ALEXANDRITE_FENCE.get(),
                        ModBlocks.ALEXANDRITE_FENCE_GATE.get(),
                        ModBlocks.ALEXANDRITE_WALL.get()
                );

        this.tag(ModTags.Blocks.NEEDS_ALEXANDRITE_TOOL)
                .add(
                        ModBlocks.NETHER_ALEXANDRITE_ORE.get(),
                        ModBlocks.END_ALEXANDRITE_ORE.get()
                );

        this.tag(BlockTags.FENCES)
                .add(
                        ModBlocks.RAW_ALEXANDRITE_FENCE.get(),
                        ModBlocks.ALEXANDRITE_FENCE.get()
                );

        this.tag(ModTags.Blocks.PAXEL_MINEABLE)
                .addTag(BlockTags.MINEABLE_WITH_PICKAXE)
                .addTag(BlockTags.MINEABLE_WITH_AXE)
                .addTag(BlockTags.MINEABLE_WITH_SHOVEL);

        this.tag(BlockTags.FENCE_GATES)
                .add(
                        ModBlocks.RAW_ALEXANDRITE_FENCE_GATE.get(),
                        ModBlocks.ALEXANDRITE_FENCE_GATE.get()
                );

        this.tag(BlockTags.WALLS)
                .add(
                        ModBlocks.RAW_ALEXANDRITE_WALL.get(),
                        ModBlocks.ALEXANDRITE_WALL.get()
                );
    }

    @Override
    public String getName() {
        return "Block Tags";
    }
}
