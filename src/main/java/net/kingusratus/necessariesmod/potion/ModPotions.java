package net.kingusratus.necessariesmod.potion;

import net.kingusratus.necessariesmod.NecessariesMod;
import net.kingusratus.necessariesmod.effect.mob_effect.ModEffects;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.alchemy.Potion;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModPotions {
    public static final DeferredRegister<Potion> POTIONS =
            DeferredRegister.create(BuiltInRegistries.POTION, NecessariesMod.MOD_ID);

    public static final Holder<Potion> GLOWING;
    public static final Holder<Potion> LONG_GLOWING;
    public static final Holder<Potion> BURNING;
    public static final Holder<Potion> LONG_BURNING;
    public static final Holder<Potion> STRONG_BURNING;
    public static final Holder<Potion> LIGHTNING;

    static {
        GLOWING = registerPotion("glowing", "glowing", new MobEffectInstance[]{new MobEffectInstance(MobEffects.GLOWING, 3600)});
        LONG_GLOWING = registerPotion("long_glowing", "glowing", new MobEffectInstance[]{new MobEffectInstance(MobEffects.GLOWING, 9600)});
        BURNING = registerPotion("burning", "burning", new MobEffectInstance[]{new MobEffectInstance(ModEffects.BURNING, 900)});
        LONG_BURNING = registerPotion("long_burning","burning", new MobEffectInstance[]{new MobEffectInstance(ModEffects.BURNING, 1800)});
        STRONG_BURNING = registerPotion("strong_burning","burning", new MobEffectInstance[]{new MobEffectInstance(ModEffects.BURNING, 432, 1)});
        LIGHTNING = registerPotion("lightning", "lightning", new MobEffectInstance[]{new MobEffectInstance(ModEffects.LIGHTNING, 1)});
    }


    public static DeferredHolder<Potion, Potion> registerPotion(String name, String potion_name, MobEffectInstance effect) {
        return POTIONS.register(name, () -> new Potion(potion_name, effect));
    }
    public static DeferredHolder<Potion, Potion> registerPotion(String name, String potion_name, MobEffectInstance[] effect) {
        return POTIONS.register(name, () -> new Potion(potion_name, effect));
    }

    public static void register(IEventBus eventBus) {
        POTIONS.register(eventBus);
    }
}