package satisfyu.bloomingnature.registry;

import dev.architectury.registry.level.entity.EntityAttributeRegistry;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.animal.Animal;
import satisfyu.bloomingnature.BloomingNature;
import satisfyu.bloomingnature.entities.pelican.PelicanEntity;
import satisfyu.bloomingnature.entities.raccoon.RaccoonEntity;
import satisfyu.bloomingnature.entities.red_wolf.RedWolfEntity;
import satisfyu.bloomingnature.entities.squirrel.SquirrelEntity;
import satisfyu.bloomingnature.entities.wandering_gardener.WanderingGardenerEntity;
import satisfyu.bloomingnature.util.BloomingNatureIdentifier;

import java.util.function.Supplier;

public class EntityRegistry {
    private static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(BloomingNature.MOD_ID, Registries.ENTITY_TYPE);


    public static final RegistrySupplier<EntityType<WanderingGardenerEntity>> WANDERING_GARDENER = create("wandering_gardener",
            () -> EntityType.Builder.of(WanderingGardenerEntity::new, MobCategory.CREATURE)
                    .sized(0.6f, 1.95f)
                    .clientTrackingRange(10)
                    .build(new BloomingNatureIdentifier("wandering_gardener").toString()));

    public static final RegistrySupplier<EntityType<RedWolfEntity>> RED_WOLF = create("red_wolf",
            () -> EntityType.Builder.of(RedWolfEntity::new, MobCategory.CREATURE)
                    .sized(0.4f, 1.5f)
                    .clientTrackingRange(10)
                    .build(new BloomingNatureIdentifier("red_wolf").toString()));

    public static final RegistrySupplier<EntityType<PelicanEntity>> PELICAN = create("pelican",
            () -> EntityType.Builder.of(PelicanEntity::new, MobCategory.CREATURE)
                    .sized(0.9f, 1.3f)
                    .build(new BloomingNatureIdentifier("pelican").toString())
    );

    public static final RegistrySupplier<EntityType<RaccoonEntity>> RACCOON = create("raccoon",
            () -> EntityType.Builder.of(RaccoonEntity::new, MobCategory.CREATURE)
                    .sized(0.9f, 1.3f)
                    .build(new BloomingNatureIdentifier("raccoon").toString())
    );

    public static final RegistrySupplier<EntityType<SquirrelEntity>> SQUIRREL = create("squirrel",
            () -> EntityType.Builder.of(SquirrelEntity::new, MobCategory.CREATURE)
                    .sized(0.9f, 1.3f)
                    .build(new BloomingNatureIdentifier("raccoon").toString())
    );



    public static <T extends EntityType<?>> RegistrySupplier<T> create(final String path, final Supplier<T> type) {
        return ENTITY_TYPES.register(new BloomingNatureIdentifier(path), type);
    }

    public static void init() {
        BloomingNature.LOGGER.debug("Registering Entities for " + BloomingNature.MOD_ID);
        ENTITY_TYPES.register();
        EntityAttributeRegistry.register(WANDERING_GARDENER, WanderingGardenerEntity::createMobAttributes);
        registerRedWolf(RED_WOLF);
        registerPelican(PELICAN);
        registerRaccoon(RACCOON);
        registerSquirrel(SQUIRREL);

    }

    public static void registerPelican(Supplier<? extends EntityType<? extends Animal>> typeSupplier) {
        EntityAttributeRegistry.register(typeSupplier, PelicanEntity::registerAttributes);
    }

    public static void registerRedWolf(Supplier<? extends EntityType<? extends Animal>> typeSupplier) {
        EntityAttributeRegistry.register(typeSupplier, RedWolfEntity::createAttributes);
    }

    public static void registerRaccoon(Supplier<? extends EntityType<? extends Animal>> typeSupplier) {
        EntityAttributeRegistry.register(typeSupplier, RaccoonEntity::createAttributes);
    }

    public static void registerSquirrel(Supplier<? extends EntityType<? extends Animal>> typeSupplier) {
        EntityAttributeRegistry.register(typeSupplier, SquirrelEntity::createAttributes);
    }
}
