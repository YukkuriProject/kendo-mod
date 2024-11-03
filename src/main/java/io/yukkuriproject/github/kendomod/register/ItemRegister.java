package io.yukkuriproject.github.kendomod.register;

import io.yukkuriproject.github.kendomod.KendoMod;
import io.yukkuriproject.github.kendomod.item.BoguItem;
import io.yukkuriproject.github.kendomod.item.SinaiItem;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterials;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import static io.yukkuriproject.github.kendomod.KendoMod.KENDO_ITEM_GROUP;
import static io.yukkuriproject.github.kendomod.KendoMod.KENDO_ITEM_GROUP_KEY;

public class ItemRegister {
    public static final SinaiItem SINAI = new SinaiItem();
    public static final BoguItem MEN = new BoguItem(ArmorMaterials.IRON, ArmorItem.Type.HELMET, new Item.Settings().maxDamage(ArmorItem.Type.HELMET.getMaxDamage(20)));

    public static void register() {
        Registry.register(Registries.ITEM, Identifier.of(KendoMod.MOD_ID, "sinai"), SINAI);
        Registry.register(Registries.ITEM, Identifier.of(KendoMod.MOD_ID, "men"), MEN);

        Registry.register(Registries.ITEM_GROUP, KENDO_ITEM_GROUP_KEY, KENDO_ITEM_GROUP);

        ItemGroupEvents.modifyEntriesEvent(KENDO_ITEM_GROUP_KEY).register(itemGroup -> {
            itemGroup.add(ItemRegister.SINAI);
            itemGroup.add(ItemRegister.MEN);
        });
    }
}
