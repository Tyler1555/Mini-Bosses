package me.tyler15555.minibosses.item;

import java.util.List;

import me.tyler15555.minibosses.util.NBTHelper;
import me.tyler15555.minibosses.util.Resources;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;

public class ItemReviveHeart extends Item {

	public ItemReviveHeart() {
		setUnlocalizedName("reviveHeart");
		setTextureName("minibosses:revive_heart"); //I currently have no idea how textures work in 1.8
		setCreativeTab(Resources.tabMB);
	}
	
	@Override
	public boolean onDroppedByPlayer(ItemStack item, EntityPlayer player) {
		player.attackEntityFrom(DamageSource.magic, 2.0F);
		return false;
	}
	
	
	@Override
	public int getEntityLifespan(ItemStack itemStack, World world) {
		return 3000;
	}
	
	@Override
	public boolean isValidArmor(ItemStack stack, int armorType, Entity entity) {
		return armorType == 1 ? true : false;
	}
	
	@Override
	public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack) {
		player.addPotionEffect(new PotionEffect(Potion.regeneration.id, 500));
		player.addPotionEffect(new PotionEffect(Potion.damageBoost.id, 500));
	}
	
	@Override
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean bool) {
		list.add(EnumChatFormatting.GOLD + "Legendary");
		list.add(EnumChatFormatting.DARK_PURPLE + "This heart is said to give great strength and");
		list.add(EnumChatFormatting.DARK_PURPLE + "long life to its owner");
	}
	
/*	@Override
	public void onUpdate(ItemStack stack, World world, Entity entity, int par4, boolean par5) {
		if(entity instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer)entity;
			
			if(player.getHealth() <= 1) {
				player.setHealth(player.getMaxHealth());
				stack.stackSize--;
			}
		}
	} */

}
