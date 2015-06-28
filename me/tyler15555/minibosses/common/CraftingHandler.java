package me.tyler15555.minibosses.common;

import java.util.ArrayList;

import me.tyler15555.minibosses.item.MBItems;
import me.tyler15555.minibosses.util.NBTHelper;
import me.tyler15555.minibosses.util.SummonEntry;
import me.tyler15555.minibosses.entity.EntitySuperSlime;
import me.tyler15555.minibosses.entity.EntityIronZombie;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.ItemCraftedEvent;
import net.minecraftforge.fml.relauncher.Side;

import org.apache.logging.log4j.Level;

public class CraftingHandler {
	//WARNING: Item.getItemFromBlock() MUST be used when a block is involved with the recipe due to the way Minecraft handles recipes with blocks.
	@SubscribeEvent
	public void onItemCrafted(ItemCraftedEvent event) {
		if(event.crafting.getItem() == MBItems.summonScroll) {
			ArrayList<Item> tableInv = new ArrayList();
			for(int index = 0; index < event.craftMatrix.getSizeInventory(); index++) {
				ItemStack stack = event.craftMatrix.getStackInSlot(index);
				if(stack != null) {
					tableInv.add(stack.getItem());
				}
			}
			if(tableInv.contains(Items.redstone) && tableInv.contains(Item.getItemFromBlock(Blocks.slime_block))) {
				SummonEntry entry = new SummonEntry(EntitySuperSlime.class, "Super Slime", 0, 0);
				NBTHelper.writeStringToStack(event.crafting, "SummonEntry", entry.toString());
			}
			if(tableInv.contains(Items.rotten_flesh) && tableInv.contains(Item.getItemFromBlock(Blocks.iron_block))) {
				SummonEntry entry = new SummonEntry(EntityIronZombie.class, "Iron Zombie", 0, 0);
				NBTHelper.writeStringToStack(event.crafting, "SummonEntry", entry.toString());
			}
		}
	}
	
}
