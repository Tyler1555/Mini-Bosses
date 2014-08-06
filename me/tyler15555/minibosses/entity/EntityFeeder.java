package me.tyler15555.minibosses.entity;

import me.tyler15555.minibosses.item.MBItems;
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
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.passive.IAnimals;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.item.Item;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class EntityFeeder extends EntityMob implements IRangedAttackMob {

	//TODO: Fix targeting errors, all features involving other mobs are temp disabled
	
	//public int imitatingEntityID;
	
	public EntityAIArrowAttack arrowAI = new EntityAIArrowAttack(this, 1.0D, 20, 60, 15.0F);
	
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
		this.targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, true));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityZombie.class, 0, true));
		this.targetTasks.addTask(3, new EntityAINearestAttackableTarget(this, EntitySkeleton.class, 0, true));
		this.targetTasks.addTask(4, new EntityAINearestAttackableTarget(this, EntityCreeper.class, 0, true));
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
		//this.getDataWatcher().addObject(12, Integer.valueOf(0));
	}
	
	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getAttributeMap().getAttributeInstance(SharedMonsterAttributes.followRange).setBaseValue(9.5D);
		this.getAttributeMap().getAttributeInstance(SharedMonsterAttributes.maxHealth).setBaseValue(150D);
		this.getAttributeMap().getAttributeInstance(SharedMonsterAttributes.movementSpeed).setBaseValue(.625D);
	}
	/*
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
			this.heal(2.0F);
		}
		
	} */
    /*
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
			this.worldObj.spawnParticle("largesmoke", this.posX, this.posY, this.posZ, 0, 0, 0);
		}
		if(this.getImitatingEntityID() == 2) {
			this.worldObj.spawnParticle("portal", this.posX, this.posY, this.posZ, 0, 0, 0);
			
			if(!this.tasks.taskEntries.contains(arrowAI)) {
				this.tasks.addTask(2, arrowAI);
			}
		}
		if(this.getImitatingEntityID() == 3) {
			this.worldObj.spawnParticle("explosion", this.posX, this.posY, this.posZ, 0, 0, 0);
		}
		if(!(this.getImitatingEntityID() == 2) && this.tasks.taskEntries.contains(arrowAI)) {
			this.tasks.removeTask(arrowAI);
		}
	} */

	//Just the skeletons arrow code without the enchantments
	@Override
	public void attackEntityWithRangedAttack(EntityLivingBase entity, float var2) {
		EntityArrow entityarrow = new EntityArrow(this.worldObj, this, entity, 1.6F, (float)(14 - this.worldObj.difficultySetting.getDifficultyId() * 4));
		entityarrow.setDamage((double)(var2 * 2.0F) + this.rand.nextGaussian() * 0.25D + (double)((float)this.worldObj.difficultySetting.getDifficultyId() * 0.11F));
		this.playSound("random.bow", 1.0F, 1.0F / (this.getRNG().nextFloat() * 0.4F + 0.8F));
        this.worldObj.spawnEntityInWorld(entityarrow);
	}
	
	@Override
	public boolean attackEntityFrom(DamageSource source, float damage) {
		super.attackEntityFrom(source, damage);
		/*
		if(this.getImitatingEntityID() == 1 && this.rand.nextInt(19) == 1) {
			if(source.getEntity() != null && source.getEntity() instanceof EntityLiving) {
				EntityLiving entity = (EntityLiving)source.getEntity();
				
				entity.addPotionEffect(new PotionEffect(Potion.poison.id, 500));
			}
		}
		if(this.getImitatingEntityID() == 3 && source.getEntity() != null && this.rand.nextInt(29) == 1) {
			this.worldObj.createExplosion(source.getEntity(), source.getEntity().posX, source.getEntity().posY, source.getEntity().posZ, 3.5F, this.worldObj.getGameRules().getGameRuleBooleanValue("mobGriefing"));
		} */
		
		if(source.getEntity() != null && source.getEntity() instanceof EntityPlayer && this.rand.nextInt(19) == 1) {
			EntityPlayer player = (EntityPlayer)source.getEntity();
			
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
	
}
