
package me.tyler15555.minibosses.client;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelCrawler extends ModelBase {

    ModelRenderer Body;
    ModelRenderer RearEnd;
    ModelRenderer Leg8;
    ModelRenderer Leg6;
    ModelRenderer Leg4;
    ModelRenderer Leg2;
    ModelRenderer Leg7;
    ModelRenderer Leg5;
    ModelRenderer Leg3;
    ModelRenderer Leg1;
    ModelRenderer Bridge;
    ModelRenderer Torso;
    ModelRenderer Head;
    ModelRenderer Arm1;
    ModelRenderer Arm2;
    ModelRenderer Shape1;
    ModelRenderer Shape2;
  
  public ModelCrawler()
  {
    textureWidth = 64;
    textureHeight = 32;
    
      Body = new ModelRenderer(this, 0, 0);
      Body.addBox(-3F, -3F, -3F, 6, 6, 6);
      Body.setRotationPoint(0F, 20F, 0F);
      Body.setTextureSize(64, 32);
      Body.mirror = true;
      setRotation(Body, 0F, 0F, 0F);
      RearEnd = new ModelRenderer(this, 0, 12);
      RearEnd.addBox(-5F, -4F, -6F, 10, 8, 12);
      RearEnd.setRotationPoint(0F, 20F, 9F);
      RearEnd.setTextureSize(64, 32);
      RearEnd.mirror = true;
      setRotation(RearEnd, 0F, 0F, 0F);
      Leg8 = new ModelRenderer(this, 18, 0);
      Leg8.addBox(-1F, -1F, -1F, 16, 2, 2);
      Leg8.setRotationPoint(4F, 20F, -1F);
      Leg8.setTextureSize(64, 32);
      Leg8.mirror = true;
      setRotation(Leg8, 0F, 0.5759587F, 0.1919862F);
      Leg6 = new ModelRenderer(this, 18, 0);
      Leg6.addBox(-1F, -1F, -1F, 16, 2, 2);
      Leg6.setRotationPoint(4F, 20F, 0F);
      Leg6.setTextureSize(64, 32);
      Leg6.mirror = true;
      setRotation(Leg6, 0F, 0.2792527F, 0.1919862F);
      Leg4 = new ModelRenderer(this, 18, 0);
      Leg4.addBox(-1F, -1F, -1F, 16, 2, 2);
      Leg4.setRotationPoint(4F, 20F, 1F);
      Leg4.setTextureSize(64, 32);
      Leg4.mirror = true;
      setRotation(Leg4, 0F, -0.2792527F, 0.1919862F);
      Leg2 = new ModelRenderer(this, 18, 0);
      Leg2.addBox(-1F, -1F, -1F, 16, 2, 2);
      Leg2.setRotationPoint(4F, 20F, 2F);
      Leg2.setTextureSize(64, 32);
      Leg2.mirror = true;
      setRotation(Leg2, 0F, -0.5759587F, 0.1919862F);
      Leg7 = new ModelRenderer(this, 18, 0);
      Leg7.addBox(-15F, -1F, -1F, 16, 2, 2);
      Leg7.setRotationPoint(-4F, 20F, -1F);
      Leg7.setTextureSize(64, 32);
      Leg7.mirror = true;
      setRotation(Leg7, 0F, -0.5759587F, -0.1919862F);
      Leg5 = new ModelRenderer(this, 18, 0);
      Leg5.addBox(-15F, -1F, -1F, 16, 2, 2);
      Leg5.setRotationPoint(-4F, 20F, 0F);
      Leg5.setTextureSize(64, 32);
      Leg5.mirror = true;
      setRotation(Leg5, 0F, -0.2792527F, -0.1919862F);
      Leg3 = new ModelRenderer(this, 18, 0);
      Leg3.addBox(-15F, -1F, -1F, 16, 2, 2);
      Leg3.setRotationPoint(-4F, 20F, 1F);
      Leg3.setTextureSize(64, 32);
      Leg3.mirror = true;
      setRotation(Leg3, 0F, 0.2792527F, -0.1919862F);
      Leg1 = new ModelRenderer(this, 18, 0);
      Leg1.addBox(-15F, -1F, -1F, 16, 2, 2);
      Leg1.setRotationPoint(-4F, 20F, 2F);
      Leg1.setTextureSize(64, 32);
      Leg1.mirror = true;
      setRotation(Leg1, 0F, 0.5759587F, -0.1919862F);
      Bridge = new ModelRenderer(this, 0, 0);
      Bridge.addBox(0F, 0F, 0F, 4, 4, 11);
      Bridge.setRotationPoint(-2F, 18F, -14F);
      Bridge.setTextureSize(64, 32);
      Bridge.mirror = true;
      setRotation(Bridge, 0F, 0F, 0F);
      Torso = new ModelRenderer(this, 0, 0);
      Torso.addBox(0F, 0F, 0F, 4, 17, 4);
      Torso.setRotationPoint(-2F, 1F, -14F);
      Torso.setTextureSize(64, 32);
      Torso.mirror = true;
      setRotation(Torso, 0F, 0F, 0F);
      Head = new ModelRenderer(this, 0, 0);
      Head.addBox(0F, 0F, 0F, 6, 6, 6);
      Head.setRotationPoint(-3F, -5F, -16F);
      Head.setTextureSize(64, 32);
      Head.mirror = true;
      setRotation(Head, 0F, 0F, 0F);
      Arm1 = new ModelRenderer(this, 0, 0);
      Arm1.addBox(0F, 0F, 0F, 4, 4, 11);
      Arm1.setRotationPoint(2F, 4F, -21F);
      Arm1.setTextureSize(64, 32);
      Arm1.mirror = true;
      setRotation(Arm1, 0F, 0F, 0F);
      Arm2 = new ModelRenderer(this, 0, 0);
      Arm2.addBox(0F, 0F, 0F, 4, 4, 11);
      Arm2.setRotationPoint(-6F, 4F, -21F);
      Arm2.setTextureSize(64, 32);
      Arm2.mirror = true;
      setRotation(Arm2, 0F, 0F, 0F);
      Shape1 = new ModelRenderer(this, 0, 0);
      Shape1.addBox(0F, 0F, 0F, 4, 4, 11);
      Shape1.setRotationPoint(2F, 11F, -21F);
      Shape1.setTextureSize(64, 32);
      Shape1.mirror = true;
      setRotation(Shape1, 0F, 0F, 0F);
      Shape2 = new ModelRenderer(this, 0, 0);
      Shape2.addBox(0F, 0F, 0F, 4, 4, 11);
      Shape2.setRotationPoint(-6F, 11F, -20F);
      Shape2.setTextureSize(64, 32);
      Shape2.mirror = true;
      setRotation(Shape2, 0F, 0F, 0F);
  }
  
  @Override
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    Body.render(f5);
    RearEnd.render(f5);
    Leg8.render(f5);
    Leg6.render(f5);
    Leg4.render(f5);
    Leg2.render(f5);
    Leg7.render(f5);
    Leg5.render(f5);
    Leg3.render(f5);
    Leg1.render(f5);
    Bridge.render(f5);
    Torso.render(f5);
    Head.render(f5);
    Arm1.render(f5);
    Arm2.render(f5);
    Shape1.render(f5);
    Shape2.render(f5);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z) {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  @Override
  public void setRotationAngles(float time, float moveSpeed, float par3, float yaw, float pitch, float par6, Entity entity) {
    super.setRotationAngles(time, moveSpeed, par3, yaw, pitch, par6, entity);
    float f6 = ((float)Math.PI / 4F);
    this.Leg1.rotateAngleZ = -f6;
    this.Leg2.rotateAngleZ = f6;
    this.Leg3.rotateAngleZ = -f6 * 0.74F;
    this.Leg4.rotateAngleZ = f6 * 0.74F;
    this.Leg5.rotateAngleZ = -f6 * 0.74F;
    this.Leg6.rotateAngleZ = f6 * 0.74F;
    this.Leg7.rotateAngleZ = -f6;
    this.Leg8.rotateAngleZ = f6;
    float f7 = -0.0F;
    float f8 = 0.3926991F;
    this.Leg1.rotateAngleY = f8 * 2.0F + f7;
    this.Leg2.rotateAngleY = -f8 * 2.0F - f7;
    this.Leg3.rotateAngleY = f8 * 1.0F + f7;
    this.Leg4.rotateAngleY = -f8 * 1.0F - f7;
    this.Leg5.rotateAngleY = -f8 * 1.0F + f7;
    this.Leg6.rotateAngleY = f8 * 1.0F - f7;
    this.Leg7.rotateAngleY = -f8 * 2.0F + f7;
    this.Leg8.rotateAngleY = f8 * 2.0F - f7;
    float f9 = -(MathHelper.cos(time * 0.6662F * 2.0F + 0.0F) * 0.4F) * moveSpeed;
    float f10 = -(MathHelper.cos(time * 0.6662F * 2.0F + (float)Math.PI) * 0.4F) * moveSpeed;
    float f11 = -(MathHelper.cos(time * 0.6662F * 2.0F + ((float)Math.PI / 2F)) * 0.4F) * moveSpeed;
    float f12 = -(MathHelper.cos(time * 0.6662F * 2.0F + ((float)Math.PI * 3F / 2F)) * 0.4F) * moveSpeed;
    float f13 = Math.abs(MathHelper.sin(time * 0.6662F + 0.0F) * 0.4F) * moveSpeed;
    float f14 = Math.abs(MathHelper.sin(time * 0.6662F + (float)Math.PI) * 0.4F) * moveSpeed;
    float f15 = Math.abs(MathHelper.sin(time * 0.6662F + ((float)Math.PI / 2F)) * 0.4F) * moveSpeed;
    float f16 = Math.abs(MathHelper.sin(time * 0.6662F + ((float)Math.PI * 3F / 2F)) * 0.4F) * moveSpeed;
    this.Leg1.rotateAngleY += f9;
    this.Leg2.rotateAngleY += -f9;
    this.Leg3.rotateAngleY += f10;
    this.Leg4.rotateAngleY += -f10;
    this.Leg5.rotateAngleY += f11;
    this.Leg6.rotateAngleY += -f11;
    this.Leg7.rotateAngleY += f12;
    this.Leg8.rotateAngleY += -f12;
    this.Leg1.rotateAngleZ += f13;
    this.Leg2.rotateAngleZ += -f13;
    this.Leg3.rotateAngleZ += f14;
    this.Leg4.rotateAngleZ += -f14;
    this.Leg5.rotateAngleZ += f15;
    this.Leg6.rotateAngleZ += -f15;
    this.Leg7.rotateAngleZ += f16;
    this.Leg8.rotateAngleZ += -f16;
  }

}
