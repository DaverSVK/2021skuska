package sk.stuba.fei.uim.oop.frame;

import sk.stuba.fei.uim.oop.adapter.Adapter;
import sk.stuba.fei.uim.oop.graphic.Graphic;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class DrawBoard extends Adapter {
    Color color =Color.blue;
    MainFrame frame;
    ArrayList<Graphic> shape;
    int x;
    int y;
    int x0;
    int y0;
    int offsetX;
    int offsetY;
    int sizeX = 0;
    int sizeY = 0;
    boolean move;
    public DrawBoard(MainFrame frame) {
        this.frame=frame;
        this.color=frame.getColor();
        this.shape=new ArrayList<>();
        this.setPreferredSize(new Dimension(600,600));
        setBackground(new Color(245, 245, 245));
        this.addMouseMotionListener(this);
        this.addMouseListener(this);
        this.x=0;
        this.y=0;

    }
    public void setColor(Color color){
        this.color=color;
    }

    @Override
    protected void paintComponent(Graphics g) {

            super.paintComponent(g);

            for (Graphic s : shape) {
                s.paint(g);
            }
            if (frame.isDraw()||move){
                g.setColor(color);
                g.fillOval(x0, y0, sizeX, sizeY);
            }



    }

    @Override
    public void mousePressed(MouseEvent e) {
        super.mousePressed(e);

        this.offsetX=e.getX();
        this.offsetY=e.getY();
        if (frame.isDraw()){
            this.color=frame.getColor();
            this.x=e.getX();
            this.y=e.getY();
            this.sizeX=10;
            this.sizeY=10;
        }
        if(!frame.isDraw()){
            for (var s: shape){
                s.onMouseMove(e.getX(),e.getY());
                if(s.isHovering()){
                    this.sizeX=s.getSizeX();
                    this.sizeY=s.getSizeY();
                    this.x=s.getX();
                    this.y=s.getY();
                    this.color=s.getColor();
                    shape.remove(s);
                    move = true;
                    break;
                }
            }

        }
        this.x0=x;
        this.y0=y;
        repaint();
        revalidate();
    }


    @Override
    public void mouseReleased(MouseEvent e) {
        super.mouseReleased(e);

        Graphics t=getGraphics();
        if (frame.isDraw()||move){
            shape.add(new Graphic(x0,y0,sizeX,sizeY,Color.blue));
        }
        move = false;
        repaint();
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        super.mouseDragged(e);
        repaint();
        revalidate();
        this.x0=x;
        this.y0=y;
        if (!frame.isDraw()&&move) {
            this.x0=x+e.getX()-offsetX;
            this.y0=y+e.getY()-offsetY;
            System.out.println(y0);
            System.out.println(x0);
        }
        if (frame.isDraw()){
            this.sizeX=0;
            this.sizeY=0;

            if ((e.getX() - x + 10)>0 && (e.getY()-y+10)>0) {
                this.sizeX = e.getX() - x + 10;
                this.sizeY = e.getY() - y + 10;
            }
            if ((e.getX() - x + 10)<0 && (e.getY()-y+10)>0) {
                this.sizeX = Math.abs(e.getX() - x + 10);
                this.x0 = x + (e.getX()-x) + 10;
                this.sizeY = e.getY() - y + 10;
            }
            if ((e.getX() - x + 10)>0 && (e.getY()-y+10)<0) {
                this.sizeY = Math.abs(e.getY() - y + 10);
                this.y0 = y + (e.getY()-y) + 10;
                this.sizeX = e.getX() - x + 10;
            }
            if ((e.getX() - x + 10)<0 && (e.getY()-y+10)<0) {
                this.sizeX = Math.abs(e.getX() - x + 10);
                this.sizeY = Math.abs(e.getY() - y + 10);
                this.y0 = y + (e.getY()-y) + 10;
                this.x0 = x + (e.getX()-x) + 10;

            }
        }

    }
}
