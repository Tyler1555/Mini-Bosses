package me.tyler15555.minibosses.client;

import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderSilverfish;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class RenderTombGuard extends RenderSilverfish {

	public RenderTombGuard(RenderManager p_i46144_1_) {
		super(p_i46144_1_);
	}

	@Override
	public ResourceLocation getEntityTexture(Entity entity) {
		return new ResourceLocation("minibosses", "textures/entity/tomb_guard.png");
	}
	
}
