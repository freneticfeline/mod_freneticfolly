package net.unladenswallow.minecraft.freneticfolly;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
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
import net.unladenswallow.minecraft.freneticfolly.item.ItemExplodingArrow;
import net.unladenswallow.minecraft.freneticfolly.item.ItemExplosionBow;
import net.unladenswallow.minecraft.freneticfolly.item.ItemIronArrow;
import net.unladenswallow.minecraft.freneticfolly.item.ItemPoisonArrow;
import net.unladenswallow.minecraft.freneticfolly.item.ItemQuiverableArrow;
import net.unladenswallow.minecraft.freneticfolly.item.ItemTeleportArrow;
import net.unladenswallow.minecraft.freneticfolly.item.ItemTeleportBow;
import net.unladenswallow.minecraft.freneticfolly.item.ItemTorchArrow;
import net.unladenswallow.minecraft.freneticfolly.item.ItemTorchBow;


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
	public static Item enderShard;
	
	public static Item emptyBowAndQuiver;
	public static ItemQuiverableArrow vanillaArrow;
	public static Item vanillaArrowBowAndQuiver;

	public static ItemQuiverableArrow torchArrow;
	public static Item torchBow;
	public static Item torchArrowBowAndQuiver;

	public static ItemQuiverableArrow explodingArrow;
	public static Item explosionBow;
	public static Item explodingArrowBowAndQuiver;

	public static ItemQuiverableArrow teleportArrow;
	public static Item teleportBow;
	public static Item teleportArrowBowAndQuiver;

	public static ItemQuiverableArrow ironArrow;
	public static Item ironArrowBowAndQuiver;
	
	public static ItemQuiverableArrow poisonArrow;
	public static Item poisonArrowBowAndQuiver;
	
	public static ItemQuiverableArrow waterArrow;
	public static Item waterArrowBowAndQuiver;
	
	public static ItemQuiverableArrow lavaArrow;
	public static Item lavaArrowBowAndQuiver;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent preInitEvent) {
		ModFreneticFolly.proxy.preInit(preInitEvent);
		
		emeraldMultitool = new ItemEmeraldMultitool();
		(sandwich = new ItemFood(9, 1.0f, false)).setUnlocalizedName("sandwich");
		binoculars = new ItemBinoculars();
		superTorch = new BlockSuperTorch();
		emeraldFountain = new BlockEmeraldFountain();
		(enderShard = new Item()).setUnlocalizedName("enderShard").setCreativeTab(CreativeTabs.tabMisc);
		
		GameRegistry.registerItem(emeraldMultitool, "emerald_multitool");
		GameRegistry.registerItem(sandwich, "sandwich");
		GameRegistry.registerItem(binoculars, "binoculars");
		GameRegistry.registerBlock(superTorch, "super_torch");
		GameRegistry.registerBlock(emeraldFountain, "emerald_fountain");
		GameRegistry.registerItem(enderShard, "ender_shard");

		/* Bows and arrows */
		emptyBowAndQuiver = new ItemBowAndQuiver("emptyBowAndQuiver", null);

		vanillaArrow = new ItemQuiverableArrow();
		vanillaArrowBowAndQuiver = new ItemBowAndQuiver("vanillaArrowBowAndQuiver", new ItemQuiverableArrow());
		
		torchArrow = new ItemTorchArrow();
		torchBow = new ItemTorchBow();
		torchArrowBowAndQuiver = new ItemBowAndQuiver("torchArrowBowAndQuiver", torchArrow);
		
		explodingArrow = new ItemExplodingArrow();
		explosionBow = new ItemExplosionBow();
		explodingArrowBowAndQuiver = new ItemBowAndQuiver("explodingArrowBowAndQuiver", explodingArrow);
		
		teleportArrow = new ItemTeleportArrow();
		teleportBow = new ItemTeleportBow();
		teleportArrowBowAndQuiver = new ItemBowAndQuiver("teleportArrowBowAndQuiver", teleportArrow);
		
		ironArrow = new ItemIronArrow();
		ironArrowBowAndQuiver = new ItemBowAndQuiver("ironArrowBowAndQuiver", ironArrow);
		
		poisonArrow = new ItemPoisonArrow();
		poisonArrowBowAndQuiver = new ItemBowAndQuiver("poisonArrowBowAndQuiver", poisonArrow);

		GameRegistry.registerItem(emptyBowAndQuiver, "emptybowandquiver");

		// Don't register vanillaArrow, as it is just a wrapper and doesn't represent a new item
		GameRegistry.registerItem(vanillaArrowBowAndQuiver, "vanillaarrowbowandquiver");

		GameRegistry.registerItem(torchArrow, "torch_arrow");
		GameRegistry.registerItem(torchBow, "torch_bow");
		GameRegistry.registerItem(torchArrowBowAndQuiver, "torcharrowbowandquiver");
		
		GameRegistry.registerItem(explodingArrow, "exploding_arrow");
		GameRegistry.registerItem(explosionBow, "explosion_bow");
		GameRegistry.registerItem(explodingArrowBowAndQuiver, "explodingarrowbowandquiver");

		GameRegistry.registerItem(teleportArrow, "teleport_arrow");
		GameRegistry.registerItem(teleportBow, "teleport_bow");
		GameRegistry.registerItem(teleportArrowBowAndQuiver, "teleportarrowbowandquiver");

		GameRegistry.registerItem(ironArrow, "iron_arrow");
		GameRegistry.registerItem(ironArrowBowAndQuiver, "ironarrowbowandquiver");

		GameRegistry.registerItem(poisonArrow, "poison_arrow");
		GameRegistry.registerItem(poisonArrowBowAndQuiver, "poisonarrowbowandquiver");
		
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
		GameRegistry.addRecipe(new ItemStack(ironArrow, 4),
				"L",
				"I",
				"F",
				'L', Items.flint,
				'I', Items.iron_ingot,
				'F', Items.feather);

		GameRegistry.addRecipe(new ItemStack(emptyBowAndQuiver, 1),
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
		System.out.println(" **************  Potion.poison.getId() = " + Potion.poison.getId() + "  ************");
		GameRegistry.addShapelessRecipe(new ItemStack(poisonArrow, 8),
				new Object[] {Items.arrow, Items.arrow, Items.arrow, Items.arrow, Items.arrow, 
						Items.arrow, Items.arrow, Items.arrow, new ItemStack(Items.potionitem, 1, 8196)});
		GameRegistry.addShapelessRecipe(new ItemStack(teleportArrow), 
				new Object[] {Items.arrow, ModFreneticFolly.enderShard});
		GameRegistry.addShapelessRecipe(new ItemStack(enderShard, 4), 
				new Object[] {Items.ender_pearl});
		GameRegistry.addShapelessRecipe(new ItemStack(Items.ender_pearl), 
				new Object[] {enderShard, enderShard, enderShard, enderShard});

		((ItemBowAndQuiver)vanillaArrowBowAndQuiver).addRepairRecipes();
		((ItemBowAndQuiver)torchArrowBowAndQuiver).addRepairRecipes();
		((ItemBowAndQuiver)explodingArrowBowAndQuiver).addRepairRecipes();
		((ItemBowAndQuiver)teleportArrowBowAndQuiver).addRepairRecipes();
		((ItemBowAndQuiver)ironArrowBowAndQuiver).addRepairRecipes();
		((ItemBowAndQuiver)poisonArrowBowAndQuiver).addRepairRecipes();

	}
	
	private void addSmelting() {
		GameRegistry.addSmelting(Blocks.obsidian, new ItemStack(Items.diamond), 0.5f);
	}

}
