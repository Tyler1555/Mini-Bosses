package me.tyler15555.minibosses.entity;

import java.util.Random;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.relauncher.Side;
import me.tyler15555.minibosses.block.MBBlocks;
import me.tyler15555.minibosses.util.WorldGenHelper;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EntityFlying;
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
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
//More or less, this mob is a debug entity now
public class EntityGlider extends EntityMob {

	public EntityGlider(World par1World) {
		super(par1World);
		this.tasks.addTask(0, new EntityAIWander(this, 1.0D));
		this.tasks.addTask(1, new EntityAISwimming(this));
		this.tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityPlayer.class, 1.0D, false));
		this.tasks.addTask(3, new EntityAILookIdle(this));
		this.tasks.addTask(4, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		this.targetTasks.addTask(0, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, true));
	}
	
	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getAttributeMap().getAttributeInstance(SharedMonsterAttributes.maxHealth).setBaseValue(11D);
		this.getAttributeMap().getAttributeInstance(SharedMonsterAttributes.followRange).setBaseValue(10.5D);
		this.getAttributeMap().getAttributeInstance(SharedMonsterAttributes.attackDamage).setBaseValue(3.5D);
		this.getAttributeMap().getAttributeInstance(SharedMonsterAttributes.movementSpeed).setBaseValue(.495D);
	}
	
	
	@Override
	public void setDead() {
		Random random = new Random();
		
		super.setDead();
		int X = (int) this.posX;
		int Y = (int) this.posY;
		int Z = (int) this.posZ;
		
		//if(world.getBlock(posX, posY, posZ) == Blocks.stone) {
			WorldGenHelper.generateSolidCube(worldObj, X, Y, Z, MBBlocks.cryptStone, 8, 8, 8);
			worldObj.setBlock(X + 4, Y + 4, Z + 4, Blocks.chest);
			
			TileEntityChest chest = (TileEntityChest) worldObj.getTileEntity(X + 4, Y + 4, Z + 4);
			
			if(chest != null) { //So we don't crash the game if another structure overwrites the chest
				Item[] sibleLoot = new Item[] {Items.diamond, Items.gold_ingot, Items.iron_ingot, Items.emerald, Items.bone, Items.coal, Items.rotten_flesh, Items.carrot, Items.golden_apple};
				
				for(int i = 0; i < MathHelper.getRandomIntegerInRange(random, 1, 9); i++) {
					chest.setInventorySlotContents(i, new ItemStack(sibleLoot[random.nextInt(sibleLoot.length)], MathHelper.getRandomIntegerInRange(random, 1, 5)));
				}
			//}
			//System.out.println("Generated Tomb at: " + posX + " " + posY + " " + posZ);
		}
	}
}
