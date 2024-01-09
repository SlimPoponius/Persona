package net.slimpopo.personamod.entity.client.models;
// Made with Blockbench 4.9.3
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
import net.slimpopo.personamod.entity.animations.JackFrostAnimationDefinition;
import net.slimpopo.personamod.entity.custom.personas.blackfrost.BlackFrostEntity;
import net.slimpopo.personamod.entity.custom.personas.blackfrost.BlackFrostSummonEntity;
import net.slimpopo.personamod.entity.custom.personas.jackfrost.JackFrostEntity;
import net.slimpopo.personamod.entity.custom.personas.jackfrost.JackFrostSummonEntity;

public class JackFrostModel<T extends Entity> extends HierarchicalModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	private final ModelPart root;
	private final ModelPart head;

	public JackFrostModel(ModelPart root) {
		this.root = root.getChild("root");
		this.head = this.root.getChild("mid").getChild("head");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition root = partdefinition.addOrReplaceChild("root", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition mid = root.addOrReplaceChild("mid", CubeListBuilder.create().texOffs(56, 59).addBox(3.5F, -9.0F, -2.0F, 1.0F, 8.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(0, 57).addBox(-4.5F, -9.0F, -2.0F, 1.0F, 8.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(30, 54).addBox(-3.0F, -9.0F, -4.0F, 6.0F, 8.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(26, 64).addBox(-3.0F, -6.0F, -5.0F, 6.0F, 5.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(15, 54).addBox(-3.0F, -9.0F, 3.0F, 6.0F, 8.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(27, 29).addBox(-3.5F, -10.0F, -3.0F, 7.0F, 9.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(29, 9).addBox(-3.5F, -1.0F, -3.0F, 7.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -7.0F, 2.0F));

		PartDefinition head = mid.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -6.0F, -2.0F, 8.0F, 6.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(0, 25).addBox(-4.0F, -7.0F, -2.0F, 8.0F, 1.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(0, 45).addBox(4.0F, -6.0F, -1.0F, 1.0F, 5.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(13, 39).addBox(-5.0F, -6.0F, -1.0F, 1.0F, 5.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(41, 64).addBox(-3.0F, -6.0F, -3.0F, 6.0F, 5.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(63, 56).addBox(-3.0F, -6.0F, 6.0F, 6.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -10.0F, -2.0F));

		PartDefinition hat = head.addOrReplaceChild("hat", CubeListBuilder.create().texOffs(0, 15).addBox(-5.0F, -2.0F, -4.0F, 10.0F, 1.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(25, 0).addBox(-4.0F, -3.0F, -3.0F, 8.0F, 1.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(40, 17).addBox(-3.0F, -4.0F, -2.0F, 6.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(54, 41).addBox(-4.0F, -1.0F, -5.0F, 8.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(69, 38).addBox(-3.0F, -2.0F, -5.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(73, 23).addBox(-2.0F, -3.0F, -4.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(15, 51).addBox(-2.0F, -3.0F, 3.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(11, 35).addBox(-3.0F, -2.0F, 4.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(48, 0).addBox(-4.0F, -1.0F, 4.0F, 8.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 35).addBox(-5.0F, -1.0F, -4.0F, 1.0F, 1.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(29, 17).addBox(4.0F, -1.0F, -4.0F, 1.0F, 1.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(57, 13).addBox(5.0F, -1.0F, -3.0F, 1.0F, 1.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(56, 48).addBox(-6.0F, -1.0F, -3.0F, 1.0F, 1.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(50, 72).addBox(-6.0F, -2.0F, -2.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-5.0F, -3.0F, -1.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(39, 71).addBox(5.0F, -2.0F, -2.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(0, 4).addBox(4.0F, -3.0F, -1.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(69, 29).addBox(5.0F, 0.0F, -2.0F, 1.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(67, 63).addBox(-6.0F, 0.0F, -2.0F, 1.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(0, 35).addBox(-6.0F, 4.0F, 1.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(29, 17).addBox(-6.0F, 4.0F, -2.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(73, 51).addBox(-6.0F, 6.0F, -1.5F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(61, 21).addBox(5.0F, 6.0F, -1.5F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(25, 26).addBox(5.0F, 4.0F, 1.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 29).addBox(5.0F, 4.0F, -2.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -6.0F, 2.0F));

		PartDefinition horn_l = hat.addOrReplaceChild("horn_l", CubeListBuilder.create().texOffs(50, 4).addBox(-2.0F, -4.0F, -1.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, -2.0F, 1.0F, 0.0F, 0.2618F, 0.0F));

		PartDefinition cube_r1 = horn_l.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(25, 0).addBox(2.5F, -7.75F, -10.25F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(65, 21).addBox(2.25F, -5.75F, -10.25F, 1.5F, 2.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(67, 8).addBox(2.0F, -3.75F, -8.25F, 2.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, -2.0F, 0.0F, -2.4871F, 0.0F, 0.0F));

		PartDefinition cube_r2 = horn_l.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(45, 54).addBox(1.5F, -5.25F, -2.25F, 3.0F, 4.75F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, -2.0F, 0.0F, -0.9163F, 0.0F, 0.0F));

		PartDefinition cube_r3 = horn_l.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(28, 45).addBox(1.0F, -1.25F, -1.75F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, -2.0F, 0.0F, -0.4363F, 0.0F, 0.0F));

		PartDefinition horn_r = hat.addOrReplaceChild("horn_r", CubeListBuilder.create().texOffs(48, 23).addBox(-2.0F, -4.0F, -1.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, -2.0F, 1.0F, 0.0F, -0.2618F, 0.0F));

		PartDefinition cube_r4 = horn_r.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(0, 25).addBox(-3.5F, -7.75F, -10.25F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(63, 0).addBox(-3.75F, -5.75F, -10.25F, 1.5F, 2.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(65, 44).addBox(-4.0F, -3.75F, -8.25F, 2.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, -2.0F, 0.0F, -2.4871F, 0.0F, 0.0F));

		PartDefinition cube_r5 = horn_r.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(54, 32).addBox(-4.5F, -5.25F, -2.25F, 3.0F, 4.75F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, -2.0F, 0.0F, -0.9163F, 0.0F, 0.0F));

		PartDefinition cube_r6 = horn_r.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(45, 45).addBox(-5.0F, -1.25F, -1.75F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, -2.0F, 0.0F, -0.4363F, 0.0F, 0.0F));

		PartDefinition arm_l = mid.addOrReplaceChild("arm_l", CubeListBuilder.create().texOffs(76, 46).addBox(0.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(4.5F, -8.0F, 0.0F));

		PartDefinition lower_arm_l = arm_l.addOrReplaceChild("lower_arm_l", CubeListBuilder.create().texOffs(76, 27).addBox(0.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, 0.0F, 0.0F));

		PartDefinition hand_l = lower_arm_l.addOrReplaceChild("hand_l", CubeListBuilder.create().texOffs(72, 72).addBox(0.0F, -1.0F, -1.75F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, 0.0F, 0.0F));

		PartDefinition cube_r7 = hand_l.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(0, 18).addBox(-0.25F, -0.5F, -0.75F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.25F, 0.5F, -2.0F, 0.0F, 0.0F, 0.7418F));

		PartDefinition cube_r8 = hand_l.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(75, 60).addBox(-0.5F, -0.25F, -1.5F, 1.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.5F, 0.0F, -0.25F, 0.0F, 0.0F, -1.1781F));

		PartDefinition arm_r = mid.addOrReplaceChild("arm_r", CubeListBuilder.create().texOffs(0, 76).addBox(-2.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-4.5F, -8.0F, 0.0F));

		PartDefinition lower_arm_r = arm_r.addOrReplaceChild("lower_arm_r", CubeListBuilder.create().texOffs(24, 76).addBox(-2.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, 0.0F, 0.0F));

		PartDefinition hand_r = lower_arm_r.addOrReplaceChild("hand_r", CubeListBuilder.create().texOffs(61, 72).addBox(-2.0F, -1.0F, -1.75F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, 0.0F, 0.0F));

		PartDefinition cube_r9 = hand_r.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(75, 5).addBox(-0.5F, -0.25F, -1.5F, 1.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.5F, 0.0F, -0.25F, 0.0F, 0.0F, 1.1781F));

		PartDefinition cube_r10 = hand_r.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(0, 15).addBox(-2.0F, -0.5F, -0.75F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.5F, -2.0F, 0.0F, 0.0F, -0.7418F));

		PartDefinition neck = mid.addOrReplaceChild("neck", CubeListBuilder.create(), PartPose.offset(0.0F, -9.0F, 0.0F));

		PartDefinition tassel_1 = neck.addOrReplaceChild("tassel_1", CubeListBuilder.create().texOffs(85, 19).addBox(-1.0F, -1.0F, -2.0F, 3.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, 0.0F, -3.0F, 0.9366F, 0.5035F, -0.0334F));

		PartDefinition cube_r11 = tassel_1.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(85, 19).addBox(-0.5F, -1.0F, -4.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.1309F, 0.0F, 0.0F));

		PartDefinition tassel_2 = neck.addOrReplaceChild("tassel_2", CubeListBuilder.create().texOffs(85, 19).mirror().addBox(-2.0F, -1.0F, -2.0F, 3.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(3.0F, 0.0F, -3.0F, 0.9366F, -0.5035F, 0.0334F));

		PartDefinition cube_r12 = tassel_2.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(85, 19).mirror().addBox(-1.5F, -1.0F, -4.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.1309F, 0.0F, 0.0F));

		PartDefinition tassel_7 = neck.addOrReplaceChild("tassel_7", CubeListBuilder.create().texOffs(85, 19).mirror().addBox(-2.0F, -1.0F, -2.0F, 3.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(4.0F, 0.0F, -1.0F, 1.1667F, -1.0272F, -0.3474F));

		PartDefinition cube_r13 = tassel_7.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(85, 19).mirror().addBox(-1.5F, -1.0F, -4.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.1309F, 0.0F, 0.0F));

		PartDefinition tassel_10 = neck.addOrReplaceChild("tassel_10", CubeListBuilder.create().texOffs(85, 19).mirror().addBox(-2.0F, -1.0F, 0.0F, 3.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(4.0F, 0.0F, 2.0F, -1.1667F, 1.0272F, -0.3474F));

		PartDefinition cube_r14 = tassel_10.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(85, 19).mirror().addBox(-1.5F, -1.0F, 2.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.1309F, 0.0F, 0.0F));

		PartDefinition tassel_8 = neck.addOrReplaceChild("tassel_8", CubeListBuilder.create().texOffs(85, 19).addBox(-1.0F, -1.0F, -2.0F, 3.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, 0.0F, -1.0F, 1.1667F, 1.0272F, 0.3474F));

		PartDefinition cube_r15 = tassel_8.addOrReplaceChild("cube_r15", CubeListBuilder.create().texOffs(85, 19).addBox(-0.5F, -1.0F, -4.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.1309F, 0.0F, 0.0F));

		PartDefinition tassel_9 = neck.addOrReplaceChild("tassel_9", CubeListBuilder.create().texOffs(85, 19).addBox(-1.0F, -1.0F, 0.0F, 3.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, 0.0F, 1.0F, -1.1667F, -1.0272F, 0.3474F));

		PartDefinition cube_r16 = tassel_9.addOrReplaceChild("cube_r16", CubeListBuilder.create().texOffs(85, 19).addBox(-0.5F, -1.0F, 2.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.1309F, 0.0F, 0.0F));

		PartDefinition tassel_3 = neck.addOrReplaceChild("tassel_3", CubeListBuilder.create().texOffs(85, 19).mirror().addBox(-2.0F, -1.0F, 0.0F, 3.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(3.0F, 0.0F, 3.0F, -0.9366F, 0.5035F, 0.0334F));

		PartDefinition cube_r17 = tassel_3.addOrReplaceChild("cube_r17", CubeListBuilder.create().texOffs(85, 19).mirror().addBox(-1.5F, -1.0F, 2.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.1309F, 0.0F, 0.0F));

		PartDefinition tassel_5 = neck.addOrReplaceChild("tassel_5", CubeListBuilder.create().texOffs(85, 19).mirror().addBox(-2.0F, -1.0F, 0.0F, 3.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.5F, 0.25F, 3.5F, -0.9366F, 0.0F, 0.0334F));

		PartDefinition cube_r18 = tassel_5.addOrReplaceChild("cube_r18", CubeListBuilder.create().texOffs(85, 19).mirror().addBox(-1.5F, -1.0F, 2.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.1309F, 0.0F, 0.0F));

		PartDefinition tassel_6 = neck.addOrReplaceChild("tassel_6", CubeListBuilder.create().texOffs(85, 19).mirror().addBox(-2.0F, -1.0F, -2.0F, 3.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.5F, 0.25F, -3.5F, 0.9366F, 0.0F, 0.0334F));

		PartDefinition cube_r19 = tassel_6.addOrReplaceChild("cube_r19", CubeListBuilder.create().texOffs(85, 19).mirror().addBox(-1.5F, -1.0F, -4.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.1309F, 0.0F, 0.0F));

		PartDefinition tassel_4 = neck.addOrReplaceChild("tassel_4", CubeListBuilder.create().texOffs(85, 19).addBox(-1.0F, -1.0F, 0.0F, 3.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, 0.0F, 3.0F, -0.9366F, -0.5035F, -0.0334F));

		PartDefinition cube_r20 = tassel_4.addOrReplaceChild("cube_r20", CubeListBuilder.create().texOffs(85, 19).addBox(-0.5F, -1.0F, 2.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.1309F, 0.0F, 0.0F));

		PartDefinition leg_l = root.addOrReplaceChild("leg_l", CubeListBuilder.create().texOffs(78, 11).addBox(-1.0F, 1.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, -8.0F, 2.0F));

		PartDefinition lower_leg_l = leg_l.addOrReplaceChild("lower_leg_l", CubeListBuilder.create().texOffs(33, 77).addBox(-1.0F, 1.0F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(26, 71).addBox(-1.5F, 2.0F, -1.5F, 3.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(78, 56).addBox(-1.0F, 3.0F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 2.0F, 0.0F));

		PartDefinition foot_l = lower_leg_l.addOrReplaceChild("foot_l", CubeListBuilder.create().texOffs(13, 71).addBox(-1.75F, 0.0F, -4.0F, 3.5F, 2.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(73, 41).addBox(-1.5F, 0.0F, -1.0F, 3.0F, 2.0F, 2.25F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 4.0F, 0.0F));

		PartDefinition leg_r = root.addOrReplaceChild("leg_r", CubeListBuilder.create().texOffs(42, 77).addBox(-1.0F, 1.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, -8.0F, 2.0F));

		PartDefinition lower_leg_r = leg_r.addOrReplaceChild("lower_leg_r", CubeListBuilder.create().texOffs(9, 77).addBox(-1.0F, 1.0F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(71, 0).addBox(-1.5F, 2.0F, -1.5F, 3.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(51, 78).addBox(-1.0F, 3.0F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 2.0F, 0.0F));

		PartDefinition foot_r = lower_leg_r.addOrReplaceChild("foot_r", CubeListBuilder.create().texOffs(0, 70).addBox(-3.75F, -2.0F, -2.0F, 3.5F, 2.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(73, 18).addBox(-3.5F, -2.0F, 1.0F, 3.0F, 2.0F, 2.25F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, 6.0F, -2.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	private void applyHeadRotation(float pNetHeadYaw,float pHeadPitch,float pAgeInTicks){
		pNetHeadYaw = Mth.clamp(pNetHeadYaw,-30f,30f);
		pHeadPitch = Mth.clamp(pHeadPitch,-25f,45f);

		this.head.yRot = pNetHeadYaw * ((float) Math.PI/180f);
		this.head.xRot = pHeadPitch * ((float)Math.PI/180f);
	}


	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.root.getAllParts().forEach(ModelPart::resetPose);
		this.applyHeadRotation(netHeadYaw,headPitch,ageInTicks);

		this.animateWalk(JackFrostAnimationDefinition.PERSONA_JACK_FROST_WALKING,
				limbSwing,limbSwingAmount,2f,2.5f);

		if(entity instanceof JackFrostEntity persona) {
			this.animate(persona.idleAnimationState,
					JackFrostAnimationDefinition.PERSONA_JACK_FROST_IDLE, ageInTicks, 1f);

			this.animate(persona.attackAnimationState,
					JackFrostAnimationDefinition.PERSONA_JACKFROST_ATTACK, ageInTicks, 1f);

		}

		if(entity instanceof BlackFrostEntity persona) {
			this.animate(persona.idleAnimationState,
					JackFrostAnimationDefinition.PERSONA_JACK_FROST_IDLE, ageInTicks, 1f);

			this.animate(persona.attackAnimationState,
					JackFrostAnimationDefinition.PERSONA_JACKFROST_ATTACK, ageInTicks, 1f);

		}

		if(entity instanceof JackFrostSummonEntity persona) {
			this.animate(persona.idleAnimationState,
					JackFrostAnimationDefinition.PERSONA_JACK_FROST_IDLE, ageInTicks, 1f);

			this.animate(persona.attackAnimationState,
					JackFrostAnimationDefinition.PERSONA_JACKFROST_ATTACK, ageInTicks, 1f);

		}

		if(entity instanceof BlackFrostSummonEntity persona) {
			this.animate(persona.idleAnimationState,
					JackFrostAnimationDefinition.PERSONA_JACK_FROST_IDLE, ageInTicks, 1f);

			this.animate(persona.attackAnimationState,
					JackFrostAnimationDefinition.PERSONA_JACKFROST_ATTACK, ageInTicks, 1f);

		}
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		root.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart root() {
		return this.root;
	}

}