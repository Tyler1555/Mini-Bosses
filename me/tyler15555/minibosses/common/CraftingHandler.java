package me.tyler15555.minibosses.common;

import java.util.ArrayList;

import me.tyler15555.minibosses.item.MBItems;
import me.tyler15555.minibosses.util.NBTHelper;
import me.tyler15555.minibosses.util.SummonEntry;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.ItemCraftedEvent;

public class CraftingHandler {

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
			if(tableInv.contains(Items.bone) && tableInv.contains(Items.bow)) {
				SummonEntry entry = new SummonEntry(EntitySkeleton.class, "Skeleton", 0, 0);
				NBTHelper.writeStringToStack(event.crafting, "SummonEntry", entry.toString());
			}
		}
	}
	
}
