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

public class Studstats implements AggregatoreStatistico {
	
	private File file;
	private List<Studente> studenti;
	private Map<TipoRapporto, Collection<Analizzatore>> analizzatori;
	private int analizerCounter;
	
	public static Studstats fromFile(String filepath) {
		return new Studstats(filepath);
	}
	
	private Studstats(String fp) {
		this.file = new FileCsv(fp);
		this.studenti = (ArrayList<Studente>) this.file.parse();
		this.analizzatori = new HashMap<TipoRapporto, Collection<Analizzatore>>();
	}
	
	@Override
	public void add(Studente s) {
		this.studenti.add(s);
	}

	@Override
	public void add(Analizzatore an) {
		TipoRapporto t = an.getTipo();
		if(!analizzatori.containsKey(t)) analizzatori.put(t, new ArrayList<Analizzatore>());
		this.analizzatori.get(t).add(an);
		this.analizerCounter++;
	}

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

	@Override
	public int numeroAnalizzatori() {
		return this.analizerCounter;
	}

	@Override
	public void addAll(Analizzatore[] analizzatori) {
		for(Analizzatore an : analizzatori) this.add(an);
	}
}
