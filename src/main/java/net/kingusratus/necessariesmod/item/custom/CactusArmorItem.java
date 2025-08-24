package net.kingusratus.necessariesmod.item.custom;

import com.google.common.collect.ImmutableMap;
import net.kingusratus.necessariesmod.effect.mob_effect.ModEffects;
import net.kingusratus.necessariesmod.item.ModArmorMaterials;
import net.minecraft.core.component.DataComponents;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.equipment.ArmorMaterial;
import net.minecraft.world.item.equipment.Equippable;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Map;

public class CactusArmorItem extends Item {
    private static final Map<ArmorMaterial, List<MobEffectInstance>> MATERIAL_TO_EFFECT_MAP =
            (new ImmutableMap.Builder<ArmorMaterial, List<MobEffectInstance>>())
                    .put(ModArmorMaterials.CACTUS_ARMOR_MATERIAL,
                            List.of(new MobEffectInstance(ModEffects.PRICKLY, 200, 0, false, false)))
                    .build();

    public CactusArmorItem(Properties properties) {
        super(properties);
    }

    @Override
    public void inventoryTick(ItemStack stack, ServerLevel level, Entity entity, @Nullable EquipmentSlot slot) {
        if(entity instanceof Player player) {
            evaluateArmorEffects(player);
        }
    }

    private void evaluateArmorEffects(Player player) {
        for(Map.Entry<ArmorMaterial, List<MobEffectInstance>> entry : MATERIAL_TO_EFFECT_MAP.entrySet()) {
            ArmorMaterial mapArmorMaterial = entry.getKey();
            List<MobEffectInstance> mapEffect = entry.getValue();

            if(hasPlayerCorrectArmorOn(mapArmorMaterial, player)) {
                addEffectToPlayer(player, mapEffect);
            }
        }
    }

    private void addEffectToPlayer(Player player, List<MobEffectInstance> mapEffect) {
        boolean hasPlayerEffect = mapEffect.stream().allMatch(effect -> player.hasEffect(effect.getEffect()));

        if(!hasPlayerEffect) {
            for (MobEffectInstance effect : mapEffect) {
                player.addEffect(new MobEffectInstance(effect.getEffect(),
                        effect.getDuration(), effect.getAmplifier(), effect.isAmbient(), effect.isVisible()));
            }
        }
    }

    private boolean hasPlayerCorrectArmorOn(ArmorMaterial mapArmorMaterial, Player player) {
        return hasAtLeastOneCactusArmor(mapArmorMaterial, player);
    }

    private boolean hasAtLeastOneCactusArmor(ArmorMaterial mapArmorMaterial, Player player) {
        ItemStack boots = player.getItemBySlot(EquipmentSlot.FEET);
        ItemStack leggings = player.getItemBySlot(EquipmentSlot.LEGS);
        ItemStack chestplate = player.getItemBySlot(EquipmentSlot.CHEST);
        ItemStack helmet = player.getItemBySlot(EquipmentSlot.HEAD);

        return isCactusArmor(boots, mapArmorMaterial) ||
               isCactusArmor(leggings, mapArmorMaterial) ||
               isCactusArmor(chestplate, mapArmorMaterial) ||
               isCactusArmor(helmet, mapArmorMaterial);
    }

    private boolean isCactusArmor(ItemStack stack, ArmorMaterial mapArmorMaterial) {
        if (stack.isEmpty()) return false;

        Equippable equippable = stack.getComponents().get(DataComponents.EQUIPPABLE);
        return equippable != null &&
               equippable.assetId().isPresent() &&
               equippable.assetId().get().equals(mapArmorMaterial.assetId());
    }
}
