package me.tyler15555.minibosses.client;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;


public class ModelForestGuard extends ModelBase {
    ModelRenderer head;
    ModelRenderer leg3;
    ModelRenderer leg4;
    ModelRenderer leg1;
    ModelRenderer leg2;
    ModelRenderer trunk;
    ModelRenderer branchLeft;
    ModelRenderer branchRight;
  
  public ModelForestGuard() {
      textureWidth = 64;
      textureHeight = 32;
    
      head = new ModelRenderer(this, 0, 0);
      head.addBox(-4F, -8F, -4F, 8, 8, 8);
      head.setRotationPoint(0F, 6F, -13F);
      head.setTextureSize(64, 32);
      head.mirror = true;
      setRotation(head, 0F, 0F, 0F);
      leg3 = new ModelRenderer(this, 0, 16);
      leg3.addBox(-2F, 0F, -2F, 4, 6, 4);
      leg3.setRotationPoint(-2F, 18F, -4F);
      leg3.setTextureSize(64, 32);
      leg3.mirror = true;
      setRotation(leg3, 0F, 0F, 0F);
      leg4 = new ModelRenderer(this, 0, 16);
      leg4.addBox(-2F, 0F, -2F, 4, 6, 4);
      leg4.setRotationPoint(2F, 18F, -4F);
      leg4.setTextureSize(64, 32);
      leg4.mirror = true;
      setRotation(leg4, 0F, 0F, 0F);
      leg1 = new ModelRenderer(this, 0, 16);
      leg1.addBox(0F, 0F, -2F, 4, 6, 4);
      leg1.setRotationPoint(-4F, 18F, 4F);
      leg1.setTextureSize(64, 32);
      leg1.mirror = true;
      setRotation(leg1, 0F, 0F, 0F);
      leg2 = new ModelRenderer(this, 0, 16);
      leg2.addBox(-2F, 0F, -2F, 4, 6, 4);
      leg2.setRotationPoint(2F, 18F, 4F);
      leg2.setTextureSize(64, 32);
      leg2.mirror = true;
      setRotation(leg2, 0F, 0F, 0F);
      trunk = new ModelRenderer(this, 0, 0);
      trunk.addBox(0F, 0F, 0F, 8, 25, 7);
      trunk.setRotationPoint(-4F, -7F, -3F);
      trunk.setTextureSize(64, 32);
      trunk.mirror = true;
      setRotation(trunk, 0F, 0F, 0F);
      branchLeft = new ModelRenderer(this, 0, 0);
      branchLeft.addBox(0F, 0F, 0F, 3, 3, 11);
      branchLeft.setRotationPoint(-7F, 0F, -11F);
      branchLeft.setTextureSize(64, 32);
      branchLeft.mirror = true;
      setRotation(branchLeft, 0F, 0F, 0F);
      branchRight = new ModelRenderer(this, 0, 0);
      branchRight.addBox(0F, 0F, 0F, 3, 3, 11);
      branchRight.setRotationPoint(4F, 0F, -11F);
      branchRight.setTextureSize(64, 32);
      branchRight.mirror = true;
      setRotation(branchRight, 0F, 0F, 0F);
  }
  
  @Override
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    head.render(f5);
    leg3.render(f5);
    leg4.render(f5);
    leg1.render(f5);
    leg2.render(f5);
    trunk.render(f5);
    branchLeft.render(f5);
    branchRight.render(f5);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z) {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  @Override
  public void setRotationAngles(float time, float moveSpeed, float par3, float yaw, float pitch, float par6, Entity entity) {
    super.setRotationAngles(time, moveSpeed, par3, yaw, pitch, par6, entity);
    this.leg1.rotateAngleX = MathHelper.cos(time * 0.6662F) * 1.4F * moveSpeed;
    this.leg2.rotateAngleX = MathHelper.cos(time * 0.6662F + (float)Math.PI) * 1.4F * moveSpeed;
    this.leg3.rotateAngleX = MathHelper.cos(time * 0.6662F + (float)Math.PI) * 1.4F * moveSpeed;
    this.leg4.rotateAngleX = MathHelper.cos(time * 0.6662F) * 1.4F * moveSpeed;
  }

}
