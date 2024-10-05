package io.yukkuriproject.github.kendomod;

import io.yukkuriproject.github.kendomod.register.ItemRegister;
import net.fabricmc.api.ModInitializer;

public class KendoMod implements ModInitializer {
    public static final String MOD_ID = "kendomod";

    @Override
    public void onInitialize() {
        ItemRegister.register();
    }
}
