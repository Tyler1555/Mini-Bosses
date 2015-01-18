package me.tyler15555.minibosses.item;

import java.util.List;

import me.tyler15555.minibosses.util.NBTHelper;
import me.tyler15555.minibosses.util.Resources;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;

public class ItemDodgeGem extends Item {

	public ItemDodgeGem() {
		setUnlocalizedName("dodgeGem");
		setCreativeTab(Resources.tabMB);
	}
	
	@Override
	public boolean isBeaconPayment(ItemStack stack) {
		return true;
	}
	
	@Override
	public int getEntityLifespan(ItemStack itemStack, World world) {
        return this.hasHolder(itemStack) == 1 ? 60 : 6000;
    }
	
	@Override
	public void addInformation(ItemStack stack, EntityPlayer playerIn, List tooltip, boolean advanced) {
		tooltip.add(EnumChatFormatting.GOLD + "Legendary");
		tooltip.add(EnumChatFormatting.DARK_PURPLE + "This gem causes its holder");
		tooltip.add(EnumChatFormatting.DARK_PURPLE + "to avoid enemy attacks.");
		tooltip.add(EnumChatFormatting.DARK_PURPLE + "However it cannot survive");
		tooltip.add(EnumChatFormatting.DARK_PURPLE + "long without a holder.");
	}
	
	public int hasHolder(ItemStack stack) {
		return NBTHelper.getIntFromStack(stack, "ShortDespawn");
	}
	
	@Override
	public boolean onDroppedByPlayer(ItemStack item, EntityPlayer player) {
		NBTHelper.writeIntToStack(item, "ShortDespawn", 1);
		return true;
	}

}
