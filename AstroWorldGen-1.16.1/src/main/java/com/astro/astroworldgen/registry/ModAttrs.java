package com.astro.astroworldgen.registry;

import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;

/** Complete base attribute set for the AstroWorldGen creature entities. */
public final class ModAttrs {
    public static AttributeModifierMap.MutableAttribute make(double health, double speed) {
        return new AttributeModifierMap.MutableAttribute()
                .createMutableAttribute(Attributes.MAX_HEALTH, health)
                .createMutableAttribute(Attributes.MOVEMENT_SPEED, speed)
                .createMutableAttribute(Attributes.ATTACK_DAMAGE, 0.0D)
                .createMutableAttribute(Attributes.FOLLOW_RANGE, 16.0D)
                .createMutableAttribute(Attributes.KNOCKBACK_RESISTANCE, 0.0D)
                .createMutableAttribute(Attributes.ARMOR, 0.0D)
                .createMutableAttribute(Attributes.ATTACK_KNOCKBACK, 0.0D)
                .createMutableAttribute(Attributes.ZOMBIE_SPAWN_REINFORCEMENTS, 0.0D);
    }

    private ModAttrs() {
    }
}
