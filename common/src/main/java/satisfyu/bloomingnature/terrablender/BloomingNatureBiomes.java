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
    public static final ResourceKey<Biome> FOREST_KEY = ResourceKey.create(Registries.BIOME,
            new ResourceLocation(BloomingNature.MOD_ID, "forest"));
    public static final ResourceKey<Biome> PLAINS_KEY = ResourceKey.create(Registries.BIOME,
            new ResourceLocation(BloomingNature.MOD_ID, "plains"));
    public static final ResourceKey<Biome> TAIGA_KEY = ResourceKey.create(Registries.BIOME,
            new ResourceLocation(BloomingNature.MOD_ID, "taiga"));
    public static final ResourceKey<Biome> OLD_GROWTH_PINE_TAIGA = ResourceKey.create(Registries.BIOME,
            new ResourceLocation(BloomingNature.MOD_ID, "old_growth_pine_taiga"));

    public static void bootstrap(BootstapContext<Biome> context) {
        context.register(BIRCH_FOREST_KEY, birchforestBiome(context));
        context.register(ASPEN_FOREST_KEY, aspenforestBiome(context));
        context.register(LARCH_FOREST_KEY, larchforestBiome(context));
        context.register(SAVANNA_KEY, savannaBiome(context));
        context.register(FOREST_KEY, forestBiome(context));
        context.register(PLAINS_KEY, plainsBiome(context));
        context.register(TAIGA_KEY, taigaBiome(context));
        context.register(OLD_GROWTH_PINE_TAIGA, oldgrowthpinetaigaBiome(context));


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
}