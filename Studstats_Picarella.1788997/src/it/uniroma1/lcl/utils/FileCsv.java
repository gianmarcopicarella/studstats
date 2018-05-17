package it.uniroma1.lcl.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import it.uniroma1.lcl.studstats.Studente;
/**
 * Parser di un file csv contenente dati riguardo gli studenti di informatica presso la Sapienza.
 * @author gianpcrx
 */
public class FileCsv extends File {
	
	/**
	 * 
	 * @param fp Stringa rappresentante la posizione (relativa o assoluta) del file.
	 */
	public FileCsv(String fp) { super(fp); }
	
	/**
	 * {@inheritDoc}
	 * Implementa un metodo parse più specifico adatto ad eseguire il parse di un file csv
	 * contenente degli studenti riga per riga.
	 * @return Una collezione di studenti ottenuti dal file csv oppure una collezione vuota in caso di file vuoto o inesistente.
	 */
	@Override
	public Collection<Studente> parse() {
		Collection<Studente> studenti = new ArrayList<Studente>();
		try(BufferedReader br = this.getBufferedReader())
		{
			String[] keys = br.readLine().split(";");
			while(br.ready()) studenti.add(new Studente(keys, br.readLine().split(";")));
			return studenti;
		}
		catch(IOException e)
		{
			e.printStackTrace();
			return studenti;
		}
	}
}
