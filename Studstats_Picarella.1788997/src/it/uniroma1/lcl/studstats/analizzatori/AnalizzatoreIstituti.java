package it.uniroma1.lcl.studstats.analizzatori;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import it.uniroma1.lcl.studstats.Rapporto;
import it.uniroma1.lcl.studstats.Studente;
import it.uniroma1.lcl.studstats.dati.Analizzatore;
import it.uniroma1.lcl.studstats.dati.TipoRapporto;
import it.uniroma1.lcl.studstats.dati.RapportoSemplice;
/**
 * Analizzatore che restituisce un Rapporto contenente il numero di studenti per ogni istituto superiore trovato. 
 * Il Rapporto è ordinato in modo descrescente in base alla chiave.
 * @author gianpcrx
 *
 */
public class AnalizzatoreIstituti implements Analizzatore {
	
	/**
	 * Genera un Rapporto contenente per ogni istituto superiore il numero di studenti diplomati. 
	 * Il Rapporto è ordinato in modo in modo descrescente per valore.
	 * {@inheritDoc}
	 */
	@Override
	public Rapporto generaRapporto(Collection<Studente> studs) {
		Map<String, Map<String, Integer>> finalMap = new HashMap<String, Map<String, Integer>>();
		finalMap.put("ISTITUTI", Analizzatore.reduceByKeyToMap(studs, "ISTITUTO_SUPERIORE"));		
		return new Rapporto(finalMap);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public TipoRapporto getTipo() {
		// TODO Auto-generated method stub
		return RapportoSemplice.AI;
	}

}
