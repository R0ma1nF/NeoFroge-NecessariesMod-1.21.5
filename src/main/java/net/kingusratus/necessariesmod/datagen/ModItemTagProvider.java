package net.kingusratus.necessariesmod.datagen;

import net.kingusratus.necessariesmod.NecessariesMod;
import net.kingusratus.necessariesmod.item.ModItems;
import net.kingusratus.necessariesmod.utils.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends ItemTagsProvider {
    public ModItemTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider,
                              CompletableFuture<TagLookup<Block>> blockTags) {
        super(output, lookupProvider, blockTags, NecessariesMod.MOD_ID);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(ModTags.Items.MEATS)
                .add(Items.COOKED_BEEF)
                .add(Items.COOKED_MUTTON)
                .add(Items.COOKED_PORKCHOP)
                .add(Items.COOKED_RABBIT);

        tag(ModTags.Items.FISHES)
                .add(Items.COOKED_COD)
                .add(Items.COOKED_SALMON)
                .add(ModItems.COOKED_TROPICAL_FISH.get());

        tag(ItemTags.SWORDS)
                .add(ModItems.FISH_SWORD.get());

        tag(ModTags.Items.TRASH)
                .add(Items.STICK)
                .add(Items.FEATHER)
                .add(Items.STRING)
                .add(Items.LEATHER)
                .add(Items.BONE)
                .add(Items.SPIDER_EYE)
                .add(Items.POISONOUS_POTATO)
                .add(Items.PAPER)
                .add(Items.SLIME_BALL)
                .add(Items.ENDER_PEARL)
                .add(Items.GHAST_TEAR)
                .add(Items.BLAZE_ROD)
                .add(Items.NETHER_STAR)
                .add(Items.PHANTOM_MEMBRANE)
                .add(Items.SHULKER_SHELL)
                .add(Items.TOTEM_OF_UNDYING)
                .add(Items.BOOK)
                .add(Items.ARROW)
                .add(Items.FIREWORK_ROCKET)
                .add(Items.LEAD)
                .add(Items.NAME_TAG)
                .add(Items.SADDLE)
                .add(Items.GLOW_BERRIES)
                .add(Items.SWEET_BERRIES)
                .add(Items.CHORUS_FRUIT)
                .add(Items.BEETROOT)
                .add(Items.MELON_SLICE)
                .add(Items.PUMPKIN_SEEDS)
                .add(Items.BEETROOT_SEEDS)
                .add(Items.WHEAT_SEEDS)
                .add(Items.TORCHFLOWER_SEEDS)
                .add(Items.PITCHER_POD)
                .add(Items.BAMBOO)
                .add(Items.COCOA_BEANS)
                .add(Items.DRIED_KELP)
                .add(Items.SEAGRASS)
                .add(Items.WARPED_FUNGUS)
                .add(Items.CRIMSON_FUNGUS)
                .add(Items.NETHER_WART)
                .add(Items.GLOW_INK_SAC)
                .add(Items.INK_SAC);
    }
}
