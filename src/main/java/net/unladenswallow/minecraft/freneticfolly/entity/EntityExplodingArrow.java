package net.unladenswallow.minecraft.freneticfolly.entity;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.FMLRelaunchLog;

public class EntityExplodingArrow extends EntityCustomArrow {

	private float explosionRadius = 1.0f;

	public EntityExplodingArrow(World worldIn, EntityLivingBase shooter, float p_i1756_3_) {
		super(worldIn, shooter, p_i1756_3_);
		unlocalizedName = "explodingArrow";
	}

	public EntityExplodingArrow(World worldIn, EntityLivingBase shooter, float p_i1756_3_, float explosionRadiusModifier) {
		super(worldIn, shooter, p_i1756_3_);
		unlocalizedName = "explodingArrow";
		this.explosionRadius = this.explosionRadius * explosionRadiusModifier;
	}


	@Override
    protected void handleInTileState(Block block, EnumFacing facing) {
//    	FMLRelaunchLog.info("EntityExplodingArrow handleInTileState(): Impact facing = " + facing);
//    	FMLRelaunchLog.info("EntityExplodingArrow handleInTileState(): Let's explode block at [" + this.posX + "," + this.posY + "," + this.posZ + "] with radius " + this.explosionRadius);
    	this.worldObj.createExplosion(this, this.posX, this.posY, this.posZ, this.explosionRadius, true);
    	this.setDead();
	}
	
	@Override
	protected void handleEntityHit(Entity entity) {
//		FMLRelaunchLog.info("EntityTorchArrow handleEntityHit()");
    	this.worldObj.createExplosion(this, this.posX, this.posY, this.posZ, this.explosionRadius, true);
		this.setDead();
	}
}
