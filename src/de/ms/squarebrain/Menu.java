package de.ms.squarebrain;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class Menu extends JFrame {

    private JSpinner squaresize;
    private JTextField textw;
    private JTextField texth;
    public static Menu frame;
    private JTextField txtName;
    private JComboBox boxDifficulty;
    private JComboBox boxGamemode;

    //Settings
    private static int difficulty = 1;
    private static int gamemode = 0;
    private static String w = "600";
    private static String h = "400";
    private static String name = "Max Mustermann";
    private static int size = 20;

    public static void main(String[] args)
    {
        // Set System L&F
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Create Menu
        EventQueue.invokeLater(() -> {
            try {
                frame = new Menu();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }


    /**
     * Erstellt das Menu
     */
    private Menu()
    {
        setTitle("Squarebrain - Menu");
        setIconImage(Toolkit.getDefaultToolkit().getImage(Menu.class.getResource("/de/ms/squarebrain/tex/logoS.png")));
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 300, 530);
        setJMenuBar(getWindowBar());

        JPanel contentPane = new JPanel();

        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setBorder(BorderFactory.createEmptyBorder(20,40,20,40));
        contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.PAGE_AXIS));

        JLabel lblSqarebrain = new JLabel("SquareBrain");
        lblSqarebrain.setForeground(Color.BLACK);
        lblSqarebrain.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblSqarebrain.setHorizontalAlignment(SwingConstants.CENTER);
        lblSqarebrain.setBounds(109, 29, 120, 50);
        contentPane.add(lblSqarebrain);

        JButton btnPlay = new JButton("Play");
        btnPlay.setToolTipText("Play game with your settings");
        btnPlay.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                size = (int) squaresize.getValue();
                new Game(Integer.parseInt(textw.getText()), Integer.parseInt(texth.getText()), txtName.getText(), (String) boxGamemode.getSelectedItem(), (String) boxDifficulty.getSelectedItem(), size);
                frame.setVisible(false);
            }
        });
        btnPlay.setBounds(100, 90, 100, 23);
        contentPane.add(btnPlay);

        boxGamemode = new JComboBox();
        boxGamemode.setToolTipText("Gamemode");
        boxGamemode.setModel(new DefaultComboBoxModel(new String[]{"Classic", "Arcade"}));
        boxGamemode.setSelectedIndex(gamemode);
        boxGamemode.setBounds(100, 220, 100, 20);
        contentPane.add(boxGamemode);

        JButton btnHighscore = new JButton("Highscore");
        btnHighscore.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                new HighscorePop((String) boxGamemode.getSelectedItem());
            }
        });
        btnHighscore.setToolTipText("Highscorelist");
        btnHighscore.setBounds(100, 403, 100, 23);
        contentPane.add(btnHighscore);

        textw = new JTextField();
        textw.setToolTipText("Game width");
        textw.setText(w);
        textw.setBounds(100, 189, 40, 20);
        contentPane.add(textw);
        textw.setColumns(10);

        texth = new JTextField();
        texth.setToolTipText("Game height");
        texth.setText(h);
        texth.setBounds(160, 189, 40, 20);
        contentPane.add(texth);
        texth.setColumns(10);

        JLabel lblX = new JLabel("x");
        lblX.setHorizontalAlignment(SwingConstants.CENTER);
        lblX.setBounds(145, 189, 10, 20);
        contentPane.add(lblX);

        JButton btnExit = new JButton("Exit");
        btnExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                writeSettings();
                frame.dispose();
            }
        });
        btnExit.setBounds(100, 124, 100, 23);
        contentPane.add(btnExit);

        txtName = new JTextField();
        txtName.setToolTipText("Playername");
        txtName.setText(name);
        txtName.setBounds(100, 372, 100, 20);
        contentPane.add(txtName);
        txtName.setColumns(10);

        boxDifficulty = new JComboBox();
        boxDifficulty.setModel(new DefaultComboBoxModel(new String[]{"Easy", "Normal", "Hard"}));
        boxDifficulty.setSelectedIndex(difficulty);
        boxDifficulty.setToolTipText("Degree of difficulty");
        boxDifficulty.setBounds(100, 251, 100, 20);
        contentPane.add(boxDifficulty);

        JLabel lblUser = new JLabel("User");
        lblUser.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblUser.setHorizontalAlignment(SwingConstants.CENTER);
        lblUser.setBounds(100, 344, 100, 20);
        contentPane.add(lblUser);

        JLabel lblSettings = new JLabel("Settings");
        lblSettings.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblSettings.setHorizontalAlignment(SwingConstants.CENTER);
        lblSettings.setBounds(100, 158, 100, 20);
        contentPane.add(lblSettings);

        JLabel lblBypixels = new JLabel("by 5pixels");
        lblBypixels.setHorizontalAlignment(SwingConstants.CENTER);
        lblBypixels.setFont(new Font("Tahoma", Font.PLAIN, 9));
        lblBypixels.setBounds(100, 437, 100, 14);
        contentPane.add(lblBypixels);


        JButton btnReset = new JButton("reset");
        btnReset.setToolTipText("More settings");
        btnReset.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0)
            {
                new ResetSettingsPop(frame);
            }
        });
        btnReset.setBounds(100, 314, 100, 23);
        contentPane.add(btnReset);

        JLabel logo = new JLabel("");
        logo.setHorizontalAlignment(SwingConstants.CENTER);
        logo.setIcon(new ImageIcon(Menu.class.getResource("/de/ms/squarebrain/tex/logoM.png")));
        logo.setBounds(60, 25, 50, 50);
        contentPane.add(logo);

        squaresize = new JSpinner();
        squaresize.setModel(new SpinnerNumberModel(size, 20, 40, 1));
        squaresize.setBounds(160, 283, 40, 20);
        contentPane.add(squaresize);

        JLabel lblSquaresize = new JLabel("Size");
        lblSquaresize.setToolTipText("Squaresize");
        lblSquaresize.setBounds(100, 282, 55, 21);
        contentPane.add(lblSquaresize);

        JLabel lblBg = new JLabel("");
        lblBg.setIcon(new ImageIcon(Menu.class.getResource("/de/ms/squarebrain/tex/BG_menu.png")));
        lblBg.setBounds(0, 0, 294, 480);
        contentPane.add(lblBg);
    }


    /**
     * Get Window Bar for Main menu
     *
     * @return JMenuBar Menubar for window
     */
    private JMenuBar getWindowBar()
    {
        JMenuBar menuBar = new JMenuBar();

        JMenu mnHelp = new JMenu("Help");
        menuBar.add(mnHelp);

        JMenuItem mntmOpenHelp = new JMenuItem("Open Help");
        mntmOpenHelp.addActionListener(arg0 -> new TutorialPop());
        mntmOpenHelp.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H, InputEvent.ALT_MASK));
        mnHelp.add(mntmOpenHelp);

        return menuBar;
    }

    //set window visible

    /**
     * Setzt das Fenster sichtbar
     */
    public void sichtbar()
    {
        frame.setVisible(true);
    }

    //Write settings

    /**
     * Schreibt Einstellungen in eine Datei
     */
    public void writeSettings()
    {
        String userpath = System.getProperty("user.home");
        Path settingspath = Paths.get(userpath, ".squarebrain", "config.txt");
        File config = new File(settingspath.toString());
        config.getParentFile().mkdirs();
        try {
            PrintWriter writer = new PrintWriter(config);
            writer.println(textw.getText());
            writer.println(texth.getText());
            writer.println(txtName.getText());
            writer.println(boxDifficulty.getSelectedIndex());
            writer.println(boxGamemode.getSelectedIndex());
            writer.println(squaresize.getValue());
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    //setter

    /**
     * Setzt Einstellungen zur�ck und speichert sie
     *
     * @see #writeSettings()
     */
    public void resetSettings()
    {
        boxDifficulty.setSelectedIndex(1);
        difficulty = 1;
        boxGamemode.setSelectedIndex(0);
        gamemode = 0;
        textw.setText("600");
        w = "600";
        texth.setText("400");
        h = "400";
        squaresize.setValue(20);
        size = 20;
        writeSettings();
    }
}
