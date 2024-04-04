package dev.danilppzz.farmer_extra_plants;

import com.mojang.logging.LogUtils;
import dev.danilppzz.farmer_extra_plants.registry.FarmBlocks;
import dev.danilppzz.farmer_extra_plants.registry.FarmItems;
import dev.danilppzz.farmer_extra_plants.registry.FarmTab;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModLoadingContext;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import org.slf4j.Logger;

@Mod(FarmerExtraPlants.MODID)
public class FarmerExtraPlants
{
    public static final String MODID = "farmer_extra_plants";
    private static final Logger LOGGER = LogUtils.getLogger();

    public FarmerExtraPlants(IEventBus modEventBus)
    {
        FarmItems.ITEMS.register(modEventBus);
        FarmBlocks.BLOCKS.register(modEventBus);
        FarmTab.CREATIVE_MODE_TABS.register(modEventBus);

        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Configuration.SPEC);
    }

    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
            ItemBlockRenderTypes.setRenderLayer(FarmBlocks.EXPERIENCE_PLANT.get(), RenderType.translucent());

        }
    }
}
