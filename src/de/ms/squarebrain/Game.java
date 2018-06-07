package de.ms.squarebrain;
/*
 * SQUAREBRAIN
 * Idee und Originalversion von Tobias Stork, Gymnasium Erding
 * Erweiterte rekursive Fassung von Dr. Matthias Spohrer, Gymnasium F�rstenried
 * Verbesserte Version 2 von 5Pixel
 */

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.IOException;
import javax.imageio.ImageIO;


/**
* Beinhaltet die Spielmechanik
* @author 5pixels
*/
public class Game
{
    
    private Window          Window;				//Spielfenster
    private Elementschlange schlange;	//Quadratschlange
    private Element         aktuellesElement;	//Zu klickendes Quadrat
    private int             zustand;				//0 = start, 1 = erster Klick ok, 2 = zweiter Klick ok, 3 = gameover, 4 = simulation, 5 = JokerFail
    private int             punktzahl;				//Spielepunktzahl
    private BufferedImage   bgimg;				//Hintergrundbild
    private boolean         imginit;			//Kontrollvariable f�r Bildimport
    private String          name;				//Playername
    private String          mode;				//Gamemode
    private String          difficulty;			//Schwierigkeit
    private Highscore       scorelist;		//Highscoreliste
    private int             size;					//Spielsteingr��e
    
    //Konstruktor
	/**
	 * @param w Breite des Fensters (Window width)
	 * @param h H�he des Fensters (Window height)
	 * @param n Name des Spielers
	 * @param mode Spielmodus
	 * @param diff Spielschwierigkeit
	 * @param size Gr��e der Spielelemente
	 */
	
    public Game(int w, int h, String n, String mode, String diff, int size){
        scorelist = new Highscore(mode);
        this.size = size;
    	Window = new Window(this, w, h);
        name = n;
        this.mode = mode;
        difficulty = diff;
        imginit = false;
        zuruecksetzen();
        allesZeichnen();
    }

    //Fenster zur�cksetzen
    /**
     * Erstellt ein neues leeres Spielfeld
     */
    public void zuruecksetzen(){
        schlange = new Elementschlange();
        aktuellesElement = new Element(Window.getW(), Window.getH(), difficulty, size);
        zustand = 0;
        punktzahl = 0;
    }
    
    //Hintergrund bild importieren
    /**
     * importiert den Spielhintergrund
     */
    public void initimg(){
    	if (imginit == false){
        	try {
                bgimg = ImageIO.read(this.getClass().getResource("tex/bg2.png"));
                imginit = true;
            } catch (IOException e) {
            }
    	}
    }

    //Spielfeld ausgeben
    /**
     * Zeichnet und aktuallisiert das Spielfeld neu
     */
    public void allesZeichnen(){
        
    	//import background
    	initimg();
        @SuppressWarnings("static-access")//ignore errors
		Graphics stift = Window.getStift();

        int[] bgDimentions = getBackgroundDimentions();


        stift.drawImage(bgimg, (int)((bgDimentions[0] - Window.getW()) * -0.5), (int)((bgDimentions[1] - Window.getH()) * -0.5), bgDimentions[0], bgDimentions[1], Window); //draw background
        
        //Anzeige
        String anzeige= "Punktzahl: " + punktzahl + " | Modus: " + mode + ", " + difficulty + " | User: " + name;
        switch(zustand){
            case 0: anzeige = "Entferne durch zweimaliges Klicken alle Quadrate in der Reihenfolge, in der sie erscheinen."; break;
            case 3: anzeige = "Punktzahl: " + punktzahl + " - Spiel zu Ende! Klicke irgendwo, um zum Menu zu gehen"; break;
            case 5: anzeige = "Punktzahl: " + punktzahl + " - Zu wenig Punkte um den Joker zu nutzen!"; break;
        }   
        stift.setColor(Color.black);
        stift.drawString(anzeige, 8, Window.getH()-8);
        
        //Zeichnen
        schlange.alleAusgeben();
        aktuellesElement.ausgeben();
        Window.repaint();
        
    }

    public int[] getBackgroundDimentions()
    {
        int windowW = Window.getW();
        int windowH = Window.getH();
        int imageW = bgimg.getWidth();
        int imageH = bgimg.getHeight();

        float multiplierW = (float)windowW / imageW;
        float multiplierH = (float)windowH / imageH;

        int newImageW = (int)(imageW * multiplierW);
        int newImageH = (int)(imageH * multiplierW);

        if(newImageH < windowH) {
            newImageW = (int)(imageW * multiplierH);
            newImageH = (int)(imageH * multiplierH);
        }

        return new int[]{newImageW, newImageH};
    }
        

    /**
     * F�hrt eine Aktion nach dem Mausklick aus
     * @param x x-Position des Klicks
     * @param y y-Position des Klicks
     */
    public void mausklick(int x, int y)
    {
        switch(zustand){
            case 3: Window.dispose();
            		Menu.frame.setVisible(true);
            		break;
            		
            default: if (aktuellesElement.getroffen(x, y)){
            		
	                schlange.hintenEinfuegen(new Element(Window.getW(), Window.getH(), difficulty, size));
	                if(aktuellesElement.getAngeklickt()){
	                    aktuellesElement = (Element)schlange.vorneEntnehmen();
	                    punktzahl++;
	                    zustand = 2;
	                }
	                else{
	                    aktuellesElement.setAngeklickt(true);
	                    zustand = 1;
	                }
	            }
	            else{
	                zustand = 3; 
	                aktuellesElement.setFail();
	                scorelist.writeScore(name, punktzahl);
	            }
        }
        allesZeichnen();
    }
    
        
    //Joker (Normal)
    /**
     * Einfache Jokerfunktion; entfernt 2 Highscorepunkte
     */
    public void joker(){
    	if(punktzahl >= 2){
    		aktuellesElement.setFail();
    		punktzahl = punktzahl - 2;
    	}else{
    		zustand = 5;
    	}
    	allesZeichnen();
    }
    
    //Joker (super)
    /**
     * Super Joker; entfernt 4 Highscorepunkte
     */
    public void sJoker(){
    	if(punktzahl >= 4){
	    	aktuellesElement.setFail();
	    	schlange.getErster().getInhalt().setNext();
	    	punktzahl = punktzahl - 4;
    	}else{
    		zustand = 5;
    	}
    	allesZeichnen();
    }
    	
}
