package dev.danilppzz.farmer_extra_plants.util;

import dev.danilppzz.farmer_extra_plants.FarmerExtraPlants;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class NameUtility {

    public static String getItemName(Item item) {
        return BuiltInRegistries.ITEM.getKey(item).toString().replace(FarmerExtraPlants.MODID + ":", "");
    }

    public static String getBlockName(Block block) {
        return BuiltInRegistries.BLOCK.getKey(block).toString().replace(FarmerExtraPlants.MODID + ":", "");
    }
}
