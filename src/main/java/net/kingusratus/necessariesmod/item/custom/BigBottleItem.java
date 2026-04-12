package net.kingusratus.necessariesmod.item.custom;

import net.kingusratus.necessariesmod.item.ModItems;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;

public class BigBottleItem extends Item {
    public BigBottleItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult use(Level level, Player player, InteractionHand hand) {
        ItemStack itemStack = player.getItemInHand(hand);
        BlockHitResult hitResult = getPlayerPOVHitResult(level, player, ClipContext.Fluid.WATER);

        if (hitResult.getType() == HitResult.Type.BLOCK) {
            if (level.getBlockState(hitResult.getBlockPos()).is(Blocks.WATER) ||
                    level.getBlockState(hitResult.getBlockPos()).is(Blocks.CAULDRON)) {

                if (!level.isClientSide && player.containerMenu.stillValid(player)) {
                    ItemStack waterBottle = new ItemStack(ModItems.BIG_WATER_BOTTLE.get());
                    //play fill sound here
                    level.playSound(null, player.getX(), player.getY(), player.getZ(), SoundEvents.BOTTLE_FILL, SoundSource.PLAYERS, 1.0F, 1.0F);

                    itemStack.shrink(1);
                    if (!player.getInventory().add(waterBottle)) {
                        player.drop(waterBottle, false);
                    }
                    return InteractionResult.SUCCESS;
                }
            }
        }
        return InteractionResult.PASS;
    }
}