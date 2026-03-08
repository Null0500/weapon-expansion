package com.rolfandco.weaponry_expansion.item;

import com.rolfandco.weaponry_expansion.item.jade.JadeBangleItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static com.rolfandco.weaponry_expansion.WeaponryExpansion.MODID;

public class ModItems {

    public static DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);

    public static final RegistryObject<Item> CUT_JADE = ITEMS.register("cut_jade", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> JADE_BANGLE = ITEMS.register("jade_bangle", () -> new JadeBangleItem(new Item.Properties()));
    public static final RegistryObject<Item> BLANKSTONE = ITEMS.register("blankstone", () -> new Item(new Item.Properties()));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
