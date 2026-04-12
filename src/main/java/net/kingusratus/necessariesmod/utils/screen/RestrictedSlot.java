package net.kingusratus.necessariesmod.utils.screen;

import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.items.IItemHandler;
import net.neoforged.neoforge.items.SlotItemHandler;
import java.util.function.Predicate;

/*
 A custom slot that only accepts items that pass the given validator test.

 // example to only allow sticks :
 this.addSlot(new RestrictedSlot(blockEntity.itemHandler, 0, 54, 34, stack -> stack.is(Items.STICK)));

 // example to only allow items tagged as planks :
 this.addSlot(new RestrictedSlot(blockEntity.itemHandler, 0, 54, 34, stack -> stack.is(ItemTags.PLANKS)));

 // example to only allow items that are either sticks or planks :
 this.addSlot(new RestrictedSlot(blockEntity.itemHandler, 0, 54, 34, stack -> stack.is(Items.STICK) || stack.is(ItemTags.PLANKS)));

 // example to allow nothing :
 this.addSlot(new RestrictedSlot(blockEntity.itemHandler, 0, 54, 34, stack -> false));
 */

public class RestrictedSlot extends SlotItemHandler {

    private final Predicate<ItemStack> validator;

    public RestrictedSlot(IItemHandler itemHandler, int index, int x, int y, Predicate<ItemStack> validator) {
        super(itemHandler, index, x, y);
        this.validator = validator;
    }

    @Override
    public boolean mayPlace(ItemStack stack) {
        return validator.test(stack);
    }
}
