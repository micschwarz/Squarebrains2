package de.ms.squarebrain.menu.components;

import javax.swing.*;

public class ButtonHighscore implements MenuComponent
{
    private JButton btnHighscore;

    @Override
    public void registerComponent(JPanel panel)
    {
        btnHighscore = new JButton("Highscore");
        btnHighscore.setToolTipText("Have a look at the Highscores");
        panel.add(btnHighscore);
    }

    public JButton getBtnHighscore()
    {
        return btnHighscore;
    }
}
