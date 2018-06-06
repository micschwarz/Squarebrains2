package de.ms.squarebrain.menu.components;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Reset implements MenuComponent
{

    private JButton btnReset;

    @Override
    public void registerComponent(JPanel panel)
    {
        btnReset = new JButton("Reset");
        btnReset.setToolTipText("Reset settings");
        panel.add(btnReset);
    }

    public JButton getBtnReset()
    {
        return btnReset;
    }
}
