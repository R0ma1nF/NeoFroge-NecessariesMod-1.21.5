package net.kingusratus.necessariesmod.datagen;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import net.kingusratus.necessariesmod.NecessariesMod;
import net.kingusratus.necessariesmod.block.ModBlocks;
import net.kingusratus.necessariesmod.item.ModArmorMaterials;
import net.kingusratus.necessariesmod.item.ModItems;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.ModelProvider;
import net.minecraft.client.data.models.blockstates.MultiVariantGenerator;
import net.minecraft.client.data.models.blockstates.PropertyDispatch;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.client.data.models.model.ModelLocationUtils;
import net.minecraft.core.Holder;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.neoforged.fml.common.Mod;

import java.util.stream.Stream;

public class ModModelProvider extends ModelProvider {

    public ModModelProvider(PackOutput output) {
        super(output, NecessariesMod.MOD_ID);
    }

    @Override
    protected void registerModels(BlockModelGenerators blockModels, ItemModelGenerators itemModels) {
        // Register food models
        registerFoodModels(itemModels, blockModels);

        // Register tool models
        registerToolsModels(itemModels, blockModels);

        // Register block models
        registerBlockModels(itemModels, blockModels);

        // Register items models
        registerItemsModels(itemModels, blockModels);
    }

    @Override
    protected Stream<? extends Holder<Item>> getKnownItems() {
        return ModItems.ITEMS.getEntries().stream();
    }

    private void registerItemsModels(ItemModelGenerators itemModels, BlockModelGenerators blockModels) {
        itemModels.generateFlatItem(ModItems.STEEL_INGOT.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ModItems.RUBY.get(), ModelTemplates.FLAT_ITEM);
    }

    private void registerFoodModels(ItemModelGenerators itemModels, BlockModelGenerators blockModels) {
        itemModels.generateFlatItem(ModItems.CHERRY.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ModItems.ORANGE.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ModItems.BANANA.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ModItems.COCONUT.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ModItems.APPLE_PIE.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ModItems.CHERRY_PIE.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ModItems.ORANGE_PIE.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ModItems.BANANA_PIE.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ModItems.COCONUT_PIE.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ModItems.CHERRY_JAM.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ModItems.ORANGE_JAM.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ModItems.BANANA_JAM.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ModItems.APPLE_JAM.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ModItems.MEAT_SKEWER.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ModItems.MEAT_CHEESE_SKEWER.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ModItems.CHICKEN_SKEWER.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ModItems.FISH_SKEWER.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ModItems.CACTUS_SKEWER.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ModItems.DIRT_SOUP.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ModItems.GRAVEL_SOUP.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ModItems.LAVA_SOUP.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ModItems.ENDER_SOUP.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ModItems.SAUSAGE.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ModItems.OMELETTE.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ModItems.CHEESE_OMELETTE.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ModItems.COOKED_TROPICAL_FISH.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ModItems.CHEESE.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ModItems.SMOKED_CHEESE.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ModItems.ZOMBIE_JERKY.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ModItems.PIZZA.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ModItems.HOTDOG.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ModItems.HAMBURGER.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ModItems.STONE_BREAD.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ModItems.COMPRESSED_BREAD.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ModItems.CHOCOLATE.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ModItems.HOT_CHOCOLATE.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ModItems.ENDER_COOKIE.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ModItems.RANDOM_COOKIE.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ModItems.VOID_COOKIE.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ModItems.PANCAKE.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ModItems.DUBIOUS_FOOD.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ModItems.THE_THING.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ModItems.NETHERITE_STEAK.get(), ModelTemplates.FLAT_ITEM);

        ModModels.createCakeModels(ModBlocks.ENDCAKE_BLOCK.get(), ModBlocks.ENDCAKE_BLOCK.asItem(), blockModels, itemModels);
    }

    private void registerToolsModels(ItemModelGenerators itemModels, BlockModelGenerators blockModels) {
        itemModels.generateFlatItem(ModItems.FISH_SWORD.get(), ModelTemplates.FLAT_HANDHELD_ITEM);

        itemModels.generateTrimmableItem(ModItems.CACTUS_HELMET.get(), ModArmorMaterials.CACTUS, ResourceLocation.fromNamespaceAndPath(NecessariesMod.MOD_ID, "cactus"), false);
        itemModels.generateTrimmableItem(ModItems.CACTUS_CHESTPLATE.get(), ModArmorMaterials.CACTUS, ResourceLocation.fromNamespaceAndPath(NecessariesMod.MOD_ID, "cactus"), false);
        itemModels.generateTrimmableItem(ModItems.CACTUS_LEGGINGS.get(), ModArmorMaterials.CACTUS, ResourceLocation.fromNamespaceAndPath(NecessariesMod.MOD_ID, "cactus"), false);
        itemModels.generateTrimmableItem(ModItems.CACTUS_BOOTS.get(), ModArmorMaterials.CACTUS, ResourceLocation.fromNamespaceAndPath(NecessariesMod.MOD_ID, "cactus"),  false);

        itemModels.generateTrimmableItem(ModItems.OBSIDIAN_HELMET.get(), ModArmorMaterials.OBSIDIAN, ResourceLocation.fromNamespaceAndPath(NecessariesMod.MOD_ID, "obsidian"), false);
        itemModels.generateTrimmableItem(ModItems.OBSIDIAN_CHESTPLATE.get(), ModArmorMaterials.OBSIDIAN, ResourceLocation.fromNamespaceAndPath(NecessariesMod.MOD_ID, "obsidian"), false);
        itemModels.generateTrimmableItem(ModItems.OBSIDIAN_LEGGINGS.get(), ModArmorMaterials.OBSIDIAN, ResourceLocation.fromNamespaceAndPath(NecessariesMod.MOD_ID, "obsidian"), false);
        itemModels.generateTrimmableItem(ModItems.OBSIDIAN_BOOTS.get(), ModArmorMaterials.OBSIDIAN, ResourceLocation.fromNamespaceAndPath(NecessariesMod.MOD_ID, "obsidian"), false);
    }

    private void registerBlockModels(ItemModelGenerators itemModels, BlockModelGenerators blockModels) {
        blockModels.createTrivialCube(ModBlocks.RUBY_BLOCK.get());
        blockModels.createTrivialCube(ModBlocks.STEEL_BLOCK.get());
        blockModels.createTrivialCube(ModBlocks.RUBY_ORE.get());
        blockModels.createTrivialCube(ModBlocks.DEEPSLATE_RUBY_ORE.get());
    }
}
