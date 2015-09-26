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

		MinecraftForge.EVENT_BUS.register(ModFreneticFolly.torchBow);
		MinecraftForge.EVENT_BUS.register(ModFreneticFolly.explosionBow);
		MinecraftForge.EVENT_BUS.register(ModFreneticFolly.binoculars);
    }

    @Override
    public void postInit(FMLPostInitializationEvent e) {
        super.postInit(e);
    }
}
