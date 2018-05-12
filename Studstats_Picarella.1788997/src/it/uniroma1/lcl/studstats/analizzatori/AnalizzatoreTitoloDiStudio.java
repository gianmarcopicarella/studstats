package it.uniroma1.lcl.studstats.analizzatori;

import java.util.Collection;
import java.util.Map;
import java.util.TreeMap;

import it.uniroma1.lcl.studstats.Rapporto;
import it.uniroma1.lcl.studstats.Studente;
import it.uniroma1.lcl.studstats.dati.Analizzatore;
import it.uniroma1.lcl.studstats.dati.TipoRapporto;
import it.uniroma1.lcl.studstats.dati.RapportoSemplice;

public class AnalizzatoreTitoloDiStudio implements Analizzatore {

	@Override
	public Rapporto generaRapporto(Collection<Studente> studs) {
		Map<String, Map<String, Integer>> finalMap = new TreeMap<>();
		finalMap.put("TITOLO", Analizzatore.reduceByKeyToMap(studs, "TITOLO_DI_STUDIO"));
		return new Rapporto(finalMap);
	}
	
	@Override
	public TipoRapporto getTipo() {
		return RapportoSemplice.ATDS;
	}

}
