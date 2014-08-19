package me.tyler15555.minibosses.item;

import me.tyler15555.minibosses.util.Resources;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;

public class ItemFeederSword extends ItemSword {

	public ItemFeederSword() {
		super(ToolMaterial.EMERALD);
		setUnlocalizedName("feederSword");
		setTextureName("minibosses:feeder_sword");
	}
	
	@Override
	public boolean hitEntity(ItemStack stack, EntityLivingBase attackedEntity, EntityLivingBase attacker) {
		super.hitEntity(stack, attackedEntity, attacker);
		attacker.heal(3.5F);
		return true;
	}
	
	@Override
	public CreativeTabs[] getCreativeTabs() {
		return new CreativeTabs[] {Resources.tabMB, CreativeTabs.tabCombat};
	}

}
