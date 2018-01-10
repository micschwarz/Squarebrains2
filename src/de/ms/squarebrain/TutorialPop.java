package de.ms.squarebrain;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.awt.Font;

/**
* Spielerkl�rung (Dialog)
* @author 5pixels
*/
public class TutorialPop extends JDialog {

	private static final long serialVersionUID = -1922810575788718315L;
	private final JPanel contentPanel = new JPanel();


	public TutorialPop() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(TutorialPop.class.getResource("/com/pixels/squarebrain/main/tex/logoS.png")));
		setTitle("Squarebrain Help");
		
		//Set System L&F
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			} 
			catch (UnsupportedLookAndFeelException e) {
				e.printStackTrace();
			}
			catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			catch (InstantiationException e) {
				e.printStackTrace();
			}
			catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		
		
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setVisible(true);
		setBounds(100, 100, 460, 495);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 11, 424, 402);
		contentPanel.add(tabbedPane);
		
		JPanel tut01 = new JPanel();
		tabbedPane.addTab("Schritt 1", null, tut01, null);
		tut01.setLayout(null);
		
		JLabel lblTutpic = new JLabel("");
		lblTutpic.setIcon(new ImageIcon(TutorialPop.class.getResource("/com/pixels/squarebrain/main/tut/001.png")));
		lblTutpic.setBounds(10, 11, 400, 300);
		tut01.add(lblTutpic);
		
		JLabel lblTut01 = new JLabel("Klicke das erste Square an...");
		lblTut01.setBounds(20, 322, 390, 14);
		tut01.add(lblTut01);
		
		JPanel tut02 = new JPanel();
		tabbedPane.addTab("Schritt 2", null, tut02, null);
		tut02.setLayout(null);
		
		JLabel lblTutpic_1 = new JLabel("");
		lblTutpic_1.setIcon(new ImageIcon(TutorialPop.class.getResource("/com/pixels/squarebrain/main/tut/002.png")));
		lblTutpic_1.setBounds(10, 11, 400, 300);
		tut02.add(lblTutpic_1);
		
		JLabel lblTut02 = new JLabel("... und es wird markiert. Das zweite Square (2) erscheint");
		lblTut02.setBounds(20, 322, 390, 14);
		tut02.add(lblTut02);
		
		JPanel tut03 = new JPanel();
		tabbedPane.addTab("Schritt 3", null, tut03, null);
		tut03.setLayout(null);
		
		JLabel lblTutpic_2 = new JLabel("");
		lblTutpic_2.setIcon(new ImageIcon(TutorialPop.class.getResource("/com/pixels/squarebrain/main/tut/003.png")));
		lblTutpic_2.setBounds(10, 11, 400, 300);
		tut03.add(lblTutpic_2);
		
		JLabel lblTut03_1 = new JLabel("Wenn das erste Square nun nocheinmal geklickt wird, erscheint ein drittes!");
		lblTut03_1.setBounds(10, 322, 400, 14);
		tut03.add(lblTut03_1);
		
		JLabel lblTut03_2 = new JLabel("Da das erste nun verschwunden ist geht es mit dem zweiten weiter!");
		lblTut03_2.setBounds(10, 347, 399, 14);
		tut03.add(lblTut03_2);
		
		JPanel tut04 = new JPanel();
		tabbedPane.addTab("Joker", null, tut04, null);
		tut04.setLayout(null);
		
		JLabel lblKlickeImSpiel = new JLabel("Klicke im Spiel oben auf Hilfe -> Joker um einen Joker zu aktivieren!");
		lblKlickeImSpiel.setBounds(10, 11, 321, 14);
		tut04.add(lblKlickeImSpiel);
		
		JLabel lblJoker = new JLabel("Joker");
		lblJoker.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblJoker.setBounds(10, 36, 46, 20);
		tut04.add(lblJoker);
		
		JLabel lblDerNormaleJoker = new JLabel("Der normale Joker zeigt das n\u00E4chste Quadrat an");
		lblDerNormaleJoker.setBounds(10, 61, 242, 14);
		tut04.add(lblDerNormaleJoker);
		
		JLabel lblTutpicj1 = new JLabel("");
		lblTutpicj1.setIcon(new ImageIcon(TutorialPop.class.getResource("/com/pixels/squarebrain/main/sqr/sqrfail.png")));
		lblTutpicj1.setBounds(10, 86, 20, 20);
		tut04.add(lblTutpicj1);
		
		JLabel lblSuperJoker = new JLabel("Super Joker");
		lblSuperJoker.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSuperJoker.setBounds(10, 152, 93, 20);
		tut04.add(lblSuperJoker);
		
		JLabel lblDerSuperJoker = new JLabel("Der Super Joker zeigt die n\u00E4chsten Beide Quadrate an");
		lblDerSuperJoker.setBounds(10, 183, 399, 14);
		tut04.add(lblDerSuperJoker);
		
		JLabel lblTutpicj2 = new JLabel("");
		lblTutpicj2.setIcon(new ImageIcon(TutorialPop.class.getResource("/com/pixels/squarebrain/main/sqr/sqrfail.png")));
		lblTutpicj2.setBounds(10, 208, 20, 20);
		tut04.add(lblTutpicj2);
		
		JLabel lblTutpicj3 = new JLabel("");
		lblTutpicj3.setIcon(new ImageIcon(TutorialPop.class.getResource("/com/pixels/squarebrain/main/sqr/sqrnxt.png")));
		lblTutpicj3.setBounds(36, 208, 20, 20);
		tut04.add(lblTutpicj3);
		
		JLabel lblDerEinsatzKostet = new JLabel("Der Einsatz kostet 2 Punkte (Shortcut: Strg + Leertaste)");
		lblDerEinsatzKostet.setBounds(10, 117, 321, 14);
		tut04.add(lblDerEinsatzKostet);
		
		JLabel lblDerEinsatzKostet_1 = new JLabel("Der Einsatz kostet 4 Punkte (Shortcut: Strg + Shift + Leertaste)");
		lblDerEinsatzKostet_1.setBounds(10, 239, 399, 14);
		tut04.add(lblDerEinsatzKostet_1);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						dispose();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
	}
}
