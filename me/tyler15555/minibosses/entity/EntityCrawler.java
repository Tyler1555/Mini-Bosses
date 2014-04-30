package me.tyler15555.minibosses.entity;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.relauncher.Side;
import me.tyler15555.minibosses.util.Resources;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIBreakDoor;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class EntityCrawler extends EntityMob {

	public EntityCrawler(World par1World) {
		super(par1World);
		this.getNavigator().setBreakDoors(true);
		this.tasks.addTask(0, new EntityAILookIdle(this));
		this.tasks.addTask(1, new EntityAISwimming(this));
		this.tasks.addTask(2, new EntityAIWander(this, 1.0D));
		this.tasks.addTask(3, new EntityAIAttackOnCollide(this, EntityPlayer.class, 1.0D, false));
		this.tasks.addTask(4, new EntityAIBreakDoor(this));
		this.tasks.addTask(5, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		this.targetTasks.addTask(0, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, true));
	}
	
	@Override
	protected void attackEntity(Entity entity, float par2) {
		super.attackEntity(entity, par2);
		if(this.rand.nextInt(74) == 1 && !this.worldObj.isRemote) {
			for(int i = 0; i < 3; i++) {
				EntitySpider spider = new EntitySpider(this.worldObj);
				spider.copyLocationAndAnglesFrom(entity);
				this.worldObj.spawnEntityInWorld(spider);
			}
		}
	}
	
	@Override
	public boolean canDespawn() {
		return false;
	}
	
	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getAttributeMap().getAttributeInstance(SharedMonsterAttributes.attackDamage).setBaseValue(10.0D);
		this.getAttributeMap().getAttributeInstance(SharedMonsterAttributes.maxHealth).setBaseValue(150D);
		this.getAttributeMap().getAttributeInstance(SharedMonsterAttributes.movementSpeed).setBaseValue(0.45D);
	}
	
	@Override
	public String getLivingSound() {
		return "minibosses:crawlerliving";
	}
	
	@Override
	public String getHurtSound() {
		return "minibosses:crawlerhurt";
	}
	
	@Override
	public String getDeathSound() {
		return "minibosses:crawlerdeath";
	}
	
	@Override
	public void setDead() {
		super.setDead();
		
		if(FMLCommonHandler.instance().getEffectiveSide() == Side.SERVER) {
			World world = this.worldObj;
			int x = MathHelper.floor_double(this.posX);
			int y = MathHelper.floor_double(this.posY);
			int z = MathHelper.floor_double(this.posZ);
			
			for(int i = 0; i < 9; i++) {
				world.setBlock(x, y + i, z, Blocks.nether_brick_fence);
			}
			for(int j = 0; j < 3; j++) {
				world.setBlock(x, y + 9, z + j, Blocks.nether_brick_fence);
				world.setBlock(x, y + 9 - j, z + 2, Blocks.web);
			}
			world.setBlock(x, y + 6, z + 2, Blocks.chest);
			
			TileEntityChest chest = (TileEntityChest) world.getTileEntity(x, y + 6, z + 2);
			
			if(chest != null) {
				ItemStack loot1 = new ItemStack(Items.diamond_sword);
				ItemStack loot2 = new ItemStack(Items.golden_apple);
				ItemStack loot3 = new ItemStack(Items.experience_bottle, this.rand.nextInt(2) + 1);
				
				EnchantmentHelper.addRandomEnchantment(this.rand, loot1, 3);
				
				chest.setInventorySlotContents(0, loot1);
				chest.setInventorySlotContents(1, loot2);
				chest.setInventorySlotContents(2, loot3);
			}
		}
	}
	/*
	
	@Override
	public boolean getCanSpawnHere() {
		if(Resources.entityBlockList.containsKey("Crawler")) {
			return Resources.entityBlockList.get("Crawler") == this.worldObj.provider.dimensionId;
		} else {
			return super.getCanSpawnHere();
		}
	} */

}
