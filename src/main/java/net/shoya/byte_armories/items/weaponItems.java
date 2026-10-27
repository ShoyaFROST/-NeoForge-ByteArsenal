package net.shoya.byte_armories.items;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.SwordItem;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.shoya.byte_armories.RhenTutorial;

public class weaponItems {

    public weaponItems(IEventBus modEventBus, ModContainer modContainer) {
    }

    public static final DeferredRegister.Items ITEMS =
            DeferredRegister.createItems(RhenTutorial.MODID);
    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    };


    //Item register
    public static final DeferredItem<SwordItem> radioactive_scythe = ITEMS.register("radioactive_scythe",
            () -> new RadioactiveScythe(ToolTiers.ExpandedWeaponTier, new Item.Properties()
                    .attributes(SwordItem.createAttributes(ToolTiers.ExpandedWeaponTier, 7, -3F))));
    public static final DeferredItem<SwordItem> winterfrost_katana = ITEMS.register("winterfrost_katana",
            () -> new SwordItem(ToolTiers.ExpandedWeaponTier, new Item.Properties()
                    .attributes(SwordItem.createAttributes(ToolTiers.ExpandedWeaponTier, 4, -2F))));
    public static final DeferredItem<SwordItem> bloodburst = ITEMS.register("bloodburst",
            () -> new SwordItem(ToolTiers.ExpandedWeaponTier, new Item.Properties()
                    .attributes(SwordItem.createAttributes(ToolTiers.ExpandedWeaponTier, 4, -2F))));
    public static final DeferredItem<SwordItem> crimson_fang = ITEMS.register("crimson_fang",
            () -> new SwordItem(ToolTiers.ExpandedWeaponTier, new Item.Properties()
                    .attributes(SwordItem.createAttributes(ToolTiers.ExpandedWeaponTier, 4, -2F))));
}
