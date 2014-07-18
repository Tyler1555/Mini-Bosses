package me.tyler15555.minibosses.client;

import net.minecraft.client.renderer.entity.RenderIronGolem;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class RenderInfernoGolem extends RenderIronGolem {

	@Override
	public ResourceLocation getEntityTexture(Entity entity) {
		return new ResourceLocation("minibosses", "textures/entity/inferno_golem.png");
	}
	
}
