package it.uniroma1.lcl.studstats.analizzatori;

import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import it.uniroma1.lcl.studstats.Rapporto;
import it.uniroma1.lcl.studstats.Studente;
import it.uniroma1.lcl.studstats.dati.Analizzatore;
import it.uniroma1.lcl.studstats.dati.RapportoComposto;
import it.uniroma1.lcl.studstats.dati.TipoRapporto;
import it.uniroma1.lcl.studstats.utils.Utils;

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
		Map<String, Integer> temp = new HashMap<>();
		studs.stream().filter(s -> s.get("NAZIONE_DI_NASCITA").equals("ITALIA"))
		.collect(Collectors.groupingBy(s -> s.get("REGIONE_DI_NASCITA"))).entrySet()
		.forEach(e -> {
			int somma = 0;
			for(Studente s : e.getValue()) 
				somma += Integer.parseInt(s.get("MaxDiVOTO"));
			temp.put(e.getKey(), somma / e.getValue().size());
		});
		
		Map<String, Map<String, Integer>> rapporto = new HashMap<>();
		rapporto.put("MEDIA_REGIONALE", Utils.ordinaPerValori(temp, this.comparator));
		return new Rapporto(rapporto);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public TipoRapporto getTipo() {
		return RapportoComposto.AMSIPR;
	}
}