package it.uniroma1.lcl.studstats.analizzatori;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import it.uniroma1.lcl.studstats.Rapporto;
import it.uniroma1.lcl.studstats.Studente;
import it.uniroma1.lcl.studstats.dati.Analizzatore;
import it.uniroma1.lcl.studstats.dati.TipoRapporto;
import it.uniroma1.lcl.studstats.utils.Utils;
import it.uniroma1.lcl.studstats.dati.RapportoSemplice;

/**
 * Analizzatore che restituisce un Rapporto contenente il numero di studenti raggruppati per sesso. 
 * @author gianpcrx
 *
 */
public class AnalizzatoreSesso implements Analizzatore {
	
	/**
	 * Genera un Rapporto contenente il numero di studenti per ogni sesso.
	 * {@inheritDoc}
	 */
	@Override
	public Rapporto generaRapporto(Collection<Studente> studs) {
		Map<String, Map<String, Integer>> rapporto = new HashMap<String, Map<String, Integer>>();
		rapporto.put("SESSO", Utils.filtraPerChiave(studs, "SESSO"));
		return new Rapporto(rapporto);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public TipoRapporto getTipo() {
		// TODO Auto-generated method stub
		return RapportoSemplice.AS;
	}
}