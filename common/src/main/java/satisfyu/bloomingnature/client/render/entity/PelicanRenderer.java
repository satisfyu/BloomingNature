package satisfyu.bloomingnature.client.render.entity;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import satisfyu.bloomingnature.BloomingNature;
import satisfyu.bloomingnature.client.model.PelicanModel;
import satisfyu.bloomingnature.entity.PelicanEntity;

public class PelicanRenderer extends MobRenderer<PelicanEntity, PelicanModel<PelicanEntity>> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(BloomingNature.MOD_ID, "textures/entity/pelican.png");

    public PelicanRenderer(EntityRendererProvider.Context context) {
        super(context, new PelicanModel<>(context.bakeLayer(PelicanModel.LAYER_LOCATION)), 0.7f);
    }

    protected float getBob(PelicanEntity pelican, float f) {
        float g = Mth.lerp(f, pelican.oFlap, pelican.flap);
        float h = Mth.lerp(f, pelican.oFlapSpeed, pelican.flapSpeed);
        return (Mth.sin(g) + 1.0F) * h;
    }

    @Override
    public ResourceLocation getTextureLocation(PelicanEntity entity) {
        return TEXTURE;
    }
}
