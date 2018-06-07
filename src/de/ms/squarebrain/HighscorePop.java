package de.ms.squarebrain;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import java.awt.Font;
import java.awt.Toolkit;

/**
* Highscoreanzeige (Dialog)
* @author 5pixels
*/
public class HighscorePop extends JDialog {


	private static final long serialVersionUID = 4800264454482986616L;
	private final JPanel contentPanel = new JPanel();			//Content
	private Highscore score;									//score
	private Score[] scorelist;									//Scorelist


	public HighscorePop(String mode) {
		
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
		
		score = new Highscore(mode);
		scorelist = score.getScores();		
		
		
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setVisible(true);
		setTitle("Highscores - " + mode);
		setIconImage(Toolkit.getDefaultToolkit().getImage(HighscorePop.class.getResource("/de/ms/squarebrain/tex/logoS.png")));
		setBounds(100, 100, 300, 492);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblHighscores = new JLabel("Highscores - " + mode);
			lblHighscores.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblHighscores.setHorizontalAlignment(SwingConstants.CENTER);
			lblHighscores.setBounds(10, 11, 264, 25);
			contentPanel.add(lblHighscores);
		}
		{
			JLabel lblName = new JLabel(scorelist[9].getName());
			lblName.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblName.setBounds(10, 47, 125, 25);
			contentPanel.add(lblName);
		}
		{
			JLabel lblName_1 = new JLabel(scorelist[8].getName());
			lblName_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblName_1.setBounds(10, 86, 125, 25);
			contentPanel.add(lblName_1);
		}
		{
			JLabel lblName_2 = new JLabel(scorelist[7].getName());
			lblName_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblName_2.setBounds(10, 122, 125, 25);
			contentPanel.add(lblName_2);
		}
		{
			JLabel lblName_3 = new JLabel(scorelist[6].getName());
			lblName_3.setBounds(10, 158, 125, 25);
			contentPanel.add(lblName_3);
		}
		{
			JLabel lblName_4 = new JLabel(scorelist[5].getName());
			lblName_4.setBounds(10, 194, 125, 25);
			contentPanel.add(lblName_4);
		}
		{
			JLabel lblName_5 = new JLabel(scorelist[4].getName());
			lblName_5.setBounds(10, 230, 125, 25);
			contentPanel.add(lblName_5);
		}
		{
			JLabel lblName_6 = new JLabel(scorelist[3].getName());
			lblName_6.setBounds(10, 266, 125, 25);
			contentPanel.add(lblName_6);
		}
		{
			JLabel lblName_7 = new JLabel(scorelist[2].getName());
			lblName_7.setBounds(10, 302, 125, 25);
			contentPanel.add(lblName_7);
		}
		{
			JLabel lblName_8 = new JLabel(scorelist[1].getName());
			lblName_8.setBounds(10, 338, 125, 25);
			contentPanel.add(lblName_8);
		}
		{
			JLabel lblName_9 = new JLabel(scorelist[0].getName());
			lblName_9.setBounds(10, 374, 125, 25);
			contentPanel.add(lblName_9);
		}
		{
			JLabel lblScore = new JLabel(scorelist[9].getScore());
			lblScore.setHorizontalAlignment(SwingConstants.TRAILING);
			lblScore.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblScore.setBounds(145, 47, 125, 25);
			contentPanel.add(lblScore);
		}
		{
			JLabel lblScore_1 = new JLabel(scorelist[8].getScore());
			lblScore_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblScore_1.setHorizontalAlignment(SwingConstants.TRAILING);
			lblScore_1.setBounds(145, 86, 125, 25);
			contentPanel.add(lblScore_1);
		}
		{
			JLabel lblScore_2 = new JLabel(scorelist[7].getScore());
			lblScore_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblScore_2.setHorizontalAlignment(SwingConstants.TRAILING);
			lblScore_2.setBounds(145, 122, 125, 25);
			contentPanel.add(lblScore_2);
		}
		{
			JLabel lblScore_3 = new JLabel(scorelist[6].getScore());
			lblScore_3.setHorizontalAlignment(SwingConstants.TRAILING);
			lblScore_3.setBounds(145, 158, 125, 25);
			contentPanel.add(lblScore_3);
		}
		{
			JLabel lblScore_4 = new JLabel(scorelist[5].getScore());
			lblScore_4.setHorizontalAlignment(SwingConstants.TRAILING);
			lblScore_4.setBounds(145, 194, 125, 25);
			contentPanel.add(lblScore_4);
		}
		{
			JLabel lblScore_5 = new JLabel(scorelist[4].getScore());
			lblScore_5.setHorizontalAlignment(SwingConstants.TRAILING);
			lblScore_5.setBounds(145, 230, 125, 25);
			contentPanel.add(lblScore_5);
		}
		{
			JLabel lblScore_6 = new JLabel(scorelist[3].getScore());
			lblScore_6.setHorizontalAlignment(SwingConstants.TRAILING);
			lblScore_6.setBounds(145, 266, 125, 25);
			contentPanel.add(lblScore_6);
		}
		{
			JLabel lblScore_7 = new JLabel(scorelist[2].getScore());
			lblScore_7.setHorizontalAlignment(SwingConstants.TRAILING);
			lblScore_7.setBounds(145, 302, 125, 25);
			contentPanel.add(lblScore_7);
		}
		{
			JLabel lblScore_8 = new JLabel(scorelist[1].getScore());
			lblScore_8.setHorizontalAlignment(SwingConstants.TRAILING);
			lblScore_8.setBounds(145, 338, 125, 25);
			contentPanel.add(lblScore_8);
		}
		{
			JLabel lblScore_9 = new JLabel(scorelist[0].getScore());
			lblScore_9.setHorizontalAlignment(SwingConstants.TRAILING);
			lblScore_9.setBounds(145, 374, 125, 25);
			contentPanel.add(lblScore_9);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Close");
				okButton.setToolTipText("Close");
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
