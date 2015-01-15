package me.tyler15555.minibosses.network;

import org.apache.logging.log4j.Level;

import me.tyler15555.minibosses.common.MiniBosses;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;





//Heavily based on pahmir's PacketHandler
public class PacketHandler {

	public PacketHandler() {
		
	}
	
	public static final SimpleNetworkWrapper instance = NetworkRegistry.INSTANCE.newSimpleChannel("MB-Keys");
	
	public static void init() {
		MiniBosses.logger.log(Level.INFO, "Registering packets...");
		instance.registerMessage(MessageKey.class, MessageKey.class, 0, Side.SERVER);
	}

}
