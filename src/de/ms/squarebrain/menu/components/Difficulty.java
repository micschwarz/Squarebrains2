package de.ms.squarebrain.menu.components;

import de.ms.squarebrain.menu.components.base.Text;

import javax.swing.*;
import java.awt.*;

public class Difficulty implements MenuComponent, Resetable
{
    private JComboBox<String> boxDifficulty;
    private String[] difficulties = {"Easy", "Normal", "Hard"};
    private int defaultValue = 1;

    @Override
    public void registerComponent(JPanel panel)
    {
        registerComponent(panel, defaultValue);
    }

    public void registerComponent(JPanel panel, int difficulty)
    {
        JPanel difficultyPanel = new JPanel(new BorderLayout());
        JLabel label = (new Text()).getComponent("Difficulty");

        JPanel labelPanel = new JPanel(new FlowLayout());
        labelPanel.add(label);

        difficultyPanel.add(labelPanel, BorderLayout.WEST);

        boxDifficulty = new JComboBox<>();
        boxDifficulty.setModel(new DefaultComboBoxModel<>(difficulties));
        boxDifficulty.setSelectedIndex(difficulty);
        boxDifficulty.setToolTipText("Degree of difficulty");
        difficultyPanel.add(boxDifficulty, BorderLayout.CENTER);

        panel.add(difficultyPanel);
    }

    public int getDifficultyId()
    {
        return boxDifficulty.getSelectedIndex();
    }

    public String getDifficultyName()
    {
        return difficulties[getDifficultyId()];
    }

    public void setDifficultyById(int value)
    {
        boxDifficulty.setSelectedIndex(value);
    }

    @Override
    public void reset()
    {
        setDifficultyById(defaultValue);
    }
}
