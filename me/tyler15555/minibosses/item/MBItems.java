package me.tyler15555.minibosses.item;

import me.tyler15555.minibosses.util.Resources;
import net.minecraft.item.Item;

public class MBItems {

	public MBItems() {
		
	}
	
	public static Item ingotDarkIron = new Item().setUnlocalizedName("ingotDarkIron").setCreativeTab(Resources.tabMB);
	public static Item darkIronHelm = new ItemDarkIronArmor(0).setUnlocalizedName("darkIronHelm");
	public static Item darkIronChest = new ItemDarkIronArmor(1).setUnlocalizedName("darkIronChest");
	public static Item darkIronLegs = new ItemDarkIronArmor(2).setUnlocalizedName("darkIronLegs");
	public static Item darkIronBoots = new ItemDarkIronArmor(3).setUnlocalizedName("darkIronBoots");
	public static Item occulus_item = new ItemOcculus();
	public static Item ingotInferno = new Item().setUnlocalizedName("ingotInferno").setCreativeTab(Resources.tabMB);
	public static Item infernoHelm = new ItemInfernoArmor(0).setUnlocalizedName("infernoHelm");
	public static Item infernoChest = new ItemInfernoArmor(1).setUnlocalizedName("infernoChest");
	public static Item infernoLegs = new ItemInfernoArmor(2).setUnlocalizedName("infernoLegs");
	public static Item infernoBoots = new ItemInfernoArmor(3).setUnlocalizedName("infernoBoots"); 
	public static Item feederTooth = new Item().setUnlocalizedName("feederTooth").setCreativeTab(Resources.tabMB);
	public static Item feederSword = new ItemFeederSword();
	public static Item reviveHeart = new ItemReviveHeart();
	public static Item medusaEye = new ItemMedusaEye();
	public static Item dodgeGem = new ItemDodgeGem();

}
