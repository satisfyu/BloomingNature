package satisfyu.bloomingnature.entities.raccoon;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.animal.Fox;
import net.minecraft.world.entity.animal.Wolf;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;
import satisfyu.bloomingnature.entities.pelican.PelicanEntity;
import satisfyu.bloomingnature.registry.EntityRegistry;
import satisfyu.bloomingnature.registry.TagsRegistry;

public class RaccoonEntity extends Fox {
    public RaccoonEntity(EntityType<? extends Fox> entityType, Level world) {
        super(entityType, world);
    }

    private static final Ingredient FOOD_ITEMS;


    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes().add(Attributes.MOVEMENT_SPEED, 0.20000001192092896).add(Attributes.MAX_HEALTH, 10.0).add(Attributes.ATTACK_DAMAGE, 1.5);
    }

    @Override
    protected float getStandingEyeHeight(Pose pose, EntityDimensions entityDimensions) {
        return this.isBaby() ? entityDimensions.height * 0.4F : entityDimensions.height * 0.5F;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.CHICKEN_AMBIENT;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource damageSource) {
        return SoundEvents.CHICKEN_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.CHICKEN_DEATH;
    }



    @Nullable
    public RaccoonEntity getBreedOffspring(ServerLevel serverLevel, AgeableMob ageableMob) {
        return EntityRegistry.RACCOON.get().create(serverLevel);
    }

    @Override
    public boolean isFood(ItemStack itemStack) {
        return FOOD_ITEMS.test(itemStack);
    }

    static {
        FOOD_ITEMS = Ingredient.of(Items.APPLE, Items.BEETROOT, Items.SWEET_BERRIES, Items.POTATO, Items.COOKED_COD, Items.COOKED_SALMON, Items.CARROT);
    }
}