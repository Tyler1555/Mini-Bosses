package me.tyler15555.minibosses.util;

import net.minecraftforge.common.config.Configuration;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.Logger;

public class ConfigHelper {

	public ConfigHelper() {
		
	}
	
	public static boolean allowSlimeBlockCrafting;
	public static boolean enableGiantSpawn;
	public static boolean microBossesEnabled;
	public static boolean powersEnabled;
	public static int ironZombieSpawnRate;
	public static int forestGuardSpawnRate;
	public static int crawlerSpawnRate;
	public static int superSlimeSpawnRate;
	public static int stealthCreeperSpawnRate;
	public static int giantSpawnRate;
	public static int feederSpawnRate;
	public static int infernoGolemSpawnRate;
	public static boolean addMiniBossesToDungeons;
	public static boolean addLootToDungeons;
	public static boolean ironZombieFix;
	public static boolean enableLivingBlocks;
	public static int mobLootRarity;
	public static boolean canFeederEatSword;
	
	public static void setupConfig(Configuration config, Logger logger) {
		try {
			config.load();
			allowSlimeBlockCrafting = config.get("General", "allowSlimeBlockCrafting", false).getBoolean(false);
			microBossesEnabled = config.get("Entities", "microBossesEnabled", true).getBoolean(true);
			ironZombieSpawnRate = config.get("Spawning", "ironZombieSpawnRate", 10).getInt(10);
			forestGuardSpawnRate = config.get("Spawning", "forestGuardSpawnRate", 10).getInt(10);
			crawlerSpawnRate = config.get("Spawning", "crawlerSpawnRate", 10).getInt(10);
			superSlimeSpawnRate = config.get("Spawning", "superSlimeSpawnRate", 10).getInt(10);
			stealthCreeperSpawnRate = config.get("Spawning", "stealthCreeperSpawnRate", 10).getInt(10);
			enableGiantSpawn = config.get("Spawning", "enableGiantSpawn", false).getBoolean(false);
			giantSpawnRate = config.get("Spawning", "giantSpawnRate", 10).getInt(10);
			feederSpawnRate = config.get("Spawning", "feederSpawnRate", 10).getInt(10);
			infernoGolemSpawnRate = config.get("Spawning", "infernoGolemSpawnRate", 10).getInt(10);
			addMiniBossesToDungeons = config.get("General", "addMiniBossesToDungeons", true).getBoolean(true);
			addLootToDungeons = config.get("General", "addLootToDungeons", true).getBoolean(true);
			powersEnabled = config.get("General", "powersEnabled", true).getBoolean(true);
			ironZombieFix = config.getBoolean("IronZombieFix", "General", false, "Kills all iron zombies in the world. Should only be used once to fix iron zombies broken in 1.8!!!!");
			enableLivingBlocks = config.getBoolean("enableLivingBlocks", "Spawning", true, "Enables/Disables living blocks from spawning.");
			mobLootRarity = config.getInt("MobLootRarity", "General", 50, 0, 100, "How rare the loot dropped by crawlers and forest guard's is. Higher numbers(X/100) means rarer items. ");
			canFeederEatSword = config.getBoolean("CanFeederEatSword", "General", true, "Whether or not the feeder can eat your sword(1/40 chance of happening)");
		} catch(Exception e) {
			logger.log(Level.ERROR, "A severe error has occured when attempting to load the config file for this mod! Some options may not be the way you set them!");
		} finally {
			if(config.hasChanged()) {
				config.save();
			}
		}
	}

}
