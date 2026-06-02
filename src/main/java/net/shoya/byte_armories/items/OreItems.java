package net.shoya.byte_armories.items;

import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredItem;
import net.shoya.byte_armories.RhenTutorial;

public class OreItems {

    public static final DeferredRegister.Items ITEMS =
            DeferredRegister.createItems(RhenTutorial.MODID);
    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    };

    public static final DeferredItem<Item> crystal_frost = ITEMS.register("crystal_frost",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> frost_ingot = ITEMS.register("frost_ingot",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> plutonium = ITEMS.register("plutonium",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> plutonium_netherite = ITEMS.register("plutonium_netherite",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> book_ico = ITEMS.register("book_ico",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> armory_enhancer = ITEMS.register("armory_enhancer",
            () -> new Item(new Item.Properties()));
}
