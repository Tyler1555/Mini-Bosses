package me.tyler15555.minibosses.util;

import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.common.IExtendedEntityProperties;

public class ExtendedPlayerProperties implements IExtendedEntityProperties {

	private int lastAbilitySaveCount = 5;
	private int currentAbilitySaveCount;
	public static String PROP_NAME = "MB-Occulus-Use-Properties";
	
	public ExtendedPlayerProperties() {
		
	}

	@Override
	public void saveNBTData(NBTTagCompound compound) {
		compound.setInteger("abilityUses", lastAbilitySaveCount);
	}

	@Override
	public void loadNBTData(NBTTagCompound compound) {
		currentAbilitySaveCount = compound.getInteger("abilityUses");
	}

	@Override
	public void init(Entity entity, World world) {

	}
	
	public void decreaseAbilityUsage() {
		--lastAbilitySaveCount;
	}
	
	public int getAbilityUsageAmount() {
		return currentAbilitySaveCount;
	}

}
