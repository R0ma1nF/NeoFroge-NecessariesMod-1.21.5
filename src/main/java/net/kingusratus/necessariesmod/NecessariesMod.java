package net.kingusratus.necessariesmod;

import net.kingusratus.necessariesmod.screen.ModMenuTypes;
import net.kingusratus.necessariesmod.screen.custom.EndInfuserScreen;
import net.kingusratus.necessariesmod.block.ModBlocks;
import net.kingusratus.necessariesmod.block.entity.ModBlockEntities;
import net.kingusratus.necessariesmod.block.entity.renderer.EndInfuserBlockEntityRenderer;
import net.kingusratus.necessariesmod.component.ModDataComponents;
import net.kingusratus.necessariesmod.effect.mob_effect.ModEffects;
import net.kingusratus.necessariesmod.item.ModItems;
import net.kingusratus.necessariesmod.loot.ModLootModifiers;
import net.kingusratus.necessariesmod.potion.ModPotions;
import net.kingusratus.necessariesmod.sound.ModSounds;
import net.kingusratus.necessariesmod.utils.ModCreativeModeTabs;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;
import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;

// The value here should match an entry in the META-INF/neoforge.mods.toml file
@Mod(NecessariesMod.MOD_ID)
public class NecessariesMod {
    public static final String MOD_ID = "necessariesmod";
    public static final Logger LOGGER = LogUtils.getLogger();

    // The constructor for the mod class is the first code that is run when your mod is loaded.
    // FML will recognize some parameter types like IEventBus or ModContainer and pass them in automatically.
    public NecessariesMod(IEventBus modEventBus, ModContainer modContainer) {
        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);

        // Register ourselves for server and other game events we are interested in.
        // Note that this is necessary if and only if we want *this* class (ExampleMod) to respond directly to events.
        // Do not add this line if there are no @SubscribeEvent-annotated functions in this class, like onServerStarting() below.
        NeoForge.EVENT_BUS.register(this);

        /*********************************************
         * REGISTER MOD THINGS
         *********************************************/
        ModCreativeModeTabs.register(modEventBus);

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);

        ModSounds.register(modEventBus);

        ModDataComponents.register(modEventBus);
        ModBlockEntities.register(modEventBus);

        ModEffects.register(modEventBus);
        ModPotions.register(modEventBus);

        ModLootModifiers.register(modEventBus);
        ModMenuTypes.register(modEventBus);

        // Register the item to a creative tab
        modEventBus.addListener(this::addCreative);
        // Register our mod's ModConfigSpec so that FML can create and load the config file for us
        modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(FMLCommonSetupEvent event) {

    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {

    }

    @EventBusSubscriber(modid = MOD_ID, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {

        }

        @SubscribeEvent
        public static void registerBER(EntityRenderersEvent.RegisterRenderers event) {
            event.registerBlockEntityRenderer(ModBlockEntities.END_INFUSER_BE.get(), EndInfuserBlockEntityRenderer::new);
        }


        @SubscribeEvent
        public static void registerScreens(RegisterMenuScreensEvent event) {
            event.register(ModMenuTypes.END_INFUSER_MENU.get(), EndInfuserScreen::new);
        }
    }
}
