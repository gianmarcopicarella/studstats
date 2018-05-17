package it.uniroma1.lcl.dati;

import java.util.Collection;
import java.util.Map;
import java.util.Objects;

import it.uniroma1.lcl.studstats.Studente;
import it.uniroma1.lcl.utils.Utils;

/**
 * Analizzatore che restituisce un Rapporto contenente il numero di diplomati 
 * raggruppati per titolo di studio ottenuto. Il Rapporto è ordinato in modo descrescente per valore.
 * @author gianpcrx
 *
 */
public class AnalizzatoreTitoloDiStudio implements Analizzatore {
	
	/**
	 * Genera un Rapporto contenente il numero di studenti per ogni titolo di studio. 
	 * Il Rapporto è ordinato per valore.
	 * {@inheritDoc}
	 */
	@Override
	public Rapporto generaRapporto(Collection<Studente> studs) {
		return new Rapporto(Map.of("TITOLO", 
				Utils.contaPerChiaveEOrdina(studs, "TITOLO_DI_STUDIO", Utils.VALORIDECRESCENTI)));
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public TipoRapporto getTipo() {
		return RapportoSemplice.ATDS;
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
