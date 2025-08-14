package net.kayzai.astralite.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class Astral_PowderIngotItem extends Item {
	public Astral_PowderIngotItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.UNCOMMON));
	}
}