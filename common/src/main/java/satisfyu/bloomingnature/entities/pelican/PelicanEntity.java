package satisfyu.bloomingnature.entities.pelican;

import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.Chicken;
import net.minecraft.world.entity.animal.Cod;
import net.minecraft.world.entity.animal.Salmon;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.pathfinder.BlockPathTypes;
import org.jetbrains.annotations.Nullable;
import satisfyu.bloomingnature.registry.EntityRegistry;


public class PelicanEntity extends Chicken {
    private static final Ingredient FOOD_ITEMS;
    private static final EntityDataAccessor<Byte> DATA_FLAGS_ID = SynchedEntityData.defineId(PelicanEntity.class, EntityDataSerializers.BYTE);
    private static final EntityDataAccessor<Boolean> DATA_TRUSTING = SynchedEntityData.defineId(PelicanEntity.class, EntityDataSerializers.BOOLEAN);
    private static final Ingredient TEMPT_INGREDIENT = Ingredient.of(ItemTags.FISHES);

    public PelicanEntity(EntityType<? extends PelicanEntity> entityType, Level level) {
        super(entityType, level);
        this.setPathfindingMalus(BlockPathTypes.WATER, 0.0F);
    }

    public static AttributeSupplier.Builder registerAttributes() {
        return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 8.0)
                .add(Attributes.MOVEMENT_SPEED, 0.2);
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(DATA_FLAGS_ID, (byte)0);
        this.entityData.define(DATA_TRUSTING, false);
    }

    @Override
    public void addAdditionalSaveData(CompoundTag pCompound) {
        super.addAdditionalSaveData(pCompound);
        pCompound.putBoolean("Trusting", this.isTrusting());
    }

    @Override
    public void readAdditionalSaveData(CompoundTag pCompound) {
        super.readAdditionalSaveData(pCompound);
        this.setTrusting(pCompound.getBoolean("Trusting"));
    }

    boolean isTrusting() {
        return this.entityData.get(DATA_TRUSTING);
    }

    private void setTrusting(boolean pTrusting) {
        this.entityData.set(DATA_TRUSTING, pTrusting);
    }

    @Override
    public InteractionResult mobInteract(Player pPlayer, InteractionHand pHand) {
        ItemStack itemstack = pPlayer.getItemInHand(pHand);
        if (!this.isTrusting() && TEMPT_INGREDIENT.test(itemstack)) {
            this.usePlayerItem(pPlayer, pHand, itemstack);
            if (!this.level().isClientSide()) {
                if (this.random.nextInt(3) == 0) {
                    this.setTrusting(true);
                    this.spawnTrustingParticles(true);
                    this.level().broadcastEntityEvent(this, (byte)41);
                } else {
                    this.spawnTrustingParticles(false);
                    this.level().broadcastEntityEvent(this, (byte)40);
                }
            }
            return InteractionResult.sidedSuccess(this.level().isClientSide());
        } else {
            return super.mobInteract(pPlayer, pHand);
        }
    }

    private void spawnTrustingParticles(boolean isTrusting) {
        ParticleOptions particleoptions = ParticleTypes.HEART;
        if (!isTrusting) {
            particleoptions = ParticleTypes.SMOKE;
        }

        for(int i = 0; i < 7; ++i) {
            double x = this.random.nextGaussian() * 0.02D;
            double y = this.random.nextGaussian() * 0.02D;
            double z = this.random.nextGaussian() * 0.02D;
            this.level().addParticle(particleoptions, this.getRandomX(1.0D), this.getRandomY() + 0.5D, this.getRandomZ(1.0D), x, y, z);
        }
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(1, new PanicGoal(this, 1.4));
        this.goalSelector.addGoal(2, new BreedGoal(this, 1.0));
        this.goalSelector.addGoal(3, new TemptGoal(this, 1.0, FOOD_ITEMS, false));
        this.goalSelector.addGoal(4, new FollowParentGoal(this, 1.1));
        this.goalSelector.addGoal(5, new WaterAvoidingRandomStrollGoal(this, 1.0));
        this.goalSelector.addGoal(6, new LookAtPlayerGoal(this, Player.class, 6.0F));
        this.goalSelector.addGoal(7, new RandomLookAroundGoal(this));
        this.goalSelector.addGoal(1, new OcelotAttackGoal(this));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, Animal.class, true, livingEntity -> {
            if (livingEntity instanceof PelicanEntity) {
                return false;
            } else if (livingEntity instanceof Salmon) {
                return true;
            } else {
                return livingEntity instanceof Cod;
            }
        }));
    }

    @Override
    public boolean canHoldItem(ItemStack pStack) {
        ItemStack itemstack = this.getItemBySlot(EquipmentSlot.MAINHAND);
        return itemstack.isEmpty() && pStack.is(ItemTags.FISHES) && !this.isBaby() && this.isTrusting();
    }

    @Override
    protected void pickUpItem(ItemEntity pItemEntity) {
        ItemStack itemstack = pItemEntity.getItem();
        if (this.canHoldItem(itemstack)) {
            int count = itemstack.getCount();
            if (count > 1) {
                this.dropItemStack(itemstack.split(count - 1));
            }

            this.onItemPickup(pItemEntity);
            this.setItemSlot(EquipmentSlot.MAINHAND, itemstack.split(1));
            this.handDropChances[EquipmentSlot.MAINHAND.getIndex()] = 2.0F;
            this.take(pItemEntity, itemstack.getCount());
            pItemEntity.discard();
        }
    }

    private void dropItemStack(ItemStack pStack) {
        ItemEntity itementity = new ItemEntity(this.level(), this.getX(), this.getY(), this.getZ(), pStack);
        this.level().addFreshEntity(itementity);
    }

    @Override
    public boolean canBeLeashed(Player pPlayer) {
        return this.isTrusting();
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
    @Override
    public PelicanEntity getBreedOffspring(ServerLevel serverLevel, AgeableMob ageableMob) {
        return EntityRegistry.PELICAN.get().create(serverLevel);
    }

    @Override
    public boolean isFood(ItemStack itemStack) {
        return FOOD_ITEMS.test(itemStack);
    }

    static {
        FOOD_ITEMS = Ingredient.of(Items.COD, Items.SALMON, Items.PUFFERFISH, Items.COOKED_COD, Items.COOKED_SALMON);
    }
}