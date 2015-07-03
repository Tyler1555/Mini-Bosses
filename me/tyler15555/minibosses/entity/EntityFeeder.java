package me.tyler15555.minibosses.entity;

import me.tyler15555.minibosses.item.MBItems;
import me.tyler15555.minibosses.util.ConfigHelper;
import me.tyler15555.minibosses.util.IMiniboss;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIArrowAttack;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.passive.IAnimals;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.world.World;

public class EntityFeeder extends EntityMob implements IMiniboss {
	
	public int imitatingEntityID;
	private int eatCount;
	private ItemStack[] stomachInv = new ItemStack[10];
	
	public EntityFeeder(World par1World) {
		super(par1World);
		this.tasks.addTask(0, new EntityAISwimming(this));
		this.tasks.addTask(1, new EntityAIWander(this, 1.0D));
		this.tasks.addTask(1, new EntityAIAttackOnCollide(this, EntityPlayer.class, 1.0D, false));
		this.tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityZombie.class, 1.0D, false));
		this.tasks.addTask(3, new EntityAIAttackOnCollide(this, EntitySkeleton.class, 1.0D, false));
		this.tasks.addTask(4, new EntityAIAttackOnCollide(this, EntityCreeper.class, 1.0D, false));
		this.tasks.addTask(5, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		this.tasks.addTask(6, new EntityAILookIdle(this));
		this.targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntityPlayer.class, true));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityZombie.class, true));
		this.targetTasks.addTask(3, new EntityAINearestAttackableTarget(this, EntitySkeleton.class, true));
		this.targetTasks.addTask(4, new EntityAINearestAttackableTarget(this, EntityCreeper.class, true));
	}
	
	/* DATA VALUE TABLE:
	 * 1 = Zombie
	 * 2 = Skeleton
	 * 3 = Creeper
	 * 0 = Nothing(Obviously)
	 */
	@Override
	public void entityInit() {
		super.entityInit();
		this.getDataWatcher().addObject(12, Integer.valueOf(0));
	}
	
	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getAttributeMap().getAttributeInstance(SharedMonsterAttributes.followRange).setBaseValue(9.5D);
		this.getAttributeMap().getAttributeInstance(SharedMonsterAttributes.maxHealth).setBaseValue(150D);
		this.getAttributeMap().getAttributeInstance(SharedMonsterAttributes.movementSpeed).setBaseValue(.425D);
	}
	
	@Override
	public void onKillEntity(EntityLivingBase entity) {
		super.onKillEntity(entity);
		
		if(entity instanceof EntityCreeper) {
			this.getDataWatcher().updateObject(12, Integer.valueOf(3));
		}
		if(entity instanceof EntitySkeleton) {
			this.getDataWatcher().updateObject(12, Integer.valueOf(2));
		}
		if(entity instanceof EntityZombie) {
			this.getDataWatcher().updateObject(12, Integer.valueOf(1));
		}
		if(entity instanceof IAnimals) {
			this.heal(10.0F);
		}
		this.heal(5.0F);
	}
	
	@Override
	public void onDeath(DamageSource source) {
		if(eatCount > 0) {
			for(int index = 0; index < stomachInv.length; index++) {
				ItemStack stack = stomachInv[index];
				EntityItem itemEntity = new EntityItem(this.worldObj, this.posX, this.posY, this.posZ, stack);
				this.worldObj.spawnEntityInWorld(itemEntity);
			}
		}
	}
    
	@Override
	public void writeToNBT(NBTTagCompound tag) {
		super.writeToNBT(tag);
		tag.setInteger("imitatingEntity", this.getImitatingEntityID());
	}
	
	@Override
	public void readFromNBT(NBTTagCompound tag) {
		super.readFromNBT(tag);
		this.setImitatingEntityID(tag.getInteger("imitatingEntity"));
	}
	
	public int getImitatingEntityID() {
		return this.getDataWatcher().getWatchableObjectInt(12);
	}
	
	public void setImitatingEntityID(int id) {
		this.getDataWatcher().updateObject(12, Integer.valueOf(id));
	}
	
	public void onLivingUpdate() {
		super.onLivingUpdate();
		
		if(this.getImitatingEntityID() == 1) {
			this.worldObj.spawnParticle(EnumParticleTypes.SMOKE_LARGE, this.posX, this.posY, this.posZ, 0, 0, 0);
		}
		if(this.getImitatingEntityID() == 2) {
			this.worldObj.spawnParticle(EnumParticleTypes.PORTAL, this.posX, this.posY, this.posZ, 0, 0, 0);
		}
		if(this.getImitatingEntityID() == 3) {
			this.worldObj.spawnParticle(EnumParticleTypes.EXPLOSION_LARGE, this.posX, this.posY, this.posZ, 0, 0, 0);
		}
	}
	
	@Override
	public boolean attackEntityAsMob(Entity entity) {
		super.attackEntityAsMob(entity);
		if(entity instanceof EntityCreeper) {
			entity.attackEntityFrom(DamageSource.causeMobDamage(this), 100F); //Since usually the feeder will not be able to kill a creeper in time, it instakills it. Call it evolution.
		}
		if(this.getImitatingEntityID() == 1 && this.rand.nextInt(19) == 1) {
			if(entity instanceof EntityLiving) {
				EntityLiving entityLiving = (EntityLiving)entity;
				
				entityLiving.addPotionEffect(new PotionEffect(Potion.poison.id, 500));
			}
		}
		if(this.getImitatingEntityID() == 3 && this.rand.nextInt(29) == 1) {
			this.worldObj.createExplosion(entity, entity.posX, entity.posY, entity.posZ, 3.5F, this.worldObj.getGameRules().getGameRuleBooleanValue("mobGriefing"));
		} 
		
		return true;
	}

	
	@Override
	public boolean attackEntityFrom(DamageSource source, float damage) {
		super.attackEntityFrom(source, damage);
		if(source.getEntity() != null && source.getEntity() instanceof EntityPlayer  && this.rand.nextInt(40) == 1 && ConfigHelper.canFeederEatSword) {
			EntityPlayer player = (EntityPlayer)source.getEntity();
			
			stomachInv[eatCount] = player.getHeldItem();
			eatCount++;
			player.destroyCurrentEquippedItem();
			this.heal(4);
		} 
		
		return true;
	}
	
	@Override
	public String getLivingSound() {
		return "minibosses:feederliving";
	}
	
	@Override
	public String getHurtSound() {
		return "minibosses:feederhurt";
	}
	
	@Override
	public String getDeathSound() {
		return "minibosses:feederdeath";
	}
	
	@Override
	public Item getDropItem() {
		return MBItems.feederTooth;
	}

	@Override
	public String getBanlistName() {
		return "Feeder";
	}

	@Override
	public ItemStack getPossibleLoot() {
		return new ItemStack(MBItems.medusaEye);
	}

	@Override
	public int getDropChance() {
		return 85;
	}
	
}
