package me.tyler15555.minibosses.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import me.tyler15555.minibosses.client.MBCreativeTab;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.util.EnumHelper;

public class Resources {

	public Resources() {
		
	}
	public static ArmorMaterial dark_iron;
	
	//Stores mod's request to not allow an entity to spawn in a certain dimension. Messages should be formatted as EntityName|DimensionID
	public static HashMap<String, Integer> entityBlockList = new HashMap();
	
	//Used to store the IDs of mod entities that would like to be in this mod's dungeons dungeons
	public static ArrayList<String> dungeonMobList = new ArrayList();
	
	
	public static String[] firstNames = new String[] {"Based Doge", "Occulus", "Lord", "Destroyer", "Darkness", "Queen", "Steve", "Tom", "LaKeesha", "Doge", "tyler15555", "2withyoda"};
	public static String[] lastNames = new String[] {"Venice", "Worlds", "The World", "Earth", "The Galaxy", "Your Mom", "The Woods", "Mountains", "Rivers"};
	
	public static String generateRandomName(Random random) {
		String ret = firstNames[random.nextInt(firstNames.length)] + " of " + lastNames[random.nextInt(lastNames.length)];
		return ret;
	}
	
	public static void setupArmorMaterials() {
	  dark_iron = EnumHelper.addArmorMaterial("DARKIRON", 22, new int[] {3, 7, 5, 4}, 25);
	}
    
	public static MBCreativeTab tabMB = new MBCreativeTab();
	
}
