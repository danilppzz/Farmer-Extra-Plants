package dev.danilppzz.farmer_extra_plants;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.config.ModConfigEvent;
import net.neoforged.neoforge.common.ModConfigSpec;

@Mod.EventBusSubscriber(modid = FarmerExtraPlants.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class Configuration
{
    private static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();


    private static final ModConfigSpec.IntValue GROWING_SPEED = BUILDER
            .comment("The growing speed in ticks")
            .defineInRange("growingSpeed", 100, 0, Integer.MAX_VALUE);

    private static final ModConfigSpec.IntValue MAX_EXPERIENCE = BUILDER
            .comment("The max experience points a player can get from fruits.")
            .comment("The min value is 1 that is equals to 0")
            .defineInRange("maxExperience", 40, 1, Integer.MAX_VALUE);



    static final ModConfigSpec SPEC = BUILDER.build();

    public static int growingSpeed;
    public static int maxExperience;

    @SubscribeEvent
    static void onLoad(final ModConfigEvent event)
    {
        growingSpeed = GROWING_SPEED.get();
        maxExperience = MAX_EXPERIENCE.get();
    }
}
