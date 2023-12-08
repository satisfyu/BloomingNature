package satisfyu.bloomingnature.fabric.terrablender;

import satisfyu.bloomingnature.terrablender.BloomingNatureBiomeReplacement;
import terrablender.api.TerraBlenderApi;

public class TerrablenderFabric implements TerraBlenderApi {

    @Override
    public void onTerraBlenderInitialized() {
        BloomingNatureBiomeReplacement.loadTerrablender();
    }
}

