package satisfyu.bloomingnature.fabric.world;

import net.fabricmc.fabric.api.biome.v1.*;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.levelgen.GenerationStep;
import satisfyu.bloomingnature.util.BloomingNatureIdentifier;
import satisfyu.bloomingnature.world.feature.BloomingNaturePlacedFeature;

import java.util.function.Predicate;


public class BloomingNatureBiomeModification {

    public static void init() {
        BiomeModification world = BiomeModifications.create(new BloomingNatureIdentifier("world_features"));
        Predicate<BiomeSelectionContext> swampBiomes = getBloomingnatureSelector("swamp_biomes");
        Predicate<BiomeSelectionContext> jungleBiomes = getBloomingnatureSelector("jungle_biomes");
        Predicate<BiomeSelectionContext> savannaBiomes = getBloomingnatureSelector("savanna_biomes");
        Predicate<BiomeSelectionContext> mountainBiomes = getBloomingnatureSelector("cherry_blossom_biomes");
        Predicate<BiomeSelectionContext> temperateBiomes = getBloomingnatureSelector("temperate_biomes");
        Predicate<BiomeSelectionContext> larchBiomes = getBloomingnatureSelector("larch_biomes");
        Predicate<BiomeSelectionContext> taigaBiomes = getBloomingnatureSelector("taiga_biomes");
        world.add(ModificationPhase.ADDITIONS, savannaBiomes, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BloomingNaturePlacedFeature.BEGONIE_FLOWER_PATCH_CHANCE_KEY));

        world.add(ModificationPhase.ADDITIONS, jungleBiomes, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BloomingNaturePlacedFeature.BOTTLEBRUSHES_FLOWER_PATCH_CHANCE_KEY));
        world.add(ModificationPhase.ADDITIONS, temperateBiomes, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BloomingNaturePlacedFeature.DAPHNE_FLOWER_PATCH_CHANCE_KEY));
        world.add(ModificationPhase.ADDITIONS, temperateBiomes, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BloomingNaturePlacedFeature.MOUNTAIN_LAUREL_FLOWER_PATCH_CHANCE_KEY));
        world.add(ModificationPhase.ADDITIONS, swampBiomes, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BloomingNaturePlacedFeature.CARDINAL_FLOWER_PATCH_CHANCE_KEY));
        world.add(ModificationPhase.ADDITIONS, swampBiomes, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BloomingNaturePlacedFeature.HYSSOP_FLOWER_PATCH_CHANCE_KEY));
        world.add(ModificationPhase.ADDITIONS, swampBiomes, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BloomingNaturePlacedFeature.JOE_PYE_FLOWER_PATCH_CHANCE_KEY));
        world.add(ModificationPhase.ADDITIONS, jungleBiomes, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BloomingNaturePlacedFeature.WHITE_ORCHID_FLOWER_PATCH_CHANCE_KEY));
        world.add(ModificationPhase.ADDITIONS, jungleBiomes, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BloomingNaturePlacedFeature.BIRD_OF_PARADISE_FLOWER_PATCH_CHANCE_KEY));
        world.add(ModificationPhase.ADDITIONS, mountainBiomes, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BloomingNaturePlacedFeature.SNOWBELL_FLOWER_PATCH_CHANCE_KEY));
        world.add(ModificationPhase.ADDITIONS, mountainBiomes, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BloomingNaturePlacedFeature.BLUEBELL_FLOWER_PATCH_CHANCE_KEY));
        world.add(ModificationPhase.ADDITIONS, taigaBiomes, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BloomingNaturePlacedFeature.MYOSOTIS_FLOWER_PATCH_CHANCE_KEY));
        world.add(ModificationPhase.ADDITIONS, taigaBiomes, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BloomingNaturePlacedFeature.LUPINE_BLUE_FLOWER_PATCH_CHANCE_KEY));
        world.add(ModificationPhase.ADDITIONS, taigaBiomes, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BloomingNaturePlacedFeature.LUPINE_PURPLE_FLOWER_PATCH_CHANCE_KEY));

        world.add(ModificationPhase.ADDITIONS, larchBiomes, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BloomingNaturePlacedFeature.LARCH_GRASS_PATCH_CHANCE_KEY));
        world.add(ModificationPhase.ADDITIONS, larchBiomes, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BloomingNaturePlacedFeature.GOATSBEARD_FLOWER_PATCH_CHANCE_KEY));
        world.add(ModificationPhase.ADDITIONS, larchBiomes, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BloomingNaturePlacedFeature.GENISTEAE_FLOWER_PATCH_CHANCE_KEY));
        world.add(ModificationPhase.ADDITIONS, larchBiomes, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BloomingNaturePlacedFeature.FOXGLOVE_WHITE_FLOWER_PATCH_CHANCE_KEY));
        world.add(ModificationPhase.ADDITIONS, swampBiomes, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BloomingNaturePlacedFeature.FOXGLOVE_PINK_FLOWER_PATCH_CHANCE_KEY));


        world.add(ModificationPhase.ADDITIONS, larchBiomes, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BloomingNaturePlacedFeature.FREESIA_YELLOW_FLOWER_PATCH_CHANCE_KEY));
        world.add(ModificationPhase.ADDITIONS, larchBiomes, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BloomingNaturePlacedFeature.FREESIA_PINK_FLOWER_PATCH_CHANCE_KEY));

    }

    private static Predicate<BiomeSelectionContext> getBloomingnatureSelector(String path) {
        return BiomeSelectors.tag(TagKey.create(Registries.BIOME, new BloomingNatureIdentifier(path)));
    }


}
