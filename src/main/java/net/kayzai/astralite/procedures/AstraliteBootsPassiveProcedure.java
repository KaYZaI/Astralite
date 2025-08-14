package net.kayzai.astralite.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

import net.kayzai.astralite.init.AstraliteModBlocks;

public class AstraliteBootsPassiveProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if ((world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() == Blocks.LAVA) {
			world.setBlock(BlockPos.containing(x, y - 1, z), AstraliteModBlocks.LAVA_ICE.get().defaultBlockState(), 3);
		}
	}
}