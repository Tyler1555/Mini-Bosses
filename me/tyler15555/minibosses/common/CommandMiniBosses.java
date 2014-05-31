package me.tyler15555.minibosses.common;

import java.util.List;

import me.tyler15555.minibosses.util.ExtendedPlayerProperties;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChatComponentText;

public class CommandMiniBosses extends CommandBase {

	public CommandMiniBosses() {
		
	}

	@Override
	public int compareTo(Object arg0) {
		return 0;
	}

	@Override
	public String getCommandName() {
		return "minibosses";
	}

	@Override
	public String getCommandUsage(ICommandSender sender) {
		return "Add no arguments to check the version, or use the argument checkpoints to check your occulus points";
	}

	@Override
	public List getCommandAliases() {
		return null;
	}

	@Override
	public void processCommand(ICommandSender sender, String[] args) {
		if(sender instanceof EntityPlayer) {
			sender.addChatMessage(new ChatComponentText("You are running Mini-Bosses version 1.2"));
		}
	}

	@Override
	public boolean canCommandSenderUseCommand(ICommandSender sender) {
		return sender instanceof EntityPlayer;
	}

	@Override
	public List addTabCompletionOptions(ICommandSender var1, String[] var2) {
		return null;
	}

	@Override
	public boolean isUsernameIndex(String[] var1, int var2) {
		return false;
	}

}
