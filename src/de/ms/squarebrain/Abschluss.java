package de.ms.squarebrain;
/**
* Abschlusselement
* @author 5pixels
*/
class Abschluss extends Listenelement{
    

	/**
	 * Gibt n�chsten zur�ck
	 * @return this
	 */
    public Listenelement getNext(){
        return this;
    }
    
    /**
     * Gibt Inhalt zur�ck
     * @return null
     */
    public Datenelement getInhalt(){
        return null;
    }
    
    /**
     * Einen Knoten hinten in der Schlange einf�gen
     * @return neuen Knoten
     */
    public Knoten hintenEinfuegen(Datenelement knoteninhalt){
        return new Knoten(this, knoteninhalt);
    }
    
    /**
     * Gibt Daten f�rs Zeichnen aus
     */
    public void getListendaten(){
    }

    /**
     * Abschluss oder nicht?
     * @return true
     */
    public boolean getAbschluss(){
    	return true;
    }

    
}