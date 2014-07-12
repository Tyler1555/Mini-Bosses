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
		int x = (int) this.posX;
		int y = (int) this.posY;
		int z = (int) this.posZ;
		
		//if(worldObj.getBlock(x, y, z) == Blocks.stone) {
			WorldGenHelper.generateSolidCube(worldObj, x, y, z, MBBlocks.cryptStone, 8, 8, 8);
			worldObj.setBlock(x + 4, y + 4, z + 4, Blocks.chest);
			//System.out.println("Generated Tomb at: " + posX + " " + posY + " " + posZ);
		//}
	}
}
