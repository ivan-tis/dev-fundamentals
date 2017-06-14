
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

    private int radius;
    
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
    
    @Override
    public void drawShape(Graphics g){
        g.fillOval(x - radius , y - radius, radius * 2, radius * 2);
    }


    protected void clickAt(int x, int y) {
        changeAspect = contains(x, y);
         if (changeAspect) {
            color = getNextColor();
            changeAspect = false;
            radius = (int)(200 * Math.random());
        }
    }
    public  void changeAspect(){
        radius = (int)(200 * Math.random());
    };
              
    public boolean contains(int x, int y) {
    int xCenter = this.x;
    int yCenter = this.y;
    double d = Math.hypot(yCenter - y, xCenter - x);
    return d <= radius;
    }
    


}
