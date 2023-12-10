package satisfyu.bloomingnature.entities.red_wolf;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import satisfyu.bloomingnature.entities.red_wolf.RedWolfModel;
import satisfyu.bloomingnature.entities.red_wolf.RedWolfEntity;
import satisfyu.bloomingnature.util.BloomingNatureIdentifier;


@Environment(value = EnvType.CLIENT)
public class RedWolfRenderer extends MobRenderer<RedWolfEntity, RedWolfModel<RedWolfEntity>> {
    private static final ResourceLocation TEXTURE = new BloomingNatureIdentifier("textures/entity/red_wolf.png");

    public RedWolfRenderer(EntityRendererProvider.Context context) {
        super(context, new RedWolfModel(context.bakeLayer(RedWolfModel.LAYER_LOCATION)), 0.7f);
    }



    @Override
    public ResourceLocation getTextureLocation(RedWolfEntity entity) {
        return TEXTURE;
    }
}
