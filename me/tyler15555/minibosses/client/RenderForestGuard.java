package me.tyler15555.minibosses.client;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class RenderForestGuard extends RenderLiving {

	public RenderForestGuard() {
		super(new ModelForestGuard(), 0.5F);
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity var1) {
		return new ResourceLocation("minibosses", "textures/entity/forest_guard.png");
	}

}
