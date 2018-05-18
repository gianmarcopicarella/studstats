package it.uniroma1.lcl.studstats.dati;
/**
 * Enum che implementa l'interfaccia segnaposto TipoRapporto. 
 * Viene utilizzato per specificare il tipo di Rapporto ritornato da un Analizzatore e 
 * per indicare Analizzatori che prendono parametri nel costruttore.
 * @author gianpcrx
 *
 */
public enum RapportoComposto implements TipoRapporto {
	ASVM, AMSIPR;
}
