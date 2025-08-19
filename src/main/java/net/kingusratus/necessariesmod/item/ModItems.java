package net.kingusratus.necessariesmod.item;

import net.kingusratus.necessariesmod.NecessariesMod;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    // The DeferredRegister for items, which will hold all the items we want to register
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(NecessariesMod.MOD_ID);

    public static final DeferredItem<Item> STEEL_INGOT = ITEMS.registerItem(
            "steel_ingot", Item::new, new Item.Properties());

    public static final DeferredItem<Item> RUBY = ITEMS.registerItem(
            "ruby", Item::new, new Item.Properties());

    public static void register(IEventBus eventBus) {
        // Register the items in the DeferredRegister
        ITEMS.register(eventBus);
    }
}
