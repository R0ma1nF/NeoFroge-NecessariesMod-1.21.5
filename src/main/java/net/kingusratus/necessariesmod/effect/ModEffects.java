package net.kingusratus.necessariesmod.effect;

import net.kingusratus.necessariesmod.NecessariesMod;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModEffects {
    public static final DeferredRegister<MobEffect> MOB_EFFECTS = DeferredRegister.create(BuiltInRegistries.MOB_EFFECT, NecessariesMod.MOD_ID);

    public static final Holder<MobEffect> BURNING = MOB_EFFECTS.register("burning", () -> new BurningEffect(MobEffectCategory.HARMFUL, 0xFF4500));

    public static void register(IEventBus eventBus) {
        MOB_EFFECTS.register(eventBus);
    }
}
