package net.unladenswallow.minecraft.freneticfolly.item;

import net.minecraft.block.Block;
import net.minecraft.block.BlockCrops;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemSeeds;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

public class ItemSeedling extends ItemSeeds {

	public ItemSeedling(String unlocalizedName, Block cropBlock) {
		super(cropBlock, Blocks.dirt);
		this.setUnlocalizedName(unlocalizedName);
		this.setCreativeTab(CreativeTabs.tabMaterials);
	}

	@Override
    public boolean onItemUse(ItemStack stack, EntityPlayer playerIn, World worldIn, BlockPos pos, EnumFacing side, float hitX, float hitY, float hitZ) {
		boolean rv = super.onItemUse(stack, playerIn, worldIn, pos, side, hitX, hitY, hitZ);
		if (rv) {
			// Immediately grow to 3rd growth stage
			IBlockState state = worldIn.getBlockState(pos.up());
			worldIn.setBlockState(pos.up(), state.withProperty(BlockCrops.AGE, Integer.valueOf(3)), 2);
		}
		return rv;
	}
}
