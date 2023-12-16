package satisfyu.bloomingnature.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.FallingBlockEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.EntityCollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.HashMap;
import java.util.Map;


public class SinkInSandBlock extends SinkInBlock {
    public SinkInSandBlock(Properties properties) {
        super(properties);
    }

    @Override
    public void entityInside(BlockState blockState, Level level, BlockPos blockPos, Entity entity) {
        if (!(entity instanceof LivingEntity) || entity.getFeetBlockState().is(this)) {
            entity.makeStuckInBlock(blockState, new Vec3(0.8999999761581421, 1.5, 0.8999999761581421));
            if (level.isClientSide) {
                RandomSource randomSource = level.getRandom();
                boolean bl = entity.xOld != entity.getX() || entity.zOld != entity.getZ();
                if (bl && randomSource.nextBoolean()) {
                    level.addParticle(ParticleTypes.CRIT, entity.getX(), (double) (blockPos.getY() + 1), entity.getZ(), (double) (Mth.randomBetween(randomSource, -1.0F, 1.0F) * 0.083333336F), 0.05000000074505806, (double) (Mth.randomBetween(randomSource, -1.0F, 1.0F) * 0.083333336F));
                }
            }
        }
        if (entity instanceof LivingEntity) {
            entity.hurt(level.damageSources().inWall(), 1.f);
        }

        if (!level.isClientSide) {
            if (entity.isOnFire() && (level.getGameRules().getBoolean(GameRules.RULE_MOBGRIEFING) || entity instanceof Player) && entity.mayInteract(level, blockPos)) {
                level.destroyBlock(blockPos, false);
            }

            entity.setSharedFlagOnFire(false);
        }
    }
}