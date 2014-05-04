package me.tyler15555.minibosses.client;
import net.minecraft.client.model.ModelSlime;
import net.minecraft.client.renderer.entity.RenderFallingBlock;
import net.minecraft.client.renderer.entity.RenderSlime;
import cpw.mods.fml.client.registry.RenderingRegistry;
import me.tyler15555.minibosses.common.CommonProxy;
import me.tyler15555.minibosses.entity.EntityCrawler;
import me.tyler15555.minibosses.entity.EntityForestGuard;
import me.tyler15555.minibosses.entity.EntityIronZombie;
import me.tyler15555.minibosses.entity.EntityLivingBlock;
import me.tyler15555.minibosses.entity.EntitySuperSlime;
import me.tyler15555.minibosses.entity.EntityWatcher;

public class ClientProxy extends CommonProxy {

	@Override
	public void registerRenderers() {
		System.out.println("[Minibosses] Registering entity renderers...");
		RenderingRegistry.registerEntityRenderingHandler(EntityIronZombie.class, new RenderIronZombie());
		RenderingRegistry.registerEntityRenderingHandler(EntitySuperSlime.class, new RenderSlime(new ModelSlime(16), new ModelSlime(0), 0.25F));
		RenderingRegistry.registerEntityRenderingHandler(EntityForestGuard.class, new RenderForestGuard());
		RenderingRegistry.registerEntityRenderingHandler(EntityCrawler.class, new RenderCrawler());
		RenderingRegistry.registerEntityRenderingHandler(EntityLivingBlock.class, new RenderLivingBlock());
		RenderingRegistry.registerEntityRenderingHandler(EntityWatcher.class, new RenderWatcher());
		System.out.println("[Minibosses] Successfully registered all entity renderers!");
	}
	
	@Override
	public int registerDarkArmorRenderPrefix() {
		return RenderingRegistry.addNewArmourRendererPrefix("dark_iron");
	}
	
}
