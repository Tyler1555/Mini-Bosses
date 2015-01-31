package me.tyler15555.minibosses.util;

import net.minecraft.item.ItemStack;

//More uses to come for this class eventually, first steps towards making an API for this mod. Although currently this class just has internal uses
public interface IMiniboss {

	/**
	 * Gets an ID for this entity that can be used to ban it from certain dimensions
	 * @return A name that is used to identify this entity for banning purposes, should contain no spaces
	 */
	public String getBanlistName();
	
	/**
	 * Gets all rare loot that can be dropped besides what the entity mainly drops
	 * @return The item you want dropped
	 */
	public ItemStack getPossibleLoot();
	
	/**
	 * Gets the chance of rare loot dropping. This number should not be larger than 100
	 * @return A number between 1-100 that determines whether or not this specified loot will drop. The higher the number the lower the chance of dropping.
	 */
	public int getDropChance();
	
}
