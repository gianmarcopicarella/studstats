package it.uniroma1.lcl.studstats;

import it.uniroma1.lcl.studstats.dati.AnalizzatoreAnnoDiploma;
import it.uniroma1.lcl.studstats.dati.AnalizzatoreIstituti;
import it.uniroma1.lcl.studstats.dati.AnalizzatoreSesso;
import it.uniroma1.lcl.studstats.dati.AnalizzatoreTitoloDiStudio;
import it.uniroma1.lcl.studstats.dati.AnalizzatoreVoto;
import it.uniroma1.lcl.studstats.dati.Analizzatori;
import it.uniroma1.lcl.studstats.dati.Rapporto;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Studstats s =Studstats.fromFile(StudstatsTest.PERCORSO);
		//s.add(new AnalizzatoreAnnoDiploma());
		s.addAll(Analizzatori.allBasic());
		
		
		for(Rapporto r : s.generaRapporti()) {
			System.out.println(r);
		}
		
	}

}
