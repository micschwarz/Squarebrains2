package de.ms.squarebrain.menu.components;

import de.ms.squarebrain.menu.components.base.Text;

import javax.swing.*;
import java.awt.*;

public class Resolution implements MenuComponent
{
    private JTextField fieldW;
    private JTextField fieldH;

    @Override
    public void registerComponent(JPanel panel)
    {
        registerComponent(panel, 600, 400);
    }

    public void registerComponent(JPanel panel, int valueWidth, int valueHeight)
    {

        JPanel mainPanel = new JPanel(new BorderLayout());
        JLabel label = (new Text()).getComponent("Resolution");

        JPanel labelPanel = new JPanel(new FlowLayout());
        labelPanel.add(label);

        mainPanel.add(labelPanel, BorderLayout.WEST);

        JPanel resolutionPanel = new JPanel(new FlowLayout());

        // Resolution W
        fieldW = new JTextField();
        fieldW.setToolTipText("Game width");
        fieldW.setText(Integer.toString(valueWidth));
        fieldW.setColumns(4);
        resolutionPanel.add(fieldW);

        // x-Label
        JLabel lblX = new JLabel("x");
        lblX.setHorizontalAlignment(SwingConstants.CENTER);
        resolutionPanel.add(lblX);

        // Resolution H
        fieldH = new JTextField();
        fieldH.setToolTipText("Game height");
        fieldH.setText(Integer.toString(valueHeight));
        fieldH.setColumns(4);
        resolutionPanel.add(fieldH);

        mainPanel.add(resolutionPanel, BorderLayout.CENTER);

        panel.add(mainPanel);
    }

    public int getWidth()
    {
        return Integer.parseInt(fieldW.getText());
    }

    public int getHeight()
    {
        return Integer.parseInt(fieldH.getText());
    }
}
