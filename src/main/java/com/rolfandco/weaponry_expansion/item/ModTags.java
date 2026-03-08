package com.rolfandco.weaponry_expansion.item;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

import static com.rolfandco.weaponry_expansion.WeaponryExpansion.MODID;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> NEEDS_JADE_TOOL = tag("needs_jade_tool");
        public static final TagKey<Block> NEEDS_BLANK_TOOL = tag("needs_blank_tool");
        private static TagKey<Block> tag(String name) {
            return BlockTags.create(new ResourceLocation(MODID, name));
        }
    }
}
