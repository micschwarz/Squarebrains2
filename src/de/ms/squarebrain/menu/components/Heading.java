package de.ms.squarebrain.menu.components;

import javax.swing.*;
import java.awt.*;

public class Heading implements MenuComponent
{
    @Override
    public void registerComponent(JPanel panel)
    {
       registerComponent(panel, "");
    }

    public void registerComponent(JPanel panel, String text) {
        JLabel lblSettings = new JLabel(text);
        lblSettings.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblSettings.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(lblSettings);
    }
}
