package de.ms.squarebrain.menu.components;

import javax.swing.*;

public class ButtonExit implements MenuComponent
{
    private JButton btnExit;

    @Override
    public void registerComponent(JPanel panel)
    {
        btnExit = new JButton("Exit");
        btnExit.setToolTipText("Save and Exit game");
        panel.add(btnExit);
    }

    public JButton getBtnExit()
    {
        return btnExit;
    }
}
