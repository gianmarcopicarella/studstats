package it.uniroma1.lcl.studstats.dati;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

import it.uniroma1.lcl.studstats.Rapporto;
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
     * @param studs Una Collection di Studente
     * @param key La chiave per cui si vuole contare
     * @return Una mappa ordinata in modo decrescente (in base alle chiavi). Ogni Entry contiene per chiave il 
     * campo passato come parametro e per valore il numero degli studenti 
     * che possiede quella determinata chiave nei propri campi.
     */
    static TreeMap<String, Integer> filterByKey(Collection<Studente> studs, String key) {
    		return studs.stream().collect(Collectors.toMap(
    				s -> ((Studente) s).get(key), s -> 1, 
    				(s1, s2) -> s1 + s2, TreeMap::new));
    }
    
    /**
     * @param studs Una Collection di Studente
     * @param key La chiave per cui si vuole contare
     * @return Una mappa ordinata in modo decrescente (in base ai valori). Ogni Entry contiene per chiave il 
     * campo passato come parametro e per valore il numero degli studenti 
     * che possiede quella determinata chiave nei propri campi.
     */
    static Map<String, Integer> reduceByKeyToMap(Collection<Studente> studs, String key){
    		return filterByKey(studs, key).entrySet()
    				.stream().sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
    				.collect(Collectors.toMap(i -> i.getKey(), i -> i.getValue(), (i1, i2) -> i1, LinkedHashMap::new));
    }
    
    /**
     * @return Il tipo di rapporto ritornato dal metodo generaRapporto.
     */
    TipoRapporto getTipo();
}