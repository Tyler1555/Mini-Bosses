package me.tyler15555.minibosses.common;

import java.util.Random;

import me.tyler15555.minibosses.entity.EntityCrawler;
import me.tyler15555.minibosses.entity.EntityLivingBlock;
import me.tyler15555.minibosses.util.ExtendedPlayerProperties;
import me.tyler15555.minibosses.util.MicroBossProperties;
import me.tyler15555.minibosses.util.Resources;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.EntityEvent.EntityConstructing;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.world.BlockEvent.BreakEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;



public class MBEventHandler {

	private final Random random = new Random();
	
	@SubscribeEvent
	public void onEntitySpawn(EntityJoinWorldEvent event) {
		if(event.entity instanceof EntityZombie || event.entity instanceof EntitySkeleton) {
			if(random.nextInt(19) == 1) {
				EntityLiving entity = (EntityLiving)event.entity;
				MicroBossProperties props = MicroBossProperties.generateRandomProperties();
				props.applyToEntity(entity);
				entity.setCustomNameTag(Resources.generateRandomName(random));
			}
		}
		if(event.entity instanceof EntityHorse && !event.world.isRemote && random.nextInt(19) == 1) {
			EntityHorse horse = (EntityHorse)event.entity;
			EntitySkeleton skeleton = new EntitySkeleton(event.world);
			
			horse.setHorseType(4);
			skeleton.setSkeletonType(0);
			skeleton.copyLocationAndAnglesFrom(horse);
			event.world.spawnEntityInWorld(skeleton);
			horse.setOwnerName(skeleton.getCommandSenderName());
			horse.setHorseTamed(true);
			skeleton.setCurrentItemOrArmor(0, new ItemStack(Items.bow));
			skeleton.mountEntity(horse);
		}
	}
	
	@SubscribeEvent
	public void onEntityConstructing(EntityConstructing event) {
		if(event.entity instanceof EntityPlayer && event.entity.getExtendedProperties(ExtendedPlayerProperties.PROP_NAME) == null) {
			EntityPlayer player = (EntityPlayer)event.entity;
			
			player.registerExtendedProperties(ExtendedPlayerProperties.PROP_NAME, new ExtendedPlayerProperties());
		}
	}
	
	@SubscribeEvent
	public void onBlockBreak(BreakEvent event) {
		if(!event.world.isRemote && random.nextInt(199) == 1) {
			if(event.block == Blocks.dirt) {
				EntityLivingBlock livingBlock = new EntityLivingBlock(event.world);
				
				livingBlock.setBlockType(0);
				livingBlock.setPosition(event.x, event.y, event.z);
				event.world.spawnEntityInWorld(livingBlock);
			}
			if(event.block == Blocks.stone) {
                EntityLivingBlock livingBlockStone = new EntityLivingBlock(event.world);
				
				livingBlockStone.setBlockType(1);
				livingBlockStone.setPosition(event.x, event.y, event.z);
				event.world.spawnEntityInWorld(livingBlockStone);
			}
		}
	}
	
}
