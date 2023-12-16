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

public class BloomingNatureBiome extends Region {
    public BloomingNatureBiome(ResourceLocation name, int weight) {
        super(name, RegionType.OVERWORLD, weight);
    }

    @Override
    public void addBiomes(Registry<Biome> registry, Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> mapper) {
        this.addModifiedVanillaOverworldBiomes(mapper, modifiedVanillaOverworldBuilder -> {
            modifiedVanillaOverworldBuilder.replaceBiome(Biomes.BIRCH_FOREST, BloomingNatureBiomeKey.BIRCH_FOREST_KEY);
            modifiedVanillaOverworldBuilder.replaceBiome(Biomes.OLD_GROWTH_BIRCH_FOREST, BloomingNatureBiomeKey.ASPEN_FOREST_KEY);
            modifiedVanillaOverworldBuilder.replaceBiome(Biomes.OLD_GROWTH_SPRUCE_TAIGA, BloomingNatureBiomeKey.LARCH_FOREST_KEY);
            modifiedVanillaOverworldBuilder.replaceBiome(Biomes.SAVANNA, BloomingNatureBiomeKey.SAVANNA_KEY);
            modifiedVanillaOverworldBuilder.replaceBiome(Biomes.SAVANNA_PLATEAU, BloomingNatureBiomeKey.SAVANNA_PLATEAU_KEY);
            modifiedVanillaOverworldBuilder.replaceBiome(Biomes.FOREST, BloomingNatureBiomeKey.FOREST_KEY);
            modifiedVanillaOverworldBuilder.replaceBiome(Biomes.PLAINS, BloomingNatureBiomeKey.PLAINS_KEY);
            modifiedVanillaOverworldBuilder.replaceBiome(Biomes.TAIGA, BloomingNatureBiomeKey.TAIGA_KEY);
            modifiedVanillaOverworldBuilder.replaceBiome(Biomes.OLD_GROWTH_PINE_TAIGA, BloomingNatureBiomeKey.OLD_GROWTH_SPRUCE_TAIGA_KEY);
            modifiedVanillaOverworldBuilder.replaceBiome(Biomes.FLOWER_FOREST, BloomingNatureBiomeKey.FLOWER_FOREST_KEY);
            modifiedVanillaOverworldBuilder.replaceBiome(Biomes.RIVER, BloomingNatureBiomeKey.RIVER_KEY);
            modifiedVanillaOverworldBuilder.replaceBiome(Biomes.SUNFLOWER_PLAINS, BloomingNatureBiomeKey.SUNFLOWER_PLAINS_KEY);
            modifiedVanillaOverworldBuilder.replaceBiome(Biomes.CHERRY_GROVE, BloomingNatureBiomeKey.CHERRY_GROVE_KEY);
            modifiedVanillaOverworldBuilder.replaceBiome(Biomes.SNOWY_PLAINS, BloomingNatureBiomeKey.SNOWY_PLAINS_KEY);
            modifiedVanillaOverworldBuilder.replaceBiome(Biomes.SNOWY_TAIGA, BloomingNatureBiomeKey.SNOWY_TAIGA_KEY);
            modifiedVanillaOverworldBuilder.replaceBiome(Biomes.SNOWY_SLOPES, BloomingNatureBiomeKey.SNOWY_SLOPES_KEY);
            modifiedVanillaOverworldBuilder.replaceBiome(Biomes.GROVE, BloomingNatureBiomeKey.GROVE_KEY);
            modifiedVanillaOverworldBuilder.replaceBiome(Biomes.SWAMP, BloomingNatureBiomeKey.SWAMP_KEY);
            modifiedVanillaOverworldBuilder.replaceBiome(Biomes.MANGROVE_SWAMP, BloomingNatureBiomeKey.MANGROVE_SWAMP_KEY);
            modifiedVanillaOverworldBuilder.replaceBiome(Biomes.DESERT, BloomingNatureBiomeKey.DESERT_KEY);

        });
    }

    public static void loadTerrablender() {
        Regions.register(new BloomingNatureBiome(new ResourceLocation(BloomingNature.MOD_ID, "overworld"), 1000));
        SurfaceRuleManager.addSurfaceRules(SurfaceRuleManager.RuleCategory.OVERWORLD, BloomingNature.MOD_ID, BloomingNatureSurfaceRules.makeRules());
    }
}