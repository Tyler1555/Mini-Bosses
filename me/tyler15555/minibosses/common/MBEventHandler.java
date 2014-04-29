package me.tyler15555.minibosses.common;

import java.util.Random;

import me.tyler15555.minibosses.entity.EntityCrawler;
import me.tyler15555.minibosses.util.MicroBossProperties;
import me.tyler15555.minibosses.util.Resources;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;



public class MBEventHandler {

	private final Random random = new Random();
	
	@SubscribeEvent
	public void onEntitySpawn(EntityJoinWorldEvent event) {
		if(event.entity instanceof EntityZombie || event.entity instanceof EntitySkeleton) {
			if(random.nextInt(19) == 1) {
				EntityLiving entity = (EntityLiving)event.entity;
				MicroBossProperties props = MicroBossProperties.generateRandomProperties();
				props.applyToEntity(entity);
				entity.setCustomNameTag(Resources.generateRandomName(random));
			}
		}
		if(event.entity instanceof EntityPlayer) {
			EntityCrawler crawler = new EntityCrawler(event.world);
			crawler.copyLocationAndAnglesFrom(event.entity);
			event.world.spawnEntityInWorld(crawler);
		}
	}
	
}
