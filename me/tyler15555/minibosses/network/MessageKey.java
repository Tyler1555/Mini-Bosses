package me.tyler15555.minibosses.network;

import io.netty.buffer.ByteBuf;
import me.tyler15555.minibosses.util.ExtendedPlayerProperties;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChatComponentText;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;





//Heavily based on pahmir's MessageKeyPressed
public class MessageKey implements IMessage, IMessageHandler<MessageKey, IMessage> {

	private int keyCode;
	
	public MessageKey() {
		
	}
	
	public MessageKey(int code) {
		keyCode = code;
	}

	@Override
	public void fromBytes(ByteBuf buf) {
		this.keyCode = buf.readByte();
	}

	@Override
	public void toBytes(ByteBuf buf) {
		buf.writeByte(keyCode);
	}

	@Override
	public IMessage onMessage(MessageKey message, MessageContext ctx) {
        EntityPlayer player = (EntityPlayer)ctx.getServerHandler().playerEntity;
		
		if(player.getExtendedProperties(ExtendedPlayerProperties.PROP_NAME) != null) {
			ExtendedPlayerProperties props = (ExtendedPlayerProperties) player.getExtendedProperties(ExtendedPlayerProperties.PROP_NAME);
			
			props.togglePowers();
			player.addChatMessage(new ChatComponentText("Powers have been toggled to state: " + props.getPowersEnabled()));
		}
		return this;
	}

}
