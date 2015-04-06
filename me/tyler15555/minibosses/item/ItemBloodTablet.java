package me.tyler15555.minibosses.item;

import java.util.List;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import me.tyler15555.minibosses.util.NBTHelper;
import me.tyler15555.minibosses.util.Resources;

public class ItemBloodTablet extends Item {

	public ItemBloodTablet() {
		setCreativeTab(Resources.tabMB);
		setUnlocalizedName("bloodTablet");
	}
	
	@SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, EntityPlayer player, List tooltip, boolean advanced) {
		if(stack.getTagCompound() != null && stack.getTagCompound().hasKey("BloodAmount")) {
			tooltip.add(EnumChatFormatting.RED + "Blood Contained: " + NBTHelper.getIntFromStack(stack, "BloodAmount") + " Units");
		} else {
			tooltip.add(EnumChatFormatting.RED + "No blood contained");
		}
	}
	
	@Override
	 public boolean onLeftClickEntity(ItemStack stack, EntityPlayer player, Entity entity) {
		NBTHelper.writeIntToStack(stack, "BloodAmount", NBTHelper.getIntFromStack(stack, "BloodAmount") + 1);
		return false;
	}
}
