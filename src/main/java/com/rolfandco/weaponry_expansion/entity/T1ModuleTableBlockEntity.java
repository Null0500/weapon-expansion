package com.rolfandco.weaponry_expansion.entity;

import com.rolfandco.weaponry_expansion.screen.T1ModuleTableMenu;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.Containers;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.Nameable;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class T1ModuleTableBlockEntity extends BlockEntity implements MenuProvider {
    public T1ModuleTableBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(ModBlockEntities.T1_MODULE_TABLE_BE.get(), blockPos, blockState);
    }


    private Component name;

    public void drops() {
        SimpleContainer inventory = new SimpleContainer(itemStackHandler.getSlots());
        for(int i = 0; i < itemStackHandler.getSlots(); ++i) {
            inventory.setItem(i, itemStackHandler.getStackInSlot(i));
        }

        Containers.dropContents(this.level, this.worldPosition, inventory);
    }

    protected ContainerData data;

    @Override
    public Component getDisplayName() {
        return Component.translatable("block.weapon_ex.t1_module_table");
    }

    ItemStackHandler itemStackHandler = new ItemStackHandler(3); // size is amount of items in gui

    private static final int INPUT_GEAR = 0;
    private static final int INPUT_GEM = 1;
    private static final int OUTPUT_GEAR = 2;

    private LazyOptional<IItemHandler> lazyHandler= LazyOptional.empty();

    @Override
    public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
        if (cap == ForgeCapabilities.ITEM_HANDLER) {
            return lazyHandler.cast();
        }
        return super.getCapability(cap, side);
    }

    @Override
    public void onLoad() {
        super.onLoad();
        lazyHandler=LazyOptional.of(() -> itemStackHandler);
    }

    @Override
    public void invalidateCaps() {
        super.invalidateCaps();
        lazyHandler.invalidate();
    }

    public Component getName() {
        return (Component)(this.name != null ? this.name : Component.translatable("container.weapon_ex.t1_module_table"));
    }

    @Nullable
    public AbstractContainerMenu createMenu(int containerId, Inventory playerInv, Player player) {
        return new T1ModuleTableMenu(containerId, playerInv, this, this.data);
    }

    @Override
    protected void saveAdditional(CompoundTag tag) {
        tag.put("inventory", itemStackHandler.serializeNBT());

        super.saveAdditional(tag);
    }

    @Override
    public void load(CompoundTag tag) {
        super.load(tag);

        itemStackHandler.deserializeNBT(tag.getCompound("inventory"));
    }
}
