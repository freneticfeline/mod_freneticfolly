package net.unladenswallow.minecraft.freneticfolly.entity;

import net.minecraft.block.Block;
import net.minecraft.block.BlockTorch;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemEnderPearl;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityEndermite;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.FMLRelaunchLog;
import net.unladenswallow.minecraft.freneticfolly.ModFreneticFolly;

public class EntityTeleportArrow extends EntityCustomArrow {

	public EntityTeleportArrow(World worldIn, EntityLivingBase shooter, float p_i1756_3_) {
		super(worldIn, shooter, p_i1756_3_);
		unlocalizedName = "teleportArrow";
//		MEMLogger.info("EntityTorchArrow [" + System.identityHashCode(this) + "] <init>(3 params)"); 
//		Thread.dumpStack();
	}

//	public EntityTorchArrow(World worldIn) {
//		super(worldIn);
//		unlocalizedName = "torchArrow";
////		MEMLogger.info("EntityTorchArrow [" + System.identityHashCode(this) + "] <init>(1 param)"); 
////		Thread.dumpStack();
//	}
	
	@Override
    protected void handleInTileState(Block block, EnumFacing facing) {
//    	MEMLogger.info("EntityTorchArrow [" + System.identityHashCode(this) + "] handleInTileState(): Impact facing = " + facing);
//        BlockPos blockpos = new BlockPos(this.xTile, this.yTile+1, this.zTile);
//    	MEMLogger.info("EntityTorchArrow handleInTileState(): Let's spawn a torch block at " + facingBlockPos);
        for (int i = 0; i < 32; ++i)
        {
            this.worldObj.spawnParticle(EnumParticleTypes.PORTAL, this.posX, this.posY + this.rand.nextDouble() * 2.0D, this.posZ, this.rand.nextGaussian(), 0.0D, this.rand.nextGaussian(), new int[0]);
        }

        if (!this.worldObj.isRemote)
        {
            if (null != this.shootingEntity && this.shootingEntity instanceof EntityPlayerMP)
            {
                EntityPlayerMP entityplayermp = (EntityPlayerMP)this.shootingEntity;

                if (entityplayermp.playerNetServerHandler.getNetworkManager().isChannelOpen() && entityplayermp.worldObj == this.worldObj && !entityplayermp.isPlayerSleeping())
                {
                    net.minecraftforge.event.entity.living.EnderTeleportEvent event = new net.minecraftforge.event.entity.living.EnderTeleportEvent(entityplayermp, this.posX, this.posY, this.posZ, 5.0F);
                    if (!net.minecraftforge.common.MinecraftForge.EVENT_BUS.post(event))
                    { // Don't indent to lower patch size

                    if (this.shootingEntity.isRiding())
                    {
                    	this.shootingEntity.mountEntity((Entity)null);
                    }

                    this.shootingEntity.setPositionAndUpdate(event.targetX, event.targetY, event.targetZ);
                    this.shootingEntity.fallDistance = 0.0F;
                    }
                }
            }

            this.setDead();
            
        }
	}
	
	@Override
	protected void handleEntityHit(Entity entity) {
//		MEMLogger.info("EntityTorchArrow handleEntityHit()");
		entity.moveEntity(0, 20, 0);
		this.setDead();
	}
}
