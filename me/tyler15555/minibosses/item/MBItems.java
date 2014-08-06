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
	public static Item ingotInferno = new Item().setUnlocalizedName("ingotInferno").setTextureName("minibosses:inferno_ingot").setCreativeTab(Resources.tabMB);
	public static Item infernoHelm = new ItemInfernoArmor(0).setUnlocalizedName("infernoHelm").setTextureName("minibosses:inferno_helm");
	public static Item infernoChest = new ItemInfernoArmor(1).setUnlocalizedName("infernoChest").setTextureName("minibosses:inferno_chest");
	public static Item infernoLegs = new ItemInfernoArmor(2).setUnlocalizedName("infernoLegs").setTextureName("minibosses:inferno_legs");
	public static Item infernoBoots = new ItemInfernoArmor(3).setUnlocalizedName("infernoBoots").setTextureName("minibosses:inferno_boots");
	public static Item feederTooth = new Item().setUnlocalizedName("feederTooth").setTextureName("minibosses:feeder_tooth").setCreativeTab(Resources.tabMB);
	public static Item feederSword = new ItemFeederSword();

}
