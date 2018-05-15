package it.uniroma1.lcl.studstats;

import java.util.Map;
/**
 * Descrive il risultato dell'Analizzatore tramite una Map.
 * @author gianpcrx
 *
 */
public class Rapporto {
	private Map<String, ? super Number> rapporto;
	public Rapporto(Map<String, ? super Number> rapporto) { this.rapporto = rapporto; }
	
	/**
	 * Restituisce una stringa rappresentante la Map memorizzata.
	 * @return Una stringa rappresentante la Map memorizzata.
	 */
	@Override
	public String toString() {
		return this.rapporto.toString();
	}
}
