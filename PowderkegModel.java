package cleverpanda.powderkegs;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

//Version 0.3.00

public class PowderkegModel extends ModelBase
{
  //fields
    ModelRenderer FrontSide;
    ModelRenderer Bottom;
    ModelRenderer LeftSide;
    ModelRenderer BackSide;
    ModelRenderer RightSide;
    ModelRenderer InnerFront;
    ModelRenderer InnerBack;
    ModelRenderer InnerRight;
    ModelRenderer InnerLeft;
    ModelRenderer TopRight;
    ModelRenderer TopLeft;
    ModelRenderer TopBack;
    ModelRenderer TopFront;
    ModelRenderer LevelIndicator;
  
  public PowderkegModel()
  {
    textureWidth = 64;
    textureHeight = 64;
    
      FrontSide = new ModelRenderer(this, 0, 0);
      FrontSide.addBox(0F, 0F, 0F, 16, 16, 0);
      FrontSide.setRotationPoint(-8F, 8F, -8F);
      FrontSide.setTextureSize(64, 64);
      FrontSide.mirror = true;
      setRotation(FrontSide, 0F, 0F, 0F);
      
      Bottom = new ModelRenderer(this, -16, 0);
      Bottom.addBox(0F, 0F, 0F, 16, 0, 16);
      Bottom.setRotationPoint(-8F, 24F, -8F);
      Bottom.setTextureSize(64, 64);
      Bottom.mirror = true;
      setRotation(Bottom, 0F, 0F, 0F);
      
      LeftSide = new ModelRenderer(this, 0, -16);
      LeftSide.addBox(0F, 0F, 0F, 0, 16, 16);
      LeftSide.setRotationPoint(8F, 8F, -8F);
      LeftSide.setTextureSize(64, 64);
      LeftSide.mirror = true;
      setRotation(LeftSide, 0F, 0F, 0F);
      
      BackSide = new ModelRenderer(this, 0, 0);
      BackSide.addBox(0F, 0F, 0F, 16, 16, 0);
      BackSide.setRotationPoint(-8F, 8F, 8F);
      BackSide.setTextureSize(64, 64);
      BackSide.mirror = true;
      setRotation(BackSide, 0F, 0F, 0F);
      
      RightSide = new ModelRenderer(this, 0, -16);
      RightSide.addBox(0F, 0F, 0F, 0, 16, 16);
      RightSide.setRotationPoint(-8F, 8F, -8F);
      RightSide.setTextureSize(64, 64);
      RightSide.mirror = true;
      setRotation(RightSide, 0F, 0F, 0F);
      
      InnerFront = new ModelRenderer(this, 2, 16);
      InnerFront.addBox(0F, 0F, 0F, 12, 16, 0);
      InnerFront.setRotationPoint(-6F, 8F, -6F);
      InnerFront.setTextureSize(64, 64);
      InnerFront.mirror = true;
      setRotation(InnerFront, 0F, 0F, 0F);
      
      InnerBack = new ModelRenderer(this, 2, 16);
      InnerBack.addBox(0F, 0F, 0F, 12, 16, 0);
      InnerBack.setRotationPoint(-6F, 8F, 6F);
      InnerBack.setTextureSize(64, 64);
      InnerBack.mirror = true;
      setRotation(InnerBack, 0F, 0F, 0F);
      
      InnerRight = new ModelRenderer(this, 2, 4);
      InnerRight.addBox(0F, 0F, 0F, 0, 16, 12);
      InnerRight.setRotationPoint(-6F, 8F, -6F);
      InnerRight.setTextureSize(64, 64);
      InnerRight.mirror = true;
      setRotation(InnerRight, 0F, 0F, 0F);
      
      InnerLeft = new ModelRenderer(this, 2, 4);
      InnerLeft.addBox(0F, 0F, 0F, 0, 16, 12);
      InnerLeft.setRotationPoint(6F, 8F, -6F);
      InnerLeft.setTextureSize(64, 64);
      InnerLeft.mirror = true;
      setRotation(InnerLeft, 0F, 0F, 0F);
      
      TopRight = new ModelRenderer(this, 14, 0);
      TopRight.addBox(0F, 0F, 0F, 2, 0, 16);
      TopRight.setRotationPoint(-8F, 8F, -8F);
      TopRight.setTextureSize(64, 64);
      TopRight.mirror = true;
      setRotation(TopRight, 0F, 0F, 0F);
      
      TopLeft = new ModelRenderer(this, 30, 0);
      TopLeft.addBox(0F, 0F, 0F, 2, 0, 16);
      TopLeft.setRotationPoint(8F, 8F, -8F);
      TopLeft.setTextureSize(64, 64);
      TopLeft.mirror = true;
      setRotation(TopLeft, 0F, 0F, 3.141593F);
      
      TopBack = new ModelRenderer(this, 14, 14);
      TopBack.addBox(0F, 0F, 0F, 16, 0, 2);
      TopBack.setRotationPoint(-8F, 8F, 6F);
      TopBack.setTextureSize(64, 64);
      TopBack.mirror = true;
      setRotation(TopBack, 0F, 0F, 0F);
      
      TopFront = new ModelRenderer(this, 14, 0);
      TopFront.addBox(0F, 0F, 0F, 16, 0, 2);
      TopFront.setRotationPoint(-8F, 8F, -8F);
      TopFront.setTextureSize(64, 64);
      TopFront.mirror = true;
      setRotation(TopFront, 0F, 0F, 0F);
      
      LevelIndicator = new ModelRenderer(this, -10, 18);
      LevelIndicator.addBox(0F, 0F, 0F, 12, 1, 12);
      LevelIndicator.setRotationPoint(-6F, 22F, -6F);
      LevelIndicator.setTextureSize(64, 64);
      LevelIndicator.mirror = true;
      setRotation(LevelIndicator, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    FrontSide.render(f5);
    Bottom.render(f5);
    LeftSide.render(f5);
    BackSide.render(f5);
    RightSide.render(f5);
    InnerFront.render(f5);
    InnerBack.render(f5);
    InnerRight.render(f5);
    InnerLeft.render(f5);
    TopRight.render(f5);
    TopLeft.render(f5);
    TopBack.render(f5);
    TopFront.render(f5);
    LevelIndicator.render(f5);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
  {
    super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
  }

}
