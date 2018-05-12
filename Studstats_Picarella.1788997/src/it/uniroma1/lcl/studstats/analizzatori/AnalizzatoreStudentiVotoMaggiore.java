package it.uniroma1.lcl.studstats.analizzatori;

import java.util.Collection;
import java.util.stream.Collectors;

import it.uniroma1.lcl.studstats.Rapporto;
import it.uniroma1.lcl.studstats.Studente;
import it.uniroma1.lcl.studstats.dati.Analizzatore;
import it.uniroma1.lcl.studstats.dati.RapportoComposto;
import it.uniroma1.lcl.studstats.dati.TipoRapporto;

public class AnalizzatoreStudentiVotoMaggiore implements Analizzatore {
	
	private int votoMinimo;
	private Analizzatore analizzatore;
	
	public AnalizzatoreStudentiVotoMaggiore(int votoMinimo) {
		this.votoMinimo = votoMinimo;
		this.analizzatore = new AnalizzatoreSesso();
	}
	
	public AnalizzatoreStudentiVotoMaggiore(int votoMinimo, Analizzatore an) {
		this.votoMinimo = votoMinimo;
		this.analizzatore = an;
	}

	@Override
	public Rapporto generaRapporto(Collection<Studente> studs) {
		return this.analizzatore.generaRapporto(studs.stream()
				.filter(s -> Integer.valueOf(s.get("MaxDiVOTO")) > this.votoMinimo)
				.collect(Collectors.toList()));
	}
	
	@Override
	public TipoRapporto getTipo() {
		return RapportoComposto.ASVM;
	}

}
