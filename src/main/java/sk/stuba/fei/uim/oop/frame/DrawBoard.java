package sk.stuba.fei.uim.oop.frame;

import sk.stuba.fei.uim.oop.adapter.Adapter;

import java.awt.*;
import java.awt.event.MouseEvent;

public class DrawBoard extends Adapter {
    Color color;
    public DrawBoard() {
        this.setPreferredSize(new Dimension(600,600));
        setBackground(new Color(245, 245, 245));
        this.addMouseMotionListener(this);
    }
    public void setColor(Color color){
        this.color=color;
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        super.mouseDragged(e);
        Graphics g=getGraphics();
        g.setColor(color);
        g.fillOval(e.getX(),e.getY(),20,20);
    }
}
