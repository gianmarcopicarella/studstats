package it.uniroma1.lcl.studstats.analizzatori;

import java.util.Collection;
import java.util.Map;
import java.util.TreeMap;

import it.uniroma1.lcl.studstats.Rapporto;
import it.uniroma1.lcl.studstats.Studente;
import it.uniroma1.lcl.studstats.dati.Analizzatore;
import it.uniroma1.lcl.studstats.dati.TipoRapporto;
import it.uniroma1.lcl.studstats.utils.Utils;
import it.uniroma1.lcl.studstats.dati.RapportoSemplice;

/**
 * Analizzatore che restituisce un Rapporto contenente il numero di diplomati 
 * raggruppati per titolo di studio ottenuto. Il Rapporto è ordinato in modo descrescente per valore.
 * @author gianpcrx
 *
 */
public class AnalizzatoreTitoloDiStudio implements Analizzatore {
	
	/**
	 * Genera un Rapporto contenente il numero di studenti per ogni titolo di studio. 
	 * Il Rapporto è ordinato per valore.
	 * {@inheritDoc}
	 */
	@Override
	public Rapporto generaRapporto(Collection<Studente> studs) {
		Map<String, Map<String, Integer>> rapporto = new TreeMap<>();
		rapporto.put("TITOLO", Utils.filtraEOrdinaPerValoriDecrescenti(studs, "TITOLO_DI_STUDIO"));
		return new Rapporto(rapporto);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public TipoRapporto getTipo() {
		return RapportoSemplice.ATDS;
	}

}
