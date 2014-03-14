/*******************************************************************************
 * @author Reika Kalseki
 * 
 * Copyright 2014
 * 
 * All rights reserved.
 * Distribution of the software in any form is only allowed with
 * explicit, prior permission from the owner.
 ******************************************************************************/
package Reika.RotaryCraft.TileEntities.Transmission;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;
import Reika.DragonAPI.Interfaces.GuiController;
import Reika.DragonAPI.Libraries.Java.ReikaJavaLibrary;
import Reika.DragonAPI.Libraries.MathSci.ReikaMathLibrary;
import Reika.RotaryCraft.API.ShaftPowerEmitter;
import Reika.RotaryCraft.Auxiliary.Interfaces.SimpleProvider;
import Reika.RotaryCraft.Base.TileEntity.TileEntity1DTransmitter;
import Reika.RotaryCraft.Registry.MachineRegistry;

public class TileEntityMultiClutch extends TileEntity1DTransmitter implements GuiController {

	private int redLevel;

	private int[] control = new int[16];

	@Override
	public void transferPower(World world, int x, int y, int z, int meta) {
		omegain = torquein = 0;
		TileEntity te = this.getTileEntity(readx, ready, readz);
		//ReikaChatHelper.writeBlockAtCoords(worldObj, readx, ready, readz);
		if (this.isProvider(te)) {
			MachineRegistry m = MachineRegistry.getMachine(world, readx, ready, readz);
			if (m == MachineRegistry.SHAFT) {
				TileEntityShaft devicein = (TileEntityShaft)te;
				if (devicein.isCross()) {
					this.readFromCross(devicein);
					return;
				}
				if (devicein.writex == x && devicein.writey == y && devicein.writez == z) {
					torquein = devicein.torque;
					omegain = devicein.omega;
				}
			}
			if (te instanceof SimpleProvider) {
				this.copyStandardPower(worldObj, readx, ready, readz);
			}
			if (m == MachineRegistry.POWERBUS) {
				TileEntityPowerBus pwr = (TileEntityPowerBus)te;
				ForgeDirection dir = this.getInputForgeDirection().getOpposite();
				omegain = pwr.getSpeedToSide(dir);
				torquein = pwr.getTorqueToSide(dir);
			}
			if (te instanceof ShaftPowerEmitter) {
				ShaftPowerEmitter sp = (ShaftPowerEmitter)te;
				if (sp.isEmitting() && sp.canWriteToBlock(xCoord, yCoord, zCoord)) {
					torquein = sp.getTorque();
					omegain = sp.getOmega();
				}
			}
			if (m == MachineRegistry.SPLITTER) {
				TileEntitySplitter devicein = (TileEntitySplitter)te;
				if (devicein.isSplitting()) {
					this.readFromSplitter(devicein);
					return;
				}
				else if (devicein.writex == x && devicein.writez == z) {
					torquein = devicein.torque;
					omegain = devicein.omega;
				}
			}
			omega = omegain;
			torque = torquein;
		}
		else {
			omega = torque = 0;
		}
	}

	public void readFromCross(TileEntityShaft cross) {
		//ModLoader.getMinecraftInstance().thePlayer.addChatMessage(String.format("%d %d %d %d", cross.writex, cross.writex2, cross.writez, cross.writez2));
		if (xCoord == cross.writex && zCoord == cross.writez) {
			omega = cross.readomega[0];
			torque = cross.readtorque[0];
		}
		else if (xCoord == cross.writex2 && zCoord == cross.writez2) {
			omega = cross.readomega[1];
			torque = cross.readtorque[1];
		}
		else
			return; //not its output
	}

	@Override
	public void animateWithTick(World world, int x, int y, int z) {
		if (!this.isInWorld()) {
			phi = 0;
			return;
		}
		phi += ReikaMathLibrary.doubpow(ReikaMathLibrary.logbase(omega+1, 2), 1.05);
	}

	@Override
	public MachineRegistry getMachine() {
		return MachineRegistry.MULTICLUTCH;
	}

	@Override
	public boolean hasModelTransparency() {
		return false;
	}

	@Override
	public int getRedstoneOverride() {
		return 0;
	}

	@Override
	public void updateEntity(World world, int x, int y, int z, int meta) {
		super.updateTileEntity();
		if (world.isRemote)
			return;
		redLevel = world.getBlockPowerInput(x, y, z);
		this.getIOSides(world, x, y, z, meta);
		this.transferPower(world, x, y, z, meta);
	}

	private void getIOSides(World world, int x, int y, int z, int meta) {
		ready = y;
		switch(meta) {
		case 0:
			readx = x+1;
			readz = z;
			break;
		case 1:
			readx = x-1;
			readz = z;
			break;
		case 2:
			readx = x;
			readz = z+1;
			break;
		case 3:
			readx = x;
			readz = z-1;
			break;
		}

		switch(control[redLevel]) {
		case 0:
			writex = x;
			writey = y-1;
			writez = z;
			break;
		case 1:
			writex = x;
			writey = y+1;
			writez = z;
			break;
		case 2:
			writex = x;
			writey = y;
			writez = z-1;
			break;
		case 3:
			writex = x;
			writey = y;
			writez = z+1;
			break;
		case 4:
			writex = x-1;
			writey = y;
			writez = z;
			break;
		case 5:
			writex = x+1;
			writey = y;
			writez = z;
			break;
		}
	}

	public void setSideOfState(int state, int side) {
		if (side >= 6) {
			ReikaJavaLibrary.pConsole("INVALID SIDE "+side+"!");
		}
		if (state >= 16) {
			ReikaJavaLibrary.pConsole("INVALID STATE "+state+"!");
		}
		control[state] = side;
	}

	@Override
	protected void writeSyncTag(NBTTagCompound NBT)
	{
		super.writeSyncTag(NBT);

		NBT.setIntArray("set", control);
	}

	@Override
	protected void readSyncTag(NBTTagCompound NBT)
	{
		super.readSyncTag(NBT);

		control = NBT.getIntArray("set");
	}

	public int getSideOfState(int state) {
		return control[state];
	}

	public int getNextSideForState(int state) {
		if (control[state] == 5)
			return 0;
		else
			return control[state]+1;
	}

}
