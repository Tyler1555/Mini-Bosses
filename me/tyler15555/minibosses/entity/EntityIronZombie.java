package me.tyler15555.minibosses.entity;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import me.tyler15555.minibosses.item.MBItems;
import me.tyler15555.minibosses.util.Resources;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class EntityIronZombie extends EntityZombie {

	public EntityIronZombie(World par1World) {
		super(par1World);
	}
	
	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(6.5D);
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(100D);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(.45D);
	}
	
	@Override
	protected void entityInit() {
		super.entityInit();
		this.getDataWatcher().addObject(15, Integer.valueOf(0));
	}
	
	@Override
	public void onLivingUpdate() {
		super.onLivingUpdate();
		
		if(this.isBurning()) {
			this.extinguish();
		}
		if(!this.worldObj.isDaytime() && this.isDarkIron()) {
			this.addPotionEffect(new PotionEffect(Potion.damageBoost.id, 2000));
			this.addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 2000));
		}
		if(FMLCommonHandler.instance().getEffectiveSide() == Side.CLIENT && this.isDarkIron()) {
			this.worldObj.spawnParticle("largesmoke", this.posX, this.posY, this.posZ, 0, 0, 0);
		}
	}
	
	public boolean isDarkIron() {
		return this.getDataWatcher().getWatchableObjectInt(15) == 1;
	}
	
	
	public void setDarkIron() {
		this.getDataWatcher().updateObject(15, Integer.valueOf(1));
	}
	
	@Override
	public boolean attackEntityFrom(DamageSource source, float damage) {
		super.attackEntityFrom(source, damage);
		if(source.getEntity() != null && source.getEntity() instanceof EntityPlayer) {
			EntityPlayer entity = (EntityPlayer)source.getEntity();
			
			if(entity.getHeldItem() != null && this.rand.nextInt(19) == 1 && this.getDistanceToEntity(entity) <= 5.5D && this.getHeldItem() == null) {
				this.setCurrentItemOrArmor(0, entity.getHeldItem());
				entity.destroyCurrentEquippedItem();
			}
			if(this.rand.nextInt(19) == 1) {
				this.setDarkIron();
			}
		}
		return true;
	}
	
	/*
	public boolean getCanSpawnHere() {
		if(Resources.entityBlockList.containsKey("IronZombie") && Resources.entityBlockList.get("IronZombie") == this.worldObj.provider.dimensionId) {
			return false;
		} else {
			return super.getCanSpawnHere();
		}
	} */
	
	@Override
	public void writeToNBT(NBTTagCompound tag) {
		super.writeToNBT(tag);
		tag.setInteger("isDarkIron", this.dataWatcher.getWatchableObjectInt(15));
	}
	
	@Override
	public void readFromNBT(NBTTagCompound tag) {
		super.readFromNBT(tag);
		if(tag.getInteger("isDarkIron") == 1) {
			this.getDataWatcher().updateObject(15, Integer.valueOf(1));
		} else {
			this.getDataWatcher().updateObject(15, Integer.valueOf(0));
		}
	}
	
	@Override
	protected Item getDropItem() {
		return MBItems.ingotDarkIron;
	}
	
	@Override
	public void dropFewItems(boolean hitRecently, int looting) {
		if(hitRecently) { //No mob farms for you
			this.dropItem(MBItems.ingotDarkIron, this.rand.nextInt(2));
		}
	}
	
	@Override
	public boolean canDespawn() {
		return false;
	}
	
	@Override
	public void setDead() {
		super.setDead();
		if(this.getHeldItem() != null) {
			this.dropItem(this.getHeldItem().getItem(), 1);
		}
	}

}
