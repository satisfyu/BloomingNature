package satisfyu.bloomingnature.entities.deer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import satisfyu.bloomingnature.BloomingNature;

public class DeerModel<T extends Entity> extends HierarchicalModel<T> {
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(BloomingNature.MOD_ID, "deer"), "main");
    private final ModelPart deer;
    private final ModelPart head;

    public DeerModel(ModelPart root) {
        this.deer = root.getChild("deer");
        this.head = deer.getChild("body").getChild("head");
    }

    public static LayerDefinition getTexturedModelData() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition deer = partdefinition.addOrReplaceChild("deer", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition body = deer.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-2.0F, -21.0F, 7.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-5.0F, -19.0F, -9.0F, 10.0F, 9.0F, 18.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition head = body.addOrReplaceChild("head", CubeListBuilder.create().texOffs(18, 27).addBox(-3.0F, -27.0F, -14.0F, 6.0F, 5.0F, 7.0F, new CubeDeformation(0.0F))
                .texOffs(0, 9).addBox(-2.0F, -25.0F, -17.0F, 4.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(0, 27).addBox(-2.0F, -22.0F, -12.0F, 4.0F, 11.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition horn_right_r1 = head.addOrReplaceChild("horn_right_r1", CubeListBuilder.create().texOffs(19, 28).addBox(-3.09F, -37.0F, -14.0F, 0.0F, 10.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.2182F));

        PartDefinition horn_left_r1 = head.addOrReplaceChild("horn_left_r1", CubeListBuilder.create().texOffs(19, 28).addBox(2.93F, -37.0F, -14.0F, 0.0F, 10.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.2182F));

        PartDefinition left_ear_r1 = head.addOrReplaceChild("left_ear_r1", CubeListBuilder.create().texOffs(38, 0).mirror().addBox(-7.0F, -26.0F, -9.0F, 3.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0436F));

        PartDefinition right_ear_r1 = head.addOrReplaceChild("right_ear_r1", CubeListBuilder.create().texOffs(38, 0).addBox(4.0F, -26.0F, -9.0F, 3.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.0436F));

        PartDefinition leftHindLeg = deer.addOrReplaceChild("leftHindLeg", CubeListBuilder.create().texOffs(38, 5).addBox(-5.0F, -10.0F, 6.0F, 3.0F, 10.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition rightHindLeg = deer.addOrReplaceChild("rightHindLeg", CubeListBuilder.create().texOffs(38, 5).mirror().addBox(2.0F, -10.0F, 6.0F, 3.0F, 10.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition rightFrontLeg = deer.addOrReplaceChild("rightFrontLeg", CubeListBuilder.create().texOffs(38, 5).mirror().addBox(2.0F, -10.0F, -9.0F, 3.0F, 10.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition leftFrontLeg = deer.addOrReplaceChild("leftFrontLeg", CubeListBuilder.create().texOffs(38, 5).addBox(-5.0F, -10.0F, -9.0F, 3.0F, 10.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 64, 64);
    }

    @Override
    public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        // Reset the pose to default
        this.root().getAllParts().forEach(ModelPart::resetPose);

        // Adjust the body's rotation based on the limb swing
        this.deer.yRot = netHeadYaw * 0.017453292F; // Convert degrees to radians

        // Adjust the legs for walking animation
        float walkSpeed = 1.0F;
        float walkDegree = 1.0F;

        // Left front leg
        this.deer.getChild("leftFrontLeg").zRot = (float) Math.cos(limbSwing * walkSpeed) * walkDegree * limbSwingAmount;

        // Right front leg
        this.deer.getChild("rightFrontLeg").zRot = (float) Math.cos(limbSwing * walkSpeed + Math.PI) * walkDegree * limbSwingAmount;

        // Left hind leg
        this.deer.getChild("leftHindLeg").zRot = (float) Math.cos(limbSwing * walkSpeed + Math.PI) * walkDegree * limbSwingAmount;

        // Right hind leg
        this.deer.getChild("rightHindLeg").zRot = (float) Math.cos(limbSwing * walkSpeed) * walkDegree * limbSwingAmount;

        // Additionally, you might need to adjust the angles to match your model's orientation
        // You can experiment with changing the x, y, and z rotations for each leg
        // Example: this.deer.getChild("leftFrontLeg").xRot = someValue;
    }





    private void applyHeadRotation(float pNetHeadYaw, float pHeadPitch, float pAgeInTicks) {
        pNetHeadYaw = Mth.clamp(pNetHeadYaw, -10.0F, 10.0F);
        pHeadPitch = Mth.clamp(pHeadPitch, -0.0F, 0.0F);

        this.head.xRot = pHeadPitch * 0.012453292F;
        this.head.yRot = pNetHeadYaw * 0.012453292F;
    }



    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        deer.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
    }

    @Override
    public ModelPart root() {
        return deer;
    }
}