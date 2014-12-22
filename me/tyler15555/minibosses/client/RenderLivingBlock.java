package me.tyler15555.minibosses.client;

import me.tyler15555.minibosses.entity.EntityLivingBlock;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.util.ResourceLocation;

public class RenderLivingBlock extends RenderLiving {
	
	public RenderLivingBlock(RenderManager manager) {
		super(manager, new ModelLivingBlock(), 0.5F);
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity) {
		EntityLivingBlock block = (EntityLivingBlock)entity;
		
		if(block.getBlockType() == 0) {
			return new ResourceLocation("minibosses", "textures/entity/living_block.png");
		} else {
			return new ResourceLocation("minibosses", "textures/entity/living_block_stone.png");
		}
	}

}
