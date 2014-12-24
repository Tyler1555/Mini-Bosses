package me.tyler15555.minibosses.entity;

import me.tyler15555.minibosses.item.MBItems;
import me.tyler15555.minibosses.util.IMiniboss;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.monster.EntityIronGolem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.world.World;

public class EntityInfernoGolem extends EntityIronGolem implements IMiniboss {

	public EntityInfernoGolem(World p_i1694_1_) {
		super(p_i1694_1_);
		this.tasks.addTask(0, new EntityAIAttackOnCollide(this, EntityPlayer.class, 1.0D, false));
		this.targetTasks.addTask(0, new EntityAINearestAttackableTarget(this, EntityPlayer.class, true));
	}
	
	@Override
	public Item getDropItem() {
		return MBItems.ingotInferno;
	}
	
	@Override
	public boolean attackEntityAsMob(Entity entity) {
		super.attackEntityAsMob(entity);
		if(this.rand.nextInt(19) == 1) {
			entity.setFire(8);
			return true;
		}
		return true;
	}

	@Override
	public String getBanlistName() {
		return "InfernoGolem";
	}

}
