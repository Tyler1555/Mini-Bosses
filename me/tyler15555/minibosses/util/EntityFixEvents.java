package me.tyler15555.minibosses.util;

import org.apache.logging.log4j.Level;

import me.tyler15555.minibosses.common.MiniBosses;
import me.tyler15555.minibosses.entity.EntityIronZombie;
import net.minecraft.entity.Entity;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraftforge.event.world.WorldEvent.Load;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import com.google.common.base.Predicate;
//This class exists to purge entities that were broken by updates to either MC or this mod. Although at the moment this class currently does not work :(
public class EntityFixEvents {

	public EntityFixEvents() {
		
	}
	
	@SubscribeEvent
	public void onWorldLoad(Load event) {
		if(true) {
			Predicate<Entity> filter = new Predicate<Entity>() {

				@Override
				public boolean apply(Entity input) {
					
					return input.getClass() == EntityIronZombie.class;
				}
				
			};
			MiniBosses.logger.log(Level.INFO, "Config value IronZombieFix enabled! Searching for entities to purge...");
			MiniBosses.logger.log(Level.INFO, "Found " + event.world.getEntities(EntityIronZombie.class, filter).size() + " entities to purge! Starting purge...");
			for(int i = 0; i < event.world.getEntities(EntityIronZombie.class, filter).size(); i++) {
				EntityZombie zombie = (EntityZombie) event.world.getEntities(EntityIronZombie.class, filter).get(i);
				System.out.println("TEST");
				zombie.setDead();
			}
			MiniBosses.logger.log(Level.INFO, "Purged all entities! If you have more worlds to purge, load them. When you are done purging all worlds, make sure you set IronZombieFix to false!");
		}
	}

}
