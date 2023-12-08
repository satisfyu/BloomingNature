package satisfyu.bloomingnature.terrablender;

import com.mojang.datafixers.util.Pair;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.biome.Climate;
import satisfyu.bloomingnature.BloomingNature;
import satisfyu.bloomingnature.world.BloomingNatureSurfaceRules;
import terrablender.api.Region;
import terrablender.api.RegionType;
import terrablender.api.Regions;
import terrablender.api.SurfaceRuleManager;

import java.util.function.Consumer;

public class BloomingNatureBiomeReplacement extends Region {
    public BloomingNatureBiomeReplacement(ResourceLocation name, int weight) {
        super(name, RegionType.OVERWORLD, weight);
    }

    @Override
    public void addBiomes(Registry<Biome> registry, Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> mapper) {
        this.addModifiedVanillaOverworldBiomes(mapper, modifiedVanillaOverworldBuilder -> {
            modifiedVanillaOverworldBuilder.replaceBiome(Biomes.BIRCH_FOREST, BloomingNatureBiomes.ASPEN_FOREST_KEY);
            modifiedVanillaOverworldBuilder.replaceBiome(Biomes.BIRCH_FOREST, BloomingNatureBiomes.BIRCH_FOREST_KEY);
            modifiedVanillaOverworldBuilder.replaceBiome(Biomes.BIRCH_FOREST, BloomingNatureBiomes.BIRCH_FOREST_KEY);
            modifiedVanillaOverworldBuilder.replaceBiome(Biomes.BIRCH_FOREST, BloomingNatureBiomes.BIRCH_FOREST_KEY);
            modifiedVanillaOverworldBuilder.replaceBiome(Biomes.OLD_GROWTH_BIRCH_FOREST, BloomingNatureBiomes.BIRCH_FOREST_KEY);
            modifiedVanillaOverworldBuilder.replaceBiome(Biomes.OLD_GROWTH_BIRCH_FOREST, BloomingNatureBiomes.BIRCH_FOREST_KEY);
            modifiedVanillaOverworldBuilder.replaceBiome(Biomes.OLD_GROWTH_BIRCH_FOREST, BloomingNatureBiomes.BIRCH_FOREST_KEY);
            modifiedVanillaOverworldBuilder.replaceBiome(Biomes.OLD_GROWTH_SPRUCE_TAIGA, BloomingNatureBiomes.LARCH_FOREST_KEY);
            modifiedVanillaOverworldBuilder.replaceBiome(Biomes.OLD_GROWTH_SPRUCE_TAIGA, BloomingNatureBiomes.LARCH_FOREST_KEY);
            modifiedVanillaOverworldBuilder.replaceBiome(Biomes.SAVANNA, BloomingNatureBiomes.SAVANNA_KEY);
            modifiedVanillaOverworldBuilder.replaceBiome(Biomes.SAVANNA, BloomingNatureBiomes.SAVANNA_KEY);
            modifiedVanillaOverworldBuilder.replaceBiome(Biomes.SAVANNA, BloomingNatureBiomes.SAVANNA_KEY);
            modifiedVanillaOverworldBuilder.replaceBiome(Biomes.FOREST, BloomingNatureBiomes.FOREST_KEY);
            modifiedVanillaOverworldBuilder.replaceBiome(Biomes.FOREST, BloomingNatureBiomes.FOREST_KEY);
            modifiedVanillaOverworldBuilder.replaceBiome(Biomes.FOREST, BloomingNatureBiomes.FOREST_KEY);
            modifiedVanillaOverworldBuilder.replaceBiome(Biomes.PLAINS, BloomingNatureBiomes.PLAINS_KEY);
            modifiedVanillaOverworldBuilder.replaceBiome(Biomes.PLAINS, BloomingNatureBiomes.PLAINS_KEY);
            modifiedVanillaOverworldBuilder.replaceBiome(Biomes.PLAINS, BloomingNatureBiomes.PLAINS_KEY);
            modifiedVanillaOverworldBuilder.replaceBiome(Biomes.TAIGA, BloomingNatureBiomes.TAIGA_KEY);
            modifiedVanillaOverworldBuilder.replaceBiome(Biomes.TAIGA, BloomingNatureBiomes.TAIGA_KEY);
            modifiedVanillaOverworldBuilder.replaceBiome(Biomes.TAIGA, BloomingNatureBiomes.TAIGA_KEY);
            modifiedVanillaOverworldBuilder.replaceBiome(Biomes.OLD_GROWTH_PINE_TAIGA, BloomingNatureBiomes.OLD_GROWTH_PINE_TAIGA);
            modifiedVanillaOverworldBuilder.replaceBiome(Biomes.OLD_GROWTH_PINE_TAIGA, BloomingNatureBiomes.OLD_GROWTH_PINE_TAIGA);
            modifiedVanillaOverworldBuilder.replaceBiome(Biomes.OLD_GROWTH_PINE_TAIGA, BloomingNatureBiomes.OLD_GROWTH_PINE_TAIGA);

        });
    }

    public static void loadTerrablender() {
        Regions.register(new BloomingNatureBiomeReplacement(new ResourceLocation(BloomingNature.MOD_ID, "overworld"), 100));
        SurfaceRuleManager.addSurfaceRules(SurfaceRuleManager.RuleCategory.OVERWORLD, BloomingNature.MOD_ID, BloomingNatureSurfaceRules.makeRules());
    }
}