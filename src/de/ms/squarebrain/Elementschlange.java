package de.ms.squarebrain;

/**
* Schlange f�r Elemente
* @author 5pixels
*/
public class Elementschlange{
    //Attribute
    private Listenelement erster;
    
    //Konstruktor
    /**
     * Erstellt Schlange f�r Elemente
     */
    public Elementschlange(){
    	erster = new Abschluss();
    }
    
    //Methoden
    /**
     * F�gt Knoten hinten in Schlange ein
     * @param knoteninhalt Inhalt des Knotens
     */
    public void hintenEinfuegen(Datenelement knoteninhalt){
        erster = erster.hintenEinfuegen(knoteninhalt);
    }
    
    /**
     * Entfernt vorne einen Knoten
     * @return entfernter Knoten
     */
    public Datenelement vorneEntnehmen(){
        Datenelement alterKnoteninhalt = erster.getInhalt();
        erster = erster.getNext();
        return alterKnoteninhalt;
    }
    
    /**
     * Gibt alle Knoten aus
     */
    public void alleAusgeben(){
        erster.getListendaten();
    }
    
    /**
     * Gibt ersten Knoten zur�ck
     * @return erster Knoten
     */
    public Listenelement getErster(){
		return erster;
    	
    }
}
