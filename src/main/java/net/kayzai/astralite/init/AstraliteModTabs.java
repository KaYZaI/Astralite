/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.kayzai.astralite.init;

import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;

import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.core.registries.Registries;

import net.kayzai.astralite.AstraliteMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class AstraliteModTabs {
	public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, AstraliteMod.MODID);

	@SubscribeEvent
	public static void buildTabContentsVanilla(BuildCreativeModeTabContentsEvent tabData) {
		if (tabData.getTabKey() == CreativeModeTabs.INGREDIENTS) {
			tabData.accept(AstraliteModItems.ASTRAL_POWDER.get());
			tabData.accept(AstraliteModItems.ASTRALITE_INGOT.get());
			tabData.accept(AstraliteModItems.PURIFIED_ASTRAL_POWDER.get());
			tabData.accept(AstraliteModItems.VIAL_ASTRAL_POWDER.get());
		} else if (tabData.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS) {
			tabData.accept(AstraliteModBlocks.ASTRAL_POWDER_ORE.get().asItem());
			tabData.accept(AstraliteModBlocks.ASTRAL_POWDER_BLOCK.get().asItem());
			tabData.accept(AstraliteModBlocks.ASTRALITE_BLOCK.get().asItem());
		} else if (tabData.getTabKey() == CreativeModeTabs.NATURAL_BLOCKS) {
			tabData.accept(AstraliteModBlocks.LAVA_ICE.get().asItem());
		} else if (tabData.getTabKey() == CreativeModeTabs.COMBAT) {
			tabData.accept(AstraliteModItems.ASTRALITE_HELMET.get());
			tabData.accept(AstraliteModItems.ASTRALITE_CHESTPLATE.get());
			tabData.accept(AstraliteModItems.ASTRALITE_LEGGINGS.get());
			tabData.accept(AstraliteModItems.ASTRALITE_BOOTS.get());
		} else if (tabData.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES) {
			tabData.accept(AstraliteModItems.ASTRALITE_SHOVEL.get());
			tabData.accept(AstraliteModItems.ASTRALITE_PICKAXE.get());
			tabData.accept(AstraliteModItems.ASTRALITE_AXE.get());
			tabData.accept(AstraliteModItems.ASTRALITE_HOE.get());
		}
	}
}