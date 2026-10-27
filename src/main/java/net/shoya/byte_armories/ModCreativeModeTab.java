package net.shoya.byte_armories;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.shoya.byte_armories.items.OreItems;
import net.shoya.byte_armories.items.weaponItems;

import java.util.function.Supplier;

public class ModCreativeModeTab {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, RhenTutorial.MODID);

    public static final Supplier<CreativeModeTab> BYTE_MATERIALS_TAB = CREATIVE_MODE_TAB.register("byte_materials_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(OreItems.book_ico.get()))
                    .title(Component.translatable("creativetab.byte_armories.byte_armory_materials"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(OreItems.armory_enhancer);

                        output.accept(OreItems.plutonium);
                        output.accept(OreItems.plutonium_netherite);
                        output.accept(OreItems.crystal_frost);
                        output.accept(OreItems.frost_ingot);
                        output.accept(OreItems.blue_soul);
                    })
                    .build());

    public static final Supplier<CreativeModeTab> BYTE_ARMORIES_TAB = CREATIVE_MODE_TAB.register("byte_armories_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(weaponItems.radioactive_scythe.get()))
                    .withTabsBefore(ResourceLocation.fromNamespaceAndPath(RhenTutorial.MODID, "byte_materials_tab"))
                    .title(Component.translatable("creativetab.byte_armories.byte_armory_items"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(weaponItems.radioactive_scythe);
                        output.accept(weaponItems.winterfrost_katana);
                        output.accept(weaponItems.bloodburst);
                        output.accept(weaponItems.crimson_fang);
                    })
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
