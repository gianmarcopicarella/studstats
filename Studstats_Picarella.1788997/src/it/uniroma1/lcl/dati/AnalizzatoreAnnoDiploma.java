package it.uniroma1.lcl.dati;

import java.util.Collection;
import java.util.Map;
import java.util.Objects;

import it.uniroma1.lcl.studstats.Studente;
import it.uniroma1.lcl.utils.Utils;

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
				Utils.contaPerChiaveEOrdina(studs, "ANNO_DIPLOMA", Utils.CHIAVIDECRESCENTI)));
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
		if(o == this) return true;
		if(o == null || this.getClass() != o.getClass()) return false;
		return true;		
	}
}
