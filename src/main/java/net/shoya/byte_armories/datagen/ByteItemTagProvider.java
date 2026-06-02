package net.shoya.byte_armories.datagen;

import net.shoya.byte_armories.RhenTutorial;
import net.shoya.byte_armories.items.weaponItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

import org.jetbrains.annotations.NotNull;
import javax.annotation.Nullable;

import java.util.concurrent.CompletableFuture;

public class ByteItemTagProvider extends ItemTagsProvider {
    public ByteItemTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, CompletableFuture<TagLookup<Block>> blockTags, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, blockTags, RhenTutorial.MODID, existingFileHelper);
    }
    @Override
    public void addTags(HolderLookup.@NotNull Provider provider) {
        tag(ItemTags.SWORDS)
                .add(weaponItems.radioactive_scythe.get());
    }
}
