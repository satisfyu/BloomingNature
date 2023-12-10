package satisfyu.bloomingnature.terrablender;

import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BiomeDefaultFeatures;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.*;
import satisfyu.bloomingnature.BloomingNature;

public class BloomingNatureBiomes {
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
    public static final ResourceKey<Biome> OLD_GROWTH_PINE_TAIGA_KEY = ResourceKey.create(Registries.BIOME,
            new ResourceLocation(BloomingNature.MOD_ID, "old_growth_pine_taiga"));
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

    public static void bootstap(BootstapContext<Biome> context) {
        context.register(BIRCH_FOREST_KEY, birchforestBiome(context));
        context.register(ASPEN_FOREST_KEY, aspenforestBiome(context));
        context.register(LARCH_FOREST_KEY, larchforestBiome(context));
        context.register(SAVANNA_KEY, savannaBiome(context));
        context.register(SAVANNA_PLATEAU_KEY, savannaPlateauBiome(context));
        context.register(FOREST_KEY, forestBiome(context));
        context.register(PLAINS_KEY, plainsBiome(context));
        context.register(TAIGA_KEY, taigaBiome(context));
        context.register(OLD_GROWTH_PINE_TAIGA_KEY, oldgrowthpinetaigaBiome(context));
        context.register(FLOWER_FOREST_KEY, flowerForest(context));
        context.register(RIVER_KEY, riverBiomes(context));
        context.register(SUNFLOWER_PLAINS_KEY, sunflowerplainsBiomes(context));
        context.register(CHERRY_GROVE_KEY, cherrygroveBiome(context));
        context.register(SNOWY_PLAINS_KEY, snowyplainsBiome(context));
        context.register(SNOWY_TAIGA_KEY, snowytaigaBiome(context));
        context.register(SNOWY_SLOPES_KEY, snowyslopesBiome(context));
        context.register(GROVE_KEY, groveBiome(context));
        context.register(SWAMP_KEY, swampBiome(context));
        context.register(MANGROVE_SWAMP_KEY, mangroveswampBiome(context));


    }

    public static void globalOverworldGeneration(BiomeGenerationSettings.Builder builder) {
        BiomeDefaultFeatures.addDefaultCarversAndLakes(builder);
        BiomeDefaultFeatures.addDefaultCrystalFormations(builder);
        BiomeDefaultFeatures.addDefaultMonsterRoom(builder);
        BiomeDefaultFeatures.addDefaultUndergroundVariety(builder);
        BiomeDefaultFeatures.addDefaultSprings(builder);
        BiomeDefaultFeatures.addSurfaceFreezing(builder);
    }

    public static Biome birchforestBiome(BootstapContext<Biome> context) {
        BiomeGenerationSettings.Builder biomeBuilder =
                new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER));
        globalOverworldGeneration(biomeBuilder);
        return new Biome.BiomeBuilder()
                .generationSettings(biomeBuilder.build())
                .specialEffects((new BiomeSpecialEffects.Builder())
                        .build())
                .build();
    }

    public static Biome aspenforestBiome(BootstapContext<Biome> context) {
        BiomeGenerationSettings.Builder biomeBuilder =
                new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER));
        globalOverworldGeneration(biomeBuilder);
        return new Biome.BiomeBuilder()
                .generationSettings(biomeBuilder.build())
                .specialEffects((new BiomeSpecialEffects.Builder())
                        .build())
                .build();
    }

    public static Biome larchforestBiome(BootstapContext<Biome> context) {
        BiomeGenerationSettings.Builder biomeBuilder =
                new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER));
        globalOverworldGeneration(biomeBuilder);
        return new Biome.BiomeBuilder()
                .generationSettings(biomeBuilder.build())
                .specialEffects((new BiomeSpecialEffects.Builder())
                        .build())
                .build();
    }

    public static Biome savannaBiome(BootstapContext<Biome> context) {
        BiomeGenerationSettings.Builder biomeBuilder =
                new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER));
        globalOverworldGeneration(biomeBuilder);
        return new Biome.BiomeBuilder()
                .generationSettings(biomeBuilder.build())
                .specialEffects((new BiomeSpecialEffects.Builder())
                        .build())
                .build();
    }

    public static Biome savannaPlateauBiome(BootstapContext<Biome> context) {
        BiomeGenerationSettings.Builder biomeBuilder =
                new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER));
        globalOverworldGeneration(biomeBuilder);
        return new Biome.BiomeBuilder()
                .generationSettings(biomeBuilder.build())
                .specialEffects((new BiomeSpecialEffects.Builder())
                        .build())
                .build();
    }

    public static Biome forestBiome(BootstapContext<Biome> context) {
        BiomeGenerationSettings.Builder biomeBuilder =
                new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER));
        globalOverworldGeneration(biomeBuilder);
        return new Biome.BiomeBuilder()
                .generationSettings(biomeBuilder.build())
                .specialEffects((new BiomeSpecialEffects.Builder())
                        .build())
                .build();
    }

    public static Biome plainsBiome(BootstapContext<Biome> context) {
        BiomeGenerationSettings.Builder biomeBuilder =
                new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER));
        globalOverworldGeneration(biomeBuilder);
        return new Biome.BiomeBuilder()
                .generationSettings(biomeBuilder.build())
                .specialEffects((new BiomeSpecialEffects.Builder())
                        .build())
                .build();
    }

    public static Biome taigaBiome(BootstapContext<Biome> context) {
        BiomeGenerationSettings.Builder biomeBuilder =
                new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER));
        globalOverworldGeneration(biomeBuilder);
        return new Biome.BiomeBuilder()
                .generationSettings(biomeBuilder.build())
                .specialEffects((new BiomeSpecialEffects.Builder())
                        .build())
                .build();
    }

    public static Biome oldgrowthpinetaigaBiome(BootstapContext<Biome> context) {
        BiomeGenerationSettings.Builder biomeBuilder =
                new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER));
        globalOverworldGeneration(biomeBuilder);
        return new Biome.BiomeBuilder()
                .generationSettings(biomeBuilder.build())
                .specialEffects((new BiomeSpecialEffects.Builder())
                        .build())
                .build();
    }

    public static Biome flowerForest(BootstapContext<Biome> context) {
        BiomeGenerationSettings.Builder biomeBuilder =
                new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER));
        globalOverworldGeneration(biomeBuilder);
        return new Biome.BiomeBuilder()
                .generationSettings(biomeBuilder.build())
                .specialEffects((new BiomeSpecialEffects.Builder())
                        .build())
                .build();
    }

    public static Biome riverBiomes(BootstapContext<Biome> context) {
        BiomeGenerationSettings.Builder biomeBuilder =
                new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER));
        globalOverworldGeneration(biomeBuilder);
        return new Biome.BiomeBuilder()
                .generationSettings(biomeBuilder.build())
                .specialEffects((new BiomeSpecialEffects.Builder())
                        .build())
                .build();
    }

    public static Biome sunflowerplainsBiomes(BootstapContext<Biome> context) {
        BiomeGenerationSettings.Builder biomeBuilder =
                new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER));
        globalOverworldGeneration(biomeBuilder);
        return new Biome.BiomeBuilder()
                .generationSettings(biomeBuilder.build())
                .specialEffects((new BiomeSpecialEffects.Builder())
                        .build())
                .build();
    }

    public static Biome cherrygroveBiome(BootstapContext<Biome> context) {
        BiomeGenerationSettings.Builder biomeBuilder =
                new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER));
        globalOverworldGeneration(biomeBuilder);
        return new Biome.BiomeBuilder()
                .generationSettings(biomeBuilder.build())
                .specialEffects((new BiomeSpecialEffects.Builder())
                        .build())
                .build();
    }

    public static Biome snowyplainsBiome(BootstapContext<Biome> context) {
        BiomeGenerationSettings.Builder biomeBuilder =
                new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER));
        globalOverworldGeneration(biomeBuilder);
        return new Biome.BiomeBuilder()
                .generationSettings(biomeBuilder.build())
                .specialEffects((new BiomeSpecialEffects.Builder())
                        .build())
                .build();
    }

    public static Biome snowytaigaBiome(BootstapContext<Biome> context) {
        BiomeGenerationSettings.Builder biomeBuilder =
                new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER));
        globalOverworldGeneration(biomeBuilder);
        return new Biome.BiomeBuilder()
                .generationSettings(biomeBuilder.build())
                .specialEffects((new BiomeSpecialEffects.Builder())
                        .build())
                .build();
    }

    public static Biome snowyslopesBiome(BootstapContext<Biome> context) {
        BiomeGenerationSettings.Builder biomeBuilder =
                new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER));
        globalOverworldGeneration(biomeBuilder);
        return new Biome.BiomeBuilder()
                .generationSettings(biomeBuilder.build())
                .specialEffects((new BiomeSpecialEffects.Builder())
                        .build())
                .build();
    }

    public static Biome groveBiome(BootstapContext<Biome> context) {
        BiomeGenerationSettings.Builder biomeBuilder =
                new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER));
        globalOverworldGeneration(biomeBuilder);
        return new Biome.BiomeBuilder()
                .generationSettings(biomeBuilder.build())
                .specialEffects((new BiomeSpecialEffects.Builder())
                        .build())
                .build();
    }

    public static Biome swampBiome(BootstapContext<Biome> context) {
        BiomeGenerationSettings.Builder biomeBuilder =
                new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER));
        globalOverworldGeneration(biomeBuilder);
        return new Biome.BiomeBuilder()
                .generationSettings(biomeBuilder.build())
                .specialEffects((new BiomeSpecialEffects.Builder())
                        .build())
                .build();
    }

    public static Biome mangroveswampBiome(BootstapContext<Biome> context) {
        BiomeGenerationSettings.Builder biomeBuilder =
                new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER));
        globalOverworldGeneration(biomeBuilder);
        return new Biome.BiomeBuilder()
                .generationSettings(biomeBuilder.build())
                .specialEffects((new BiomeSpecialEffects.Builder())
                        .build())
                .build();
    }
}