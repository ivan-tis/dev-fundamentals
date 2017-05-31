import java.util.Set;
import java.util.List;
import java.util.Vector;
import java.util.HashSet;

/**
 * Write a description of class Project here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Project
{
    private String name;
    private Set<Task> tasks; 
    
    public Project() {
        tasks = new HashSet<Task>();
    }
    
    public Project(String name) {
        this.name = name;
        tasks = new HashSet<Task>();
    }
    
    public String getName() {
        return name;
    }
    
    public void addTask(Task task) {
        //if (!tasks.contains(task)) {
            tasks.add(task);
        //}
    }
    
    public int calculateTimeToDelivery() {
        int maxTimeToComplete = 0;
        for (Task task: tasks) {
            int time = task.calculateTimeToComplete();
            if (time > maxTimeToComplete) {
                maxTimeToComplete = time;
            }
        }
        return maxTimeToComplete;
    }
    
    public int countTasks() {
        return tasks.size();
    }
    
    public List<Task> calculateCriticalPath() {
        List<Task> path = new Vector<Task>();
        int maxTimeProject = calculateTimeToDelivery();
        Task finalNode = null;
        for(Task task: tasks){
            if(maxTimeProject ==task.calculateTimeToComplete()){
                finalNode =task;
            }
        }
        path.add(finalNode);
        return getCriticalPath(finalNode, path);
    }
    
    public List<Task> getCriticalPath(Task finalNode, List<Task> path){
        int maxTimeNode = finalNode.calculateTimeToComplete() - finalNode.getTimeToComplete();
        if(finalNode.getPreRequisites().size()==0 && path.size() ==1){
            return path;
        }
        for(Task task:finalNode.getPreRequisites()){
            if(maxTimeNode == task.calculateTimeToComplete()){
                path.add(task);
                getCriticalPath(task, path);
            }
            else{
                if(maxTimeNode ==0){
                    path.add(task);
                }
            }
        }
        
        return path;
    }
    

}
