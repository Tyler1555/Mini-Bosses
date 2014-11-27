package me.tyler15555.minibosses.tileentity;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

public class TileEntityMedusaStone extends TileEntity {

	private String entityName;
	
	public TileEntityMedusaStone(String name) {
		entityName = name;
	}
	
	public void writeToNBT(NBTTagCompound tag) {
		super.writeToNBT(tag);
		tag.setString("name", entityName);
	}
	
	public void readFromNBT(NBTTagCompound tag) {
		super.readFromNBT(tag);
		entityName = tag.getString("name");
	}
	
	 public boolean canUpdate() {
		 return false;
	 }

}
