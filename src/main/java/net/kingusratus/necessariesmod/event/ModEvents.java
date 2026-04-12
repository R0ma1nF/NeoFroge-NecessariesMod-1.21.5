package net.kingusratus.necessariesmod.event;

import net.kingusratus.necessariesmod.NecessariesMod;
import net.kingusratus.necessariesmod.component.ModDataComponents;
import net.kingusratus.necessariesmod.item.ModItems;
import net.kingusratus.necessariesmod.item.custom.DrillItem;
import net.kingusratus.necessariesmod.potion.ModPotions;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionBrewing;
import net.minecraft.world.item.alchemy.Potions;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.brewing.RegisterBrewingRecipesEvent;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;
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

    @SubscribeEvent
    public static void registerCustomPotionsRecipes(RegisterBrewingRecipesEvent event) {
        PotionBrewing.Builder builder = event.getBuilder();

        builder.addMix(Potions.AWKWARD, Items.GLOW_INK_SAC, ModPotions.GLOWING);
        builder.addMix(Potions.AWKWARD, Items.GLOW_BERRIES, ModPotions.GLOWING);
        builder.addMix(Potions.AWKWARD, Items.GLOW_LICHEN, ModPotions.GLOWING);
        builder.addMix(ModPotions.GLOWING, Items.REDSTONE, ModPotions.LONG_GLOWING);

        builder.addMix(Potions.AWKWARD, Items.MAGMA_BLOCK, ModPotions.BURNING);
        builder.addMix(ModPotions.BURNING, Items.REDSTONE, ModPotions.LONG_BURNING);
        builder.addMix(ModPotions.BURNING, Items.GLOWSTONE_DUST, ModPotions.STRONG_BURNING);

        builder.addMix(Potions.AWKWARD, Items.IRON_PICKAXE, ModPotions.HASTE);
        builder.addMix(ModPotions.HASTE, Items.REDSTONE, ModPotions.LONG_HASTE);
        builder.addMix(ModPotions.HASTE, Items.GLOWSTONE_DUST, ModPotions.STRONG_HASTE);
        builder.addMix(ModPotions.LONG_HASTE, Items.GLOWSTONE_DUST, ModPotions.LONG_STRONG_HASTE);
        builder.addMix(ModPotions.STRONG_HASTE, Items.REDSTONE, ModPotions.LONG_STRONG_HASTE);

        builder.addMix(Potions.AWKWARD, Items.LIGHTNING_ROD, ModPotions.LIGHTNING);
    }
}
