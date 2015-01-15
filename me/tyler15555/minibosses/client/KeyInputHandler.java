package me.tyler15555.minibosses.client;

import me.tyler15555.minibosses.network.MessageKey;
import me.tyler15555.minibosses.network.PacketHandler;
import me.tyler15555.minibosses.util.KeyType;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent.KeyInputEvent;
import net.minecraftforge.fml.relauncher.Side;



public class KeyInputHandler {

	public KeyInputHandler() {
		
	}
	
	@SubscribeEvent
	public void onKeyPressed(KeyInputEvent event) {
		if(ClientProxy.toggleBind.isPressed()) {
			PacketHandler.instance.sendToServer(new MessageKey(KeyType.TOGGLE_POWERS.code));
			System.out.println("Message Sent");
		}
	}
	

}
