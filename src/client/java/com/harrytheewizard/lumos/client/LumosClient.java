package com.harrytheewizard.lumos.client;

import com.harrytheewizard.lumos.LumosMode;
import net.fabricmc.api.ClientModInitializer;

public class LumosClient implements ClientModInitializer {

    private static net.minecraft.core.BlockPos lastPos =  null;

    @Override
    public void onInitializeClient() {
        com.harrytheewizard.lumos.LumosConfig.load();
        net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if (client.player == null || client.level == null) return;

            com.harrytheewizard.lumos.LumosMode mode = com.harrytheewizard.lumos.LumosConfig.getMode();

            if (mode == com.harrytheewizard.lumos.LumosMode.OFF) {
                com.harrytheewizard.lumos.LumosManager.clearLightSources();
                return;
            }

            com.harrytheewizard.lumos.LumosManager.clearLightSources();
            net.minecraft.world.item.ItemStack held = client.player.getMainHandItem();
            int level = com.harrytheewizard.lumos.LightLevelHelper.getLightLevel(held.getItem());
            if (level > 0) {
                com.harrytheewizard.lumos.LumosManager.addLightSource(new com.harrytheewizard.lumos.DynamicLightSource(
                        client.player.getX(), client.player.getY(), client.player.getZ(), level
                ));
            }

            if (mode == com.harrytheewizard.lumos.LumosMode.FAST || mode == LumosMode.REALTIME) {
                net.minecraft.core.BlockPos pos = client.player.blockPosition();
                if (level > 0) {
                    if (!pos.equals(lastPos)) {
                        if (lastPos != null) {
                            client.level.getLightEngine().checkBlock(lastPos);
                        }
                        client.level.getLightEngine().checkBlock(pos);
                        lastPos = pos;
                    }
                } else {
                    if (lastPos != null) {
                        client.level.getLightEngine().checkBlock(lastPos);
                        lastPos = null;
                    }
                }
            }
        });

    }
}
