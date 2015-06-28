package me.tyler15555.minibosses.util;

import java.lang.reflect.InvocationTargetException;

import me.tyler15555.minibosses.entity.EntitySuperSlime;

import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;


public class SummonEntry {

	private static Class entityClass;
	private static String summon;
	private static int bCost;
	private static int lReq;
	
	public SummonEntry(Class clazz, String summonName, int bloodCost, int levelReq) {
		entityClass = clazz;
		summon = summonName;
		bCost = bloodCost;
		lReq = levelReq;
	}
	
	public void doSummon(int blood, int level, World world, int x, int y, int z) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		if(blood >= bCost && level >= lReq) {
			Entity monster = (Entity) entityClass.getConstructor(World.class).newInstance(world);
			monster.setPosition(x, y, z);
			if(monster instanceof EntitySuperSlime) {
				EntitySuperSlime slime = (EntitySuperSlime)monster;
				slime.setSlimeSize(MathHelper.getRandomIntegerInRange(slime.getRNG(), 10, 15));
			}
			world.spawnEntityInWorld(monster);
		}
	}
	
	@Override
	public String toString() {
		return entityClass.getName() + ":" + summon + ":" + bCost + ":" + lReq;
	} 
}
