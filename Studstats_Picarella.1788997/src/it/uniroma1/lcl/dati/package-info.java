/**
 * 
 */
/**
 * 
 * Package contenente le classi di analisi, i rapporti, gli enum e le interfaccie necessarie ad esse.
 * Analizzatore è un interfaccia che descrive la struttura di un tipico analizzatore.
 * Analizzatori è un interfaccia che viene utilizzata per istanziare i diversi analizzatori.
 * TipoRapporto è un interfaccia implementata da ogni enum che descrive il tipo di Rapporto. Questo consente la futura creazione di nuovi enum senza dover rifattorizzare alcune parti di codice.
 * AnalizzatoreAnnoDiploma è una classe che esegue analisi sulle date di diploma dei vari studenti.
 * AnalizzatoreIstituti è una classe che esegue analisi sui vari istituti frequentati dagli studenti.
 * AnalizzatoreMediaStudentiItalianiPerRegione è una classe (bonus) che esegue analisi sulla media regionale dei vari studenti.
 * AnalizzatoreSesso è una classe che esegue un'analisi sul numero di Studenti maschi e femmine.
 * AnalizzatoreStudentiVotoMaggiore è una classe che esegue un'analisi solo sugli studenti con voto maggiore a quello specificato.
 * AnalizzatoreTitoloDiStudio è una classe che esegue un'analisi contando il numero di titoli di studio.
 * AnalizzatoreVoto è una classe che esegue un'analisi del voto di maturità massimo, minimo, mediano e medio dei vari studenti.
 * Rapporto è una classe contenente una mappa con tutte le informazioni dell'analisi eseguita da un'analizzatore qualsiasi. 
 * RapportoComposto è l'enum utilizzato per indicare il tipo di Rapporto di ogni analizzatore composto (prende uno o più parametri tramite il costruttore).
 * RapportoSemplice è l'enum utilizzato per indicare il tipo di Rapporto di ogni analizzatore semplice (prende zero parametri tramite il costruttore). 
 * 
 * @since 1.0
 * @author gianpcrx
 * @version 1.0
 */
package it.uniroma1.lcl.dati;