package net.unladenswallow.minecraft.freneticfolly.block;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.unladenswallow.minecraft.freneticfolly.ModFreneticFolly;

public class BlockEmeraldFountain extends Block {
	
	private static final float SPAWN_CHANCE = 0.15f;
	private static final float BONUS_CHANCE = 0.05f;
/*	private static final float BREAK_CHANCE = 0.001f;
	private static final int MIN_SPAWN_ON_BREAK = 6;
	private static final int MAX_SPAWN_ON_BREAK = 9;
*/
	public BlockEmeraldFountain() {
		super(Material.rock);
		this.setCreativeTab(CreativeTabs.tabBlock);
		this.setUnlocalizedName("emeraldFountain");
		this.setTickRandomly(true);
		this.setHardness(3.0f);
		this.setHarvestLevel("pickaxe", 0);
	}
	
    public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand) {
//    	MEMLogger.info("BlockEmeraldFountain updateTick(): " + pos.toString() + "; worldTime " + worldIn.getTotalWorldTime());
    	BlockPos justAbove = new BlockPos(pos.getX(), pos.getY()+1, pos.getZ());
    	if (rand.nextFloat() < SPAWN_CHANCE) {
//    		MEMLogger.info("BlockEmeraldFountain: BLING! [" + justAbove.getX() + "," + justAbove.getY() + "," + justAbove.getZ() + "]");
        	int numItemsToSpawn = 1;
        	if (rand.nextFloat() < BONUS_CHANCE) {
        		numItemsToSpawn = 3;
//        		MEMLogger.info("BlockEmeraldFountain: BLING! BLING! BLING!");
        	}
        	spawnAsEntity(worldIn, justAbove, new ItemStack(Items.emerald, numItemsToSpawn));
        }
/*    	if (rand.nextFloat() < BREAK_CHANCE) {
    		int numEmeraldsToSpawn = rand.nextInt(MAX_SPAWN_ON_BREAK - MIN_SPAWN_ON_BREAK) + MIN_SPAWN_ON_BREAK;
        	MEMLogger.info("BlockEmeraldFountain: BREAKDOWN! Giving " + numEmeraldsToSpawn + " emeralds");
        	spawnAsEntity(worldIn, justAbove, new ItemStack(Items.emerald, numEmeraldsToSpawn));
    		worldIn.destroyBlock(pos, false);
    	}
*/    }
    
    @SideOnly(Side.CLIENT)
    public void randomDisplayTick(World worldIn, BlockPos pos, IBlockState state, Random rand)
    {
        double d0 = (double)pos.getX() + 0.5D;
        double d1 = (double)pos.getY() + 1.2D;
        double d2 = (double)pos.getZ() + 0.5D;

        worldIn.spawnParticle(EnumParticleTypes.WATER_SPLASH, d0, d1, d2, 0.0D, 0.0D, 0.0D, new int[0]);
        
    }

    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune) {
    	return Item.getItemFromBlock(ModFreneticFolly.emeraldFountain);
    }

   @Override
   public String getHarvestTool(IBlockState state)
   {
       return "pickaxe";
   }

   @Override
   public boolean canHarvestBlock(IBlockAccess world, BlockPos pos, EntityPlayer player)
   {
       return true;
   }

}
