package me.tyler15555.minibosses.client;

import me.tyler15555.minibosses.block.MBBlocks;
import me.tyler15555.minibosses.common.CommonProxy;
import me.tyler15555.minibosses.common.MiniBosses;
import me.tyler15555.minibosses.entity.EntityCrawler;
import me.tyler15555.minibosses.entity.EntityFeeder;
import me.tyler15555.minibosses.entity.EntityForestGuard;
import me.tyler15555.minibosses.entity.EntityInfernoGolem;
import me.tyler15555.minibosses.entity.EntityIronZombie;
import me.tyler15555.minibosses.entity.EntityLivingBlock;
import me.tyler15555.minibosses.entity.EntitySprout;
import me.tyler15555.minibosses.entity.EntitySuperSlime;
import me.tyler15555.minibosses.entity.EntityTombGuard;
import me.tyler15555.minibosses.entity.EntityWatcher;
import me.tyler15555.minibosses.item.MBItems;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelSlime;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.renderer.entity.RenderSlime;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.item.Item;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.FMLCommonHandler;

import org.apache.logging.log4j.Level;
import org.lwjgl.input.Keyboard;




public class ClientProxy extends CommonProxy {

	protected static final KeyBinding toggleBind = new KeyBinding("key.toggle.powers", Keyboard.KEY_P, "key.catagories.minibosses");
	
	@Override
	public void registerRenderers() {
		MiniBosses.logger.log(Level.INFO, "Registering entity renderers...");
		RenderingRegistry.registerEntityRenderingHandler(EntityIronZombie.class, new RenderIronZombie(Minecraft.getMinecraft().getRenderManager()));
		RenderingRegistry.registerEntityRenderingHandler(EntitySuperSlime.class, new RenderSlime(Minecraft.getMinecraft().getRenderManager(), new ModelSlime(16), 0.25F));
		RenderingRegistry.registerEntityRenderingHandler(EntityForestGuard.class, new RenderForestGuard(Minecraft.getMinecraft().getRenderManager()));
		RenderingRegistry.registerEntityRenderingHandler(EntityCrawler.class, new RenderCrawler(Minecraft.getMinecraft().getRenderManager()));
		RenderingRegistry.registerEntityRenderingHandler(EntityLivingBlock.class, new RenderLivingBlock(Minecraft.getMinecraft().getRenderManager()));
		RenderingRegistry.registerEntityRenderingHandler(EntityWatcher.class, new RenderWatcher(Minecraft.getMinecraft().getRenderManager()));
		RenderingRegistry.registerEntityRenderingHandler(EntityFeeder.class, new RenderFeeder(Minecraft.getMinecraft().getRenderManager()));
		RenderingRegistry.registerEntityRenderingHandler(EntityTombGuard.class, new RenderTombGuard(Minecraft.getMinecraft().getRenderManager()));
		RenderingRegistry.registerEntityRenderingHandler(EntityInfernoGolem.class, new RenderInfernoGolem(Minecraft.getMinecraft().getRenderManager()));
		RenderingRegistry.registerEntityRenderingHandler(EntitySprout.class, new RenderSprout(Minecraft.getMinecraft().getRenderManager()));
		MiniBosses.logger.log(Level.INFO, "Finished registering entity renderers!");
		
		MiniBosses.logger.log(Level.INFO, "Registering item/block renderers");
		RenderItem renderItem = Minecraft.getMinecraft().getRenderItem();
		
		renderItem.getItemModelMesher().register(Item.getItemFromBlock(MBBlocks.cryptStone), 0, new ModelResourceLocation("minibosses:cryptStone", "inventory"));
		renderItem.getItemModelMesher().register(Item.getItemFromBlock(MBBlocks.blockSlime), 0, new ModelResourceLocation("minibosses:blockSlime", "inventory"));
		
		renderItem.getItemModelMesher().register(MBItems.ingotDarkIron, 0, new ModelResourceLocation("minibosses:ingotDarkIron", "inventory"));
		renderItem.getItemModelMesher().register(MBItems.ingotInferno, 0, new ModelResourceLocation("minibosses:ingotInferno", "inventory"));
		renderItem.getItemModelMesher().register(MBItems.darkIronHelm, 0, new ModelResourceLocation("minibosses:darkIronHelm", "inventory"));
		renderItem.getItemModelMesher().register(MBItems.darkIronChest, 0, new ModelResourceLocation("minibosses:darkIronChest", "inventory"));
		renderItem.getItemModelMesher().register(MBItems.darkIronLegs, 0, new ModelResourceLocation("minibosses:darkIronLegs", "inventory"));
		renderItem.getItemModelMesher().register(MBItems.darkIronBoots, 0, new ModelResourceLocation("minibosses:darkIronBoots", "inventory"));
		renderItem.getItemModelMesher().register(MBItems.feederTooth, 0, new ModelResourceLocation("minibosses:feederTooth", "inventory"));
		renderItem.getItemModelMesher().register(MBItems.feederSword, 0, new ModelResourceLocation("minibosses:feederSword", "inventory"));
		renderItem.getItemModelMesher().register(MBItems.infernoHelm, 0, new ModelResourceLocation("minibosses:infernoHelm", "inventory"));
		renderItem.getItemModelMesher().register(MBItems.infernoChest, 0, new ModelResourceLocation("minibosses:infernoChest", "inventory"));
		renderItem.getItemModelMesher().register(MBItems.infernoLegs, 0, new ModelResourceLocation("minibosses:infernoLegs", "inventory"));
		renderItem.getItemModelMesher().register(MBItems.infernoBoots, 0, new ModelResourceLocation("minibosses:infernoBoots", "inventory"));
		renderItem.getItemModelMesher().register(MBItems.occulus_item, 0, new ModelResourceLocation("minibosses:itemOcculus", "inventory"));
	}
	
	@Override
	public void registerKeyBindings() {
		ClientRegistry.registerKeyBinding(toggleBind);
		FMLCommonHandler.instance().bus().register(new KeyInputHandler());
		MiniBosses.logger.log(Level.INFO, "Registered Key Bindings!");
	}
	
}
