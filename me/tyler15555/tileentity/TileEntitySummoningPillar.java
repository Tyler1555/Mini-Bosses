package me.tyler15555.tileentity;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.relauncher.Side;

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
	
	@Override
	public Packet getDescriptionPacket() {
		NBTTagCompound syncData = new NBTTagCompound();
		this.writeToNBT(syncData);
		
		return new S35PacketUpdateTileEntity(this.getPos(), 0, syncData);
	}
	
	@Override
	public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity pkt) {
		if(FMLCommonHandler.instance().getEffectiveSide() == Side.CLIENT) {
			this.readFromNBT(pkt.getNbtCompound());
		} else {
			//Never trust the client
			return;
		}
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
