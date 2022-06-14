package sk.stuba.fei.uim.oop.graphic;

import lombok.Getter;
import lombok.Setter;
import java.awt.*;

@Getter
@Setter
public class Graphic{
    int x;
    int y;
    int sizeX;
    int sizeY;
    Color color;
    boolean hovering=false;
    public Graphic(int x, int y, int sizeX, int sizeY) {
        this.x=x;
        this.y=y;
        this.sizeX=sizeX;
        this.sizeY=sizeY;
    }
    public void paint(Graphics g){
        g.drawLine(x, y, sizeX, sizeY);

    }

}
