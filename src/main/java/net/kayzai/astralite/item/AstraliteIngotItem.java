package net.kayzai.astralite.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class AstraliteIngotItem extends Item {
	public AstraliteIngotItem() {
		super(new Item.Properties().stacksTo(64).fireResistant().rarity(Rarity.EPIC));
	}
}