package net.unladenswallow.minecraft.freneticfolly.item;

import java.util.List;

import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.IStringSerializable;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.unladenswallow.minecraft.freneticfolly.FFLogger;

public class ItemBowAndQuiver extends ItemCustomBow {

//	protected static int VARIANT_MASK = 1792;
	protected static int DAMAGE_MASK = 255;
	
    public static final PropertyEnum VARIANT = PropertyEnum.create("variant", ItemBowAndQuiver.EnumType.class);

    public ItemBowAndQuiver() {
		super("bowAndQuiver", "minecraft:bow");
		this.setMaxDamage(64);
	}

    @Override
    public String getUnlocalizedName(ItemStack stack)
    {
        return this.getUnlocalizedName() + "." + EnumType.values()[getTypeFromMeta(stack.getMetadata())].getTypeName();
    }


	@Override
    protected boolean isUsableByPlayer(ItemStack stack, EntityPlayer playerIn) {
//		FFLogger.info("ItemBowAndQuiver isUsableByPlayer: maxItemUseDuration = " + this.getMaxItemUseDuration(stack));
		/* Damage is being used as "ammo count", so it's usable as long as it isn't fully damaged.
		 * This also means that the bow will never break, because it can't be used the last time. */
//		FFLogger.info("ItemBowAndQuiver isUsableByPlayer: " 
//				+ (0 != getTypeFromMeta(stack.getMetadata())
//				&& (hasInfiniteArrows(stack, playerIn) || (stack.getItemDamage() < stack.getMaxDamage())
//					       ))
//				+ " (type = " + getTypeFromMeta(stack.getMetadata()) 
//				+ "; stack.getItemDamage() = " + stack.getItemDamage() + "; stack.getMaxDamage() = " + stack.getMaxDamage() + ")");
		return (0 != getTypeFromMeta(stack.getMetadata())
				&& (hasInfiniteArrows(stack, playerIn) || (stack.getItemDamage() < stack.getMaxDamage())
			       ));
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, EntityPlayer playerIn, List tooltip, boolean advanced) {
//		logCurrentStackState(stack);
		super.addInformation(stack, playerIn, tooltip, advanced);
		int ammoCount = stack.getMaxDamage() - stack.getItemDamage();
		int bowType = getTypeFromMeta(stack.getMetadata());
		tooltip.add(EnumChatFormatting.GRAY + "Quiver: "
				+ (bowType == 0 ? "empty"
								: ammoCount + " / " + stack.getMaxDamage() + " " 
								  + EnumChatFormatting.BLUE.toString() + EnumType.values()[bowType].getName() + (stack.getItemDamage() > 1 ? "s" : "")
				  ));
		if (stack.getItemDamage() > 0) {
			tooltip.add(EnumChatFormatting.GRAY.toString() + EnumChatFormatting.ITALIC.toString()
				+ "Reload with " + Math.min(8, stack.getItemDamage()) + (stack.getItemDamage() > 3 ? " or 3" : "")
				+ (bowType == 0 ? " of any type of arrows" 
								: " additional " + EnumType.values()[bowType].getName()	+ (stack.getItemDamage() > 1 ? "s" : "")
				  ));
		}
	}

	private void logCurrentStackState(ItemStack stack) {
		FFLogger.info("The current state of this " + stack.getDisplayName() + " is...\n"
				+ "meta = " + stack.getMetadata() + " [" + dumpMeta(stack.getMetadata()) + "]\n"
				+ "type = " + getTypeFromMeta(stack.getMetadata()) + " (" + EnumType.values()[getTypeFromMeta(stack.getMetadata())].getName() + "); "
				+ "damage = " + stack.getItemDamage() + "; "
				+ "arrowCount = " + getArrowCountFromMeta(stack.getMetadata())
				);
		
	}

	public int getDamage(ItemStack stack) {
		return getDamageFromMeta(stack.getMetadata());
	}
	
	@Override
    public boolean isRepairable()
    {
        return false;
    }
	
	private int getDamageFromMeta(int meta) {
		return meta & DAMAGE_MASK;
	}
	
	private int getTypeFromMeta(int meta) {
		return meta >> 8;
	}
	
	private int getArrowCountFromMeta(int meta) {
		return this.getMaxDamage() - getDamageFromMeta(meta);
	}

	public void addRepairRecipes() {
		/* Add a recipe for each possible damage amount for each variant of the BowAndQuiver */
		Object[] params;
		for (int v = 1; v < ItemBowAndQuiver.EnumType.values().length; v++) {
			FFLogger.info("ItemBowAndQuiver addRepairRecipes(): Adding recipes for type = " + ItemBowAndQuiver.EnumType.values()[v].getName());
			/* First add a recipe for empty quiver and bow and 8 of this variant's arrow item */
			params = new Object[9];
			FFLogger.info("ItemBowAndQuiver addRepairRecipes(): Using " + ItemBowAndQuiver.EnumType.values()[v].getAmmoItem().getUnlocalizedName()
					+ " with meta = " + this.getMaxDamage());
			FFLogger.info("ItemBowAndQuiver addRepairRecipes(): ...to make meta = " + getMetaFromTypeAndDamage(v, this.getMaxDamage() - 8));
			fillParamsArrayWithItems(params, ItemBowAndQuiver.EnumType.META_LOOKUP[v].getAmmoItem());
			params[8] = new ItemStack(this, 1, this.getMaxDamage());
			GameRegistry.addShapelessRecipe(new ItemStack(this, 1, getMetaFromTypeAndDamage(v, this.getMaxDamage() - 8)), params);
			/* Add recipes for adding arrows to this variant of the BowAndQuiver, for each possible damage value of the BowAndQuiver */
			for (int i = 1; i <= this.getMaxDamage(); i++) {
				/* Only allow "reloading" 8 arrows at a time (full crafting table), 
				 * or 3 arrows at a time (full inventory crafting box),
				 * unless there are fewer than 8 missing */
				int ammoCount = Math.min(8, i);
				int newDamage = i-ammoCount;
				params = new Object[ammoCount+1];
//				for (int j = 0; j < ammoCount; j++) {
//					params[j] = new ItemStack(Items.arrow);
//				}
				fillParamsArrayWithItems(params, ItemBowAndQuiver.EnumType.META_LOOKUP[v].getAmmoItem());
				params[ammoCount] = new ItemStack(this, 1, getMetaFromTypeAndDamage(v, i));
				FFLogger.info("ItemBowAndQuiver addRepairRecipes(): Adding recipe for BAQ with meta = "
						+ getMetaFromTypeAndDamage(v, newDamage) + " and " + ammoCount + " of " + ItemBowAndQuiver.EnumType.META_LOOKUP[v].getAmmoItem().getUnlocalizedName());
				GameRegistry.addShapelessRecipe(new ItemStack(this, 1, getMetaFromTypeAndDamage(v, newDamage)), params);
				if (i > 3) {
					params = new Object[4];
					fillParamsArrayWithItems(params, ItemBowAndQuiver.EnumType.META_LOOKUP[v].getAmmoItem());
					params[3] = new ItemStack(this, 1, getMetaFromTypeAndDamage(v, i));
					newDamage = i-3;
					FFLogger.info("ItemBowAndQuiver addRepairRecipes(): Adding recipe for BAQ with meta = "
							+ getMetaFromTypeAndDamage(v, newDamage) + " and " + 3 + " of " + ItemBowAndQuiver.EnumType.META_LOOKUP[v].getAmmoItem().getUnlocalizedName());
					GameRegistry.addShapelessRecipe(new ItemStack(this, 1, getMetaFromTypeAndDamage(v, newDamage)), params);
				}
			}
		}
	}

	private void fillParamsArrayWithItems(Object[] params, Item ammoItem) {
//		FFLogger.info("ItemBowAndQuiver fillParamsArrayWithItems(): adding " + params.length + " instances of " + ammoItem.getUnlocalizedName());
		for (int j = 0; j < params.length; j++) {
			params[j] = new ItemStack(ammoItem);
		}
	}

	@Override
	protected void consumeAmmo(ItemStack stack, World worldIn, EntityPlayer playerIn) {
        // Do nothing.  Ammo is "consumed" by the bow taking damage
	}

	@Override
	protected void takeDamage(int i, ItemStack stack, EntityPlayer playerIn) {
        stack.damageItem(1, playerIn);
        if (stack.getItemDamage() == stack.getMaxDamage()) {
        	FFLogger.info("ItemBowAndQuiver takeDamage(): Quiver empty.  Reverting to default state.");
        	super.setDamage(stack, this.getMaxDamage());
        }
        logCurrentStackState(stack);
	}

	@Override
    public void setDamage(ItemStack stack, int damage)
    {
//		FFLogger.info("ItemBowAndQuiver setDamage: damage = " + dumpMeta(damage));
		/* It seems that the "damage" parameter is sometimes only a damage value, but other times
		 * full metadata, so make sure to mask out just the damage portion. */
		super.setDamage(stack, getMetaFromTypeAndDamage(getTypeFromMeta(stack.getMetadata()), getDamageFromMeta(damage)));
    }


    protected String dumpMeta(int damage) {
		return damage + " [" 
				+ Integer.toBinaryString(damage >> 24) + " (" + Integer.toString(damage >> 24) + ") "
				+ Integer.toBinaryString((damage >> 16) & 255) + " (" + Integer.toString((damage >> 16) & 255) + ") "
				+ Integer.toBinaryString((damage >> 8) & 255) + " (" + Integer.toString((damage >> 8) & 255) + ") "
				+ Integer.toBinaryString(damage & 255) + " (" + Integer.toString(damage & 255) + ")]"
				;
	}
	private int getMetaFromTypeAndDamage(int typeFromMeta, int damage) {
		return (typeFromMeta << 8) + damage;
	}

    @Override
	protected EntityArrow getNewEntityArrow(int stackMeta, World worldIn, EntityPlayer playerIn, float damage, int itemUseDuration) {
		return EnumType.values()[getTypeFromMeta(stackMeta)].getQuiverableArrow().getNewEntityArrow(worldIn, playerIn, damage, itemUseDuration);
	}

    @Override
	protected float getNewFovModifier(int stackMeta, int itemInUseDuration) {
		int type = getTypeFromMeta(stackMeta);
    	if (0 == type) {
//    		FFLogger.info("ItemBowAndQuiver getNewFovModifier: empty bow; newFovModifier = 1.0f");
    		return 1.0f;
    	} else {
//    		FFLogger.info("ItemBowAndQuiver getNewFovModifier: type = " + type);
    		if (type < 0 || type >= EnumType.values().length) {
    			FFLogger.warning("ItemBowAndQuiver getNewFovModifier: Cannot get FOV modifier for out of range type: " + type);
    			return 1.0f;
    		} else {
	    		ItemQuiverableArrow quiverableArrow = EnumType.values()[type].getQuiverableArrow();
	    		if (quiverableArrow == null) {
		    		FFLogger.warning("ItemBowAndQuiver getNewFovModifier: null quiverableArrow for type = " + type);
	    			return 1.0f;
	    		} else {
		    		FFLogger.info("ItemBowAndQuiver getNewFovModifier: quiverableArrow = " + (quiverableArrow == null ? "null" : quiverableArrow.getName()));
			    	FFLogger.info("ItemBowAndQuiver getNewFovModifier: stackMeta = " + stackMeta + "; itemInUseDuration = " + itemInUseDuration
			    			+ "; newFovModifier = " + quiverableArrow.getNewFovModifier(itemInUseDuration));
			    	return quiverableArrow.getNewFovModifier(itemInUseDuration);
	    		}
    		}
    	}
    }

	public static enum EnumType implements IStringSerializable
    {
        EMPTY(0, "empty"),
        ARROW(1, "arrow", new ItemQuiverableArrow()),
		TORCH_ARROW(2, "torchArrow", new ItemTorchArrow()),
		TELEPORT_ARROW(3, "teleportArrow", new ItemTeleportArrow()),
		EXPLODING_ARROW(4, "explodingArrow", new ItemExplodingArrow());
        private static final ItemBowAndQuiver.EnumType[] META_LOOKUP = new ItemBowAndQuiver.EnumType[values().length];
        private final int meta;
        private String typeName;
        private final ItemQuiverableArrow quiverableArrow;

		private EnumType(int meta, String typeName)
        {
            this(meta, typeName, null);
        }

        private EnumType(int meta, String typeName, ItemQuiverableArrow quiverableArrow)
        {
            this.meta = meta;
            this.quiverableArrow = quiverableArrow;
            this.typeName = typeName;
            FFLogger.info("ItemBowAndQuiver:EnumType <init>: given quiverableArrow is " + (quiverableArrow == null ? "null" : quiverableArrow.getName()));
            FFLogger.info("ItemBowAndQuiver:EnumType <init>: my quiverableArrow is " + this.getName());
        }

        public int getMetadata()
        {
            return this.meta;
        }

        public String getTypeName() {
        	return this.typeName;
        }
        
        public String toString()
        {
            return getName();
        }

        public Item getAmmoItem() {
			return this.quiverableArrow == null ? null : this.quiverableArrow.getItemUsedByBow();
		}

        public ItemQuiverableArrow getQuiverableArrow() {
        	return this.quiverableArrow;
        }
        
        public static ItemBowAndQuiver.EnumType byMetadata(int meta)
        {
            if (meta < 0 || meta >= META_LOOKUP.length)
            {
                meta = 0;
            }

            return META_LOOKUP[meta];
        }

        public String getName()
        {
            return this.quiverableArrow == null ? "empty" : this.quiverableArrow.getName();
        }

        public String getUnlocalizedName()
        {
            return this.getMetadata() == 0 ? "empty" : this.quiverableArrow.getUnlocalizedName();
        }

        static
        {
        	ItemBowAndQuiver.EnumType[] var0 = values();
            int var1 = var0.length;

            for (int var2 = 0; var2 < var1; ++var2)
            {
            	ItemBowAndQuiver.EnumType var3 = var0[var2];
                META_LOOKUP[var3.getMetadata()] = var3;
            }
        }
    }
}
