package sk.stuba.fei.uim.oop.frame;

import javax.swing.*;
import java.awt.*;


public class MainFrame extends JFrame {
    JPanel SettingsPanel;
    public MainFrame(){
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(800,600);
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());
        this.add(SettingsPanel = new JPanel(),BorderLayout.EAST);
        SettingsPanel.setBackground(new Color(97, 98, 97));
        SettingsPanel.setPreferredSize(new Dimension(100,50));

        this.setVisible(true);
    }
}
