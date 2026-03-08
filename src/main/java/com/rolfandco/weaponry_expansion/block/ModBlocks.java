package com.rolfandco.weaponry_expansion.block;

import com.rolfandco.weaponry_expansion.block.module_table.T1ModuleTable;
import com.rolfandco.weaponry_expansion.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

import static com.rolfandco.weaponry_expansion.WeaponryExpansion.MODID; // referenced in deferred register.create (static import, replaces WeaponryExpansion.MODID with just MODID)

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MODID); // private method to register blocks easier


    public static final RegistryObject<Block> JADE_ORE = registerBlock("jade_ore", // public so WeaponryExpansion.java and others can access it, registers an object block BLOCKNAME = register("name", supplier -> new class block(blockBehaviour)) no clue if thats right
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_ORE)));

   public static final RegistryObject<Block> JADE_BLOCK = registerBlock("jade_block", () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.AMETHYST)));
   public static final RegistryObject<Block> T1_MODULE_TABLE = registerBlock("t1_module_table", () -> new T1ModuleTable(BlockBehaviour.Properties.of()));


    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
