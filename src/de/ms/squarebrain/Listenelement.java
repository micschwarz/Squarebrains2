package de.ms.squarebrain;

/**
* Listenelement
* @author 5pixels
*/
public abstract class Listenelement
{
   public abstract Listenelement getNext();
   public abstract Datenelement getInhalt();
   public abstract Knoten hintenEinfuegen(Datenelement knoteninhalt);
   public abstract void getListendaten();
   public abstract boolean getAbschluss();

}
