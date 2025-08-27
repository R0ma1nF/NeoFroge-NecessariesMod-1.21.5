package net.kingusratus.necessariesmod.block;


import net.kingusratus.necessariesmod.NecessariesMod;
import net.kingusratus.necessariesmod.block.custom.EndCakeBlock;
import net.kingusratus.necessariesmod.item.ModItems;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Function;
import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(NecessariesMod.MOD_ID);


    /***************************************************************************************
     * BLOCKS
     ***************************************************************************************/
    public static final DeferredBlock<Block> STEEL_BLOCK = registerBlock("steel_block",
            (properties) -> new Block(properties
                    .strength(5.0F, 6.0F).requiresCorrectToolForDrops().sound(SoundType.IRON)));
    public static final DeferredBlock<Block> RUBY_ORE = registerBlock("ruby_ore",
            (properties) -> new DropExperienceBlock(UniformInt.of(5, 10), properties
                    .strength(3.0F, 3.0F).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final DeferredBlock<Block> DEEPSLATE_RUBY_ORE = registerBlock("deepslate_ruby_ore",
            (properties) -> new DropExperienceBlock(UniformInt.of(5, 10), properties
                    .strength(4.5F, 3.0F).requiresCorrectToolForDrops().sound(SoundType.DEEPSLATE)));
    public static final DeferredBlock<Block> RUBY_BLOCK = registerBlock("ruby_block",
            (properties) -> new Block(properties
                    .strength(5.0F, 6.0F).instrument(NoteBlockInstrument.BIT).requiresCorrectToolForDrops().sound(SoundType.METAL)));
    public static final DeferredBlock<Block> ENDCAKE_BLOCK = registerBlock("endcake",
            (properties) -> new EndCakeBlock(Blocks.CAKE.properties()));

    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Function<BlockBehaviour.Properties, T> function) {
        DeferredBlock<T> toReturn = BLOCKS.registerBlock(name, function);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
        ModItems.ITEMS.registerItem(name, (properties) -> new BlockItem(block.get(), properties.useBlockDescriptionPrefix()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
