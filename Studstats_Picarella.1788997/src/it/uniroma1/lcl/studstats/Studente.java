package it.uniroma1.lcl.studstats;

import java.util.HashMap;
import java.util.Map;

public class Studente {
	private Map<String, String> data;
	
	public Studente(String[] keys, String[] values) {
		this.data = new HashMap<String, String>();
		for(int i = 0; i < keys.length; i++) 
			this.set(keys[i], values[i]);
	}
	
	public String get(String key) {
		return this.data.containsKey(key) ? this.data.get(key) : null;
	}
	
	public void set(String key, String value) {
		this.data.put(key, value);
	}
}
