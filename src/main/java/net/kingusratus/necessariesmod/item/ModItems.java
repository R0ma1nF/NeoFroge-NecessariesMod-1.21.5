package net.kingusratus.necessariesmod.item;

import net.kingusratus.necessariesmod.NecessariesMod;
import net.kingusratus.necessariesmod.food.ModConsumables;
import net.kingusratus.necessariesmod.food.ModFoodProperties;
import net.kingusratus.necessariesmod.item.custom.VoidCookieItem;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ToolMaterial;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    // The DeferredRegister for items, which will hold all the items we want to register
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(NecessariesMod.MOD_ID);


    /***************************************************************************************
     * MISC ITEMS
     ***************************************************************************************/
    public static final DeferredItem<Item> STEEL_INGOT = ITEMS.registerItem("steel_ingot",
            Item::new);
    public static final DeferredItem<Item> RUBY = ITEMS.registerItem("ruby",
            Item::new);

    /***************************************************************************************
     * FOOD ITEMS
     ***************************************************************************************/
    public static final DeferredItem<Item> CHERRY = ITEMS.registerItem("cherry",
            (properties) -> new Item(properties.food(ModFoodProperties.CHERRY).component(DataComponents.CONSUMABLE, ModConsumables.DEFAULT_CONSUMABLE)));
    public static final DeferredItem<Item> ORANGE = ITEMS.registerItem("orange",
            (properties) -> new Item(properties.food(ModFoodProperties.ORANGE).component(DataComponents.CONSUMABLE, ModConsumables.DEFAULT_CONSUMABLE)));
    public static final DeferredItem<Item> BANANA = ITEMS.registerItem("banana",
            (properties) -> new Item(properties.food(ModFoodProperties.BANANA).component(DataComponents.CONSUMABLE, ModConsumables.DEFAULT_CONSUMABLE)));
    public static final DeferredItem<Item> COCONUT = ITEMS.registerItem("coconut",
            (properties) -> new Item(properties.food(ModFoodProperties.COCONUT).component(DataComponents.CONSUMABLE, ModConsumables.DEFAULT_CONSUMABLE)));
    public static final DeferredItem<Item> CHERRY_JAM = ITEMS.registerItem("cherry_jam",
            (properties) -> new Item(properties.food(ModFoodProperties.CHERRY_JAM).component(DataComponents.CONSUMABLE, ModConsumables.DEFAULT_DRINK)));
    public static final DeferredItem<Item> ORANGE_JAM = ITEMS.registerItem("orange_jam",
            (properties) -> new Item(properties.food(ModFoodProperties.ORANGE_JAM).component(DataComponents.CONSUMABLE, ModConsumables.DEFAULT_DRINK)));
    public static final DeferredItem<Item> BANANA_JAM = ITEMS.registerItem("banana_jam",
            (properties) -> new Item(properties.food(ModFoodProperties.BANANA_JAM).component(DataComponents.CONSUMABLE, ModConsumables.DEFAULT_DRINK)));
    public static final DeferredItem<Item> APPLE_JAM = ITEMS.registerItem("apple_jam",
            (properties) -> new Item(properties.food(ModFoodProperties.APPLE_JAM).component(DataComponents.CONSUMABLE, ModConsumables.DEFAULT_DRINK)));
    public static final DeferredItem<Item> APPLE_PIE = ITEMS.registerItem("apple_pie",
            (properties) -> new Item(properties.food(ModFoodProperties.APPLE_PIE).component(DataComponents.CONSUMABLE, ModConsumables.DEFAULT_CONSUMABLE)));
    public static final DeferredItem<Item> CHERRY_PIE = ITEMS.registerItem("cherry_pie",
            (properties) -> new Item(properties.food(ModFoodProperties.CHERRY_PIE).component(DataComponents.CONSUMABLE, ModConsumables.DEFAULT_CONSUMABLE)));
    public static final DeferredItem<Item> ORANGE_PIE = ITEMS.registerItem("orange_pie",
            (properties) -> new Item(properties.food(ModFoodProperties.ORANGE_PIE).component(DataComponents.CONSUMABLE, ModConsumables.DEFAULT_CONSUMABLE)));
    public static final DeferredItem<Item> BANANA_PIE = ITEMS.registerItem("banana_pie",
            (properties) -> new Item(properties.food(ModFoodProperties.BANANA_PIE).component(DataComponents.CONSUMABLE, ModConsumables.DEFAULT_CONSUMABLE)));
    public static final DeferredItem<Item> COCONUT_PIE = ITEMS.registerItem("coconut_pie",
            (properties) -> new Item(properties.food(ModFoodProperties.COCONUT_PIE).component(DataComponents.CONSUMABLE, ModConsumables.DEFAULT_CONSUMABLE)));
    public static final DeferredItem<Item> MEAT_SKEWER = ITEMS.registerItem("meat_skewer",
            (properties) -> new Item(properties.food(ModFoodProperties.MEAT_SKEWER).component(DataComponents.CONSUMABLE, ModConsumables.DEFAULT_CONSUMABLE)));
    public static final DeferredItem<Item> MEAT_CHEESE_SKEWER = ITEMS.registerItem("meat_cheese_skewer",
            (properties) -> new Item(properties.food(ModFoodProperties.MEAT_CHEESE_SKEWER).component(DataComponents.CONSUMABLE, ModConsumables.DEFAULT_CONSUMABLE)));
    public static final DeferredItem<Item> CHICKEN_SKEWER = ITEMS.registerItem("chicken_skewer",
            (properties) -> new Item(properties.food(ModFoodProperties.CHICKEN_SKEWER).component(DataComponents.CONSUMABLE, ModConsumables.DEFAULT_CONSUMABLE)));
    public static final DeferredItem<Item> FISH_SKEWER = ITEMS.registerItem("fish_skewer",
            (properties) -> new Item(properties.food(ModFoodProperties.FISH_SKEWER).component(DataComponents.CONSUMABLE, ModConsumables.DEFAULT_CONSUMABLE)));
    public static final DeferredItem<Item> CACTUS_SKEWER = ITEMS.registerItem("cactus_skewer",
            (properties) -> new Item(properties.food(ModFoodProperties.CACTUS_SKEWER).component(DataComponents.CONSUMABLE, ModConsumables.CACTUS_SKEWER)));
    public static final DeferredItem<Item> SAUSAGE = ITEMS.registerItem("sausage",
            (properties) -> new Item(properties.food(ModFoodProperties.SAUSAGE).component(DataComponents.CONSUMABLE, ModConsumables.DEFAULT_CONSUMABLE)));
    public static final DeferredItem<Item> OMELETTE = ITEMS.registerItem("omelette",
            (properties) -> new Item(properties.food(ModFoodProperties.OMELETTE).component(DataComponents.CONSUMABLE, ModConsumables.DEFAULT_CONSUMABLE)));
    public static final DeferredItem<Item> CHEESE_OMELETTE = ITEMS.registerItem("cheese_omelette",
            (properties) -> new Item(properties.food(ModFoodProperties.CHEESE_OMELETTE).component(DataComponents.CONSUMABLE, ModConsumables.DEFAULT_CONSUMABLE)));
    public static final DeferredItem<Item> COOKED_TROPICAL_FISH = ITEMS.registerItem("cooked_tropical_fish",
            (properties) -> new Item(properties.food(ModFoodProperties.COOKED_TROPICAL_FISH).component(DataComponents.CONSUMABLE, ModConsumables.DEFAULT_CONSUMABLE)));
    public static final DeferredItem<Item> DIRT_SOUP = ITEMS.registerItem("dirt_soup",
            (properties) -> new Item(properties.stacksTo(1).food(ModFoodProperties.DIRT_SOUP).component(DataComponents.CONSUMABLE, ModConsumables.DIRT_SOUP).usingConvertsTo(Items.BOWL)));
    public static final DeferredItem<Item> GRAVEL_SOUP = ITEMS.registerItem("gravel_soup",
            (properties) -> new Item(properties.stacksTo(1).food(ModFoodProperties.GRAVEL_SOUP).component(DataComponents.CONSUMABLE, ModConsumables.GRAVEL_SOUP).usingConvertsTo(Items.BOWL)));
    public static final DeferredItem<Item> LAVA_SOUP = ITEMS.registerItem("lava_soup",
            (properties) -> new Item(properties.stacksTo(1).food(ModFoodProperties.LAVA_SOUP).component(DataComponents.CONSUMABLE, ModConsumables.LAVA_SOUP)));
    public static final DeferredItem<Item> ENDER_SOUP = ITEMS.registerItem("ender_soup",
            (properties) -> new Item(properties.stacksTo(1).food(ModFoodProperties.ENDER_SOUP).component(DataComponents.CONSUMABLE, ModConsumables.ENDER_SOUP).usingConvertsTo(Items.BOWL)));
    public static final DeferredItem<Item> CHEESE = ITEMS.registerItem("cheese",
            (properties) -> new Item(properties.food(ModFoodProperties.CHEESE).component(DataComponents.CONSUMABLE, ModConsumables.DEFAULT_CONSUMABLE)));
    public static final DeferredItem<Item> SMOKED_CHEESE = ITEMS.registerItem("smoked_cheese",
            (properties) -> new Item(properties.food(ModFoodProperties.SMOKED_CHEESE).component(DataComponents.CONSUMABLE, ModConsumables.DEFAULT_CONSUMABLE)));
    public static final DeferredItem<Item> ZOMBIE_JERKY = ITEMS.registerItem("zombie_jerky",
            (properties) -> new Item(properties.food(ModFoodProperties.ZOMBIE_JERKY).component(DataComponents.CONSUMABLE, ModConsumables.DEFAULT_CONSUMABLE)));
    public static final DeferredItem<Item> PIZZA = ITEMS.registerItem("pizza",
            (properties) -> new Item(properties.food(ModFoodProperties.PIZZA).component(DataComponents.CONSUMABLE, ModConsumables.DEFAULT_CONSUMABLE)));
    public static final DeferredItem<Item> HOTDOG = ITEMS.registerItem("hotdog",
            (properties) -> new Item(properties.food(ModFoodProperties.HOTDOG).component(DataComponents.CONSUMABLE, ModConsumables.DEFAULT_CONSUMABLE)));
    public static final DeferredItem<Item> HAMBURGER = ITEMS.registerItem("hamburger",
            (properties) -> new Item(properties.food(ModFoodProperties.HAMBURGER).component(DataComponents.CONSUMABLE, ModConsumables.DEFAULT_CONSUMABLE)));
    public static final DeferredItem<Item> STONE_BREAD = ITEMS.registerItem("stone_bread",
            (properties) -> new Item(properties.food(ModFoodProperties.STONE_BREAD).component(DataComponents.CONSUMABLE, ModConsumables.STONE_BREAD)));
    public static final DeferredItem<Item> COMPRESSED_BREAD = ITEMS.registerItem("compressed_bread",
            (properties) -> new Item(properties.food(ModFoodProperties.COMPRESSED_BREAD).component(DataComponents.CONSUMABLE, ModConsumables.DEFAULT_CONSUMABLE)));
    public static final DeferredItem<Item> CHOCOLATE = ITEMS.registerItem("chocolate",
            (properties) -> new Item(properties.food(ModFoodProperties.CHOCOLATE).component(DataComponents.CONSUMABLE, ModConsumables.DEFAULT_CONSUMABLE)));
    public static final DeferredItem<Item> HOT_CHOCOLATE = ITEMS.registerItem("hot_chocolate",
            (properties) -> new Item(properties.food(ModFoodProperties.HOT_CHOCOLATE).component(DataComponents.CONSUMABLE, ModConsumables.HOT_CHOCOLATE)));
    public static final DeferredItem<Item> ENDER_COOKIE = ITEMS.registerItem("ender_cookie",
            (properties) -> new Item(properties.food(ModFoodProperties.ENDER_COOKIE).component(DataComponents.CONSUMABLE, ModConsumables.ENDER_COOKIE)));
    public static final DeferredItem<Item> VOID_COOKIE = ITEMS.registerItem("void_cookie",
            VoidCookieItem::new);
    public static final DeferredItem<Item> RANDOM_COOKIE = ITEMS.registerItem("random_cookie",
            (properties) -> new Item(properties.food(ModFoodProperties.RANDOM_COOKIE).component(DataComponents.CONSUMABLE, ModConsumables.RANDOM_COOKIE)));
    public static final DeferredItem<Item> PANCAKE = ITEMS.registerItem("pancake",
            (properties) -> new Item(properties.food(ModFoodProperties.PANCAKE).component(DataComponents.CONSUMABLE, ModConsumables.DEFAULT_CONSUMABLE)));
    public static final DeferredItem<Item> DUBIOUS_FOOD = ITEMS.registerItem("dubious_food",
            (properties) -> new Item(properties.food(ModFoodProperties.DUBIOUS_FOOD).component(DataComponents.CONSUMABLE, ModConsumables.DUBIOUS_FOOD)));
    public static final DeferredItem<Item> THE_THING = ITEMS.registerItem("the_thing",
            (properties) -> new Item(properties.rarity(Rarity.RARE).food(ModFoodProperties.THE_THING).component(DataComponents.CONSUMABLE, ModConsumables.THE_THING)));
    public static final DeferredItem<Item> NETHERITE_STEAK = ITEMS.registerItem("netherite_steak",
            (properties) -> new Item(properties.rarity(Rarity.RARE).food(ModFoodProperties.NETHERITE_STEAK).component(DataComponents.CONSUMABLE, ModConsumables.NETHERITE_STEAK)));


    /***************************************************************************************
     * TOOLS
     ***************************************************************************************/
    public static final DeferredItem<Item> FISH_SWORD = ITEMS.registerItem("fish_sword",
            (properties) -> new Item(properties.sword(ToolMaterial.IRON, 3.0F, -2.4F).food(ModFoodProperties.FISH_SWORD).component(DataComponents.CONSUMABLE, ModConsumables.DEFAULT_CONSUMABLE).usingConvertsTo(Items.STICK)));



    public static void register(IEventBus eventBus) {
        // Register the items in the DeferredRegister
        ITEMS.register(eventBus);
    }
}
