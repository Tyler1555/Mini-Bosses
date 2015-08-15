package me.tyler15555.minibosses.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import me.tyler15555.minibosses.item.MBItems;
import me.tyler15555.minibosses.util.IMiniboss;

public class EntityStalker extends EntityMob  implements IMiniboss{

	public EntityStalker(World worldIn) {
		super(worldIn);
		this.tasks.addTask(0, new EntityAIWander(this, 1.0D));
		this.tasks.addTask(1, new EntityAISwimming(this));
		this.tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityPlayer.class, 1.0D, false));
		this.tasks.addTask(3, new EntityAILookIdle(this));
		this.tasks.addTask(4, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		this.targetTasks.addTask(0, new EntityAINearestAttackableTarget(this, EntityPlayer.class, true));
	}
	
	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getAttributeMap().getAttributeInstance(SharedMonsterAttributes.maxHealth).setBaseValue(200D);
		this.getAttributeMap().getAttributeInstance(SharedMonsterAttributes.followRange).setBaseValue(25.5D);
		this.getAttributeMap().getAttributeInstance(SharedMonsterAttributes.attackDamage).setBaseValue(3D);
		this.getAttributeMap().getAttributeInstance(SharedMonsterAttributes.movementSpeed).setBaseValue(.245D);
	}
	
	@Override
	public void onLivingUpdate() {
		super.onLivingUpdate();
		if(!this.worldObj.isRemote && !this.worldObj.isDaytime()) {
			this.addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 500));
		}
	}
	
	@Override
	public boolean attackEntityAsMob(Entity entity) {
		if(entity instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer)entity;
			player.attackEntityFrom(DamageSource.outOfWorld, (float) this.getAttributeMap().getAttributeInstance(SharedMonsterAttributes.attackDamage).getAttributeValue()); //Void damage bypasses armor
		}
		return true;
	}
	
	@Override
	public void knockBack(Entity p_70653_1_, float p_70653_2_, double p_70653_3_, double p_70653_5_) {
		return; //Stops knockback from occuring
	}
	
	@Override
	public boolean attackEntityFrom(DamageSource source, float amt) {
		if(this.rand.nextInt(9) == 1) {
			this.heal(amt);
			return super.attackEntityFrom(source, amt);
		}
		return super.attackEntityFrom(source, amt);
	}

	@Override
	public String getBanlistName() {
		return "Stalker";
	}

	@Override
	public ItemStack getPossibleLoot() {
		return new ItemStack(MBItems.occulus_item);
	}

	@Override
	public int getDropChance() {
		return 80;
	}

}
