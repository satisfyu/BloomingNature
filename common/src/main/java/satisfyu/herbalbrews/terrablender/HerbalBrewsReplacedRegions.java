package satisfyu.herbalbrews.terrablender;

import com.mojang.datafixers.util.Pair;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.biome.Climate;
import satisfyu.herbalbrews.world.HerbalBrewsSurfaceRules;
import terrablender.api.*;

import java.util.function.Consumer;

import static satisfyu.herbalbrews.HerbalBrews.MOD_ID;


public class HerbalBrewsReplacedRegions extends Region {

    public HerbalBrewsReplacedRegions(ResourceLocation name, int weight) {
        super(name, RegionType.OVERWORLD, weight);
    }


    @Override
    public void addBiomes(Registry<Biome> registry, Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> mapper) {
        this.addModifiedVanillaOverworldBiomes(mapper, modifiedVanillaOverworldBuilder -> {
            modifiedVanillaOverworldBuilder.replaceBiome(Biomes.FOREST, ModBiomes.TEST_BIOME);
        });
    }

    public static void loadTerrablender() {
        Regions.register(new HerbalBrewsReplacedRegions(new ResourceLocation(MOD_ID, "overworld"), 5));
        SurfaceRuleManager.addSurfaceRules(SurfaceRuleManager.RuleCategory.OVERWORLD, MOD_ID, HerbalBrewsSurfaceRules.makeRules());
    }
}
