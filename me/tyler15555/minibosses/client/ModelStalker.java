package me.tyler15555.minibosses.client;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelStalker extends ModelBase {
    ModelRenderer opticNerve;
    ModelRenderer nerveGore1;
    ModelRenderer nerveGore2;
    ModelRenderer nerveGore3;
    ModelRenderer head;
    ModelRenderer body;
    ModelRenderer rightarm;
    ModelRenderer leftarm;
    ModelRenderer rightleg;
    ModelRenderer leftleg;
  
  public ModelStalker() {
      textureWidth = 64;
      textureHeight = 32;
    
      opticNerve = new ModelRenderer(this, 0, 0);
      opticNerve.addBox(0F, 0F, 0F, 2, 2, 8);
      opticNerve.setRotationPoint(-1F, -13F, 4F);
      opticNerve.setTextureSize(64, 32);
      opticNerve.mirror = true;
      setRotation(opticNerve, 0F, 0F, 0F);
      nerveGore1 = new ModelRenderer(this, 0, 0);
      nerveGore1.addBox(0F, 0F, 0F, 1, 1, 2);
      nerveGore1.setRotationPoint(1F, -12F, 8F);
      nerveGore1.setTextureSize(64, 32);
      nerveGore1.mirror = true;
      setRotation(nerveGore1, -0.3717861F, 0.5205006F, 0F);
      nerveGore2 = new ModelRenderer(this, 0, 0);
      nerveGore2.addBox(0F, 0F, 0F, 1, 1, 2);
      nerveGore2.setRotationPoint(-1F, -13F, 5F);
      nerveGore2.setTextureSize(64, 32);
      nerveGore2.mirror = true;
      setRotation(nerveGore2, 0F, -0.9294653F, -0.1858931F);
      nerveGore3 = new ModelRenderer(this, 0, 0);
      nerveGore3.addBox(0F, 0F, 0F, 1, 1, 2);
      nerveGore3.setRotationPoint(0F, -13F, 9F);
      nerveGore3.setTextureSize(64, 32);
      nerveGore3.mirror = true;
      setRotation(nerveGore3, 0.8179294F, 0F, 0F);
      head = new ModelRenderer(this, 0, 0);
      head.addBox(-4F, -8F, -4F, 8, 8, 8);
      head.setRotationPoint(0F, -8F, 0F);
      head.setTextureSize(64, 32);
      head.mirror = true;
      setRotation(head, 0F, 0F, 0F);
      body = new ModelRenderer(this, 16, 16);
      body.addBox(-4F, 0F, -2F, 8, 12, 4);
      body.setRotationPoint(0F, 0F, 0F);
      body.setTextureSize(64, 32);
      body.mirror = true;
      setRotation(body, 0F, 0F, 0F);
      rightarm = new ModelRenderer(this, 40, 16);
      rightarm.addBox(-3F, -2F, -2F, 4, 12, 4);
      rightarm.setRotationPoint(-5F, 2F, 0F);
      rightarm.setTextureSize(64, 32);
      rightarm.mirror = true;
      setRotation(rightarm, 3.141593F, 0F, 0.1858931F);
      leftarm = new ModelRenderer(this, 40, 16);
      leftarm.addBox(-1F, -2F, -2F, 4, 12, 4);
      leftarm.setRotationPoint(5F, 2F, 0F);
      leftarm.setTextureSize(64, 32);
      leftarm.mirror = true;
      setRotation(leftarm, 3.123003F, 0F, -0.1442806F);
      rightleg = new ModelRenderer(this, 0, 16);
      rightleg.addBox(-2F, 0F, -2F, 4, 12, 4);
      rightleg.setRotationPoint(-2F, 12F, 0F);
      rightleg.setTextureSize(64, 32);
      rightleg.mirror = true;
      setRotation(rightleg, 0F, 0F, 0F);
      leftleg = new ModelRenderer(this, 0, 16);
      leftleg.addBox(-2F, 0F, -2F, 4, 12, 4);
      leftleg.setRotationPoint(2F, 12F, 0F);
      leftleg.setTextureSize(64, 32);
      leftleg.mirror = true;
      setRotation(leftleg, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    opticNerve.render(f5);
    nerveGore1.render(f5);
    nerveGore2.render(f5);
    nerveGore3.render(f5);
    head.render(f5);
    body.render(f5);
    rightarm.render(f5);
    leftarm.render(f5);
    rightleg.render(f5);
    leftleg.render(f5);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z) {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
    super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    this.leftleg.rotateAngleX = MathHelper.cos(f * 0.6662F + (float)Math.PI) * 1.4F * f1;
    this.rightleg.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.4F * f1;
    this.rightleg.rotateAngleY = 0.0F;
    this.leftleg.rotateAngleY = 0.0F;
  }

}
