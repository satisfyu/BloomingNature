package satisfyu.bloomingnature.entity.muddy_pig;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import satisfyu.bloomingnature.util.BloomingNatureIdentifier;


@Environment(value = EnvType.CLIENT)
public class MuddyPigRenderer extends MobRenderer<MuddyPigEntity, MuddyPigModel<MuddyPigEntity>> {
    private static final ResourceLocation TEXTURE = new BloomingNatureIdentifier("textures/entity/muddy_pig.png");

    public MuddyPigRenderer(EntityRendererProvider.Context context) {
        super(context, new MuddyPigModel(context.bakeLayer(MuddyPigModel.LAYER_LOCATION)), 0.7f);
    }



    @Override
    public ResourceLocation getTextureLocation(MuddyPigEntity entity) {
        return TEXTURE;
    }
}
