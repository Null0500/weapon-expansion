package com.rolfandco.weaponry_expansion.item;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.TierSortingRegistry;

import java.util.List;

import static com.rolfandco.weaponry_expansion.WeaponryExpansion.MODID;

public class ModToolTiers {
public static final Tier JADE = TierSortingRegistry.registerTier(
        new ForgeTier(6, 4096, 0.25f, 4f, 20,
                ModTags.Blocks.NEEDS_JADE_TOOL, () -> Ingredient.of(ModItems.CUT_JADE.get())),
        new ResourceLocation(MODID, "jade"), List.of(Tiers.NETHERITE), List.of());
}
