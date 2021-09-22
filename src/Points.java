import java.awt.*;
import java.util.*;

public class Points extends Point{
    private Point change;
    private Random r;

    public Points(int i, int j, int x, int y){
        super(x,y);
        r = new Random();
        change = new Point(r.nextInt(5) - 4 + i / 20,r.nextInt(5) - 4 + j / 20);
    }

    public Point getChange(){
        return change;
    }
}
