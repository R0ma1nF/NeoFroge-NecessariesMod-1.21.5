package net.kingusratus.necessariesmod.food;

import net.kingusratus.necessariesmod.effect.EnderChestConsumeEffect;
import net.kingusratus.necessariesmod.effect.ModEffects;
import net.kingusratus.necessariesmod.effect.RandomEffectConsumeEffect;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.ItemUseAnimation;
import net.minecraft.world.item.component.Consumable;
import net.minecraft.world.item.consume_effects.ApplyStatusEffectsConsumeEffect;
import net.minecraft.world.item.consume_effects.TeleportRandomlyConsumeEffect;

import java.util.List;

public class ModConsumables {
    public static final Consumable DEFAULT_CONSUMABLE = defaultFood().build();
    public static final Consumable DEFAULT_DRINK = defaultDrink().build();
    public static final Consumable HOT_CHOCOLATE;
    public static final Consumable DUBIOUS_FOOD;
    public static final Consumable CACTUS_SKEWER; // ModEffect.PRICKLY
    public static final Consumable DIRT_SOUP; // slowness and instant damage for 2 hearts
    public static final Consumable GRAVEL_SOUP; // slowness and instant damage for 2 hearts
    public static final Consumable LAVA_SOUP; // ModEffect.Burning and fire resistance for 4 min
    public static final Consumable ENDER_SOUP; // teleport to random location in 300 blocks radius
    public static final Consumable STONE_BREAD; // resistance for 2 min and 4 hearts of instant damage
    public static final Consumable ENDER_COOKIE; // onConsume new EnderChestConsumeEffect
    public static final Consumable RANDOM_COOKIE; // onConsume new RandomEffectConsumeEffect
    public static final Consumable VOID_COOKIE; // onConsume new EnderChestConsumeEffect and dont delete the item
    public static final Consumable NETHERITE_STEAK; // like an enchanted golden apple
    public static final Consumable THE_THING; // best food

    public static Consumable.Builder defaultFood() {
        return Consumable.builder().consumeSeconds(1.6F).animation(ItemUseAnimation.EAT).sound(SoundEvents.GENERIC_EAT).hasConsumeParticles(true);
    }

    public static Consumable.Builder defaultDrink() {
        return Consumable.builder().consumeSeconds(1.6F).animation(ItemUseAnimation.DRINK).sound(SoundEvents.GENERIC_DRINK).hasConsumeParticles(false);
    }

    static {
        HOT_CHOCOLATE = defaultDrink().onConsume(new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.REGENERATION, 600, 0))).build();

        DUBIOUS_FOOD = defaultFood().onConsume(new ApplyStatusEffectsConsumeEffect(List.of(
                new MobEffectInstance(MobEffects.HUNGER, 600, 0),
                new MobEffectInstance(MobEffects.POISON, 600, 0),
                new MobEffectInstance(MobEffects.NAUSEA, 600, 0)
        ))).build();

        CACTUS_SKEWER = defaultFood()
                .onConsume(new ApplyStatusEffectsConsumeEffect(
                        new MobEffectInstance(MobEffects.INSTANT_DAMAGE, 1, 0)
                ))
                .build();

        DIRT_SOUP = defaultDrink()
                .onConsume(new ApplyStatusEffectsConsumeEffect(List.of(
                        new MobEffectInstance(MobEffects.SLOWNESS, 600, 0),
                        new MobEffectInstance(MobEffects.INSTANT_DAMAGE, 1, 0)
                )))
                .build();

        GRAVEL_SOUP = defaultDrink()
                .onConsume(new ApplyStatusEffectsConsumeEffect(List.of(
                        new MobEffectInstance(MobEffects.SLOWNESS, 600, 0),
                        new MobEffectInstance(MobEffects.INSTANT_DAMAGE, 1, 0)
                )))
                .build();

        LAVA_SOUP = defaultDrink()
                .onConsume(new ApplyStatusEffectsConsumeEffect(List.of(
                        new MobEffectInstance(ModEffects.BURNING, 100, 0),
                        new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 4800, 0) // 4 min
                )))
                .build();

        ENDER_SOUP = defaultDrink()
                .onConsume(new TeleportRandomlyConsumeEffect(1000))
                .build();

        STONE_BREAD = defaultFood()
                .onConsume(new ApplyStatusEffectsConsumeEffect(List.of(
                        new MobEffectInstance(MobEffects.RESISTANCE, 2400, 0), // 2 min
                        new MobEffectInstance(MobEffects.INSTANT_DAMAGE, 1, 1)
                )))
                .build();

        ENDER_COOKIE = defaultFood()
                .onConsume(new EnderChestConsumeEffect())
                .build();

        VOID_COOKIE = defaultFood()
                .onConsume(new EnderChestConsumeEffect())
                .build();

        RANDOM_COOKIE = defaultFood()
                .onConsume(new RandomEffectConsumeEffect())
                .build();

        NETHERITE_STEAK = defaultFood()
                .onConsume(new ApplyStatusEffectsConsumeEffect(List.of(
                        new MobEffectInstance(MobEffects.REGENERATION, 400, 1),
                        new MobEffectInstance(MobEffects.ABSORPTION, 2400, 3),
                        new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 4800, 0),
                        new MobEffectInstance(MobEffects.RESISTANCE, 4800, 0)
                )))
                .build();

        // GIVE THE GOOD ITEMS
        THE_THING = defaultDrink()
                .onConsume(new ApplyStatusEffectsConsumeEffect(List.of(
                        new MobEffectInstance(MobEffects.REGENERATION, 2400, 1),
                        new MobEffectInstance(MobEffects.ABSORPTION, 4800, 3),
                        new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 9600, 0),
                        new MobEffectInstance(MobEffects.RESISTANCE, 9600, 0),
                        new MobEffectInstance(MobEffects.SATURATION, 1, 0),
                        new MobEffectInstance(MobEffects.HASTE, 9600, 1),
                        new MobEffectInstance(MobEffects.SPEED, 9600, 1),
                        new MobEffectInstance(MobEffects.NIGHT_VISION, 9600, 0),
                        new MobEffectInstance(MobEffects.LUCK, 9600, 0),
                        new MobEffectInstance(MobEffects.STRENGTH, 9600, 1)
                )))
                .build();

    }
}