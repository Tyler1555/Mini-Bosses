package me.tyler15555.minibosses.block;

import me.tyler15555.minibosses.tileentity.TileEntityMedusaStone;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockMedusaStone extends BlockContainer {

	private String entityName;
	
	public BlockMedusaStone() {
		super(Material.rock);
	}
	
	public BlockMedusaStone(String name) {
		super(Material.rock);
		entityName = name;
	}

	@Override
	public TileEntity createNewTileEntity(World world, int i) {
		return new TileEntityMedusaStone(entityName);
	}

}
