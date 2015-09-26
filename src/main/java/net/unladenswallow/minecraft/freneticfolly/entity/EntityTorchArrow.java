package net.unladenswallow.minecraft.freneticfolly.entity;

import net.minecraft.block.Block;
import net.minecraft.block.BlockTorch;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.FMLRelaunchLog;
import net.unladenswallow.minecraft.freneticfolly.ModFreneticFolly;

public class EntityTorchArrow extends EntityCustomArrow {

	public EntityTorchArrow(World worldIn, EntityLivingBase shooter, float p_i1756_3_) {
		super(worldIn, shooter, p_i1756_3_);
		unlocalizedName = "torchArrow";
//		FMLRelaunchLog.info("EntityTorchArrow [" + System.identityHashCode(this) + "] <init>(3 params)"); 
//		Thread.dumpStack();
	}

//	public EntityTorchArrow(World worldIn) {
//		super(worldIn);
//		unlocalizedName = "torchArrow";
////		FMLRelaunchLog.info("EntityTorchArrow [" + System.identityHashCode(this) + "] <init>(1 param)"); 
////		Thread.dumpStack();
//	}
	
	@Override
    protected void handleInTileState(Block block, EnumFacing facing) {
//    	FMLRelaunchLog.info("EntityTorchArrow [" + System.identityHashCode(this) + "] handleInTileState(): Impact facing = " + facing);
        BlockPos blockpos = new BlockPos(this.xTile, this.yTile, this.zTile);
    	BlockPos facingBlockPos = facingBlock(blockpos, facing);
//    	FMLRelaunchLog.info("EntityTorchArrow handleInTileState(): Let's spawn a torch block at " + facingBlockPos);
    	if (facing != EnumFacing.DOWN && Blocks.torch.canPlaceBlockAt(worldObj, facingBlockPos)) {
//    		FMLRelaunchLog.info("EntityTorchArrow handleInTileState(): Torch spawned");
        	worldObj.setBlockState(facingBlockPos, Blocks.torch.getDefaultState().withProperty(BlockTorch.FACING, swapZFacing(facing)));
    	} else {
//    		FMLRelaunchLog.info("EntityTorchArrow handleInTileState(): Oops, can't spawn here");
    		Block.spawnAsEntity(worldObj, facingBlockPos, new ItemStack(ModFreneticFolly.torchArrow));
    	}
    	this.setDead();
	}
	
	@Override
	protected void handleEntityHit(Entity entity) {
//		FMLRelaunchLog.info("EntityTorchArrow handleEntityHit()");
		entity.setFire(10);
		this.setDead();
	}
}
