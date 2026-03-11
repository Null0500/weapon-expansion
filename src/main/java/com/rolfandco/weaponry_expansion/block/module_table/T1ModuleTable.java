package com.rolfandco.weaponry_expansion.block.module_table;

import com.rolfandco.weaponry_expansion.Logger;
import com.rolfandco.weaponry_expansion.datagen.ModItemTagProvider;
import com.rolfandco.weaponry_expansion.entity.T1ModuleTableBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.EnchantmentMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.network.NetworkHooks;

import javax.annotation.Nullable;


public class T1ModuleTable extends BaseEntityBlock {

    public T1ModuleTable(Properties properties) {
        super(properties);
    }

    @Override
    public VoxelShape getCollisionShape(BlockState p_60572_, BlockGetter p_60573_, BlockPos p_60574_, CollisionContext p_60575_) {
        VoxelShape stands = Shapes.or(
                Block.box(0, 0, 0, 2, 4, 2),    // NW stand
                Block.box(0, 0, 14, 2, 4, 16),  // SW stand
                Block.box(14, 0, 0, 16, 4, 2),  // NE stand
                Block.box(14, 0, 14, 16, 4, 16) // SE stand
        );

        VoxelShape body = Shapes.or(
                Block.box(3, 3, 3, 13, 5, 13),   // Lower rim
                Block.box(3, 9, 3, 13, 11, 13),  // Upper rim
                Block.box(0, 4, 0, 16, 9, 16),   // Middle slab
                Block.box(0, 11, 0, 16, 14, 16)  // Top slab
        );

        return Shapes.or(stands, body);
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext ctx) {
        return this.getCollisionShape(state, level, pos, ctx);
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        ItemStack stack = player.getItemInHand(hand);
        if (stack.is(ModItemTagProvider.BLANK_GEAR)) {
            Logger.debug("Blank Gear detected!");
        }

        if (!level.isClientSide && player instanceof ServerPlayer serverPlayer) {
            NetworkHooks.openScreen(serverPlayer, state.getMenuProvider(level, pos));
        }
        return InteractionResult.sidedSuccess(level.isClientSide);
    }


    @Override
    public void onRemove(BlockState blockState, Level level, BlockPos blockPos, BlockState blockNewState, boolean isMoving) {
        if (blockState.getBlock() != blockNewState.getBlock()) {
            BlockEntity blockEntity = level.getBlockEntity(blockPos);
            if (blockEntity instanceof T1ModuleTableBlockEntity) {
                ((T1ModuleTableBlockEntity) blockEntity).drops();
            }
        }

        super.onRemove(blockState, level, blockPos, blockNewState, isMoving);
    }

    @Override
    public RenderShape getRenderShape(BlockState blockState) {
        return RenderShape.MODEL;
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        return new T1ModuleTableBlockEntity(blockPos, blockState);
    }
}
