package net.kingusratus.necessariesmod.utils;

import net.kingusratus.necessariesmod.NecessariesMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModTags {
    public static class Blocks {
        private static TagKey<Block> createTag(String name) {
            return BlockTags.create(ResourceLocation.fromNamespaceAndPath(NecessariesMod.MOD_ID, name));
        }
    }

    public static class Items {
        public static final TagKey<Item> MEATS = createTag("meats");
        public static final TagKey<Item> FISHES = createTag("fishes");
        public static final TagKey<Item> TRASH = createTag("trash");
        public static final TagKey<Item> REPAIRS_CACTUS_ARMOR = createTag("repairs_cactus_armor");
        public static final TagKey<Item> REPAIRS_OBSIDIAN_ARMOR = createTag("repairs_obsidian_armor");

        private static TagKey<Item> createTag(String name) {
            return ItemTags.create(ResourceLocation.fromNamespaceAndPath(NecessariesMod.MOD_ID, name));
        }
    }
}
