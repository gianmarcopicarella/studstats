package it.uniroma1.lcl.studstats.analizzatori;

import java.text.DecimalFormat;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import it.uniroma1.lcl.studstats.Rapporto;
import it.uniroma1.lcl.studstats.Studente;
import it.uniroma1.lcl.studstats.dati.Analizzatore;
import it.uniroma1.lcl.studstats.dati.TipoRapporto;
import it.uniroma1.lcl.studstats.dati.RapportoSemplice;

public class AnalizzatoreVoto implements Analizzatore {

	@Override
	public Rapporto generaRapporto(Collection<Studente> studs) {
		int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
		double count = 0;
		Map<String, String> map = new HashMap<String, String>();		
		map.put("VOTO_MEDIANO", ((List<Studente>)studs).get(studs.size() / 2).get("MaxDiVOTO"));
		for(Studente s : studs) {
			int t = Integer.valueOf(s.get("MaxDiVOTO"));
			if(t < min) min = t;
			else if( t > max) max = t;
			count += t;
		}
		
		map.put("VOTO_MEDIO", new DecimalFormat("#.##").format(count / studs.size()));
		map.put("VOTO_MAX", "" + max);
		map.put("VOTO_MIN", "" + min);
		
		return new Rapporto(map);
	}
	
	@Override
	public TipoRapporto getTipo() {
		return RapportoSemplice.AV;
	}
	
}
