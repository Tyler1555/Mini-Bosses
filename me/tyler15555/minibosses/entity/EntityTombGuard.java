package me.tyler15555.minibosses.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.monster.EntitySilverfish;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class EntityTombGuard extends EntitySilverfish {

	public EntityTombGuard(World p_i1740_1_) {
		super(p_i1740_1_);
	}
	
	@Override
	protected void attackEntity(Entity entity, float damage) { //Not entirely sure if that float parameter is correct
		if(this.rand.nextInt(3) == 1 && entity instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer)entity;
			int[] possibleEffects = new int[] {Potion.blindness.id, Potion.poison.id, Potion.digSlowdown.id, Potion.weakness.id, Potion.confusion.id};
			
			player.addPotionEffect(new PotionEffect(possibleEffects[this.rand.nextInt(possibleEffects.length)], 500, 4));
		}
	}

}
