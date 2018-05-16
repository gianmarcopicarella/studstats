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
 * Analizzatore che restituisce un Rapporto contenente il numero di studenti raggruppati per sesso. 
 * @author gianpcrx
 *
 */
public class AnalizzatoreSesso implements Analizzatore {
	
	/**
	 * Genera un Rapporto contenente il numero di studenti per ogni sesso.
	 * {@inheritDoc}
	 */
	@Override
	public Rapporto generaRapporto(Collection<Studente> studs) {
		return new Rapporto(Map.of("SESSO", Utils.contaPerChiave(studs, "SESSO")));
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public TipoRapporto getTipo() {
		// TODO Auto-generated method stub
		return RapportoSemplice.AS;
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