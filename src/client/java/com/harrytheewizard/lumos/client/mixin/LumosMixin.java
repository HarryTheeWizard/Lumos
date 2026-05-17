package com.harrytheewizard.lumos.client.mixin;

import com.harrytheewizard.lumos.DynamicLightSource;
import com.harrytheewizard.lumos.LightLevelHelper;
import com.harrytheewizard.lumos.LumosManager;
import net.minecraft.client.Minecraft;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(net.minecraft.client.renderer.GameRenderer.class)
public class LumosMixin {

	@Inject(at = @At("HEAD"), method = "render")
	private void onRender(CallbackInfo info) {
		Minecraft client = Minecraft.getInstance();
		if (client.player == null) return;

		Player player = client.player;
		LumosManager.clearLightSources();

		ItemStack held = player.getMainHandItem();
		int level = LightLevelHelper.getLightLevel(held.getItem());
		if (level > 0) {
			LumosManager.addLightSource(new DynamicLightSource(
					player.getX(), player.getY(), player.getZ(), level
			));
		}
	}
}