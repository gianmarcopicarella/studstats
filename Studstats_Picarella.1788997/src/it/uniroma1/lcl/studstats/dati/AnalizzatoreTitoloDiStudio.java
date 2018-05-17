package it.uniroma1.lcl.studstats.dati;

import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import it.uniroma1.lcl.studstats.Studente;
import it.uniroma1.lcl.studstats.utils.Utils;

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
		
		Map<String, LinkedHashMap<String, Long>> vvv = new HashMap<String, LinkedHashMap<String, Long>>();
		//vvv.put("VOTO", Utils.contaPerChiaveEOrdina(studs, "TITOLO_DI_STUDIO"));
		
		
		//Map<String, LinkedHashMap<String, Long>> map = new HashMap<String, LinkedHashMap<String, Long>>();
		
		LinkedHashMap<String, Long> xxx = studs.stream().collect(Collectors.groupingBy(i -> ((Studente)i).get("TITOLO_DI_STUDIO"), HashMap::new, Collectors.counting())).entrySet().stream()
		.sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
		.collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue, (e1,e2)->e1, LinkedHashMap::new));
		
		vvv.put("TITOLO", xxx);
		
		
		return new Rapporto(vvv);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public TipoRapporto getTipo() {
		return RapportoSemplice.ATDS;
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
