
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Collection;
import java.util.Vector;

import java.util.Collections;
import java.util.List;
import java.util.Comparator;
/**
 * Write a description of class DrawingPanel here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DrawingPanel extends JPanel
{
    //private Circle circle;
    private List<Circle> circles;
    private List<Circle> circles2;
    public DrawingPanel() {
        
        //circle = new Circle(25, Color.yellow);
        circles = new Vector<Circle>();
        circles2 = new Vector<Circle>();
        setBackground(Color.GRAY);
        
        addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent event) {
                Collections.sort(circles); 
                if (!clickIsInsideAnyCircle(event)) {
                    addNewCircle(event);
                }    
           
                repaint();
            }
        });
    }
    
    private boolean clickIsInsideAnyCircle(MouseEvent event) {
        boolean isInsideAnyCircle = false;
        for (Circle circle: circles) {
            circle.clickAt(event.getX(), event.getY());
            if (circle.isInsideCircle(event.getX(), event.getY())) {
                isInsideAnyCircle = true;
            }            
        }
        return isInsideAnyCircle;
    }
    
    private void addNewCircle(MouseEvent event) {
        circles.add(new Circle(event.getX(), event.getY()));
    }
    
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        for (Circle circle: circles2) {
            System.out.println(circle.getRadius());
            circle.draw(g);
            
        }
        for (Circle circle: circles) {
            System.out.println(circle.getRadius());
            circle.draw(g);
            
        }
        //circles.clear();
    }
}
