package satisfyu.bloomingnature.registry;

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.Registrar;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import satisfyu.bloomingnature.BloomingNature;
import satisfyu.bloomingnature.util.BloomingNatureIdentifier;

public class SoundRegistry {
    public static final Registrar<SoundEvent> SOUND_EVENTS = DeferredRegister.create(BloomingNature.MOD_ID, Registries.SOUND_EVENT).getRegistrar();

    public static final RegistrySupplier<SoundEvent> DEER_AMBIENT = create("deer_ambient");
    public static final RegistrySupplier<SoundEvent> DEER_HURT = create("deer_hurt");
    public static final RegistrySupplier<SoundEvent> DEER_DEATH = create("deer_death");
    public static final RegistrySupplier<SoundEvent> RACCOON_AMBIENT = create("raccoon_ambient");
    public static final RegistrySupplier<SoundEvent> RACCOON_HURT = create("raccoon_hurt");
    public static final RegistrySupplier<SoundEvent> RACCOON_DEATH = create("raccoon_death");
    public static final RegistrySupplier<SoundEvent> SQUIRREL_AMBIENT = create("squirrel_ambient");
    public static final RegistrySupplier<SoundEvent> SQUIRREL_HURT = create("squirrel_hurt");
    public static final RegistrySupplier<SoundEvent> SQUIRREL_DEATH = create("squirrel_death");
    public static final RegistrySupplier<SoundEvent> OWL_AMBIENT = create("owl_ambient");
    public static final RegistrySupplier<SoundEvent> OWL_HURT = create("owl_hurt");
    public static final RegistrySupplier<SoundEvent> OWL_DEATH = create("owl_death");



    private static RegistrySupplier<SoundEvent> create(String name) {
        final ResourceLocation id = new BloomingNatureIdentifier(name);
        return SOUND_EVENTS.register(id, () -> SoundEvent.createVariableRangeEvent(id));
    }

    public static void init() {
        BloomingNature.LOGGER.debug("Registering Sounds for " + BloomingNature.MOD_ID);
    }
}
