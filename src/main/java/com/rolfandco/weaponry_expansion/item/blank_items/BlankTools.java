package com.rolfandco.weaponry_expansion.item.blank_items;

import com.rolfandco.weaponry_expansion.item.ModItems;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static com.rolfandco.weaponry_expansion.WeaponryExpansion.MODID;

public class BlankTools{
    private static DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);


    public static final RegistryObject<Item> BLANK_SWORD = ITEMS.register("blank_sword", () -> new Item(new Item.Properties()));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
