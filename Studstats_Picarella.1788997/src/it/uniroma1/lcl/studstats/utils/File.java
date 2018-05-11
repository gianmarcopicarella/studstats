package it.uniroma1.lcl.studstats.utils;

import it.uniroma1.lcl.studstats.Studente;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collection;

/**
 * Classe astratta che può essere estesa per dare una implementazione più specifica a seconda del file da parsare.
 * @author gianpcrx
 * 
 */
public abstract class File {
	private Path path;
	public File(String fp) { this.path = Paths.get(fp); }
	public File(Path fp) { this.path = fp; }
	
	/**
	 * 
	 * @return Un oggetto del tipo BufferedReader che consente
	 *  di leggere il file passato al costruttore della classe riga per riga.
	 */
	protected BufferedReader getBufferedReader() {
		try {
			return new BufferedReader(new FileReader(this.path.toString()));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * @return Una Collection di studenti generati tramite il parsing del file. 
	 * Ritorna una Collection vuota se il file è vuoto o viene sollevata un eccezione.
	 */
	public abstract Collection<Studente> parse();
}
