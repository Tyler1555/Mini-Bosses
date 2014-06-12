package me.tyler15555.minibosses.common;

import java.util.Random;

import me.tyler15555.minibosses.util.Resources;
import me.tyler15555.minibosses.util.WorldGenHelper;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.tileentity.TileEntityMobSpawner;
import net.minecraft.util.MathHelper;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraft.world.EnumSkyBlock;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraftforge.common.ChestGenHooks;
import net.minecraftforge.common.DungeonHooks;
import cpw.mods.fml.common.IWorldGenerator;

public class MBWorldGenerator implements IWorldGenerator {

	public MBWorldGenerator() {
		
	}

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		switch(world.provider.dimensionId) {
		case 0:
			generateSurface(world, chunkX, chunkZ, random);
		}
	}
	
	private void generateSurface(World world, int chunkX, int chunkZ, Random random) {
		int posX = random.nextInt(16) + chunkX;
		int posY = random.nextInt(80);
		int posZ = random.nextInt(16) + chunkZ;
		
		if(world.getBlock(posX, posY, posZ) == Blocks.grass) {
			WorldGenHelper.generateCorner(world, posX, posY - 5, posZ, Blocks.stonebrick, 7, 7, 7);
			
			world.setBlock(posX + 2, posY - 5, posZ + 6, Blocks.mob_spawner);
			world.setBlock(posX + 4, posY - 5, posZ + 6, Blocks.mob_spawner);
			world.setBlock(posX, posY - 7, posZ, Blocks.chest);
			
			//world.setLightValue(EnumSkyBlock.Block, posX + 2, posY - 5, posZ + 6, 0);
			//world.setLightValue(EnumSkyBlock.Block, posX + 4, posY - 5, posZ + 6, 0);
			
			TileEntityMobSpawner spawner1 = (TileEntityMobSpawner) world.getTileEntity(posX + 2, posY - 5, posZ + 6);
			TileEntityMobSpawner spawner2 = (TileEntityMobSpawner) world.getTileEntity(posX + 4, posY - 5, posZ + 6);
			TileEntityChest chest = (TileEntityChest) world.getTileEntity(posX, posY - 7, posZ);
			
			WeightedRandomChestContent.generateChestContents(random, ChestGenHooks.getItems(ChestGenHooks.DUNGEON_CHEST, random), chest, 6);
			
			spawner1.func_145881_a().setEntityName(DungeonHooks.getRandomDungeonMob(random)); //func_whatever gets the spawner's logic
			spawner2.func_145881_a().setEntityName(DungeonHooks.getRandomDungeonMob(random));
			
			System.out.println("Generated Ruins at: " + posX + " " + posY + " " + posZ);
		}
	}

}
