/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.kayzai.astralite.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BlockItem;

import net.kayzai.astralite.item.VialAstralPowderItem;
import net.kayzai.astralite.item.AstraliteShovelItem;
import net.kayzai.astralite.item.AstralitePickaxeItem;
import net.kayzai.astralite.item.AstraliteIngotItem;
import net.kayzai.astralite.item.AstraliteHoeItem;
import net.kayzai.astralite.item.AstraliteAxeItem;
import net.kayzai.astralite.item.AstraliteArmorItem;
import net.kayzai.astralite.item.Astral_PowderIngotItem;
import net.kayzai.astralite.item.AstralPowderPurifiedItem;
import net.kayzai.astralite.AstraliteMod;

public class AstraliteModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, AstraliteMod.MODID);
	public static final RegistryObject<Item> ASTRAL_POWDER = REGISTRY.register("astral_powder", () -> new Astral_PowderIngotItem());
	public static final RegistryObject<Item> ASTRAL_POWDER_ORE = block(AstraliteModBlocks.ASTRAL_POWDER_ORE);
	public static final RegistryObject<Item> ASTRAL_POWDER_BLOCK = block(AstraliteModBlocks.ASTRAL_POWDER_BLOCK);
	public static final RegistryObject<Item> ASTRALITE_INGOT = REGISTRY.register("astralite_ingot", () -> new AstraliteIngotItem());
	public static final RegistryObject<Item> ASTRALITE_BLOCK = block(AstraliteModBlocks.ASTRALITE_BLOCK);
	public static final RegistryObject<Item> LAVA_ICE = block(AstraliteModBlocks.LAVA_ICE, new Item.Properties().fireResistant());
	public static final RegistryObject<Item> ASTRALITE_HELMET = REGISTRY.register("astralite_helmet", () -> new AstraliteArmorItem.Helmet());
	public static final RegistryObject<Item> ASTRALITE_CHESTPLATE = REGISTRY.register("astralite_chestplate", () -> new AstraliteArmorItem.Chestplate());
	public static final RegistryObject<Item> ASTRALITE_LEGGINGS = REGISTRY.register("astralite_leggings", () -> new AstraliteArmorItem.Leggings());
	public static final RegistryObject<Item> ASTRALITE_BOOTS = REGISTRY.register("astralite_boots", () -> new AstraliteArmorItem.Boots());
	public static final RegistryObject<Item> PURIFIED_ASTRAL_POWDER = REGISTRY.register("purified_astral_powder", () -> new AstralPowderPurifiedItem());
	public static final RegistryObject<Item> VIAL_ASTRAL_POWDER = REGISTRY.register("vial_astral_powder", () -> new VialAstralPowderItem());
	public static final RegistryObject<Item> ASTRALITE_SHOVEL = REGISTRY.register("astralite_shovel", () -> new AstraliteShovelItem());
	public static final RegistryObject<Item> ASTRALITE_PICKAXE = REGISTRY.register("astralite_pickaxe", () -> new AstralitePickaxeItem());
	public static final RegistryObject<Item> ASTRALITE_AXE = REGISTRY.register("astralite_axe", () -> new AstraliteAxeItem());
	public static final RegistryObject<Item> ASTRALITE_HOE = REGISTRY.register("astralite_hoe", () -> new AstraliteHoeItem());

	// Start of user code block custom items
	// End of user code block custom items
	private static RegistryObject<Item> block(RegistryObject<Block> block) {
		return block(block, new Item.Properties());
	}

	private static RegistryObject<Item> block(RegistryObject<Block> block, Item.Properties properties) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), properties));
	}
}