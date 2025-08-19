package net.kingusratus.necessariesmod.item.custom;

import net.kingusratus.necessariesmod.food.ModConsumables;
import net.kingusratus.necessariesmod.food.ModFoodProperties;
import net.kingusratus.necessariesmod.item.ModItems;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public class VoidCookieItem extends Item {
    public VoidCookieItem(Properties properties) {
        super(properties.rarity(Rarity.RARE).stacksTo(1).food(ModFoodProperties.VOID_COOKIE).component(DataComponents.CONSUMABLE, ModConsumables.VOID_COOKIE));
    }

    public @NotNull ItemStack finishUsingItem(ItemStack itemstack, Level world, LivingEntity entity) {
        ItemStack retval = new ItemStack((ItemLike) ModItems.VOID_COOKIE.get());
        super.finishUsingItem(itemstack, world, entity);
        if (itemstack.isEmpty()) {
            return retval;
        } else {
            if (entity instanceof Player) {
                Player player = (Player)entity;
                if (!player.getAbilities().instabuild && !player.getInventory().add(retval)) {
                    player.drop(retval, false);
                }
            }

            return itemstack;
        }
    }
}