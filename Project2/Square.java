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
    private int radius;
    private int x;
    private int y;
    private Color color;
    private boolean changeAspect;
    private int side;
    public Square(int radius, Color color) {
        this.radius = radius;
        this.color = color;
    }
    public int getRadius(){
       return radius;
    }
    public Square(int x, int y) {
        this.x = x;
        this.y = y;
        color = getNextColor();
        radius = 25;
    }
    
    public void draw(Graphics g, int x, int y) {
        this.draw(g);
        this.x = x;
        this.y = y;
    }
    
    public void draw(Graphics g) {
        g.setColor(color);
        g.fillRect(x , y - radius, radius * 2, radius * 2);
    }
    

    public boolean contains(int x, int y) {
        int xCenter = this.x;
        int yCenter = this.y;
        double d = Math.hypot(yCenter - y, xCenter - x);
        return d <= radius;
    }
    
       public void clickAt(int x, int y) {
        changeAspect = contains(x, y);
         if (changeAspect) {
            color = getNextColor();
            changeAspect = false;
            radius = (int)(200 * Math.random());
        }
    }
}
