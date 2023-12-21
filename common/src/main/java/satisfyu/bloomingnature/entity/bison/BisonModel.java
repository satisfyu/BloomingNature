package satisfyu.bloomingnature.entity.bison;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.QuadrupedModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import satisfyu.bloomingnature.util.BloomingNatureIdentifier;

public class BisonModel<T extends Entity> extends HierarchicalModel<T> {
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new BloomingNatureIdentifier("bison"), "main");
    private final ModelPart rightHindLeg;
    private final ModelPart leftHindLeg;
    private final ModelPart leftFrontLeg;
    private final ModelPart rightFrontLeg;
    private final ModelPart body;
    private final ModelPart head;
    private final ModelPart bison;


    public BisonModel(ModelPart root) {
        this.bison = root.getChild("bison");
        this.rightHindLeg = bison.getChild("rightHindLeg");
        this.leftHindLeg = bison.getChild("leftHindLeg");
        this.leftFrontLeg = bison.getChild("leftFrontLeg");
        this.rightFrontLeg = bison.getChild("rightFrontLeg");
        this.body = bison.getChild("body");
        this.head = bison.getChild("head");
    }

    public static LayerDefinition getTexturedModelData() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition bison = partdefinition.addOrReplaceChild("bison", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition rightHindLeg = bison.addOrReplaceChild("rightHindLeg", CubeListBuilder.create().texOffs(1, 69).addBox(3.5F, -12.0F, 9.0F, 5.0F, 11.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.0F, 1.0F, 0.0F));

        PartDefinition leftHindLeg = bison.addOrReplaceChild("leftHindLeg", CubeListBuilder.create().texOffs(1, 69).addBox(-6.5F, -11.0F, 9.0F, 5.0F, 11.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition leftFrontLeg = bison.addOrReplaceChild("leftFrontLeg", CubeListBuilder.create().texOffs(1, 69).addBox(-7.5F, -11.0F, -14.0F, 5.0F, 11.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition rightFrontLeg = bison.addOrReplaceChild("rightFrontLeg", CubeListBuilder.create().texOffs(1, 69).addBox(2.5F, -11.0F, -14.0F, 5.0F, 11.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition body = bison.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 35).addBox(-7.5F, -28.0F, -1.0F, 15.0F, 17.0F, 16.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-8.5F, -29.0F, -17.0F, 17.0F, 19.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition head = bison.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(2.5F, -5.5968F, -0.4185F, 2.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(0, 0).addBox(-4.5F, -5.5968F, -0.4185F, 2.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -21.4032F, -20.5815F));

        PartDefinition hair_r1 = head.addOrReplaceChild("hair_r1", CubeListBuilder.create().texOffs(54, 60).addBox(-3.5F, 2.0F, -18.6005F, 7.0F, 9.0F, 8.0F, new CubeDeformation(0.5F)), PartPose.offsetAndRotation(0.0F, 6.9032F, 16.682F, -0.7854F, 0.0F, 0.0F));

        PartDefinition head_r1 = head.addOrReplaceChild("head_r1", CubeListBuilder.create().texOffs(51, 20).addBox(-3.5F, -18.9896F, -16.4957F, 7.0F, 9.0F, 15.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 6.9032F, 16.682F, 0.7854F, 0.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 128, 128);
    }

    @Override
    public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.root().getAllParts().forEach(ModelPart::resetPose);

        this.head.yRot = netHeadYaw * 0.0089453292F;
        this.head.xRot = headPitch * 0.0047453292F;

        this.rightHindLeg.xRot = Mth.cos(limbSwing * 0.6662F) * 0.5F * limbSwingAmount;
        this.leftHindLeg.xRot = Mth.cos(limbSwing * 0.6662F + 3.1415927F) * 0.5F * limbSwingAmount;
        this.rightFrontLeg.xRot = Mth.cos(limbSwing * 0.6662F + 3.1415927F) * 0.5F * limbSwingAmount;
        this.leftFrontLeg.xRot = Mth.cos(limbSwing * 0.6662F) * 0.5F * limbSwingAmount;
    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        bison.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
    }

    @Override
    public ModelPart root() {
        return bison;
    }
}