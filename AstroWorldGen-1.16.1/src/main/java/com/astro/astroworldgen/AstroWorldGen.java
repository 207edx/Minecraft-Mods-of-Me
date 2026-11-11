package com.astro.astroworldgen;

import com.astro.astroworldgen.registry.ModBlocks;
import com.astro.astroworldgen.registry.ModItems;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * AstroWorldGen mod entry point.
 *
 * The first content milestone registers starter material blocks and resource
 * items. Natural cave/biome placement, structures and the experimental
 * 500-block height engine remain separate milestones.
 */
@Mod(AstroWorldGen.MOD_ID)
public final class AstroWorldGen {
    public static final String MOD_ID = "astroworldgen";
    private static final Logger LOGGER = LogManager.getLogger();

    public AstroWorldGen() {
        IEventBus modBus = FMLJavaModLoadingContext.get().getModEventBus();
        ModBlocks.BLOCKS.register(modBus);
        ModItems.ITEMS.register(modBus);
        LOGGER.info("AstroWorldGen starter material registry initialized.");
    }
}
