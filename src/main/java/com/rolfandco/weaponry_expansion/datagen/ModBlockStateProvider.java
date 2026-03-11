package com.rolfandco.weaponry_expansion.datagen;

import com.rolfandco.weaponry_expansion.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

import static com.rolfandco.weaponry_expansion.WeaponryExpansion.MODID;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, MODID, exFileHelper);

    }

    @Override
    protected void registerStatesAndModels() {
        simpleBlockWithItem(ModBlocks.T1_MODULE_TABLE.get(), new ModelFile.UncheckedModelFile(modLoc("block/t1_module_table")));
    }

    @Override
    public void simpleBlock(Block block, ConfiguredModel... models) {
            super.simpleBlock(block, models);
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}
