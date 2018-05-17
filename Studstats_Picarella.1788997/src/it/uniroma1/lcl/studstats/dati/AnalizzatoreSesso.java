package it.uniroma1.lcl.studstats.dati;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;

import it.uniroma1.lcl.studstats.Studente;
import it.uniroma1.lcl.studstats.utils.Utils;

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
		HashMap<String, TreeMap<String, Integer>> m = new HashMap<String, TreeMap<String, Integer>>();
		m.put("SESSO", Utils.contaPerChiave(studs, "SESSO"));
		return new Rapporto(m);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public TipoRapporto getTipo() {
		// TODO Auto-generated method stub
		return RapportoSemplice.AS;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public int hashCode() {
		return Objects.hash(this.getClass());
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean equals(Object o) {
		if(o == this) return true;
		if(o == null || this.getClass() != o.getClass()) return false;
		return true;
	}
}