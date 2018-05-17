package it.uniroma1.lcl.studstats.dati;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;
import java.util.stream.Collectors;

import it.uniroma1.lcl.studstats.Studente;
import it.uniroma1.lcl.studstats.utils.Utils;

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
		
		HashMap<String, TreeMap<String, Integer>> m = new HashMap<String, TreeMap<String, Integer>>();
		m.put("ANNI_DIPLOMA", Utils.contaPerChiave(studs, "ANNO_DIPLOMA"));
		
		
		
		//studs.stream().collect(Collectors. i -> ((Studente)(i))., HashMap::new, Collectors.counting());
		
		TreeMap<String, Integer> t = new TreeMap<String, Integer>((a, b) -> b.compareTo(a)); 
		
		
		
		
		t.putAll(studs.stream()
				.collect(Collectors.toMap(i -> ((Studente)(i)).get("ANNO_DIPLOMA"), i -> 1, (a, b) -> a + b, TreeMap::new)));
		
		
		m.put("ANNI_DIPLOMA", t);
		
		return new Rapporto(m);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public TipoRapporto getTipo() {
		return RapportoSemplice.AAD;
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
