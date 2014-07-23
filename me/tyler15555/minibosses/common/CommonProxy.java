package me.tyler15555.minibosses.common;

public class CommonProxy {

	public void registerRenderers() {
		System.out.println("[MiniBosses] Detected server side, skipping renderer registration");
	}
	
	public int registerDarkArmorRenderPrefix() {
		return "dark_iron".length();
	}
	
	public void registerKeyBindings() {
		System.out.println("[MiniBosses] Detected server side, skipping key binding registration");
	}
	
	public int registerInfernoArmorRenderPrefix() {
		return "inferno".length();
	}
	
}
