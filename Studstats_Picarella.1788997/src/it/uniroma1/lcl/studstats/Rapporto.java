package it.uniroma1.lcl.studstats;

import java.util.Map;
/**
 * Descrive il risultato dell'Analizzatore tramite una Map.
 * @author gianpcrx
 *
 */
public class Rapporto {
	//private Map<Object, Object> rapporto;
	private String stringa;
	/**
	 * Presa in input una Map genera l'oggetto che rappresenta il risultato di un'analizzatore.
	 * @param rapporto Mappa utilizzata per il toString().
	 */
	public Rapporto(String s) { this.stringa = s; }
	//public Rapporto(Map<Object, Object> rapporto) { this.rapporto = rapporto; }
	
	/**
	 * Restituisce una stringa rappresentante la Map memorizzata.
	 * @return Una stringa rappresentante la Map memorizzata.
	 */
	@Override
	public String toString() {
		return this.stringa;
	}
}
