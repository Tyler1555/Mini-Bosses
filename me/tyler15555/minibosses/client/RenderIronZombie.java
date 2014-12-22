package me.tyler15555.minibosses.client;

import me.tyler15555.minibosses.entity.EntityIronZombie;
import net.minecraft.client.model.ModelZombie;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderZombie;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.util.ResourceLocation;

public class RenderIronZombie extends RenderZombie {

	public RenderIronZombie(RenderManager manager) {
		super(manager);
	}
	
	@Override
	protected ResourceLocation getEntityTexture(EntityLiving entity) {
		EntityIronZombie zombie = (EntityIronZombie)entity;
		if(zombie.isDarkIron()) {
			return new ResourceLocation("minibosses", "textures/entity/dark_iron_zombie.png");
		} else {
			return new ResourceLocation("minibosses", "textures/entity/iron_zombie.png");
		}
	}

}
