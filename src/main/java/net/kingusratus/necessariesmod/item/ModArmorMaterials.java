package net.kingusratus.necessariesmod.item;

import com.google.common.collect.Maps;
import net.kingusratus.necessariesmod.NecessariesMod;
import net.kingusratus.necessariesmod.utils.ModTags;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.equipment.ArmorMaterial;
import net.minecraft.world.item.equipment.ArmorType;
import net.minecraft.world.item.equipment.EquipmentAsset;
import net.minecraft.world.item.equipment.EquipmentAssets;

import java.util.Map;

public class ModArmorMaterials {

    /***************************************************************************************
     * RESSOURCE KEYS
     ***************************************************************************************/

    public static ResourceKey<EquipmentAsset> CACTUS;
    public static ResourceKey<EquipmentAsset> OBSIDIAN;

    static {
        CACTUS = ResourceKey.create(EquipmentAssets.ROOT_ID, ResourceLocation.fromNamespaceAndPath(NecessariesMod.MOD_ID, "cactus"));
        OBSIDIAN = ResourceKey.create(EquipmentAssets.ROOT_ID, ResourceLocation.fromNamespaceAndPath(NecessariesMod.MOD_ID, "obsidian"));
    }

    /***************************************************************************************
     * ARMOR MATERIALS
     ***************************************************************************************/
    public static final ArmorMaterial CACTUS_ARMOR_MATERIAL;
    public static final ArmorMaterial OBSIDIAN_ARMOR_MATERIAL;

    static {
        CACTUS_ARMOR_MATERIAL = new ArmorMaterial(5, makeDefense(1, 2, 3, 1, 3), 15, SoundEvents.ARMOR_EQUIP_LEATHER, 0.0F, 0.0F, ModTags.Items.REPAIRS_CACTUS_ARMOR, CACTUS);
        OBSIDIAN_ARMOR_MATERIAL = new ArmorMaterial(37, makeDefense(3, 6, 8, 3, 11), 10, SoundEvents.ARMOR_EQUIP_NETHERITE, 2.0F, 0.0F, ModTags.Items.REPAIRS_OBSIDIAN_ARMOR, OBSIDIAN);
    }

    /***************************************************************************************
     * HELPER METHODS
     ***************************************************************************************/
    private static Map<ArmorType, Integer> makeDefense(int boots, int leggings, int chestplate, int helmet, int body) {
        return Maps.newEnumMap(Map.of(ArmorType.BOOTS, boots, ArmorType.LEGGINGS, leggings, ArmorType.CHESTPLATE, chestplate, ArmorType.HELMET, helmet, ArmorType.BODY, body));
    }
}