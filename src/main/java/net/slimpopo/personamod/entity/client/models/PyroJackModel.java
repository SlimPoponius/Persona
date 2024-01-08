package net.slimpopo.personamod.entity.client.models;// Made with Blockbench 4.9.1
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.slimpopo.personamod.entity.animations.ModAnimationDefinition;
import net.slimpopo.personamod.entity.custom.personas.pyrojack.PyroJackEntity;
import net.slimpopo.personamod.entity.custom.personas.pyrojack.PyroJackSummonEntity;

public class PyroJackModel<T extends Entity> extends HierarchicalModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	private final ModelPart root;
	private final ModelPart head;

	public PyroJackModel(ModelPart root) {

		this.root = root.getChild("root");
		this.head = this.root.getChild("mid").getChild("head");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition root = partdefinition.addOrReplaceChild("root", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition mid = root.addOrReplaceChild("mid", CubeListBuilder.create().texOffs(0, 17).addBox(-6.0F, -16.0F, -6.0F, 12.0F, 3.0F, 12.0F, new CubeDeformation(0.0F))
		.texOffs(16, 69).addBox(-6.0F, -16.0F, -8.0F, 9.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(6, 17).addBox(3.0F, -16.0F, -7.0F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(48, 0).addBox(-8.0F, -16.0F, -8.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(0, 13).addBox(-2.0F, -14.0F, -8.0F, 5.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(0, 45).addBox(2.0F, -13.0F, -8.0F, 5.0F, 4.0F, 14.0F, new CubeDeformation(0.0F))
		.texOffs(56, 61).addBox(7.0F, -13.0F, -7.0F, 1.0F, 4.0F, 12.0F, new CubeDeformation(0.0F))
		.texOffs(38, 48).addBox(9.0F, -8.0F, -8.0F, 1.0F, 2.0F, 14.0F, new CubeDeformation(0.0F))
		.texOffs(36, 32).addBox(-2.0F, -13.0F, -8.0F, 4.0F, 4.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(0, 76).addBox(-1.0F, -9.0F, -9.0F, 6.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(70, 68).addBox(-1.0F, -8.0F, -10.0F, 9.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(24, 48).addBox(-7.0F, -13.0F, 6.0F, 13.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(56, 29).addBox(-9.0F, -13.0F, -6.0F, 3.0F, 4.0F, 12.0F, new CubeDeformation(0.0F))
		.texOffs(0, 63).addBox(-7.0F, -9.0F, -4.0F, 3.0F, 3.0F, 10.0F, new CubeDeformation(0.0F))
		.texOffs(16, 64).addBox(-7.0F, -9.0F, 6.0F, 13.0F, 3.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(66, 22).addBox(-6.0F, -8.0F, 8.0F, 11.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(32, 29).addBox(5.0F, -9.0F, -9.0F, 4.0F, 3.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition cube_r1 = mid.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 19).addBox(-0.4748F, -0.9658F, -0.0231F, 2.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -14.25F, -8.75F, 0.0066F, -0.524F, -1.7051F));

		PartDefinition cube_r2 = mid.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(0, 20).addBox(-0.4748F, -0.9658F, -0.0231F, 2.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, -14.25F, -8.75F, 0.0066F, -0.524F, -1.7051F));

		PartDefinition cube_r3 = mid.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(12, 13).addBox(-0.9559F, -0.9658F, -0.0916F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.25F, -11.25F, -9.5F, 0.0113F, 0.0421F, -1.5706F));

		PartDefinition cube_r4 = mid.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(0, 17).addBox(-0.9559F, -0.9658F, -0.0916F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.25F, -11.25F, -9.5F, 0.0113F, 0.0421F, -1.5706F));

		PartDefinition cube_r5 = mid.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(0, 5).addBox(-2.0F, -1.0F, -6.0F, 3.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, -12.25F, -3.0F, 0.0058F, -0.1749F, -1.7028F));

		PartDefinition cube_r6 = mid.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(36, 26).addBox(-2.0F, -1.0F, -6.0F, 3.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -13.0F, -3.0F, 0.0F, 0.0F, -1.4399F));

		PartDefinition head = mid.addOrReplaceChild("head", CubeListBuilder.create().texOffs(40, 73).addBox(-3.0F, -8.0F, -5.0F, 6.0F, 7.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(48, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(26, 73).addBox(-3.0F, -8.0F, 4.0F, 6.0F, 7.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(56, 29).addBox(-2.0F, -8.0F, 5.0F, 4.0F, 6.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(36, 17).addBox(-2.0F, -8.0F, -6.0F, 4.0F, 6.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 45).addBox(-5.0F, -8.0F, -3.0F, 1.0F, 7.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(0, 32).addBox(-6.0F, -8.0F, -2.0F, 1.0F, 6.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(0, 17).addBox(5.0F, -8.0F, -2.0F, 1.0F, 6.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(4.0F, -8.0F, -3.0F, 1.0F, 7.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -16.0F, 0.0F));

		PartDefinition hat = head.addOrReplaceChild("hat", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition cube_r7 = hat.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, -18.0F, 10.0F, 1.5708F, -0.829F, -1.5708F));

		PartDefinition cube_r8 = hat.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(8, 0).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -18.0F, 8.0F, 1.5708F, 0.6545F, -1.5708F));

		PartDefinition cube_r9 = hat.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(36, 38).addBox(-2.0F, -1.0F, -1.0F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -17.0F, 7.0F, -1.5708F, -1.1345F, 1.5708F));

		PartDefinition cube_r10 = hat.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(70, 61).addBox(1.0F, -35.0F, -2.0F, 5.0F, 3.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(36, 17).addBox(-5.0F, -28.0F, -5.0F, 10.0F, 2.0F, 10.0F, new CubeDeformation(0.0F))
		.texOffs(0, 32).addBox(-6.0F, -26.0F, -6.0F, 12.0F, 1.0F, 12.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-8.0F, -25.0F, -8.0F, 16.0F, 1.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 16.0F, 0.0F, 0.0F, -1.5708F, 0.0F));

		PartDefinition cube_r11 = hat.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(40, 64).addBox(-2.0F, -2.0F, -3.0F, 5.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -16.0F, 1.0F, -1.5708F, -1.0908F, 1.5708F));

		PartDefinition cube_r12 = hat.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(54, 48).addBox(-3.0F, -2.0F, -4.0F, 7.0F, 5.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -14.0F, 0.0F, -1.5708F, -1.4399F, 1.5708F));

		PartDefinition hand = mid.addOrReplaceChild("hand", CubeListBuilder.create().texOffs(72, 0).addBox(-2.0F, -3.0F, -4.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(74, 25).addBox(-1.5F, -2.0F, 0.0F, 3.0F, 3.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(36, 24).addBox(-3.0F, 1.0F, -4.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(6, 32).addBox(-3.0F, -1.0F, -2.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-4.0F, -12.0F, -8.0F));

		PartDefinition lantern = hand.addOrReplaceChild("lantern", CubeListBuilder.create().texOffs(8, 45).addBox(-3.0F, -1.0F, -3.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 45).addBox(2.0F, -1.0F, -3.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 27).addBox(-2.0F, 2.0F, -3.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 42).addBox(-1.0F, 3.0F, -3.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(66, 16).addBox(-3.0F, 4.0F, -5.0F, 6.0F, 1.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(24, 53).addBox(-3.0F, 9.0F, -5.0F, 6.0F, 1.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(74, 32).addBox(-2.0F, 5.0F, -4.0F, 4.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 96, 96);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.root.getAllParts().forEach(ModelPart::resetPose);
		this.applyHeadRotation(netHeadYaw,headPitch,ageInTicks);

		if(entity instanceof PyroJackEntity) {
			this.animate(((PyroJackEntity) entity).idleAnimationState,
					ModAnimationDefinition.PERSONA_PYROJACK_IDLE, ageInTicks, 1f);

			this.animate(((PyroJackEntity) entity).attackAnimationState,
					ModAnimationDefinition.PERSONA_PYROJACK_ATTACK, ageInTicks, 1f);
		}

		if(entity instanceof PyroJackSummonEntity) {
			this.animate(((PyroJackSummonEntity) entity).idleAnimationState,
					ModAnimationDefinition.PERSONA_PYROJACK_IDLE, ageInTicks, 1f);

			this.animate(((PyroJackSummonEntity) entity).attackAnimationState,
					ModAnimationDefinition.PERSONA_PYROJACK_ATTACK, ageInTicks, 1f);
		}
	}

	private void applyHeadRotation(float pNetHeadYaw,float pHeadPitch,float pAgeInTicks){
		pNetHeadYaw = Mth.clamp(pNetHeadYaw,-30f,30f);
		pHeadPitch = Mth.clamp(pHeadPitch,-25f,45f);

		this.head.yRot = pNetHeadYaw * ((float) Math.PI/180f);
		this.head.xRot = pHeadPitch * ((float)Math.PI/180f);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		root.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart root() {
		return root;
	}
}