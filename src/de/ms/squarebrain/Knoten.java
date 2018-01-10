package de.ms.squarebrain;
/**
* Knoten f�r Liste
* @author 5pixels
*/
public class Knoten extends Listenelement{
    
    //Attribute
    private Listenelement naechster;
    private Datenelement inhalt;
    
    //Konstruktor
    /**
     * Erstellt einen Knoten
     * @param n N�chster Knoten
     * @param i Inhalt
     */
    public Knoten(Listenelement n, Datenelement i){
        naechster = n;
        inhalt = i;
    }
    
    //Methoden
    public void naechsterSetzen(Listenelement n){
        naechster = n;
    }

	/**
	 * Gibt n�chsten zur�ck
	 * @return {@link #naechster}
	 */
    public Listenelement getNext(){
        return naechster;
    }
    
    /**
     * Gibt Inhalt zur�ck
     * @return {@link #inhalt}
     */
    public Datenelement getInhalt(){
        return inhalt;
    }
    
    /**
     * Einen Knoten hinten in der Schlange einf�gen
     * @return this
     */
    public Knoten hintenEinfuegen(Datenelement knoteninhalt){
        naechster = naechster.hintenEinfuegen(knoteninhalt);
        return this;
    }
    
    /**
     * Gibt Daten f�rs Zeichnen aus
     */
    public void getListendaten(){
        inhalt.ausgeben();
        naechster.getListendaten();
    }
    
    /**
     * Abschluss oder nicht?
     * @return inhalt.getAbschluss()
     */
    public boolean getAbschluss(){
    	return inhalt.getAbschluss();
    }
}
