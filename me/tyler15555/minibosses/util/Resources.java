package me.tyler15555.minibosses.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import me.tyler15555.minibosses.client.MBCreativeTab;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.util.EnumHelper;

public class Resources {

	public Resources() {
		
	}
	public static ArmorMaterial dark_iron;
	public static ArmorMaterial inferno;
	public static ToolMaterial feeder;
	
	public static final String MOD_VERSION = "1.2.5";
	
	//Stores mod's request to not allow an entity to spawn in a certain dimension. Messages should be formatted as EntityName:DimensionID
	public static HashMap<String, Integer> entityBlockList = new HashMap();
	
	public static String[] firstNames = new String[] {"Based Doge", "Occulus", "Lord", "Destroyer", "Darkness", "Queen", "Steve", "Tom", "LaKeesha", "Doge", "tyler15555", "2withyoda", "Larry", "Larone"};
	public static String[] lastNames = new String[] {"Venice", "Worlds", "The World", "Earth", "The Galaxy", "Your Mom", "The Woods", "Mountains", "Rivers", "Stankins"};
	
	public static String generateRandomName(Random random) {
		String ret = firstNames[random.nextInt(firstNames.length)] + " of " + lastNames[random.nextInt(lastNames.length)];
		return ret;
	}
	
	public static void setupArmorMaterials() {
	  dark_iron = EnumHelper.addArmorMaterial("DARKIRON", "dark_iron", 22, new int[] {3, 7, 5, 4}, 25);
	  inferno = EnumHelper.addArmorMaterial("INFERNO", "inferno", 20, new int[] {3, 6, 4, 4}, 8);
	  feeder = EnumHelper.addToolMaterial("FEEDER", 3, 500, 2.5F, 3.5F, 20);
	}
    
	public static MBCreativeTab tabMB = new MBCreativeTab();
	
}
