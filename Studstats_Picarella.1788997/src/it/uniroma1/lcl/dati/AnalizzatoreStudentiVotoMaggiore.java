package it.uniroma1.lcl.dati;

import java.util.Collection;
import java.util.Objects;
import java.util.stream.Collectors;

import it.uniroma1.lcl.studstats.Studente;

/**
 * Analizzatore che preso in input un voto minimo restituisce un Rapporto contenente gli studenti raggruppati
 * per sesso filtrati per voto. Può essere passato come parametro del costruttore un tipo di Analizzatore a piacere
 * così da modificare il comportamento della classe. 
 * @author gianpcrx
 *
 */
public class AnalizzatoreStudentiVotoMaggiore implements Analizzatore {
	
	private int votoMinimo;
	private Analizzatore analizzatore;
	
	/**
	 * Istanzia un oggetto del tipo AnalizzatoreStudentiVotoMaggiore con votoMinimo passato come parametro.
	 * @param votoMinimo Il voto da utilizzare per prendere in considerazione uno studente durante la fase di analisi.
	 */
	public AnalizzatoreStudentiVotoMaggiore(int votoMinimo) {
		this.votoMinimo = votoMinimo;
		this.analizzatore = new AnalizzatoreSesso();
	}
	
	/**
	 * Istanzia un oggetto del tipo AnalizzatoreStudentiVotoMaggiore con votoMinimo ed an passato come parametro.
	 * @param votoMinimo Il voto da utilizzare per prendere in considerazione uno studente durante la fase di analisi.
	 * @param an L'analizzatore che si vuole utilizzare all'interno di generaRapporto.
	 */
	public AnalizzatoreStudentiVotoMaggiore(int votoMinimo, Analizzatore an) {
		this.votoMinimo = votoMinimo;
		this.analizzatore = an;
	}
	
	/**
	 * Genera un Rapporto utilizzando l'analizzatore passato al costruttore oppure, in mancanza di esso, l'analizzatore Sesso.
	 * Utilizza gli studenti con voto maggiore o uguale a quello passato al costruttore.
	 * {@inheritDoc}
	 */
	@Override
	public Rapporto generaRapporto(Collection<Studente> studs) {
		return this.analizzatore.generaRapporto(studs.stream()
				.filter(s -> Integer.valueOf(s.get("MaxDiVOTO")) > this.votoMinimo)
				.collect(Collectors.toList()));
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public TipoRapporto getTipo() {
		return RapportoComposto.ASVM;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public int hashCode() {
		return Objects.hash(this.getClass(), this.votoMinimo, this.analizzatore.getClass());
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean equals(Object o) {
		if(o == this) return true;
		if(o == null || this.getClass() != o.getClass()) return false;
		AnalizzatoreStudentiVotoMaggiore a = (AnalizzatoreStudentiVotoMaggiore)o;
		return a.votoMinimo == this.votoMinimo && a.analizzatore.equals(this.analizzatore);
	}
}
