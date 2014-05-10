package me.tyler15555.minibosses.item;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.relauncher.Side;
import me.tyler15555.minibosses.util.ExtendedPlayerProperties;
import me.tyler15555.minibosses.util.Resources;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;

public class ItemOcculus extends Item {

	public ItemOcculus() {
		setCreativeTab(Resources.tabMB);
		setUnlocalizedName("itemOcculus");
		setTextureName("minibosses:occulus");
	}
	
	@Override
	public boolean onLeftClickEntity(ItemStack stack, EntityPlayer player, Entity entity) {
		if(FMLCommonHandler.instance().getEffectiveSide() == Side.SERVER) {
			--stack.stackSize;
			player.addChatMessage(new ChatComponentText("The curse has been passed..."));
			if(entity instanceof EntityLiving) {
				EntityLiving target = (EntityLiving)entity;
				
				target.addPotionEffect(new PotionEffect(Potion.wither.id, 4000));
				target.addPotionEffect(new PotionEffect(Potion.confusion.id, 4000));
				target.addPotionEffect(new PotionEffect(Potion.blindness.id, 4000));
				target.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 4000));
			}
		}
		return true;
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
		if(FMLCommonHandler.instance().getEffectiveSide() == Side.SERVER) {
			--stack.stackSize;
			
			EntityLightningBolt lightning = new EntityLightningBolt(world, player.posX, player.posY, player.posZ + 5);
			
			world.spawnEntityInWorld(lightning);
			
			if(player.getExtendedProperties(ExtendedPlayerProperties.PROP_NAME) != null) {
				ExtendedPlayerProperties props = (ExtendedPlayerProperties) player.getExtendedProperties(ExtendedPlayerProperties.PROP_NAME);
				
				props.setAbilityUsage(props.getAbilityUsageAmount() + 5);
			}
			player.addChatMessage(new ChatComponentText("And so it begins..."));
		}
		
		return stack;
	}

}
