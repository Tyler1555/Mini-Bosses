package me.tyler15555.minibosses.client;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class RenderStalker extends RenderLiving {

	public RenderStalker() {
		super(Minecraft.getMinecraft().getRenderManager(), new ModelStalker(), 0.5F);
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity) {
		return new ResourceLocation("minibosses", "textures/entity/stalker.png");
	}

}
