package net.kingusratus.necessariesmod.datagen;


import net.kingusratus.necessariesmod.NecessariesMod;
import net.kingusratus.necessariesmod.block.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.common.data.BlockTagsProvider;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends BlockTagsProvider {
    public ModBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, lookupProvider, NecessariesMod.MOD_ID);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(BlockTags.BEACON_BASE_BLOCKS)
                .add(Blocks.BIRCH_PLANKS)
                .add(ModBlocks.RUBY_BLOCK.get());
    }
}