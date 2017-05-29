
/**
 * Write a description of class Task here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.Vector;
public class Task
{
    private String description;
    private String name;
    private String owner;
    private int timeToComplete;
    private Vector<Task> preRequisite; 
    
    public Task()
    {
        preRequisite = new Vector<Task>();
        this.description = "";
        this.name = "";
        this.owner = "";
        this.timeToComplete = 0;
    }
    
    public Task(String name, int timeToComplete)
    {
        preRequisite = new Vector<Task>();
        this.name = name;
        this.timeToComplete = timeToComplete;
    }
    
    public String getDescription(){
        return description;
    }
    
    public void setDescription(String description){
       this.description = description;
    }
    
    
    public String getName(){
        return name;
    }
    
    public void setName(String name){
       this.name = name;
    }
    
    public String getOwner(){
        return owner;
    }
    
    public void setOwner(String owner){
       this.owner = owner;
    }
    
        public int getTimeToComplete(){
        return timeToComplete;
    }
    
    public void setTimeToComplete(int timeToComplete){
       this.timeToComplete = timeToComplete;
    }
    
    public void dependsOn(Task otherTask){
        preRequisite.add(otherTask);
    }
    
    public int calculateTimeToComplete(){
        int maxPreRequisiteTime = 0;
          for(Task task: preRequisite){
            if( task.calculateTimeToComplete() > maxPreRequisiteTime){
            maxPreRequisiteTime = task.calculateTimeToComplete();
            }  
         }
         return getTimeToComplete() + maxPreRequisiteTime;
    }
    
    @Override
    public boolean equals(Object otherObject){
        Task otherTask = (Task) otherObject;
        return this.name.equals(otherTask.name) &&
        timeToComplete == otherTask.timeToComplete;
    }
    
    @Override
    public int hashCode(){
        return name.hashCode() + 53 * timeToComplete;
    }
    
    @Override
    public String toString(){
        return String.format("<n:%s , t:%s>", name, timeToComplete);
    }
   
}
       