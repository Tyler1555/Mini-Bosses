package me.tyler15555.minibosses.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.MathHelper;

public class MicroBossProperties {

	//What the boss will be wearing
	private ItemStack[] gear;
	
	//Potion effects that will be applied on spawn
	private PotionEffect[] potion_effects;
	
	private int health; //If you want to values to be default, set them to 0
	
	private boolean enchantHeldItem;
	
	private final static Random random = new Random();
	
	//A simple way for mods to add their items to the array of weapons
	public static ArrayList<ItemStack> modWeapons = new ArrayList();
	
	public MicroBossProperties(ItemStack[] items, PotionEffect[] potions, int health, boolean shouldEnchant) {
		this.gear = items;
		this.potion_effects = potions;
		this.health = health;
		this.enchantHeldItem = shouldEnchant;
	}
	
	public void applyToEntity(EntityLivingBase entityLivingBase) {
		for(int index = 0; index < this.gear.length; index++) {
			if(this.gear[index] != null) {
				entityLivingBase.setCurrentItemOrArmor(index, this.gear[index]);
			}
		}
		for(int i = 0; i < this.potion_effects.length; i++) {
			if(this.potion_effects[i] != null) {
				entityLivingBase.addPotionEffect(this.potion_effects[i]);
			}
		}
		if(enchantHeldItem && entityLivingBase.getHeldItem() != null) {
			EnchantmentHelper.addRandomEnchantment(random, entityLivingBase.getHeldItem(), MathHelper.getRandomIntegerInRange(random, 1, 4));
		}
		if(this.health <= 0) {
			entityLivingBase.setHealth(entityLivingBase.getMaxHealth());
		} else {
			entityLivingBase.setHealth(this.health);
		}
	}
	
	
	public static MicroBossProperties generateRandomProperties() {
		ItemStack[] weapons = new ItemStack[] {new ItemStack(Items.diamond_sword), new ItemStack(Items.iron_sword), new ItemStack(Items.diamond_axe), new ItemStack(Items.iron_axe), new ItemStack(Items.stone_sword), new ItemStack(Items.stone_axe)};
		ItemStack[] helmets = new ItemStack[] {new ItemStack(Items.leather_helmet), new ItemStack(Items.diamond_helmet), new ItemStack(Items.chainmail_helmet), new ItemStack(Items.iron_helmet)};
		ItemStack[] chestplates = new ItemStack[] {new ItemStack(Items.leather_chestplate), new ItemStack(Items.diamond_chestplate), new ItemStack(Items.chainmail_chestplate), new ItemStack(Items.iron_chestplate)};
		ItemStack[] leggings = new ItemStack[] {new ItemStack(Items.leather_leggings), new ItemStack(Items.diamond_leggings), new ItemStack(Items.chainmail_leggings), new ItemStack(Items.iron_leggings)};
		ItemStack[] boots = new ItemStack[] {new ItemStack(Items.leather_boots), new ItemStack(Items.diamond_boots), new ItemStack(Items.chainmail_boots), new ItemStack(Items.iron_boots)};
		PotionEffect[] potions = new PotionEffect[] {new PotionEffect(Potion.damageBoost.id, 1000, 4), new PotionEffect(Potion.regeneration.id, 1000, 4), new PotionEffect(Potion.moveSpeed.id, 1000, 4)};

		for(int i = 0; i < modWeapons.size(); i++) {
			Arrays.asList(weapons).add(modWeapons.get(i));
		}
		
		return new MicroBossProperties(new ItemStack[] {weapons[random.nextInt(Math.abs(helmets.length))], helmets[random.nextInt(Math.abs(helmets.length))], chestplates[random.nextInt(Math.abs(chestplates.length))], leggings[random.nextInt(Math.abs(leggings.length))], boots[random.nextInt(Math.abs(boots.length))]}, 
				potions, Math.abs(MathHelper.getRandomIntegerInRange(random, 100, 175)), random.nextBoolean());
	} 
	
}
