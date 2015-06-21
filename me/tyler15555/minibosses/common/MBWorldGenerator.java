package me.tyler15555.minibosses.common;

import java.util.Random;

import me.tyler15555.minibosses.block.MBBlocks;
import me.tyler15555.minibosses.util.ConfigHelper;
import me.tyler15555.minibosses.util.Resources;
import me.tyler15555.minibosses.util.WorldGenHelper;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
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
		int posX = chunkX + random.nextInt(16);
		int posY = random.nextInt(128);
		int posZ = random.nextInt(16) + chunkZ;
		
		if(ConfigHelper.enableStructureGen) {
			if(random.nextInt(100) >= 75) {
				if(random.nextInt(100) >= 80) {
					if(random.nextInt(100) >= 85) {
						if(world.getBlock(posX, posY, posZ) == Blocks.stone) {
							WorldGenHelper.generateSolidCube(world, posX, posY, posZ, MBBlocks.cryptStone, 8, 8, 8);
							world.setBlock(posX + 4, posY + 4, posZ + 4, Blocks.chest);
							
							TileEntityChest chest = (TileEntityChest) world.getTileEntity(posX + 4, posY + 4, posZ + 4);
							
							if(chest != null) { //So we don't crash the game if another structure overwrites the chest
								Item[] possibleLoot = new Item[] {Items.diamond, Items.gold_ingot, Items.iron_ingot, Items.emerald, Items.bone, Items.coal, Items.rotten_flesh, Items.carrot, Items.golden_apple};
								
								for(int i = 0; i < MathHelper.getRandomIntegerInRange(random, 1, 9); i++) {
									chest.setInventorySlotContents(i, new ItemStack(possibleLoot[random.nextInt(possibleLoot.length)], MathHelper.getRandomIntegerInRange(random, 1, 5)));
								}
							}
							//System.out.println("Generated Tomb at: " + posX + " " + posY + " " + posZ); Used for finding naturally generating structures. Uncomment this line if you want to be a dirty cheater. You dirty cheater.
						}
					}
				}
			}
		}
	}

}
