/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.kayzai.astralite.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.Block;

import net.kayzai.astralite.block.LavaIceBlock;
import net.kayzai.astralite.block.Astral_PowderOreBlock;
import net.kayzai.astralite.block.Astral_PowderBlockBlock;
import net.kayzai.astralite.block.AstralIngotBlockBlock;
import net.kayzai.astralite.AstraliteMod;

public class AstraliteModBlocks {
	public static final DeferredRegister<Block> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCKS, AstraliteMod.MODID);
	public static final RegistryObject<Block> ASTRAL_POWDER_ORE = REGISTRY.register("astral_powder_ore", () -> new Astral_PowderOreBlock());
	public static final RegistryObject<Block> ASTRAL_POWDER_BLOCK = REGISTRY.register("astral_powder_block", () -> new Astral_PowderBlockBlock());
	public static final RegistryObject<Block> ASTRALITE_BLOCK = REGISTRY.register("astralite_block", () -> new AstralIngotBlockBlock());
	public static final RegistryObject<Block> LAVA_ICE = REGISTRY.register("lava_ice", () -> new LavaIceBlock());
	// Start of user code block custom blocks
	// End of user code block custom blocks
}