
import java.awt.Color;
import java.awt.Graphics;
/**
 * Write a description of class Circle here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Circle extends AbstractShape
{


    
    public Circle(int radius, Color color) {
        this.radius = radius;
        this.color = color;
    }
    public int getRadius(){
       return radius;
    }
    public Circle(int x, int y) {
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
        g.fillOval(x - radius , y - radius, radius * 2, radius * 2);
    }
    


}
