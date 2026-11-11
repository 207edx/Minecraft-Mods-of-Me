package com.astro.astroworldgen;

import net.minecraftforge.fml.common.Mod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * AstroWorldGen entry point.
 *
 * This foundation milestone only verifies that the Forge mod loads.
 * World-generation registries and the experimental height engine are
 * added in later, separately tested milestones.
 */
@Mod(AstroWorldGen.MOD_ID)
public final class AstroWorldGen {
    public static final String MOD_ID = "astroworldgen";
    private static final Logger LOGGER = LogManager.getLogger();

    public AstroWorldGen() {
        LOGGER.info("AstroWorldGen foundation loaded. World-generation modules are not registered yet.");
    }
}
