package me.tyler15555.minibosses.network;

import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.relauncher.Side;

//Heavily based on pahmir's PacketHandler
public class PacketHandler {

	public PacketHandler() {
		
	}
	
	public static final SimpleNetworkWrapper instance = NetworkRegistry.INSTANCE.newSimpleChannel("MB-Keys");
	
	public static void init() {
		instance.registerMessage(MessageKey.class, MessageKey.class, 0, Side.SERVER);
	}

}
