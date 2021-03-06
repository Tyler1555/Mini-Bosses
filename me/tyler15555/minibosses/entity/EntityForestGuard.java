package me.tyler15555.minibosses.entity;

import java.util.ArrayList;

import me.tyler15555.minibosses.item.MBItems;
import me.tyler15555.minibosses.util.ConfigHelper;
import me.tyler15555.minibosses.util.IMiniboss;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.util.BlockPos;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EntityDamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.IShearable;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.relauncher.Side;



public class EntityForestGuard extends EntityMob implements IShearable, IMiniboss {
	
	public EntityForestGuard(World par1World) {
		super(par1World);
		this.tasks.addTask(0, new EntityAISwimming(this));
		this.tasks.addTask(1, new EntityAIAttackOnCollide(this, EntityPlayer.class, 1.0D, false));
		this.tasks.addTask(2, new EntityAIWander(this, 1.0D));
		this.tasks.addTask(3, new EntityAILookIdle(this));
		this.tasks.addTask(8, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		this.targetTasks.addTask(0, new EntityAINearestAttackableTarget(this, EntityPlayer.class, true));
	}
	
	@Override
	public void entityInit() {
		super.entityInit();
		this.dataWatcher.addObject(12, Integer.valueOf(0));
		this.dataWatcher.addObject(13, Integer.valueOf(0));
	}
	
	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(7.5D);
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(135D);
		this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(6.5D);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.4375D);
	}
	
	@Override
	public void writeToNBT(NBTTagCompound tag) {
		super.writeToNBT(tag);
		tag.setInteger("shearCount", this.dataWatcher.getWatchableObjectInt(12));
		tag.setInteger("hasBeenAttacked", this.getDataWatcher().getWatchableObjectInt(13));
	}
	
	@Override
	public void readFromNBT(NBTTagCompound tag) {
		super.readFromNBT(tag);
		this.getDataWatcher().updateObject(12, Integer.valueOf(tag.getInteger("shearCount")));
		this.dataWatcher.updateObject(13, Integer.valueOf(tag.getInteger("hasBeenAttacked")));
	}
	
	@Override
	public void knockBack(Entity p_70653_1_, float p_70653_2_, double p_70653_3_, double p_70653_5_) {
		return; //Stops knockback from occuring
	}
	
	@Override
	public void onLivingUpdate() {
		super.onLivingUpdate();
		if(this.worldObj.isRaining() || this.isInWater()) {
			this.addPotionEffect(new PotionEffect(Potion.regeneration.id, 500, 4));
		}
		if(this.worldObj.isDaytime() && this.worldObj.canBlockSeeSky(new BlockPos((int)this.posX, (int)this.posY, (int)this.posZ))) {
			this.addPotionEffect(new PotionEffect(Potion.damageBoost.id, 500, 4));
		}
	}
	
	@Override
	public boolean attackEntityFrom(DamageSource source, float damage) {
		super.attackEntityFrom(source, damage);
		if(source instanceof EntityDamageSource) {
			this.getDataWatcher().updateObject(13, Integer.valueOf(1));
		}
		if(this.rand.nextInt(9) == 1 && source.getEntity() != null) {
			this.setPosition(source.getEntity().posX, source.getEntity().posY, source.getEntity().posZ - 2);
		}
		if(this.rand.nextInt(19) == 1) {
			if(FMLCommonHandler.instance().getSide() == Side.SERVER) {
				for(int i = 0; i < MathHelper.getRandomIntegerInRange(rand, 3, 5); i++) {
					//System.out.println("SHOULD SPAWN");
					EntitySprout sprout = new EntitySprout(this.worldObj);
					
					sprout.setPosition(this.posX, this.posY, this.posZ);
					this.worldObj.spawnEntityInWorld(sprout);
				}
			}
		}
		return true;
	}
	
	@Override
	public void setDead() {
		super.setDead();
		
		if(FMLCommonHandler.instance().getEffectiveSide() == Side.SERVER && this.getDataWatcher().getWatchableObjectInt(13) == 1) {
			int x = (int)this.posX;
			int y = (int)this.posY;
			int z = (int)this.posZ;
			
			for(int i = 0; i < 5; i++) {
				this.worldObj.setBlockState(new BlockPos(x, y + i, z), Blocks.log.getDefaultState());
			}
			this.worldObj.setBlockState(new BlockPos(x, y + 5, z), Blocks.leaves.getDefaultState());
			this.worldObj.setBlockState(new BlockPos(x + 1, y + 4, z), Blocks.leaves.getDefaultState());
			this.worldObj.setBlockState(new BlockPos(x - 1, y + 4, z), Blocks.leaves.getDefaultState());
			this.worldObj.setBlockState(new BlockPos(x, y + 4, z + 1), Blocks.leaves.getDefaultState());
			this.worldObj.setBlockState(new BlockPos(x, y + 4, z - 1), Blocks.leaves.getDefaultState());
			this.worldObj.setBlockState(new BlockPos(x, y + 6, z), Blocks.chest.getDefaultState());
			
			TileEntityChest chest = (TileEntityChest) this.worldObj.getTileEntity(new BlockPos(x, y + 6, z));
			if(chest != null) {
				ItemStack stack = this.getLoot();
				EnchantmentHelper.addRandomEnchantment(rand, stack, 2);
				chest.setInventorySlotContents(1, stack);
				chest.setInventorySlotContents(0, new ItemStack(Blocks.sapling));
				chest.setInventorySlotContents(2, new ItemStack(Items.bone, 4));
			}
		}
	}

	@Override
	public boolean isShearable(ItemStack item, IBlockAccess world, BlockPos pos) {
		return this.getDataWatcher().getWatchableObjectInt(12) < 4;
	}

	@Override
	public ArrayList<ItemStack> onSheared(ItemStack item, IBlockAccess world, BlockPos pos, int fortune) {
		ArrayList<ItemStack> ret = new ArrayList();
		
		ret.add(new ItemStack(Blocks.leaves));
		ret.add(new ItemStack(Blocks.log));
		
		this.getDataWatcher().updateObject(12, Integer.valueOf(this.getDataWatcher().getWatchableObjectInt(12) + 1));
		return ret;
	}
	
	/*
	@Override
	public boolean getCanSpawnHere() {
		if(Resources.entityBlockList.containsKey("ForestGuard") && Resources.entityBlockList.get("ForestGuard") == this.worldObj.provider.dimensionId) {
			return false;
		} else {
			return super.getCanSpawnHere();
		}
	} */

	@Override
	public String getBanlistName() {
		return "ForestGuard";
	}

	@Override
	public ItemStack getPossibleLoot() {
		return new ItemStack(MBItems.dodgeGem);
	}

	@Override
	public int getDropChance() {
		return 60;
	}
	
	private ItemStack getLoot() {
		return this.rand.nextInt(100) >= ConfigHelper.mobLootRarity ? new ItemStack(Items.diamond_axe) : new ItemStack(Items.iron_axe);
	}
}
