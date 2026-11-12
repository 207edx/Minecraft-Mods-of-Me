package com.astro.astroworldgen.client;

import com.astro.astroworldgen.AstroWorldGen;
import com.astro.astroworldgen.registry.ModBlocks;
import com.astro.astroworldgen.registry.ModEntities;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = AstroWorldGen.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public final class ClientSetup {
    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event) {
        RenderingRegistry.registerEntityRenderingHandler(ModEntities.PENGUIN.get(), PenguinRenderer::new);
        RenderTypeLookup.setRenderLayer(ModBlocks.BRITTLE_ICE.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(ModBlocks.ICE_CRYSTAL.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.ICICLE.get(), RenderType.getCutout());
    }

    private ClientSetup() {
    }
}
