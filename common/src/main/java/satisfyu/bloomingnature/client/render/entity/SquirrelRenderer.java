package satisfyu.bloomingnature.client.render.entity;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import satisfyu.bloomingnature.BloomingNature;
import satisfyu.bloomingnature.client.model.SquirrelModel;
import satisfyu.bloomingnature.entity.SquirrelEntity;


@Environment(EnvType.CLIENT)
public class SquirrelRenderer extends MobRenderer<SquirrelEntity, SquirrelModel> {

    public SquirrelRenderer(EntityRendererProvider.Context context) {
        super(context, new SquirrelModel(context.bakeLayer(SquirrelModel.LAYER_LOCATION)), 0.4F);
    }

    @Override
    public ResourceLocation getTextureLocation(SquirrelEntity entity) {
        return new ResourceLocation(BloomingNature.MOD_ID, "textures/entity/squirrel.png");
    }
}