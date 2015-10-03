package net.unladenswallow.minecraft.freneticfolly;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.unladenswallow.minecraft.freneticfolly.block.BlockEmeraldFountain;
import net.unladenswallow.minecraft.freneticfolly.block.BlockSuperTorch;
import net.unladenswallow.minecraft.freneticfolly.item.ItemBinoculars;
import net.unladenswallow.minecraft.freneticfolly.item.ItemEmeraldMultitool;


@Mod(modid = ModFreneticFolly.MODID, useMetadata = true)
public class ModFreneticFolly {

	public static final String MODID = "mod_freneticfolly";
	
	@SidedProxy(clientSide="net.unladenswallow.minecraft.freneticfolly.ClientProxy", serverSide="net.unladenswallow.minecraft.freneticfolly.ServerProxy")
	public static CommonProxy proxy;
	
	public static Item emeraldMultitool;
	public static Item sandwich;
	public static Item binoculars;
	public static Block superTorch;
	public static Block emeraldFountain;
	public static Item seedBomb; // TODO
	
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent preInitEvent) {
		ModFreneticFolly.proxy.preInit(preInitEvent);
		
		emeraldMultitool = new ItemEmeraldMultitool();
		(sandwich = new ItemFood(9, 1.0f, false)).setUnlocalizedName("sandwich");
		binoculars = new ItemBinoculars();
		superTorch = new BlockSuperTorch();
		emeraldFountain = new BlockEmeraldFountain();
		
		GameRegistry.registerItem(emeraldMultitool, "emerald_multitool");
		GameRegistry.registerItem(sandwich, "sandwich");
		GameRegistry.registerItem(binoculars, "binoculars");
		GameRegistry.registerBlock(superTorch, "super_torch");
		GameRegistry.registerBlock(emeraldFountain, "emerald_fountain");

	}
	
	@EventHandler
	public void init (FMLInitializationEvent event) {
		ModFreneticFolly.proxy.init(event);
		FFLogger.info("Initializing " + ModFreneticFolly.MODID);
		addRecipes();
		addSmelting();
	}
	
	private void addRecipes() {
		GameRegistry.addRecipe(new ItemStack(sandwich, 2),
				" B ",
				" M ",
				" B ",
				'B', Items.bread,
				'M', Items.cooked_beef);
		GameRegistry.addRecipe(new ItemStack(sandwich, 2),
				" B ",
				" M ",
				" B ",
				'B', Items.bread,
				'M', Items.cooked_porkchop);
		GameRegistry.addRecipe(new ItemStack(sandwich, 2),
				" B ",
				" M ",
				" B ",
				'B', Items.bread,
				'M', Items.cooked_chicken);
		GameRegistry.addRecipe(new ItemStack(sandwich, 2),
				" B ",
				" M ",
				" B ",
				'B', Items.bread,
				'M', Items.cooked_mutton);
		GameRegistry.addRecipe(new ItemStack(sandwich, 2),
				" B ",
				" M ",
				" B ",
				'B', Items.bread,
				'M', Items.cooked_rabbit);
		GameRegistry.addRecipe(new ItemStack(sandwich, 2),
				" B ",
				" M ",
				" B ",
				'B', Items.bread,
				'M', Items.cooked_fish);
		GameRegistry.addRecipe(new ItemStack(emeraldFountain),
				"   ",
				" W ",
				" E ",
				'E', Blocks.emerald_block,
				'W', Items.water_bucket);
		GameRegistry.addRecipe(new ItemStack(binoculars),
				"G G",
				"III",
				"G G",
				'G', Blocks.glass_pane,
				'I', Items.iron_ingot);
		GameRegistry.addRecipe(new ItemStack(Items.saddle),
				"LLL",
				"LIL",
				"I I",
				'L', Items.leather,
				'I', Items.iron_ingot);

//		GameRegistry.addShapelessRecipe(new ItemStack(emeraldMultitool),
//				new Object[] {ModEmeraldMaterial.emeraldPickaxe, ModEmeraldMaterial.emeraldAxe, ModEmeraldMaterial.emeraldSpade});
		GameRegistry.addShapelessRecipe(new ItemStack(superTorch, 2),
				new Object[] {Blocks.torch, Blocks.torch, Blocks.torch});
	}
	
	private void addSmelting() {
	}

}
