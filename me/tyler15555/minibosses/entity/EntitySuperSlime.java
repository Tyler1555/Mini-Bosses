package me.tyler15555.minibosses.entity;

import me.tyler15555.minibosses.block.MBBlocks;
import me.tyler15555.minibosses.item.MBItems;
import me.tyler15555.minibosses.util.IMiniboss;
import me.tyler15555.minibosses.util.Resources;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.EntitySlime;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class EntitySuperSlime extends EntitySlime implements IMiniboss {

	public EntitySuperSlime(World par1World) {
		super(par1World);
	}
	
	@Override
	public void setDead() {
		this.isDead = true;
	}
	
	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getAttributeMap().getAttributeInstance(SharedMonsterAttributes.maxHealth).setBaseValue(125D);
	}
	
	@Override
	public void onCollideWithPlayer(EntityPlayer player) {
		super.onCollideWithPlayer(player);
		if(this.rand.nextInt(10) == 1) {
			player.knockBack(player, 10.5F, 10.5F, 10.5F);
		}
	}
	
	@Override
	public void entityInit() {
		super.entityInit();
		this.setSlimeSize(MathHelper.getRandomIntegerInRange(rand, 10, 14));
	}
	
	@Override
	public void onLivingUpdate() {
		super.onLivingUpdate();
		
		int minionSpawnCounter = 0;

		if(this.rand.nextInt(24) == 1) {
			minionSpawnCounter++;
			if(minionSpawnCounter >= 10 && this.getAttackTarget() != null && !this.worldObj.isRemote) {
				EntitySlime slime = new EntitySlime(this.worldObj);
				slime.copyLocationAndAnglesFrom(this);
				this.worldObj.spawnEntityInWorld(slime);
				minionSpawnCounter = 0;
			}
		}
	}
	/*
	
	@Override
	public boolean getCanSpawnHere() {
		super.getCanSpawnHere();
		if(Resources.entityBlockList.containsKey("SuperSlime")) {
			return Resources.entityBlockList.get("SuperSlime") == this.worldObj.provider.dimensionId;
		} else {
			return true;
		}
	} */
	
	@Override
	public Item getDropItem() {
		return Item.getItemFromBlock(MBBlocks.blockSlime);
	}
	
	@Override
	public void dropFewItems(boolean hitRecently, int looting) {
		if(hitRecently) {
			this.dropItem(Item.getItemFromBlock(MBBlocks.blockSlime), this.rand.nextInt(2));
			this.dropItem(Items.slime_ball, this.rand.nextInt(9));
		}
	}
	
	@Override
	public boolean canDespawn() {
		return false;
	}

	@Override
	public String getBanlistName() {
		return "SuperSlime";
	}

	@Override
	public ItemStack getPossibleLoot() {
		return new ItemStack(MBItems.reviveHeart);
	}

	@Override
	public int getDropChance() {
		return 85;
	}

}
