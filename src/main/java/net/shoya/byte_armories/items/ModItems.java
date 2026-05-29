package net.shoya.byte_armories.items;

import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredItem;
import net.shoya.byte_armories.RhenTutorial;

public class ModItems {

    public static final DeferredRegister.Items ITEMS =
            DeferredRegister.createItems(RhenTutorial.MODID);
    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    };

    public static final DeferredItem<Item> crystal_frost = ITEMS.register("crystal_frost",
            () -> new Item(new Item.Properties()));
}
