package it.uniroma1.lcl.studstats;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

import it.uniroma1.lcl.studstats.AggregatoreStatistico;
import it.uniroma1.lcl.studstats.dati.Analizzatore;
import it.uniroma1.lcl.studstats.dati.Rapporto;
import it.uniroma1.lcl.studstats.dati.TipoRapporto;
import it.uniroma1.lcl.studstats.utils.File;
import it.uniroma1.lcl.studstats.utils.FileCsv;

/**
 * Implementazione di AggregatoreStatistico 
 * che esegue un analisi degli studenti tramite gli Analizzatori forniti. 
 * @author gianpcrx
 *
 */
public class Studstats implements AggregatoreStatistico {
	/**
	 * File da cui leggere i dati dei vari studenti.
	 */
	private File file;
	/**
	 * Lista di studenti su cui effettuare le operazioni di analisi.
	 */
	private List<Studente> studenti;
	/**
	 * LinkedHashSet contenente tutti gli Analizzatori aggiunti nell'oggetto corrente.
	 */
	private LinkedHashSet<Analizzatore> analizzatori;
	
	/**
	 * Ritorna una nuova istanza della classe Studstats a partire da un filepath fornito come parametro.
	 * @param filepath Path del file da caricare.
	 * @return Un istanza della classe Studstats inizializzata con il file fornito in input.
	 */
	public static Studstats fromFile(String filepath) { return new Studstats(filepath); }
	
	/**
	 * Ritorna una nuova istanza della classe Studstats a partire da un oggetto di tipo Path fornito come parametro.
	 * @param fp Oggetto Path del file da caricare.
	 * @return Un istanza della classe Studstats inizializzata con il file fornito in input.
	 */
	public static Studstats fromFile(Path fp) { return new Studstats(fp.toString()); }
	
	/**
	 * Inizializza l'oggetto tramite il parametro fp di tipo String
	 * @param fp
	 */
	private Studstats(String fp) {
		this.file = new FileCsv(fp);
		this.studenti = (ArrayList<Studente>) this.file.parse();
		this.analizzatori = new LinkedHashSet<Analizzatore>();
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
	 * Aggiunge un nuovo Analizzatore alla LinkedHashSet di Studstats.
	 */
	@Override
	public void add(Analizzatore an) {
		this.analizzatori.add(an);
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
			this.analizzatori.forEach(a -> r.add(a.generaRapporto(this.studenti)));
		
		for(TipoRapporto t : tipiRapporto) {
			for(Analizzatore a : this.analizzatori) {
				if(a.getTipo() == t) {
					r.add(a.generaRapporto(this.studenti));
					break;
				}
			}
		}
		return r;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public int numeroAnalizzatori() {
		return this.analizzatori.size();
	}
}