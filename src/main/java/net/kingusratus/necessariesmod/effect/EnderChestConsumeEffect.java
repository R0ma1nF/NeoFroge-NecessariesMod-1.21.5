package net.kingusratus.necessariesmod.effect;

import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.SimpleMenuProvider;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.inventory.ChestMenu;
import net.minecraft.world.inventory.PlayerEnderChestContainer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.consume_effects.ConsumeEffect;
import net.minecraft.world.level.Level;

public class EnderChestConsumeEffect implements ConsumeEffect {

    @Override
    public Type<? extends ConsumeEffect> getType() {
        return null;
    }

    @Override
    public boolean apply(Level level, ItemStack itemStack, LivingEntity livingEntity) {

        if (!level.isClientSide && livingEntity instanceof ServerPlayer player) {
            PlayerEnderChestContainer enderChest = player.getEnderChestInventory();
            enderChest.startOpen(player);
            player.openMenu(new SimpleMenuProvider(
                    (id, inventory, playerEntity) -> ChestMenu.threeRows(id, inventory, enderChest),
                    Component.translatable("container.enderchest")
            ));

            level.playSound(null, player.getX(), player.getY(), player.getZ(), SoundEvents.ENDER_CHEST_OPEN, SoundSource.BLOCKS, 1.0F, 1.0F);
            return true;
        }

        return false;
    }
}
