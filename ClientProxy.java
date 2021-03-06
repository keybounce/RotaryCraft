/*******************************************************************************
 * @author Reika Kalseki
 * 
 * Copyright 2014
 * 
 * All rights reserved.
 * Distribution of the software in any form is only allowed with
 * explicit, prior permission from the owner.
 ******************************************************************************/
package Reika.RotaryCraft;

import java.util.HashMap;

import net.minecraft.client.renderer.entity.RenderTNTPrimed;
import net.minecraft.world.World;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.common.MinecraftForge;
import Reika.DragonAPI.Instantiable.IO.SoundLoader;
import Reika.DragonAPI.Instantiable.Rendering.BlockSheetTexRenderer;
import Reika.DragonAPI.Instantiable.Rendering.ForcedTextureArmorModel;
import Reika.DragonAPI.Instantiable.Rendering.ItemSpriteSheetRenderer;
import Reika.DragonAPI.Instantiable.Rendering.MultiSheetItemRenderer;
import Reika.DragonAPI.Instantiable.Rendering.SpawnerRenderer;
import Reika.RotaryCraft.Auxiliary.RotaryRenderList;
import Reika.RotaryCraft.Base.RotaryTERenderer;
import Reika.RotaryCraft.Entities.EntityCustomTNT;
import Reika.RotaryCraft.Entities.EntityDischarge;
import Reika.RotaryCraft.Entities.EntityExplosiveShell;
import Reika.RotaryCraft.Entities.EntityFreezeGunShot;
import Reika.RotaryCraft.Entities.EntityIceBlock;
import Reika.RotaryCraft.Entities.EntityLiquidBlock;
import Reika.RotaryCraft.Entities.EntityRailGunShot;
import Reika.RotaryCraft.Entities.EntitySonicShot;
import Reika.RotaryCraft.Entities.RenderDischarge;
import Reika.RotaryCraft.Entities.RenderFreezeGunShot;
import Reika.RotaryCraft.Entities.RenderIceBlock;
import Reika.RotaryCraft.Entities.RenderLiquidBlock;
import Reika.RotaryCraft.Entities.RenderRailGunShot;
import Reika.RotaryCraft.Entities.RenderSonicShot;
import Reika.RotaryCraft.Registry.ItemRegistry;
import Reika.RotaryCraft.Registry.MachineRegistry;
import Reika.RotaryCraft.Registry.SoundRegistry;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ClientProxy extends CommonProxy
{
	//public static final int BlockSheetTexRenderID = RenderingRegistry.getNextAvailableRenderId();

	public static final ItemSpriteSheetRenderer[] items = {
		new ItemSpriteSheetRenderer(RotaryCraft.instance, RotaryCraft.class, "Textures/Items/items.png"),
		new ItemSpriteSheetRenderer(RotaryCraft.instance, RotaryCraft.class, "Textures/Items/items2.png"),
		new ItemSpriteSheetRenderer(RotaryCraft.instance, RotaryCraft.class, "Textures/Items/items3.png"),
	};

	public static final MultiSheetItemRenderer modOres = new MultiSheetItemRenderer(RotaryCraft.instance, RotaryCraft.class);

	//public static final ItemSpriteSheetRenderer terrain = new ItemSpriteSheetRenderer(RotaryCraft.class, "Textures/GUI/mobradargui.png", RotaryAux.terrainpng);
	public static final BlockSheetTexRenderer block = new BlockSheetTexRenderer(RotaryCraft.class, "Textures/Terrain/textures.png");

	public static final ItemMachineRenderer machineItems = new ItemMachineRenderer();
	public static final SpawnerRenderer spawner = new SpawnerRenderer();

	public static PipeBodyRenderer pipe;
	public static CubicalMachineRenderer cube;
	public static ConnectedGlassRenderer connected;

	//public static final ForcedTextureArmorModel bed1 = new ForcedTextureArmorModel(RotaryCraft.class, "/Reika/RotaryCraft/Textures/Misc/bedrock_1.png");
	//public static final ForcedTextureArmorModel bed2 = new ForcedTextureArmorModel(RotaryCraft.class, "/Reika/RotaryCraft/Textures/Misc/bedrock_2.png");
	//public static final ForcedTextureArmorModel hsla1 = new ForcedTextureArmorModel(RotaryCraft.class, "/Reika/RotaryCraft/Textures/Misc/steel_1.png");
	//public static final ForcedTextureArmorModel hsla2 = new ForcedTextureArmorModel(RotaryCraft.class, "/Reika/RotaryCraft/Textures/Misc/steel_2.png");
	//public static final ForcedTextureArmorModel io = new ForcedTextureArmorModel(RotaryCraft.class, "/Reika/RotaryCraft/Textures/Misc/IOGoggles.png");
	//public static final ForcedTextureArmorModel nvg = new ForcedTextureArmorModel(RotaryCraft.class, "/Reika/RotaryCraft/Textures/Misc/NVGoggles.png");
	//public static final ForcedTextureArmorModel nvh = new ForcedTextureArmorModel(RotaryCraft.class, "/Reika/RotaryCraft/Textures/Misc/NVHelmet.png");
	//public static final ForcedTextureArmorModel jet = new ForcedTextureArmorModel(RotaryCraft.class, "/Reika/RotaryCraft/Textures/Misc/jet.png");
	//public static final ForcedTextureArmorModel bedjet = new ForcedTextureArmorModel(RotaryCraft.class, "/Reika/RotaryCraft/Textures/Misc/bedrock_jet.png");

	private static final HashMap<ItemRegistry, ForcedTextureArmorModel> armorTextures = new HashMap();
	private static final HashMap<ItemRegistry, String> armorAssets = new HashMap();

	@Override
	public void registerSounds() {
		MinecraftForge.EVENT_BUS.register(new SoundLoader(RotaryCraft.instance, SoundRegistry.soundList, SoundRegistry.SOUND_FOLDER));
	}

	@Override
	public void registerRenderers() {
		pipeRender = RenderingRegistry.getNextAvailableRenderId();
		pipe = new PipeBodyRenderer(pipeRender);
		RenderingRegistry.registerBlockHandler(pipeRender, pipe);

		cubeRender = RenderingRegistry.getNextAvailableRenderId();
		cube = new CubicalMachineRenderer(cubeRender);
		RenderingRegistry.registerBlockHandler(cubeRender, cube);

		connectedRender = RenderingRegistry.getNextAvailableRenderId();
		connected = new ConnectedGlassRenderer(connectedRender);
		RenderingRegistry.registerBlockHandler(connectedRender, connected);

		this.loadModels();

		RenderingRegistry.registerEntityRenderingHandler(EntityRailGunShot.class, new RenderRailGunShot());
		RenderingRegistry.registerEntityRenderingHandler(EntityExplosiveShell.class, new RenderRailGunShot());
		RenderingRegistry.registerEntityRenderingHandler(EntityFreezeGunShot.class, new RenderFreezeGunShot());
		RenderingRegistry.registerEntityRenderingHandler(EntityIceBlock.class, new RenderIceBlock());
		RenderingRegistry.registerEntityRenderingHandler(EntitySonicShot.class, new RenderSonicShot());
		RenderingRegistry.registerEntityRenderingHandler(EntityLiquidBlock.class, new RenderLiquidBlock());
		RenderingRegistry.registerEntityRenderingHandler(EntityDischarge.class, new RenderDischarge());
		RenderingRegistry.registerEntityRenderingHandler(EntityCustomTNT.class, new RenderTNTPrimed());

		this.registerSpriteSheets();
		this.registerBlockSheets();

		MinecraftForgeClient.registerItemRenderer(RotaryCraft.spawner.itemID, spawner);
	}

	@Override
	public void addArmorRenders() {
		NVHelmet = RenderingRegistry.addNewArmourRendererPrefix("NVHelmet");
		NVGoggles = RenderingRegistry.addNewArmourRendererPrefix("NVGoggles");
		IOGoggles = RenderingRegistry.addNewArmourRendererPrefix("IOGoggles");
		armor = RenderingRegistry.addNewArmourRendererPrefix("Bedrock");
		SteelArmor = RenderingRegistry.addNewArmourRendererPrefix("HSLA");
		/*
		ReikaTextureHelper.forceArmorTexturePath("/Reika/RotaryCraft/Textures/Misc/bedrock_1.png");
		ReikaTextureHelper.forceArmorTexturePath("/Reika/RotaryCraft/Textures/Misc/bedrock_2.png");
		ReikaTextureHelper.forceArmorTexturePath("/Reika/RotaryCraft/Textures/Misc/steel_1.png");
		ReikaTextureHelper.forceArmorTexturePath("/Reika/RotaryCraft/Textures/Misc/steel_2.png");
		ReikaTextureHelper.forceArmorTexturePath("/Reika/RotaryCraft/Textures/Misc/IOGoggles.png");
		ReikaTextureHelper.forceArmorTexturePath("/Reika/RotaryCraft/Textures/Misc/NVGoggles.png");
		ReikaTextureHelper.forceArmorTexturePath("/Reika/RotaryCraft/Textures/Misc/NVHelmet.png");*/

		addArmorTexture(ItemRegistry.JETPACK, "/Reika/RotaryCraft/Textures/Misc/jet.png");
		addArmorTexture(ItemRegistry.BEDPACK, "/Reika/RotaryCraft/Textures/Misc/bedrock_jet.png");
		addArmorTexture(ItemRegistry.JUMP, "/Reika/RotaryCraft/Textures/Misc/jump.png");
		addArmorTexture(ItemRegistry.BEDJUMP, "/Reika/RotaryCraft/Textures/Misc/bedrock_jump.png");
		addArmorTexture(ItemRegistry.NVG, "/Reika/RotaryCraft/Textures/Misc/NVGoggles.png");
		addArmorTexture(ItemRegistry.NVH, "/Reika/RotaryCraft/Textures/Misc/NVHelmet.png");
		addArmorTexture(ItemRegistry.IOGOGGLES, "/Reika/RotaryCraft/Textures/Misc/IOGoggles.png");
		addArmorTexture(ItemRegistry.BEDHELM, "/Reika/RotaryCraft/Textures/Misc/bedrock_1.png");
		addArmorTexture(ItemRegistry.BEDCHEST, "/Reika/RotaryCraft/Textures/Misc/bedrock_1.png");
		addArmorTexture(ItemRegistry.BEDBOOTS, "/Reika/RotaryCraft/Textures/Misc/bedrock_1.png");
		addArmorTexture(ItemRegistry.BEDLEGS, "/Reika/RotaryCraft/Textures/Misc/bedrock_2.png");
		addArmorTexture(ItemRegistry.STEELBOOTS, "/Reika/RotaryCraft/Textures/Misc/steel_1.png");
		addArmorTexture(ItemRegistry.STEELHELMET, "/Reika/RotaryCraft/Textures/Misc/steel_1.png");
		addArmorTexture(ItemRegistry.STEELCHEST, "/Reika/RotaryCraft/Textures/Misc/steel_1.png");
		addArmorTexture(ItemRegistry.STEELLEGS, "/Reika/RotaryCraft/Textures/Misc/steel_2.png");
	}

	private static void addArmorTexture(ItemRegistry item, String tex) {
		RotaryCraft.logger.log("Adding armor texture for "+item+": "+tex);
		armorTextures.put(item, new ForcedTextureArmorModel(RotaryCraft.class, tex, item.getArmorType()));
		String[] s = tex.split("/");
		String file = s[s.length-1];
		String defaultTex = "rotarycraft:textures/models/armor/"+file;
		//ReikaJavaLibrary.pConsole(defaultTex);
		armorAssets.put(item, defaultTex);
	}

	public static ForcedTextureArmorModel getArmorRenderer(ItemRegistry item) {
		return armorTextures.get(item);
	}

	public static String getArmorTextureAsset(ItemRegistry item) {
		return armorAssets.get(item);
	}

	public void loadModels() {

		for (int i = 0; i < MachineRegistry.machineList.length; i++) {
			MachineRegistry m = MachineRegistry.machineList[i];
			if (m.hasRender() && !m.isPipe()) {
				RotaryTERenderer render = RotaryRenderList.instantiateRenderer(m);
				//int[] renderLists = render.createLists();
				//GLListData.addListData(m, renderLists);
				ClientRegistry.bindTileEntitySpecialRenderer(m.getTEClass(), render);
			}
		}

		MinecraftForgeClient.registerItemRenderer(RotaryCraft.machineplacer.itemID, machineItems);
		MinecraftForgeClient.registerItemRenderer(RotaryCraft.engineitems.itemID, machineItems);
		MinecraftForgeClient.registerItemRenderer(RotaryCraft.gbxitems.itemID, machineItems);
		MinecraftForgeClient.registerItemRenderer(RotaryCraft.shaftitems.itemID, machineItems);
		MinecraftForgeClient.registerItemRenderer(RotaryCraft.advgearitems.itemID, machineItems);
		MinecraftForgeClient.registerItemRenderer(RotaryCraft.flywheelitems.itemID, machineItems);
		//MinecraftForgeClient.registerItemRenderer(RotaryCraft.hydraulicitems.itemID, machineItems);
	}


	private void registerBlockSheets() {
		//RenderingRegistry.registerBlockHandler(BlockSheetTexRenderID, block);
	}

	private void registerSpriteSheets() {
		MinecraftForgeClient.registerItemRenderer(RotaryCraft.shaftcraft.itemID, items[0]);
		MinecraftForgeClient.registerItemRenderer(RotaryCraft.enginecraft.itemID, items[0]);
		MinecraftForgeClient.registerItemRenderer(RotaryCraft.borecraft.itemID, items[0]);
		MinecraftForgeClient.registerItemRenderer(RotaryCraft.misccraft.itemID, items[0]);
		MinecraftForgeClient.registerItemRenderer(RotaryCraft.powders.itemID, items[0]);
		//MinecraftForgeClient.registerItemRenderer(RotaryCraft.pipeplacer.itemID, items[0]);
		MinecraftForgeClient.registerItemRenderer(RotaryCraft.compacts.itemID, items[0]);
		MinecraftForgeClient.registerItemRenderer(RotaryCraft.extracts.itemID, items[0]);
		MinecraftForgeClient.registerItemRenderer(RotaryCraft.gearunits.itemID, items[0]);

		for (int i = 0; i < ItemRegistry.itemList.length; i++) {
			//ReikaJavaLibrary.pConsole("Registering Item Spritesheet for "+ItemRegistry.itemList[i].name()+" at ID "+(ItemRegistry.itemList[i].getShiftedID()+256)+" with sheet "+ItemRegistry.itemList[i].getTextureSheet());
			MinecraftForgeClient.registerItemRenderer(ItemRegistry.itemList[i].getShiftedID(), items[ItemRegistry.itemList[i].getTextureSheet()]);
		}

		MinecraftForgeClient.registerItemRenderer(RotaryCraft.modextracts.itemID, modOres);
		MinecraftForgeClient.registerItemRenderer(RotaryCraft.modingots.itemID, modOres);
	}

	// Override any other methods that need to be handled differently client side.

	@Override
	public World getClientWorld()
	{
		return FMLClientHandler.instance().getClient().theWorld;
	}

}
