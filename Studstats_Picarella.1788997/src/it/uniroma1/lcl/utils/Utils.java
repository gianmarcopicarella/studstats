package it.uniroma1.lcl.utils;

import java.util.AbstractMap;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

import it.uniroma1.lcl.studstats.Studente;

/**
 * Classe contenente funzioni utili per operare su mappe. 
 * @author gianpcrx
 *
 */
public final class Utils {
	
	public static final Comparator<Map.Entry<String, Integer>> VALORIDECRESCENTI = Map.Entry.<String, Integer>comparingByValue().reversed();
	public static final Comparator<Map.Entry<String, Integer>> CHIAVIDECRESCENTI = Map.Entry.<String, Integer>comparingByKey().reversed();
	
	
	/**
	 * Conta le occorrenze di una determinata chiave su una Collection di oggetti Studente.
     * @param studs Una Collection di oggetti Studente.
     * @param key La chiave per cui si vuole contare.
     * @return Una mappa ordinata in modo decrescente (in base alle chiavi). Ogni Entry contiene per chiave il 
     * campo passato come parametro e per valore il numero degli studenti 
     * che possiede quella determinata chiave nei propri campi.
     */
    public static HashMap<String, Integer> contaPerChiave(Collection<Studente> studs, String key) {
    		return studs.stream().collect(Collectors.toMap(s -> s.get(key), s -> 1, 
    				(s1, s2) -> s1 + s2, HashMap::new));
    }
    
    /**
     * Conta e ordina una mappa tramite la chiave ed il Comparator fornito.
     * @param studs Una Collection di oggetti Studente.
     * @param key Una chiave da utilizzare per filtrare.
     * @param c Un Comparator utilizzato per ordinare la Mappa.
     * @return Una mappa contenente come chiavi, 
     * le chiavi identificate dal parametro key e come valore, 
     * il numero di studenti che possiede quella determinata chiave.
     */
    public static LinkedHashMap<String, Integer> contaPerChiaveEOrdina(Collection<Studente> studs, String key, Comparator<Map.Entry<String, Integer>> c){
    	return ordinaMappa(contaPerChiave(studs, key), c);
    }
    
    /**
     * Prende in ingresso una mappa e restituisce una nuova mappa ordinata tramite il Comparator fornito.
     * @param map La mappa da ordinare.
     * @param c Il Comparator da utilizzare nell'ordinamento.
     * @return Una nuova mappa ordinata tramite il Comparator fornito.
     */
    public static LinkedHashMap<String, Integer> ordinaMappa(AbstractMap<String, Integer> map, Comparator<Map.Entry<String, Integer>> c){
    	return map.entrySet().stream().sorted(c)
    			.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (i1, i2) -> i1, LinkedHashMap::new));
    }
}
