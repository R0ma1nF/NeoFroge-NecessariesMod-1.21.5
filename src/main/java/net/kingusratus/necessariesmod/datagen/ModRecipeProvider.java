package net.kingusratus.necessariesmod.datagen;

import net.kingusratus.necessariesmod.NecessariesMod;
import net.kingusratus.necessariesmod.block.ModBlocks;
import net.kingusratus.necessariesmod.item.ModItems;
import net.kingusratus.necessariesmod.utils.ModTags;
import net.minecraft.advancements.Advancement;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider {

    // Constants pour les valeurs de cuisson communes
    private static final float COOKING_EXPERIENCE = 0.35f;
    private static final int COOKING_TIME = 200;

    protected ModRecipeProvider(HolderLookup.Provider provider, RecipeOutput output) {
        super(provider, output);
    }

    @Override
    protected void buildRecipes() {
        buildShapedRecipes();
        buildShapelessRecipes();
        buildSmeltingRecipes();
        buildBlastingRecipes();
        buildSmokingRecipes();
        buildCampfireRecipes();
        buildStoneCuttingRecipes();
        buildMiscRecipes();
    }

    // ================================
    // SHAPED RECIPES
    // ================================

    private void buildShapedRecipes() {
        // Recettes de nourriture de base
        buildBasicFoodRecipes();

        // Recettes de brochettes
        buildSkewerRecipes();

        // Recettes spéciales
        buildSpecialRecipes();

        // Recettes d'armures
        buildArmorRecipes();
    }

    private void buildBasicFoodRecipes() {
        shaped(RecipeCategory.FOOD, ModItems.SAUSAGE.get(), 3)
                .pattern("MMM")
                .define('M', ModTags.Items.MEATS)
                .unlockedBy("has_meat", has(ModTags.Items.MEATS))
                .save(this.output);

        shaped(RecipeCategory.FOOD, ModItems.HOTDOG)
                .pattern("BSB")
                .define('B', Items.BREAD)
                .define('S', ModItems.SAUSAGE.get())
                .unlockedBy("has_sausage", has(ModItems.SAUSAGE.get()))
                .save(this.output);

        shaped(RecipeCategory.FOOD, ModItems.HAMBURGER.get())
                .pattern(" B ")
                .pattern("CMC")
                .pattern(" B ")
                .define('B', Items.BREAD)
                .define('C', ModItems.CHEESE.get())
                .define('M', ModTags.Items.MEATS)
                .unlockedBy("has_meat", has(ModTags.Items.MEATS))
                .unlockedBy("has_cheese", has(ModItems.CHEESE.get()))
                .save(this.output);

        shaped(RecipeCategory.FOOD, ModItems.PIZZA.get())
                .pattern("C")
                .pattern("M")
                .pattern("B")
                .define('C', ModItems.CHEESE.get())
                .define('M', ModTags.Items.MEATS)
                .define('B', Items.BREAD)
                .unlockedBy("has_meat", has(ModTags.Items.MEATS))
                .unlockedBy("has_cheese", has(ModItems.CHEESE.get()))
                .save(this.output);

        shaped(RecipeCategory.FOOD, ModItems.PANCAKE.get(), 3)
                .pattern("SHS")
                .pattern("WWW")
                .pattern("EME")
                .define('S', Items.SUGAR)
                .define('H', Items.HONEY_BOTTLE)
                .define('W', Items.WHEAT)
                .define('E', ItemTags.EGGS)
                .define('M', Items.MILK_BUCKET)
                .unlockedBy("has_honey", has(Items.HONEY_BOTTLE))
                .save(this.output);
    }

    private void buildSkewerRecipes() {
        shaped(RecipeCategory.FOOD, ModItems.MEAT_SKEWER.get(), 3)
                .pattern("MMM")
                .pattern(" S ")
                .define('M', ModTags.Items.MEATS)
                .define('S', Items.STICK)
                .unlockedBy("has_meat", has(ModTags.Items.MEATS))
                .save(this.output);

        shaped(RecipeCategory.FOOD, ModItems.MEAT_CHEESE_SKEWER.get(), 3)
                .pattern("MCM")
                .pattern(" S ")
                .define('M', ModTags.Items.MEATS)
                .define('C', ModItems.CHEESE.get())
                .define('S', Items.STICK)
                .unlockedBy("has_meat", has(ModTags.Items.MEATS))
                .unlockedBy("has_cheese", has(ModItems.CHEESE.get()))
                .save(this.output);

        shaped(RecipeCategory.FOOD, ModItems.CHICKEN_SKEWER.get(), 3)
                .pattern("CCC")
                .pattern(" S ")
                .define('C', Items.COOKED_CHICKEN)
                .define('S', Items.STICK)
                .unlockedBy("has_chicken", has(Items.COOKED_CHICKEN))
                .save(this.output);

        shaped(RecipeCategory.FOOD, ModItems.FISH_SKEWER.get(), 3)
                .pattern("FFF")
                .pattern(" S ")
                .define('F', ModTags.Items.FISHES)
                .define('S', Items.STICK)
                .unlockedBy("has_fish", has(ModTags.Items.FISHES))
                .save(this.output);

        shaped(RecipeCategory.FOOD, ModItems.CACTUS_SKEWER.get(), 3)
                .pattern("CCC")
                .pattern(" S ")
                .define('C', Items.CACTUS)
                .define('S', Items.STICK)
                .unlockedBy("has_cactus", has(Items.CACTUS))
                .save(this.output);
    }

    private void buildSpecialRecipes() {
        shaped(RecipeCategory.FOOD, ModItems.STONE_BREAD.get(), 1)
                .pattern("CWC")
                .define('C', Items.COBBLESTONE)
                .define('W', Items.WHEAT)
                .unlockedBy("has_wheat", has(Items.WHEAT))
                .save(this.output);

        shaped(RecipeCategory.FOOD, ModBlocks.ENDCAKE_BLOCK.asItem())
                .pattern("MMM")
                .pattern("SES")
                .pattern("WWW")
                .define('M', Items.MILK_BUCKET)
                .define('S', Items.SUGAR)
                .define('E', Items.DRAGON_EGG)
                .define('W', Items.WHEAT)
                .unlockedBy("has_dragon_egg", has(Items.DRAGON_EGG))
                .save(this.output);

        shaped(RecipeCategory.FOOD, ModItems.COMPRESSED_BREAD.get(), 1)
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .define('#', Items.BREAD)
                .unlockedBy("has_bread", has(Items.BREAD))
                .save(this.output);

        shaped(RecipeCategory.FOOD, ModItems.FISH_SWORD.get(), 1)
                .pattern("F")
                .pattern("F")
                .pattern("S")
                .define('F', ModTags.Items.FISHES)
                .define('S', Items.STICK)
                .unlockedBy("has_fishes", has(ModTags.Items.FISHES))
                .save(this.output);

    }

    private void buildMiscRecipes() {
        shaped(RecipeCategory.MISC, ModItems.COPPER_COIL.get(), 1)
                .pattern("CCC")
                .pattern("CSC")
                .pattern("CCC")
                .define('C', ModItems.COPPER_WIRE.get())
                .define('S', Items.STICK)
                .unlockedBy("has_copper_wire", has(ModItems.COPPER_WIRE.get()))
                .save(this.output);

        shaped(RecipeCategory.MISC, ModItems.ELECTRONIC_CIRCUIT.get(), 1)
                .pattern("WCW")
                .pattern("RIR")
                .pattern("WGW")
                .define('W', ModItems.COPPER_WIRE.get())
                .define('C', Items.GREEN_DYE)
                .define('R', Items.REDSTONE)
                .define('I', Items.IRON_INGOT)
                .define('G', Items.GOLD_INGOT)
                .unlockedBy("has_copper_wire", has(ModItems.COPPER_WIRE.get()))
                .unlockedBy("has_redstone", has(Items.REDSTONE))
                .unlockedBy("has_iron_ingot", has(Items.IRON_INGOT))
                .unlockedBy("has_gold_ingot", has(Items.GOLD_INGOT))
                .save(this.output);

        shaped(RecipeCategory.MISC, ModItems.IRON_PLATE.get(), 1)
                .pattern("III")
                .define('I', Items.IRON_INGOT)
                .unlockedBy("has_iron_ingot", has(Items.IRON_INGOT))
                .save(this.output);

        shaped(RecipeCategory.MISC, ModItems.REINFORCED_STICK.get(), 1)
                .pattern("ISI")
                .pattern("ISI")
                .pattern("ISI")
                .define('I', Items.IRON_INGOT)
                .define('S', Items.STICK)
                .unlockedBy("has_iron_ingot", has(Items.IRON_INGOT))
                .unlockedBy("has_stick", has(Items.STICK))
                .save(this.output);

        shaped(RecipeCategory.MISC, ModItems.IRON_CASING.get(), 1)
                .pattern("III")
                .pattern("I I")
                .pattern("III")
                .define('I', Items.IRON_INGOT)
                .unlockedBy("has_iron_ingot", has(Items.IRON_INGOT))
                .save(this.output);

        shaped(RecipeCategory.MISC, ModItems.DRILL_HEAD.get(), 1)
                .pattern(" D ")
                .pattern("DSD")
                .pattern("SSS")
                .define('D', Blocks.DIAMOND_BLOCK)
                .define('S', ModItems.STEEL_INGOT.get())
                .unlockedBy("has_diamond_block", has(Blocks.DIAMOND_BLOCK))
                .unlockedBy("has_steel_ingot", has(ModItems.STEEL_INGOT.get()))
                .save(this.output);

        shaped(RecipeCategory.MISC, ModItems.DRILL_CASING.get(), 1)
                .pattern("SPS")
                .pattern("SCS")
                .pattern("SPS")
                .define('S', ModItems.STEEL_INGOT.get())
                .define('P', ModItems.IRON_PLATE.get())
                .define('C', ModItems.IRON_CASING.get())
                .unlockedBy("has_steel_ingot", has(ModItems.STEEL_INGOT.get()))
                .unlockedBy("has_iron_plate", has(ModItems.IRON_PLATE.get()))
                .unlockedBy("has_iron_casing", has(ModItems.IRON_CASING.get()))
                .save(this.output);

        shaped(RecipeCategory.MISC, ModItems.DRILL_ENGINE.get(), 1)
                .pattern("SIS")
                .pattern("RPR")
                .pattern("CEC")
                .define('S', ModItems.STEEL_INGOT.get())
                .define('I', Blocks.IRON_BLOCK)
                .define('R', Items.REDSTONE)
                .define('P', Blocks.PISTON)
                .define('C', ModItems.COPPER_COIL.get())
                .define('E', ModItems.ELECTRONIC_CIRCUIT.get())
                .unlockedBy("has_steel_ingot", has(ModItems.STEEL_INGOT.get()))
                .unlockedBy("has_iron_block", has(Blocks.IRON_BLOCK))
                .unlockedBy("has_redstone", has(Items.REDSTONE))
                .unlockedBy("has_piston", has(Blocks.PISTON))
                .unlockedBy("has_copper_coil", has(ModItems.COPPER_COIL.get()))
                .unlockedBy("has_electronic_circuit", has(ModItems.ELECTRONIC_CIRCUIT.get()))
                .save(this.output);

        shaped(RecipeCategory.MISC, ModItems.DRILL_HANDLE.get(), 1)
                .pattern("LSL")
                .pattern("LIL")
                .pattern("LSL")
                .define('L', Items.LEATHER)
                .define('S', ModItems.REINFORCED_STICK.get())
                .define('I', Items.IRON_INGOT)
                .unlockedBy("has_leather", has(Items.LEATHER))
                .unlockedBy("has_reinforced_stick", has(ModItems.REINFORCED_STICK.get()))
                .unlockedBy("has_iron_ingot", has(Items.IRON_INGOT))
                .save(this.output);

        shaped(RecipeCategory.MISC, ModItems.DRILL.get(), 1)
                .pattern("SHS")
                .pattern("DCD")
                .pattern("SES")
                .define('H', ModItems.DRILL_HEAD.get())
                .define('S', ModItems.STEEL_INGOT.get())
                .define('D', ModItems.DRILL_HANDLE.get())
                .define('C', ModItems.DRILL_CASING.get())
                .define('E', ModItems.DRILL_ENGINE.get())
                .unlockedBy("has_drill_head", has(ModItems.DRILL_HEAD.get()))
                .unlockedBy("has_steel_ingot", has(ModItems.STEEL_INGOT.get()))
                .unlockedBy("has_drill_handle", has(ModItems.DRILL_HANDLE.get()))
                .unlockedBy("has_drill_casing", has(ModItems.DRILL_CASING.get()))
                .unlockedBy("has_drill_engine", has(ModItems.DRILL_ENGINE.get()))
                .save(this.output);
    }

    private void buildArmorRecipes() {
        shaped(RecipeCategory.COMBAT, ModItems.CACTUS_HELMET.get())
                .pattern("CCC")
                .pattern("C C")
                .define('C', Items.CACTUS)
                .unlockedBy("has_cactus", has(Items.CACTUS))
                .save(this.output);

        shaped(RecipeCategory.COMBAT, ModItems.CACTUS_CHESTPLATE.get())
                .pattern("C C")
                .pattern("CCC")
                .pattern("CCC")
                .define('C', Items.CACTUS)
                .unlockedBy("has_cactus", has(Items.CACTUS))
                .save(this.output);

        shaped(RecipeCategory.COMBAT, ModItems.CACTUS_LEGGINGS.get())
                .pattern("CCC")
                .pattern("C C")
                .pattern("C C")
                .define('C', Items.CACTUS)
                .unlockedBy("has_cactus", has(Items.CACTUS))
                .save(this.output);

        shaped(RecipeCategory.COMBAT, ModItems.CACTUS_BOOTS.get())
                .pattern("C C")
                .pattern("C C")
                .define('C', Items.CACTUS)
                .unlockedBy("has_cactus", has(Items.CACTUS))
                .save(this.output);

        shaped(RecipeCategory.COMBAT, ModItems.OBSIDIAN_HELMET.get())
                .pattern("OOO")
                .pattern("O O")
                .define('O', Items.OBSIDIAN)
                .unlockedBy("has_obsidian", has(Items.OBSIDIAN))
                .save(this.output);

        shaped(RecipeCategory.COMBAT, ModItems.OBSIDIAN_CHESTPLATE.get())
                .pattern("O O")
                .pattern("OOO")
                .pattern("OOO")
                .define('O', Items.OBSIDIAN)
                .unlockedBy("has_obsidian", has(Items.OBSIDIAN))
                .save(this.output);

        shaped(RecipeCategory.COMBAT, ModItems.OBSIDIAN_LEGGINGS.get())
                .pattern("OOO")
                .pattern("O O")
                .pattern("O O")
                .define('O', Items.OBSIDIAN)
                .unlockedBy("has_obsidian", has(Items.OBSIDIAN))
                .save(this.output);

        shaped(RecipeCategory.COMBAT, ModItems.OBSIDIAN_BOOTS.get())
                .pattern("O O")
                .pattern("O O")
                .define('O', Items.OBSIDIAN)
                .unlockedBy("has_obsidian", has(Items.OBSIDIAN))
                .save(this.output);
    }

    // ================================
    // SHAPELESS RECIPES
    // ================================

    private void buildShapelessRecipes() {
        buildCookieRecipes();
        buildPieRecipes();
        buildJamRecipes();
        buildSoupRecipes();
        buildMiscShapelessRecipes();
    }

    private void buildCookieRecipes() {
        shapeless(RecipeCategory.FOOD, ModItems.ENDER_COOKIE, 4)
                .requires(Items.ENDER_EYE)
                .requires(Items.WHEAT)
                .requires(Items.SUGAR)
                .unlockedBy("has_ender_pearl", has(Items.ENDER_PEARL))
                .save(this.output);

        shapeless(RecipeCategory.FOOD, ModItems.RANDOM_COOKIE, 4)
                .requires(ModItems.DUBIOUS_FOOD)
                .requires(Items.WHEAT)
                .requires(Items.SUGAR)
                .unlockedBy("has_dubious_food", has(ModItems.DUBIOUS_FOOD))
                .save(this.output);

        shapeless(RecipeCategory.FOOD, ModItems.VOID_COOKIE, 1)
                .requires(Items.NETHER_STAR)
                .requires(Items.DRAGON_BREATH)
                .requires(Items.WHEAT)
                .requires(Items.SUGAR)
                .unlockedBy("has_nether_star", has(Items.NETHER_STAR))
                .save(this.output);
    }

    private void buildPieRecipes() {
        shapeless(RecipeCategory.FOOD, ModItems.APPLE_PIE, 1)
                .requires(Items.APPLE)
                .requires(Items.SUGAR)
                .requires(ItemTags.EGGS)
                .unlockedBy("has_apple", has(Items.APPLE))
                .unlockedBy("has_sugar", has(Items.SUGAR))
                .unlockedBy("has_egg", has(ItemTags.EGGS))
                .save(this.output);

        // orange, cherry, banana and coconut pies
        shapeless(RecipeCategory.FOOD, ModItems.CHERRY_PIE, 1)
                .requires(ModItems.CHERRY.get())
                .requires(Items.SUGAR)
                .requires(ItemTags.EGGS)
                .unlockedBy("has_cherry", has(ModItems.CHERRY.get()))
                .unlockedBy("has_sugar", has(Items.SUGAR))
                .unlockedBy("has_egg", has(ItemTags.EGGS))
                .save(this.output);

        shapeless(RecipeCategory.FOOD, ModItems.ORANGE_PIE, 1)
                .requires(ModItems.ORANGE.get())
                .requires(Items.SUGAR)
                .requires(ItemTags.EGGS)
                .unlockedBy("has_orange", has(ModItems.ORANGE.get()))
                .save(this.output);

        shapeless(RecipeCategory.FOOD, ModItems.BANANA_PIE, 1)
                .requires(ModItems.BANANA.get())
                .requires(Items.SUGAR)
                .requires(ItemTags.EGGS)
                .unlockedBy("has_banana", has(ModItems.BANANA.get()))
                .save(this.output);

        shapeless(RecipeCategory.FOOD, ModItems.COCONUT_PIE, 1)
                .requires(ModItems.COCONUT.get())
                .requires(Items.SUGAR)
                .requires(ItemTags.EGGS)
                .unlockedBy("has_coconut", has(ModItems.COCONUT.get()))
                .save(this.output);
    }

    private void buildJamRecipes() {
        shapeless(RecipeCategory.FOOD, ModItems.APPLE_JAM, 2)
                .requires(Items.APPLE)
                .requires(Items.SUGAR)
                .unlockedBy("has_apple", has(Items.APPLE))
                .unlockedBy("has_sugar", has(Items.SUGAR))
                .save(this.output);

        shapeless(RecipeCategory.FOOD, ModItems.CHERRY_JAM, 2)
                .requires(ModItems.CHERRY.get())
                .requires(Items.SUGAR)
                .unlockedBy("has_cherry", has(ModItems.CHERRY.get()))
                .unlockedBy("has_sugar", has(Items.SUGAR))
                .save(this.output);

        shapeless(RecipeCategory.FOOD, ModItems.ORANGE_JAM, 2)
                .requires(ModItems.ORANGE.get())
                .requires(Items.SUGAR)
                .unlockedBy("has_orange", has(ModItems.ORANGE.get()))
                .unlockedBy("has_sugar", has(Items.SUGAR))
                .save(this.output);

        shapeless(RecipeCategory.FOOD, ModItems.BANANA_JAM, 2)
                .requires(ModItems.BANANA.get())
                .requires(Items.SUGAR)
                .unlockedBy("has_banana", has(ModItems.BANANA.get()))
                .unlockedBy("has_sugar", has(Items.SUGAR))
                .save(this.output);
    }

    private void buildSoupRecipes() {
        shapeless(RecipeCategory.FOOD, ModItems.DIRT_SOUP)
                .requires(Items.DIRT)
                .requires(Items.BOWL)
                .unlockedBy("has_dirt", has(Items.DIRT))
                .save(this.output);

        shapeless(RecipeCategory.FOOD, ModItems.GRAVEL_SOUP)
                .requires(Items.GRAVEL)
                .requires(Items.BOWL)
                .unlockedBy("has_gravel", has(Items.GRAVEL))
                .save(this.output);

        shapeless(RecipeCategory.FOOD, ModItems.LAVA_SOUP)
                .requires(Items.LAVA_BUCKET)
                .requires(Items.BOWL)
                .unlockedBy("has_lava", has(Items.LAVA_BUCKET))
                .save(this.output);

        shapeless(RecipeCategory.FOOD, ModItems.ENDER_SOUP)
                .requires(Items.DRAGON_BREATH)
                .requires(Items.CHORUS_FRUIT)
                .requires(Items.BOWL)
                .unlockedBy("has_dragon_breath", has(Items.DRAGON_BREATH))
                .save(this.output);
    }

    private void buildMiscShapelessRecipes() {
        shapeless(RecipeCategory.FOOD, Items.BREAD, 9)
                .requires(ModItems.COMPRESSED_BREAD)
                .unlockedBy("has_compressed_bread", has(ModItems.COMPRESSED_BREAD))
                .save(this.output);

        shapeless(RecipeCategory.FOOD, ModItems.THE_THING, 1)
                .requires(Items.NETHER_STAR)
                .requires(ModItems.DUBIOUS_FOOD)
                .requires(ModItems.DIRT_SOUP)
                .requires(ModItems.GRAVEL_SOUP)
                .unlockedBy("has_nether_star", has(Items.NETHER_STAR))
                .save(this.output);

        shapeless(RecipeCategory.FOOD, ModItems.CHOCOLATE.get(), 1)
                .requires(Items.COCOA_BEANS)
                .requires(Items.SUGAR)
                .unlockedBy("has_cacao", has(Items.COCOA_BEANS))
                .unlockedBy("has_sugar", has(Items.SUGAR))
                .save(this.output);

        shapeless(RecipeCategory.FOOD, ModItems.HOT_CHOCOLATE, 3)
                .requires(ModItems.CHOCOLATE.get())
                .requires(Items.MILK_BUCKET)
                .unlockedBy("has_chocolate", has(ModItems.CHOCOLATE.get()))
                .unlockedBy("has_milk", has(Items.MILK_BUCKET))
                .save(this.output);

        shapeless(RecipeCategory.FOOD, ModItems.CHEESE_OMELETTE)
                .requires(ModItems.CHEESE.get())
                .requires(ModItems.OMELETTE.get())
                .unlockedBy("has_cheese", has(ModItems.CHEESE.get()))
                .unlockedBy("has_omelette", has(ModItems.OMELETTE.get()))
                .save(this.output);

        shapeless(RecipeCategory.FOOD, ModItems.NETHERITE_STEAK)
                .requires(Items.COOKED_BEEF)
                .requires(Items.NETHERITE_SCRAP)
                .requires(Items.NETHERITE_SCRAP)
                .unlockedBy("has_netherite_scrap", has(Items.NETHERITE_SCRAP))
                .save(this.output);

        shapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.RUBY_BLOCK)
                .requires(ModItems.RUBY.get(), 9)
                .unlockedBy("has_ruby", has(ModItems.RUBY.get()))
                .save(this.output);

        shapeless(RecipeCategory.MISC, ModItems.RUBY.get(), 9)
                .requires(ModBlocks.RUBY_BLOCK)
                .unlockedBy("has_ruby_block", has(ModBlocks.RUBY_BLOCK))
                .save(this.output);

        shapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.STEEL_BLOCK)
                .requires(ModItems.STEEL_INGOT.get(), 9)
                .unlockedBy("has_steel_ingot", has(ModItems.STEEL_INGOT.get()))
                .save(this.output);

        shapeless(RecipeCategory.MISC, ModItems.STEEL_INGOT.get(), 9)
                .requires(ModBlocks.STEEL_BLOCK)
                .unlockedBy("has_steel_block", has(ModBlocks.STEEL_BLOCK))
                .save(this.output);

    }

    // ================================
    // SMELTING, SMOKING, BLASTING & CAMPFIRE
    // ================================

    private void buildSmeltingRecipes() {
        oreSmelting(this.output, List.of(Items.MILK_BUCKET), RecipeCategory.FOOD,
                   new ItemStack(ModItems.CHEESE.get(), 8), COOKING_EXPERIENCE, COOKING_TIME, "cheese");

        oreSmelting(this.output, List.of(Items.EGG, Items.BLUE_EGG, Items.BROWN_EGG),
                   RecipeCategory.FOOD, ModItems.OMELETTE.get(), COOKING_EXPERIENCE, COOKING_TIME, "omelette");

        oreSmelting(this.output, List.of(Items.ROTTEN_FLESH), RecipeCategory.FOOD,
                   ModItems.ZOMBIE_JERKY.get(), COOKING_EXPERIENCE, COOKING_TIME, "zombie_jerky");

        oreSmelting(this.output, List.of(Items.TROPICAL_FISH), RecipeCategory.FOOD,
                   ModItems.COOKED_TROPICAL_FISH.get(), COOKING_EXPERIENCE, COOKING_TIME, "cooked_tropical_fish");
        oreSmelting(
                this.output,
                List.of(ModBlocks.RUBY_ORE.get()),
                RecipeCategory.MISC,
                ModItems.RUBY.get(),
                1f,
                200,
                "ruby_from_ore"
        );

        oreSmelting(
                this.output,
                List.of(ModBlocks.DEEPSLATE_RUBY_ORE.get()),
                RecipeCategory.MISC,
                ModItems.RUBY.get(),
                1f,
                200,
                "ruby_from_ore"
        );
    }

    private void buildStoneCuttingRecipes() {
        oreStonecutting(this.output, Items.COPPER_INGOT, RecipeCategory.MISC,
                new ItemStack(ModItems.COPPER_WIRE.get(), 3), "copper_wire");
    }

    private void buildSmokingRecipes() {
        oreSmoking(this.output, List.of(Items.MILK_BUCKET), RecipeCategory.FOOD,
                new ItemStack(ModItems.CHEESE.get(), 8), COOKING_EXPERIENCE, COOKING_TIME, "cheese");

        oreSmoking(this.output, List.of(Items.EGG, Items.BLUE_EGG, Items.BROWN_EGG),
                RecipeCategory.FOOD, ModItems.OMELETTE.get(), COOKING_EXPERIENCE, COOKING_TIME, "omelette");

        oreSmoking(this.output, List.of(ModItems.CHEESE.get()), RecipeCategory.FOOD,
                ModItems.SMOKED_CHEESE.get(), COOKING_EXPERIENCE, COOKING_TIME, "smoked_cheese");

        oreSmoking(this.output, List.of(Items.ROTTEN_FLESH), RecipeCategory.FOOD,
                ModItems.ZOMBIE_JERKY.get(), COOKING_EXPERIENCE, COOKING_TIME, "zombie_jerky");

        oreSmoking(this.output, List.of(Items.TROPICAL_FISH), RecipeCategory.FOOD,
                ModItems.COOKED_TROPICAL_FISH.get(), COOKING_EXPERIENCE, COOKING_TIME, "cooked_tropical_fish");
    }

    private void buildBlastingRecipes() {
        oreBlasting(this.output, List.of(ModItems.IRON_PLATE.get()), RecipeCategory.MISC,
                ModItems.STEEL_INGOT.get(), 0.50f, 250, "steel_ingot_from_blasting");

        oreBlasting(this.output, List.of(ModBlocks.RUBY_ORE.get()), RecipeCategory.MISC,
                ModItems.RUBY.get(), 1f, 100, "ruby_from_ore");

        oreBlasting(this.output, List.of(ModBlocks.DEEPSLATE_RUBY_ORE.get()), RecipeCategory.MISC,
                ModItems.RUBY.get(), 1f, 100, "ruby_from_ore");
    }

    private void buildCampfireRecipes() {
        oreCampfireCooking(this.output, List.of(Items.EGG, Items.BLUE_EGG, Items.BROWN_EGG),
                          RecipeCategory.FOOD, ModItems.OMELETTE.get(), COOKING_EXPERIENCE, COOKING_TIME, "omelette");

        oreCampfireCooking(this.output, List.of(ModItems.CHEESE.get()), RecipeCategory.FOOD,
                          ModItems.SMOKED_CHEESE.get(), COOKING_EXPERIENCE, COOKING_TIME, "smoked_cheese");

        oreCampfireCooking(this.output, List.of(Items.MILK_BUCKET), RecipeCategory.FOOD,
                          new ItemStack(ModItems.CHEESE.get(), 8), COOKING_EXPERIENCE, COOKING_TIME, "cheese");

        oreCampfireCooking(this.output, List.of(Items.ROTTEN_FLESH), RecipeCategory.FOOD,
                          ModItems.ZOMBIE_JERKY.get(), COOKING_EXPERIENCE, COOKING_TIME, "zombie_jerky");

        oreCampfireCooking(this.output, List.of(Items.TROPICAL_FISH), RecipeCategory.FOOD,
                          ModItems.COOKED_TROPICAL_FISH.get(), COOKING_EXPERIENCE, COOKING_TIME, "cooked_tropical_fish");

    }

    // ================================
    // MÉTHODES UTILITAIRES
    // ================================

    protected void oreStonecutting(RecipeOutput recipeOutput, ItemLike pIngredient, RecipeCategory pCategory, ItemLike pResult, String pGroup) {
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(pIngredient), pCategory, pResult)
                .group(pGroup)
                .unlockedBy(getHasName(pIngredient), has(pIngredient))
                .save(recipeOutput, NecessariesMod.MOD_ID + ":" + getItemName(pResult) + "_from_stonecutting_" + getItemName(pIngredient));
    }

    protected void oreSmelting(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                               float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(recipeOutput, RecipeSerializer.SMELTING_RECIPE, SmeltingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected void oreBlasting(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                               float pExperience, int pCookingTime, String pGroup) {
        oreCooking(recipeOutput, RecipeSerializer.BLASTING_RECIPE, BlastingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected void oreSmoking(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                              float pExperience, int pCookingTime, String pGroup) {
        oreCooking(recipeOutput, RecipeSerializer.SMOKING_RECIPE, SmokingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTime, pGroup, "_from_smoking");
    }

    protected void oreCampfireCooking(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTime, String pGroup) {
        oreCooking(recipeOutput, RecipeSerializer.CAMPFIRE_COOKING_RECIPE, CampfireCookingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTime, pGroup, "_from_campfire");
    }

    protected <T extends AbstractCookingRecipe> void oreCooking(RecipeOutput recipeOutput, RecipeSerializer<T> pCookingSerializer, AbstractCookingRecipe.Factory<T> factory,
                                                                List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        for(ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult, pExperience, pCookingTime, pCookingSerializer, factory).group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(recipeOutput, NecessariesMod.MOD_ID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }
    }

    protected void oreStonecutting(RecipeOutput recipeOutput, ItemLike pIngredient, RecipeCategory pCategory, ItemStack pResult, String pGroup) {
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(pIngredient), pCategory, pResult.getItem())
                .group(pGroup)
                .unlockedBy(getHasName(pIngredient), has(pIngredient))
                .save(recipeOutput, NecessariesMod.MOD_ID + ":" + getItemName(pResult.getItem()) + "_from_stonecutting_" + getItemName(pIngredient));
    }

    protected void oreSmelting(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemStack pResult,
                               float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(recipeOutput, RecipeSerializer.SMELTING_RECIPE, SmeltingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected void oreBlasting(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemStack pResult,
                               float pExperience, int pCookingTime, String pGroup) {
        oreCooking(recipeOutput, RecipeSerializer.BLASTING_RECIPE, BlastingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected void oreSmoking(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemStack pResult,
                              float pExperience, int pCookingTime, String pGroup) {
        oreCooking(recipeOutput, RecipeSerializer.SMOKING_RECIPE, SmokingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTime, pGroup, "_from_smoking");
    }

    protected void oreCampfireCooking(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemStack pResult,
                                      float pExperience, int pCookingTime, String pGroup) {
        oreCooking(recipeOutput, RecipeSerializer.CAMPFIRE_COOKING_RECIPE, CampfireCookingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTime, pGroup, "_from_campfire");
    }

    protected <T extends AbstractCookingRecipe> void oreCooking(RecipeOutput recipeOutput, RecipeSerializer<T> pCookingSerializer, AbstractCookingRecipe.Factory<T> factory,
                                                                List<ItemLike> pIngredients, RecipeCategory pCategory, ItemStack pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        for(ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult, pExperience, pCookingTime, pCookingSerializer, factory).group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(recipeOutput, NecessariesMod.MOD_ID + ":" + getItemName(pResult.getItem()) + pRecipeName + "_" + getItemName(itemlike));
        }
    }

    public static class Runner extends RecipeProvider.Runner {
        public Runner(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
            super(output, lookupProvider);
        }

        @Override
        protected RecipeProvider createRecipeProvider(HolderLookup.Provider provider, RecipeOutput output) {
            return new ModRecipeProvider(provider, output);
        }

        @Override
        public String getName() {
            return "";
        }
    }
}
