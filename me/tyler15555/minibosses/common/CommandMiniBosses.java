package me.tyler15555.minibosses.common;

import me.tyler15555.minibosses.entity.EntityStealthCreeper;
import me.tyler15555.minibosses.entity.EntitySuperSlime;
import me.tyler15555.minibosses.util.IMiniboss;
import me.tyler15555.minibosses.util.Resources;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.Entity;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChatComponentText;

import com.google.common.base.Predicate;

public class CommandMiniBosses extends CommandBase {

	//Just because the code is a bit cleaner with it up here
	public final Predicate filter = new Predicate() {

		public boolean isMiniboss(Entity entity) {
			return entity instanceof IMiniboss || entity instanceof EntitySuperSlime || entity instanceof EntityStealthCreeper;
		}
		
		@Override
		public boolean apply(Object input) {
			return this.isMiniboss((Entity)input);
		}};
	
	public CommandMiniBosses() {
		
	}
	

	@Override
	public int compareTo(Object arg0) {
		return 0;
	}

	@Override
	public String getName() {
		return "minibosses";
	}

	@Override
	public String getCommandUsage(ICommandSender sender) {
		return "Checks the version of this mod. Use /minibosses kill all or an entities name with no spaces to kill all of those entities";
	}

	@Override
	public void execute(ICommandSender sender, String[] args) throws CommandException {
		if(args.length == 0) {
			if(sender instanceof EntityPlayer) {
				sender.addChatMessage(new ChatComponentText("[Mini-Bosses] You are running Mini-Bosses version " + Resources.MOD_VERSION));
				sender.addChatMessage(new ChatComponentText("[Mini-Bosses]If you encounter a bug or need some form of support, please post on our forums located here: http://tinyurl.com/ptm57c6"));
			}
		} else if(args.length == 2 && sender.getEntityWorld() != null) {
			if(args[0].equalsIgnoreCase("kill")) {
				int counter = 0;
				for(Object eo : sender.getEntityWorld().getEntities(Entity.class, filter)) {
					Entity entity = (Entity)eo;
					if(args[1].equalsIgnoreCase("all")) {
						sender.getEntityWorld().removeEntity(entity);
					} else {
						IMiniboss boss = (IMiniboss)entity;
						if(boss.getBanlistName().equalsIgnoreCase(args[1])) {
							sender.getEntityWorld().removeEntity(entity);
						}
					}
					counter++;
				}
				sender.addChatMessage(new ChatComponentText("[Mini-Bosses] Killed " + counter + " entities!"));
				counter = 0;
			}
		}
	}


	@Override
	public boolean isUsernameIndex(String[] var1, int var2) {
		return false;
	}
	
	@Override
	public int getRequiredPermissionLevel() {
		return 2;
	}

}
