package sk.stuba.fei.uim.oop.buttons;

import sk.stuba.fei.uim.oop.frame.MainFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ColorButt extends JButton implements ActionListener {
    JLabel text;
    int color = 0;
    MainFrame frame;
    public ColorButt(MainFrame frame){
        this.frame=frame;
        this.setFocusable(false);
        this.setPreferredSize(new Dimension(100,200));
        this.setBackground(new Color(89, 86, 255));
        this.setLayout(new BorderLayout());
        this.add(text = new JLabel("Blue",JLabel.CENTER),BorderLayout.CENTER);
        this.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==this){
            System.out.println(color);
            if (color==0){
                text.setText("Red");
                color++;
                frame.setColor(new Color(227, 0, 0));
                this.setBackground(new Color(255, 89, 89));
            }
            else if (color==1){
                text.setText("Green");
                color++;
                frame.setColor(new Color(110, 227, 0));
                this.setBackground(new Color(138, 255, 110));
            }
            else {
                text.setText("Blue");
                color=0;
                frame.setColor(new Color(0, 64, 227));
                this.setBackground(new Color(89, 86, 255, 255));
            }

        }
    }
}