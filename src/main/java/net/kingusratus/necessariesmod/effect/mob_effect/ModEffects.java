package net.kingusratus.necessariesmod.effect.mob_effect;

import net.kingusratus.necessariesmod.NecessariesMod;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModEffects {
    public static final DeferredRegister<MobEffect> MOB_EFFECTS = DeferredRegister.create(BuiltInRegistries.MOB_EFFECT, NecessariesMod.MOD_ID);

    public static final Holder<MobEffect> BURNING = MOB_EFFECTS.register("burning", () -> new BurningEffect(MobEffectCategory.HARMFUL, 0xF56C27));
    public static final Holder<MobEffect> LIGHTNING = MOB_EFFECTS.register("lightning", () -> new LightningEffect(MobEffectCategory.HARMFUL, 0xF5C827));
    public static final Holder<MobEffect> CONFUSING = MOB_EFFECTS.register("confusing", () -> new ConfusingEffect(MobEffectCategory.BENEFICIAL, 0xA0A0A0));
    public static final Holder<MobEffect> PRICKLY = MOB_EFFECTS.register("prickly", () -> new PricklyEffect(MobEffectCategory.HARMFUL, 0x4E944F));


    public static void register(IEventBus eventBus) {
        MOB_EFFECTS.register(eventBus);
    }
}
