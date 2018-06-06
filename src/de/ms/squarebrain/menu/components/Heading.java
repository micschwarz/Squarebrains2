package de.ms.squarebrain.menu.components;

import javax.swing.*;
import java.awt.*;

public class Heading implements MenuComponent
{
    @Override
    public void registerComponent(JPanel panel)
    {
        JPanel headingPanel = new JPanel(new GridBagLayout());
        headingPanel.setMinimumSize(new Dimension(400,400));

        JLabel logo = new JLabel(new ImageIcon(Heading.class.getResource("/de/ms/squarebrain/tex/logoS.png")));
        logo.setHorizontalAlignment(SwingConstants.CENTER);
        headingPanel.add(logo);

        JLabel text = new JLabel("SquareBrain");
        text.setForeground(Color.BLACK);
        text.setFont(new Font("Tahoma", Font.PLAIN, 20));
        text.setHorizontalAlignment(SwingConstants.CENTER);
        headingPanel.add(text);

        panel.add(headingPanel);
    }
}
