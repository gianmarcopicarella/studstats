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
 * Analizzatore che restituisce un Rapporto contenente il numero di diplomati 
 * in ogni anno ordinati per anno in ordine descrescente.
 * @author gianpcrx
 *
 */
public class AnalizzatoreAnnoDiploma implements Analizzatore {
	
	/**
	 * Genera un Rapporto contenente per ogni anno il numero di diplomati. 
	 * Il Rapporto è ordinato in modo descrescente per chiave.
	 * {@inheritDoc}
	 */
	@Override
	public Rapporto generaRapporto(Collection<Studente> studs) {
		Map<String, Map<String, Integer>> finalMap = new HashMap<String, Map<String, Integer>>();
		finalMap.put("ANNI_DIPLOMA", Analizzatore.filterByKey(studs, "ANNO_DIPLOMA").descendingMap());
		return new Rapporto(finalMap);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public TipoRapporto getTipo() {
		return RapportoSemplice.AAD;
	}
}
