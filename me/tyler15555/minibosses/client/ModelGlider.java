package me.tyler15555.minibosses.client;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelGlider extends ModelBase {
    
	ModelRenderer Body;
    ModelRenderer Glider1;
    ModelRenderer Glider2;
    ModelRenderer Leg1;
    ModelRenderer Leg2;
    ModelRenderer Leg3;
    ModelRenderer Leg4;
    ModelRenderer Leg5;
    ModelRenderer Leg6;
    ModelRenderer Head;
  
  public ModelGlider() {
    textureWidth = 64;
    textureHeight = 32;
    
      Body = new ModelRenderer(this, 0, 0);
      Body.addBox(0F, 0F, 0F, 5, 4, 24);
      Body.setRotationPoint(-1F, 4F, -10F);
      Body.setTextureSize(64, 32);
      Body.mirror = true;
      setRotation(Body, 0F, 0F, 0F);
      Glider1 = new ModelRenderer(this, 0, 0);
      Glider1.addBox(0F, 0F, 0F, 5, 1, 20);
      Glider1.setRotationPoint(-8F, 23F, -7F);
      Glider1.setTextureSize(64, 32);
      Glider1.mirror = true;
      setRotation(Glider1, 0F, 0F, 0F);
      Glider2 = new ModelRenderer(this, 0, 0);
      Glider2.addBox(0F, 0F, 0F, 5, 1, 20);
      Glider2.setRotationPoint(7F, 23F, -8F);
      Glider2.setTextureSize(64, 32);
      Glider2.mirror = true;
      setRotation(Glider2, 0F, 0F, 0F);
      Leg1 = new ModelRenderer(this, 0, 0);
      Leg1.addBox(0F, 0F, 0F, 2, 17, 2);
      Leg1.setRotationPoint(-3F, 6F, -5F);
      Leg1.setTextureSize(64, 32);
      Leg1.mirror = true;
      setRotation(Leg1, 0F, 0F, 0.2443461F);
      Leg2 = new ModelRenderer(this, 0, 0);
      Leg2.addBox(0F, 0F, 0F, 2, 17, 2);
      Leg2.setRotationPoint(-3F, 6F, 1F);
      Leg2.setTextureSize(64, 32);
      Leg2.mirror = true;
      setRotation(Leg2, 0F, 0F, 0.2443461F);
      Leg3 = new ModelRenderer(this, 0, 0);
      Leg3.addBox(0F, 0F, 0F, 2, 17, 2);
      Leg3.setRotationPoint(-3F, 7F, 8F);
      Leg3.setTextureSize(64, 32);
      Leg3.mirror = true;
      setRotation(Leg3, 0F, 0F, 0.2443461F);
      Leg4 = new ModelRenderer(this, 0, 0);
      Leg4.addBox(0F, 0F, 0F, 2, 17, 2);
      Leg4.setRotationPoint(4F, 7F, -6F);
      Leg4.setTextureSize(64, 32);
      Leg4.mirror = true;
      setRotation(Leg4, 0F, 0F, -0.2443461F);
      Leg5 = new ModelRenderer(this, 0, 0);
      Leg5.addBox(0F, 0F, 0F, 2, 17, 2);
      Leg5.setRotationPoint(3F, 7F, 1F);
      Leg5.setTextureSize(64, 32);
      Leg5.mirror = true;
      setRotation(Leg5, 0F, 0F, -0.2443461F);
      Leg6 = new ModelRenderer(this, 0, 0);
      Leg6.addBox(0F, 0F, 0F, 2, 17, 2);
      Leg6.setRotationPoint(3F, 7F, 8F);
      Leg6.setTextureSize(64, 32);
      Leg6.mirror = true;
      setRotation(Leg6, 0F, 0F, -0.2443461F);
      Head = new ModelRenderer(this, 0, 0);
      Head.addBox(0F, 0F, 0F, 6, 6, 6);
      Head.setRotationPoint(-2F, 3F, -16F);
      Head.setTextureSize(64, 32);
      Head.mirror = true;
      setRotation(Head, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    Body.render(f5);
    Glider1.render(f5);
    Glider2.render(f5);
    Leg1.render(f5);
    Leg2.render(f5);
    Leg3.render(f5);
    Leg4.render(f5);
    Leg5.render(f5);
    Leg6.render(f5);
    Head.render(f5);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z) {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
    super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
  }

}
