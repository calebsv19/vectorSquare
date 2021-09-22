import java.awt.*;

public class Handler {
    private int width;
    private int height;
    private Points[][] squares;

    public static final int SIZE = 80, TOTAL_LENGTH = 800, LENGTH = TOTAL_LENGTH / SIZE;

    public static final double C_CHANGE = 1.048;

    public Handler(int width, int height){
        squares = new Points[SIZE][SIZE];
        this.width = width;
        this.height = height;

        for (int i = 0; i < SIZE; i++){
            for(int j = 0; j < SIZE; j++){
                squares[j][i] = new Points(i, j,300 + TOTAL_LENGTH / SIZE * i,100 + TOTAL_LENGTH / SIZE * j);
            }
        }
    }

    public void tick(int width, int height){
        for (int i = 0; i < SIZE; i++){
            for(int j = 0; j < SIZE; j++){
                squares[j][i].setLocation(squares[j][i].getX() + squares[j][i].getChange().getX(),
                                          squares[j][i].getY() + squares[j][i].getChange().getY());
            }
        }
    }

    public void render(Graphics g, int width, int height){
        g.setColor(Color.WHITE);
        g.fillRect(0,0, width, height);
        for (int i = 0; i < SIZE; i++){
            for(int j = 0; j < SIZE; j++){
                g.setColor(new Color((int) (202 - Math.pow(C_CHANGE, i) - Math.pow(C_CHANGE, j)), (int) (240 - Math.pow(C_CHANGE, i) - Math.pow(C_CHANGE, j)), (int) (212 - Math.pow(C_CHANGE, i) - Math.pow(C_CHANGE, j))));
                g.fillRect((int) squares[j][i].getX(), (int) squares[j][i].getY(), LENGTH, LENGTH);
                g.setColor(Color.BLACK);
                g.drawRect((int) squares[j][i].getX(), (int) squares[j][i].getY(), LENGTH, LENGTH);
            }
        }
    }
}
