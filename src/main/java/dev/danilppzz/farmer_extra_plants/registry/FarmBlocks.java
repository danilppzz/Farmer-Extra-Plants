package dev.danilppzz.farmer_extra_plants.registry;

import dev.danilppzz.farmer_extra_plants.FarmerExtraPlants;
import dev.danilppzz.farmer_extra_plants.blocks.ExperiencePlantBlock;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class FarmBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(FarmerExtraPlants.MODID);

    public static final DeferredBlock<Block> EXPERIENCE_PLANT = registerBlock("experience_plant",
            () -> new ExperiencePlantBlock(Block.Properties.ofFullCopy(Blocks.AZALEA_LEAVES).noOcclusion()));

    public static DeferredBlock<Block> registerBlock(
            String name, Supplier<Block> block) {
        DeferredBlock<Block> blockReg = BLOCKS.register(name, block);
        FarmItems.ITEMS.register(name, () -> new BlockItem(blockReg.get(), new Item.Properties()));
        return blockReg;
    }
}
