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
		return new Rapporto(Map.of("SESSO", Utils.contaPerChiave(studs, "SESSO")).toString());
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public TipoRapporto getTipo() {
		// TODO Auto-generated method stub
		return RapportoSemplice.AS;
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