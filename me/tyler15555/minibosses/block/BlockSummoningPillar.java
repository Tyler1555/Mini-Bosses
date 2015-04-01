package me.tyler15555.minibosses.block;

import me.tyler15555.minibosses.common.MiniBosses;
import me.tyler15555.minibosses.item.MBItems;
import me.tyler15555.minibosses.util.Resources;
import me.tyler15555.tileentity.TileEntitySummoningPillar;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

public class BlockSummoningPillar extends BlockContainer {

	public BlockSummoningPillar() {
		super(Material.rock);
		setCreativeTab(Resources.tabMB);
		setUnlocalizedName("summoningPillar");
	}

	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return new TileEntitySummoningPillar();
	}
	
	@Override
	public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumFacing side, float hitX, float hitY, float hitZ) {
		if(world.getTileEntity(pos) != null) {
			if(player.getHeldItem().getItem() == MBItems.summonScroll) {
				
			}
			return true;
		} else {
			return false;
		}
	}

}
