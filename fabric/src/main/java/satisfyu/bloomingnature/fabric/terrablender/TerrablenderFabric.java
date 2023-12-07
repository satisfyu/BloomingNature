package satisfyu.bloomingnature.fabric.terrablender;

import satisfyu.bloomingnature.terrablender.BloomingNatureRegion;
import terrablender.api.TerraBlenderApi;

public class TerrablenderFabric implements TerraBlenderApi {

    @Override
    public void onTerraBlenderInitialized() {
        BloomingNatureRegion.loadTerrablender();
    }
}

