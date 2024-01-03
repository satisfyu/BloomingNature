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
        Predicate<BiomeSelectionContext> overworld = getBloomingNatureSelector("overworld");
        Predicate<BiomeSelectionContext> plains = getBloomingNatureSelector("plains");
        Predicate<BiomeSelectionContext> aspen = getBloomingNatureSelector("aspen");
        Predicate<BiomeSelectionContext> birch = getBloomingNatureSelector("birch");
        Predicate<BiomeSelectionContext> forest = getBloomingNatureSelector("forest");
        Predicate<BiomeSelectionContext> flower_forest = getBloomingNatureSelector("flower_forest");
        Predicate<BiomeSelectionContext> river = getBloomingNatureSelector("river");
        Predicate<BiomeSelectionContext> cherry_grove = getBloomingNatureSelector("cherry_grove");
        Predicate<BiomeSelectionContext> grove = getBloomingNatureSelector("grove");
        Predicate<BiomeSelectionContext> snowy_plains = getBloomingNatureSelector("snowy_plains");
        Predicate<BiomeSelectionContext> snowy_slopes = getBloomingNatureSelector("snowy_slopes");
        Predicate<BiomeSelectionContext> snowy_taiga = getBloomingNatureSelector("snowy_taiga");
        Predicate<BiomeSelectionContext> beach = getBloomingNatureSelector("beach");
        Predicate<BiomeSelectionContext> stony_shore = getBloomingNatureSelector("stony_shore");
        Predicate<BiomeSelectionContext> jungle = getBloomingNatureSelector("jungle");
        Predicate<BiomeSelectionContext> desert = getBloomingNatureSelector("desert");
        Predicate<BiomeSelectionContext> swamp = getBloomingNatureSelector("swamp");
        Predicate<BiomeSelectionContext> mangrove_swamp = getBloomingNatureSelector("mangrove_swamp");
        Predicate<BiomeSelectionContext> sunflower_plains = getBloomingNatureSelector("sunflower_plains");
        Predicate<BiomeSelectionContext> taiga = getBloomingNatureSelector("taiga");
        Predicate<BiomeSelectionContext> old_growth_spruce_taiga = getBloomingNatureSelector("old_growth_spruce_taiga");
        Predicate<BiomeSelectionContext> old_growth_pine_taiga = getBloomingNatureSelector("old_growth_pine_taiga");
        Predicate<BiomeSelectionContext> savanna = getBloomingNatureSelector("savanna");
        Predicate<BiomeSelectionContext> savanna_plateau = getBloomingNatureSelector("savanna_plateau");

        //removing lava lakes
        world.add(ModificationPhase.REMOVALS, overworld, ctx -> ctx.getGenerationSettings().removeFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.LAVA_LAKE_SURFACE));
        world.add(ModificationPhase.REMOVALS, overworld, ctx -> ctx.getGenerationSettings().removeFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.LAVA_LAKE_UNDERGROUND));

        //beach
        world.add(ModificationPhase.ADDITIONS, beach, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.PALM_TREE_KEY));
        world.add(ModificationPhase.ADDITIONS, beach, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.BEACH_FLOWERS_KEY));

        //jungle
        world.add(ModificationPhase.ADDITIONS, jungle, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.FLOATING_LEAVES_KEY));
        world.add(ModificationPhase.ADDITIONS, jungle, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.JUNGLE_FLOWERS_KEY));

        //desert
        world.add(ModificationPhase.ADDITIONS, desert, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.QUICKSAND_KEY));

        //plains
        world.add(ModificationPhase.REMOVALS, plains, ctx -> ctx.getGenerationSettings().removeFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.PLAINS_FLOWERS));
        world.add(ModificationPhase.REMOVALS, plains, ctx -> ctx.getGenerationSettings().removeFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.PLAINS_TREES));
        world.add(ModificationPhase.ADDITIONS, plains, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.PLAINS_BN_TREES));
        world.add(ModificationPhase.ADDITIONS, plains, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.PLAINS_BN_FLOWERS));
        world.add(ModificationPhase.ADDITIONS, plains, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.PLAINS_BN_GRASS));
        world.add(ModificationPhase.ADDITIONS, plains, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.STONE_BOULDER_KEY));
        world.add(ModificationPhase.ADDITIONS, plains, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.STONE_MOUND_KEY));
        world.add(ModificationPhase.ADDITIONS, plains, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.GRAVEL_BEACH_KEY));
        world.add(ModificationPhase.ADDITIONS, plains, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.STONE_SLABS_KEY));
        world.add(ModificationPhase.ADDITIONS, plains, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.TRAVERTIN_KEY));
        world.add(ModificationPhase.ADDITIONS, plains, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.PLAINS_BN_MOUND));

        //aspen
        world.add(ModificationPhase.REMOVALS, aspen, ctx -> ctx.getGenerationSettings().removeFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.ASPEN_FLOWERS));
        world.add(ModificationPhase.REMOVALS, aspen, ctx -> ctx.getGenerationSettings().removeFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.FLOWER_DEFAULT));
        world.add(ModificationPhase.REMOVALS, aspen, ctx -> ctx.getGenerationSettings().removeFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.ASPEN_TREES));
        world.add(ModificationPhase.ADDITIONS, aspen, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.ASPEN_BN_TREES));
        world.add(ModificationPhase.ADDITIONS, aspen, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.ASPEN_BN_FALLEN));
        world.add(ModificationPhase.ADDITIONS, aspen, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.ASPEN_BN_FLOWERS));
        world.add(ModificationPhase.ADDITIONS, aspen, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.ASPEN_BN_GRASS));
        world.add(ModificationPhase.ADDITIONS, aspen, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.STONE_SLABS_KEY));

        //birch
        world.add(ModificationPhase.REMOVALS, birch, ctx -> ctx.getGenerationSettings().removeFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.BIRCH_FLOWERS));
        world.add(ModificationPhase.REMOVALS, birch, ctx -> ctx.getGenerationSettings().removeFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.FLOWER_DEFAULT));
        world.add(ModificationPhase.REMOVALS, birch, ctx -> ctx.getGenerationSettings().removeFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.BIRCH_TREES));
        world.add(ModificationPhase.ADDITIONS, birch, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.BIRCH_BN_TREES));
        world.add(ModificationPhase.ADDITIONS, birch, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.BIRCH_BN_FALLEN));
        world.add(ModificationPhase.ADDITIONS, birch, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.BIRCH_BN_FLOWERS));
        world.add(ModificationPhase.ADDITIONS, birch, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.BIRCH_BN_GRASS));
        world.add(ModificationPhase.ADDITIONS, birch, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.STONE_SLABS_KEY));

        //forest
        world.add(ModificationPhase.REMOVALS, forest, ctx -> ctx.getGenerationSettings().removeFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.FOREST_FLOWERS));
        world.add(ModificationPhase.REMOVALS, forest, ctx -> ctx.getGenerationSettings().removeFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.FOREST_TREES));
        world.add(ModificationPhase.ADDITIONS, forest, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.FOREST_BN_TREES));
        world.add(ModificationPhase.ADDITIONS, forest, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.FOREST_BN_FALLEN));
        world.add(ModificationPhase.ADDITIONS, forest, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.FOREST_BN_FLOWERS));
        world.add(ModificationPhase.ADDITIONS, forest, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.FOREST_BN_GRASS));

        //flower_forest
        world.add(ModificationPhase.REMOVALS, flower_forest, ctx -> ctx.getGenerationSettings().removeFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.FLOWER_FOREST_FLOWER));
        world.add(ModificationPhase.REMOVALS, flower_forest, ctx -> ctx.getGenerationSettings().removeFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.FLOWER_FOREST_FLOWER_FLOWER));
        world.add(ModificationPhase.REMOVALS, flower_forest, ctx -> ctx.getGenerationSettings().removeFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.FLOWER_FOREST_TREES));
        world.add(ModificationPhase.ADDITIONS, flower_forest, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.FLOWER_FOREST_BN_TREES));
        world.add(ModificationPhase.ADDITIONS, flower_forest, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.FLOWER_FOREST_BN_FALLEN));
        world.add(ModificationPhase.ADDITIONS, flower_forest, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.FLOWER_FOREST_BN_FLOWERS));
        world.add(ModificationPhase.ADDITIONS, flower_forest, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.FLOWER_FOREST_BN_GRASS));

        //river
        world.add(ModificationPhase.REMOVALS, river, ctx -> ctx.getGenerationSettings().removeFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.RIVER_TREES));
        world.add(ModificationPhase.REMOVALS, river, ctx -> ctx.getGenerationSettings().removeFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.RIVER_FLOWERS));
        world.add(ModificationPhase.ADDITIONS, river, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.RIVER_BN_TREES));
        world.add(ModificationPhase.ADDITIONS, river, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.PLAINS_BN_GRASS));
        world.add(ModificationPhase.ADDITIONS, river, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.STONE_BOULDER_KEY));
        world.add(ModificationPhase.ADDITIONS, river, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.STONE_MOUND_KEY));
        world.add(ModificationPhase.ADDITIONS, river, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.GRAVEL_BEACH_KEY));
        world.add(ModificationPhase.ADDITIONS, river, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.STONE_SLABS_KEY));
        world.add(ModificationPhase.ADDITIONS, river, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.TRAVERTIN_KEY));
        world.add(ModificationPhase.ADDITIONS, river, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.PLAINS_BN_MOUND));

        //cherry
        world.add(ModificationPhase.REMOVALS, cherry_grove, ctx -> ctx.getGenerationSettings().removeFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.CHERRY_TREES));
        world.add(ModificationPhase.REMOVALS, cherry_grove, ctx -> ctx.getGenerationSettings().removeFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.CHERRY_FLOWERS));
        world.add(ModificationPhase.ADDITIONS, cherry_grove, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.CHERRY_BN_TREES));
        world.add(ModificationPhase.ADDITIONS, cherry_grove, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.CHERRY_BN_FLOWERS));

        //grove
        world.add(ModificationPhase.REMOVALS, grove, ctx -> ctx.getGenerationSettings().removeFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.GROVE_TREES));
        world.add(ModificationPhase.ADDITIONS, grove, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.SNOWY_PLAINS_BN_TREES));

        //snowy_plains
        world.add(ModificationPhase.REMOVALS, snowy_plains, ctx -> ctx.getGenerationSettings().removeFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.SNOWY_PLAINS_TREES));
        world.add(ModificationPhase.REMOVALS, snowy_plains, ctx -> ctx.getGenerationSettings().removeFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.SNOWY_PLAINS_FLOWERS));
        world.add(ModificationPhase.ADDITIONS, snowy_plains, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.SNOWY_PLAINS_BN_TREES));
        world.add(ModificationPhase.ADDITIONS, snowy_plains, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.STONE_BOULDER_KEY));
        world.add(ModificationPhase.ADDITIONS, snowy_plains, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.STONE_MOUND_KEY));
        world.add(ModificationPhase.ADDITIONS, snowy_plains, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.GRAVEL_BEACH_KEY));
        world.add(ModificationPhase.ADDITIONS, snowy_plains, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.STONE_SLABS_KEY));

        //snowy_slopes
        world.add(ModificationPhase.ADDITIONS, snowy_slopes, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.SNOWY_SLOPES_BN_TREES));

        //snowy_taiga
        world.add(ModificationPhase.REMOVALS, snowy_taiga, ctx -> ctx.getGenerationSettings().removeFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.SNOWY_TAIGA_TREES));
        world.add(ModificationPhase.ADDITIONS, snowy_taiga, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.SNOWY_TAIGA_BN_TREES));
        world.add(ModificationPhase.ADDITIONS, snowy_taiga, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.STONE_BOULDER_KEY));
        world.add(ModificationPhase.ADDITIONS, snowy_taiga, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.STONE_MOUND_KEY));
        world.add(ModificationPhase.ADDITIONS, snowy_taiga, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.GRAVEL_BEACH_KEY));
        world.add(ModificationPhase.ADDITIONS, snowy_taiga, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.STONE_SLABS_KEY));

        //swamp
        world.add(ModificationPhase.REMOVALS, swamp, ctx -> ctx.getGenerationSettings().removeFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.SWAMP_TREES));
        world.add(ModificationPhase.REMOVALS, swamp, ctx -> ctx.getGenerationSettings().removeFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.SWAMP_FLOWERS));
        world.add(ModificationPhase.REMOVALS, swamp, ctx -> ctx.getGenerationSettings().removeFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.SWAMP_GRASS));
        world.add(ModificationPhase.ADDITIONS, swamp, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.SWAMP_WATER_BASIN));
        world.add(ModificationPhase.ADDITIONS, swamp, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.SWAMP_MARSH_BASIN));
        world.add(ModificationPhase.ADDITIONS, swamp, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.SWAMP_FLOATING_LEAVES));
        world.add(ModificationPhase.ADDITIONS, swamp, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.SWAMP_MUD));
        world.add(ModificationPhase.ADDITIONS, swamp, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.SWAMP_SWAMP_MUD));
        world.add(ModificationPhase.ADDITIONS, swamp, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.SWAMP_MARSH));
        world.add(ModificationPhase.ADDITIONS, swamp, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.SWAMP_BN_TREES));
        world.add(ModificationPhase.ADDITIONS, swamp, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.SWAMP_VEGETATION));
        world.add(ModificationPhase.ADDITIONS, swamp, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.SWAMP_CATTAILS));
        world.add(ModificationPhase.ADDITIONS, swamp, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.SWAMP_REED));
        world.add(ModificationPhase.ADDITIONS, swamp, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.SWAMP_BN_GRASS));
        world.add(ModificationPhase.ADDITIONS, swamp, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.SWAMP_BN_FLOWERS));

        //mangrove_swamp
        world.add(ModificationPhase.ADDITIONS, mangrove_swamp, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.SWAMP_WATER_BASIN));
        world.add(ModificationPhase.ADDITIONS, mangrove_swamp, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.SWAMP_MARSH_BASIN));
        world.add(ModificationPhase.ADDITIONS, mangrove_swamp, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.SWAMP_FLOATING_LEAVES));
        world.add(ModificationPhase.ADDITIONS, mangrove_swamp, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.SWAMP_MUD));
        world.add(ModificationPhase.ADDITIONS, mangrove_swamp, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.SWAMP_SWAMP_MUD));
        world.add(ModificationPhase.ADDITIONS, mangrove_swamp, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.SWAMP_MARSH));
        world.add(ModificationPhase.ADDITIONS, mangrove_swamp, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.SWAMP_VEGETATION));
        world.add(ModificationPhase.ADDITIONS, mangrove_swamp, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.SWAMP_CATTAILS));
        world.add(ModificationPhase.ADDITIONS, mangrove_swamp, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.SWAMP_REED));

        //sunflower_plains
        world.add(ModificationPhase.ADDITIONS, sunflower_plains, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.PLAINS_BN_TREES));
        world.add(ModificationPhase.ADDITIONS, sunflower_plains, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.ASPEN_BN_FLOWERS));

        //stone_shore
        world.add(ModificationPhase.ADDITIONS, stony_shore, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.STONE_PILLARS_KEY));
        world.add(ModificationPhase.ADDITIONS, stony_shore, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.STONE_CLIFFS_KEY));
        world.add(ModificationPhase.ADDITIONS, stony_shore, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.COBBLESTONE_BEACH_KEY));
        world.add(ModificationPhase.ADDITIONS, stony_shore, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.COBBLESTONE_BEACH_MOSSY_KEY));

        //taiga
        world.add(ModificationPhase.REMOVALS, taiga, ctx -> ctx.getGenerationSettings().removeFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.TAIGA_LARGE_FERN));
        world.add(ModificationPhase.REMOVALS, taiga, ctx -> ctx.getGenerationSettings().removeFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.TAIGA_TREES));
        world.add(ModificationPhase.REMOVALS, taiga, ctx -> ctx.getGenerationSettings().removeFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.TAIGA_FLOWERS));
        world.add(ModificationPhase.REMOVALS, taiga, ctx -> ctx.getGenerationSettings().removeFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.TAIGA_GRASS));
        world.add(ModificationPhase.ADDITIONS, taiga, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.TAIGA_SPRUCE_TREES));
        world.add(ModificationPhase.ADDITIONS, taiga, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.TAIGA_SPRUCE_FALLEN));
        world.add(ModificationPhase.ADDITIONS, taiga, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.TAIGA_GRASS_PATCH));
        world.add(ModificationPhase.ADDITIONS, taiga, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.TAIGA_BN_FLOWERS));
        world.add(ModificationPhase.ADDITIONS, taiga, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.STONE_BOULDER_KEY));
        world.add(ModificationPhase.ADDITIONS, taiga, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.STONE_MOUND_KEY));
        world.add(ModificationPhase.ADDITIONS, taiga, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.GRAVEL_BEACH_KEY));
        world.add(ModificationPhase.ADDITIONS, taiga, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.STONE_SLABS_KEY));
        world.add(ModificationPhase.ADDITIONS, taiga, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.TRAVERTIN_KEY));
        world.add(ModificationPhase.ADDITIONS, taiga, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.TAIGA_FOREST_MOSS));

        //old_growth_spruce_taiga
        world.add(ModificationPhase.REMOVALS, old_growth_spruce_taiga, ctx -> ctx.getGenerationSettings().removeFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.OLD_GROWTH_SPRUCE_TAIGA_LARGE_FERN));
        world.add(ModificationPhase.REMOVALS, old_growth_spruce_taiga, ctx -> ctx.getGenerationSettings().removeFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.OLD_GROWTH_SPRUCE_TAIGA_TREES));
        world.add(ModificationPhase.REMOVALS, old_growth_spruce_taiga, ctx -> ctx.getGenerationSettings().removeFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.OLD_GROWTH_SPRUCE_TAIGA_FLOWERS));
        world.add(ModificationPhase.REMOVALS, old_growth_spruce_taiga, ctx -> ctx.getGenerationSettings().removeFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.OLD_GROWTH_SPRUCE_TAIGA_GRASS));
        world.add(ModificationPhase.ADDITIONS, old_growth_spruce_taiga, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.OLD_GROWTH_SPRUCE_TAIGA_BN_TREES));
        world.add(ModificationPhase.ADDITIONS, old_growth_spruce_taiga, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.TAIGA_SPRUCE_FALLEN));
        world.add(ModificationPhase.ADDITIONS, old_growth_spruce_taiga, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.TAIGA_GRASS_PATCH));
        world.add(ModificationPhase.ADDITIONS, old_growth_spruce_taiga, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.TAIGA_BN_FLOWERS));
        world.add(ModificationPhase.ADDITIONS, old_growth_spruce_taiga, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.STONE_BOULDER_KEY));
        world.add(ModificationPhase.ADDITIONS, old_growth_spruce_taiga, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.STONE_MOUND_KEY));
        world.add(ModificationPhase.ADDITIONS, old_growth_spruce_taiga, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.GRAVEL_BEACH_KEY));
        world.add(ModificationPhase.ADDITIONS, old_growth_spruce_taiga, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.STONE_SLABS_KEY));
        world.add(ModificationPhase.ADDITIONS, old_growth_spruce_taiga, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.TRAVERTIN_KEY));
        world.add(ModificationPhase.ADDITIONS, old_growth_spruce_taiga, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.TAIGA_FOREST_MOSS));

        //old_growth_pine_taiga
        world.add(ModificationPhase.REMOVALS, old_growth_pine_taiga, ctx -> ctx.getGenerationSettings().removeFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.OLD_GROWTH_PINE_TAIGA_LARGE_FERN));
        world.add(ModificationPhase.REMOVALS, old_growth_pine_taiga, ctx -> ctx.getGenerationSettings().removeFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.OLD_GROWTH_PINE_TAIGA_TREES));
        world.add(ModificationPhase.REMOVALS, old_growth_pine_taiga, ctx -> ctx.getGenerationSettings().removeFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.OLD_GROWTH_PINE_TAIGA_FLOWERS));
        world.add(ModificationPhase.REMOVALS, old_growth_pine_taiga, ctx -> ctx.getGenerationSettings().removeFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.OLD_GROWTH_PINE_TAIGA_GRASS));
        world.add(ModificationPhase.ADDITIONS, old_growth_pine_taiga, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.LARCH_TREES));
        world.add(ModificationPhase.ADDITIONS, old_growth_pine_taiga, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.LARCH_FALLEN));
        world.add(ModificationPhase.ADDITIONS, old_growth_pine_taiga, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.LARCH_FLOWERS));
        world.add(ModificationPhase.ADDITIONS, old_growth_pine_taiga, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.LARCH_GRASS_PATCH));
        world.add(ModificationPhase.ADDITIONS, old_growth_pine_taiga, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.STONE_SLABS_KEY));
        world.add(ModificationPhase.ADDITIONS, old_growth_pine_taiga, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.TAIGA_FOREST_MOSS));

        //savanna
        world.add(ModificationPhase.REMOVALS, savanna, ctx -> ctx.getGenerationSettings().removeFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.TREES_SAVANNA));
        world.add(ModificationPhase.REMOVALS, savanna, ctx -> ctx.getGenerationSettings().removeFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.PATCH_GRASS_SAVANNA));
        world.add(ModificationPhase.REMOVALS, savanna, ctx -> ctx.getGenerationSettings().removeFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.BROWN_MUSHROOM_NORMAL));
        world.add(ModificationPhase.REMOVALS, savanna, ctx -> ctx.getGenerationSettings().removeFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.RED_MUSHROOM_NORMAL));
        world.add(ModificationPhase.REMOVALS, savanna, ctx -> ctx.getGenerationSettings().removeFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.FLOWER_WARM));
        world.add(ModificationPhase.ADDITIONS, savanna, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.SAVANNA_TREES));
        world.add(ModificationPhase.ADDITIONS, savanna, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.SAVANNA_VEGETATION));
        world.add(ModificationPhase.ADDITIONS, savanna, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.SAVANNA_GRASS_PATCH));
        world.add(ModificationPhase.ADDITIONS, savanna, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.GRANITE_BOULDERS));
        world.add(ModificationPhase.ADDITIONS, savanna, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.GRANITE_SLABS));
        world.add(ModificationPhase.ADDITIONS, savanna, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.PACKED_MUD));

        //savanna_plateau
        world.add(ModificationPhase.REMOVALS, savanna_plateau, ctx -> ctx.getGenerationSettings().removeFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.TREES_SAVANNA));
        world.add(ModificationPhase.REMOVALS, savanna_plateau, ctx -> ctx.getGenerationSettings().removeFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.PATCH_GRASS_SAVANNA));
        world.add(ModificationPhase.REMOVALS, savanna_plateau, ctx -> ctx.getGenerationSettings().removeFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.BROWN_MUSHROOM_NORMAL));
        world.add(ModificationPhase.REMOVALS, savanna_plateau, ctx -> ctx.getGenerationSettings().removeFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.RED_MUSHROOM_NORMAL));
        world.add(ModificationPhase.REMOVALS, savanna_plateau, ctx -> ctx.getGenerationSettings().removeFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.FLOWER_WARM));
        world.add(ModificationPhase.ADDITIONS, savanna_plateau, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.SAVANNA_PLATEAU_TREES));
        world.add(ModificationPhase.ADDITIONS, savanna_plateau, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.SAVANNA_VEGETATION));
        world.add(ModificationPhase.ADDITIONS, savanna_plateau, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.SAVANNA_GRASS_PATCH));
        world.add(ModificationPhase.ADDITIONS, savanna_plateau, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.GRANITE_BOULDERS));
        world.add(ModificationPhase.ADDITIONS, savanna_plateau, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.GRANITE_SLABS));
        world.add(ModificationPhase.ADDITIONS, savanna_plateau, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.PACKED_MUD));


    }



    private static Predicate<BiomeSelectionContext> getBloomingNatureSelector(String path) {
        return BiomeSelectors.tag(TagKey.create(Registries.BIOME, new BloomingNatureIdentifier(path)));
    }
}
