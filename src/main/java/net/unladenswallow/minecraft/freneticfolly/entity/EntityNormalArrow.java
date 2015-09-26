package net.unladenswallow.minecraft.freneticfolly.entity;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.FMLRelaunchLog;

public class EntityNormalArrow extends EntityArrow {

	public EntityNormalArrow(World worldIn) {
		super(worldIn);
		FMLRelaunchLog.info("EntityNormalArrow <init>(World): I'm just a normal arrow");
	}

    public EntityNormalArrow(World worldIn, EntityLivingBase shooter, float p_i1756_3_) {
    	super(worldIn, shooter, p_i1756_3_);
		FMLRelaunchLog.info("EntityNormalArrow <init>(World, EntityLivingBase, float): I'm just a normal arrow");
    }
}
