package satisfyu.bloomingnature.world;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import satisfyu.bloomingnature.util.BloomingNatureIdentifier;

public class PlacedFeatures {

    public static final ResourceKey<PlacedFeature> PALM_TREE_KEY = registerKey("beach_palm");
    public static final ResourceKey<PlacedFeature> BEACH_FLOWERS_KEY = registerKey("beach_flowers");
    public static final ResourceKey<PlacedFeature> STONE_SLABS_KEY = registerKey("terrain/stone_slabs");
    public static final ResourceKey<PlacedFeature> STONE_MOUND_KEY = registerKey("terrain/stone_mound");
    public static final ResourceKey<PlacedFeature> STONE_CLIFFS_KEY = registerKey("terrain/stone_cliffs");
    public static final ResourceKey<PlacedFeature> STONE_BOULDER_KEY = registerKey("terrain/stone_boulder");
    public static final ResourceKey<PlacedFeature> COBBLESTONE_BEACH_KEY = registerKey("terrain/cobblestone_beach");
    public static final ResourceKey<PlacedFeature> COBBLESTONE_BEACH_MOSSY_KEY = registerKey("terrain/cobblestone_beach_mossy");
    public static final ResourceKey<PlacedFeature> FLOATING_LEAVES_KEY = registerKey("terrain/swamp_floating_leaves");
    public static final ResourceKey<PlacedFeature> JUNGLE_FLOWERS_KEY = registerKey("jungle_flowers");
    public static final ResourceKey<PlacedFeature> QUICKSAND_KEY = registerKey("terrain/quicksand");


    public static ResourceKey<PlacedFeature> registerKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, new BloomingNatureIdentifier(name));
    }
}
