package com.rolfandco.weaponry_expansion.item.blank_items;

import com.rolfandco.weaponry_expansion.item.ModArmorMaterials;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static com.rolfandco.weaponry_expansion.WeaponryExpansion.MODID;

public class BlankArmor extends ArmorItem {
    private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);

    public static final RegistryObject<Item> BLANK_HELMET = ITEMS.register("blank_helmet",
            () -> new ArmorItem(ModArmorMaterials.BLANK, Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> BLANK_CHESTPLATE = ITEMS.register("blank_chestplate",
            () -> new ArmorItem(ModArmorMaterials.BLANK, Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> BLANK_LEGGINGS = ITEMS.register("blank_leggings",
            () -> new ArmorItem(ModArmorMaterials.BLANK, Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> BLANK_BOOTS = ITEMS.register("blank_boots",
            () -> new ArmorItem(ModArmorMaterials.BLANK, Type.BOOTS, new Item.Properties()));

    public BlankArmor(ArmorMaterial armorMaterial, Type type, Properties properties) {
        super(armorMaterial, type, properties);
    }

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
