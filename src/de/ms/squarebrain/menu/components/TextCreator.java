package de.ms.squarebrain.menu.components;

import javax.swing.*;
import java.awt.*;

public class TextCreator implements MenuComponent
{
    @Override
    public void registerComponent(JPanel panel)
    {
        JLabel lblCreator = new JLabel("by micschwarz");
        lblCreator.setHorizontalAlignment(SwingConstants.CENTER);
        lblCreator.setFont(new Font("Tahoma", Font.PLAIN, 9));
        panel.add(lblCreator);
    }
}
