package it.uniroma1.lcl.studstats.dati;

import java.util.Map;

import it.uniroma1.lcl.studstats.analizzatori.AnalizzatoreAnnoDiploma;
import it.uniroma1.lcl.studstats.analizzatori.AnalizzatoreIstituti;
import it.uniroma1.lcl.studstats.analizzatori.AnalizzatoreMediaStudentiItalianiPerRegione;
import it.uniroma1.lcl.studstats.analizzatori.AnalizzatoreSesso;
import it.uniroma1.lcl.studstats.analizzatori.AnalizzatoreStudentiVotoMaggiore;
import it.uniroma1.lcl.studstats.analizzatori.AnalizzatoreTitoloDiStudio;
import it.uniroma1.lcl.studstats.analizzatori.AnalizzatoreVoto;
/**
 * Interfaccia che istanzia gli analizzatori di base
 * (e' possibile sostituire i metodi con una propria
 * implementazione lambda)
 *
 * @author gianpcrx
 *
 */
public interface Analizzatori {
	/**
	 * 
	 * @return Una nuova istanza della classe AnalizzatoreAnnoDiploma.
	 */
	static Analizzatore annoDiploma() { return new AnalizzatoreAnnoDiploma(); }
	/**
	 * 
	 * @return Una nuova istanza della classe AnalizzatoreIstituti.
	 */
    static Analizzatore istituti() { return new AnalizzatoreIstituti(); }
    /**
	 * 
	 * @return Una nuova istanza della classe AnalizzatoreSesso.
	 */
    static Analizzatore sesso() { return new AnalizzatoreSesso(); }
    /**
	 * 
	 * @return Una nuova istanza della classe AnalizzatoreTitoloDiStudio.
	 */
    static Analizzatore titoloDiStudio() { return new AnalizzatoreTitoloDiStudio(); }
    /**
	 * 
	 * @return Una nuova istanza della classe AnalizzatoreVoto.
	 */
    static Analizzatore voto() { return new AnalizzatoreVoto(); }
    /**
	 * @param voto Voto utilizzato per selezionare gli studenti da analizzare.
	 * @return Una nuova istanza della classe AnalizzatoreStudentiVotoMaggiore.
	 */
    static Analizzatore studentiVotoMaggiore(int voto) { 
    	return new AnalizzatoreStudentiVotoMaggiore(voto); 
    }
    /**
	 * @param voto Voto utilizzato per selezionare gli studenti da analizzare.
	 * @param a Analizzatore utilizzato nel metodo generaRapporto.
	 * @return Una nuova istanza della classe AnalizzatoreStudentiVotoMaggiore.
	 */
    static Analizzatore studentiVotoMaggiore(int voto, Analizzatore a) { 
    	return new AnalizzatoreStudentiVotoMaggiore(voto, a); 
    }
    
    /**
     * 
     * @return Una nuova istanza della classe AnalizzatoreMediaStudentiItalianiPerRegione.
     */
    static Analizzatore analizzatoreBonus() {
    	return new AnalizzatoreMediaStudentiItalianiPerRegione(Map.Entry.<String, Integer>comparingByValue().reversed());
    }
    
    /**
	 * 
	 * @return Un array che contiene istanze di tutti gli analizzatori semplici.
	 */
    static Analizzatore[] allBasic() { 
    	return new Analizzatore[]{ annoDiploma(), istituti(), sesso(), titoloDiStudio(), voto() }; 
    }
}
