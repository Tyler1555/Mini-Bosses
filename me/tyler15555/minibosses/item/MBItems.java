package me.tyler15555.minibosses.item;

import me.tyler15555.minibosses.util.Resources;
import net.minecraft.item.Item;

public class MBItems {

	public MBItems() {
		
	}
	
	public static Item ingotDarkIron = new Item().setUnlocalizedName("ingotDarkIron").setTextureName("minibosses:dark_iron").setCreativeTab(Resources.tabMB);
	public static Item darkIronHelm = new ItemDarkIronArmor(0).setUnlocalizedName("darkIronHelm").setTextureName("minibosses:dark_iron_helm");
	public static Item darkIronChest = new ItemDarkIronArmor(1).setUnlocalizedName("darkIronChest").setTextureName("minibosses:dark_iron_chest");
	public static Item darkIronLegs = new ItemDarkIronArmor(2).setUnlocalizedName("darkIronLegs").setTextureName("minibosses:dark_iron_legs");
	public static Item darkIronBoots = new ItemDarkIronArmor(3).setUnlocalizedName("darkIronBoots").setTextureName("minibosses:dark_iron_boots");
	public static Item occulus_item = new ItemOcculus();

}
