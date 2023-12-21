package satisfyu.bloomingnature.entity.bison;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import satisfyu.bloomingnature.BloomingNature;
import satisfyu.bloomingnature.entity.deer.DeerEntity;
import satisfyu.bloomingnature.entity.deer.DeerModel;


public class BisonRenderer extends MobRenderer<BisonEntity, BisonModel<BisonEntity>> {

    private static final ResourceLocation TEXTURE = new ResourceLocation(BloomingNature.MOD_ID, "textures/entity/bison.png");

    public BisonRenderer(EntityRendererProvider.Context context) {
        super(context, new BisonModel(context.bakeLayer(BisonModel.LAYER_LOCATION)), 0.9f);
    }

    @Override
    public ResourceLocation getTextureLocation(BisonEntity entity) {
        return TEXTURE;
    }


}
