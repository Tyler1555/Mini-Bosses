package me.tyler15555.minibosses.entity;

import me.tyler15555.minibosses.util.IMiniboss;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class EntityLivingBlock extends EntityMob implements IMiniboss {
	
	public EntityLivingBlock(World par1World) {
		super(par1World);
		this.tasks.addTask(0, new EntityAIWander(this, 1.0D));
		this.tasks.addTask(1, new EntityAISwimming(this));
		this.tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityPlayer.class, 1.0D, false));
		this.targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, true));
	}
	
	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getAttributeMap().getAttributeInstance(SharedMonsterAttributes.maxHealth).setBaseValue(20);
		this.getAttributeMap().getAttributeInstance(SharedMonsterAttributes.movementSpeed).setBaseValue(0.49D);
		this.getAttributeMap().getAttributeInstance(SharedMonsterAttributes.attackDamage).setBaseValue(4);
	}
	
	@Override
	public void entityInit() {
		super.entityInit();
		this.getDataWatcher().addObject(12, Integer.valueOf(0));
	}
	
	public void setBlockType(int type) {
		this.getDataWatcher().updateObject(12, Integer.valueOf(type));
	}
	
	public int getBlockType() {
		return this.getDataWatcher().getWatchableObjectInt(12);
	}
	
	@Override
	public void writeToNBT(NBTTagCompound tag) {
		super.writeToNBT(tag);
		tag.setInteger("Type", this.getDataWatcher().getWatchableObjectInt(12));
	}
	
	@Override
	public void readFromNBT(NBTTagCompound tag) {
		super.readFromNBT(tag);
		this.getDataWatcher().updateObject(12, Integer.valueOf(tag.getInteger("Type")));
	}
	
	@Override
	public Item getDropItem() {
		if(getBlockType() == 0) {
			return Item.getItemFromBlock(Blocks.dirt);
		}
		if(getBlockType() == 1) {
			return Item.getItemFromBlock(Blocks.stone);
		} else {
			return Item.getItemFromBlock(Blocks.dirt);
		}
	}
	
	@Override
	public boolean canDespawn() {
		return false;
	}

	@Override
	public String getBanlistName() {
		return "LivingBlock";
	}

}
