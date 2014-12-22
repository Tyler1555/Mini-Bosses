package me.tyler15555.minibosses.util;

import net.minecraft.block.Block;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;

public class WorldGenHelper {

	public WorldGenHelper() {
		
	}
	
	public static void generatePillar(World world, int x, int y, int z, int height, Block block) {
		for(int i = 0; i < height; i++) {
			world.setBlockState(new BlockPos(x, y + i, z), block.getDefaultState()); 
		}
	}
	
	public static void generateWall(World world, int x, int y, int z, Block block, int height, int width) {
		for(int i = 0; i < width; i++) {
			for(int j = 0; j < height; j++) {
				generatePillar(world, x + i, y , z, j, block);
			}
		}
	}
	
	public static void generateSolidCube(World world, int x, int y, int z, Block block, int height, int width, int volume) {
		for(int i = 0; i < width; i++) {
			for(int j = 0; j < height; j++) {
				for(int k = 0; k < volume; k++) {
					world.setBlockState(new BlockPos(x + i, y + j, z + k), block.getDefaultState());
				}
			}
		}
	}
}
