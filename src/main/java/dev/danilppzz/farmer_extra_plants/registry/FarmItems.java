package dev.danilppzz.farmer_extra_plants.registry;


import dev.danilppzz.farmer_extra_plants.FarmerExtraPlants;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class FarmItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(FarmerExtraPlants.MODID);

    public static final DeferredItem<Item> EXPERIENCE_SEED = ITEMS.register("experience_seed",
            () -> new ItemNameBlockItem(FarmBlocks.EXPERIENCE_PLANT.get(), new Item.Properties()));

    public static final DeferredItem<Item> EXPERIENCE_NUGGET = ITEMS.register("experience_nugget",
            () -> new FarmExperienceFood(new Item.Properties()));
}
