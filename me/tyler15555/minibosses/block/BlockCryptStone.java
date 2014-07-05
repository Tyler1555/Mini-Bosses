package me.tyler15555.minibosses.block;

import me.tyler15555.minibosses.util.Resources;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockCryptStone extends Block {

	protected BlockCryptStone() {
		super(Material.rock);
		setBlockName("cryptStone");
		setBlockTextureName("minibosses:crypt_stone");
		setCreativeTab(Resources.tabMB);
		setHarvestLevel("pickaxe", 2);
	}
	
	@Override
	public boolean isBeaconBase(IBlockAccess worldObj, int x, int y, int z, int beaconX, int beaconY, int beaconZ) {
		return true;
	}
	
	@Override
	public void onNeighborChange(IBlockAccess world, int x, int y, int z, int tileX, int tileY, int tileZ) {
		if(world.getTileEntity(tileX, tileY, tileZ) instanceof TileEntityChest) {
			//Coming soon ;)
		}
	}
	
	@Override
	public boolean isReplaceableOreGen(World world, int x, int y, int z, Block target) {
		return false;
	}
	
	@Override
	public boolean canCreatureSpawn(EnumCreatureType type, IBlockAccess world, int x, int y, int z) {
		return type == type.monster ? false : true;
	}
	
	@Override
	public void onEntityWalking(World world, int x, int y, int z, Entity entity) {
		if(entity instanceof EntityLiving) {
			EntityLiving living = (EntityLiving)entity;
			
			if(living.getCreatureAttribute() == EnumCreatureAttribute.UNDEAD) {
				living.setFire(10);
			}
		}
	}

}
