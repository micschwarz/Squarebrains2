package de.ms.squarebrain;

import de.ms.squarebrain.menu.components.*;

import java.awt.*;
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

    public static Menu frame;

    // Settings
    private Resolution resolution;
    private GameMode gameMode;
    private Difficulty difficulty;
    private User user;

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
        setBounds(100, 100, 300, 600);
        setJMenuBar(getWindowBar());

        JPanel contentPane = new JPanel();

        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setBorder(BorderFactory.createEmptyBorder(20,40,20,40));
        contentPane.setLayout(new GridLayout(0,1 ,0,2));

        initGameSection(contentPane);
        initSettingsSection(contentPane);
        initUserSection(contentPane);

        (new TextCreator()).registerComponent(contentPane);
    }

    private void initGameSection(JPanel contentPane)
    {
        // Add Title
        (new Title()).registerComponent(contentPane);
        // Add Playbutton
        ButtonPlay button = new ButtonPlay();
        button.registerComponent(contentPane);
        button.getBtnPlay().addActionListener(e -> {
            new Game(resolution.getWidth(), resolution.getHeight(), user.getUserName(), Integer.toString(gameMode.getGameModeId()), Integer.toString(difficulty.getDifficultyId()), 20);
            frame.setVisible(false);
        });
        // Add Exitbutton
        ButtonExit btnExit = new ButtonExit();
        btnExit.registerComponent(contentPane);
        btnExit.getBtnExit().addActionListener(e -> {
            writeSettings();
            frame.dispose();
        });
    }

    private void initSettingsSection(JPanel contentPane)
    {
        // SETTINGS
        // Add Settings Header
        (new Heading()).registerComponent(contentPane, "Settings");
        // Add Resolution
        resolution = new Resolution();
        resolution.registerComponent(contentPane);
        // Add Gamemode
        gameMode = new GameMode();
        gameMode.registerComponent(contentPane);
        // Add Difficulty
        difficulty = new Difficulty();
        difficulty.registerComponent(contentPane);
        // Add Reset
        Reset reset = new Reset();
        reset.registerComponent(contentPane);
        reset.getBtnReset().addActionListener(arg0 -> new ResetSettingsPop(frame));
    }

    private void initUserSection(JPanel contentPane)
    {
        // USER
        // Add User Header
        (new Heading()).registerComponent(contentPane,"User");
        //Add User Name
        user = new User();
        user.registerComponent(contentPane);
        // Add Highscore button
        ButtonHighscore btnScore = new ButtonHighscore();
        btnScore.registerComponent(contentPane);
        btnScore.getBtnHighscore().addActionListener(e -> new HighscorePop(Integer.toString(gameMode.getGameModeId())));
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
    private void writeSettings()
    {
        /*String userpath = System.getProperty("user.home");
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
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }*/

    }

    /**
     * Resets settings
     *
     * @see #writeSettings()
     */
    void resetSettings()
    {
        user.reset();
        difficulty.reset();
        gameMode.reset();
        resolution.reset();
        writeSettings();
    }
}
