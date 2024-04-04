package dev.danilppzz.farmer_extra_plants.registry;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class FarmFood {
    public static final FoodProperties DEFAULT_FOOD = new FoodProperties.Builder()
            .nutrition(4)
            .saturationMod(0.4f)
            .alwaysEat()
            .effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 200, 1), 1.0f)
            .build();
}
