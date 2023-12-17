package satisfyu.bloomingnature.forge;

import dev.architectury.platform.forge.EventBuses;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import satisfyu.bloomingnature.BloomingNature;

@Mod(BloomingNature.MOD_ID)
public class BloomingNatureForge {
    public BloomingNatureForge() {
        EventBuses.registerModEventBus(BloomingNature.MOD_ID, FMLJavaModLoadingContext.get().getModEventBus());
        BloomingNature.init();
        BloomingNature.commonInit();
    }
}
