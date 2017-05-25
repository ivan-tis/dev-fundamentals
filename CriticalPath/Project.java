
/**
 * Write a description of class Project here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.Date;
import java.util.Vector;
import java.util.Collection;
public class Project
{
    private String name;
    private Date date;
    private Collection<Task> tasks;
    
    public Project(){
        tasks = new Vector<Task>();
    }
    public Project(String name)
    {
        tasks = new Vector<Task>();
        this.name = name;
    }
    
    public String getName(){
    return name;
    }
    
    public void addTask(Task task){
        if(!tasks.contains(task)){
              tasks.add(task);
        }
    }
    public int calculateTimeToDelivery(){
        int maxTimeToComplete = 0;
       for(Task task: tasks){  
              int time = task.calculateTimeToComplete();
                if(time > maxTimeToComplete){
                maxTimeToComplete = time;
                }
    
        }
        return maxTimeToComplete;
    }
    
    public int countTasks(){
     return tasks.size();
    }
}
