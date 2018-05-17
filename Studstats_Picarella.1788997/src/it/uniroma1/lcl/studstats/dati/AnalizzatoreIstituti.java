package it.uniroma1.lcl.studstats.dati;

import java.util.Collection;
import java.util.Map;
import java.util.Objects;

import it.uniroma1.lcl.studstats.Studente;
import it.uniroma1.lcl.studstats.utils.Utils;
/**
 * Analizzatore che restituisce un Rapporto contenente il numero di studenti per ogni istituto superiore trovato. 
 * Il Rapporto è ordinato in modo descrescente in base alla chiave.
 * @author gianpcrx
 *
 */
public class AnalizzatoreIstituti implements Analizzatore {
	
	/**
	 * Genera un Rapporto contenente per ogni istituto superiore il numero di studenti diplomati. 
	 * Il Rapporto è ordinato in modo in modo descrescente per valore.
	 * {@inheritDoc}
	 */
	@Override
	public Rapporto generaRapporto(Collection<Studente> studs) {		
		return new Rapporto(Map.of("ISTITUTI", 
				Utils.contaPerChiaveEOrdina(studs, "ISTITUTO_SUPERIORE", Utils.VALORIDECRESCENTI)));
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public TipoRapporto getTipo() {
		return RapportoSemplice.AI;
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
