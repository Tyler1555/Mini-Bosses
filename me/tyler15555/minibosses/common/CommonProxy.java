package me.tyler15555.minibosses.common;

import org.apache.logging.log4j.Level;

public class CommonProxy {

	public void registerRenderers() {
		MiniBosses.logger.log(Level.INFO, "Detected server side, skipping render registration");
	}
	
	public int registerDarkArmorRenderPrefix() {
		return "dark_iron".length();
	}
	
	public void registerKeyBindings() {
		MiniBosses.logger.log(Level.INFO, "Detected server side, skipping key binding registration");
	}
	
	public int registerInfernoArmorRenderPrefix() {
		return "inferno".length();
	}
	
}
