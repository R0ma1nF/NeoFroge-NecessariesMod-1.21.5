package net.kingusratus.necessariesmod.effect;

import net.minecraft.advancements.critereon.LightningStrikeTrigger;
import net.minecraft.core.Holder;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.SimpleMenuProvider;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.inventory.ChestMenu;
import net.minecraft.world.inventory.PlayerEnderChestContainer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.consume_effects.ConsumeEffect;
import net.minecraft.world.level.Level;

import java.util.List;
import java.util.Random;

public class RandomEffectConsumeEffect implements ConsumeEffect {

    @Override
    public Type<? extends ConsumeEffect> getType() {
        return null;
    }

    @Override
    public boolean apply(Level level, ItemStack itemStack, LivingEntity livingEntity) {

        if (!level.isClientSide && livingEntity instanceof ServerPlayer player) {
            List<Holder<MobEffect>> effects = List.of(
                // Effets bénéfiques
                MobEffects.REGENERATION,
                MobEffects.SPEED,
                MobEffects.FIRE_RESISTANCE,
                MobEffects.JUMP_BOOST,
                MobEffects.STRENGTH,
                MobEffects.HEALTH_BOOST,
                MobEffects.ABSORPTION,
                MobEffects.LUCK,
                MobEffects.NIGHT_VISION,
                MobEffects.INVISIBILITY,
                MobEffects.WATER_BREATHING,
                MobEffects.RESISTANCE,
                MobEffects.HERO_OF_THE_VILLAGE,
                MobEffects.CONDUIT_POWER,
                MobEffects.INSTANT_HEALTH,
                MobEffects.DOLPHINS_GRACE,
                MobEffects.GLOWING,
                MobEffects.ABSORPTION,

                MobEffects.POISON,
                MobEffects.POISON,
                MobEffects.WEAKNESS,
                MobEffects.BLINDNESS,
                MobEffects.HUNGER,
                MobEffects.UNLUCK,
                MobEffects.BAD_OMEN,
                MobEffects.WITHER,
                MobEffects.WITHER,
                MobEffects.SLOWNESS,
                MobEffects.MINING_FATIGUE,
                MobEffects.LEVITATION,
                MobEffects.DARKNESS,
                MobEffects.SLOW_FALLING,
                MobEffects.NAUSEA,
                MobEffects.INSTANT_DAMAGE,
                MobEffects.INSTANT_DAMAGE,
                MobEffects.INSTANT_DAMAGE,
                ModEffects.BURNING
            );
            Random random = new Random();

            int totalOptions = effects.size() + 1; // +1 pour la foudre
            int choice = random.nextInt(totalOptions);

            if (choice == effects.size()) {
                LightningBolt l = EntityType.LIGHTNING_BOLT.create(level, EntitySpawnReason.TRIGGERED);
                if (l != null) {
                    l.setPos(player.getX(), player.getY(), player.getZ());
                    level.addFreshEntity(l);
                }
            } else {
                Holder<MobEffect> randomEffect = effects.get(choice);
                int duration = 20 * (10 + random.nextInt(11)); // 10 à 20 secondes
                int amplifier = random.nextInt(2); // niveau 0 ou 1
                player.addEffect(new MobEffectInstance(randomEffect, duration, amplifier));
            }
            level.playSound(null, player.blockPosition(), SoundEvents.EXPERIENCE_ORB_PICKUP, SoundSource.PLAYERS, 1.0F, 1.0F);
            return true;
        }

        return false;
    }
}
