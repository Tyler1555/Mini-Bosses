package me.tyler15555.minibosses.client;
import me.tyler15555.minibosses.common.CommonProxy;
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
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelSlime;
import net.minecraft.client.renderer.entity.RenderSlime;
import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.FMLCommonHandler;

import org.lwjgl.input.Keyboard;



public class ClientProxy extends CommonProxy {

	protected static final KeyBinding toggleBind = new KeyBinding("key.toggle.powers", Keyboard.KEY_P, "key.catagories.minibosses");
	
	@Override
	public void registerRenderers() {
		System.out.println("[Minibosses] Registering entity renderers...");
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
		System.out.println("[Minibosses] Successfully registered all entity renderers!");
	}
	
	//@Override
	//public int registerDarkArmorRenderPrefix() {
	//	return RenderingRegistry.this.;
	//}
	
	@Override
	public void registerKeyBindings() {
		ClientRegistry.registerKeyBinding(toggleBind);
		FMLCommonHandler.instance().bus().register(new KeyInputHandler());
	}
	
	//@Override
	//public int registerInfernoArmorRenderPrefix() {
	//	return RenderingRegistry.addNewArmourRendererPrefix("inferno");
	//}
	
}
