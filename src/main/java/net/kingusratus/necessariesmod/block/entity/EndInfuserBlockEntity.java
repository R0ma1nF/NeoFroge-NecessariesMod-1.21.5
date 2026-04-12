package net.kingusratus.necessariesmod.block.entity;

import net.kingusratus.necessariesmod.screen.custom.EndInfuserMenu;
import net.kingusratus.necessariesmod.item.ModItems;
import net.kingusratus.necessariesmod.utils.InfusionHelper;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.item.alchemy.PotionContents;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.Containers;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.items.ItemStackHandler;
import org.jetbrains.annotations.Nullable;


public class EndInfuserBlockEntity extends BlockEntity implements MenuProvider {
    public final ItemStackHandler itemHandler = new ItemStackHandler(5) {
        @Override
        protected void onContentsChanged(int slot) {
            setChanged();
            if (!level.isClientSide()) {
                level.sendBlockUpdated(getBlockPos(), getBlockState(), getBlockState(), 3);
            }
        }
    };

    public static final int INPUT_SLOT = 0;
    public static final int INPUT_SLOT_2 = 1;
    public static final int INPUT_SLOT_3 = 2;
    public static final int OUTPUT_SLOT = 3;
    public static final int FUEL_SLOT = 4;

    protected final ContainerData data;
    private int progress = 0;
    private int maxProgress = 72;
    private int remainingFuel = 0;
    private float rotation = 0;

    public EndInfuserBlockEntity(BlockPos pos, BlockState blockState) {
        super(ModBlockEntities.END_INFUSER_BE.get(), pos, blockState);
        data = new ContainerData() {
            @Override
            public int get(int i) {
                return switch (i) {
                    case 0 -> EndInfuserBlockEntity.this.progress;
                    case 1 -> EndInfuserBlockEntity.this.maxProgress;
                    case 2 -> EndInfuserBlockEntity.this.remainingFuel;
                    default -> 0;
                };
            }

            @Override
            public void set(int i, int value) {
                switch (i) {
                    case 0 -> EndInfuserBlockEntity.this.progress = value;
                    case 1 -> EndInfuserBlockEntity.this.maxProgress = value;
                    case 2 -> EndInfuserBlockEntity.this.remainingFuel = value;
                }
            }

            @Override
            public int getCount() {
                return 3;
            }
        };
    }

    @Override
    public Component getDisplayName() {
        return Component.translatable("block.necessariesmod.end_infuser");
    }

    @Override
    public @Nullable AbstractContainerMenu createMenu(int i, Inventory inventory, Player player) {
        return new EndInfuserMenu(i, inventory, this, this.data);
    }

    public float getRenderingRotation() {
        rotation += 0.5f;
        if(rotation >= 360) {
            rotation = 0;
        }
        return rotation;
    }

    // DESTROY LOGIC

    public void drops() {
        SimpleContainer inventory = new SimpleContainer(itemHandler.getSlots());
        for (int i = 0; i < itemHandler.getSlots(); i++) {
            inventory.setItem(i, itemHandler.getStackInSlot(i));
        }

        Containers.dropContents(this.level, this.worldPosition, inventory);
    }

    @Override
    public void preRemoveSideEffects(BlockPos pos, BlockState state) {
        drops();
        super.preRemoveSideEffects(pos, state);
    }

    // SAVE & LOAD LOGIC

    @Override
    protected void saveAdditional(CompoundTag tag, HolderLookup.Provider registries) {
        tag.put("inventory", itemHandler.serializeNBT(registries));
        tag.putInt("end_infuser.progress", progress);
        tag.putInt("end_infuser.max_progress", maxProgress);
        tag.putInt("end_infuser.remaining_fuel", remainingFuel);

        super.saveAdditional(tag, registries);
    }

    @Override
    protected void loadAdditional(CompoundTag tag, HolderLookup.Provider registries) {
        super.loadAdditional(tag, registries);

        itemHandler.deserializeNBT(registries, tag.getCompound("inventory").get());
        progress = tag.getInt("end_infuser.progress").get();
        maxProgress = tag.getInt("end_infuser.max_progress").get();
        remainingFuel = tag.getInt("end_infuser.remaining_fuel").get();
    }

    // CRAFTING LOGIC

    public void tick(Level level, BlockPos blockPos, BlockState blockState) {
        boolean isActive = hasRecipe();
        if(isActive) {
            increaseCraftingProgress();
            setChanged(level, blockPos, blockState);

            if(hasCraftingFinished()) {
                craftItem();
                resetProgress();
            }
        } else {
            resetProgress();
        }

        if (canConsumeFuel()) {
            consumeFuel();
        }
    }

    private void craftItem() {
        ItemStack inputStack = itemHandler.getStackInSlot(INPUT_SLOT);
        ItemStack outputStack = itemHandler.getStackInSlot(OUTPUT_SLOT);

        if (outputStack.is(ModItems.BIG_WATER_BOTTLE)) {
            outputStack = new ItemStack(ModItems.BIG_POTION.get());
        }

        PotionContents newContents = InfusionHelper.applyRecipe(outputStack, inputStack.getItem());
        outputStack.set(DataComponents.POTION_CONTENTS, newContents);


        this.remainingFuel -= 1;
        itemHandler.extractItem(INPUT_SLOT, 1, false);
        itemHandler.setStackInSlot(OUTPUT_SLOT, outputStack);
    }

    private boolean hasRecipe() {
        shiftIngredientsLeft();

        ItemStack inputStack = itemHandler.getStackInSlot(INPUT_SLOT);
        ItemStack outputStack = itemHandler.getStackInSlot(OUTPUT_SLOT);

        if (inputStack.isEmpty() || remainingFuel <= 0) {
            return false;
        }

        if (!InfusionHelper.isInfusable(outputStack)) {
            return false;
        }

        return InfusionHelper.canApplyRecipe(outputStack, inputStack.getItem());
    }

    private boolean canConsumeFuel() {
        return itemHandler.getStackInSlot(FUEL_SLOT).is(Items.ECHO_SHARD) && remainingFuel <= 0;
    }

    private void consumeFuel() {
        itemHandler.extractItem(FUEL_SLOT, 1, false);
        remainingFuel += 20;
    }

    private void resetProgress() {
        progress = 0;
        maxProgress = 72;
    }

    private boolean hasCraftingFinished() {
        return this.progress >= this.maxProgress;
    }

    private void increaseCraftingProgress() {
        progress++;
    }

    private void shiftIngredientsLeft() {
        if (itemHandler.getStackInSlot(INPUT_SLOT).isEmpty()) {
            if (!itemHandler.getStackInSlot(INPUT_SLOT_2).isEmpty()) {
                itemHandler.setStackInSlot(INPUT_SLOT, itemHandler.getStackInSlot(INPUT_SLOT_2));
                itemHandler.setStackInSlot(INPUT_SLOT_2, ItemStack.EMPTY);
            } else if (!itemHandler.getStackInSlot(INPUT_SLOT_3).isEmpty()) {
                itemHandler.setStackInSlot(INPUT_SLOT, itemHandler.getStackInSlot(INPUT_SLOT_3));
                itemHandler.setStackInSlot(INPUT_SLOT_3, ItemStack.EMPTY);
            }
        }

        if (itemHandler.getStackInSlot(INPUT_SLOT_2).isEmpty() && !itemHandler.getStackInSlot(INPUT_SLOT_3).isEmpty()) {
            itemHandler.setStackInSlot(INPUT_SLOT_2, itemHandler.getStackInSlot(INPUT_SLOT_3));
            itemHandler.setStackInSlot(INPUT_SLOT_3, ItemStack.EMPTY);
        }
    }

    // UPDATE PACKET LOGIC

    @Override
    public CompoundTag getUpdateTag(HolderLookup.Provider pRegistries) {
        return saveWithoutMetadata(pRegistries);
    }

    @Override
    public @Nullable Packet<ClientGamePacketListener> getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }
}
