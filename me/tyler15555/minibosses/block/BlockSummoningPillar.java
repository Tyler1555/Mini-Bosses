package me.tyler15555.minibosses.block;

import java.lang.reflect.InvocationTargetException;

import org.apache.logging.log4j.Level;

import me.tyler15555.minibosses.common.MiniBosses;
import me.tyler15555.minibosses.item.MBItems;
import me.tyler15555.minibosses.util.Resources;
import me.tyler15555.minibosses.util.NBTHelper;
import me.tyler15555.minibosses.util.SummonEntry;
import me.tyler15555.tileentity.TileEntitySummoningPillar;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.relauncher.Side;

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
			if(player.getHeldItem().getItem() == MBItems.summonScroll && FMLCommonHandler.instance().getEffectiveSide() == Side.SERVER) {
				TileEntitySummoningPillar pillar = (TileEntitySummoningPillar)world.getTileEntity(pos);
				String[] summonData = NBTHelper.getStringFromStack(player.getHeldItem(), "SummonEntry").split(":");
				try {
					SummonEntry summon = new SummonEntry(Class.forName(summonData[0]), summonData[1], Integer.valueOf(summonData[2]), Integer.valueOf(summonData[3]));
					summon.doSummon(pillar.getBloodAmount(), pillar.getPillarLevel(), world, pos.getX(), pos.getY(), pos.getZ());
				} catch (NumberFormatException e) {
					MiniBosses.logger.log(Level.WARN, "An invalid number was encountered while processing a summon entry! Ignoring...");
					e.printStackTrace();
					return false;
				} catch (ClassNotFoundException e) {
					MiniBosses.logger.log(Level.WARN, "The entity class: " + summonData[0] + "specified in this summon was not found! Ignoring...");
					e.printStackTrace();
					return false;
				} catch (InstantiationException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					e.printStackTrace();
				} catch (NoSuchMethodException e) {
					e.printStackTrace();
				} catch (SecurityException e) {
					e.printStackTrace();
				}
			}
			return true;
		} else {
			return false;
		}
	}
	
	@Override
	public boolean isOpaqueCube() {
		return false;
	}
	
	@Override
	public int getRenderType() {
		return 3;
	}
	/*
	@Override
	public IBlockState onBlockPlaced(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer) {
		super.onBlockPlaced(worldIn, pos, facing, hitX, hitY, hitZ, meta, placer);
		TileEntitySummoningPillar pillar = (TileEntitySummoningPillar) worldIn.getTileEntity(pos);
		//pillar.setPillarLevel(0);
		return this.getDefaultState();
	} */
}
