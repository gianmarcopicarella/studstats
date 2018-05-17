package it.uniroma1.lcl.dati;

import java.util.Collection;

import it.uniroma1.lcl.studstats.Studente;

/**
 * Interfaccia che consente di implementare un Analizzatore specifico. 
 * Contiene inoltre diversi metodi helper statici per operare con Map e Collection.
 * @author gianpcrx
 *
 */
public interface Analizzatore
{
	/**
     * Restituisce il tipo di rapporto che genera l’analizzatore
     * NOTA BENE: questo metodo può essere implementato di default
     * utilizzando le annotazioni che saranno viste a lezione
     * venerdì (e, per la teledidattica e gli assenti, spiegate su
     * diapositive) OPPURE può essere lasciato astratto e
     * implementato in ciascuna sottoclasse (richiedendo la
     * specifica in ciascuna implementazione di Analizzatore). In
     * questo secondo caso non sara’ possibile utilizzare le lambda
     * per implementare gli analizzatori base.
     * @param studs Una Collection di Studente.
     * @return Un rapporto contente le informazioni ottenute dall'analizzatore sottoforma di mappa.
     */
    Rapporto generaRapporto(Collection<Studente> studs);
    
    /**
     * @return Il tipo di rapporto ritornato dal metodo generaRapporto.
     */
    TipoRapporto getTipo();
}