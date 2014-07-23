package me.tyler15555.minibosses.client;
import org.lwjgl.input.Keyboard;

import net.minecraft.client.model.ModelSlime;
import net.minecraft.client.renderer.entity.RenderFallingBlock;
import net.minecraft.client.renderer.entity.RenderSlime;
import net.minecraft.client.settings.KeyBinding;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.FMLCommonHandler;
import me.tyler15555.minibosses.common.CommonProxy;
import me.tyler15555.minibosses.entity.EntityCrawler;
import me.tyler15555.minibosses.entity.EntityFeeder;
import me.tyler15555.minibosses.entity.EntityForestGuard;
import me.tyler15555.minibosses.entity.EntityGlider;
import me.tyler15555.minibosses.entity.EntityInfernoGolem;
import me.tyler15555.minibosses.entity.EntityIronZombie;
import me.tyler15555.minibosses.entity.EntityLivingBlock;
import me.tyler15555.minibosses.entity.EntitySuperSlime;
import me.tyler15555.minibosses.entity.EntityTombGuard;
import me.tyler15555.minibosses.entity.EntityWatcher;

public class ClientProxy extends CommonProxy {

	protected static final KeyBinding toggleBind = new KeyBinding("key.toggle.powers", Keyboard.KEY_P, "key.catagories.minibosses");
	
	@Override
	public void registerRenderers() {
		System.out.println("[Minibosses] Registering entity renderers...");
		RenderingRegistry.registerEntityRenderingHandler(EntityIronZombie.class, new RenderIronZombie());
		RenderingRegistry.registerEntityRenderingHandler(EntitySuperSlime.class, new RenderSlime(new ModelSlime(16), new ModelSlime(0), 0.25F));
		RenderingRegistry.registerEntityRenderingHandler(EntityForestGuard.class, new RenderForestGuard());
		RenderingRegistry.registerEntityRenderingHandler(EntityCrawler.class, new RenderCrawler());
		RenderingRegistry.registerEntityRenderingHandler(EntityLivingBlock.class, new RenderLivingBlock());
		RenderingRegistry.registerEntityRenderingHandler(EntityWatcher.class, new RenderWatcher());
		RenderingRegistry.registerEntityRenderingHandler(EntityGlider.class, new RenderGlider());
		RenderingRegistry.registerEntityRenderingHandler(EntityFeeder.class, new RenderFeeder());
		RenderingRegistry.registerEntityRenderingHandler(EntityTombGuard.class, new RenderTombGuard());
		RenderingRegistry.registerEntityRenderingHandler(EntityInfernoGolem.class, new RenderInfernoGolem());
		System.out.println("[Minibosses] Successfully registered all entity renderers!");
	}
	
	@Override
	public int registerDarkArmorRenderPrefix() {
		return RenderingRegistry.addNewArmourRendererPrefix("dark_iron");
	}
	
	@Override
	public void registerKeyBindings() {
		ClientRegistry.registerKeyBinding(toggleBind);
		FMLCommonHandler.instance().bus().register(new KeyInputHandler());
	}
	
	@Override
	public int registerInfernoArmorRenderPrefix() {
		return RenderingRegistry.addNewArmourRendererPrefix("inferno");
	}
	
}
