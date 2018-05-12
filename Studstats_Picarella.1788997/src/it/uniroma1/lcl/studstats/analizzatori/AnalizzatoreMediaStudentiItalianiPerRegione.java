package it.uniroma1.lcl.studstats.analizzatori;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import it.uniroma1.lcl.studstats.Rapporto;
import it.uniroma1.lcl.studstats.Studente;
import it.uniroma1.lcl.studstats.dati.Analizzatore;
import it.uniroma1.lcl.studstats.dati.RapportoComposto;
import it.uniroma1.lcl.studstats.dati.TipoRapporto;

public class AnalizzatoreMediaStudentiItalianiPerRegione implements Analizzatore {

	@Override
	public Rapporto generaRapporto(Collection<Studente> studs) {
		Map<String, Integer> t = new HashMap<>();
		studs.stream().filter(s -> s.get("NAZIONE_DI_NASCITA").equals("ITALIA"))
		.collect(Collectors.groupingBy(s -> s.get("REGIONE_DI_NASCITA"))).entrySet()
		.forEach(e -> {
			t.put(e.getKey(), e.getValue().stream()
					.map(s -> Integer.parseInt(s.get("MaxDiVOTO")))
					.mapToInt(i -> i)
					.sum() / e.getValue().size());
		});
		Map<String, Map<String, Integer>> r = new HashMap<>();
		r.put("MEDIA_REGIONALE", t);
		return new Rapporto(r);
	}
	
	@Override
	public TipoRapporto getTipo() {
		return RapportoComposto.AMSIPR;
	}

}
