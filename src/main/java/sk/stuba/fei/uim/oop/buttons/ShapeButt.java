package sk.stuba.fei.uim.oop.buttons;

import sk.stuba.fei.uim.oop.frame.MainFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ShapeButt extends JButton implements ActionListener {
    JLabel text;
    boolean draw = true;
    MainFrame frame;
    public ShapeButt(MainFrame frame){
        this.frame=frame;
        this.setFocusable(false);
        this.setPreferredSize(new Dimension(100,200));
        this.setBackground(new Color(175, 185, 192));
        this.setLayout(new BorderLayout());
        this.add(text = new JLabel("Drawing",JLabel.CENTER),BorderLayout.CENTER);
        this.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==this){
            if (draw){
                text.setText("Moving");
                draw = false;
                frame.setDraw(false);
            }
            else {
                text.setText("Drawing");
                draw = true;
                frame.setDraw(true);
            }
        }
    }
}