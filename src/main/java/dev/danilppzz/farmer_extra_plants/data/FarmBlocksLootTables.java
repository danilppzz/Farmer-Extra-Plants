package dev.danilppzz.farmer_extra_plants.data;

import dev.danilppzz.farmer_extra_plants.FarmerExtraPlants;
import dev.danilppzz.farmer_extra_plants.blocks.ExperiencePlantBlock;
import dev.danilppzz.farmer_extra_plants.registry.FarmBlocks;
import dev.danilppzz.farmer_extra_plants.registry.FarmItems;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import org.jetbrains.annotations.NotNull;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class FarmBlocksLootTables extends BlockLootSubProvider {
    public FarmBlocksLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        LootItemCondition.Builder lootitemcondition$builder = LootItemBlockStatePropertyCondition
                .hasBlockStateProperties(FarmBlocks.EXPERIENCE_PLANT.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(ExperiencePlantBlock.AGE, ExperiencePlantBlock.MAX_AGE));

        this.add(FarmBlocks.EXPERIENCE_PLANT.get(), createCropDrops(FarmBlocks.EXPERIENCE_PLANT.get(), FarmItems.EXPERIENCE_NUGGET.get(),
                FarmItems.EXPERIENCE_SEED.get(), lootitemcondition$builder));
    }



    @Override
    public @NotNull Iterable<Block> getKnownBlocks() {
        return BuiltInRegistries.BLOCK.stream()
                .filter(block -> Optional.of(BuiltInRegistries.BLOCK.getKey(block))
                        .filter(key -> key.getNamespace().equals(FarmerExtraPlants.MODID))
                        .isPresent())
                .collect(Collectors.toSet());
    }
}
