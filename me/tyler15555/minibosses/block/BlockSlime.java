package me.tyler15555.minibosses.block;

import me.tyler15555.minibosses.util.Resources;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.common.util.ForgeDirection;

public class BlockSlime extends Block {

	public BlockSlime() {
		super(Material.sponge);
		setBlockName("blockSlime");
		setBlockTextureName("minibosses:slime_block");
		setCreativeTab(Resources.tabMB);
	}
	
	@Override
	public void onPlantGrow(World world, int x, int y, int z, int sourceX, int sourceY, int sourceZ) {
		world.spawnParticle("largesmoke", (double)x, (double)y, (double)z, 0, 0, 0);
	}
	
	@Override
	public boolean isFertile(World world, int x, int y, int z) {
		return true;
	}
	
	@Override
	public boolean isBeaconBase(IBlockAccess worldObj, int x, int y, int z, int beaconX, int beaconY, int beaconZ) {
		return true;
	}
	
	@Override
	public boolean canSustainPlant(IBlockAccess world, int x, int y, int z, ForgeDirection direction, IPlantable plantable) {
		EnumPlantType type = plantable.getPlantType(world, x, y, z);
		switch(type) {
		case Water:
			return true;
		case Beach:
			return true;
		case Crop:
			return true;
		default:
			return false;
		}
	}

}
