package com.rolfandco.weaponry_expansion.item.jade;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;

import java.util.logging.Logger;

public class JadeBangleItem extends Item {

    public JadeBangleItem(Properties properties) {
        super(properties);
    }
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack itemstack = player.getItemInHand(hand);
        if (!level.isClientSide()) { // Not on the client: (on the server:)
            player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED), player);
        }

        if (!player.getAbilities().instabuild) { // if the player doesn't have access to insta-build (which is available in creative mode) (stolen from ender pearl :D)
            itemstack.shrink(1); // shrink the item stack by an integer. Set to negative value to add
        }

        return InteractionResultHolder.sidedSuccess(itemstack, level.isClientSide());
    }

}
