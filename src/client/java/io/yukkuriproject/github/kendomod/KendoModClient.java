package io.yukkuriproject.github.kendomod;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.client.MinecraftClient;

public class KendoModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ClientTickEvents.END_CLIENT_TICK.register((c) -> {
            System.out.println(MinecraftClient.getInstance().mouse.wasRightButtonClicked());
        });
    }
}
