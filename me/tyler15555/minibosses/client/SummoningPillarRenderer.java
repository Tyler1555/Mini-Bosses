package me.tyler15555.minibosses.client;

import me.tyler15555.tileentity.TileEntitySummoningPillar;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;
//TODO: Add some fancy visuals
public class SummoningPillarRenderer extends TileEntitySpecialRenderer {

	public SummoningPillarRenderer() {
		
	}
	
	private ModelSummonPillar model = new ModelSummonPillar();

	@Override
	public void renderTileEntityAt(TileEntity te, double posX, double posY, double posZ, float p_180535_8_, int p_180535_9_) {
		Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("minibosses", "textures/blocks/pillar.png"));
		GL11.glPushMatrix();
		GL11.glTranslated(posX + 0.5D, posY + 1.5D, posZ + 0.5D);
		GL11.glScalef(1F, -1F, -1F);
		this.model.simpleRender();
		GL11.glPopMatrix();
	}
	//To implement
	public ResourceLocation getTextureFromData(TileEntitySummoningPillar pillar) {
		return null;
	}

}
