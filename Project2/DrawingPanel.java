import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;



/**
 * Write a description of class DrawingPanel here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class DrawingPanel extends JPanel
{
     private Random rand = new Random();
     private Circle circle = new Circle(25);

         
    public DrawingPanel(){
      setBackground(Color.GRAY);
      addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent event){
               System.out.println(event.getPoint()); 
               if (circle.isInTheCicle(event.getX(), event.getY())) {
                   circle.setColor(getRandomColor());
                }
               repaint();
            }
        });
    }
    
    @Override
    public void paint(Graphics g){
        super.paint(g);
        g.setColor(circle.getColor());
        circle.setX(getWidth()/2);
        circle.setY(getHeight()/2);
        g.fillOval(circle.getX() - (50/2),circle.getY() - (50/2),50,50);
    }
    
    private Color getRandomColor() {
        return new Color(rand.nextFloat(), rand.nextFloat(),
        rand.nextFloat());
    }
}
