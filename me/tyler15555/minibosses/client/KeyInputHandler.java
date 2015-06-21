package me.tyler15555.minibosses.client;

import me.tyler15555.minibosses.network.MessageKey;
import me.tyler15555.minibosses.network.PacketHandler;
import me.tyler15555.minibosses.util.KeyType;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.InputEvent.KeyInputEvent;

public class KeyInputHandler {

	public KeyInputHandler() {
		
	}
	
	@SubscribeEvent
	public void onKeyPressed(KeyInputEvent event) {
		if(ClientProxy.toggleBind.isPressed()) {
			PacketHandler.instance.sendToServer(new MessageKey(KeyType.TOGGLE_POWERS.code));
		}
	}
	

}
