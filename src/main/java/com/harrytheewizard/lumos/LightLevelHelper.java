package com.harrytheewizard.lumos;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;

public class LightLevelHelper {
    public static int getLightLevel(Item item) {
        if (item == Items.TORCH) return 14;
        if (item == Items.SOUL_TORCH) return 10;
        if (item == Items.LANTERN) return 15;
        if (item == Items.SOUL_LANTERN) return 10;
        if (item == Items.GLOWSTONE) return 15;
        if (item == Items.SEA_LANTERN) return 15;
        if (item == Items.SHROOMLIGHT) return 15;
        if (item == Items.BEACON) return 15;
        if (item == Items.END_ROD) return 14;
        if (item == Items.BLAZE_ROD) return 15;
        if (item == Items.LAVA_BUCKET) return 15;
        if (item == Items.FIRE_CHARGE) return 15;
        if (item == Items.GLOWSTONE_DUST) return 8;
        if (item == Items.GLOW_INK_SAC) return 8;
        if (item == Items.GLOW_BERRIES) return 8;
        if (item == Items.MAGMA_BLOCK) return 3;
        if (item == Items.CRYING_OBSIDIAN) return 10;
        if (item == Items.NETHER_STAR) return 15;
        if (item == Items.CAMPFIRE) return 15;
        if (item == Items.SOUL_CAMPFIRE) return 10;
        if (item == Items.JACK_O_LANTERN) return 15;
        if (item == Items.SEA_PICKLE) return 6;
        if (item == Items.REDSTONE_TORCH) return 7;
        if (item == Items.OCHRE_FROGLIGHT) return 15;
        if (item == Items.VERDANT_FROGLIGHT) return 15;
        if (item == Items.PEARLESCENT_FROGLIGHT) return 15;
        return 0;
    }
}