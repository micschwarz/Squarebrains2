package de.ms.squarebrain.menu.components;

import de.ms.squarebrain.menu.components.base.Text;

import javax.swing.*;
import java.awt.*;

public class GameMode implements MenuComponent, Resetable
{
    private JComboBox<String> boxGameMode;
    private String[] gameModes = {"Classic", "Arcade"};
    private int defaultValue = 0;

    @Override
    public void registerComponent(JPanel panel)
    {
        registerComponent(panel, defaultValue);
    }

    public void registerComponent(JPanel panel, int gameMode)
    {
        JPanel gameModePanel = new JPanel(new BorderLayout());
        JLabel label = (new Text()).getComponent("Gamemode");

        JPanel labelPanel = new JPanel(new FlowLayout());
        labelPanel.add(label);

        gameModePanel.add(labelPanel, BorderLayout.WEST);

        boxGameMode = new JComboBox<>();
        boxGameMode.setToolTipText("Gamemode");
        boxGameMode.setModel(new DefaultComboBoxModel<>(gameModes));
        boxGameMode.setSelectedIndex(gameMode);
        gameModePanel.add(boxGameMode, BorderLayout.CENTER);

        panel.add(gameModePanel);
    }

    public int getGameModeId()
    {
        return boxGameMode.getSelectedIndex();
    }

    public String getGameModeName()
    {
        return gameModes[getGameModeId()];
    }

    public void setGameModeById(int value)
    {
        boxGameMode.setSelectedIndex(value);
    }

    @Override
    public void reset()
    {
        setGameModeById(defaultValue);
    }
}
