package net.kingusratus.necessariesmod.item.custom;

import net.kingusratus.necessariesmod.sound.ModSounds;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipDisplay;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

import java.util.function.Consumer;

public class SuspiciousKeyItem extends Item {

    public SuspiciousKeyItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult use(Level level, Player player, InteractionHand hand) {

        if (!level.isClientSide) {
            level.playSound(null, player.getX(), player.getY(), player.getZ(), ModSounds.SUSPICIOUS_KEY_USE.get(), SoundSource.PLAYERS, 1.0F, 1.0F);
        }

        return InteractionResult.PASS;
    }

    @Override
    public void appendHoverText(@NotNull ItemStack stack, @NotNull TooltipContext context, @NotNull TooltipDisplay tooltipDisplay, @NotNull Consumer<Component> components, @NotNull TooltipFlag tooltipFlag) {

        Component hoverText = Component.translatable("item.necessariesmod.suspicious_key.desc")
                .withStyle(ChatFormatting.DARK_GRAY)
                .withStyle(ChatFormatting.ITALIC);

        components.accept(hoverText);

        super.appendHoverText(stack, context, tooltipDisplay, components, tooltipFlag);
    }

}
