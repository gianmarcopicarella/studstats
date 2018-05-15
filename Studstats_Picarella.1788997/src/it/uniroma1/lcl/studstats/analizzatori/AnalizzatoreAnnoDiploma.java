package it.uniroma1.lcl.studstats.analizzatori;

import java.util.Collection;
import java.util.Map;
import java.util.Objects;

import it.uniroma1.lcl.studstats.Rapporto;
import it.uniroma1.lcl.studstats.Studente;
import it.uniroma1.lcl.studstats.dati.Analizzatore;
import it.uniroma1.lcl.studstats.dati.TipoRapporto;
import it.uniroma1.lcl.studstats.utils.Utils;
import it.uniroma1.lcl.studstats.dati.RapportoSemplice;

/**
 * Analizzatore che restituisce un Rapporto contenente il numero di diplomati 
 * in ogni anno ordinati per anno in ordine descrescente.
 * @author gianpcrx
 *
 */
public class AnalizzatoreAnnoDiploma implements Analizzatore {
	
	/**
	 * Genera un Rapporto contenente per ogni anno il numero di diplomati. 
	 * Il Rapporto è ordinato in modo descrescente per chiave.
	 * {@inheritDoc}
	 */
	@Override
	public Rapporto generaRapporto(Collection<Studente> studs) {
		return new Rapporto(Map.of("ANNI_DIPLOMA", 
				Utils.contaPerChiave(studs, "ANNO_DIPLOMA").descendingMap()).toString());
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public TipoRapporto getTipo() {
		return RapportoSemplice.AAD;
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
		return o == this || !(o == null || this.getClass() != o.getClass());	
	}
}
