package it.uniroma1.lcl.studstats;

import java.util.Map;

public class Rapporto {
	private Map<?, ?> map;
	
	public Rapporto(Map<?, ?> map) {
		this.map = map;
	}
	
	@Override
	public String toString() {
		return this.map.toString();
	}
}
