import java.awt.Color;
/**
 * Write a description of class Circle here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Circle
{
  private int x;
  private int y;
  private int radio;
  private Color color;

  public Circle(int radio){
      color = Color.yellow;
      this.radio = radio;
    }
  public void setColor(Color color){
      this.color = color;
  }
  public void setX(int x){
      this.x = x;
  }
  public void setY(int y){
      this.y = y;
  }
  
  public Color getColor(){
    return color;
  }
  
  public int getX(){
      return x;
  }
  public int getY(){
      return y;
  } 
  public boolean isInTheCicle(int xPoint, int yPoint){
      boolean isInTheCicle;
      if (Math.sqrt(Math.pow(this.x-xPoint,2) + Math.pow(this.y - yPoint,2)) <= radio){
            isInTheCicle = true; 
        }else{
            isInTheCicle = false; 
        } 
      return isInTheCicle;
  }
}
