package satisfyu.bloomingnature.terrablender;

import com.mojang.datafixers.util.Pair;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.biome.Climate;
import satisfyu.bloomingnature.BloomingNature;
import satisfyu.bloomingnature.world.BloomingNatureSurfaceRules;
import terrablender.api.*;

import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;

public class BloomingNatureBiome extends Region {
    public BloomingNatureBiome(ResourceLocation name, int weight) {
        super(name, RegionType.OVERWORLD, weight);
    }

    @Override
    public void addBiomes(Registry<Biome> registry, Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> mapper) {
        this.addModifiedVanillaOverworldBiomes(mapper, modifiedVanillaOverworldBuilder -> {
            modifiedVanillaOverworldBuilder.replaceBiome(Biomes.BIRCH_FOREST, BIRCH_FOREST_KEY);
            modifiedVanillaOverworldBuilder.replaceBiome(Biomes.OLD_GROWTH_BIRCH_FOREST, ASPEN_FOREST_KEY);
            modifiedVanillaOverworldBuilder.replaceBiome(Biomes.OLD_GROWTH_SPRUCE_TAIGA, LARCH_FOREST_KEY);
            modifiedVanillaOverworldBuilder.replaceBiome(Biomes.SAVANNA, SAVANNA_KEY);
            modifiedVanillaOverworldBuilder.replaceBiome(Biomes.SAVANNA_PLATEAU, SAVANNA_PLATEAU_KEY);
            modifiedVanillaOverworldBuilder.replaceBiome(Biomes.FOREST, FOREST_KEY);
            modifiedVanillaOverworldBuilder.replaceBiome(Biomes.PLAINS, PLAINS_KEY);
            modifiedVanillaOverworldBuilder.replaceBiome(Biomes.TAIGA, TAIGA_KEY);
            modifiedVanillaOverworldBuilder.replaceBiome(Biomes.OLD_GROWTH_PINE_TAIGA, OLD_GROWTH_SPRUCE_TAIGA_KEY);
            modifiedVanillaOverworldBuilder.replaceBiome(Biomes.FLOWER_FOREST, FLOWER_FOREST_KEY);
            modifiedVanillaOverworldBuilder.replaceBiome(Biomes.RIVER, RIVER_KEY);
            modifiedVanillaOverworldBuilder.replaceBiome(Biomes.SUNFLOWER_PLAINS, SUNFLOWER_PLAINS_KEY);
            modifiedVanillaOverworldBuilder.replaceBiome(Biomes.CHERRY_GROVE, CHERRY_GROVE_KEY);
            modifiedVanillaOverworldBuilder.replaceBiome(Biomes.SNOWY_PLAINS, SNOWY_PLAINS_KEY);
            modifiedVanillaOverworldBuilder.replaceBiome(Biomes.SNOWY_TAIGA, SNOWY_TAIGA_KEY);
            modifiedVanillaOverworldBuilder.replaceBiome(Biomes.SNOWY_SLOPES, SNOWY_SLOPES_KEY);
            modifiedVanillaOverworldBuilder.replaceBiome(Biomes.GROVE, GROVE_KEY);
            modifiedVanillaOverworldBuilder.replaceBiome(Biomes.SWAMP, SWAMP_KEY);
            modifiedVanillaOverworldBuilder.replaceBiome(Biomes.MANGROVE_SWAMP, MANGROVE_SWAMP_KEY);
        });
    }

    public static final ResourceKey<Biome> BIRCH_FOREST_KEY = ResourceKey.create(Registries.BIOME,
            new ResourceLocation(BloomingNature.MOD_ID, "birch_forest"));
    public static final ResourceKey<Biome> ASPEN_FOREST_KEY = ResourceKey.create(Registries.BIOME,
            new ResourceLocation(BloomingNature.MOD_ID, "aspen_forest"));
    public static final ResourceKey<Biome> LARCH_FOREST_KEY = ResourceKey.create(Registries.BIOME,
            new ResourceLocation(BloomingNature.MOD_ID, "larch_forest"));
    public static final ResourceKey<Biome> SAVANNA_KEY = ResourceKey.create(Registries.BIOME,
            new ResourceLocation(BloomingNature.MOD_ID, "savanna"));
    public static final ResourceKey<Biome> SAVANNA_PLATEAU_KEY = ResourceKey.create(Registries.BIOME,
            new ResourceLocation(BloomingNature.MOD_ID, "savanna_plateau"));
    public static final ResourceKey<Biome> FOREST_KEY = ResourceKey.create(Registries.BIOME,
            new ResourceLocation(BloomingNature.MOD_ID, "forest"));
    public static final ResourceKey<Biome> PLAINS_KEY = ResourceKey.create(Registries.BIOME,
            new ResourceLocation(BloomingNature.MOD_ID, "plains"));
    public static final ResourceKey<Biome> TAIGA_KEY = ResourceKey.create(Registries.BIOME,
            new ResourceLocation(BloomingNature.MOD_ID, "taiga"));
    public static final ResourceKey<Biome> OLD_GROWTH_SPRUCE_TAIGA_KEY = ResourceKey.create(Registries.BIOME,
            new ResourceLocation(BloomingNature.MOD_ID, "old_growth_spruce_taiga"));
    public static final ResourceKey<Biome> FLOWER_FOREST_KEY = ResourceKey.create(Registries.BIOME,
            new ResourceLocation(BloomingNature.MOD_ID, "flower_forest"));
    public static final ResourceKey<Biome> RIVER_KEY = ResourceKey.create(Registries.BIOME,
            new ResourceLocation(BloomingNature.MOD_ID, "river"));
    public static final ResourceKey<Biome> SUNFLOWER_PLAINS_KEY = ResourceKey.create(Registries.BIOME,
            new ResourceLocation(BloomingNature.MOD_ID, "sunflower_plains"));
    public static final ResourceKey<Biome> CHERRY_GROVE_KEY = ResourceKey.create(Registries.BIOME,
            new ResourceLocation(BloomingNature.MOD_ID, "cherry_grove"));
    public static final ResourceKey<Biome> SNOWY_PLAINS_KEY = ResourceKey.create(Registries.BIOME,
            new ResourceLocation(BloomingNature.MOD_ID, "snowy_plains"));
    public static final ResourceKey<Biome> SNOWY_TAIGA_KEY = ResourceKey.create(Registries.BIOME,
            new ResourceLocation(BloomingNature.MOD_ID, "snowy_taiga"));
    public static final ResourceKey<Biome> SNOWY_SLOPES_KEY = ResourceKey.create(Registries.BIOME,
            new ResourceLocation(BloomingNature.MOD_ID, "snowy_slopes"));
    public static final ResourceKey<Biome> GROVE_KEY = ResourceKey.create(Registries.BIOME,
            new ResourceLocation(BloomingNature.MOD_ID, "grove"));
    public static final ResourceKey<Biome> SWAMP_KEY = ResourceKey.create(Registries.BIOME,
            new ResourceLocation(BloomingNature.MOD_ID, "swamp"));
    public static final ResourceKey<Biome> MANGROVE_SWAMP_KEY = ResourceKey.create(Registries.BIOME,
            new ResourceLocation(BloomingNature.MOD_ID, "mangrove_swamp"));

    
    public static void loadTerrablender() {
        Regions.register(new BloomingNatureBiome(new ResourceLocation(BloomingNature.MOD_ID, "overworld"), 1000));
        SurfaceRuleManager.addSurfaceRules(SurfaceRuleManager.RuleCategory.OVERWORLD, BloomingNature.MOD_ID, BloomingNatureSurfaceRules.makeRules());
    }
}