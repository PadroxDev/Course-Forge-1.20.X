package net.padrox.mccourse.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.padrox.mccourse.MCCourseMod;
import net.padrox.mccourse.block.ModBlocks;

public class ModCreativeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MCCourseMod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> COURSE_TAB = CREATIVE_MODE_TABS.register("course_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.ALEXANDRITE_GEM.get()))
                    .title(Component.translatable("creativetab.course_tab"))
                    .displayItems((parameters, output) -> {
                        output.accept(ModItems.RAW_ALEXANDRITE.get());
                        output.accept(ModItems.ALEXANDRITE_GEM.get());
                        output.accept(ModItems.METAL_DETECTOR.get());
                        output.accept(ModItems.KOHLRABI.get());
                        output.accept(ModItems.PEAT_BRICK.get());

                        output.accept(ModBlocks.SOUND_BLOCK.get());

                        output.accept(ModBlocks.RAW_ALEXANDRITE_BLOCK.get());
                        output.accept(ModBlocks.ALEXANDRITE_BLOCK.get());

                        output.accept(ModBlocks.ALEXANDRITE_ORE.get());
                        output.accept(ModBlocks.DEEPSLATE_ALEXANDRITE_ORE.get());
                        output.accept(ModBlocks.NETHER_ALEXANDRITE_ORE.get());
                        output.accept(ModBlocks.END_ALEXANDRITE_ORE.get());

                        output.accept(ModBlocks.RAW_ALEXANDRITE_STAIRS.get());
                        output.accept(ModBlocks.RAW_ALEXANDRITE_SLAB.get());
                        output.accept(ModBlocks.ALEXANDRITE_STAIRS.get());
                        output.accept(ModBlocks.ALEXANDRITE_SLAB.get());

                        output.accept(ModBlocks.RAW_ALEXANDRITE_PRESSURE_PLATE.get());
                        output.accept(ModBlocks.RAW_ALEXANDRITE_BUTTON.get());
                        output.accept(ModBlocks.ALEXANDRITE_PRESSURE_PLATE.get());
                        output.accept(ModBlocks.ALEXANDRITE_BUTTON.get());

                        output.accept(ModBlocks.RAW_ALEXANDRITE_FENCE.get());
                        output.accept(ModBlocks.RAW_ALEXANDRITE_FENCE_GATE.get());
                        output.accept(ModBlocks.RAW_ALEXANDRITE_WALL.get());
                        output.accept(ModBlocks.ALEXANDRITE_FENCE.get());
                        output.accept(ModBlocks.ALEXANDRITE_FENCE_GATE.get());
                        output.accept(ModBlocks.ALEXANDRITE_WALL.get());

                        output.accept(ModBlocks.RAW_ALEXANDRITE_DOOR.get());
                        output.accept(ModBlocks.RAW_ALEXANDRITE_TRAPDOOR.get());
                        output.accept(ModBlocks.ALEXANDRITE_DOOR.get());
                        output.accept(ModBlocks.ALEXANDRITE_TRAPDOOR.get());
                    }).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}