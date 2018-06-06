package de.ms.squarebrain.menu.components.base;

import de.ms.squarebrain.menu.components.MenuComponent;

import javax.swing.*;
import java.awt.*;

public class Text implements MenuComponent
{
    @Override
    public void registerComponent(JPanel panel)
    {
        registerComponent(panel, "");
    }

    public void registerComponent(JPanel panel, String text)
    {
        panel.add(getComponent(text));
    }

    public JLabel getComponent(String text)
    {
        JLabel lblSettings = new JLabel(text);
        lblSettings.setFont(new Font("Tahoma", Font.PLAIN, 11));
        lblSettings.setHorizontalAlignment(SwingConstants.CENTER);
        return lblSettings;
    }
}
