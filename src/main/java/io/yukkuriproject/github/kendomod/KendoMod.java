package io.yukkuriproject.github.kendomod;

import io.yukkuriproject.github.kendomod.register.ItemRegister;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryKey;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class KendoMod implements ModInitializer {
    public static final String MOD_ID = "kendomod";

    public static final RegistryKey<ItemGroup> KENDO_ITEM_GROUP_KEY = RegistryKey.of(Registries.ITEM_GROUP.getKey(), Identifier.of(KendoMod.MOD_ID, "item_group"));
    public static final ItemGroup KENDO_ITEM_GROUP = FabricItemGroup.builder()
            .icon(() -> new ItemStack(ItemRegister.SINAI))
            .displayName(Text.translatable("itemGroup.kendomod"))
            .build();

    @Override
    public void onInitialize() {
        ItemRegister.register();
    }
}
