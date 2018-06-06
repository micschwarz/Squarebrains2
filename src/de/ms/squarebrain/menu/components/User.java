package de.ms.squarebrain.menu.components;

import javax.swing.*;

public class User implements MenuComponent, Resetable
{
    JTextField inUser;
    String defaultValue = "Max Mustermann";

    @Override
    public void registerComponent(JPanel panel)
    {
        registerComponent(panel, defaultValue);
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

    public void setUserName(String value)
    {
        inUser.setText(value);
    }

    @Override
    public void reset()
    {
        setUserName(defaultValue);
    }
}
