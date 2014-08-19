package me.tyler15555.minibosses.common;

import java.util.Random;

import me.tyler15555.minibosses.entity.EntityCrawler;
import me.tyler15555.minibosses.entity.EntityLivingBlock;
import me.tyler15555.minibosses.util.ConfigHelper;
import me.tyler15555.minibosses.util.ExtendedPlayerProperties;
import me.tyler15555.minibosses.util.IMiniboss;
import me.tyler15555.minibosses.util.MicroBossProperties;
import me.tyler15555.minibosses.util.Resources;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.EntityEvent.EntityConstructing;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.player.PlayerEvent.BreakSpeed;
import net.minecraftforge.event.world.BlockEvent.BreakEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;



public class MBEventHandler {

	private final Random random = new Random();
	
	@SubscribeEvent
	public void onEntitySpawn(EntityJoinWorldEvent event) {
		if(ConfigHelper.microBossesEnabled) {
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
				horse.func_152120_b(skeleton.getCommandSenderName()); //Sets the owner of the horse
				horse.setHorseTamed(true);
				skeleton.setCurrentItemOrArmor(0, new ItemStack(Items.bow));
				skeleton.mountEntity(horse);
			}
			if(event.entity instanceof EntityCreeper && random.nextInt(19) == 1) {
				EntityCreeper creeper = (EntityCreeper)event.entity;
				
				creeper.getDataWatcher().updateObject(17, Byte.valueOf((byte)1));
			}
			if(event.entity instanceof IMiniboss) {
				IMiniboss entity = (IMiniboss)event.entity;
				if(Resources.entityBlockList.containsKey(entity.getBanlistName()) && Resources.entityBlockList.get(entity.getBanlistName()) == event.entity.worldObj.provider.dimensionId) {
					event.entity.setDead();
				}
			}
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
	
	@SubscribeEvent
	public void changeBreakSpeed(BreakSpeed speed) {
		if(speed.entityPlayer.getExtendedProperties(ExtendedPlayerProperties.PROP_NAME) != null) {
			ExtendedPlayerProperties props = (ExtendedPlayerProperties) speed.entityPlayer.getExtendedProperties(ExtendedPlayerProperties.PROP_NAME);
			
			if(props.getAbilityUsageAmount() > 0 && props.getPowersEnabled()) {
				speed.newSpeed = speed.originalSpeed * 2;
				
				if(random.nextInt(149) == 1) {
					props.decreaseAbilityUsage();
				}
			} else {
				speed.newSpeed = speed.originalSpeed;
			}
		}
	}
	
	@SubscribeEvent
	public void onLivingAttack(LivingAttackEvent event) {
		if(event.source.getEntity() != null && event.source.getEntity() instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer)event.source.getEntity();
			
			if(player.getExtendedProperties(ExtendedPlayerProperties.PROP_NAME) != null) {
				ExtendedPlayerProperties props = (ExtendedPlayerProperties) player.getExtendedProperties(ExtendedPlayerProperties.PROP_NAME);
				
				if(props.getAbilityUsageAmount() > 0 && props.getPowersEnabled()) {
					event.entityLiving.setPosition(event.entityLiving.posX, event.entityLiving.posY, event.entityLiving.posZ + 10);
					EntityLightningBolt lightning = new EntityLightningBolt(event.entityLiving.worldObj, event.entityLiving.posX, event.entityLiving.posY, event.entityLiving.posZ);
					
					player.worldObj.spawnEntityInWorld(lightning);
					props.decreaseAbilityUsage();
					
					System.out.println("USAGE REMAINING: " + props.getAbilityUsageAmount());
				}
			}
		}
	}
	
}
