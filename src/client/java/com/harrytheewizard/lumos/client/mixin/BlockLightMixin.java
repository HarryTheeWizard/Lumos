package com.harrytheewizard.lumos.client.mixin;

import com.harrytheewizard.lumos.DynamicLightSource;
import com.harrytheewizard.lumos.LumosManager;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.lighting.BlockLightEngine;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(BlockLightEngine.class)
public class BlockLightMixin {

    @Inject(at = @At("RETURN"), method = "getEmission(JLnet/minecraft/world/level/block/state/BlockState;)I", cancellable = true)
    private void onGetEmission(long blockNode, BlockState state, CallbackInfoReturnable<Integer> cir) {
        BlockPos pos = BlockPos.of(blockNode);
        for (DynamicLightSource source : LumosManager.getLightSources()) {
            BlockPos sourcePos = BlockPos.containing(source.getX(), source.getY(), source.getZ());
            if (sourcePos.equals(pos)) {
                int current = cir.getReturnValue();
                if (source.getLightLevel() > current) {
                    cir.setReturnValue(source.getLightLevel());
                }
            }
        }
    }
}
