
/**
 * Write a description of class Project here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.Date;
import java.util.Vector;

public class Project
{
    private String name;
    private Date date;
    private Vector tasks;
    
    public Project(){
        tasks = new Vector();
    }
    public Project(String name)
    {
        tasks = new Vector();
        this.name = name;
    }
    
    public String getName(){
    return name;
    }
    
    public void addTask(Task task){
        tasks.add(task);
    }
    public int calculateTimeToDelivery(){
        int maxTimeToComplete = 0;
        for(Object element: tasks){
          Task task = (Task) element;
          if(task.getTimeToComplete()>maxTimeToComplete){
              maxTimeToComplete = task.getTimeToComplete();
          }
        }
        return maxTimeToComplete;
    }
}
