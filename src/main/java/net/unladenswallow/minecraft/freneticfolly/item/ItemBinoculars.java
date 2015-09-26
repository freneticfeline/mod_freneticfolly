package net.unladenswallow.minecraft.freneticfolly.item;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.client.event.FOVUpdateEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class ItemBinoculars extends Item {

	public ItemBinoculars() {
		super();
		setUnlocalizedName("binoculars");
		setCreativeTab(CreativeTabs.tabTools);
		setMaxDamage(1000);
		setMaxStackSize(1);
	}

	@Override
    public ItemStack onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn)
    {
		playerIn.setItemInUse(itemStackIn, this.getMaxItemUseDuration(itemStackIn));

        return itemStackIn;
    }

    @Override
    public int getMaxItemUseDuration(ItemStack stack)
    {
        return 72000;
    }

	@SubscribeEvent
	public void fovUpdate(FOVUpdateEvent event) {
		if (event.entity instanceof EntityPlayer) {
			if (event.entity.isUsingItem() && event.entity.getItemInUse().getItem() == this) {
				event.newfov = 0.2f;
			}
		}
	}

}
