package satisfyu.bloomingnature.fabric.terrablender;

import satisfyu.bloomingnature.terrablender.BloomingNatureBiome;
import terrablender.api.TerraBlenderApi;

public class TerrablenderFabric implements TerraBlenderApi {

    @Override
    public void onTerraBlenderInitialized() {
        BloomingNatureBiome.loadTerrablender();
    }
}

