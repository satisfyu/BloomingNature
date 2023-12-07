package satisfyu.bloomingnature;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import satisfyu.bloomingnature.registry.*;

public class BloomingNature {
    public static final String MOD_ID = "bloomingnature";
    public static final Logger LOGGER = LogManager.getLogger(MOD_ID);

    public static void init() {
        ObjectRegistry.init();
        BoatsAndSignsRegistry.init();
        BlockEntityRegistry.init();
        EntityRegistry.init();
        TabRegistry.init();
    }

    public static void commonInit() {
        ObjectRegistry.registerCompostable();
    }
}

