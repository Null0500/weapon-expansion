package com.rolfandco.weaponry_expansion.item;

import com.rolfandco.weaponry_expansion.block.ModBlocks;
import com.rolfandco.weaponry_expansion.item.blank_items.BlankTools;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import static com.rolfandco.weaponry_expansion.WeaponryExpansion.MODID;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB_DEFERRED_REGISTER
            = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MODID);

    public static final RegistryObject<CreativeModeTab> MOD_ITEMS = CREATIVE_MODE_TAB_DEFERRED_REGISTER.register("weapon_ex", () -> CreativeModeTab.builder().icon(() -> new ItemStack(BlankTools.BLANK_SWORD.get()))
            .title(Component.translatable("creativetab.weapon_ex"))
            .displayItems((pParamaters, pOutput) -> {

        pOutput.accept(ModItems.CUT_JADE.get());
        pOutput.accept(ModItems.BLANKSTONE.get());
        pOutput.accept(ModItems.JADE_BANGLE.get());
        pOutput.accept(BlankTools.BLANK_SWORD.get());
        pOutput.accept(ModBlocks.JADE_BLOCK.get());
        pOutput.accept(ModBlocks.JADE_ORE.get());
        pOutput.accept(ModBlocks.T1_MODULE_TABLE.get());

    }).build());

    public static void register(IEventBus eventBus) {CREATIVE_MODE_TAB_DEFERRED_REGISTER.register(eventBus);}
}
