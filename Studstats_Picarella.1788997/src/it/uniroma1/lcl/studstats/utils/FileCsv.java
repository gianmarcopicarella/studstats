package it.uniroma1.lcl.studstats.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import it.uniroma1.lcl.studstats.Studente;

public class FileCsv extends File {
	
	public FileCsv(String fp) {
		super(fp);
	}
	
	@Override
	public Collection<Studente> parse() {
		// TODO Auto-generated method stub
		Collection<Studente> studenti = new ArrayList<Studente>();
		try(BufferedReader br = this.getBufferedReader())
		{
			//Leggo le chiavi del file
			String[] keys = br.readLine().split(";");
			while(br.ready()) studenti.add(new Studente(keys, br.readLine().split(";")));
			return studenti;
		}
		catch(IOException e)
		{
			// gestisci l�eccezione di I/O
			e.printStackTrace();
			return null;
		}
	}

}
