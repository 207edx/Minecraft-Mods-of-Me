package com.astro.astroworldgen;

import com.astro.astroworldgen.registry.ModBlocks;
import com.astro.astroworldgen.registry.ModEntities;
import com.astro.astroworldgen.registry.ModItems;
import com.astro.astroworldgen.worldgen.AstroWorldGenWorlds;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(AstroWorldGen.MOD_ID)
public final class AstroWorldGen {
    public static final String MOD_ID = "astroworldgen";
    private static final Logger LOGGER = LogManager.getLogger();

    public AstroWorldGen() {
        IEventBus modBus = FMLJavaModLoadingContext.get().getModEventBus();
        ModBlocks.BLOCKS.register(modBus);
        ModItems.ITEMS.register(modBus);
        ModEntities.ENTITIES.register(modBus);
        AstroWorldGenWorlds.register(modBus);

        modBus.addListener(AstroWorldGenWorlds::setup);
        modBus.addListener(ModEntities::setup);

        // Terrain additions use biome generation, not chunk-load mutation.
        LOGGER.info("AstroWorldGen material, biome, cave-carver and penguin systems initialized.");
    }
}
