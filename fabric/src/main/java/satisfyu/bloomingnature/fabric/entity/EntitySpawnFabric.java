package satisfyu.bloomingnature.fabric.entity;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.entity.ambient.AmbientCreature;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.levelgen.Heightmap;
import satisfyu.bloomingnature.registry.EntityRegistry;
import satisfyu.bloomingnature.terrablender.BloomingNatureBiomeKey;

public class EntitySpawnFabric {
    public static void addEntitySpawn() {
        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(Biomes.BEACH, BloomingNatureBiomeKey.RIVER_KEY), MobCategory.CREATURE,
                EntityRegistry.PELICAN.get(), 5, 3, 5);

        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BloomingNatureBiomeKey.SWAMP_KEY, BloomingNatureBiomeKey.MANGROVE_SWAMP_KEY), MobCategory.CREATURE,
                EntityRegistry.MUDDY_PIG.get(), 8, 4, 7);

        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BloomingNatureBiomeKey.SWAMP_KEY, BloomingNatureBiomeKey.MANGROVE_SWAMP_KEY), MobCategory.CREATURE,
                EntityRegistry.MOSSY_SHEEP.get(), 8, 3, 5);

        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BloomingNatureBiomeKey.PLAINS_KEY, BloomingNatureBiomeKey.FOREST_KEY,
                        BloomingNatureBiomeKey.BIRCH_FOREST_KEY, BloomingNatureBiomeKey.SUNFLOWER_PLAINS_KEY, BloomingNatureBiomeKey.TAIGA_KEY, BloomingNatureBiomeKey.ASPEN_FOREST_KEY, BloomingNatureBiomeKey.OLD_GROWTH_SPRUCE_TAIGA_KEY, BloomingNatureBiomeKey.LARCH_FOREST_KEY), MobCategory.CREATURE,
                EntityRegistry.RACCOON.get(), 8, 2, 4);

        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BloomingNatureBiomeKey.PLAINS_KEY, BloomingNatureBiomeKey.FOREST_KEY, BloomingNatureBiomeKey.BIRCH_FOREST_KEY, BloomingNatureBiomeKey.SUNFLOWER_PLAINS_KEY, BloomingNatureBiomeKey.TAIGA_KEY), MobCategory.CREATURE,
                EntityRegistry.SQUIRREL.get(), 8, 2, 2);

        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BloomingNatureBiomeKey.LARCH_FOREST_KEY), MobCategory.CREATURE,
                EntityRegistry.RED_WOLF.get(), 10, 3, 4);

        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BloomingNatureBiomeKey.PLAINS_KEY, BloomingNatureBiomeKey.FOREST_KEY,
                        BloomingNatureBiomeKey.BIRCH_FOREST_KEY, BloomingNatureBiomeKey.SUNFLOWER_PLAINS_KEY, BloomingNatureBiomeKey.TAIGA_KEY, BloomingNatureBiomeKey.ASPEN_FOREST_KEY, BloomingNatureBiomeKey.OLD_GROWTH_SPRUCE_TAIGA_KEY, BloomingNatureBiomeKey.LARCH_FOREST_KEY), MobCategory.CREATURE,
                EntityRegistry.DEER.get(), 8, 2, 4);



        SpawnPlacements.register(EntityRegistry.SQUIRREL.get(), SpawnPlacements.Type.ON_GROUND,
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
    }
}
