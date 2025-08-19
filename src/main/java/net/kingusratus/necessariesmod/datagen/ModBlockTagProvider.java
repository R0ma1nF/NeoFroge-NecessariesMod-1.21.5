package net.kingusratus.necessariesmod.datagen;


import net.kingusratus.necessariesmod.NecessariesMod;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.BlockTagsProvider;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends BlockTagsProvider {
    public ModBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, lookupProvider, NecessariesMod.MOD_ID);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {

    }
}