package com.rolfandco.weaponry_expansion.datagen;

import com.rolfandco.weaponry_expansion.item.ModItems;
import com.rolfandco.weaponry_expansion.item.jade.JadeTools;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

import static com.rolfandco.weaponry_expansion.WeaponryExpansion.MODID;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {

        handheldItem(JadeTools.JADE_PICKAXE);
        handheldItem(JadeTools.JADE_SWORD);
        generatedItem(ModItems.CUT_JADE);



    }
    private ItemModelBuilder handheldItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/handheld")).texture(
                "layer0", new ResourceLocation(MODID, "item/" + item.getId().getPath()));
    }

    private ItemModelBuilder generatedItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture(
                "layer0", new ResourceLocation(MODID, "item/" + item.getId().getPath()));
    }
}
