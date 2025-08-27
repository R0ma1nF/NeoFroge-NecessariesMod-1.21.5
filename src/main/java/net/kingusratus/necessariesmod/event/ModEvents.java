package net.kingusratus.necessariesmod.event;

import net.kingusratus.necessariesmod.NecessariesMod;
import net.kingusratus.necessariesmod.item.custom.DrillItem;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.level.BlockEvent;
import java.util.HashSet;
import java.util.Set;

@EventBusSubscriber(modid = NecessariesMod.MOD_ID)
public class ModEvents {
    private static final Set<BlockPos> HARVESTED_BLOCKS = new HashSet<>();

    @SubscribeEvent
    public static void onDrillUsage(BlockEvent.BreakEvent event) {
        Player player = event.getPlayer();
        ItemStack mainHandItem = player.getMainHandItem();

        if (mainHandItem.getItem() instanceof DrillItem drill && player instanceof ServerPlayer serverPlayer) {
            if (!DrillItem.tryConsumeCoal(player)) {
                // NOT ENOUGH COAL STRANGER ! More seriously, if you don't have coal, you can't use the drill.
                event.setCanceled(true);
                if (player.level().isClientSide) {
                    player.displayClientMessage(Component.literal("Not enough coal!"), true);
                }
                return;
            }

            BlockPos initialBlockPos = event.getPos();
            if (HARVESTED_BLOCKS.contains(initialBlockPos)) {
                return;
            }

            for (BlockPos pos : DrillItem.getBlocksToBeDestroyed(1, initialBlockPos, serverPlayer)) {
                if( pos.equals(initialBlockPos)) continue;
                HARVESTED_BLOCKS.add(pos);
                serverPlayer.gameMode.destroyBlock(pos);
                HARVESTED_BLOCKS.remove(pos);
            }
        }
    }
}
