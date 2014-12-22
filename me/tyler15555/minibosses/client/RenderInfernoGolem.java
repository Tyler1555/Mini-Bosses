package me.tyler15555.minibosses.client;

import net.minecraft.client.renderer.entity.RenderIronGolem;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class RenderInfernoGolem extends RenderIronGolem {

	public RenderInfernoGolem(RenderManager p_i46133_1_) {
		super(p_i46133_1_);
	}

	@Override
	public ResourceLocation getEntityTexture(Entity entity) {
		return new ResourceLocation("minibosses", "textures/entity/inferno_golem.png");
	}
	
}
