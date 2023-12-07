package satisfyu.herbalbrews.registry;

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import satisfyu.herbalbrews.HerbalBrews;
import satisfyu.herbalbrews.entities.FlowerBoxBlockEntity;
import satisfyu.herbalbrews.entities.FlowerPotBigBlockEntity;

import java.util.function.Supplier;

public class BlockEntityRegistry {

    private static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITY_TYPES = DeferredRegister.create(HerbalBrews.MOD_ID, Registries.BLOCK_ENTITY_TYPE);

    public static final RegistrySupplier<BlockEntityType<TeaKettleBlockEntity>> TEA_KETTLE_BLOCK_ENTITY = create("tea_kettle", () -> BlockEntityType.Builder.of(TeaKettleBlockEntity::new, ObjectRegistry.TEA_KETTLE.get(), ObjectRegistry.COPPER_TEA_KETTLE.get()).build(null));
    public static final RegistrySupplier<BlockEntityType<CauldronBlockEntity>> CAULDRON_BLOCK_ENTITY = create("cauldron", () -> BlockEntityType.Builder.of(CauldronBlockEntity::new, ObjectRegistry.CAULDRON.get()).build(null));
    public static final RegistrySupplier<BlockEntityType<FlowerBoxBlockEntity>> FLOWER_BOX_ENTITY = create("flower_box", () -> BlockEntityType.Builder.of(FlowerBoxBlockEntity::new, ObjectRegistry.FLOWER_BOX.get()).build(null));
    public static final RegistrySupplier<BlockEntityType<FlowerPotBigBlockEntity>> FLOWER_POT_BIG_ENTITY = create("flower_pot_big", () -> BlockEntityType.Builder.of(FlowerPotBigBlockEntity::new, ObjectRegistry.FLOWER_POT_BIG.get()).build(null));


    private static <T extends BlockEntityType<?>> RegistrySupplier<T> create(final String path, final Supplier<T> type) {
        return BLOCK_ENTITY_TYPES.register(path, type);
    }

    public static void init() {
        HerbalBrews.LOGGER.debug("Registering Mod BlockEntities for " + HerbalBrews.MOD_ID);
        BLOCK_ENTITY_TYPES.register();
    }

}