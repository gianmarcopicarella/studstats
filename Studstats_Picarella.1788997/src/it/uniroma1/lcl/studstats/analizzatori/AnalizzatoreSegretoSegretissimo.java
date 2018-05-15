package it.uniroma1.lcl.studstats.analizzatori;

import java.util.Collection;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import it.uniroma1.lcl.studstats.Rapporto;
import it.uniroma1.lcl.studstats.Studente;
import it.uniroma1.lcl.studstats.dati.Analizzatore;
import it.uniroma1.lcl.studstats.dati.RapportoSemplice;
import it.uniroma1.lcl.studstats.dati.TipoRapporto;
import it.uniroma1.lcl.studstats.utils.Utils;


/**
 * Analizzatore creato per il test Studstats 3. 
 * Restituisce un rapporto contenente il numero di studenti nati per ogni regione.
 * @author gianpcrx
 *
 */
public class AnalizzatoreSegretoSegretissimo implements Analizzatore {
	
	/**
	 * Restituisce un rapporto contenente il numero di studenti nati per ogni regione.
	 * {@inheritDoc}
	 */
	@Override
	public Rapporto generaRapporto(Collection<Studente> studs) {
		return new Rapporto(Map.of("REGIONI", Utils.contaPerChiaveEOrdinaPerValoriDecrescenti(studs.stream()
				.filter(s -> s.get("NAZIONE_DI_NASCITA").equals("ITALIA"))
				.collect(Collectors.toList()), "REGIONE_DI_NASCITA")).toString());
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public TipoRapporto getTipo() {
		return RapportoSemplice.AR;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(this.getClass());
	}
	
	@Override
	public boolean equals(Object o) {
		if(o == this) return true;
		if(o == null || this.getClass() != o.getClass()) return false;
		Analizzatore c = (Analizzatore)o;
		return c.getTipo() == this.getTipo();	
	}
}
