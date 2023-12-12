package satisfyu.bloomingnature.fabric.entity;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.entity.ambient.AmbientCreature;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.levelgen.Heightmap;
import satisfyu.bloomingnature.registry.EntityRegistry;
import satisfyu.bloomingnature.terrablender.BloomingNatureBiomes;

public class EntitySpawnFabric {
    public static void addEntitySpawn() {
        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(Biomes.BEACH, BloomingNatureBiomes.RIVER_KEY), MobCategory.CREATURE,
                EntityRegistry.PELICAN.get(), 6, 3, 5);

        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BloomingNatureBiomes.SWAMP_KEY, BloomingNatureBiomes.MANGROVE_SWAMP_KEY), MobCategory.CREATURE,
                EntityRegistry.MUDDY_PIG.get(), 8, 4, 7);

        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BloomingNatureBiomes.PLAINS_KEY, BloomingNatureBiomes.FOREST_KEY,
                        BloomingNatureBiomes.BIRCH_FOREST_KEY, BloomingNatureBiomes.SUNFLOWER_PLAINS_KEY, BloomingNatureBiomes.TAIGA_KEY, BloomingNatureBiomes.ASPEN_FOREST_KEY, BloomingNatureBiomes.OLD_GROWTH_PINE_TAIGA_KEY, BloomingNatureBiomes.LARCH_FOREST_KEY), MobCategory.CREATURE,
                EntityRegistry.RACCOON.get(), 8, 2, 4);

        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BloomingNatureBiomes.PLAINS_KEY, BloomingNatureBiomes.FOREST_KEY, BloomingNatureBiomes.BIRCH_FOREST_KEY, BloomingNatureBiomes.SUNFLOWER_PLAINS_KEY, BloomingNatureBiomes.TAIGA_KEY), MobCategory.CREATURE,
                EntityRegistry.SQUIRREL.get(), 8, 2, 4);

        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BloomingNatureBiomes.LARCH_FOREST_KEY), MobCategory.CREATURE,
                EntityRegistry.RED_WOLF.get(), 12, 3, 5);




        SpawnPlacements.register(EntityRegistry.SQUIRREL.get(), SpawnPlacements.Type.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, AmbientCreature::checkMobSpawnRules);
        SpawnPlacements.register(EntityRegistry.RACCOON.get(), SpawnPlacements.Type.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, AmbientCreature::checkMobSpawnRules);
        SpawnPlacements.register(EntityRegistry.PELICAN.get(), SpawnPlacements.Type.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, AmbientCreature::checkMobSpawnRules);
        SpawnPlacements.register(EntityRegistry.MUDDY_PIG.get(), SpawnPlacements.Type.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, AmbientCreature::checkMobSpawnRules);
    }
}
