package me.tyler15555.minibosses.block;

import com.google.common.base.Predicate;

import me.tyler15555.minibosses.entity.EntityTombGuard;
import me.tyler15555.minibosses.util.Resources;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLiving.SpawnPlacementType;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.util.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockCryptStone extends Block {

	protected BlockCryptStone() {
		super(Material.rock);
		setUnlocalizedName("cryptStone");
		setCreativeTab(Resources.tabMB);
		setHarvestLevel("pickaxe", 2);
	}
	
	@Override
	public boolean isBeaconBase(IBlockAccess worldObj, BlockPos pos, BlockPos beaconPOS) {
		return true;
	}
	
	@Override
	public void onNeighborChange(IBlockAccess world, BlockPos pos, BlockPos nextPOS) {
		if(world.getTileEntity(nextPOS) instanceof TileEntityChest) {
			for(int i = 0; i < 3; i++) {
				EntityTombGuard guard = new EntityTombGuard((World) world);
				guard.setLocationAndAngles(pos.getX(), pos.getY(), pos.getZ(), 0.0F, 0.0F);
				World _world = (World)world;
				_world.spawnEntityInWorld(guard);
			}
		}
	}
	
	@Override
	public boolean isReplaceableOreGen(World world, BlockPos pos, Predicate<IBlockState> target) {
		return false;
	}
	
	@Override
	public boolean canCreatureSpawn(IBlockAccess world, BlockPos pos, SpawnPlacementType type) {
		return type == type.ON_GROUND ? false : true;
	}
	
	@Override
	public void onEntityCollidedWithBlock(World world, BlockPos pos, Entity entity) {
		if(entity instanceof EntityLiving) {
			EntityLiving living = (EntityLiving)entity;
			
			if(living.getCreatureAttribute() == EnumCreatureAttribute.UNDEAD) {
				living.setFire(10);
			}
		}
	}

}
