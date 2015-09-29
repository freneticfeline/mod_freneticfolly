package net.unladenswallow.minecraft.freneticfolly.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.unladenswallow.minecraft.freneticfolly.ModFreneticFolly;
import net.unladenswallow.minecraft.freneticfolly.entity.EntityTorchArrow;

public class ItemTorchBow extends ItemCustomBow {

	public ItemTorchBow() {
		super("torchBow", ModFreneticFolly.MODID + ":" + "torch_bow");
		this.setModelVariantCount(3);
	}
	
	@Override
	protected boolean shotIsCritical(int itemUseDuration, float arrowDamage) {
        return false;
	}

	@Override
	protected float getArrowDamage(int itemUseDuration) {
        float f = (float)itemUseDuration / 20.0F;
        f = (f * f + f * 2.0F) / 3.0F;
        if (f > 0.75F)
        {
            f = 0.75F;
        }
        return f;
	}

	@Override
	protected int getModelVariation(int useTime) {
    	if(useTime >= 21) {
    		return 2;
        } else if(useTime > 10) {
            return 1;
        } else {
            return 0;
        }
	}

	@Override
	protected void applyEnchantments(EntityArrow entityarrow, ItemStack stack) {
		// No enchantments apply
	}

	@Override
	protected EntityArrow getNewEntityArrow(World worldIn, EntityPlayer playerIn, float damage, int itemUseDuration) {
		return new EntityTorchArrow(worldIn, playerIn, damage);
	}

	@Override
	protected Item getItemUsedByBow() {
		return ModFreneticFolly.torchArrow;
	}
}
