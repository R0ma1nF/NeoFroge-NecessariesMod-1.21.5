package net.kingusratus.necessariesmod.utils;

import net.kingusratus.necessariesmod.NecessariesMod;
import net.kingusratus.necessariesmod.block.ModBlocks;
import net.kingusratus.necessariesmod.item.ModItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, NecessariesMod.MOD_ID);


    public static final Supplier<CreativeModeTab> NECESSARIESMOD_ITEM = CREATIVE_MODE_TAB.register("necessariesmod_item",
            () -> CreativeModeTab.builder().icon(() -> ModItems.RUBY.get().getDefaultInstance())
                    .title(Component.translatable("creativetab.necessariesmod.item_tab"))
                    .displayItems((parameters, output) -> {
                        output.accept(ModItems.STEEL_INGOT);
                        output.accept(ModBlocks.STEEL_BLOCK);
                        output.accept(ModItems.RUBY);
                        output.accept(ModBlocks.RUBY_BLOCK);
                        output.accept(ModBlocks.RUBY_ORE);
                        output.accept(ModBlocks.DEEPSLATE_RUBY_ORE);
                        output.accept(ModItems.CACTUS_HELMET);
                        output.accept(ModItems.CACTUS_CHESTPLATE);
                        output.accept(ModItems.CACTUS_LEGGINGS);
                        output.accept(ModItems.CACTUS_BOOTS);
                        output.accept(ModItems.OBSIDIAN_HELMET);
                        output.accept(ModItems.OBSIDIAN_CHESTPLATE);
                        output.accept(ModItems.OBSIDIAN_LEGGINGS);
                        output.accept(ModItems.OBSIDIAN_BOOTS);
                        output.accept(ModItems.COPPER_WIRE);
                        output.accept(ModItems.COPPER_COIL);
                        output.accept(ModItems.ELECTRONIC_CIRCUIT);
                        output.accept(ModItems.IRON_PLATE);
                        output.accept(ModItems.REINFORCED_STICK);
                        output.accept(ModItems.IRON_CASING);
                        output.accept(ModItems.DRILL_HEAD);
                        output.accept(ModItems.DRILL_CASING);
                        output.accept(ModItems.DRILL_ENGINE);
                        output.accept(ModItems.DRILL_HANDLE);
                        output.accept(ModItems.DRILL);
                    }).build());

    public static final Supplier<CreativeModeTab> NECESSARIESMOD_FOODS = CREATIVE_MODE_TAB.register("necessariesmod_foods",
            () -> CreativeModeTab.builder().icon(() -> ModItems.FISH_SKEWER.get().getDefaultInstance())
                    .title(Component.translatable("creativetab.necessariesmod.food_tab"))
                    .displayItems((parameters, output) -> {
                        output.accept(ModItems.CHERRY);
                        output.accept(ModItems.ORANGE);
                        output.accept(ModItems.BANANA);
                        output.accept(ModItems.COCONUT);
                        output.accept(ModItems.APPLE_PIE);
                        output.accept(ModItems.CHERRY_PIE);
                        output.accept(ModItems.ORANGE_PIE);
                        output.accept(ModItems.BANANA_PIE);
                        output.accept(ModItems.COCONUT_PIE);
                        output.accept(ModItems.CHERRY_JAM);
                        output.accept(ModItems.ORANGE_JAM);
                        output.accept(ModItems.BANANA_JAM);
                        output.accept(ModItems.APPLE_JAM);
                        output.accept(ModItems.MEAT_SKEWER);
                        output.accept(ModItems.MEAT_CHEESE_SKEWER);
                        output.accept(ModItems.CHICKEN_SKEWER);
                        output.accept(ModItems.FISH_SKEWER);
                        output.accept(ModItems.CACTUS_SKEWER);
                        output.accept(ModItems.SAUSAGE);
                        output.accept(ModItems.COOKED_TROPICAL_FISH);
                        output.accept(ModItems.ZOMBIE_JERKY);
                        output.accept(ModItems.NETHERITE_STEAK);
                        output.accept(ModItems.OMELETTE);
                        output.accept(ModItems.CHEESE_OMELETTE);
                        output.accept(ModItems.CHEESE);
                        output.accept(ModItems.SMOKED_CHEESE);
                        output.accept(ModItems.PIZZA);
                        output.accept(ModItems.HOTDOG);
                        output.accept(ModItems.HAMBURGER);
                        output.accept(ModItems.STONE_BREAD);
                        output.accept(ModItems.COMPRESSED_BREAD);
                        output.accept(ModItems.DUBIOUS_FOOD);
                        output.accept(ModItems.DIRT_SOUP);
                        output.accept(ModItems.GRAVEL_SOUP);
                        output.accept(ModItems.LAVA_SOUP);
                        output.accept(ModItems.ENDER_SOUP);
                        output.accept(ModItems.CHOCOLATE);
                        output.accept(ModItems.HOT_CHOCOLATE);
                        output.accept(ModItems.ENDER_COOKIE);
                        output.accept(ModItems.VOID_COOKIE);
                        output.accept(ModItems.RANDOM_COOKIE);
                        output.accept(ModBlocks.ENDCAKE_BLOCK);
                        output.accept(ModItems.PANCAKE);
                        output.accept(ModItems.THE_THING);
                        output.accept(ModItems.FISH_SWORD);
                    }).build());



    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
