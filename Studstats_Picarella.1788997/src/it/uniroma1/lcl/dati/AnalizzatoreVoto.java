package it.uniroma1.lcl.dati;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import it.uniroma1.lcl.studstats.Studente;

/**
 * Analizzatore che restituisce un Rapporto contenente il voto medio, 
 * il voto massimo e minimo e la mediana dei voti degli studenti.
 * @author gianpcrx
 *
 */
public class AnalizzatoreVoto implements Analizzatore {
	
	/**
	 * Genera un Rapporto contenete il voto medio, minimo, massimo e mediano dei vari studenti.
	 * {@inheritDoc}
	 */
	@Override
	public Rapporto generaRapporto(Collection<Studente> studs) {
		HashMap<String, Number> rapporto = new HashMap<String, Number>();		
		List<Integer> ints = studs.stream().map(s -> Integer.parseInt(s.get("MaxDiVOTO")))
				.sorted().collect(Collectors.toList());
		int size = studs.size();
		if (size > 0) { 
			rapporto.put("VOTO_MIN", ints.get(0));
			rapporto.put("VOTO_MAX", ints.get(size - 1));
			rapporto.put("VOTO_MEDIANO", size % 2 == 0 ? 
					(ints.get(size / 2 - 1) + ints.get(size / 2)) / 2 :
					ints.get(size / 2));
			rapporto.put("VOTO_MEDIO", Math.ceil(100 * (double)ints.stream().mapToInt(i->i).sum() / size) / 100);
		}
		return new Rapporto(Map.of("VOTO", rapporto));
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public TipoRapporto getTipo() {
		return RapportoSemplice.AV;
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