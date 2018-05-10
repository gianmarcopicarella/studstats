package it.uniroma1.lcl.studstats.dati;

import it.uniroma1.lcl.studstats.analizzatori.AnalizzatoreAnnoDiploma;
import it.uniroma1.lcl.studstats.analizzatori.AnalizzatoreIstituti;
import it.uniroma1.lcl.studstats.analizzatori.AnalizzatoreSesso;
import it.uniroma1.lcl.studstats.analizzatori.AnalizzatoreStudentiVotoMaggiore;
import it.uniroma1.lcl.studstats.analizzatori.AnalizzatoreTitoloDiStudio;
import it.uniroma1.lcl.studstats.analizzatori.AnalizzatoreVoto;

public interface Analizzatori {
	static Analizzatore annoDiploma() { return new AnalizzatoreAnnoDiploma(); }
    static Analizzatore istituti() { return new AnalizzatoreIstituti(); }
    static Analizzatore sesso() { return new AnalizzatoreSesso(); }
    static Analizzatore titoloDiStudio() { return new AnalizzatoreTitoloDiStudio(); }
    static Analizzatore voto() { return new AnalizzatoreVoto(); }
    static Analizzatore studentiVotoMaggiore(int voto) { 
    	return new AnalizzatoreStudentiVotoMaggiore(voto); 
    }
    static Analizzatore studentiVotoMaggiore(int voto, Analizzatore a) { 
    	return new AnalizzatoreStudentiVotoMaggiore(voto, a); 
    }
    static Analizzatore[] allBasic() { 
    	return new Analizzatore[]{ annoDiploma(), istituti(), sesso(), titoloDiStudio(), voto() }; 
    }
}
