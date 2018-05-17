package it.uniroma1.lcl.studstats.dati;

import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;
import java.util.stream.Collectors;

import it.uniroma1.lcl.studstats.Studente;
import it.uniroma1.lcl.studstats.utils.Utils;
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
		Map<String, LinkedHashMap<String, Long>> map = new HashMap<String, LinkedHashMap<String, Long>>();
		
		LinkedHashMap<String, Long> xxx = studs.stream().collect(Collectors.groupingBy(i -> ((Studente)i).get("ISTITUTO_SUPERIORE"), HashMap::new, Collectors.counting())).entrySet().stream()
		.sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
		.collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue, (e1,e2)->e1, LinkedHashMap::new));
		
		map.put("ISTITUTI", xxx);
		
		return new Rapporto(map);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public TipoRapporto getTipo() {
		return RapportoSemplice.AI;
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
