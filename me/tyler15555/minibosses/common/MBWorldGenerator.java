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
		
	}

}
