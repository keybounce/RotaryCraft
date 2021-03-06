/*******************************************************************************
 * @author Reika Kalseki
 * 
 * Copyright 2014
 * 
 * All rights reserved.
 * Distribution of the software in any form is only allowed with
 * explicit, prior permission from the owner.
 ******************************************************************************/
// Date: 17/05/2013 1:11:43 PM
// Template version 1.1
// Java generated by Techne
// Keep in mind that you still need to fill in some blanks
// - ZeuX

package Reika.RotaryCraft.Models.Animated;

import java.util.ArrayList;

import net.minecraft.client.model.ModelRenderer;

import org.lwjgl.opengl.GL11;

import Reika.RotaryCraft.Base.RotaryModelBase;

public class ModelMagnetizer extends RotaryModelBase
{
	//fields
	ModelRenderer Shape1;
	ModelRenderer Shape2;
	ModelRenderer Shape2a;
	ModelRenderer Shape2c;
	ModelRenderer Shape2b;
	ModelRenderer Shape2d;
	ModelRenderer Shape2e;
	ModelRenderer Shape2f;
	ModelRenderer Shape2g;
	ModelRenderer Shape2j;
	ModelRenderer Shape2h;
	ModelRenderer Shape3;
	ModelRenderer Shape3a;
	ModelRenderer Shape4;
	ModelRenderer Shape4a;
	ModelRenderer Shape2k;
	ModelRenderer Shape2l;
	ModelRenderer Shape2m;
	ModelRenderer Shape2n;
	ModelRenderer Shape2o;
	ModelRenderer Shape2p;
	ModelRenderer Shape5;
	ModelRenderer Shape5a;
	ModelRenderer Shape5b;
	ModelRenderer Shape5c;

	public ModelMagnetizer()
	{
		textureWidth = 128;
		textureHeight = 128;

		Shape1 = new ModelRenderer(this, 0, 0);
		Shape1.addBox(0F, 0F, 0F, 16, 1, 16);
		Shape1.setRotationPoint(-8F, 23F, -8F);
		Shape1.setTextureSize(128, 128);
		Shape1.mirror = true;
		this.setRotation(Shape1, 0F, 0F, 0F);
		Shape2 = new ModelRenderer(this, 0, 38);
		Shape2.addBox(0F, 0F, 0F, 5, 1, 16);
		Shape2.setRotationPoint(3F, 22F, -8F);
		Shape2.setTextureSize(128, 128);
		Shape2.mirror = true;
		this.setRotation(Shape2, 0F, 0F, 0F);
		Shape2a = new ModelRenderer(this, 0, 20);
		Shape2a.addBox(0F, 0F, 0F, 5, 1, 16);
		Shape2a.setRotationPoint(-8F, 22F, -8F);
		Shape2a.setTextureSize(128, 128);
		Shape2a.mirror = true;
		this.setRotation(Shape2a, 0F, 0F, 0F);
		Shape2c = new ModelRenderer(this, 82, 94);
		Shape2c.addBox(0F, 0F, 0F, 4, 1, 16);
		Shape2c.setRotationPoint(4F, 9F, -8F);
		Shape2c.setTextureSize(128, 128);
		Shape2c.mirror = true;
		this.setRotation(Shape2c, 0F, 0F, 0F);
		Shape2b = new ModelRenderer(this, 82, 57);
		Shape2b.addBox(0F, 0F, 0F, 3, 2, 16);
		Shape2b.setRotationPoint(5F, 10F, -8F);
		Shape2b.setTextureSize(128, 128);
		Shape2b.mirror = true;
		this.setRotation(Shape2b, 0F, 0F, 0F);
		Shape2d = new ModelRenderer(this, 43, 98);
		Shape2d.addBox(0F, 0F, 0F, 1, 2, 16);
		Shape2d.setRotationPoint(7F, 14F, -8F);
		Shape2d.setTextureSize(128, 128);
		Shape2d.mirror = true;
		this.setRotation(Shape2d, 0F, 0F, 0F);
		Shape2e = new ModelRenderer(this, 82, 19);
		Shape2e.addBox(0F, 0F, 0F, 2, 2, 16);
		Shape2e.setRotationPoint(6F, 12F, -8F);
		Shape2e.setTextureSize(128, 128);
		Shape2e.mirror = true;
		this.setRotation(Shape2e, 0F, 0F, 0F);
		Shape2f = new ModelRenderer(this, 82, 76);
		Shape2f.addBox(0F, 0F, 0F, 4, 1, 16);
		Shape2f.setRotationPoint(-8F, 9F, -8F);
		Shape2f.setTextureSize(128, 128);
		Shape2f.mirror = true;
		this.setRotation(Shape2f, 0F, 0F, 0F);
		Shape2g = new ModelRenderer(this, 82, 38);
		Shape2g.addBox(0F, 0F, 0F, 3, 2, 16);
		Shape2g.setRotationPoint(-8F, 10F, -8F);
		Shape2g.setTextureSize(128, 128);
		Shape2g.mirror = true;
		this.setRotation(Shape2g, 0F, 0F, 0F);
		Shape2j = new ModelRenderer(this, 79, 0);
		Shape2j.addBox(0F, 0F, 0F, 2, 2, 16);
		Shape2j.setRotationPoint(-8F, 12F, -8F);
		Shape2j.setTextureSize(128, 128);
		Shape2j.mirror = true;
		this.setRotation(Shape2j, 0F, 0F, 0F);
		Shape2h = new ModelRenderer(this, 43, 79);
		Shape2h.addBox(0F, 0F, 0F, 1, 2, 16);
		Shape2h.setRotationPoint(-8F, 14F, -8F);
		Shape2h.setTextureSize(128, 128);
		Shape2h.mirror = true;
		this.setRotation(Shape2h, 0F, 0F, 0F);
		Shape3 = new ModelRenderer(this, 0, 111);
		Shape3.addBox(-1F, -1F, 0F, 2, 2, 15);
		Shape3.setRotationPoint(0F, 15F, -6.5F);
		Shape3.setTextureSize(128, 128);
		Shape3.mirror = true;
		this.setRotation(Shape3, 0F, 0F, 0.7853982F);
		Shape3a = new ModelRenderer(this, 0, 111);
		Shape3a.addBox(-1F, -1F, 0F, 2, 2, 15);
		Shape3a.setRotationPoint(0F, 15F, -6.5F);
		Shape3a.setTextureSize(128, 128);
		Shape3a.mirror = true;
		this.setRotation(Shape3a, 0F, 0F, 0F);
		Shape4 = new ModelRenderer(this, 66, 0);
		Shape4.addBox(0F, 0F, 0F, 4, 10, 2);
		Shape4.setRotationPoint(-2F, 13F, 6F);
		Shape4.setTextureSize(128, 128);
		Shape4.mirror = true;
		this.setRotation(Shape4, 0F, 0F, 0F);
		Shape4a = new ModelRenderer(this, 66, 0);
		Shape4a.addBox(0F, 0F, 0F, 4, 10, 2);
		Shape4a.setRotationPoint(-2F, 13F, -6F);
		Shape4a.setTextureSize(128, 128);
		Shape4a.mirror = true;
		this.setRotation(Shape4a, 0F, 0F, 0F);
		Shape2k = new ModelRenderer(this, 43, 39);
		Shape2k.addBox(0F, 0F, 0F, 2, 3, 16);
		Shape2k.setRotationPoint(-8F, 16F, -8F);
		Shape2k.setTextureSize(128, 128);
		Shape2k.mirror = true;
		this.setRotation(Shape2k, 0F, 0F, 0F);
		Shape2l = new ModelRenderer(this, 43, 59);
		Shape2l.addBox(0F, 0F, 0F, 2, 3, 16);
		Shape2l.setRotationPoint(6F, 16F, -8F);
		Shape2l.setTextureSize(128, 128);
		Shape2l.mirror = true;
		this.setRotation(Shape2l, 0F, 0F, 0F);
		Shape2m = new ModelRenderer(this, 0, 92);
		Shape2m.addBox(0F, 0F, 0F, 3, 2, 16);
		Shape2m.setRotationPoint(-8F, 19F, -8F);
		Shape2m.setTextureSize(128, 128);
		Shape2m.mirror = true;
		this.setRotation(Shape2m, 0F, 0F, 0F);
		Shape2n = new ModelRenderer(this, 43, 20);
		Shape2n.addBox(0F, 0F, 0F, 3, 2, 16);
		Shape2n.setRotationPoint(5F, 19F, -8F);
		Shape2n.setTextureSize(128, 128);
		Shape2n.mirror = true;
		this.setRotation(Shape2n, 0F, 0F, 0F);
		Shape2o = new ModelRenderer(this, 0, 56);
		Shape2o.addBox(0F, 0F, 0F, 4, 1, 16);
		Shape2o.setRotationPoint(-8F, 21F, -8F);
		Shape2o.setTextureSize(128, 128);
		Shape2o.mirror = true;
		this.setRotation(Shape2o, 0F, 0F, 0F);
		Shape2p = new ModelRenderer(this, 0, 74);
		Shape2p.addBox(0F, 0F, 0F, 4, 1, 16);
		Shape2p.setRotationPoint(4F, 21F, -8F);
		Shape2p.setTextureSize(128, 128);
		Shape2p.mirror = true;
		this.setRotation(Shape2p, 0F, 0F, 0F);
		Shape5 = new ModelRenderer(this, 79, 113);
		Shape5.addBox(-2F, -2F, 0F, 4, 4, 6);
		Shape5.setRotationPoint(0F, 15F, -2F);
		Shape5.setTextureSize(128, 128);
		Shape5.mirror = true;
		this.setRotation(Shape5, 0F, 0F, 0.7853982F);
		Shape5a = new ModelRenderer(this, 79, 113);
		Shape5a.addBox(-2F, -2F, 0F, 4, 4, 6);
		Shape5a.setRotationPoint(0F, 15F, -2F);
		Shape5a.setTextureSize(128, 128);
		Shape5a.mirror = true;
		this.setRotation(Shape5a, 0F, 0F, 0.3926991F);
		Shape5b = new ModelRenderer(this, 79, 113);
		Shape5b.addBox(-2F, -2F, 0F, 4, 4, 6);
		Shape5b.setRotationPoint(0F, 15F, -2F);
		Shape5b.setTextureSize(128, 128);
		Shape5b.mirror = true;
		this.setRotation(Shape5b, 0F, 0F, 1.178097F);
		Shape5c = new ModelRenderer(this, 79, 113);
		Shape5c.addBox(-2F, -2F, 0F, 4, 4, 6);
		Shape5c.setRotationPoint(0F, 15F, -2F);
		Shape5c.setTextureSize(128, 128);
		Shape5c.mirror = true;
		this.setRotation(Shape5c, 0F, 0F, 0F);
	}

	@Override
	public void renderAll(ArrayList li, float phi, float theta)
	{
		Shape1.render(f5);
		Shape2.render(f5);
		Shape2a.render(f5);
		Shape2c.render(f5);
		Shape2b.render(f5);
		Shape2d.render(f5);
		Shape2e.render(f5);
		Shape2f.render(f5);
		Shape2g.render(f5);
		Shape2j.render(f5);
		Shape2h.render(f5);
		Shape4.render(f5);
		Shape4a.render(f5);
		Shape2k.render(f5);
		Shape2l.render(f5);
		Shape2m.render(f5);
		Shape2n.render(f5);
		Shape2o.render(f5);
		Shape2p.render(f5);
		boolean has = (Boolean)li.get(0);
		if (!has)
			return;
		GL11.glTranslated(0, 0.9375, 0);
		GL11.glRotatef(phi, 0, 0, 1);
		GL11.glTranslated(0, -0.9375, 0);
		Shape3.render(f5);
		Shape3a.render(f5);
		Shape5.render(f5);
		Shape5a.render(f5);
		Shape5b.render(f5);
		Shape5c.render(f5);
		GL11.glTranslated(0, 0.9375, 0);
		GL11.glRotatef(-phi, 0, 0, 1);
		GL11.glTranslated(0, -0.9375, 0);
	}

	@Override
	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f6)
	{
		super.setRotationAngles(f, f1, f2, f3, f4, f5);
	}

}
