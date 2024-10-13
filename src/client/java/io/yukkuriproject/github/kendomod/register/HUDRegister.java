package io.yukkuriproject.github.kendomod.register;

import io.yukkuriproject.github.kendomod.hud.SinaiHUD;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;

public abstract class HUDRegister {
    public static void register() {
        HudRenderCallback.EVENT.register(SinaiHUD::callback);
    }
}
