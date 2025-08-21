package net.kingusratus.necessariesmod.effect.mob_effect;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.InstantenousMobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.LivingEntity;

public class LightningEffect extends InstantenousMobEffect {
    public LightningEffect(MobEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public boolean applyEffectTick(ServerLevel level, LivingEntity entity, int amplifier) {
        if (!level.isClientSide) {
            for (int i = 0; i < amplifier+1; i++) {
                spawnLightning(level, entity);
            }
        }
        return true;
    }

    private void spawnLightning(ServerLevel level, LivingEntity entity) {
        LightningBolt l = EntityType.LIGHTNING_BOLT.create(level, EntitySpawnReason.TRIGGERED);
        if (l != null) {
            l.setPos(entity.getX(), entity.getY(), entity.getZ());
            level.addFreshEntity(l);
        }
    }
}
