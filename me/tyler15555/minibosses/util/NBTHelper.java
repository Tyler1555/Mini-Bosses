package me.tyler15555.minibosses.util;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public class NBTHelper {

	public NBTHelper() {
		
	}
	
	private static void createNBTData(ItemStack stack) {
		if(stack.stackSize == 1 && stack.stackTagCompound == null) {
			stack.setTagCompound(new NBTTagCompound());
		} else {
			return;
		}
	}
	
	public static void writeIntToStack(ItemStack stack, String key, int val) {
		createNBTData(stack);
		stack.getTagCompound().setInteger(key, val);
	}
	
	public static int getIntFromStack(ItemStack stack, String key) {
		if(stack.getTagCompound() == null) {
			return 0;
		} else {
			return stack.getTagCompound().getInteger(key);
		}
	}
	
	public static void writeStringToStack(ItemStack stack, String key, String val) {
		createNBTData(stack);
		stack.getTagCompound().setString(key, val);
	}
	
	public static String getStringFromStack(ItemStack stack, String key) {
		if(stack.getTagCompound() == null) {
			return "";
		} else {
			return stack.getTagCompound().getString(key);
		}
	}

}
