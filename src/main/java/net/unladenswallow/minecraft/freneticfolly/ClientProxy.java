package net.unladenswallow.minecraft.freneticfolly;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderArrow;
import net.minecraft.client.resources.model.ModelBakery;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.unladenswallow.minecraft.freneticfolly.entity.EntityExplodingArrow;
import net.unladenswallow.minecraft.freneticfolly.entity.EntityTorchArrow;
import net.unladenswallow.minecraft.freneticfolly.item.RenderTorchArrow;

public class ClientProxy extends CommonProxy {

    @Override
    public void preInit(FMLPreInitializationEvent e) {
        super.preInit(e);
    }

    @Override
    public void init(FMLInitializationEvent e) {
        super.init(e);
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher()
    		.register(ModFreneticFolly.torchBow, 0, new ModelResourceLocation(new ResourceLocation(ModFreneticFolly.MODID, "torch_bow"), "inventory"));
        ModelBakery.addVariantName(ModFreneticFolly.torchBow, ModFreneticFolly.MODID + ":torch_bow");
        ModelBakery.addVariantName(ModFreneticFolly.torchBow, ModFreneticFolly.MODID + ":torch_bow_pulling_0");
        ModelBakery.addVariantName(ModFreneticFolly.torchBow, ModFreneticFolly.MODID + ":torch_bow_pulling_1");
        ModelBakery.addVariantName(ModFreneticFolly.torchBow, ModFreneticFolly.MODID + ":torch_bow_pulling_2");
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher()
    		.register(ModFreneticFolly.torchArrow, 0, new ModelResourceLocation(new ResourceLocation(ModFreneticFolly.MODID, "torch_arrow"), "inventory"));
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher()
    		.register(ModFreneticFolly.explosionBow, 0, new ModelResourceLocation(new ResourceLocation(ModFreneticFolly.MODID, "explosion_bow"), "inventory"));
        ModelBakery.addVariantName(ModFreneticFolly.explosionBow, ModFreneticFolly.MODID + ":explosion_bow");
        ModelBakery.addVariantName(ModFreneticFolly.explosionBow, ModFreneticFolly.MODID + ":explosion_bow_pulling_0");
        ModelBakery.addVariantName(ModFreneticFolly.explosionBow, ModFreneticFolly.MODID + ":explosion_bow_pulling_1");
        ModelBakery.addVariantName(ModFreneticFolly.explosionBow, ModFreneticFolly.MODID + ":explosion_bow_pulling_2");
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher()
    		.register(ModFreneticFolly.explodingArrow, 0, new ModelResourceLocation(new ResourceLocation(ModFreneticFolly.MODID, "exploding_arrow"), "inventory"));
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher()
    		.register(ModFreneticFolly.teleportBow, 0, new ModelResourceLocation(new ResourceLocation(ModFreneticFolly.MODID, "teleport_bow"), "inventory"));
        ModelBakery.addVariantName(ModFreneticFolly.teleportBow, ModFreneticFolly.MODID + ":teleport_bow");
        ModelBakery.addVariantName(ModFreneticFolly.teleportBow, ModFreneticFolly.MODID + ":teleport_bow_pulling_0");
        ModelBakery.addVariantName(ModFreneticFolly.teleportBow, ModFreneticFolly.MODID + ":teleport_bow_pulling_1");
        ModelBakery.addVariantName(ModFreneticFolly.teleportBow, ModFreneticFolly.MODID + ":teleport_bow_pulling_2");
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher()
    		.register(ModFreneticFolly.teleportArrow, 0, new ModelResourceLocation(new ResourceLocation(ModFreneticFolly.MODID, "teleport_arrow"), "inventory"));
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher()
    		.register(ModFreneticFolly.ironArrow, 0, new ModelResourceLocation(new ResourceLocation(ModFreneticFolly.MODID, "iron_arrow"), "inventory"));
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher()
    		.register(ModFreneticFolly.poisonArrow, 0, new ModelResourceLocation(new ResourceLocation(ModFreneticFolly.MODID, "poison_arrow"), "inventory"));
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher()
    		.register(ModFreneticFolly.waterArrow, 0, new ModelResourceLocation(new ResourceLocation(ModFreneticFolly.MODID, "water_arrow"), "inventory"));
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher()
    		.register(ModFreneticFolly.lavaArrow, 0, new ModelResourceLocation(new ResourceLocation(ModFreneticFolly.MODID, "lava_arrow"), "inventory"));
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher()
    		.register(ModFreneticFolly.emeraldMultitool, 0, new ModelResourceLocation(new ResourceLocation(ModFreneticFolly.MODID, "emerald_multitool"), "inventory"));
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher()
    		.register(ModFreneticFolly.sandwich, 0, new ModelResourceLocation(new ResourceLocation(ModFreneticFolly.MODID, "sandwich"), "inventory"));
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher()
    		.register(ModFreneticFolly.binoculars, 0, new ModelResourceLocation(new ResourceLocation(ModFreneticFolly.MODID, "binoculars"), "inventory"));
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher()
        	.register(Item.getItemFromBlock(ModFreneticFolly.superTorch), 0, new ModelResourceLocation(new ResourceLocation(ModFreneticFolly.MODID, "super_torch"), "inventory"));
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher()
    		.register(Item.getItemFromBlock(ModFreneticFolly.emeraldFountain), 0, new ModelResourceLocation(new ResourceLocation(ModFreneticFolly.MODID, "emerald_fountain"), "inventory"));
        RenderingRegistry.registerEntityRenderingHandler(EntityTorchArrow.class,
        	new RenderTorchArrow(Minecraft.getMinecraft().getRenderManager()));
        RenderingRegistry.registerEntityRenderingHandler(EntityExplodingArrow.class,
            	new RenderArrow(Minecraft.getMinecraft().getRenderManager()));
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher()
    		.register(ModFreneticFolly.enderShard, 0, new ModelResourceLocation(new ResourceLocation(ModFreneticFolly.MODID, "ender_shard"), "inventory"));

        registerItemModelWithVariants(ModFreneticFolly.emptyBowAndQuiver, ModFreneticFolly.MODID + ":bowandquiver_empty", "minecraft:bow", 3);
        registerItemModelWithVariants(ModFreneticFolly.vanillaArrowBowAndQuiver, ModFreneticFolly.MODID + ":bowandquiver_vanillaarrow", "minecraft:bow", 3);
        registerItemModelWithVariants(ModFreneticFolly.torchArrowBowAndQuiver, ModFreneticFolly.MODID + ":bowandquiver_torcharrow", "minecraft:bow", 3);
        registerItemModelWithVariants(ModFreneticFolly.explodingArrowBowAndQuiver, ModFreneticFolly.MODID + ":bowandquiver_explodingarrow", "minecraft:bow", 3);
        registerItemModelWithVariants(ModFreneticFolly.teleportArrowBowAndQuiver, ModFreneticFolly.MODID + ":bowandquiver_teleportarrow", "minecraft:bow", 3);
        registerItemModelWithVariants(ModFreneticFolly.ironArrowBowAndQuiver, ModFreneticFolly.MODID + ":bowandquiver_ironarrow", "minecraft:bow", 3);
        registerItemModelWithVariants(ModFreneticFolly.poisonArrowBowAndQuiver, ModFreneticFolly.MODID + ":bowandquiver_poisonarrow", "minecraft:bow", 3);
        registerItemModelWithVariants(ModFreneticFolly.waterArrowBowAndQuiver, ModFreneticFolly.MODID + ":bowandquiver_waterarrow", "minecraft:bow", 3);
        registerItemModelWithVariants(ModFreneticFolly.lavaArrowBowAndQuiver, ModFreneticFolly.MODID + ":bowandquiver_lavaarrow", "minecraft:bow", 3);
        
        MinecraftForge.EVENT_BUS.register(ModFreneticFolly.torchBow);
		MinecraftForge.EVENT_BUS.register(ModFreneticFolly.explosionBow);
		MinecraftForge.EVENT_BUS.register(ModFreneticFolly.teleportBow);
		MinecraftForge.EVENT_BUS.register(ModFreneticFolly.emptyBowAndQuiver);
		MinecraftForge.EVENT_BUS.register(ModFreneticFolly.vanillaArrowBowAndQuiver);
		MinecraftForge.EVENT_BUS.register(ModFreneticFolly.torchArrowBowAndQuiver);
		MinecraftForge.EVENT_BUS.register(ModFreneticFolly.explodingArrowBowAndQuiver);
		MinecraftForge.EVENT_BUS.register(ModFreneticFolly.teleportArrowBowAndQuiver);
		MinecraftForge.EVENT_BUS.register(ModFreneticFolly.ironArrowBowAndQuiver);
		MinecraftForge.EVENT_BUS.register(ModFreneticFolly.poisonArrowBowAndQuiver);
		MinecraftForge.EVENT_BUS.register(ModFreneticFolly.waterArrowBowAndQuiver);
		MinecraftForge.EVENT_BUS.register(ModFreneticFolly.lavaArrowBowAndQuiver);

		MinecraftForge.EVENT_BUS.register(ModFreneticFolly.binoculars);
    }

    @Override
    public void postInit(FMLPostInitializationEvent e) {
        super.postInit(e);
    }
    
    private void registerItemModelWithVariants(Item bowAndQuiver, String itemModel, String modelBase, int numVariants) {
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher()
    		.register(bowAndQuiver, 0, new ModelResourceLocation(itemModel, "inventory"));
        ModelBakery.addVariantName(bowAndQuiver, itemModel);
        ModelBakery.addVariantName(bowAndQuiver, modelBase);
        for (int i = 0; i < numVariants; i++) {
	        ModelBakery.addVariantName(bowAndQuiver, modelBase + "_pulling_" + i);
        }
    }
}
