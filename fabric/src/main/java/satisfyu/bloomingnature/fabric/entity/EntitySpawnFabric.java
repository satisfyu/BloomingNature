package satisfyu.bloomingnature.fabric.entity;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.entity.ambient.AmbientCreature;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.levelgen.Heightmap;
import satisfyu.bloomingnature.registry.EntityRegistry;
import satisfyu.bloomingnature.terrablender.BloomingNatureBiome;

public class EntitySpawnFabric {
    public static void addEntitySpawn() {
        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(Biomes.BEACH, BloomingNatureBiome.RIVER_KEY), MobCategory.CREATURE,
                EntityRegistry.PELICAN.get(), 5, 3, 4);

        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BloomingNatureBiome.SWAMP_KEY, BloomingNatureBiome.MANGROVE_SWAMP_KEY), MobCategory.CREATURE,
                EntityRegistry.MUDDY_PIG.get(), 8, 4, 5);

        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BloomingNatureBiome.SWAMP_KEY, BloomingNatureBiome.MANGROVE_SWAMP_KEY), MobCategory.CREATURE,
                EntityRegistry.MOSSY_SHEEP.get(), 8, 3, 5);

        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BloomingNatureBiome.FOREST_KEY,
                        BloomingNatureBiome.BIRCH_FOREST_KEY, BloomingNatureBiome.SUNFLOWER_PLAINS_KEY, BloomingNatureBiome.ASPEN_FOREST_KEY, BloomingNatureBiome.OLD_GROWTH_SPRUCE_TAIGA_KEY, BloomingNatureBiome.LARCH_FOREST_KEY), MobCategory.CREATURE,
                EntityRegistry.RACCOON.get(), 8, 2, 3);

        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BloomingNatureBiome.PLAINS_KEY, BloomingNatureBiome.FOREST_KEY, BloomingNatureBiome.BIRCH_FOREST_KEY, BloomingNatureBiome.SUNFLOWER_PLAINS_KEY, BloomingNatureBiome.TAIGA_KEY), MobCategory.CREATURE,
                EntityRegistry.SQUIRREL.get(), 8, 2, 2);

        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BloomingNatureBiome.LARCH_FOREST_KEY), MobCategory.CREATURE,
                EntityRegistry.RED_WOLF.get(), 10, 3, 4);

        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BloomingNatureBiome.FOREST_KEY, BloomingNatureBiome.BIRCH_FOREST_KEY, BloomingNatureBiome.TAIGA_KEY, BloomingNatureBiome.ASPEN_FOREST_KEY, BloomingNatureBiome.OLD_GROWTH_SPRUCE_TAIGA_KEY, BloomingNatureBiome.LARCH_FOREST_KEY), MobCategory.CREATURE,
                EntityRegistry.DEER.get(), 12, 2, 4);

        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BloomingNatureBiome.FOREST_KEY,
                        BloomingNatureBiome.BIRCH_FOREST_KEY, BloomingNatureBiome.TAIGA_KEY, BloomingNatureBiome.ASPEN_FOREST_KEY, BloomingNatureBiome.OLD_GROWTH_SPRUCE_TAIGA_KEY, BloomingNatureBiome.LARCH_FOREST_KEY), MobCategory.CREATURE,
                EntityType.SHEEP, 10, 2, 5);

        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BloomingNatureBiome.FOREST_KEY,
                        BloomingNatureBiome.BIRCH_FOREST_KEY, BloomingNatureBiome.TAIGA_KEY, BloomingNatureBiome.ASPEN_FOREST_KEY, BloomingNatureBiome.OLD_GROWTH_SPRUCE_TAIGA_KEY, BloomingNatureBiome.LARCH_FOREST_KEY), MobCategory.CREATURE,
                EntityType.COW, 10, 2, 4);

        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BloomingNatureBiome.FOREST_KEY,
                        BloomingNatureBiome.BIRCH_FOREST_KEY, BloomingNatureBiome.TAIGA_KEY, BloomingNatureBiome.ASPEN_FOREST_KEY, BloomingNatureBiome.OLD_GROWTH_SPRUCE_TAIGA_KEY, BloomingNatureBiome.LARCH_FOREST_KEY, BloomingNatureBiome.PLAINS_KEY, BloomingNatureBiome.RIVER_KEY), MobCategory.CREATURE,
                EntityType.COD, 15, 4, 5);

        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BloomingNatureBiome.FOREST_KEY,
                        BloomingNatureBiome.PLAINS_KEY, BloomingNatureBiome.RIVER_KEY), MobCategory.CREATURE,
                EntityType.SALMON, 10, 4, 7);

        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BloomingNatureBiome.LARCH_FOREST_KEY, BloomingNatureBiome.OLD_GROWTH_SPRUCE_TAIGA_KEY, BloomingNatureBiome.TAIGA_KEY, BloomingNatureBiome.BIRCH_FOREST_KEY, Biomes.DARK_FOREST), MobCategory.CREATURE,
                EntityRegistry.OWL.get(), 9, 2, 2);

        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BloomingNatureBiome.LARCH_FOREST_KEY, BloomingNatureBiome.OLD_GROWTH_SPRUCE_TAIGA_KEY, BloomingNatureBiome.TAIGA_KEY, BloomingNatureBiome.BIRCH_FOREST_KEY, Biomes.DARK_FOREST, BloomingNatureBiome.ASPEN_FOREST_KEY, BloomingNatureBiome.SAVANNA_KEY, BloomingNatureBiome.SAVANNA_PLATEAU_KEY), MobCategory.CREATURE,
                EntityRegistry.BOAR.get(), 10, 3, 4);

        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BloomingNatureBiome.SAVANNA_PLATEAU_KEY, BloomingNatureBiome.SAVANNA_KEY), MobCategory.CREATURE,
                EntityRegistry.BISON.get(), 10, 3, 5);

        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BloomingNatureBiome.LARCH_FOREST_KEY, BloomingNatureBiome.OLD_GROWTH_SPRUCE_TAIGA_KEY, BloomingNatureBiome.TAIGA_KEY, BloomingNatureBiome.BIRCH_FOREST_KEY, Biomes.DARK_FOREST, BloomingNatureBiome.ASPEN_FOREST_KEY, BloomingNatureBiome.FLOWER_FOREST_KEY, BloomingNatureBiome.FOREST_KEY), MobCategory.CREATURE,
                EntityRegistry.TURKEY.get(), 12, 3, 4);

        SpawnPlacements.register(EntityRegistry.SQUIRREL.get(), SpawnPlacements.Type.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, AmbientCreature::checkMobSpawnRules);
        SpawnPlacements.register(EntityRegistry.OWL.get(), SpawnPlacements.Type.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING, AmbientCreature::checkMobSpawnRules);
        SpawnPlacements.register(EntityRegistry.TURKEY.get(), SpawnPlacements.Type.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, AmbientCreature::checkMobSpawnRules);
        SpawnPlacements.register(EntityRegistry.RACCOON.get(), SpawnPlacements.Type.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, AmbientCreature::checkMobSpawnRules);
        SpawnPlacements.register(EntityRegistry.PELICAN.get(), SpawnPlacements.Type.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, AmbientCreature::checkMobSpawnRules);
        SpawnPlacements.register(EntityRegistry.MUDDY_PIG.get(), SpawnPlacements.Type.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, AmbientCreature::checkMobSpawnRules);
        SpawnPlacements.register(EntityRegistry.DEER.get(), SpawnPlacements.Type.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, AmbientCreature::checkMobSpawnRules);
        SpawnPlacements.register(EntityRegistry.MOSSY_SHEEP.get(), SpawnPlacements.Type.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, AmbientCreature::checkMobSpawnRules);
        SpawnPlacements.register(EntityRegistry.RED_WOLF.get(), SpawnPlacements.Type.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, AmbientCreature::checkMobSpawnRules);
        SpawnPlacements.register(EntityRegistry.BOAR.get(), SpawnPlacements.Type.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, AmbientCreature::checkMobSpawnRules);
        SpawnPlacements.register(EntityRegistry.BISON.get(), SpawnPlacements.Type.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, AmbientCreature::checkMobSpawnRules);
    }
}
