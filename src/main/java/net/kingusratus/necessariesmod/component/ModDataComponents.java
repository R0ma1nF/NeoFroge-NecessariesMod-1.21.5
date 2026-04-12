package net.kingusratus.necessariesmod.component;

import com.mojang.serialization.Codec;
import net.kingusratus.necessariesmod.NecessariesMod;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.effect.MobEffectInstance;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.List;
import java.util.function.UnaryOperator;

public class ModDataComponents {
    public static final DeferredRegister<DataComponentType<?>> DATA_COMPONENT_TYPES =
            DeferredRegister.createDataComponents(Registries.DATA_COMPONENT_TYPE, NecessariesMod.MOD_ID);

    public static final DeferredHolder<DataComponentType<?>, DataComponentType<Integer>> REMAINING_USES = register("remaining_uses",
            builder -> builder.persistent(Codec.INT));

    public static final DeferredHolder<DataComponentType<?>, DataComponentType<List<MobEffectInstance>>> POTION_EFFECTS = register("potion_effects",
            builder -> builder.persistent(Codec.list(MobEffectInstance.CODEC)));


    private static <T> DeferredHolder<DataComponentType<?>, DataComponentType<T>> register(String name,
                                                                                           UnaryOperator<DataComponentType.Builder<T>> builderOperator) {
        return DATA_COMPONENT_TYPES.register(name, () -> builderOperator.apply(DataComponentType.builder()).build());
    }

    public static void register(IEventBus eventBus) {
        DATA_COMPONENT_TYPES.register(eventBus);
    }
}