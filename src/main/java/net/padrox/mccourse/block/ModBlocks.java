package net.padrox.mccourse.block;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.padrox.mccourse.MCCourseMod;
import net.padrox.mccourse.block.custom.AlexandriteLampBlock;
import net.padrox.mccourse.block.custom.SoundBlock;
import net.padrox.mccourse.item.ModItems;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, MCCourseMod.MOD_ID);

    public static final RegistryObject<Block> RAW_ALEXANDRITE_BLOCK = registerBlock("raw_alexandrite_block",
            () -> new Block((BlockBehaviour.Properties.copy(Blocks.EMERALD_BLOCK))));
    public static final RegistryObject<Block> ALEXANDRITE_BLOCK = registerBlock("alexandrite_block",
            () -> new Block((BlockBehaviour.Properties.copy(Blocks.EMERALD_BLOCK))));

    public static final RegistryObject<Block> ALEXANDRITE_ORE = registerBlock("alexandrite_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.STONE)
                    .strength(3.0f, 3.0f).requiresCorrectToolForDrops(), UniformInt.of(4, 8)));
    public static final RegistryObject<Block> DEEPSLATE_ALEXANDRITE_ORE = registerBlock("deepslate_alexandrite_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE)
                    .strength(4.5f, 3.0f).requiresCorrectToolForDrops(), UniformInt.of(4, 8)));
    public static final RegistryObject<Block> NETHER_ALEXANDRITE_ORE = registerBlock("nether_alexandrite_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.NETHERRACK)
                    .strength(2.0f).requiresCorrectToolForDrops(), UniformInt.of(4, 8)));
    public static final RegistryObject<Block> END_ALEXANDRITE_ORE = registerBlock("end_alexandrite_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.END_STONE)
                    .strength(4.5f, 6.0f).requiresCorrectToolForDrops(), UniformInt.of(4, 8)));

    public static final RegistryObject<Block> SOUND_BLOCK = registerBlock("sound_block",
            () -> new SoundBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));

    public static final RegistryObject<Block> RAW_ALEXANDRITE_STAIRS = registerBlock("raw_alexandrite_stairs",
            () -> new StairBlock(() -> ModBlocks.RAW_ALEXANDRITE_BLOCK.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.GRANITE_STAIRS).sound(SoundType.METAL)));
    public static final RegistryObject<Block> RAW_ALEXANDRITE_SLAB = registerBlock("raw_alexandrite_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.GRANITE_SLAB).sound(SoundType.METAL)));
    public static final RegistryObject<Block> ALEXANDRITE_STAIRS = registerBlock("alexandrite_stairs",
            () -> new StairBlock(() -> ModBlocks.ALEXANDRITE_BLOCK.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.GRANITE_STAIRS).sound(SoundType.METAL)));
    public static final RegistryObject<Block> ALEXANDRITE_SLAB = registerBlock("alexandrite_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.GRANITE_SLAB).sound(SoundType.METAL)));

    public static final RegistryObject<Block> RAW_ALEXANDRITE_PRESSURE_PLATE = registerBlock("raw_alexandrite_pressure_plate",
            () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING,
                    BlockBehaviour.Properties.copy(Blocks.GRANITE).sound(SoundType.METAL), BlockSetType.IRON));
    public static final RegistryObject<Block> RAW_ALEXANDRITE_BUTTON = registerBlock("raw_alexandrite_button",
            () -> new ButtonBlock(BlockBehaviour.Properties.copy(Blocks.GRANITE).sound(SoundType.METAL), BlockSetType.IRON, 10, true));

    public static final RegistryObject<Block> ALEXANDRITE_PRESSURE_PLATE = registerBlock("alexandrite_pressure_plate",
            () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING,
                    BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.METAL), BlockSetType.IRON));
    public static final RegistryObject<Block> ALEXANDRITE_BUTTON = registerBlock("alexandrite_button",
            () -> new ButtonBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.METAL), BlockSetType.IRON, 10, true));


    public static final RegistryObject<Block> RAW_ALEXANDRITE_FENCE = registerBlock("raw_alexandrite_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));
    public static final RegistryObject<Block> RAW_ALEXANDRITE_FENCE_GATE = registerBlock("raw_alexandrite_fence_gate",
            () -> new FenceGateBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK), SoundEvents.FENCE_GATE_OPEN, SoundEvents.FENCE_GATE_CLOSE));
    public static final RegistryObject<Block> RAW_ALEXANDRITE_WALL = registerBlock("raw_alexandrite_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));

    public static final RegistryObject<Block> ALEXANDRITE_FENCE = registerBlock("alexandrite_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));
    public static final RegistryObject<Block> ALEXANDRITE_FENCE_GATE = registerBlock("alexandrite_fence_gate",
            () -> new FenceGateBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK), SoundEvents.FENCE_GATE_OPEN, SoundEvents.FENCE_GATE_CLOSE));
    public static final RegistryObject<Block> ALEXANDRITE_WALL = registerBlock("alexandrite_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));

    public static final RegistryObject<Block> RAW_ALEXANDRITE_DOOR = registerBlock("raw_alexandrite_door",
            () -> new DoorBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK), BlockSetType.IRON));
    public static final RegistryObject<Block> RAW_ALEXANDRITE_TRAPDOOR = registerBlock("raw_alexandrite_trapdoor",
            () -> new TrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion(), BlockSetType.IRON));
    public static final RegistryObject<Block> ALEXANDRITE_DOOR = registerBlock("alexandrite_door",
            () -> new DoorBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK), BlockSetType.IRON));
    public static final RegistryObject<Block> ALEXANDRITE_TRAPDOOR = registerBlock("alexandrite_trapdoor",
            () -> new TrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion(), BlockSetType.IRON));

    public static final RegistryObject<Block> ALEXANDRITE_LAMP = registerBlock("alexandrite_lamp",
            () -> new AlexandriteLampBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BLUE).sound(SoundType.GLASS)
                    .lightLevel(state -> state.getValue(AlexandriteLampBlock.CLICKED) ? 15 : 0)));

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block>RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
