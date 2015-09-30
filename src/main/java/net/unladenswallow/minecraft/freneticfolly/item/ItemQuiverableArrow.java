package net.unladenswallow.minecraft.freneticfolly.item;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

/**
 * This class represents an arrow that can be placed into the Bow and Quiver.
 * Specifically, a "quiverable" arrow must provide:
 *  - What entity should spawn when it is used by a Bow and Quiver, including what
 *    damage should be applied to its entity based on time in use of the Bow and Quiver
 *  - What FOV should be displayed based on time in use of the Bow and Quiver
 *  - What the Bow and Quiver's model base name is when using this type of arrow
 *  - What model variant should be used based on time in use of the Bow and Quiver
 *  - What item (possibly itself) should be used in the recipe for restocking the Bow and Quiver
 *  
 *  If there is a non-quiver bow whose behavior we want to mimic, we can use that
 *  to define much of this behavior
 *  
 *  The base ItemQuiverableArrow class represents the special case of the vanilla arrow.
 *  Additional arrow types should extend ItemQuiverableArrow
 *  
 * @author FreneticFeline
 *
 */
public class ItemQuiverableArrow extends Item {

	protected ItemCustomBow bowToMimic;
	protected Item itemUsedByBow;
	
	public ItemQuiverableArrow() {
		this.setUnlocalizedName("vanillaArrow");
		this.bowToMimic = new ItemCustomBow("vanillaBow", "minecraft:bow"){};
		this.itemUsedByBow = Items.arrow;
		this.setCreativeTab(CreativeTabs.tabCombat);
	}
	
	public String getName() {
        return ("" + StatCollector.translateToLocal(this.getUnlocalizedName() + ".name")).trim();
	}
	
	public Item getItemUsedByBow() {
		return this.itemUsedByBow;
	}
	
	public EntityArrow getNewEntityArrow(World worldIn, EntityPlayer playerIn, float damage, int itemUseDuration) {
		return this.getBowToMimick().getNewEntityArrow(worldIn, playerIn, damage, itemUseDuration);
	}

	public String getModelBaseName() {
		return this.getBowToMimick().getModelBaseName();
	}
	
	public int getModelVariation(int useTime) {
    	return this.getBowToMimick().getModelVariation(useTime);
	}

	public float getNewFovModifier(int useTime) {
        return this.getBowToMimick().getNewFovModifier(useTime);
	}

	protected ItemCustomBow getBowToMimick() {
		return this.bowToMimic;
	}
}
