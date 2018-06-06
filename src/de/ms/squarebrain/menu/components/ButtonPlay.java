package de.ms.squarebrain.menu.components;

import de.ms.squarebrain.Game;
import de.ms.squarebrain.Menu;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonPlay implements MenuComponent
{
    private JButton btnPlay;

    @Override
    public void registerComponent(JPanel panel)
    {
        btnPlay = new JButton("Play");
        btnPlay.setToolTipText("Play game with your settings");
        panel.add(btnPlay);
    }

    public JButton getBtnPlay()
    {
        return btnPlay;
    }
}
