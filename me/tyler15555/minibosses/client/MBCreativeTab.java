package me.tyler15555.minibosses.client;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;

public class MBCreativeTab extends CreativeTabs {

	public MBCreativeTab() {
		super("MiniBosses");
	}

	public MBCreativeTab(int par1, String par2Str) {
		super(par1, par2Str);
	}

	@Override
	public Item getTabIconItem() {
		return Item.getItemFromBlock(Blocks.dragon_egg);
	}

}
