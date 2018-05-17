package it.uniroma1.lcl.dati;

import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import it.uniroma1.lcl.studstats.Studente;
import it.uniroma1.lcl.utils.Utils;

/**
 * Analizzatore inizializzato con un comparator che restituisce un Rapporto (ordinato per valore tramite il comparator fornito) contenente la media regionale italiana dei vari studenti.
 * @author gianpcrx
 *
 */
public class AnalizzatoreMediaStudentiItalianiPerRegione implements Analizzatore {
	private Comparator<Entry<String, Integer>> comparator;
	
	/**
	 * Preso un comparator c istanzia il nuovo oggetto.
	 * @param c Il comparator da utilizzare nell'ordinamento dei risultati
	 */
	public AnalizzatoreMediaStudentiItalianiPerRegione(Comparator<Entry<String, Integer>> c) {
		this.comparator = c;
	}
	
	/**
	 * Genera un Rapporto contenente per ogni regione italiana la media dei vari studenti diplomati.
	 * Ordina la mappa del rapporto per valore tramite il comparator fornito al costruttore della classe.
	 * {@inheritDoc}
	 */
	@Override
	public Rapporto generaRapporto(Collection<Studente> studs) {
		HashMap<String, Integer> temp = new HashMap<>();
		studs.stream().filter(s -> s.get("NAZIONE_DI_NASCITA").equals("ITALIA"))
		.collect(Collectors.groupingBy(s -> s.get("REGIONE_DI_NASCITA"))).entrySet()
		.forEach(e -> {
			temp.put(e.getKey(), e.getValue().stream()
					.mapToInt(i -> Integer.parseInt(i.get("MaxDiVOTO"))).sum() / e.getValue().size());
		});
		return new Rapporto(Map.of("MEDIA_REGIONALE", 
				Utils.ordinaMappa(temp, this.comparator)));
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public TipoRapporto getTipo() {
		return RapportoComposto.AMSIPR;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public int hashCode() {
		return Objects.hash(this.getClass(), this.comparator);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean equals(Object o) {
		if(o == this) return true;
		if(o == null || this.getClass() != o.getClass()) return false;
		AnalizzatoreMediaStudentiItalianiPerRegione a = (AnalizzatoreMediaStudentiItalianiPerRegione)(o);
		return a.comparator.equals(this.comparator);
	}
}