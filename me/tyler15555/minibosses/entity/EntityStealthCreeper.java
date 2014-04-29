package me.tyler15555.minibosses.entity;

import me.tyler15555.minibosses.util.Resources;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class EntityStealthCreeper extends EntityCreeper {

	public EntityStealthCreeper(World par1World) {
		super(par1World);
	}
	
	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getAttributeMap().getAttributeInstance(SharedMonsterAttributes.maxHealth).setBaseValue(12.0D);
	}
	
	@Override
	public void onLivingUpdate() {
		super.onLivingUpdate();
		if(this.getAttackTarget() != null) {
			this.addPotionEffect(new PotionEffect(Potion.invisibility.id, 5));
		}
	}
	
	@Override
	public Item getDropItem() {
		return Items.golden_carrot;
	}
	
	@Override
	public boolean getCanSpawnHere() {
		if(Resources.entityBlockList.containsKey("StealthCreeper")) {
			if(Resources.entityBlockList.get("StealthCreeper") == this.worldObj.provider.dimensionId) {
				return false;
			}
		}
		return super.getCanSpawnHere();
	}

}
