package com.astro.astroworldgen.client;

import com.astro.astroworldgen.AstroWorldGen;
import com.astro.astroworldgen.entity.PenguinEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class PenguinRenderer extends MobRenderer<PenguinEntity, PenguinModel> {
    private static final ResourceLocation TEXTURE =
            new ResourceLocation(AstroWorldGen.MOD_ID, "textures/entity/penguin.png");

    public PenguinRenderer(EntityRendererManager manager) {
        super(manager, new PenguinModel(), 0.3F);
    }

    @Override
    public ResourceLocation getEntityTexture(PenguinEntity entity) {
        return TEXTURE;
    }
}
