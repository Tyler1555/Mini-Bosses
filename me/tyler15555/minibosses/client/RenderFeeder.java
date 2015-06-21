package me.tyler15555.minibosses.client;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class RenderFeeder extends RenderLiving {

	public RenderFeeder() {
		super(new ModelFeeder(), 0.5F);
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity) {
		return new ResourceLocation("minibosses", "textures/entity/feeder.png");
	}

}
