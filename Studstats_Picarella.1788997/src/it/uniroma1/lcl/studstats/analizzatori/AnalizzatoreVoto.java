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
		int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
		double count = 0;
		Map<String, String> rapporto = new HashMap<String, String>();		
		rapporto.put("VOTO_MEDIANO", ((List<Studente>)studs).get(studs.size() / 2).get("MaxDiVOTO"));
		for(Studente s : studs) {
			int t = Integer.valueOf(s.get("MaxDiVOTO"));
			if(t < min) min = t;
			else if( t > max) max = t;
			count += t;
		}
		
		rapporto.put("VOTO_MEDIO", new DecimalFormat("#.##").format(count / studs.size()));
		rapporto.put("VOTO_MAX", "" + max);
		rapporto.put("VOTO_MIN", "" + min);
		return new Rapporto(rapporto);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public TipoRapporto getTipo() {
		return RapportoSemplice.AV;
	}
	
}
