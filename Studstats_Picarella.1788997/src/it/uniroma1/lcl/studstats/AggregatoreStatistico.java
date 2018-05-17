package it.uniroma1.lcl.studstats;

import java.util.List;

import it.uniroma1.lcl.dati.Analizzatore;
import it.uniroma1.lcl.dati.Rapporto;
import it.uniroma1.lcl.dati.TipoRapporto;

public interface AggregatoreStatistico {
	/**
     * Aggiunge uno studente per l'analisi
     * @param s Studente da aggiungere.
     */
    void add(Studente s);
    
    /**
     * Aggiunge un Analizzatore all'aggregatore
     * @param an Analizzatore da aggiungere.
     */
    void add(Analizzatore an);
    /**
     * Genera i rapporti dei tipi specificati 
     * (tutti i tipi se non viene specificato nessun tipo)
     * @param tipiRapporto I tipi di cui si vogliono i rapporti.
     * @return la lista dei rapporti generati.
     */
    List<Rapporto> generaRapporti(TipoRapporto... tipiRapporto);
    
    /**
     * Restituisce il numero di analizzatori memorizzati.
     * @return Il numero di Analizzatore memorizzati.
     */
    int numeroAnalizzatori();
    
    /**
     * Aggiunge all'AggregatoreStatistico tutti gli analizzatori presenti nell'array.
     * @param analizzatori Array di Analizzatore da aggiungere all'AggregatoreStatistico.
     */
    default void addAll(Analizzatore[] analizzatori) {
    	for(Analizzatore a : analizzatori) add(a);
    }
}
