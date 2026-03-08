package com.rolfandco.weaponry_expansion.datagen;

import com.rolfandco.weaponry_expansion.item.ModItems;
import com.rolfandco.weaponry_expansion.item.blank_items.BlankTools;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

import javax.annotation.Nullable;
import java.util.concurrent.CompletableFuture;

import static com.rolfandco.weaponry_expansion.WeaponryExpansion.MODID;

public class ModItemTagProvider extends ItemTagsProvider {
    public static final TagKey<Item> BLANK_GEAR = TagKey.create(
            Registries.ITEM,
            new ResourceLocation(MODID, "blank_gear")
    );

    public ModItemTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> provider,
                              CompletableFuture<TagsProvider.TagLookup<Block>> block_provider,
                              @Nullable ExistingFileHelper existingFileHelper) {
        super(output, provider, block_provider, MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {

    }
}
