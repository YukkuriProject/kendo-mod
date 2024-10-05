package io.yukkuriproject.github.kendomod.register;

import io.yukkuriproject.github.kendomod.KendoMod;
import io.yukkuriproject.github.kendomod.item.SinaiItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ItemRegister {
    public static final SinaiItem SINAI = new SinaiItem();

    public static void register() {
        Registry.register(Registries.ITEM, Identifier.of(KendoMod.MOD_ID, "sinai"), SINAI);
    }
}
