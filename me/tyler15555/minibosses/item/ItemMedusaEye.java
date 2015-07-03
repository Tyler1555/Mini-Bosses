package me.tyler15555.minibosses.item;

import java.util.List;

import me.tyler15555.minibosses.util.Resources;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.entity.boss.EntityWither;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemMedusaEye extends Item {

	public ItemMedusaEye() {
		setUnlocalizedName("medusaEye");
	}
	
	@SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, EntityPlayer playerI, List tooltip, boolean advanced) {
		tooltip.add(EnumChatFormatting.DARK_BLUE + "Rare");
		tooltip.add(EnumChatFormatting.DARK_PURPLE + "The eye of the slain Medusa.");
		tooltip.add(EnumChatFormatting.DARK_PURPLE + "It is rumored to turn enemies into stone");
	}
	
	//Since the entity is turned into stone, there is no need to actually damage it. Behold, my optimization
	@Override
	public boolean onLeftClickEntity(ItemStack stack, EntityPlayer player, Entity entity) { 
        if(entity instanceof EntityPlayer || entity instanceof EntityDragon || entity instanceof EntityWither) {
        	if(FMLCommonHandler.instance().getSide() == Side.SERVER) player.addChatMessage(new ChatComponentText("This entity is too powerful to be affected by the eye!"));
        	return false;
        } else {
        	entity.worldObj.setBlockState(new BlockPos(entity.posX, entity.posY, entity.posZ), Blocks.stone.getDefaultState());
            entity.setDead();
            player.destroyCurrentEquippedItem();
            return true;
        }
    }
	
	@Override
	public CreativeTabs[] getCreativeTabs() {
		return new CreativeTabs[] {Resources.tabMB, CreativeTabs.tabCombat};
	}

}
