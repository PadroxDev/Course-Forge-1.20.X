package net.padrox.mccourse.enchantment;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.padrox.mccourse.MCCourseMod;

public class ModEnchantments {
    public static final DeferredRegister<Enchantment> ENCHANTMENTS =
            DeferredRegister.create(ForgeRegistries.ENCHANTMENTS, MCCourseMod.MOD_ID);

    public static final RegistryObject<Enchantment> LIGHTNING_STRIKER =
            ENCHANTMENTS.register("lightning_striker",
                    () -> new LightningStrikerEnchantment(Enchantment.Rarity.VERY_RARE, EnchantmentCategory.WEAPON,
                            EquipmentSlot.MAINHAND));

    public static void register(IEventBus eventBus) {
        ENCHANTMENTS.register(eventBus);
    }
}
