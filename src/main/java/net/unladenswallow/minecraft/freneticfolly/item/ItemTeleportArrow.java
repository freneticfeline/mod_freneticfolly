package net.unladenswallow.minecraft.freneticfolly.item;

public class ItemTeleportArrow extends ItemQuiverableArrow {

	public ItemTeleportArrow() {
		super();
		setUnlocalizedName("teleportArrow");
		this.bowToMimic = new ItemTeleportBow();
		this.itemUsedByBow = this;
	}

}
