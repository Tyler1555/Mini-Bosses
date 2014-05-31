package me.tyler15555.minibosses.client;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class RenderGlider extends RenderLiving {

	public RenderGlider() {
		super(new ModelGlider(), 0.5F);
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity var1) {
		return new ResourceLocation("minibosses", "textures/entity/glider.png");
	}

}
