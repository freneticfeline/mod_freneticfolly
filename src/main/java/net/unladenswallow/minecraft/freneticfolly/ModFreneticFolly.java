package net.unladenswallow.minecraft.freneticfolly;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
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
import net.unladenswallow.minecraft.freneticfolly.item.ItemBowAndQuiver;
import net.unladenswallow.minecraft.freneticfolly.item.ItemEmeraldMultitool;
import net.unladenswallow.minecraft.freneticfolly.item.ItemExplosionBow;
import net.unladenswallow.minecraft.freneticfolly.item.ItemTeleportBow;
import net.unladenswallow.minecraft.freneticfolly.item.ItemTorchBow;


@Mod(modid = ModFreneticFolly.MODID, useMetadata = true)
public class ModFreneticFolly {

	public static final String MODID = "mod_freneticfolly";
	
	@SidedProxy(clientSide="net.unladenswallow.minecraft.freneticfolly.ClientProxy", serverSide="net.unladenswallow.minecraft.freneticfolly.ServerProxy")
	public static CommonProxy proxy;
	
	public static Item torchArrow;
	public static Item torchBow;
	public static Item explosionBow;
	public static Item explodingArrow;
	public static Item teleportBow;
	public static Item teleportArrow;
	public static Item emeraldMultitool;
	public static Item sandwich;
	public static Item binoculars;
	public static Block superTorch;
	public static Block emeraldFountain;
	public static Item enderShard;
	public static Item bowAndQuiver;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent preInitEvent) {
		ModFreneticFolly.proxy.preInit(preInitEvent);
		
		torchBow = new ItemTorchBow();
		(torchArrow = new Item()).setUnlocalizedName("torchArrow").setCreativeTab(CreativeTabs.tabCombat);
		explosionBow = new ItemExplosionBow();
		(explodingArrow = new Item()).setUnlocalizedName("explodingArrow").setCreativeTab(CreativeTabs.tabCombat);
		teleportBow = new ItemTeleportBow();
		(teleportArrow = new Item()).setUnlocalizedName("teleportArrow").setCreativeTab(CreativeTabs.tabCombat);
		emeraldMultitool = new ItemEmeraldMultitool();
		(sandwich = new ItemFood(9, 1.0f, false)).setUnlocalizedName("sandwich");
		binoculars = new ItemBinoculars();
		superTorch = new BlockSuperTorch();
		emeraldFountain = new BlockEmeraldFountain();
		(enderShard = new Item()).setUnlocalizedName("enderShard").setCreativeTab(CreativeTabs.tabMisc);
		bowAndQuiver = new ItemBowAndQuiver();

		GameRegistry.registerItem(torchBow, "torch_bow");
		GameRegistry.registerItem(torchArrow, "torch_arrow");
		GameRegistry.registerItem(explosionBow, "explosion_bow");
		GameRegistry.registerItem(explodingArrow, "exploding_arrow");
		GameRegistry.registerItem(teleportBow, "teleport_bow");
		GameRegistry.registerItem(teleportArrow, "teleport_arrow");
		GameRegistry.registerItem(emeraldMultitool, "emerald_multitool");
		GameRegistry.registerItem(sandwich, "sandwich");
		GameRegistry.registerItem(binoculars, "binoculars");
		GameRegistry.registerBlock(superTorch, "super_torch");
		GameRegistry.registerBlock(emeraldFountain, "emerald_fountain");
		GameRegistry.registerItem(enderShard, "ender_shard");
		GameRegistry.registerItem(bowAndQuiver, "bowandquiver");
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
		GameRegistry.addRecipe(new ItemStack(torchBow),
				"IS ",
				"I T",
				"IS ",
				'T', Blocks.torch,
				'S', Items.stick,
				'I', Items.string);
		GameRegistry.addRecipe(new ItemStack(explosionBow),
				"IS ",
				"I G",
				"IS ",
				'G', Items.gunpowder,
				'S', Items.stick,
				'I', Items.string);
		GameRegistry.addRecipe(new ItemStack(teleportBow),
				"IS ",
				"I E",
				"IS ",
				'E', Items.ender_pearl,
				'S', Items.stick,
				'I', Items.string);
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

		GameRegistry.addRecipe(new ItemStack(bowAndQuiver),
				"LTS",
				"TLS",
				"LTS",
				'L', Items.leather,
				'T', Items.stick,
				'S', Items.string);

//		GameRegistry.addShapelessRecipe(new ItemStack(emeraldMultitool),
//				new Object[] {ModEmeraldMaterial.emeraldPickaxe, ModEmeraldMaterial.emeraldAxe, ModEmeraldMaterial.emeraldSpade});
		GameRegistry.addShapelessRecipe(new ItemStack(superTorch, 2),
				new Object[] {Blocks.torch, Blocks.torch, Blocks.torch});
		GameRegistry.addShapelessRecipe(new ItemStack(torchArrow),
				new Object[] {Blocks.torch, Items.arrow});
		GameRegistry.addShapelessRecipe(new ItemStack(explodingArrow), 
				new Object[] {Items.arrow, Items.gunpowder});
		GameRegistry.addShapelessRecipe(new ItemStack(teleportArrow), 
				new Object[] {Items.arrow, ModFreneticFolly.enderShard});
		GameRegistry.addShapelessRecipe(new ItemStack(enderShard, 4), 
				new Object[] {Items.ender_pearl});
		GameRegistry.addShapelessRecipe(new ItemStack(Items.ender_pearl), 
				new Object[] {enderShard, enderShard, enderShard, enderShard});

		GameRegistry.addShapelessRecipe(new ItemStack(bowAndQuiver, 1, 62), 
				new Object[] {Items.arrow, new ItemStack(bowAndQuiver, 1, 63)});
		((ItemBowAndQuiver)bowAndQuiver).addRepairRecipes();

	}
	
	private void addSmelting() {
		GameRegistry.addSmelting(Blocks.obsidian, new ItemStack(Items.diamond), 0.5f);
	}

}
