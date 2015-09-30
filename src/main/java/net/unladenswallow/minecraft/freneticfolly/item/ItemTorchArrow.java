package net.unladenswallow.minecraft.freneticfolly.item;

public class ItemTorchArrow extends ItemQuiverableArrow {

	public ItemTorchArrow() {
		super();
		setUnlocalizedName("torchArrow");
		this.bowToMimic = new ItemTorchBow();
		this.itemUsedByBow = this;
	}
}
