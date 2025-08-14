package net.kayzai.astralite.procedures;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.tags.BlockTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

public class AstraliteAxePassiveProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		boolean isWood = false;
		double height = 0;
		double zwidth = 0;
		double xwidth = 0;
		height = 0;
		if ((world.getBlockState(BlockPos.containing(x, y, z))).is(BlockTags.create(ResourceLocation.parse("minecraft:logs"))) && entity.isShiftKeyDown()) {
			for (int index0 = 0; index0 < 64; index0++) {
				xwidth = -3;
				for (int index1 = 0; index1 < 7; index1++) {
					zwidth = -3;
					for (int index2 = 0; index2 < 7; index2++) {
						if ((world.getBlockState(BlockPos.containing(x + xwidth, y + height, z + zwidth))).is(BlockTags.create(ResourceLocation.parse("minecraft:logs")))) {
							{
								BlockPos _pos = BlockPos.containing(x + xwidth, y + height, z + zwidth);
								Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x + xwidth, y + height, z + zwidth), null);
								world.destroyBlock(_pos, false);
							}
						}
						zwidth = zwidth + 1;
					}
					xwidth = xwidth + 1;
				}
				height = height + 1;
			}
			{
				ItemStack _ist = itemstack;
				if (_ist.hurt(1, RandomSource.create(), null)) {
					_ist.shrink(1);
					_ist.setDamageValue(0);
				}
			}
		}
	}
}