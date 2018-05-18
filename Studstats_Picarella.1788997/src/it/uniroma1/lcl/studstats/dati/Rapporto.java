package it.uniroma1.lcl.studstats.dati;

import java.util.AbstractMap;
import java.util.Map;

/**
 * Classe utilizzata come tipo di ritorno dal metodo generaRapporto dell'interfaccia Analizzatore. 
 * La classe Rapporto contiene una mappa di mappe contenente tutti i dati riguardanti l'analisi effettuata sui dati.
 * @author gianpcrx
 *
 */
public class Rapporto {
	/**
	 * Mappa utilizzata per contenere i dati dell'analisi prodotta da un'analizzatore.
	 */
	private Map<String, ? extends AbstractMap <String, ? extends Number>> mappa;
	
	/**
	 * Istanzia un nuovo oggetto Rapporto a partire da una mappa di mappe.
	 * @param mappa Una mappa di mappe con al suo interno i dati riguardanti l'analisi effettuata.
	 */
	public Rapporto(Map<String, ? extends AbstractMap <String, ? extends Number>> mappa) {
		this.mappa = mappa;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		return this.mappa.toString();
	}
}
