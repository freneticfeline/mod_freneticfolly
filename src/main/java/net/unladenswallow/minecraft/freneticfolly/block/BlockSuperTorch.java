package net.unladenswallow.minecraft.freneticfolly.block;

import net.minecraft.block.BlockTorch;
import net.minecraft.creativetab.CreativeTabs;

/**
 * It would be easier to simply instantiate BlockTorch and set appropriate properties,
 * but unfortunately the BlockTorch constructor is protected, so extending it
 * is the next best solution. 
 */
public class BlockSuperTorch extends BlockTorch {

	public BlockSuperTorch() {
		super();
		this.setLightLevel(1.0f);
		this.setCreativeTab(CreativeTabs.tabDecorations);
		this.setUnlocalizedName("superTorch");
	}
	
}
