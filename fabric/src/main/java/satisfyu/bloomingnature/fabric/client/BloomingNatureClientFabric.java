package satisfyu.bloomingnature.fabric.client;

import net.fabricmc.api.ClientModInitializer;
import satisfyu.bloomingnature.client.BloomingNatureClient;

public class BloomingNatureClientFabric implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BloomingNatureClient.preInitClient();
        BloomingNatureClient.initClient();
    }
}
