package me.tyler15555.minibosses.item;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import me.tyler15555.minibosses.util.Resources;
import me.tyler15555.minibosses.util.NBTHelper;

public class ItemSummonScroll extends Item {

	public ItemSummonScroll() {
		setCreativeTab(Resources.tabMB);
		setUnlocalizedName("summonScroll");
	}
	
	@SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, EntityPlayer player, List tooltip, boolean advanced) {
		if(stack.getTagCompound() != null && stack.getTagCompound().hasKey("SummonEntry")) {
			String[] data = NBTHelper.getStringFromStack(stack, "SummonEntry").split(":");
			tooltip.add(EnumChatFormatting.GOLD + "Summons a " + data[1]);
			tooltip.add(EnumChatFormatting.RED + "Blood Required: " + data[2]);
			tooltip.add(EnumChatFormatting.RED + "Pillar Level Required: " + data[3]);
		}
	}

}
