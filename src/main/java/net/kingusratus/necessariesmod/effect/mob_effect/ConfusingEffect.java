package net.kingusratus.necessariesmod.effect.mob_effect;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.InstantenousMobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.network.chat.Component;

public class ConfusingEffect extends InstantenousMobEffect  {

    public ConfusingEffect(MobEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public boolean applyEffectTick(ServerLevel level, LivingEntity entity, int amplifier) {
        if (entity instanceof ServerPlayer player) {
            player.sendSystemMessage(Component.translatable("effect.necessariesmod.confusing.message"));
        }
        return true;
    }
}
