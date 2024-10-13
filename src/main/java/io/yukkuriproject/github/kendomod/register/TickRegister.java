package io.yukkuriproject.github.kendomod.register;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;

public class TickRegister {
    public static void register() {
        ServerTickEvents.END_WORLD_TICK.register(ItemRegister.SINAI::tick);
    }
}
