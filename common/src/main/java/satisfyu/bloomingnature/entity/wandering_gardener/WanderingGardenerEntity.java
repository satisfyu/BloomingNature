package satisfyu.bloomingnature.entity.wandering_gardener;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.entity.npc.WanderingTrader;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.trading.MerchantOffers;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import satisfyu.bloomingnature.registry.ObjectRegistry;
import satisfyu.bloomingnature.util.VillagerUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class WanderingGardenerEntity extends WanderingTrader {
    public static final HashMap<Integer, VillagerTrades.ItemListing[]> TRADES = createTrades();

    private static HashMap<Integer, VillagerTrades.ItemListing[]> createTrades() {
        HashMap<Integer, VillagerTrades.ItemListing[]> trades = new HashMap<>();
        trades.put(1, new VillagerTrades.ItemListing[]{
                new VillagerUtil.SellItemFactory(ObjectRegistry.JOE_PYE.get(), 2, 4, 3, 15),
                new VillagerUtil.SellItemFactory(ObjectRegistry.CATTAIL.get(), 2, 4, 3, 15),
                new VillagerUtil.SellItemFactory(ObjectRegistry.REED.get(), 2, 4, 3, 15),
                new VillagerUtil.SellItemFactory(ObjectRegistry.HYSSOP.get(), 2, 4, 3, 15),
                new VillagerUtil.SellItemFactory(ObjectRegistry.MOUNTAIN_SNOWBELL.get(), 2, 4, 3, 15),
                new VillagerUtil.SellItemFactory(ObjectRegistry.CARDINAL.get(), 2, 4, 3, 15),
                new VillagerUtil.SellItemFactory(ObjectRegistry.MOUNTAIN_LAUREL.get(), 2, 4, 3, 15),
                new VillagerUtil.SellItemFactory(ObjectRegistry.BIRD_OF_PARADISE.get(), 2, 4, 3, 15),
                new VillagerUtil.SellItemFactory(ObjectRegistry.WHITE_ORCHID.get(), 2, 4, 3, 15),
                new VillagerUtil.SellItemFactory(ObjectRegistry.DAPHNE.get(), 2, 4, 3, 15),
                new VillagerUtil.SellItemFactory(ObjectRegistry.BOTTLEBRUSHES.get(), 2, 4, 3, 15),
                new VillagerUtil.SellItemFactory(ObjectRegistry.BLUEBELL.get(), 2, 4, 3, 15),
                new VillagerUtil.SellItemFactory(ObjectRegistry.BEGONIE.get(), 2, 4, 3, 15),
                new VillagerUtil.SellItemFactory(ObjectRegistry.GOATSBEARD.get(), 2, 4, 3, 15),
                new VillagerUtil.SellItemFactory(ObjectRegistry.GENISTEAE.get(), 2, 4, 3, 15),
                new VillagerUtil.SellItemFactory(ObjectRegistry.FOXGLOVE_WHITE.get(), 2, 4, 3, 15),
                new VillagerUtil.SellItemFactory(ObjectRegistry.FOXGLOVE_PINK.get(), 2, 4, 3, 15),
                new VillagerUtil.SellItemFactory(ObjectRegistry.FREESIA_YELLOW.get(), 2, 4, 3, 15),
                new VillagerUtil.SellItemFactory(ObjectRegistry.FREESIA_PINK.get(), 2, 4, 3, 15),
                new VillagerUtil.SellItemFactory(ObjectRegistry.LUPINE_BLUE.get(), 2, 4, 3, 15),
                new VillagerUtil.SellItemFactory(ObjectRegistry.LUPINE_PURPLE.get(), 2, 4, 3, 15),
                new VillagerUtil.SellItemFactory(ObjectRegistry.BEACH_BUSH.get(), 2, 4, 3, 15),
                new VillagerUtil.SellItemFactory(ObjectRegistry.BEACH_GRASS.get(), 2, 4, 3, 15),
                new VillagerUtil.SellItemFactory(ObjectRegistry.BEACH_BUSH_TALL.get(), 2, 4, 3, 15)



        });
        return trades;
    }

    public WanderingGardenerEntity(EntityType<? extends WanderingGardenerEntity> entityType, Level world) {
        super(entityType, world);
    }

    @Override
    protected void updateTrades() {
        if (this.offers == null) {
            this.offers = new MerchantOffers();
        }
        this.addOffersFromItemListings(this.offers, TRADES.get(1), 8);
    }
}