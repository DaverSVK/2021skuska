package sk.stuba.fei.uim.oop.frame;

import sk.stuba.fei.uim.oop.adapter.Adapter;
import sk.stuba.fei.uim.oop.graphic.Graphic;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class DrawBoard extends Adapter {
    private MainFrame frame;
    private ArrayList<Graphic> shape;
    private ArrayList<Bod> bod;

    private int x;
    private int y;
    private int x0;
    private int y0;
    private int x1;
    private int y1;
    private int spacing = 20;

    public DrawBoard(MainFrame frame) {
        this.frame=frame;
        this.shape=new ArrayList<>();
        this.setPreferredSize(new Dimension(600,600));
        setBackground(new Color(245, 245, 245));
        this.addMouseMotionListener(this);
        this.addMouseListener(this);
        this.bod=new ArrayList<>();
        this.setFocusable(true);
        this.requestFocus();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Graphic s : shape) {
            s.paint(g);
        }
        }


    @Override
    public void mouseEntered(MouseEvent e) {
        super.mouseEntered(e);
        this.x0=e.getX();
        this.y0=e.getY();

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        super.mouseMoved(e);
        int distance = (int) Math.sqrt(Math.pow((x0-e.getX()),2)+Math.pow((y0-e.getY()),2));
        //System.out.println(distance);
        if (distance>=50){
//            bod.add(new Bod(e.getX(),e.getY()));
            //System.out.println(e.getX()+" : "+e.getY());
            bod.add(new Bod(e.getX(),e.getY()));
            shape.add(new Graphic(x0,y0,e.getX(),e.getY()));
            this.x0=e.getX();
            this.y0=e.getY();
            if(shape.size()>10){
                shape.remove(0);
                bod.remove(0);
                System.out.println(shape.size());
            }
        }

        repaint();
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        super.mouseDragged(e);
        int distance = (int) Math.sqrt(Math.pow((x0-e.getX()),2)+Math.pow((y0-e.getY()),2));
        //System.out.println(distance);
        if (distance>=50){
            bod.add(new Bod(e.getX(),e.getY()));
            //System.out.println(e.getX()+" : "+e.getY());
            shape.add(new Graphic(x0,y0,e.getX(),e.getY()));
            this.x0=e.getX();
            this.y0=e.getY();
            if(shape.size()>10){
                shape.remove(0);
                bod.remove(0);
                System.out.println(shape.size());
            }
        }
        repaint();
    }
}
//package sk.stuba.fei.uim.oop.frame;
//
//        import sk.stuba.fei.uim.oop.adapter.Adapter;
//        import sk.stuba.fei.uim.oop.graphic.Graphic;
//
//        import java.awt.*;
//        import java.awt.event.MouseEvent;
//        import java.util.ArrayList;
//
//public class DrawBoard extends Adapter {
//    Color color;
//    MainFrame frame;
//    ArrayList<Graphic> shape;
//    int x;
//    int y;
//    int x0;
//    int y0;
//    int offsetX;
//    int offsetY;
//    int sizeX = 0;
//    int sizeY = 0;
//    boolean move;
//    public DrawBoard(MainFrame frame) {
//        this.frame=frame;
//        this.color=frame.getColor();
//        this.shape=new ArrayList<>();
//        this.setPreferredSize(new Dimension(600,600));
//        setBackground(new Color(245, 245, 245));
//        this.addMouseMotionListener(this);
//        this.addMouseListener(this);
//        this.x=0;
//        this.y=0;
//
//    }
//
//    @Override
//    protected void paintComponent(Graphics g) {
//
//        super.paintComponent(g);
//
//        for (Graphic s : shape) {
//            s.paint(g);
//        }
//        if (frame.isDraw()||move){
//            g.setColor(color);
//            g.fillOval(x0, y0, sizeX, (int)((0.666)*(double) sizeY));
//            g.fillRect(x0+ sizeX/3, y0-5+(int)((0.666)*(double) sizeY), sizeX/3, sizeY/3);
//        }
//    }
//
//    @Override
//    public void mousePressed(MouseEvent e) {
//        super.mousePressed(e);
//
//        this.offsetX=e.getX();
//        this.offsetY=e.getY();
//        if (frame.isDraw()){
//            this.color=frame.getColor();
//            this.x=e.getX();
//            this.y=e.getY();
//            this.sizeX=10;
//            this.sizeY=10;
//        }
//        if(!frame.isDraw()){
//            for (var s: shape){
//                s.onMouseMove(e.getX(),e.getY());
//                if(s.isHovering()){
//                    this.sizeX=s.getSizeX();
//                    this.sizeY=s.getSizeY();
//                    this.x=s.getX();
//                    this.y=s.getY();
//                    this.color=s.getColor();
//                    shape.remove(s);
//                    move = true;
//                    break;
//                }
//            }
//
//        }
//        this.x0=x;
//        this.y0=y;
//        repaint();
//        revalidate();
//    }
//
//
//    @Override
//    public void mouseReleased(MouseEvent e) {
//        super.mouseReleased(e);
//        if (frame.isDraw()||move){
//            shape.add(new Graphic(x0,y0,sizeX,sizeY,color));
//        }
//        move = false;
//        repaint();
//    }
//
//    @Override
//    public void mouseDragged(MouseEvent e) {
//        super.mouseDragged(e);
//        repaint();
//        revalidate();
//        this.x0=x;
//        this.y0=y;
//        if (!frame.isDraw()&&move) {
//            this.x0=x+e.getX()-offsetX;
//            this.y0=y+e.getY()-offsetY;
//            System.out.println(y0);
//            System.out.println(x0);
//        }
//        if (frame.isDraw()){
//            this.sizeX=0;
//            this.sizeY=0;
//
//            if ((e.getX() - x + 10)>0 && (e.getY()-y+10)>0) {
//                this.sizeX = e.getX() - x + 10;
//                this.sizeY = e.getY() - y + 10;
//            }
//            if ((e.getX() - x + 10)<0 && (e.getY()-y+10)>0) {
//                this.sizeX = Math.abs(e.getX() - x + 10);
//                this.x0 = x + (e.getX()-x) + 10;
//                this.sizeY = e.getY() - y + 10;
//            }
//            if ((e.getX() - x + 10)>0 && (e.getY()-y+10)<0) {
//                this.sizeY = Math.abs(e.getY() - y + 10);
//                this.y0 = y + (e.getY()-y) + 10;
//                this.sizeX = e.getX() - x + 10;
//            }
//            if ((e.getX() - x + 10)<0 && (e.getY()-y+10)<0) {
//                this.sizeX = Math.abs(e.getX() - x + 10);
//                this.sizeY = Math.abs(e.getY() - y + 10);
//                this.y0 = y + (e.getY()-y) + 10;
//                this.x0 = x + (e.getX()-x) + 10;
//
//            }
//        }
//
//    }
//}