package net.kingusratus.necessariesmod.event;

import net.kingusratus.necessariesmod.NecessariesMod;
import net.kingusratus.necessariesmod.potion.ModPotions;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionBrewing;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.phys.HitResult;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.brewing.RegisterBrewingRecipesEvent;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;


@EventBusSubscriber(modid = NecessariesMod.MOD_ID)
public class ModEvents {

    @SubscribeEvent
    public static void onBrewingRecipeRegister(RegisterBrewingRecipesEvent event) {
        PotionBrewing.Builder builder = event.getBuilder();

        // GLOWING POTION
        builder.addMix(Potions.AWKWARD, Items.GLOW_INK_SAC, ModPotions.GLOWING);
        builder.addMix(Potions.AWKWARD, Items.GLOW_BERRIES, ModPotions.GLOWING);
        builder.addMix(Potions.AWKWARD, Items.GLOW_LICHEN, ModPotions.GLOWING);
        builder.addMix(ModPotions.GLOWING, Items.REDSTONE, ModPotions.LONG_GLOWING);

        // BURNING POTION
        builder.addMix(Potions.AWKWARD, Items.MAGMA_BLOCK, ModPotions.BURNING);
        builder.addMix(ModPotions.BURNING, Items.REDSTONE, ModPotions.LONG_BURNING);
        builder.addMix(ModPotions.BURNING, Items.GLOWSTONE_DUST, ModPotions.STRONG_BURNING);

        // LIGHTNING POTION
        builder.addMix(Potions.AWKWARD, Items.LIGHTNING_ROD, ModPotions.LIGHTNING);

    }
}
