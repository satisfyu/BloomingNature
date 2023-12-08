package satisfyu.bloomingnature.fabric;

import net.fabricmc.api.ModInitializer;
import satisfyu.bloomingnature.BloomingNature;

public class BloomingNatureFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        BloomingNature.init();
    }
}
