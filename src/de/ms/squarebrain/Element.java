package de.ms.squarebrain;
import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

/**
* Spielstein
* @author 5pixels
*/
public class Element implements Datenelement{
    private Random zufallsgenerator;
    private int x, y;				//Position
    private boolean angeklickt;		
    private Image sqr; 				//square texture
    private int col; 				//square texture number
    private String difficulty;		//Schwierigkeit
    private int size;
    private boolean fail;
    private boolean tri;
    private boolean next;
    
    /**
     * Erstellt ein Element f�r das Spielfeld
     * @param w Fensterbreite
     * @param h Fensterh�he
     * @param diff Schwierigkeitsgrad
     * @param size Spielsteingr��e
     */
    public Element(int w, int h, String diff, int size){
    	fail = false;
    	next = false;
    	this.size = size;
    	difficulty = diff;
    	zufallsgenerator = new Random();
        x = zufallsgenerator.nextInt(w-20);
        y = zufallsgenerator.nextInt(h-40);
        col = zufallsgenerator.nextInt(6 - 0 + 1) + 0;
        angeklickt = false;
        tri = false;
        
    }

    public void setAngeklickt(boolean angeklicktNeu){
        angeklickt = angeklicktNeu;
    }

    public boolean getAngeklickt(){
        return angeklickt;
    }
    
    public boolean getroffen(int xPunkt, int yPunkt){
        return xPunkt>=x && xPunkt<x+size && yPunkt>=y && yPunkt<y+size;
    }
    
    public void setFail(){
    	fail = true;
    }
    
    public void setNext(){
    	next = true;
    }
    
    //load texture
    public void initimg(){
    	try{
    		switch(col){
    			case 0: sqr = ImageIO.read(this.getClass().getResource("sqr/sqr01.png")); break;
    		
    			case 1: sqr = ImageIO.read(this.getClass().getResource("sqr/sqr02.png")); break;
    		
    			case 2: sqr = ImageIO.read(this.getClass().getResource("sqr/sqr03.png")); break;
    		
    			case 3: sqr = ImageIO.read(this.getClass().getResource("sqr/sqr04.png")); break;
    		
    			case 4: if(difficulty == "Easy"){sqr = ImageIO.read(this.getClass().getResource("tri/tri05.png"));
						tri = true;
						}else{sqr = ImageIO.read(this.getClass().getResource("sqr/sqr05.png"));} break;
    			
    			case 5: if(difficulty == "Easy"){sqr = ImageIO.read(this.getClass().getResource("tri/tri06.png"));
    					tri = true;
    					}else{sqr = ImageIO.read(this.getClass().getResource("sqr/sqr06.png"));} break;
    		
    			case 6: if(difficulty == "Easy"){sqr = ImageIO.read(this.getClass().getResource("tri/tri07.png"));
    					tri = true;
						}else{sqr = ImageIO.read(this.getClass().getResource("sqr/sqr07.png"));} break;
    			
    			case 7: if(tri){sqr = ImageIO.read(this.getClass().getResource("tri/triklck.png"));
    					}else{sqr = ImageIO.read(this.getClass().getResource("sqr/sqrklck.png"));} break;
    			
    			case 8: if(tri){sqr = ImageIO.read(this.getClass().getResource("tri/trifail.png"));
						}else{sqr = ImageIO.read(this.getClass().getResource("sqr/sqrfail.png"));} break;
						
    			case 9: if(tri){sqr = ImageIO.read(this.getClass().getResource("tri/trinxt.png"));
						}else{sqr = ImageIO.read(this.getClass().getResource("sqr/sqrnxt.png"));} break;
    		
    			default: if(tri){sqr = ImageIO.read(this.getClass().getResource("tri/trifail.png"));
						 }else{sqr = ImageIO.read(this.getClass().getResource("sqr/sqrfail.png"));} break;
    			
    			
    		}
    	} catch (IOException e) {
			e.printStackTrace();
		} 
    }
    
    /**
     * Abschluss oder nicht?
     * return false
     */
    public boolean getAbschluss(){
    	return false;
    }

    public void ausgeben(){
        Graphics stift = Window.getStift();
        if (difficulty == "Hard"){
        	col = 5;
        }
        if(fail){
        	col = 8;
        }else if(next){
        	col = 9;
        }
        if (angeklickt){
            col = 7;
        }
        initimg();
        stift.drawImage(sqr, x, y, size, size, null);
    }
    
    /**
     * x-Position
     * @return {@link #x}
     */
    public int getX(){
    	return x;
    }
    
    /**
     * y-Position
     * @return {@link #y}
     */
    public int getY(){
    	return y;
    }
}
