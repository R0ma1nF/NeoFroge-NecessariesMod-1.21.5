package net.kingusratus.necessariesmod.datagen;

import net.kingusratus.necessariesmod.NecessariesMod;
import net.minecraft.client.resources.model.EquipmentClientInfo;
import net.minecraft.data.CachedOutput;
import net.minecraft.data.DataProvider;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.function.BiConsumer;

public class ModEquipmentInfoProvider implements DataProvider {

    public final PackOutput.PathProvider path;

    public ModEquipmentInfoProvider(PackOutput output) {
        this.path = output.createPathProvider(PackOutput.Target.RESOURCE_PACK, "equipment");
    }

    private void add(BiConsumer<ResourceLocation, EquipmentClientInfo> registrar) {
        registrar.accept(
                ResourceLocation.fromNamespaceAndPath(NecessariesMod.MOD_ID, "cactus"),
                EquipmentClientInfo.builder()
                        .addLayers(
                                EquipmentClientInfo.LayerType.HUMANOID,
                                new EquipmentClientInfo.Layer(
                                        ResourceLocation.fromNamespaceAndPath(NecessariesMod.MOD_ID, "cactus/outer"),
                                        Optional.empty(),
                                        false
                                )
                        )
                        .addLayers(
                                EquipmentClientInfo.LayerType.HUMANOID_LEGGINGS,
                                new EquipmentClientInfo.Layer(
                                        ResourceLocation.fromNamespaceAndPath(NecessariesMod.MOD_ID, "cactus/inner"),
                                        Optional.empty(),
                                        false
                                )
                        )
                        .build()
        );

        registrar.accept(
                ResourceLocation.fromNamespaceAndPath(NecessariesMod.MOD_ID, "obsidian"),
                EquipmentClientInfo.builder()
                        .addLayers(
                                EquipmentClientInfo.LayerType.HUMANOID,
                                new EquipmentClientInfo.Layer(
                                        ResourceLocation.fromNamespaceAndPath(NecessariesMod.MOD_ID, "obsidian/outer"),
                                        Optional.empty(),
                                        false
                                )
                        )
                        .addLayers(
                                EquipmentClientInfo.LayerType.HUMANOID_LEGGINGS,
                                new EquipmentClientInfo.Layer(
                                        ResourceLocation.fromNamespaceAndPath(NecessariesMod.MOD_ID, "obsidian/inner"),
                                        Optional.empty(),
                                        false
                                )
                        )
                        .build()
        );
    }

    @Override
    public CompletableFuture<?> run(CachedOutput cache) {
        Map<ResourceLocation, EquipmentClientInfo> map = new HashMap<>();
        this.add((name, info) -> {
            if (map.putIfAbsent(name, info) != null) {
                throw new IllegalStateException("Tried to register equipment client info twice for id: " + name);
            }
        });
        return DataProvider.saveAll(cache, EquipmentClientInfo.CODEC, this.path, map);
    }

    @Override
    public String getName() {
        return "Equipment Client Infos: " + NecessariesMod.MOD_ID;
    }
}
