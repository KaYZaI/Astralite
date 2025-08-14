package net.kayzai.astralite.procedures;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.tags.BlockTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

public class AstralitePickaxePassiveProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		double raytraceDistance = 0;
		double toolHarvestLevel = 0;
		double FacingDirection = 0;
		double width = 0;
		double height = 0;
		double depth = 0;
		double xOffset = 0;
		double yOffset = 0;
		double zOffset = 0;
		raytraceDistance = 5;
		toolHarvestLevel = 2;
		FacingDirection = 0;
		if (!entity.isShiftKeyDown()) {
			width = 1;
			height = 1;
			depth = 1;
			if ((entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(raytraceDistance)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
					.getDirection()) == Direction.DOWN
					|| (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(raytraceDistance)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
							.getDirection()) == Direction.UP) {
				width = 3;
				height = 1;
				depth = 3;
				FacingDirection = 1;
			} else if ((entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(raytraceDistance)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
					.getDirection()) == Direction.NORTH
					|| (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(raytraceDistance)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
							.getDirection()) == Direction.SOUTH) {
				width = 3;
				height = 3;
				depth = 1;
				FacingDirection = 2;
			} else if ((entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(raytraceDistance)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
					.getDirection()) == Direction.WEST
					|| (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(raytraceDistance)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
							.getDirection()) == Direction.EAST) {
				width = 1;
				height = 3;
				depth = 3;
				FacingDirection = 3;
			}
			if (FacingDirection == 3) {
				xOffset = 0;
			} else {
				xOffset = -1;
			}
			for (int index0 = 0; index0 < (int) width; index0++) {
				if (FacingDirection == 1) {
					yOffset = 0;
				} else {
					yOffset = -1;
				}
				for (int index1 = 0; index1 < (int) height; index1++) {
					if (FacingDirection == 2) {
						zOffset = 0;
					} else {
						zOffset = -1;
					}
					for (int index2 = 0; index2 < (int) depth; index2++) {
						if (world.getBlockState(BlockPos.containing(x + xOffset, y + yOffset, z + zOffset)).getDestroySpeed(world, BlockPos.containing(x + xOffset, y + yOffset, z + zOffset)) >= 0
								&& (world.getBlockState(BlockPos.containing(x + xOffset, y + yOffset, z + zOffset))).is(BlockTags.create(ResourceLocation.parse("minecraft:mineable/pickaxe")))) {
							{
								BlockPos _pos = BlockPos.containing(x + xOffset, y + yOffset, z + zOffset);
								Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x + xOffset, y + yOffset, z + zOffset), null);
								world.destroyBlock(_pos, false);
							}
						}
						zOffset = zOffset + 1;
					}
					yOffset = yOffset + 1;
				}
				xOffset = xOffset + 1;
			}
			{
				ItemStack _ist = itemstack;
				if (_ist.hurt(1, RandomSource.create(), null)) {
					_ist.shrink(1);
					_ist.setDamageValue(0);
				}
			}
			if (itemstack.getMaxDamage() + itemstack.getDamageValue() > 0) {
				{
					ItemStack _ist = itemstack;
					if (_ist.hurt(-1, RandomSource.create(), null)) {
						_ist.shrink(1);
						_ist.setDamageValue(0);
					}
				}
			}
		}
	}
}