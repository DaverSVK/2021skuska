package sk.stuba.fei.uim.oop.frame;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Bod {
    private int x0;
    private int y0;


    public Bod(int x0, int y0)  {
        this.x0=x0;
        this.y0=y0;

    }
}
