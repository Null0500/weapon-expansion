package com.rolfandco.weaponry_expansion.entity;

import com.rolfandco.weaponry_expansion.block.ModBlocks;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static com.rolfandco.weaponry_expansion.WeaponryExpansion.MODID;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, MODID);

    public static final RegistryObject<BlockEntityType<T1ModuleTableBlockEntity>> T1_MODULE_TABLE_BE = BLOCK_ENTITIES.register(
            "t1_module_table_be", () -> BlockEntityType.Builder.of(T1ModuleTableBlockEntity::new,
                    ModBlocks.T1_MODULE_TABLE.get()).build(null));







    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}
