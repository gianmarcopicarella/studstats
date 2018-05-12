package it.uniroma1.lcl.studstats.analizzatori;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import it.uniroma1.lcl.studstats.Rapporto;
import it.uniroma1.lcl.studstats.Studente;
import it.uniroma1.lcl.studstats.dati.Analizzatore;
import it.uniroma1.lcl.studstats.dati.TipoRapporto;
import it.uniroma1.lcl.studstats.dati.RapportoSemplice;

public class AnalizzatoreIstituti implements Analizzatore {

	@Override
	public Rapporto generaRapporto(Collection<Studente> studs) {
		Map<String, Map<String, Integer>> finalMap = new HashMap<String, Map<String, Integer>>();
		finalMap.put("ISTITUTI", Analizzatore.reduceByKeyToMap(studs, "ISTITUTO_SUPERIORE"));		
		return new Rapporto(finalMap);
	}
	
	@Override
	public TipoRapporto getTipo() {
		// TODO Auto-generated method stub
		return RapportoSemplice.AI;
	}

}
