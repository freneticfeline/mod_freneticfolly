package net.unladenswallow.minecraft.freneticfolly;

import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy extends CommonProxy {

    @Override
    public void preInit(FMLPreInitializationEvent e) {
        super.preInit(e);
    }

    @Override
    public void init(FMLInitializationEvent e) {
        super.init(e);
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
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher()
    		.register(ModFreneticFolly.seedStarter, 0, new ModelResourceLocation(new ResourceLocation(ModFreneticFolly.MODID, "seed_starter"), "inventory"));
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher()
    		.register(ModFreneticFolly.wheatSeedling, 0, new ModelResourceLocation(new ResourceLocation(ModFreneticFolly.MODID, "wheat_seedling"), "inventory"));
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher()
    		.register(ModFreneticFolly.pumpkinSeedling, 0, new ModelResourceLocation(new ResourceLocation(ModFreneticFolly.MODID, "pumpkin_seedling"), "inventory"));
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher()
    		.register(ModFreneticFolly.melonSeedling, 0, new ModelResourceLocation(new ResourceLocation(ModFreneticFolly.MODID, "melon_seedling"), "inventory"));

		MinecraftForge.EVENT_BUS.register(ModFreneticFolly.binoculars);
    }

    @Override
    public void postInit(FMLPostInitializationEvent e) {
        super.postInit(e);
    }
    
}
