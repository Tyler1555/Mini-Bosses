package me.tyler15555.minibosses.common;

import java.util.List;

import me.tyler15555.minibosses.util.ExtendedPlayerProperties;
import me.tyler15555.minibosses.util.Resources;
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
		return "Checks the version of this mod";
	}

	@Override
	public List getCommandAliases() {
		return null;
	}

	@Override
	public void processCommand(ICommandSender sender, String[] args) {
		if(sender instanceof EntityPlayer) {
			sender.addChatMessage(new ChatComponentText("[Mini-Bosses] You are running Mini-Bosses version " + Resources.MOD_VERSION));
			sender.addChatMessage(new ChatComponentText("[Mini-Bosses]If you encounter a bug or need some form of support, please post on our forums located here: http://tinyurl.com/ptm57c6"));
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
