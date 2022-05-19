package sk.stuba.fei.uim.oop.frame;

import sk.stuba.fei.uim.oop.buttons.ColorButt;
import sk.stuba.fei.uim.oop.buttons.DrawButt;
import sk.stuba.fei.uim.oop.buttons.ShapeButt;

import javax.swing.*;
import java.awt.*;


public class MainFrame extends JFrame {
    JPanel settingsPanel;
    DrawBoard drawBoard;
    Color color =Color.blue;
    boolean draw;
    public MainFrame(){
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(800,600);
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());
        this.draw = true;

        this.add(settingsPanel = new JPanel(),BorderLayout.EAST);
        settingsPanel.setBackground(new Color(97, 98, 97));
        settingsPanel.setPreferredSize(new Dimension(100,50));
        settingsPanel.setLayout(new GridLayout(3,1));
        settingsPanel.add(new DrawButt(this));
        settingsPanel.add(new ShapeButt(this));
        settingsPanel.add(new ColorButt(this));
        this.add(drawBoard = new DrawBoard(this));
        this.pack();

        this.setVisible(true);
    }
    public void setColor(Color color){
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public void clearArea(){
        this.remove(drawBoard);
        this.add(drawBoard = new DrawBoard(this));
        this.repaint();
        revalidate();
    }

    public boolean isDraw() {
        return draw;
    }

    public void setDraw(boolean draw) {
        this.draw = draw;
    }
}
