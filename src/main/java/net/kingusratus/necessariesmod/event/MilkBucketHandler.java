package net.kingusratus.necessariesmod.event;

import net.kingusratus.necessariesmod.NecessariesMod;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;

@EventBusSubscriber(modid = NecessariesMod.MOD_ID)
public class MilkBucketHandler {

    @SubscribeEvent
    public static void onRightClickItem(PlayerInteractEvent.RightClickItem event) {
        Player player = event.getEntity();
        ItemStack stack = event.getItemStack();
        // A activer quand le fluid de lait sera implementé
        /*
        if (stack.getItem() == Items.MILK_BUCKET) {
            HitResult hit = player.pick(5.0D, 0.0F, false);
            if (hit.getType() == HitResult.Type.BLOCK) {
                if (!player.level().isClientSide) {
                    var blockHit = (BlockHitResult) hit;
                    var pos = blockHit.getBlockPos().relative(blockHit.getDirection());
                    var level = player.level();
                    if (level.getBlockState(pos).canBeReplaced()) {
                        level.setBlockAndUpdate(pos, Blocks.WATER.defaultBlockState());
                        level.playSound(null, pos, SoundEvents.BUCKET_EMPTY, SoundSource.BLOCKS, 1.0F, 1.0F);
                        if (!player.getAbilities().instabuild) {
                            stack.shrink(1);
                            player.addItem(new ItemStack(Items.BUCKET));
                        }
                    }
                }
                event.setCancellationResult(InteractionResult.SUCCESS);
                event.setCanceled(true);
            }
        }*/
    }
}
