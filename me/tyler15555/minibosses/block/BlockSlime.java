package me.tyler15555.minibosses.block;

import me.tyler15555.minibosses.util.Resources;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.common.util.ForgeDirection;

public class BlockSlime extends Block {

	public BlockSlime() {
		super(Material.sponge);
		setUnlocalizedName("blockFertileSlime");
		setBlockTextureName("minibosses:slime_block");
		setCreativeTab(Resources.tabMB);
	}
	
	@Override
	public boolean isFertile(World world, BlockPos pos) {
		return true;
	}
	
	@Override
	public boolean isBeaconBase(IBlockAccess worldObj, BlockPos pos, BlockPos beaconPos) {
		return true;
	}
	
	@Override
	public boolean canSustainPlant(IBlockAccess world, BlockPos pos, EnumFacing direction, IPlantable plantable) {
		EnumPlantType type = plantable.getPlantType(world, pos);
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
