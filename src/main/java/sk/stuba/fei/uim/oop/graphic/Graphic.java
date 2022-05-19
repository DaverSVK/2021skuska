package sk.stuba.fei.uim.oop.graphic;

import lombok.Getter;
import lombok.Setter;
import sk.stuba.fei.uim.oop.adapter.Adapter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.Serializable;
@Getter
@Setter
public class Graphic{
    int x;
    int y;
    int sizeX;
    int sizeY;
    Color color;
    boolean hovering=false;
    public Graphic(int x, int y, int sizeX, int sizeY, Color color) {
        this.x=x;
        this.y=y;
        this.sizeX=sizeX;
        this.sizeY=sizeY;
        this.color=color;
    }
    public void paint(Graphics g){
        g.setColor(color);
        g.fillOval(x, y, sizeX, (int)((0.666)*(double) sizeY));
        g.fillRect(x+ sizeX/3, y-5+(int)((0.666)*(double) sizeY), sizeX/3, sizeY/3);

    }

    public void onMouseMove(int x, int y){
        if((x > this.x && x < this.x + this.sizeX)&&(y > this.y && y<this.y + this.sizeY)){
            hovering = true;
        }
        else{
            hovering = false;
        }
    }

}
