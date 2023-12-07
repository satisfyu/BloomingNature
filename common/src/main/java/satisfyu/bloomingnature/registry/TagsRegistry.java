package satisfyu.bloomingnature.registry;

import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import satisfyu.bloomingnature.util.BloomingNatureIdentifier;

public class TagsRegistry {

    public static final TagKey<Block> ALLOWS_COOKING = TagKey.create(Registries.BLOCK, new BloomingNatureIdentifier("allows_cooking"));
    public static final TagKey<Item> SHOVEL = TagKey.create(Registries.ITEM, new BloomingNatureIdentifier("shovel"));
    public static final TagKey<Item> BIG_FLOWER = TagKey.create(Registries.ITEM, new BloomingNatureIdentifier("big_flower"));
    public static final TagKey<Item> SMALL_FLOWER = TagKey.create(Registries.ITEM, new BloomingNatureIdentifier("small_flower"));

}
