package sk.stuba.fei.uim.oop.buttons;

import sk.stuba.fei.uim.oop.frame.MainFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DrawButt extends JButton implements ActionListener {
    MainFrame frame;
    public DrawButt(MainFrame frame){
        this.frame=frame;
        this.setPreferredSize(new Dimension(100,200));
        this.setBackground(new Color(175, 185, 192));
        this.setLayout(new BorderLayout());
        this.add(new JLabel("Clear",JLabel.CENTER),BorderLayout.CENTER);

        this.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==this){
            frame.clearArea();
        }
    }
}