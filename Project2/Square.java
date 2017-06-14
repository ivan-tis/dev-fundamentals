import java.awt.Color;
import java.awt.Graphics;
/**
 * Write a description of class Sqare here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Square extends AbstractShape
{

    private int side;
    public Square(int side, Color color) {
        this.side = side;
        this.color = color;
    }
    public int getSide(){
       return side;
    }
    
    public Square(int x, int y) {
        this.x = x;
        this.y = y;
        color = getNextColor();
        side = 25;
    }
    
    public  void changeAspect(){
        side = (int)(200 * Math.random());
    };
    
    @Override
    public void drawShape(Graphics g){
      g.fillRect(x , y - side, side * 2, side * 2);
    }
   
    public boolean contains(int x, int y) {
    int xCenter = this.x;
    int yCenter = this.y;
    double d = Math.hypot(yCenter - y, xCenter - x);
    return d <= side;
    }
}
