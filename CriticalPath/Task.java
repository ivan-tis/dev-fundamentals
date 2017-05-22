
/**
 * Write a description of class Task here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Task
{
    private String description;
    private String name;
    private String owner;
    private int timeToComplete;
    public Task()
    {
        this.description = "";
        this.name = "";
        this.owner = "";
        this.timeToComplete = 0;
    }
    
    public Task(String name, int timeToComplete)
    {
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
   
}
