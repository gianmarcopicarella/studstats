package it.uniroma1.lcl.studstats.utils;

import java.util.Collection;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

import it.uniroma1.lcl.studstats.Studente;

/**
 * Classe contenente funzioni utili per operare su mappe. 
 * @author gianpcrx
 *
 */
public final class Utils {
	/**
     * @param studs Una Collection di Studente
     * @param key La chiave per cui si vuole contare
     * @return Una mappa ordinata in modo decrescente (in base alle chiavi). Ogni Entry contiene per chiave il 
     * campo passato come parametro e per valore il numero degli studenti 
     * che possiede quella determinata chiave nei propri campi.
     */
    public static TreeMap<String, Integer> contaPerChiave(Collection<Studente> studs, String key) {
    		return studs.stream().collect(Collectors.toMap(s -> s.get(key), s -> 1, 
    				(s1, s2) -> s1 + s2, TreeMap::new));
    }
    
    /**
     * @param studs Una Collection di Studente
     * @param key La chiave per cui si vuole contare
     * @return Una mappa ordinata in modo decrescente (in base ai valori). Ogni Entry contiene per chiave il 
     * campo passato come parametro e per valore il numero degli studenti 
     * che possiede quella determinata chiave nei propri campi.
     */
    public static Map<String, Integer> contaPerChiaveEOrdinaPerValoriDecrescenti(Collection<Studente> studs, String key){
    		return ordinaPerValori(contaPerChiave(studs, key), 
    				Map.Entry.<String, Integer>comparingByValue().reversed());
    	
    }
    
    /**
     * Prende in ingresso una mappa e restituisce una nuova mappa ordinata per valore.
     * @param map La mappa da ordinare per valore
     * @param c Il Comparator da utilizzare nell'ordinamento
     * @return Una nuova mappa ordinata per valore
     */
    public static Map<String, Integer> ordinaPerValori(Map<String, Integer> map, Comparator<Map.Entry<String, Integer>> c){
    	return map.entrySet().stream().sorted(c)
    			.collect(Collectors.toMap(i -> i.getKey(), i -> i.getValue(), (i1, i2) -> i1, LinkedHashMap::new));
    }
}
