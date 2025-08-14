package net.kayzai.astralite.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class VialAstralPowderItem extends Item {
	public VialAstralPowderItem() {
		super(new Item.Properties().stacksTo(64).fireResistant().rarity(Rarity.RARE));
	}
}