package me.tyler15555.minibosses.network;

import me.tyler15555.minibosses.util.ExtendedPlayerProperties;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChatComponentText;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;

public class MessageKeyHandler implements IMessageHandler<MessageKey, IMessage> {

	public MessageKeyHandler() {
		
	}

	@Override
	public IMessage onMessage(MessageKey message, MessageContext ctx) {
        EntityPlayer player = (EntityPlayer)ctx.getServerHandler().playerEntity;
		
		if(player.getExtendedProperties(ExtendedPlayerProperties.PROP_NAME) != null) {
			ExtendedPlayerProperties props = (ExtendedPlayerProperties) player.getExtendedProperties(ExtendedPlayerProperties.PROP_NAME);
			
			props.togglePowers();
			player.addChatMessage(new ChatComponentText("Toggled powers!"));
		}
		return null;
	}

}
