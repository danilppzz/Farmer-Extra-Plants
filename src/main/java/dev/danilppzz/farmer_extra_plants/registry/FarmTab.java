package dev.danilppzz.farmer_extra_plants.registry;

import dev.danilppzz.farmer_extra_plants.FarmerExtraPlants;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class FarmTab {
    public static DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, FarmerExtraPlants.MODID);

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> FARMER_EXTRA_PLANTS_TAB = CREATIVE_MODE_TABS.register("farmer_extra_plants_tab", () -> {
        CreativeModeTab.Builder builder = CreativeModeTab.builder();

        builder.displayItems((itemDisplayParameters, output) -> {
            FarmBlocks.BLOCKS.getEntries()
                    .stream()
                    .map(DeferredHolder::get)
                    .forEach(output::accept);
            FarmItems.ITEMS.getEntries()
                    .stream()
                    .map(DeferredHolder::get)
                    .forEach(output::accept);
        });

        builder.icon(() -> new ItemStack(FarmBlocks.EXPERIENCE_PLANT.get()));
        builder.title(Component.translatable("itemGroup.farmer_extra_plants"));

        return builder.build();
    });
}
