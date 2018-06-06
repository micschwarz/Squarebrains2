package de.ms.squarebrain.menu.components;

import javax.swing.*;

public class User implements MenuComponent
{
    JTextField inUser;

    @Override
    public void registerComponent(JPanel panel)
    {
        registerComponent(panel, "Max Mustermann");
    }

    public void registerComponent(JPanel panel, String name)
    {
        inUser = new JTextField();
        inUser.setToolTipText("Playername");
        inUser.setText(name);
        panel.add(inUser);
    }

    public String getUserName()
    {
        return inUser.getText();
    }
}
