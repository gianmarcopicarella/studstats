package it.uniroma1.lcl.studstats.dati;

import java.util.AbstractMap;
import java.util.Map;

public class Rapporto {
	private Map<String, ? extends AbstractMap <String, ? extends Number>> mappa;
	
	public Rapporto(Map<String, ? extends AbstractMap <String, ? extends Number>> mappa) {
		this.mappa = mappa;
	}
	
	@Override
	public String toString() {
		return this.mappa.toString();
	}
	
}
