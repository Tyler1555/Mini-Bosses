package me.tyler15555.minibosses.item;

import me.tyler15555.minibosses.common.MiniBosses;
import me.tyler15555.minibosses.util.Resources;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraftforge.common.ISpecialArmor;

public class ItemInfernoArmor extends ItemArmor implements ISpecialArmor {

	public ItemInfernoArmor(int p_i45325_2_) {
		super(Resources.dark_iron, p_i45325_2_, MiniBosses.createInfernoRenderPrefix());
	}

	@Override
	public ArmorProperties getProperties(EntityLivingBase player, ItemStack armor, DamageSource source, double damage, int slot) {
		if(source.isFireDamage()) {
			return new ArmorProperties(1, Integer.MAX_VALUE, MathHelper.floor_double(damage / 0.25D)); //No, having Integer.Max_VALUE does not mean this will absorb all the damage, its there to prevent an overflow in case you somehow take some ungodly amount of damage
		} else {
			return new ArmorProperties(0, 0, 0);
		}
	}

	@Override
	public int getArmorDisplay(EntityPlayer player, ItemStack armor, int slot) {
		return 4;
	}

	@Override
	public void damageArmor(EntityLivingBase entity, ItemStack stack, DamageSource source, int damage, int slot) {
		if(source.isFireDamage()) {
			stack.damageItem(damage * 2, entity);
		} else {
			stack.damageItem(damage, entity);
		}
	}
	
	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type) {
		//return !(stack.getItem() == MBItems.infernoLegs) ? "minibosses:/textures/items/armor/inferno_1.png" : "minibosses:/textures/items/armor/inferno_2.png"; 
		return null;
	}
	
	@Override
	public CreativeTabs[] getCreativeTabs() {
		return new CreativeTabs[] {Resources.tabMB, CreativeTabs.tabCombat};
	}

}
