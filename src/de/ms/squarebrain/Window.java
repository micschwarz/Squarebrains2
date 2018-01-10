package de.ms.squarebrain;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

/**
* Fenster f�r Spiel
* @author 5pixels
*/
public class Window extends JFrame{
	
	private int w,h; 									//width, height
	private static final long serialVersionUID = 1L;	//Variable Version
	private JPanel inhalt;								//Fensterinhalt
    private Graphics stift;								//Zeichentool
    private Image bild;									//Zeichenfl�che
    private static Window aktuell;						//Aktuelles Fenster

    /**
     * Erstellt Fenster f�r Spiel
     * @param spiel das zu zeichnende Spiel
     * @param w Fensterbreite
     * @param h Fensterh�he
     */
    public Window(final Game spiel, int w, int h){
        super("Squarebrain");
        setTitle("Squarebrain");
        setIconImage(Toolkit.getDefaultToolkit().getImage(Menu.class.getResource("/com/pixels/squarebrain/main/tex/logoS.png")));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        setFocusable(true);
        inhalt = new JPanel(){
			private static final long serialVersionUID = 1L; //UID
			public void paint(Graphics g){
                g.drawImage(bild, 0, 0, null);
            }
        };
        
        //Menubar
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		//Menubar 
		JMenu mnGame = new JMenu("Game");
		menuBar.add(mnGame);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Menu.frame.setVisible(true);
			}
		});
		mntmExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, InputEvent.ALT_MASK));
		mnGame.add(mntmExit);
		
		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);
		
		JMenuItem mntmTutorial = new JMenuItem("Tutorial");
		mntmTutorial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new TutorialPop();
			}
		});
		mntmTutorial.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H, InputEvent.ALT_MASK));
		mnHelp.add(mntmTutorial);
		
		JMenu mnJoker = new JMenu("Joker");
		mnHelp.add(mnJoker);
		
		JMenuItem mntmNormal = new JMenuItem("Normal");
		mntmNormal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				spiel.joker();
			}
		});
		mntmNormal.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_SPACE, InputEvent.CTRL_MASK));
		mnJoker.add(mntmNormal);
		
		JMenuItem mntmSuper = new JMenuItem("Super");
		mntmSuper.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				spiel.sJoker();
			}
		});
		mntmSuper.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_SPACE, InputEvent.CTRL_MASK | InputEvent.SHIFT_MASK));
		mnJoker.add(mntmSuper);
        
        
        
        this.w = w;
        this.h = h;
        inhalt.setPreferredSize(new Dimension(w, h));
        
        inhalt.addMouseListener(new MouseAdapter(){
                public void mousePressed(MouseEvent e){
                    spiel.mausklick(e.getX(), e.getY());
                }
            }
        );
             
        setContentPane(inhalt);
        pack();
        Dimension size = inhalt.getSize();
        bild = inhalt.createImage(size.width, size.height);
        stift = bild.getGraphics();
        setVisible(true);
        aktuell = this;
    }

    /**
     * Gibt Zeichentool aus
     * @return {@link #stift}
     */
    public static Graphics getStift(){
        return aktuell.stift;
    }
    
    //get width
    /**
     * Gibt Fensterbreite aus
     * @return {@link #w}
     */
    public int getW(){
    	return w;
    }
    
    //get hight
    /**
     * Gibt Fensterh�he aus
     * @return {@link #h}
     */ 
    public int getH(){
    	return h;
    }
    

}
