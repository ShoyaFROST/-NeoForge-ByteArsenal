package net.shoya.byte_armories.util;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.shoya.byte_armories.RhenTutorial;

public class ByteTags {
    public static class Blocks {
        public static final TagKey<Block> NEEDS_PLUTONIUM_TOOL = createTag("needs_plutonium_tool");
        public static final TagKey<Block> INCORRECT_FOR_PLUTONIUM_TOOL = createTag("incorrect_for_plutonium_tool");

        private static TagKey<Block> createTag(String name) {
            return BlockTags.create(ResourceLocation.fromNamespaceAndPath(RhenTutorial.MODID, name));
        }
    }
    public static class Items {


        private static TagKey<Item> createTag(String name) {
            return ItemTags.create(ResourceLocation.fromNamespaceAndPath(RhenTutorial.MODID, name));
        }
    }
}
