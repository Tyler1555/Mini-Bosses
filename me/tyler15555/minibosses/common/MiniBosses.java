package me.tyler15555.minibosses.common;

import java.awt.Color;
import java.util.HashMap;

import me.tyler15555.minibosses.block.MBBlocks;
import me.tyler15555.minibosses.entity.EntityCrawler;
import me.tyler15555.minibosses.entity.EntityFeeder;
import me.tyler15555.minibosses.entity.EntityForestGuard;
import me.tyler15555.minibosses.entity.EntityGlider;
import me.tyler15555.minibosses.entity.EntityInfernoGolem;
import me.tyler15555.minibosses.entity.EntityIronZombie;
import me.tyler15555.minibosses.entity.EntityLivingBlock;
import me.tyler15555.minibosses.entity.EntitySprout;
import me.tyler15555.minibosses.entity.EntityStealthCreeper;
import me.tyler15555.minibosses.entity.EntitySuperSlime;
import me.tyler15555.minibosses.entity.EntityTombGuard;
import me.tyler15555.minibosses.entity.EntityWatcher;
import me.tyler15555.minibosses.item.MBItems;
import me.tyler15555.minibosses.network.PacketHandler;
import me.tyler15555.minibosses.util.ConfigHelper;
import me.tyler15555.minibosses.util.MicroBossProperties;
import me.tyler15555.minibosses.util.Resources;
import net.minecraft.command.ServerCommandManager;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.monster.EntityGiantZombie;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.common.ChestGenHooks;
import net.minecraftforge.common.DungeonHooks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.core.Logger;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLInterModComms.IMCEvent;
import cpw.mods.fml.common.event.FMLInterModComms.IMCMessage;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid = "MiniBosses", name = "Mini-Bosses", version = "v1.1.2")
public class MiniBosses {
	
	public static org.apache.logging.log4j.Logger logger;

	@Instance("MiniBosses")
	public static MiniBosses instance;
	@SidedProxy(clientSide = "me.tyler15555.minibosses.client.ClientProxy", serverSide = "me.tyler15555.minibosses.common.CommonProxy")
	public static CommonProxy proxy;
	
	public static HashMap<String, Integer> entityBanMap = new HashMap();
	
	@EventHandler
	public void preLoad(FMLPreInitializationEvent event) {
		event.getModLog().log(Level.INFO, "Mini-Bosses is starting to load!");
		logger = event.getModLog();
		
		ConfigHelper.setupConfig(new Configuration(event.getSuggestedConfigurationFile()), event.getModLog());
		
		Resources.setupArmorMaterials();
		
		GameRegistry.registerItem(MBItems.ingotDarkIron, "ingotDarkIron");
		GameRegistry.registerItem(MBItems.darkIronHelm, "darkIronHelm");
		GameRegistry.registerItem(MBItems.darkIronChest, "darkIronChest");
		GameRegistry.registerItem(MBItems.darkIronLegs, "darkIronLegs");
		GameRegistry.registerItem(MBItems.darkIronBoots, "darkIronBoots");
		GameRegistry.registerItem(MBItems.occulus_item, "itemOcculus");
		GameRegistry.registerItem(MBItems.ingotInferno, "ingotInferno");
		GameRegistry.registerItem(MBItems.infernoHelm, "infernoHelm");
		GameRegistry.registerItem(MBItems.infernoChest, "infernoChest");
		GameRegistry.registerItem(MBItems.infernoLegs, "infernoLegs");
		GameRegistry.registerItem(MBItems.infernoBoots, "infernoBoots"); 
		GameRegistry.registerItem(MBItems.feederTooth, "feederTooth"); 
		GameRegistry.registerItem(MBItems.feederSword, "feederSword"); 
		
		GameRegistry.registerBlock(MBBlocks.blockSlime, "blockSlime");
		GameRegistry.registerBlock(MBBlocks.cryptStone, "cryptStone");
	}
	
	@EventHandler
	public void loadMod(FMLInitializationEvent event) {
		PacketHandler.init();
		
		proxy.registerRenderers();
		proxy.registerKeyBindings();
		
		OreDictionary.registerOre("ingotDarkIron", MBItems.ingotDarkIron);
		OreDictionary.registerOre("ingotInferno", MBItems.ingotInferno);
		
		MinecraftForge.EVENT_BUS.register(new MBEventHandler());
		
		EntityRegistry.registerGlobalEntityID(EntityIronZombie.class, "MB-IronZombie", EntityRegistry.findGlobalUniqueEntityId(), Color.GRAY.getRGB(), Color.BLACK.getRGB());
		EntityRegistry.registerGlobalEntityID(EntityCrawler.class, "MB-Crawler", EntityRegistry.findGlobalUniqueEntityId(), Color.RED.getRGB(), Color.BLACK.getRGB());
		EntityRegistry.registerGlobalEntityID(EntitySuperSlime.class, "MB-SuperSlime", EntityRegistry.findGlobalUniqueEntityId(), Color.GREEN.getRGB(), Color.CYAN.getRGB());
		EntityRegistry.registerGlobalEntityID(EntityForestGuard.class, "MB-ForestGuard", EntityRegistry.findGlobalUniqueEntityId(), Color.GREEN.getRGB(), Color.WHITE.getRGB());
		EntityRegistry.registerGlobalEntityID(EntityStealthCreeper.class, "MB-StealthCreeper", EntityRegistry.findGlobalUniqueEntityId(), Color.WHITE.getRGB(), Color.GRAY.getRGB());
		EntityRegistry.registerGlobalEntityID(EntityLivingBlock.class, "MB-LivingBlock", EntityRegistry.findGlobalUniqueEntityId());
		EntityRegistry.registerGlobalEntityID(EntityWatcher.class, "MB-Watcher", EntityRegistry.findGlobalUniqueEntityId(), Color.BLACK.getRGB(), Color.WHITE.getRGB());
		EntityRegistry.registerGlobalEntityID(EntityFeeder.class, "MB-Feeder", EntityRegistry.findGlobalUniqueEntityId(), Color.RED.getRGB(), Color.WHITE.getRGB());
		EntityRegistry.registerGlobalEntityID(EntityGlider.class, "DEBUG_ENTITY", EntityRegistry.findGlobalUniqueEntityId(), Color.BLACK.getRGB(), Color.BLACK.getRGB());
		EntityRegistry.registerGlobalEntityID(EntityTombGuard.class, "MB-TombGuard", EntityRegistry.findGlobalUniqueEntityId());
		EntityRegistry.registerGlobalEntityID(EntityInfernoGolem.class, "MB-InfernoGolem", EntityRegistry.findGlobalUniqueEntityId(), Color.RED.getRGB(), Color.LIGHT_GRAY.getRGB());
		EntityRegistry.registerGlobalEntityID(EntitySprout.class, "MB-Sprout", EntityRegistry.findGlobalUniqueEntityId());
		
		EntityRegistry.addSpawn(EntityIronZombie.class, ConfigHelper.ironZombieSpawnRate, 1, 1, EnumCreatureType.monster, BiomeDictionary.getBiomesForType(Type.PLAINS));
		EntityRegistry.addSpawn(EntitySuperSlime.class, ConfigHelper.superSlimeSpawnRate, 1, 1, EnumCreatureType.monster, BiomeDictionary.getBiomesForType(Type.SWAMP));
		EntityRegistry.addSpawn(EntityForestGuard.class, ConfigHelper.forestGuardSpawnRate, 1, 1, EnumCreatureType.monster, BiomeDictionary.getBiomesForType(Type.FOREST));
		EntityRegistry.addSpawn(EntityCrawler.class, ConfigHelper.crawlerSpawnRate, 1, 1, EnumCreatureType.monster, BiomeDictionary.getBiomesForType(Type.PLAINS));
		EntityRegistry.addSpawn(EntityStealthCreeper.class, ConfigHelper.stealthCreeperSpawnRate, 1, 1, EnumCreatureType.creature, BiomeDictionary.getBiomesForType(Type.JUNGLE));
		EntityRegistry.addSpawn(EntityFeeder.class, 0, 1, 1, EnumCreatureType.monster, BiomeDictionary.getBiomesForType(Type.JUNGLE));
		EntityRegistry.addSpawn(EntityInfernoGolem.class, ConfigHelper.infernoGolemSpawnRate, 1, 4, EnumCreatureType.monster, BiomeDictionary.getBiomesForType(Type.NETHER));
		
		if(ConfigHelper.allowSlimeBlockCrafting) {
			GameRegistry.addRecipe(new ItemStack(MBBlocks.blockSlime, 2), new Object[] {"sss", "sss", "sss", 's', Items.slime_ball});
		}
		if(ConfigHelper.enableGiantSpawn) {
			EntityRegistry.addSpawn(EntityGiantZombie.class, ConfigHelper.giantSpawnRate, 1, 1, EnumCreatureType.monster, BiomeDictionary.getBiomesForType(Type.PLAINS));
		}
		if(ConfigHelper.addMiniBossesToDungeons) {
			DungeonHooks.addDungeonMob("MB-IronZombie", 50);
			DungeonHooks.addDungeonMob("MB-ForestGuard", 50);
		}
		if(ConfigHelper.addLootToDungeons) {
			ChestGenHooks.addItem(ChestGenHooks.DUNGEON_CHEST, new WeightedRandomChestContent(new ItemStack(MBItems.ingotDarkIron, 3), 1, 10, 10));
		}
		GameRegistry.addRecipe(new ShapedOreRecipe(MBItems.darkIronHelm, new Object[] {"iii", "i i", "xxx", 'i', "ingotDarkIron"}));
		GameRegistry.addRecipe(new ShapedOreRecipe(MBItems.darkIronChest, new Object[] {"i i", "iii", "iii", 'i', "ingotDarkIron"}));
		GameRegistry.addRecipe(new ShapedOreRecipe(MBItems.darkIronLegs, new Object[] {"iii", "i i", "i i", 'i', "ingotDarkIron"}));
		GameRegistry.addRecipe(new ShapedOreRecipe(MBItems.darkIronBoots, new Object[] {"xxx", "i i", "i i", 'i', "ingotDarkIron"}));
		GameRegistry.addRecipe(new ShapedOreRecipe(MBItems.infernoHelm, new Object[] {"iii", "i i", "xxx", 'i', "ingotInferno"}));
		GameRegistry.addRecipe(new ShapedOreRecipe(MBItems.infernoChest, new Object[] {"i i", "iii", "iii", 'i', "ingotInferno"}));
		GameRegistry.addRecipe(new ShapedOreRecipe(MBItems.infernoLegs, new Object[] {"iii", "i i", "i i", 'i', "ingotInferno"}));
		GameRegistry.addRecipe(new ShapedOreRecipe(MBItems.infernoBoots, new Object[] {"xxx", "i i", "i i", 'i', "ingotInferno"})); 
		
		GameRegistry.registerWorldGenerator(new MBWorldGenerator(), 1);
	}
	
	@EventHandler
	public void finishLoading(FMLPostInitializationEvent event) {
		logger.log(Level.INFO, "Mini-Bosses has finished loading!");
	}
	
	@EventHandler
	public void handleIMC(IMCEvent event) {
		for(IMCMessage message : event.getMessages()) {
			if(message.isStringMessage() && message.getStringValue().contains(":")) {
				String[] data = message.getStringValue().split(":");
				
				entityBanMap.put(data[0], Integer.valueOf(data[1]));
			}
			logger.log(Level.INFO, "Mod: " + message.getSender() + " has sent a ban request!");
		}
	}
	
	@EventHandler
	public void onServerStart(FMLServerStartingEvent event) {
		MinecraftServer server = event.getServer();
		ServerCommandManager manager = (ServerCommandManager)server.getCommandManager();
		
		manager.registerCommand(new CommandMiniBosses());
	}
	
	public static int createDarkIronRenderPrefix() {
		return proxy.registerDarkArmorRenderPrefix();
	}
	
	public static int createInfernoRenderPrefix() {
		return proxy.registerInfernoArmorRenderPrefix();
	}
	
}
