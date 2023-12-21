package satisfyu.bloomingnature.entity.bison;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.animal.Cow;
import net.minecraft.world.level.Level;
import satisfyu.bloomingnature.registry.EntityRegistry;
import satisfyu.bloomingnature.registry.SoundRegistry;


public class BisonEntity extends Cow {
    public BisonEntity(EntityType<? extends Cow> entityType, Level world) {
        super(entityType, world);
    }

    @Override
    public Cow getBreedOffspring(ServerLevel serverWorld, AgeableMob passiveEntity) {
        return EntityRegistry.BISON.get().create(serverWorld);
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundRegistry.BISON_AMBIENT.get();
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource damageSource) {
        return SoundRegistry.BISON_HURT.get();
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundRegistry.BISON_DEATH.get();
    }

    public static AttributeSupplier.Builder createMobAttributes() {
        return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 14.0).add(Attributes.MOVEMENT_SPEED, 0.1800009838F);
    }

    @Override
    public int getMaxHeadYRot() {
        return 35;
    }
}