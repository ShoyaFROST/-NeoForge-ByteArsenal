package net.shoya.byte_armories.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.shoya.byte_armories.RhenTutorial;
import net.shoya.byte_armories.util.ByteTags;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ByteBlockTagProvider extends BlockTagsProvider {
    public ByteBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, RhenTutorial.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {

        tag(ByteTags.Blocks.NEEDS_PLUTONIUM_TOOL)
                .addTag(BlockTags.NEEDS_IRON_TOOL);

        tag(ByteTags.Blocks.INCORRECT_FOR_PLUTONIUM_TOOL)
                .addTag(BlockTags.INCORRECT_FOR_IRON_TOOL)
                .remove(ByteTags.Blocks.NEEDS_PLUTONIUM_TOOL);
    }
}