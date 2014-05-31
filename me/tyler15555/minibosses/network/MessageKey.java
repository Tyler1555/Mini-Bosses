package me.tyler15555.minibosses.network;

import me.tyler15555.minibosses.util.ExtendedPlayerProperties;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChatComponentText;
import io.netty.buffer.ByteBuf;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;

//Heavily based on pahmir's MessageKeyPressed
public class MessageKey implements IMessage {

	private int keyCode;
	
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

	

}
