package it.uniroma1.lcl.studstats;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import it.uniroma1.lcl.studstats.dati.Analizzatore;
import it.uniroma1.lcl.studstats.dati.TipoRapporto;
import it.uniroma1.lcl.studstats.utils.File;
import it.uniroma1.lcl.studstats.utils.FileCsv;
import it.uniroma1.lcl.studstats.AggregatoreStatistico;

/**
 * Implementazione di AggregatoreStatistico 
 * che esegue un analisi degli studenti tramite gli Analizzatori forniti. 
 * @author gianpcrx
 *
 */
public class Studstats implements AggregatoreStatistico {
	
	private File file;
	private List<Studente> studenti;
	private Map<TipoRapporto, Collection<Analizzatore>> analizzatori;
	private int analizerCounter;
	
	/**
	 * Ritorna una nuova istanza della classe Studstats a partire da un filepath fornito come parametro.
	 * @param filepath Path del file da caricare.
	 * @return Un istanza della classe Studstats inizializzata con il file fornito in input.
	 */
	public static Studstats fromFile(String filepath) { return new Studstats(filepath); }
	
	private Studstats(String fp) {
		this.file = new FileCsv(fp);
		this.studenti = (ArrayList<Studente>) this.file.parse();
		this.analizzatori = new HashMap<TipoRapporto, Collection<Analizzatore>>();
	}
	
	/**
	 * {@inheritDoc}
	 * Aggiunge un nuovo Studente alla lista di studenti.
	 */
	@Override
	public void add(Studente s) {
		this.studenti.add(s);
	}
	
	/**
	 * {@inheritDoc}
	 * Aggiunge un nuovo Analizzatore alla Map.
	 */
	@Override
	public void add(Analizzatore an) {
		TipoRapporto t = an.getTipo();
		if(!analizzatori.containsKey(t)) analizzatori.put(t, new ArrayList<Analizzatore>());
		this.analizzatori.get(t).add(an);
		this.analizerCounter++;
	}

	/**
	 * {@inheritDoc}
	 * @param tipiRapporto Un array a lunghezza variabile di TipoRapporto.
	 * @return Restituisce una List di Rapporto contenente tutti i Rapporti con lo stesso tipo fornito in tipiRapporto.
	 * Se tipiRapporto è vuoto viene restituita una List di Rapporto contenente tutti i Rapporti.
	 */
	@Override
	public List<Rapporto> generaRapporti(TipoRapporto... tipiRapporto) {
		List<Rapporto> r = new ArrayList<Rapporto>();
		if(tipiRapporto.length == 0)
			this.analizzatori.entrySet().forEach(e -> {
				e.getValue().forEach(a -> r.add(a.generaRapporto(this.studenti)));
			});
		for(TipoRapporto t: tipiRapporto)
			this.analizzatori.get(t).forEach(a -> r.add(a.generaRapporto(this.studenti)));
		return r;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public int numeroAnalizzatori() {
		return this.analizerCounter;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void addAll(Analizzatore[] analizzatori) {
		for(Analizzatore an : analizzatori) this.add(an);
	}
}
