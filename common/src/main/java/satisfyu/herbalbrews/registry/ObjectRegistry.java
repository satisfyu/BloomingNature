package satisfyu.herbalbrews.registry;

import de.cristelknight.doapi.Util;
import dev.architectury.core.item.ArchitecturySpawnEggItem;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.Registrar;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.flag.FeatureFlag;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import org.jetbrains.annotations.NotNull;
import satisfyu.herbalbrews.HerbalBrews;
import satisfyu.herbalbrews.blocks.*;
import satisfyu.herbalbrews.items.*;
import satisfyu.herbalbrews.util.GeneralUtil;
import satisfyu.herbalbrews.util.HerbalBrewsIdentifier;

import java.util.function.Consumer;
import java.util.function.Supplier;

@SuppressWarnings("unused")
public class ObjectRegistry {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(HerbalBrews.MOD_ID, Registries.ITEM);
    public static final Registrar<Item> ITEM_REGISTRAR = ITEMS.getRegistrar();
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(HerbalBrews.MOD_ID, Registries.BLOCK);
    public static final Registrar<Block> BLOCK_REGISTRAR = BLOCKS.getRegistrar();


    public static final RegistrySupplier<Block> RED_BRICKS = registerWithItem("red_bricks", () -> new Block(BlockBehaviour.Properties.copy(Blocks.BRICKS)));
    public static final RegistrySupplier<Block> RED_BRICK_STAIRS = registerWithItem("red_brick_stairs", () -> new StairBlock(RED_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(RED_BRICKS.get())));
    public static final RegistrySupplier<Block> RED_BRICK_SLAB = registerWithItem("red_brick_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(RED_BRICKS.get())));
    public static final RegistrySupplier<Block> RED_BRICK_WALL = registerWithItem("red_brick_wall", () -> new WallBlock(BlockBehaviour.Properties.copy(RED_BRICKS.get())));

    public static final RegistrySupplier<Block> CALCITE_BRICKS = registerWithItem("calcite_bricks", () -> new Block(BlockBehaviour.Properties.copy(Blocks.CALCITE)));
    public static final RegistrySupplier<Block> CALCITE_BRICK_STAIRS = registerWithItem("calcite_brick_stairs", () -> new StairBlock(CALCITE_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(RED_BRICKS.get())));
    public static final RegistrySupplier<Block> CALCITE_BRICK_SLAB = registerWithItem("calcite_brick_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(CALCITE_BRICKS.get())));
    public static final RegistrySupplier<Block> CALCITE_BRICK_WALL = registerWithItem("calcite_brick_wall", () -> new WallBlock(BlockBehaviour.Properties.copy(CALCITE_BRICKS.get())));


    public static final RegistrySupplier<Block> LARCH_LOG = registerWithItem("larch_log", () -> new RotatedPillarBlock(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(2.0f)));
    public static final RegistrySupplier<Block> LARCH_WOOD = registerWithItem("larch_wood", () -> new RotatedPillarBlock(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(2.0f)));
    public static final RegistrySupplier<Block> STRIPPED_LARCH_WOOD = registerWithItem("stripped_larch_wood", () -> new RotatedPillarBlock(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(2.0f)));
    public static final RegistrySupplier<Block> STRIPPED_LARCH_LOG = registerWithItem("stripped_larch_log", () -> new RotatedPillarBlock(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(2.0f)));
    public static final RegistrySupplier<Block> LARCH_PLANKS = registerWithItem("larch_planks", () -> new Block(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(2.0f, 3.0f).mapColor(MapColor.TERRACOTTA_ORANGE)));
    public static final RegistrySupplier<Block> LARCH_STAIRS = registerWithItem("larch_stairs", () -> new StairBlock(LARCH_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.OAK_STAIRS)));
    public static final RegistrySupplier<Block> LARCH_SLAB = registerWithItem("larch_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SLAB)));
    public static final RegistrySupplier<Block> LARCH_PRESSURE_PLATE = registerWithItem("larch_pressure_plate", () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.of().noCollission().strength(0.5f).sound(SoundType.WOOD).mapColor(LARCH_PLANKS.get().defaultMapColor()), BlockSetType.OAK));
    public static final RegistrySupplier<Block> LARCH_BUTTON = registerWithItem("larch_button", () -> createWoodenButtonBlock(BlockSetType.OAK, FeatureFlags.VANILLA));
    public static final RegistrySupplier<Block> LARCH_TRAPDOOR = registerWithItem("larch_trapdoor", () -> new TrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_TRAPDOOR), BlockSetType.OAK));
    public static final RegistrySupplier<Block> LARCH_DOOR = registerWithItem("larch_door", () -> new DoorBlock(BlockBehaviour.Properties.of().strength(3.0f).sound(SoundType.WOOD).noOcclusion().mapColor(LARCH_PLANKS.get().defaultMapColor()), BlockSetType.OAK));
    public static final RegistrySupplier<Block> LARCH_FENCE = registerWithItem("larch_fence", () -> new FenceBlock(BlockBehaviour.Properties.of().strength(2.0f, 3.0f).sound(SoundType.WOOD)));
    public static final RegistrySupplier<Block> LARCH_FENCE_GATE = registerWithItem("larch_fence_gate", () -> new FenceGateBlock(BlockBehaviour.Properties.of().strength(2.0f, 3.0f).sound(SoundType.WOOD).mapColor(LARCH_PLANKS.get().defaultMapColor()), WoodType.OAK));
    public static final RegistrySupplier<Block> LARCH_LEAVES = registerWithItem("larch_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.of().strength(0.2f).randomTicks().sound(SoundType.GRASS).noOcclusion().isViewBlocking((state, world, pos) -> false).isSuffocating((state, world, pos) -> false)));
    public static final RegistrySupplier<Block> LARCH_WINDOW = registerWithItem("larch_window", () -> new LarchWindowBlock(BlockBehaviour.Properties.of().strength(0.2f).randomTicks().sound(SoundType.GRASS).noOcclusion().isViewBlocking((state, world, pos) -> false).isSuffocating((state, world, pos) -> false)));
    public static final RegistrySupplier<Block> LARCH_SAPLING = registerWithItem("larch_sapling", () -> new SaplingBlock(new AbstractTreeGrower() {@Override protected @NotNull ResourceKey<ConfiguredFeature<?, ?>> getConfiguredFeature(@NotNull RandomSource random, boolean bees) {return GeneralUtil.configuredFeatureKey("larch");}}, BlockBehaviour.Properties.copy(Blocks.SPRUCE_SAPLING)));

    public static final RegistrySupplier<Block> SWAMP_OAK_LOG = registerWithItem("swamp_oak_log", () -> new RotatedPillarBlock(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(2.0f)));
    public static final RegistrySupplier<Block> SWAMP_OAK_WOOD = registerWithItem("swamp_oak_wood", () -> new RotatedPillarBlock(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(2.0f)));
    public static final RegistrySupplier<Block> STRIPPED_SWAMP_OAK_WOOD = registerWithItem("stripped_swamp_oak_wood", () -> new RotatedPillarBlock(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(2.0f)));
    public static final RegistrySupplier<Block> STRIPPED_SWAMP_OAK_LOG = registerWithItem("stripped_swamp_oak_log", () -> new RotatedPillarBlock(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(2.0f)));
    public static final RegistrySupplier<Block> SWAMP_OAK_PLANKS = registerWithItem("swamp_oak_planks", () -> new Block(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(2.0f, 3.0f).mapColor(MapColor.TERRACOTTA_ORANGE)));
    public static final RegistrySupplier<Block> SWAMP_OAK_STAIRS = registerWithItem("swamp_oak_stairs", () -> new StairBlock(SWAMP_OAK_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.OAK_STAIRS)));
    public static final RegistrySupplier<Block> SWAMP_OAK_SLAB = registerWithItem("swamp_oak_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SLAB)));
    public static final RegistrySupplier<Block> SWAMP_OAK_PRESSURE_PLATE = registerWithItem("swamp_oak_pressure_plate", () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.of().noCollission().strength(0.5f).sound(SoundType.WOOD).mapColor(SWAMP_OAK_PLANKS.get().defaultMapColor()), BlockSetType.OAK));
    public static final RegistrySupplier<Block> SWAMP_OAK_BUTTON = registerWithItem("swamp_oak_button", () -> createWoodenButtonBlock(BlockSetType.OAK, FeatureFlags.VANILLA));
    public static final RegistrySupplier<Block> SWAMP_OAK_TRAPDOOR = registerWithItem("swamp_oak_trapdoor", () -> new TrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_TRAPDOOR), BlockSetType.OAK));
    public static final RegistrySupplier<Block> SWAMP_OAK_DOOR = registerWithItem("swamp_oak_door", () -> new DoorBlock(BlockBehaviour.Properties.of().strength(3.0f).sound(SoundType.WOOD).noOcclusion().mapColor(SWAMP_OAK_PLANKS.get().defaultMapColor()), BlockSetType.OAK));
    public static final RegistrySupplier<Block> SWAMP_OAK_FENCE = registerWithItem("swamp_oak_fence", () -> new FenceBlock(BlockBehaviour.Properties.of().strength(2.0f, 3.0f).sound(SoundType.WOOD)));
    public static final RegistrySupplier<Block> SWAMP_OAK_FENCE_GATE = registerWithItem("swamp_oak_fence_gate", () -> new FenceGateBlock(BlockBehaviour.Properties.of().strength(2.0f, 3.0f).sound(SoundType.WOOD).mapColor(SWAMP_OAK_PLANKS.get().defaultMapColor()), WoodType.OAK));
    public static final RegistrySupplier<Block> SWAMP_OAK_WINDOW = registerWithItem("swamp_oak_window", () -> new SwampOakWindowBlock(BlockBehaviour.Properties.of().strength(0.2f).randomTicks().sound(SoundType.GRASS).noOcclusion().isViewBlocking((state, world, pos) -> false).isSuffocating((state, world, pos) -> false)));
    public static final RegistrySupplier<Block> ORANGE_LEAVES = registerWithItem("orange_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.of().strength(0.2f).randomTicks().sound(SoundType.GRASS).noOcclusion().isViewBlocking((state, world, pos) -> false).isSuffocating((state, world, pos) -> false)));
    public static final RegistrySupplier<Block> SWAMP_OAK_LEAVES = registerWithItem("swamp_oak_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.of().strength(0.2f).randomTicks().sound(SoundType.GRASS).noOcclusion().isViewBlocking((state, world, pos) -> false).isSuffocating((state, world, pos) -> false)));
    public static final RegistrySupplier<Block> SWAMP_OAK_SAPLING = registerWithItem("swamp_oak_sapling", () -> new SaplingBlock(new AbstractTreeGrower() {@Override protected @NotNull ResourceKey<ConfiguredFeature<?, ?>> getConfiguredFeature(@NotNull RandomSource random, boolean bees) {return GeneralUtil.configuredFeatureKey("swamp_oak");}}, BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));

    public static final RegistrySupplier<Block> SNOWY_FIR_LOG = registerWithItem("snowy_fir_log", () -> new RotatedPillarBlock(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(2.0f)));
    public static final RegistrySupplier<Block> SNOWY_FIR_WOOD = registerWithItem("snowy_fir_wood", () -> new RotatedPillarBlock(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(2.0f)));
    public static final RegistrySupplier<Block> STRIPPED_SNOWY_FIR_WOOD = registerWithItem("stripped_snowy_fir_wood", () -> new RotatedPillarBlock(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(2.0f)));
    public static final RegistrySupplier<Block> STRIPPED_SNOWY_FIR_LOG = registerWithItem("stripped_snowy_fir_log", () -> new RotatedPillarBlock(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(2.0f)));
    public static final RegistrySupplier<Block> SNOWY_FIR_PLANKS = registerWithItem("snowy_fir_planks", () -> new Block(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(2.0f, 3.0f).mapColor(MapColor.TERRACOTTA_ORANGE)));
    public static final RegistrySupplier<Block> SNOWY_FIR_STAIRS = registerWithItem("snowy_fir_stairs", () -> new StairBlock(SNOWY_FIR_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.OAK_STAIRS)));
    public static final RegistrySupplier<Block> SNOWY_FIR_SLAB = registerWithItem("snowy_fir_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SLAB)));
    public static final RegistrySupplier<Block> SNOWY_FIR_PRESSURE_PLATE = registerWithItem("snowy_fir_pressure_plate", () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.of().noCollission().strength(0.5f).sound(SoundType.WOOD).mapColor(SNOWY_FIR_PLANKS.get().defaultMapColor()), BlockSetType.OAK));
    public static final RegistrySupplier<Block> SNOWY_FIR_BUTTON = registerWithItem("snowy_fir_button", () -> createWoodenButtonBlock(BlockSetType.OAK, FeatureFlags.VANILLA));
    public static final RegistrySupplier<Block> SNOWY_FIR_TRAPDOOR = registerWithItem("snowy_fir_trapdoor", () -> new TrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_TRAPDOOR), BlockSetType.OAK));
    public static final RegistrySupplier<Block> SNOWY_FIR_DOOR = registerWithItem("snowy_fir_door", () -> new DoorBlock(BlockBehaviour.Properties.of().strength(3.0f).sound(SoundType.WOOD).noOcclusion().mapColor(SNOWY_FIR_PLANKS.get().defaultMapColor()), BlockSetType.OAK));
    public static final RegistrySupplier<Block> SNOWY_FIR_FENCE = registerWithItem("snowy_fir_fence", () -> new FenceBlock(BlockBehaviour.Properties.of().strength(2.0f, 3.0f).sound(SoundType.WOOD)));
    public static final RegistrySupplier<Block> SNOWY_FIR_FENCE_GATE = registerWithItem("snowy_fir_fence_gate", () -> new FenceGateBlock(BlockBehaviour.Properties.of().strength(2.0f, 3.0f).sound(SoundType.WOOD).mapColor(SNOWY_FIR_PLANKS.get().defaultMapColor()), WoodType.OAK));
    public static final RegistrySupplier<Block> SNOWY_FIR_WINDOW = registerWithItem("snowy_fir_window", () -> new SwampOakWindowBlock(BlockBehaviour.Properties.of().strength(0.2f).randomTicks().sound(SoundType.GRASS).noOcclusion().isViewBlocking((state, world, pos) -> false).isSuffocating((state, world, pos) -> false)));
    public static final RegistrySupplier<Block> SNOWY_FIR_LEAVES = registerWithItem("snowy_fir_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.of().strength(0.2f).randomTicks().sound(SoundType.GRASS).noOcclusion().isViewBlocking((state, world, pos) -> false).isSuffocating((state, world, pos) -> false)));
    public static final RegistrySupplier<Block> SNOWY_FIR_SAPLING = registerWithItem("snowy_fir_sapling", () -> new SaplingBlock(new AbstractTreeGrower() {@Override protected @NotNull ResourceKey<ConfiguredFeature<?, ?>> getConfiguredFeature(@NotNull RandomSource random, boolean bees) {return GeneralUtil.configuredFeatureKey("snowy_fir");}}, BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));

    public static final RegistrySupplier<Block> JOE_PYE = registerWithItem("joe_pye", () -> new FlowerBlock(MobEffects.HEAL, 1, BlockBehaviour.Properties.copy(Blocks.DANDELION)));
    public static final RegistrySupplier<Block> HYSSOP = registerWithItem("hyssop", () -> new FlowerBlock(MobEffects.HEAL, 1, BlockBehaviour.Properties.copy(Blocks.DANDELION)));
    public static final RegistrySupplier<Block> MOUNTAIN_SNOWBELL = registerWithItem("mountain_snowbell", () -> new FlowerBlock(MobEffects.HEAL, 1, BlockBehaviour.Properties.copy(Blocks.DANDELION)));
    public static final RegistrySupplier<Block> CARDINAL = registerWithItem("cardinal", () -> new TallFlowerBlock(BlockBehaviour.Properties.copy(Blocks.ROSE_BUSH)));
    public static final RegistrySupplier<Block> MOUNTAIN_LAUREL = registerWithItem("mountain_laurel", () -> new FlowerBlock(MobEffects.HEAL, 1, BlockBehaviour.Properties.copy(Blocks.DANDELION)));
    public static final RegistrySupplier<Block> TALL_MOUNTAIN_LAUREL = registerWithItem("tall_mountain_laurel", () -> new TallFlowerBlock(BlockBehaviour.Properties.copy(Blocks.ROSE_BUSH)));

    public static final RegistrySupplier<Block> BIRD_OF_PARADISE = registerWithItem("bird_of_paradise", () -> new FlowerBlock(MobEffects.HEAL, 1, BlockBehaviour.Properties.copy(Blocks.DANDELION)));
    public static final RegistrySupplier<Block> WHITE_ORCHID = registerWithItem("white_orchid", () -> new FlowerBlock(MobEffects.HEAL, 1, BlockBehaviour.Properties.copy(Blocks.DANDELION)));

    public static final RegistrySupplier<Block> DAPHNE = registerWithItem("daphne", () -> new FlowerBlock(MobEffects.SLOW_FALLING, 1, BlockBehaviour.Properties.copy(Blocks.DANDELION)));
    public static final RegistrySupplier<Block> BOTTLEBRUSHES = registerWithItem("bottlebrushes", () -> new FlowerBlock(MobEffects.NIGHT_VISION, 1, BlockBehaviour.Properties.copy(Blocks.DANDELION)));
    public static final RegistrySupplier<Block> BLUEBELL = registerWithItem("bluebell", () -> new FlowerBlock(MobEffects.NIGHT_VISION, 1, BlockBehaviour.Properties.copy(Blocks.DANDELION)));
    public static final RegistrySupplier<Block> BEGONIE = registerWithItem("begonie", () -> new FlowerBlock(MobEffects.FIRE_RESISTANCE, 1, BlockBehaviour.Properties.copy(Blocks.DANDELION)));
    public static final RegistrySupplier<Block> GOATSBEARD = registerWithItem("goatsbeard", () -> new FlowerBlock(MobEffects.HEAL, 1, BlockBehaviour.Properties.copy(Blocks.DANDELION)));
    public static final RegistrySupplier<Block> GENISTEAE = registerWithItem("genisteae", () -> new FlowerBlock(MobEffects.HEAL, 1, BlockBehaviour.Properties.copy(Blocks.DANDELION)));
    public static final RegistrySupplier<Block> FOXGLOVE_WHITE = registerWithItem("foxglove_white", () -> new FlowerBlock(MobEffects.HEAL, 1, BlockBehaviour.Properties.copy(Blocks.DANDELION)));
    public static final RegistrySupplier<Block> FOXGLOVE_PINK = registerWithItem("foxglove_pink", () -> new FlowerBlock(MobEffects.HEAL, 1, BlockBehaviour.Properties.copy(Blocks.DANDELION)));
    public static final RegistrySupplier<Block> FREESIA_YELLOW = registerWithItem("freesia_yellow", () -> new FlowerBlock(MobEffects.DIG_SPEED, 1, BlockBehaviour.Properties.copy(Blocks.DANDELION)));
    public static final RegistrySupplier<Block> FREESIA_PINK = registerWithItem("freesia_pink", () -> new FlowerBlock(MobEffects.DIG_SPEED, 1, BlockBehaviour.Properties.copy(Blocks.DANDELION)));
    public static final RegistrySupplier<Block> LUPINE_BLUE = registerWithItem("lupine_blue", () -> new FlowerBlock(MobEffects.DIG_SPEED, 1, BlockBehaviour.Properties.copy(Blocks.DANDELION)));
    public static final RegistrySupplier<Block> TALL_LUPINE_BLUE = registerWithItem("tall_lupine_blue", () -> new TallFlowerBlock(BlockBehaviour.Properties.copy(Blocks.ROSE_BUSH)));
    public static final RegistrySupplier<Block> LUPINE_PURPLE = registerWithItem("lupine_purple", () -> new FlowerBlock(MobEffects.DIG_SPEED, 1, BlockBehaviour.Properties.copy(Blocks.DANDELION)));
    public static final RegistrySupplier<Block> TALL_LUPINE_PURPLE = registerWithItem("tall_lupine_purple", () -> new TallFlowerBlock(BlockBehaviour.Properties.copy(Blocks.ROSE_BUSH)));



    public static final RegistrySupplier<Block> FLOWER_POT_BIG = registerWithItem("flower_pot_big", () -> new FlowerPotBigBlock(BlockBehaviour.Properties.copy(Blocks.FLOWER_POT)));
    public static final RegistrySupplier<Block> FLOWER_BOX = registerWithItem("flower_box", () -> new FlowerBoxBlock(BlockBehaviour.Properties.copy(Blocks.FLOWER_POT)));


    public static final RegistrySupplier<Item> WANDERING_GARDENER_SPAWN_EGG = registerItem("wandering_gardener_spawn_egg", () -> new ArchitecturySpawnEggItem(EntityRegistry.WANDERING_GARDENER, -1, -1, getSettings()));



    public static final RegistrySupplier<Block> POTTED_JOE_PYE = registerWithoutItem("potted_joe_pye", () -> new FlowerPotBlock(JOE_PYE.get(), BlockBehaviour.Properties.copy(Blocks.FLOWER_POT)));
    public static final RegistrySupplier<Block> POTTED_HYSSOP = registerWithoutItem("potted_hyssop", () -> new FlowerPotBlock(HYSSOP.get(), BlockBehaviour.Properties.copy(Blocks.FLOWER_POT)));
    public static final RegistrySupplier<Block> POTTED_MOUNTAIN_SNOWBELL = registerWithoutItem("potted_mountain_snowbell", () -> new FlowerPotBlock(MOUNTAIN_SNOWBELL.get(), BlockBehaviour.Properties.copy(Blocks.FLOWER_POT)));
    public static final RegistrySupplier<Block> POTTED_MOUNTAIN_LAUREL = registerWithoutItem("potted_mountain_laurel", () -> new FlowerPotBlock(MOUNTAIN_LAUREL.get(), BlockBehaviour.Properties.copy(Blocks.FLOWER_POT)));
    public static final RegistrySupplier<Block> POTTED_WHITE_ORCHID = registerWithoutItem("potted_white_orchid", () -> new FlowerPotBlock(WHITE_ORCHID.get(), BlockBehaviour.Properties.copy(Blocks.FLOWER_POT)));
    public static final RegistrySupplier<Block> POTTED_BIRD_OF_PARADISE = registerWithoutItem("potted_bird_of_paradise", () -> new FlowerPotBlock(BIRD_OF_PARADISE.get(), BlockBehaviour.Properties.copy(Blocks.FLOWER_POT)));
    public static final RegistrySupplier<Block> POTTED_LARCH_SAPLING = registerWithoutItem("potted_larch_sapling", () -> new FlowerPotBlock(LARCH_SAPLING.get(), BlockBehaviour.Properties.copy(Blocks.FLOWER_POT)));
    public static final RegistrySupplier<Block> POTTED_DAPHNE = registerWithoutItem("potted_daphne", () -> new FlowerPotBlock(DAPHNE.get(), BlockBehaviour.Properties.copy(Blocks.FLOWER_POT)));
    public static final RegistrySupplier<Block> POTTED_BOTTLEBRUSHES = registerWithoutItem("potted_bottlebrushes", () -> new FlowerPotBlock(BOTTLEBRUSHES.get(), BlockBehaviour.Properties.copy(Blocks.FLOWER_POT)));
    public static final RegistrySupplier<Block> POTTED_BLUEBELL = registerWithoutItem("potted_bluebell", () -> new FlowerPotBlock(BLUEBELL.get(), BlockBehaviour.Properties.copy(Blocks.FLOWER_POT)));
    public static final RegistrySupplier<Block> POTTED_BEGONIE = registerWithoutItem("potted_begonie", () -> new FlowerPotBlock(BEGONIE.get(), BlockBehaviour.Properties.copy(Blocks.FLOWER_POT)));
    public static final RegistrySupplier<Block> POTTED_GOATSBEARD = registerWithoutItem("potted_goatsbeard", () -> new FlowerPotBlock(GOATSBEARD.get(), BlockBehaviour.Properties.copy(Blocks.FLOWER_POT)));
    public static final RegistrySupplier<Block> POTTED_GENISTEAE = registerWithoutItem("potted_genisteae", () -> new FlowerPotBlock(GENISTEAE.get(), BlockBehaviour.Properties.copy(Blocks.FLOWER_POT)));
    public static final RegistrySupplier<Block> POTTED_FOXGLOVE_WHITE = registerWithoutItem("potted_foxglove_white", () -> new FlowerPotBlock(FOXGLOVE_WHITE.get(), BlockBehaviour.Properties.copy(Blocks.FLOWER_POT)));
    public static final RegistrySupplier<Block> POTTED_FOXGLOVE_PINK = registerWithoutItem("potted_foxglove_pink", () -> new FlowerPotBlock(FOXGLOVE_PINK.get(), BlockBehaviour.Properties.copy(Blocks.FLOWER_POT)));
    public static final RegistrySupplier<Block> POTTED_FREESIA_YELLOW = registerWithoutItem("potted_freesia_yellow", () -> new FlowerPotBlock(FREESIA_YELLOW.get(), BlockBehaviour.Properties.copy(Blocks.FLOWER_POT)));
    public static final RegistrySupplier<Block> POTTED_FREESIA_PINK = registerWithoutItem("potted_freesia_pink", () -> new FlowerPotBlock(FREESIA_PINK.get(), BlockBehaviour.Properties.copy(Blocks.FLOWER_POT)));
    public static final RegistrySupplier<Block> POTTED_LUPINE_BLUE = registerWithoutItem("potted_lupine_blue", () -> new FlowerPotBlock(LUPINE_BLUE.get(), BlockBehaviour.Properties.copy(Blocks.FLOWER_POT)));
    public static final RegistrySupplier<Block> POTTED_LUPINE_PURPLE = registerWithoutItem("potted_lupine_purple", () -> new FlowerPotBlock(LUPINE_PURPLE.get(), BlockBehaviour.Properties.copy(Blocks.FLOWER_POT)));


    public static void init() {
        ITEMS.register();
        BLOCKS.register();
    }

    public static void registerCompostable() {
        ComposterBlock.COMPOSTABLES.put(ObjectRegistry.JOE_PYE.get(), 0.3f);
        ComposterBlock.COMPOSTABLES.put(ObjectRegistry.MOUNTAIN_LAUREL.get(), 0.3f);
        ComposterBlock.COMPOSTABLES.put(ObjectRegistry.HYSSOP.get(), 0.3f);
        ComposterBlock.COMPOSTABLES.put(ObjectRegistry.CARDINAL.get(), 0.3f);
        ComposterBlock.COMPOSTABLES.put(ObjectRegistry.WHITE_ORCHID.get(), 0.3f);
        ComposterBlock.COMPOSTABLES.put(ObjectRegistry.MOUNTAIN_SNOWBELL.get(), 0.3f);
        ComposterBlock.COMPOSTABLES.put(ObjectRegistry.BIRD_OF_PARADISE.get(), 0.3f);
    }

    private static Item.Properties getSettings(Consumer<Item.Properties> consumer) {
        Item.Properties settings = new Item.Properties();
        consumer.accept(settings);
        return settings;
    }

    private static Item.Properties getSettingsWithoutTab(Consumer<Item.Properties> consumer) {
        Item.Properties settings = new Item.Properties();
        consumer.accept(settings);
        return settings;
    }

    static Item.Properties getSettings() {
        return getSettings(settings -> {
        });
    }

    private static Item.Properties getSettingsWithoutTab() {
        return getSettingsWithoutTab(settings -> {
        });
    }

    public static <T extends Block> RegistrySupplier<T> registerWithItem(String name, Supplier<T> block) {
        return Util.registerWithItem(BLOCKS, BLOCK_REGISTRAR, ITEMS, ITEM_REGISTRAR, new HerbalBrewsIdentifier(name), block);
    }


    public static <T extends Block> RegistrySupplier<T> registerWithoutItem(String path, Supplier<T> block) {
        return Util.registerWithoutItem(BLOCKS, BLOCK_REGISTRAR, new HerbalBrewsIdentifier(path), block);
    }

    public static <T extends Item> RegistrySupplier<T> registerItem(String path, Supplier<T> itemSupplier) {
        return Util.registerItem(ITEMS, ITEM_REGISTRAR, new HerbalBrewsIdentifier(path), itemSupplier);
    }


    private static ButtonBlock createWoodenButtonBlock(BlockSetType blockSetType, FeatureFlag... requiredFeatures) {
        BlockBehaviour.Properties settings = BlockBehaviour.Properties.of().noCollission().strength(0.5F).pushReaction(PushReaction.DESTROY);
        if (requiredFeatures.length > 0) {
            settings = settings.requiredFeatures(requiredFeatures);
        }

        return new ButtonBlock(settings, blockSetType, 30, true);
    }
}

