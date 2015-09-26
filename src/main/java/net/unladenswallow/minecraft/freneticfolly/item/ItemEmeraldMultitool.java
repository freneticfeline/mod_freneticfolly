package net.unladenswallow.minecraft.freneticfolly.item;

import java.util.Set;

import com.google.common.collect.Sets;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemStack;

public class ItemEmeraldMultitool extends ItemEmeraldTool {

	/* These are copied from ItemPickaxe, ItemAxe, and ItemSpade, respectively */
    private static final Set<Block> PICKAXE_EFFECTIVE_ON = Sets.newHashSet(new Block[] {Blocks.activator_rail, Blocks.coal_ore, Blocks.cobblestone, Blocks.detector_rail, Blocks.diamond_block, Blocks.diamond_ore, Blocks.double_stone_slab, Blocks.golden_rail, Blocks.gold_block, Blocks.gold_ore, Blocks.ice, Blocks.iron_block, Blocks.iron_ore, Blocks.lapis_block, Blocks.lapis_ore, Blocks.lit_redstone_ore, Blocks.mossy_cobblestone, Blocks.netherrack, Blocks.packed_ice, Blocks.rail, Blocks.redstone_ore, Blocks.sandstone, Blocks.red_sandstone, Blocks.stone, Blocks.stone_slab});
    private static final Set<Block> AXE_EFFECTIVE_ON = Sets.newHashSet(new Block[] {Blocks.planks, Blocks.bookshelf, Blocks.log, Blocks.log2, Blocks.chest, Blocks.pumpkin, Blocks.lit_pumpkin, Blocks.melon_block, Blocks.ladder});
    private static final Set<Block> SPADE_EFFECTIVE_ON = Sets.newHashSet(new Block[] {Blocks.clay, Blocks.dirt, Blocks.farmland, Blocks.grass, Blocks.gravel, Blocks.mycelium, Blocks.sand, Blocks.snow, Blocks.snow_layer, Blocks.soul_sand});

    public static final ItemPickaxe componentEmeraldPickaxe = new ItemPickaxe(material) { };
    public static final ItemAxe componentEmeraldAxe = new ItemAxe(material) { };
    public static final ItemSpade componentEmeraldSpade = new ItemSpade(material);
    
	public ItemEmeraldMultitool() {
		super(getEffectiveBlocks());
		this.setUnlocalizedName("emeraldMultitool");
		this.setMaxDamage(getMaxDamage() * 2);
	}

	@Override
	public Set<String> getToolClasses(ItemStack stack) {
		Set<String> combinedSet = Sets.union(
				Sets.union(componentEmeraldAxe.getToolClasses(stack), componentEmeraldSpade.getToolClasses(stack)),
				componentEmeraldPickaxe.getToolClasses(stack));
//		FMLRelaunchLog.info("EmeraldMultitool: Reporting tool classes: " + combinedSet);
		return combinedSet;
	}

	@Override
	public boolean canHarvestBlock(Block block) {
//		FMLRelaunchLog.info("EmeraldMultitool: Can I harvest " + block.getLocalizedName() + "? " 
//				+ ((toolCanHarvestBlock(block) || super.canHarvestBlock(block)) ? "yes" : "no"));
		return toolCanHarvestBlock(block)
				|| super.canHarvestBlock(block);
	}
	
	@Override
	public float getStrVsBlock(ItemStack stack, Block block) {
		float maxStrVsBlock = Math.max(
				Math.max(componentEmeraldAxe.getStrVsBlock(stack, block), componentEmeraldPickaxe.getStrVsBlock(stack, block)),
				componentEmeraldSpade.getStrVsBlock(stack, block));
//		FMLRelaunchLog.info("EmeraldMultitool: strVsBlock for " + block.getLocalizedName() + " is " + maxStrVsBlock);
		return maxStrVsBlock;
	}
	
	public boolean toolCanHarvestBlock(Block block) {
		boolean rv = componentEmeraldAxe.canHarvestBlock(block) 
				|| componentEmeraldPickaxe.canHarvestBlock(block)
				|| componentEmeraldSpade.canHarvestBlock(block);
//		FMLRelaunchLog.info("EmeraldMultitool: Can I harvest (as tool) " + block.getLocalizedName() + "? " 
//				+ (rv ? "yes" : "no"));
		return rv;
	}

	private static Set<Block> getEffectiveBlocks() {
		return Sets.union(Sets.union(PICKAXE_EFFECTIVE_ON, AXE_EFFECTIVE_ON), SPADE_EFFECTIVE_ON);
	}

    @Override
    public int getHarvestLevel(ItemStack stack, String toolClass)
    {
        int level = super.getHarvestLevel(stack, toolClass);
        if (level == -1 && toolClass != null && getToolClasses(stack).contains(toolClass))
        {
//        	FMLRelaunchLog.info("EmeraldMultitool: HarvestLevel is " + this.toolMaterial.getHarvestLevel());
            return this.toolMaterial.getHarvestLevel();
        }
        else
        {
//        	FMLRelaunchLog.info("EmeraldMultitool: HarvestLevel (from super) is " + level);
            return level;
        }
    }

    @Override
    public float getDigSpeed(ItemStack stack, net.minecraft.block.state.IBlockState state)
    {
        for (String type : getToolClasses(stack))
        {
            if (state.getBlock().isToolEffective(type, state))
//            	FMLRelaunchLog.info("EmeraldMultitool: DigSpeed is " + efficiencyOnProperMaterial);
                return efficiencyOnProperMaterial;
        }
//    	FMLRelaunchLog.info("EmeraldMultitool: DigSpeed (from super) is " + super.getDigSpeed(stack, state));
        return super.getDigSpeed(stack, state);
    }

}
