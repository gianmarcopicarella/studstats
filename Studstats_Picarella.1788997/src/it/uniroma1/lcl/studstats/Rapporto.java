package it.uniroma1.lcl.studstats;

import java.util.Map;

public class Rapporto {
	private Map<String, Map<String, ? extends Number>> mappa;
	
	public Rapporto(Map<String, Map<String, ? extends Number>> mappa) {
		this.mappa = mappa;
	}
	
	@Override
	public String toString() {
		return this.mappa.toString();
	}
	
}
