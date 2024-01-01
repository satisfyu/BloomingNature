package satisfyu.bloomingnature.fabric.world;

import net.fabricmc.fabric.api.biome.v1.*;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.levelgen.GenerationStep;
import satisfyu.bloomingnature.util.BloomingNatureIdentifier;
import satisfyu.bloomingnature.world.PlacedFeatures;

import java.util.function.Predicate;


public class BloomingNatureBiomeModification {

    public static void init() {
        BiomeModification world = BiomeModifications.create(new BloomingNatureIdentifier("world_features"));
        Predicate<BiomeSelectionContext> beachBiomes = getBloomingNatureSelector("beach_biomes");
        Predicate<BiomeSelectionContext> stonyBiomes = getBloomingNatureSelector("stony_biomes");
        Predicate<BiomeSelectionContext> jungleBiomes = getBloomingNatureSelector("jungle_biomes");
        world.add(ModificationPhase.ADDITIONS, beachBiomes, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.PALM_TREE_KEY));
        world.add(ModificationPhase.ADDITIONS, beachBiomes, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.BEACH_FLOWERS_KEY));
        world.add(ModificationPhase.ADDITIONS, stonyBiomes, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.STONE_MOUND_KEY));
        world.add(ModificationPhase.ADDITIONS, stonyBiomes, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.STONE_SLABS_KEY));
        world.add(ModificationPhase.ADDITIONS, stonyBiomes, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.STONE_PILLARS_KEY));
        world.add(ModificationPhase.ADDITIONS, stonyBiomes, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.STONE_CLIFFS_KEY));
        world.add(ModificationPhase.ADDITIONS, stonyBiomes, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.STONE_BOULDER_KEY));
        world.add(ModificationPhase.ADDITIONS, stonyBiomes, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.COBBLESTONE_BEACH_KEY));
        world.add(ModificationPhase.ADDITIONS, stonyBiomes, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.COBBLESTONE_BEACH_MOSSY_KEY));
        world.add(ModificationPhase.ADDITIONS, jungleBiomes, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.FLOATING_LEAVES_KEY));
        world.add(ModificationPhase.ADDITIONS, jungleBiomes, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.JUNGLE_FLOWERS_KEY));
        world.add(ModificationPhase.ADDITIONS, jungleBiomes, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.QUICKSAND_KEY));
    }

    private static Predicate<BiomeSelectionContext> getBloomingNatureSelector(String path) {
        return BiomeSelectors.tag(TagKey.create(Registries.BIOME, new BloomingNatureIdentifier(path)));
    }



}
