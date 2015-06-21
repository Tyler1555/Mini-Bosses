package me.tyler15555.minibosses.util;
//More uses to come for this class eventually, first steps towards making an API for this mod. Although currently this class just has internal uses
public interface IMiniboss {

	/**
	 * Gets an ID for this entity that can be used to ban it from certain dimensions
	 * @return A name that is used to identify this entity for banning purposes, should contain no spaces
	 */
	public String getBanlistName();
	
}
