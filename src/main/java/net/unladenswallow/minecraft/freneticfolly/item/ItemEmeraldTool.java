package net.unladenswallow.minecraft.freneticfolly.item;

import java.util.Set;

import net.minecraft.item.ItemTool;
import net.minecraftforge.common.util.EnumHelper;

public class ItemEmeraldTool extends ItemTool {
	
	public static ToolMaterial material = EnumHelper.addToolMaterial(
			"EmeraldTool",
			3,
			1000,
			10.0f,
			2.5f,
			30
			);

	@SuppressWarnings("rawtypes")
	protected ItemEmeraldTool(Set effectiveBlocks) {
		super(2.0f, material, effectiveBlocks);
	}

}
