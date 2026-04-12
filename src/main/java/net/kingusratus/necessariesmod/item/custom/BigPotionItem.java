package net.kingusratus.necessariesmod.item.custom;

import net.kingusratus.necessariesmod.component.ModDataComponents;
import net.kingusratus.necessariesmod.food.ModConsumables;
import net.kingusratus.necessariesmod.item.ModItems;
import net.kingusratus.necessariesmod.utils.InfusionHelper;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.component.TooltipDisplay;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

import java.util.*;
import java.util.function.Consumer;

public class BigPotionItem extends Item {

    private static final int numberOfUses = 5;


    public BigPotionItem(Properties properties, MobEffectInstance[] effects) {
        super(properties
                .stacksTo(1)
                .component(DataComponents.CONSUMABLE, ModConsumables.DEFAULT_DRINK)
                .component(DataComponents.POTION_CONTENTS, InfusionHelper.getPotionContents(List.of(effects)))
                .component(ModDataComponents.REMAINING_USES, numberOfUses)
        );
    }

    @Override
    public @NotNull ItemStack finishUsingItem(@NotNull ItemStack stack, @NotNull Level level, @NotNull LivingEntity entity) {
        MobEffectInstance[] effects = Objects.requireNonNull(stack.get(DataComponents.POTION_CONTENTS)).customEffects().toArray(new MobEffectInstance[0]);
        if (!level.isClientSide) {
            for (MobEffectInstance effect : effects) {
                entity.addEffect(new MobEffectInstance(effect));
            }
        }

        if (entity instanceof Player player && !player.getAbilities().instabuild) {
            Integer usesLeftObj = stack.get(ModDataComponents.REMAINING_USES);
            int usesLeft;

            if (usesLeftObj != null) {
                usesLeft = usesLeftObj - 1;
            } else {
                return new ItemStack(ModItems.BIG_BOTTLE.get());
            }

            if (usesLeft > 0) {
                stack.set(ModDataComponents.REMAINING_USES, usesLeft);
                return stack;
            } else {
                return new ItemStack(ModItems.BIG_BOTTLE.get());
            }
        }

        return super.finishUsingItem(stack, level, entity);
    }

    @Override
    public void appendHoverText(@NotNull ItemStack stack, @NotNull TooltipContext context, @NotNull TooltipDisplay tooltipDisplay, @NotNull Consumer<Component> components, @NotNull TooltipFlag tooltipFlag) {
        Integer remainingUses = stack.get(ModDataComponents.REMAINING_USES);

        if(remainingUses != null) {
            components.accept(Component.literal(remainingUses + " / " + numberOfUses ));
        }

        super.appendHoverText(stack, context, tooltipDisplay, components, tooltipFlag);
    }


}