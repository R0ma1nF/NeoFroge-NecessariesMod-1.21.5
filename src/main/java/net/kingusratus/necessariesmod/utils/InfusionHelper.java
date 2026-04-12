package net.kingusratus.necessariesmod.utils;

import net.kingusratus.necessariesmod.potion.ModPotions;
import net.minecraft.core.Holder;
import net.minecraft.core.component.DataComponents;
import net.minecraft.util.ARGB;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.item.alchemy.PotionContents;
import net.minecraft.world.item.alchemy.Potions;

import java.util.*;

public class InfusionHelper {
    private static final int MAX_EFFECTS = 3;
    private static final List<Mix<Potion>> potionMixes = new ArrayList<>();

    static {
        registerMix(Potions.WATER, Items.BREEZE_ROD, Potions.WIND_CHARGED);
        registerMix(Potions.WATER, Items.SLIME_BLOCK, Potions.OOZING);
        registerMix(Potions.WATER, Items.STONE, Potions.INFESTED);
        registerMix(Potions.WATER, Items.COBWEB, Potions.WEAVING);
        registerMix(Potions.WATER, Items.GOLDEN_CARROT, Potions.NIGHT_VISION);
        registerMix(Potions.NIGHT_VISION, Items.REDSTONE, Potions.LONG_NIGHT_VISION);
        registerMix(Potions.NIGHT_VISION, Items.FERMENTED_SPIDER_EYE, Potions.INVISIBILITY);
        registerMix(Potions.LONG_NIGHT_VISION, Items.FERMENTED_SPIDER_EYE, Potions.LONG_INVISIBILITY);
        registerMix(Potions.INVISIBILITY, Items.REDSTONE, Potions.LONG_INVISIBILITY);
        registerMix(Potions.WATER, Items.MAGMA_CREAM, Potions.FIRE_RESISTANCE);
        registerMix(Potions.FIRE_RESISTANCE, Items.REDSTONE, Potions.LONG_FIRE_RESISTANCE);
        registerMix(Potions.WATER, Items.RABBIT_FOOT, Potions.LEAPING);
        registerMix(Potions.LEAPING, Items.REDSTONE, Potions.LONG_LEAPING);
        registerMix(Potions.LEAPING, Items.GLOWSTONE_DUST, Potions.STRONG_LEAPING);
        registerMix(Potions.LEAPING, Items.FERMENTED_SPIDER_EYE, Potions.SLOWNESS);
        registerMix(Potions.LONG_LEAPING, Items.FERMENTED_SPIDER_EYE, Potions.LONG_SLOWNESS);
        registerMix(Potions.SLOWNESS, Items.REDSTONE, Potions.LONG_SLOWNESS);
        registerMix(Potions.SLOWNESS, Items.GLOWSTONE_DUST, Potions.STRONG_SLOWNESS);
        registerMix(Potions.WATER, Items.TURTLE_HELMET, Potions.TURTLE_MASTER);
        registerMix(Potions.TURTLE_MASTER, Items.REDSTONE, Potions.LONG_TURTLE_MASTER);
        registerMix(Potions.TURTLE_MASTER, Items.GLOWSTONE_DUST, Potions.STRONG_TURTLE_MASTER);
        registerMix(Potions.SWIFTNESS, Items.FERMENTED_SPIDER_EYE, Potions.SLOWNESS);
        registerMix(Potions.LONG_SWIFTNESS, Items.FERMENTED_SPIDER_EYE, Potions.LONG_SLOWNESS);
        registerMix(Potions.WATER, Items.SUGAR, Potions.SWIFTNESS);
        registerMix(Potions.SWIFTNESS, Items.REDSTONE, Potions.LONG_SWIFTNESS);
        registerMix(Potions.SWIFTNESS, Items.GLOWSTONE_DUST, Potions.STRONG_SWIFTNESS);
        registerMix(Potions.WATER, Items.PUFFERFISH, Potions.WATER_BREATHING);
        registerMix(Potions.WATER_BREATHING, Items.REDSTONE, Potions.LONG_WATER_BREATHING);
        registerMix(Potions.WATER, Items.GLISTERING_MELON_SLICE, Potions.HEALING);
        registerMix(Potions.HEALING, Items.GLOWSTONE_DUST, Potions.STRONG_HEALING);
        registerMix(Potions.HEALING, Items.FERMENTED_SPIDER_EYE, Potions.HARMING);
        registerMix(Potions.STRONG_HEALING, Items.FERMENTED_SPIDER_EYE, Potions.STRONG_HARMING);
        registerMix(Potions.HARMING, Items.GLOWSTONE_DUST, Potions.STRONG_HARMING);
        registerMix(Potions.POISON, Items.FERMENTED_SPIDER_EYE, Potions.HARMING);
        registerMix(Potions.LONG_POISON, Items.FERMENTED_SPIDER_EYE, Potions.HARMING);
        registerMix(Potions.STRONG_POISON, Items.FERMENTED_SPIDER_EYE, Potions.STRONG_HARMING);
        registerMix(Potions.WATER, Items.SPIDER_EYE, Potions.POISON);
        registerMix(Potions.POISON, Items.REDSTONE, Potions.LONG_POISON);
        registerMix(Potions.POISON, Items.GLOWSTONE_DUST, Potions.STRONG_POISON);
        registerMix(Potions.WATER, Items.GHAST_TEAR, Potions.REGENERATION);
        registerMix(Potions.REGENERATION, Items.REDSTONE, Potions.LONG_REGENERATION);
        registerMix(Potions.REGENERATION, Items.GLOWSTONE_DUST, Potions.STRONG_REGENERATION);
        registerMix(Potions.WATER, Items.BLAZE_POWDER, Potions.STRENGTH);
        registerMix(Potions.STRENGTH, Items.REDSTONE, Potions.LONG_STRENGTH);
        registerMix(Potions.STRENGTH, Items.GLOWSTONE_DUST, Potions.STRONG_STRENGTH);
        registerMix(Potions.WATER, Items.FERMENTED_SPIDER_EYE, Potions.WEAKNESS);
        registerMix(Potions.WEAKNESS, Items.REDSTONE, Potions.LONG_WEAKNESS);
        registerMix(Potions.WATER, Items.PHANTOM_MEMBRANE, Potions.SLOW_FALLING);
        registerMix(Potions.SLOW_FALLING, Items.REDSTONE, Potions.LONG_SLOW_FALLING);
        registerMix(Potions.WATER, Items.GLOW_INK_SAC, ModPotions.GLOWING);
        registerMix(Potions.WATER, Items.GLOW_BERRIES, ModPotions.GLOWING);
        registerMix(Potions.WATER, Items.GLOW_LICHEN, ModPotions.GLOWING);
        registerMix(ModPotions.GLOWING, Items.REDSTONE, ModPotions.LONG_GLOWING);
        registerMix(Potions.WATER, Items.MAGMA_BLOCK, ModPotions.BURNING);
        registerMix(ModPotions.BURNING, Items.REDSTONE, ModPotions.LONG_BURNING);
        registerMix(ModPotions.BURNING, Items.GLOWSTONE_DUST, ModPotions.STRONG_BURNING);
        registerMix(Potions.WATER, Items.LIGHTNING_ROD, ModPotions.LIGHTNING);
        registerMix(Potions.WATER, Items.IRON_PICKAXE, ModPotions.HASTE);
        registerMix(ModPotions.HASTE, Items.REDSTONE, ModPotions.LONG_HASTE);
        registerMix(ModPotions.HASTE, Items.GLOWSTONE_DUST, ModPotions.STRONG_HASTE);
        registerMix(ModPotions.LONG_HASTE, Items.GLOWSTONE_DUST, ModPotions.LONG_STRONG_HASTE);
        registerMix(ModPotions.STRONG_HASTE, Items.REDSTONE, ModPotions.LONG_STRONG_HASTE);

    }

    private static void registerMix(Holder<Potion> previous, Item ingredient, Holder<Potion> next) {
        potionMixes.add(new Mix<>(previous, ingredient, next));
    }

    public static boolean isInfusable(ItemStack stack) {
        return stack.is(ModTags.Items.INFUSABLE);
    }

    public static boolean canApplyRecipe(ItemStack potion, Item ingredient) {
        PotionContents contents = potion.getOrDefault(DataComponents.POTION_CONTENTS, PotionContents.EMPTY);
        List<MobEffectInstance> effects = new ArrayList<>(contents.customEffects());


        if (!effects.isEmpty()) {
            MobEffectInstance lastEffect = effects.getLast();
            Holder<Potion> lastPotion = getLastPotionFromEffect(lastEffect);

            if (findMix(lastPotion, ingredient) != null) {
                return true;
            }
        }

        if (effects.size() < MAX_EFFECTS) {
            return findMix(Potions.WATER, ingredient) != null;
        }

        return false;
    }

    public static PotionContents applyRecipe(ItemStack potion, Item ingredient) {
        PotionContents contents = potion.getOrDefault(DataComponents.POTION_CONTENTS, PotionContents.EMPTY);
        List<MobEffectInstance> effects = new ArrayList<>(contents.customEffects());

        if (!effects.isEmpty()) {
            MobEffectInstance lastEffect = effects.getLast();
            Holder<Potion> lastPotion = getLastPotionFromEffect(lastEffect);
            Mix<Potion> mix = findMix(lastPotion, ingredient);

            if (mix != null) {
                return getPotionFromMix(mix, effects, true);
            }
        }

        Mix<Potion> mix = findMix(Potions.WATER, ingredient);
        if (mix != null) {
            return getPotionFromMix(mix, effects, false);
        }

        return contents;
    }

    private static Mix<Potion> findMix(Holder<Potion> potion, Item ingredient) {
        return potionMixes.stream()
                .filter(m -> m.from().equals(potion) && m.ingredient() == ingredient)
                .findFirst()
                .orElse(null);
    }

    private static Holder<Potion> getLastPotionFromEffect(MobEffectInstance effect) {
        return potionMixes.stream()
                .filter(m -> isPotionContainsEffect(m.to(), effect.getEffect(), effect.getAmplifier(), effect.getDuration()))
                .map(Mix::to)
                .findFirst()
                .orElse(Potions.WATER);
    }

    private static PotionContents getPotionFromMix(Mix<Potion> mix, List<MobEffectInstance> effects, boolean replaceLast) {
        Potion resultPotion = mix.to().value();
        List<MobEffectInstance> newEffects = new ArrayList<>(effects);

        if (replaceLast && !newEffects.isEmpty()) {
            newEffects.removeLast();
        }

        newEffects.addAll(resultPotion.getEffects());

        if (newEffects.size() > MAX_EFFECTS) {
            newEffects = newEffects.subList(0, MAX_EFFECTS);
        }

        return getPotionContents(newEffects);
    }

    private static boolean isPotionContainsEffect(Holder<Potion> potion, Holder<MobEffect> effect, int amplifier, int duration) {
        return potion.value().getEffects().stream()
                .anyMatch(e -> e.getEffect().equals(effect)
                        && e.getAmplifier() == amplifier
                        && e.getDuration() == duration);
    }

    public static PotionContents getPotionContents(List<MobEffectInstance> effects) {
        PotionContents potionContents = PotionContents.EMPTY;
        if (effects != null && !effects.isEmpty()) {
            String name = effects.stream()
                    .map(e -> ((MobEffect)e.getEffect().value()).getDescriptionId())
                    .reduce((a, b) -> a + "_" + b)
                    .orElse("custom_potion");

            potionContents = new PotionContents(
                    Optional.empty(),
                    getPotionColor(effects),
                    effects,
                    Optional.of(name)
            );
        }
        return potionContents;
    }

    private static Optional<Integer> getPotionColor(List<MobEffectInstance> effects) {
        if (effects == null || effects.isEmpty()) {
            return Optional.empty();
        }
        int i = 0;
        int j = 0;
        int k = 0;
        int l = 0;

        for(MobEffectInstance mobeffectinstance : effects) {
            if (mobeffectinstance.isVisible()) {
                int i1 = ((MobEffect)mobeffectinstance.getEffect().value()).getColor();
                int j1 = mobeffectinstance.getAmplifier() + 1;
                i += j1 * ARGB.red(i1);
                j += j1 * ARGB.green(i1);
                k += j1 * ARGB.blue(i1);
                l += j1;
            }
        }

        return l == 0 ? Optional.empty() : Optional.of(ARGB.color(i / l, j / l, k / l));
    }

    static record Mix<T>(Holder<T> from, Item ingredient, Holder<T> to) {}
}