package it.uniroma1.lcl.studstats;

import java.util.HashMap;
import java.util.Map;
/**
 * Rappresenta uno studente letto da file.
 * @author gianpcrx
 */
public class Studente {
	private Map<String, String> data;
	/**
	 * A partire da chiavi e valori genera una Map contenente i dati dello studente.
	 * @param keys Chiavi della mappa da generare.
	 * @param values Valori della mappa da generare.
	 */
	public Studente(String[] keys, String[] values) {
		this.data = new HashMap<String, String>();
		for(int i = 0; i < keys.length; i++) 
			this.set(keys[i], values[i]);
	}
	/**
	 * Ritorna il valore alla chiave specificata.
	 * @param key La chiave da trovare.
	 * @return Il valore memorizzato alla chiave indicata. Ritorna null se la chiave non è presente.
	 */
	public String get(String key) {
		return this.data.containsKey(key) ? this.data.get(key) : null;
	}
	/**
	 * Aggiunge o modifica una Entry nella Map dello studente con un nuovo valore fornito come parametro.
	 * @param key La chiave da trovare o aggiungere.
	 * @param value Il valore da associare alla chiave fornita come parametro.
	 */
	public void set(String key, String value) {
		this.data.put(key, value);
	}
}
