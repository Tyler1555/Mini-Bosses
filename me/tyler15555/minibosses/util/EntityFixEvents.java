package me.tyler15555.minibosses.util;

import me.tyler15555.minibosses.common.MiniBosses;
import me.tyler15555.minibosses.entity.EntityIronZombie;
import net.minecraft.entity.Entity;
import net.minecraftforge.event.world.WorldEvent.Save;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import org.apache.logging.log4j.Level;




//This class exists to purge entities that were broken by updates to either MC or this mod, or to apply other entity work arounds due to changes in MC.
public class EntityFixEvents {

	public EntityFixEvents() {
		
	}
	
	@SubscribeEvent
	public void onWorldSaved(Save event) {
		if(ConfigHelper.ironZombieFix) { //Iron Zombie 1.8 fix
			MiniBosses.logger.log(Level.INFO, "Config value IronZombieFix enabled! Searching for entities to purge...");
			for(Object entityObj : event.world.loadedEntityList) {
				Entity entity = (Entity)entityObj;
				
				if(entity instanceof EntityIronZombie) {
					event.world.removeEntity(entity);
				}
			}
			MiniBosses.logger.log(Level.INFO, "Purged all entities! If you have more worlds to purge, load them. When you are done purging all worlds, make sure you set IronZombieFix to false!");
		}
	}
}
