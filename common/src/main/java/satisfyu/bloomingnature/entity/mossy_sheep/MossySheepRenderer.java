package satisfyu.bloomingnature.entity.mossy_sheep;

import net.minecraft.client.model.SheepModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import satisfyu.bloomingnature.BloomingNature;
import satisfyu.bloomingnature.client.BloomingNatureClient;

public class MossySheepRenderer extends MobRenderer<SheepEntity, SheepModel<SheepEntity>> {

    private static final ResourceLocation TEXTURE = new ResourceLocation(BloomingNature.MOD_ID, "textures/entity/mossy_sheep.png");

    public MossySheepRenderer(EntityRendererProvider.Context context) {
        super(context, new SheepModel<>(context.bakeLayer(BloomingNatureClient.MOSSY_SHEEP_MODEL_LAYER)), 0.7f);
        this.addLayer(new MossySheepWoolFeature<>(this, context.getModelSet(), "mossy", BloomingNatureClient.MOSSY_SHEEP_FUR));
    }

    @Override
    public ResourceLocation getTextureLocation(SheepEntity entity) {
        return TEXTURE;
    }
}