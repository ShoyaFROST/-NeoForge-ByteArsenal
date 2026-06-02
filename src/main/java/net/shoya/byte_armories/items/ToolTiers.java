package net.shoya.byte_armories.items;

import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.common.SimpleTier;
import net.shoya.byte_armories.util.ByteTags;

public class ToolTiers {
    public static final Tier ExpandedWeaponTier = new SimpleTier(ByteTags.Blocks.INCORRECT_FOR_PLUTONIUM_TOOL,
            2031, 9.0F, 4.0F, 15, () -> Ingredient.of(OreItems.plutonium));
}
