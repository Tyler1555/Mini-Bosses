package me.tyler15555.minibosses.util;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.Logger;

import net.minecraftforge.common.config.Configuration;

public class ConfigHelper {

	public ConfigHelper() {
		
	}
	
	public static boolean allowSlimeBlockCrafting;
	public static boolean enableGiantSpawn;
	public static boolean microBossesEnabled;
	public static int ironZombieSpawnRate;
	public static int forestGuardSpawnRate;
	public static int crawlerSpawnRate;
	public static int superSlimeSpawnRate;
	public static int stealthCreeperSpawnRate;
	public static int giantSpawnRate;
	
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
		} catch(Exception e) {
			logger.log(Level.ERROR, "A severe error has occured when attempting to load the config file for this mod! Some options may not be the way you set them!");
		} finally {
			if(config.hasChanged()) {
				config.save();
			}
		}
	}

}
