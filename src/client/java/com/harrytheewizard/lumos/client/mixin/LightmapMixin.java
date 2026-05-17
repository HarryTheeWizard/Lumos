package com.harrytheewizard.lumos.client.mixin;

import com.harrytheewizard.lumos.DynamicLightSource;
import com.harrytheewizard.lumos.LumosManager;
import net.minecraft.client.renderer.LevelRenderer;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockAndLightGetter;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import com.harrytheewizard.lumos.LumosConfig;
import com.harrytheewizard.lumos.LumosMode;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value = LevelRenderer.BrightnessGetter.class, priority = 900)
public interface LightmapMixin {

    @Inject(method = "lambda$static$0", at = @At("RETURN"),cancellable = true, remap = false)
    private static void onGetLightmapCoordinates(BlockAndLightGetter level, BlockPos pos, CallbackInfoReturnable<Integer> cir) {
                                if (LumosConfig.getMode() != LumosMode.REALTIME) return;

                double bestLevel = 0.0;
                for (DynamicLightSource source : new java.util.ArrayList<DynamicLightSource>(LumosManager.getLightSources())) {
                    if (source == null) continue;
                    double dist = Math.sqrt(
                        Math.pow(source.getX() - pos.getX(), 2) +
                        Math.pow(source.getY() - pos.getY(), 2) +
                        Math.pow(source.getZ() - pos.getZ(), 2)
                    );
                    if (dist < 7.75) {
                        double multiplier = 1.0 - dist / 7.75;
                        double lightLevel = multiplier * source.getLightLevel();
                        if (lightLevel > bestLevel) bestLevel = lightLevel;
                    }

                }

                if (bestLevel <= 0.0) return;

                int vanilla = cir.getReturnValue();
                int vanillaBlock = (vanilla >> 4) & 0xF;
                int dynamic = (int) Math.round(bestLevel);
                if (dynamic > vanillaBlock) {
                    int sky = vanilla & 0xF0000;
                    cir.setReturnValue(sky | (dynamic << 4));
                }
    }
}
