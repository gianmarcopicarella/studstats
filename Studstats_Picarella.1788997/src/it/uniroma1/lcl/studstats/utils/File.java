package it.uniroma1.lcl.studstats.utils;

import it.uniroma1.lcl.studstats.Studente;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collection;

public abstract class File {
	private Path path;
	
	public File(String fp) {
		this.path = Paths.get(fp);
	}
	
	public File(Path fp) {
		this.path = fp;
	}
	
	protected BufferedReader getBufferedReader() {
		try {
			return new BufferedReader(new FileReader(this.path.toString()));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public abstract Collection<Studente> parse();
}
