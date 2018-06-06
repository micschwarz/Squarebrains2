package de.ms.squarebrain.menu.components;

import de.ms.squarebrain.menu.components.base.Text;

import javax.swing.*;
import java.awt.*;

public class Resolution implements MenuComponent, Resetable
{
    private JTextField fieldW;
    private JTextField fieldH;

    private int defaultW = 600;
    private int defaultH = 400;

    @Override
    public void registerComponent(JPanel panel)
    {
        registerComponent(panel, defaultW, defaultH);
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

    public void setWidth(int value)
    {
        fieldW.setText(Integer.toString(value));
    }

    public void setHeight(int value)
    {
        fieldH.setText(Integer.toString(value));
    }

    @Override
    public void reset()
    {
        setWidth(defaultW);
        setHeight(defaultH);
    }
}
