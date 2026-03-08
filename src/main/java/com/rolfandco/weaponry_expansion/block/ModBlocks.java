package com.rolfandco.weaponry_expansion.block;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static com.rolfandco.weaponry_expansion.WeaponryExpansion.MODID; // referenced in deferred register.create (static import, replaces WeaponryExpansion.MODID with just MODID)

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MODID); // private method to register blocks easier


    public static final RegistryObject<Block> JADE_ORE = BLOCKS.register("jade_ore", // public so WeaponryExpansion.java and others can access it, registers an object block BLOCKNAME = register("name", supplier -> new class block(blockBehaviour)) no clue if thats right
            () -> new Block(BlockBehaviour.Properties.of().requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> JADE_BLOCK = BLOCKS.register("jade_block",
            () -> new Block(BlockBehaviour.Properties.of().requiresCorrectToolForDrops()));


    public static void register(IEventBus eventBus) {BLOCKS.register(eventBus);}
}
