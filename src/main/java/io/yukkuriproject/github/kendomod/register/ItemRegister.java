package io.yukkuriproject.github.kendomod.register;

import io.yukkuriproject.github.kendomod.KendoMod;
import io.yukkuriproject.github.kendomod.item.MenItem;
import io.yukkuriproject.github.kendomod.item.DoItem;
import io.yukkuriproject.github.kendomod.item.SinaiItem;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import static io.yukkuriproject.github.kendomod.KendoMod.KENDO_ITEM_GROUP;
import static io.yukkuriproject.github.kendomod.KendoMod.KENDO_ITEM_GROUP_KEY;

public class ItemRegister {
    public static final SinaiItem SINAI = new SinaiItem();
    public static final MenItem MEN = new MenItem(new Item.Settings().maxDamage(432));
    public static final DoItem DO = new DoItem(new Item.Settings().maxDamage(432));

    public static void register() {
        Registry.register(Registries.ITEM, Identifier.of(KendoMod.MOD_ID, "sinai"), SINAI);
        Registry.register(Registries.ITEM, Identifier.of(KendoMod.MOD_ID, "men"), MEN);
        Registry.register(Registries.ITEM, Identifier.of(KendoMod.MOD_ID, "do"), DO);

        Registry.register(Registries.ITEM_GROUP, KENDO_ITEM_GROUP_KEY, KENDO_ITEM_GROUP);

        ItemGroupEvents.modifyEntriesEvent(KENDO_ITEM_GROUP_KEY).register(itemGroup -> {
            itemGroup.add(ItemRegister.SINAI);
            itemGroup.add(ItemRegister.MEN);
            itemGroup.add(ItemRegister.DO);
        });
    }
}
