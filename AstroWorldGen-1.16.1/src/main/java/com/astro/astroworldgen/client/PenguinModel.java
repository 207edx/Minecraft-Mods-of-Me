package com.astro.astroworldgen.client;

import com.astro.astroworldgen.entity.PenguinEntity;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;

/** Low-poly penguin model adapted from the supplied IceUpdate source. */
public class PenguinModel extends EntityModel<PenguinEntity> {
    private final ModelRenderer body;
    private final ModelRenderer head;
    private final ModelRenderer beak;
    private final ModelRenderer leftFlipper;
    private final ModelRenderer rightFlipper;
    private final ModelRenderer leftFoot;
    private final ModelRenderer rightFoot;
    private final ModelRenderer[] parts;

    public PenguinModel() {
        textureWidth = 64;
        textureHeight = 32;
        body = new ModelRenderer(this, 0, 0);
        body.addBox(-3.0F, -9.0F, -2.5F, 6, 9, 5);
        body.setRotationPoint(0.0F, 21.0F, 0.0F);
        head = new ModelRenderer(this, 0, 14);
        head.addBox(-2.5F, -5.0F, -2.5F, 5, 5, 5);
        head.setRotationPoint(0.0F, 12.0F, 0.0F);
        beak = new ModelRenderer(this, 24, 14);
        beak.addBox(-1.0F, -3.0F, -4.5F, 2, 1, 2);
        beak.setRotationPoint(0.0F, 12.0F, 0.0F);
        leftFlipper = new ModelRenderer(this, 24, 0);
        leftFlipper.addBox(0.0F, 0.0F, -1.5F, 1, 6, 3);
        leftFlipper.setRotationPoint(3.0F, 13.0F, 0.0F);
        rightFlipper = new ModelRenderer(this, 24, 0);
        rightFlipper.mirror = true;
        rightFlipper.addBox(-1.0F, 0.0F, -1.5F, 1, 6, 3);
        rightFlipper.setRotationPoint(-3.0F, 13.0F, 0.0F);
        leftFoot = new ModelRenderer(this, 34, 0);
        leftFoot.addBox(-1.5F, 0.0F, -3.0F, 3, 1, 4);
        leftFoot.setRotationPoint(1.5F, 23.0F, 0.5F);
        rightFoot = new ModelRenderer(this, 34, 0);
        rightFoot.mirror = true;
        rightFoot.addBox(-1.5F, 0.0F, -3.0F, 3, 1, 4);
        rightFoot.setRotationPoint(-1.5F, 23.0F, 0.5F);
        parts = new ModelRenderer[]{body, head, beak, leftFlipper, rightFlipper, leftFoot, rightFoot};
    }

    @Override
    public void setRotationAngles(PenguinEntity entity, float limbSwing, float limbSwingAmount,
                                  float ageInTicks, float netHeadYaw, float headPitch) {
        head.rotateAngleY = netHeadYaw * 0.017453292F;
        head.rotateAngleX = headPitch * 0.017453292F;
        boolean idle = limbSwingAmount < 0.02F;
        if (idle) head.rotateAngleX += MathHelper.sin(ageInTicks * 0.06F) * 0.08F;
        beak.rotateAngleY = head.rotateAngleY;
        beak.rotateAngleX = head.rotateAngleX;
        float walk = MathHelper.cos(limbSwing * 0.6662F);
        leftFoot.rotateAngleX = walk * 1.2F * limbSwingAmount;
        rightFoot.rotateAngleX = -walk * 1.2F * limbSwingAmount;
        body.rotateAngleZ = MathHelper.sin(limbSwing * 0.6662F) * 0.25F * limbSwingAmount;
        float flap = entity.isInWater() ? MathHelper.sin(ageInTicks * 0.8F) * 0.9F
                : idle && entity.ticksExisted % 240 < 30 ? MathHelper.sin(ageInTicks * 0.9F) * 0.6F
                : walk * 0.4F * limbSwingAmount;
        leftFlipper.rotateAngleZ = -(0.12F + Math.abs(flap));
        rightFlipper.rotateAngleZ = 0.12F + Math.abs(flap);
    }

    @Override
    public void render(MatrixStack matrix, IVertexBuilder buffer, int light, int overlay,
                       float red, float green, float blue, float alpha) {
        for (ModelRenderer part : parts) part.render(matrix, buffer, light, overlay, red, green, blue, alpha);
    }
}
