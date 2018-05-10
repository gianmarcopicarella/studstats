package it.uniroma1.lcl.studstats;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import it.uniroma1.lcl.studstats.dati.Analizzatore;
import it.uniroma1.lcl.studstats.dati.TipoRapporto;
import it.uniroma1.lcl.studstats.utils.File;
import it.uniroma1.lcl.studstats.utils.FileCsv;
import it.uniroma1.lcl.studstats.AggregatoreStatistico;

public class Studstats implements AggregatoreStatistico {
	
	private File file;
	private List<Studente> studenti;
	private Collection<Analizzatore> analizzatori;
	
	public static Studstats fromFile(String filepath) {
		return new Studstats(filepath);
	}
	
	private Studstats(String fp) {
		this.file = new FileCsv(fp);
		this.studenti = (ArrayList<Studente>) this.file.parse();
		this.analizzatori = new ArrayList<Analizzatore>();
	}
	
	@Override
	public void add(Studente s) {
		this.studenti.add(s);
	}

	@Override
	public void add(Analizzatore an) {
		this.analizzatori.add(an);
	}

	@Override
	public List<Rapporto> generaRapporti(TipoRapporto... tipiRapporto) {
		ArrayList<Rapporto> r = new ArrayList<Rapporto>();
		if(tipiRapporto.length == 0) 
			this.analizzatori.forEach(a -> r.add(a.generaRapporto(this.studenti)));
		
		this.analizzatori.forEach(a -> {
			for(TipoRapporto t : tipiRapporto) 
				if(a.getTipo() == t) {
					r.add(a.generaRapporto(this.studenti));
					break;
				}
		});
		return r;
	}

	@Override
	public int numeroAnalizzatori() {
		return this.analizzatori.size();
	}
}
