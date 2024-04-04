package dev.danilppzz.farmer_extra_plants.registry;

import dev.danilppzz.farmer_extra_plants.Configuration;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

import java.util.Random;

public class FarmExperienceFood extends Item {
    public FarmExperienceFood(Properties properties) {
        super(properties.food(EXPERIENCE_FOOD).stacksTo(16).rarity(Rarity.UNCOMMON));
    }

    public static final FoodProperties EXPERIENCE_FOOD = new FoodProperties.Builder()
            .nutrition(0)
            .saturationMod(0.0f)
            .alwaysEat()
            .build();

    @Override
    public @NotNull ItemStack finishUsingItem(ItemStack itemStack, Level level, LivingEntity livingEntity) {
        Random random = new Random();
        int toGive = random.nextInt(Configuration.maxExperience);
        Player player = (Player) livingEntity;
        player.giveExperiencePoints(toGive);
        return super.finishUsingItem(itemStack, level, livingEntity);
    }
}
