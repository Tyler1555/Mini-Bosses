package me.tyler15555.tileentity;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

public class TileEntitySummoningPillar extends TileEntity {

	private int bloodAmt;
	private int level;
	
	public TileEntitySummoningPillar() {
		
	}
	
	@Override
	public void writeToNBT(NBTTagCompound tag) {
		super.writeToNBT(tag);
		tag.setInteger("BloodAmount", bloodAmt);
		tag.setInteger("Level", level);
	}
	
	@Override
	public void readFromNBT(NBTTagCompound tag) {
		super.readFromNBT(tag);
		bloodAmt = tag.getInteger("BloodAmount");
		level = tag.getInteger("Level");
	}
	
	public void setBloodAmount(int amt) {
		bloodAmt = amt;
	}
	
	public int getBloodAmount() {
		return bloodAmt;
	}
	
	public void setPillarLevel(int i) {
		level = i;
	}
	
	public int getPillarLevel() {
		return level;
	}
	
}
