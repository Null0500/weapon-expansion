package com.rolfandco.weaponry_expansion.block.module_table;

import com.rolfandco.weaponry_expansion.Logger;
import com.rolfandco.weaponry_expansion.datagen.ModItemTagProvider;
import com.rolfandco.weaponry_expansion.item.ModItems;
import com.rolfandco.weaponry_expansion.item.blank_items.BlankTools;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;


public class T1ModuleTable extends Block {

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
    public InteractionResult use(BlockState blockState, Level level, BlockPos blockPos, Player player, InteractionHand hand, BlockHitResult hitResult) {
        ItemStack itemstack = player.getItemInHand(hand);
        if (itemstack.is(ModItemTagProvider.BLANK_GEAR)) {
            Logger.info("This item has the Blank Gear tag!");
            return InteractionResult.PASS;
        } else {
            return InteractionResult.FAIL;
        }
    }

}
