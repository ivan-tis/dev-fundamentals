
/**
 * Write a description of class Project here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.Date;
import java.util.Set;
import java.util.HashSet;
import java.util.Collection;
import java.util.List;
import java.util.Vector;
public class Project
{
    private String name;
    private Set<Task> tasks;
    
    public Project(){
        tasks = new HashSet<Task>();
    }
    public Project(String name)
    {
        tasks = new HashSet<Task>();
        this.name = name;
    }
    
    public String getName(){
    return name;
    }
    
    public void addTask(Task task){
       // if(!tasks.contains(task)){
              tasks.add(task);
       // }
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
    
    public List<Task> calculateCriticalPath(){ 
        List<Task> path = new Vector<Task>();
        
        return  path;
    }
}
