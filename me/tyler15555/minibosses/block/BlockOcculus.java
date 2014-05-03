package me.tyler15555.minibosses.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.world.World;

public class BlockOcculus extends Block {

	public BlockOcculus() {
		super(Material.rock);
		setTickRandomly(true);
		setBlockTextureName("minibosses:occulus_block");
		setBlockName("blockOcculus");
	}
	
	@Override
	public void onEntityCollidedWithBlock(World world, int x, int y, int z, Entity entity) {
		if(entity instanceof EntityLightningBolt && !world.isRemote) {
			entity.dropItem(null, 1);
		}
	}

}
