package it.uniroma1.lcl.studstats.dati;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

import it.uniroma1.lcl.studstats.Rapporto;
import it.uniroma1.lcl.studstats.Studente;

public interface Analizzatore
{
    Rapporto generaRapporto(Collection<Studente> studs);
    
    static Map<String, Integer> filterByKeyDescendant(Collection<Studente> studs, String key) {
    		return studs.stream().collect(Collectors.toMap(
    				s -> ((Studente) s).get(key), s -> 1, 
    				(s1, s2) -> s1 + s2, TreeMap::new))
    				.descendingMap();
    }
    
    static Map<String, Integer> reduceByKeyToMap(Collection<Studente> studs, String key){
    		return filterByKeyDescendant(studs, key).entrySet()
    				.stream().sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
    				.collect(Collectors.toMap(i -> i.getKey(), i -> i.getValue(), (i1, i2) -> i1, LinkedHashMap::new));
    }
    
    TipoRapporto getTipo();
}