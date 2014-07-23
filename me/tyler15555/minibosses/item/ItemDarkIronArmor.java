package me.tyler15555.minibosses.item;

import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import me.tyler15555.minibosses.common.MiniBosses;
import me.tyler15555.minibosses.util.Resources;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.common.ISpecialArmor;

public class ItemDarkIronArmor extends ItemArmor implements ISpecialArmor {
	
	public ItemDarkIronArmor(int p_i45325_3_) {
		super(Resources.dark_iron, MiniBosses.createDarkIronRenderPrefix(), p_i45325_3_);
	}

	@Override
	public ArmorProperties getProperties(EntityLivingBase player, ItemStack armor, DamageSource source, double damage, int slot) {
		if(source.getEntity() != null && source.getEntity() instanceof EntityLiving) {
			EntityLiving entity = (EntityLiving)source.getEntity();
			if(entity.getCreatureAttribute() == EnumCreatureAttribute.UNDEAD) {
				return new ArmorProperties(1, Integer.MAX_VALUE, MathHelper.floor_double(damage / 2)); //No, having Integer.Max_VALUE does not mean this will absorb all the damage, its there to prevent an overflow in case you somehow take some ungodly amount of damage
			}
		}
		return new ArmorProperties(0, 0, 0);
	}

	@Override
	public int getArmorDisplay(EntityPlayer player, ItemStack armor, int slot) {
		return 4;
	}

	@Override
	public void damageArmor(EntityLivingBase entity, ItemStack stack,DamageSource source, int damage, int slot) {
		if(entity.worldObj.isDaytime()) {
			stack.damageItem(MathHelper.floor_double(damage * 1.5D), entity);
		} else {
			stack.damageItem(damage, entity);
		}
	}
	
	@Override
	public void onArmorTick(World world, EntityPlayer player, ItemStack armor) {
		if(!world.isDaytime()) {
			if(armor.getItem() == MBItems.darkIronHelm) {
				player.addPotionEffect(new PotionEffect(Potion.nightVision.id, 500));
			}
			if(armor.getItem() == MBItems.darkIronChest) {
				player.addPotionEffect(new PotionEffect(Potion.regeneration.id, 500));
			}
			if(armor.getItem() == MBItems.darkIronLegs) {
				player.addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 500));
			}
			if(armor.getItem() == MBItems.darkIronBoots) {
				player.addPotionEffect(new PotionEffect(Potion.jump.id, 500));
			}
		}
	}
	
	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type) {
		return !(stack.getItem() == MBItems.darkIronLegs) ? "minibosses:textures/armor/dark_iron_1.png" : "minibosses:textures/armor/dark_iron_2.png";
	}
	
	@Override
	public CreativeTabs[] getCreativeTabs() {
		return new CreativeTabs[] {Resources.tabMB, CreativeTabs.tabCombat};
	}

}
