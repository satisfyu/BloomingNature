package satisfyu.herbalbrews.fabric.terrablender;

import satisfyu.herbalbrews.terrablender.HerbalBrewsRegion;
import satisfyu.herbalbrews.terrablender.HerbalBrewsReplacedRegions;
import terrablender.api.TerraBlenderApi;

public class TerrablenderFabric implements TerraBlenderApi {

    @Override
    public void onTerraBlenderInitialized() {
        HerbalBrewsRegion.loadTerrablender();
        HerbalBrewsReplacedRegions.loadTerrablender();
    }
}

