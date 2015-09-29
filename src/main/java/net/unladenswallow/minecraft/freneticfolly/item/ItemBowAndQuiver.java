package net.unladenswallow.minecraft.freneticfolly.item;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemBowAndQuiver extends ItemCustomBow {

	public ItemBowAndQuiver() {
		super("bowAndQuiver", "minecraft:bow");
		this.setMaxDamage(64);
	}

	@Override
    protected boolean isUsableByPlayer(ItemStack stack, EntityPlayer playerIn) {
		/* Damage is being used as "ammo count", so it's usable as long as it isn't fully damaged.
		 * This also means that the bow will never break, because it can't be used the last time. */
		return stack.getItemDamage() < stack.getMaxDamage();
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, EntityPlayer playerIn, List tooltip, boolean advanced) {
		super.addInformation(stack, playerIn, tooltip, advanced);
		int ammoCount = stack.getMaxDamage() - stack.getItemDamage();
		tooltip.add(EnumChatFormatting.GRAY + "Quiver: " + ammoCount + " / " + stack.getMaxDamage() + " arrows");
		if (stack.getItemDamage() > 0) {
			tooltip.add(EnumChatFormatting.GRAY.toString() + EnumChatFormatting.ITALIC.toString()
				+ "Reload with " + Math.min(8, stack.getItemDamage()) + " additional arrow" + (stack.getItemDamage() > 1 ? "s" : ""));
		}
	}

	public void addRepairRecipes() {
		/* Add a recipe for each possible damage amount for the BowAndQuiver */
		for (int i = 1; i <= this.getMaxDamage(); i++) {
			/* Only allow "reloading" 8 arrows at a time, unless there are fewer than 8 missing */
			// TODO: Also allow reloading 3 arrows at a time
			int ammoCount = Math.min(8, i);
			int newDamage = i-ammoCount;
			Object[] params = new Object[ammoCount+1];
			for (int j = 0; j < ammoCount; j++) {
				params[j] = new ItemStack(Items.arrow);
			}
			params[ammoCount] = new ItemStack(this, 1, i);
			GameRegistry.addShapelessRecipe(new ItemStack(this, 1, newDamage), params);
		}
	}

	@Override
	protected void consumeAmmo(ItemStack stack, World worldIn, EntityPlayer playerIn) {
        // Do nothing.  Ammo is "consumed" by the item taking damage
	}

}
