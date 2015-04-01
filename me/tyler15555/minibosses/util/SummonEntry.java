package me.tyler15555.minibosses.util;


public class SummonEntry {

	private final Class entityClass;
	private final String summon;
	private final int bCost;
	private final int lReq;
	
	public SummonEntry(Class clazz, String summonName, int bloodCost, int levelReq) {
		entityClass = clazz;
		summon = summonName;
		bCost = bloodCost;
		lReq = levelReq;
	}
	
	public void doSummon() {
		
	}
	
	@Override
	public String toString() {
		return entityClass.getName() + ":" + summon + ":" + bCost + ":" + lReq;
	} 
	
}
