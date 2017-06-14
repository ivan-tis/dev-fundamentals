import java.awt.Color;
import java.awt.Graphics;
/**
 * Abstract class Shape - write a description of the class here
 *
 * @author (your name here)
 * @version (version number or date here)
 */
public abstract class AbstractShape
{
    protected int x;
    protected int y;
    protected Color color;
    protected boolean changeAspect;
    protected int radius;
    
    protected Color getNextColor() {
    int red = (int) (255 * Math.random());
    int green = (int) (255 * Math.random());
    int blue = (int) (255 * Math.random());
    
    return new Color(red, green, blue);
    }

    
    protected void clickAt(int x, int y) {
        changeAspect = contains(x, y);
         if (changeAspect) {
            color = getNextColor();
            changeAspect = false;
            radius = (int)(200 * Math.random());
        }
    }
    
    protected boolean contains(int x, int y) {
    int xCenter = this.x;
    int yCenter = this.y;
    double d = Math.hypot(yCenter - y, xCenter - x);
    return d <= radius;
    }
    
    
    public abstract void draw(Graphics g);
}
