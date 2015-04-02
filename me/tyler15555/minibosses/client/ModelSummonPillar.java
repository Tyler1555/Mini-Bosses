package me.tyler15555.minibosses.client;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelSummonPillar extends ModelBase {
  
    ModelRenderer pillarBase1;
    ModelRenderer pillarBase2;
    ModelRenderer pillarTower;
    ModelRenderer pillarHolder;
  
  public ModelSummonPillar() {
      textureWidth = 64;
      textureHeight = 32;
    
      pillarBase1 = new ModelRenderer(this, 0, 0);
      pillarBase1.addBox(0F, 0F, 0F, 16, 2, 16);
      pillarBase1.setRotationPoint(-8F, 22F, -8F);
      pillarBase1.setTextureSize(64, 32);
      pillarBase1.mirror = true;
      setRotation(pillarBase1, 0F, 0F, 0F);
      pillarBase2 = new ModelRenderer(this, 0, 0);
      pillarBase2.addBox(0F, 0F, 0F, 13, 2, 13);
      pillarBase2.setRotationPoint(-6F, 20F, -7F);
      pillarBase2.setTextureSize(64, 32);
      pillarBase2.mirror = true;
      setRotation(pillarBase2, 0F, 0F, 0F);
      pillarTower = new ModelRenderer(this, 0, 0);
      pillarTower.addBox(0F, 0F, 0F, 4, 20, 5);
      pillarTower.setRotationPoint(-2F, 0F, -3F);
      pillarTower.setTextureSize(64, 32);
      pillarTower.mirror = true;
      setRotation(pillarTower, 0F, 0F, 0F);
      pillarHolder = new ModelRenderer(this, 0, 0);
      pillarHolder.addBox(0F, 0F, 0F, 10, 11, 1);
      pillarHolder.setRotationPoint(-5F, -6F, 0F);
      pillarHolder.setTextureSize(64, 32);
      pillarHolder.mirror = true;
      setRotation(pillarHolder, -0.5948578F, 0F, 0F);
  }
  
  @Override
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    pillarBase1.render(f5);
    pillarBase2.render(f5);
    pillarTower.render(f5);
    pillarHolder.render(f5);
  }
  
  public void simpleRender() {
	  pillarBase1.render(0.0625F);
	  pillarBase2.render(0.0625F);
	  pillarTower.render(0.0625F);
	  pillarHolder.render(0.0625F);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z) {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  @Override
  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
    super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
  }

}
