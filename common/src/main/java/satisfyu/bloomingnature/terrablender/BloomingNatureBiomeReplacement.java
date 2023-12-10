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
            modifiedVanillaOverworldBuilder.replaceBiome(Biomes.BIRCH_FOREST, BloomingNatureBiomes.BIRCH_FOREST_KEY);
            modifiedVanillaOverworldBuilder.replaceBiome(Biomes.OLD_GROWTH_BIRCH_FOREST, BloomingNatureBiomes.ASPEN_FOREST_KEY);
            modifiedVanillaOverworldBuilder.replaceBiome(Biomes.OLD_GROWTH_SPRUCE_TAIGA, BloomingNatureBiomes.LARCH_FOREST_KEY);
            modifiedVanillaOverworldBuilder.replaceBiome(Biomes.SAVANNA, BloomingNatureBiomes.SAVANNA_KEY);
            modifiedVanillaOverworldBuilder.replaceBiome(Biomes.SAVANNA_PLATEAU, BloomingNatureBiomes.SAVANNA_PLATEAU_KEY);
            modifiedVanillaOverworldBuilder.replaceBiome(Biomes.WINDSWEPT_SAVANNA, BloomingNatureBiomes.SAVANNA_PLATEAU_KEY);
            modifiedVanillaOverworldBuilder.replaceBiome(Biomes.FOREST, BloomingNatureBiomes.FOREST_KEY);
            modifiedVanillaOverworldBuilder.replaceBiome(Biomes.FOREST, BloomingNatureBiomes.FOREST_KEY);
            modifiedVanillaOverworldBuilder.replaceBiome(Biomes.PLAINS, BloomingNatureBiomes.PLAINS_KEY);
            modifiedVanillaOverworldBuilder.replaceBiome(Biomes.TAIGA, BloomingNatureBiomes.TAIGA_KEY);
            modifiedVanillaOverworldBuilder.replaceBiome(Biomes.OLD_GROWTH_PINE_TAIGA, BloomingNatureBiomes.OLD_GROWTH_PINE_TAIGA_KEY);
            modifiedVanillaOverworldBuilder.replaceBiome(Biomes.FLOWER_FOREST, BloomingNatureBiomes.FLOWER_FOREST_KEY);
            modifiedVanillaOverworldBuilder.replaceBiome(Biomes.RIVER, BloomingNatureBiomes.RIVER_KEY);
            modifiedVanillaOverworldBuilder.replaceBiome(Biomes.SUNFLOWER_PLAINS, BloomingNatureBiomes.SUNFLOWER_PLAINS_KEY);
            modifiedVanillaOverworldBuilder.replaceBiome(Biomes.CHERRY_GROVE, BloomingNatureBiomes.CHERRY_GROVE_KEY);
            modifiedVanillaOverworldBuilder.replaceBiome(Biomes.SNOWY_PLAINS, BloomingNatureBiomes.SNOWY_PLAINS_KEY);
            modifiedVanillaOverworldBuilder.replaceBiome(Biomes.SNOWY_TAIGA, BloomingNatureBiomes.SNOWY_TAIGA_KEY);
            modifiedVanillaOverworldBuilder.replaceBiome(Biomes.SNOWY_SLOPES, BloomingNatureBiomes.SNOWY_SLOPES_KEY);
            modifiedVanillaOverworldBuilder.replaceBiome(Biomes.GROVE, BloomingNatureBiomes.GROVE_KEY);
            modifiedVanillaOverworldBuilder.replaceBiome(Biomes.SWAMP, BloomingNatureBiomes.SWAMP_KEY);
            modifiedVanillaOverworldBuilder.replaceBiome(Biomes.WINDSWEPT_SAVANNA, BloomingNatureBiomes.SAVANNA_PLATEAU_KEY);
            modifiedVanillaOverworldBuilder.replaceBiome(Biomes.WINDSWEPT_FOREST, BloomingNatureBiomes.FOREST_KEY);
            modifiedVanillaOverworldBuilder.replaceBiome(Biomes.WINDSWEPT_GRAVELLY_HILLS, BloomingNatureBiomes.TAIGA_KEY);
            modifiedVanillaOverworldBuilder.replaceBiome(Biomes.WINDSWEPT_HILLS, BloomingNatureBiomes.PLAINS_KEY);
            modifiedVanillaOverworldBuilder.replaceBiome(Biomes.MANGROVE_SWAMP, BloomingNatureBiomes.MANGROVE_SWAMP_KEY);



        });
    }

    public static void loadTerrablender() {
        Regions.register(new BloomingNatureBiomeReplacement(new ResourceLocation(BloomingNature.MOD_ID, "overworld"), 1000));
        SurfaceRuleManager.addSurfaceRules(SurfaceRuleManager.RuleCategory.OVERWORLD, BloomingNature.MOD_ID, BloomingNatureSurfaceRules.makeRules());
    }
}