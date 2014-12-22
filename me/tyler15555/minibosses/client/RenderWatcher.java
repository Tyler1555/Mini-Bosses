package me.tyler15555.minibosses.client;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class RenderWatcher extends RenderLiving {

	public RenderWatcher(RenderManager manager) {
		super(manager, new ModelWatcher(), 0.5F);
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity) {
		return new ResourceLocation("minibosses", "textures/entity/watcher.png");
	}

}
